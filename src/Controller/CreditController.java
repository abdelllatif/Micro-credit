package Controller;

import Models.Credit;
import Models.Echeance;
import Models.Employe;
import Models.Professionnel;
import Repository.CreditRepository;
import Service.CreditService;
import Service.EcheanceService;
import Service.EmployeService;
import Service.ProfessionnelService;
import Utils.VerifierClient;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CreditController {

    private final CreditService creditServ;
    private final EcheanceService echeanceServ;
    private final VerifierClient verifier;
    private final CreditRepository creditRepo;

    public CreditController() {
        this.creditServ = new CreditService();
        this.verifier = new VerifierClient();
        this.echeanceServ = new EcheanceService();
        this.creditRepo = new CreditRepository();
    }

    public void addCredit() {
        Scanner sc = new Scanner(System.in);
        ProfessionnelService pp = new ProfessionnelService();
        EmployeService ep = new EmployeService();

        try {
            System.out.print("ID Client: ");
            int clientId = sc.nextInt();

            System.out.print("Est employé ? (true si employe / false si professionnel): ");
            boolean estEmploye = sc.nextBoolean();
            sc.nextLine();

            double salaire = 0.0;
            double revenu = 0.0;
            int anneesExperience = 0;
            int score = 0;

            if (estEmploye) {
                Optional<Employe> emOpt = ep.getEmployeById(clientId);
                if (!emOpt.isPresent()) {
                    System.out.println("Employe not found");
                    return;
                }
                Employe em = emOpt.get();
                salaire = em.getSalaire();
                anneesExperience = em.getAnciennete();
                score = em.getScore();
                System.out.println("Employé trouvé: Salaire = " + salaire + " | Expérience = " + anneesExperience);

            } else {
                Optional<Professionnel> prOpt = pp.getProfessionnelById(clientId);
                if (!prOpt.isPresent()) {
                    System.out.println("Professionnel not found");
                    return;
                }
                Professionnel pr = prOpt.get();
                revenu = pr.getRevenu();
                score = pr.getScore();
                System.out.println("Professionnel trouvé: Revenu = " + revenu);
            }

            System.out.print("Montant demandé: ");
            BigDecimal montantDemande = sc.nextBigDecimal();

            System.out.print("Durée en mois: ");
            int dureeEnMois = sc.nextInt();

            List<Credit> credits;
            if (estEmploye) {
                credits = creditServ.getCreditsByEmployee(clientId);
            } else {
                credits = creditServ.getCreditsByProfessional(clientId);
            }

            List<Echeance> toutesEcheances = new ArrayList<>();
            for (Credit c : credits) {
                toutesEcheances.addAll(echeanceServ.getEcheancesByCreditId(c.getId()).values());
            }

            Credit.DecisionType decision = verifier.verifierCredit(
                    clientId, estEmploye, credits, toutesEcheances,
                    estEmploye ? salaire : revenu,
                    score,
                    anneesExperience
            );

            Credit credit = new Credit();
            if (estEmploye) credit.setEmployeId(clientId);
            else credit.setProfessionnelId(clientId);

            credit.setMontantDemande(montantDemande);
            credit.setMontantOctroye(
                    decision == Credit.DecisionType.ACCORDIMMEDIAT ? montantDemande : BigDecimal.ZERO
            );
            credit.setTauxInteret(5.0);
            credit.setDureeEnMois(dureeEnMois);
            credit.setTypeCredit(Credit.CreditType.CONSOMMATION);
            credit.setDecision(decision);

            ResultSet rs = creditRepo.addCredit(credit);
            if (rs.next()) {
                int id = rs.getInt(1);
                credit.setId(id);
                System.out.println("Credit ajouté avec ID = " + id + " | Décision = " + decision);

                if (decision == Credit.DecisionType.ACCORDIMMEDIAT) {
                    echeanceServ.generateEcheancesForCredit(credit);
                }

            } else {
                System.out.println(" Erreur lors de l'ajout du crédit");
            }

        } catch (SQLException e) {
            System.out.println("Erreur SQL: " + e.getMessage());
        }
    }
}

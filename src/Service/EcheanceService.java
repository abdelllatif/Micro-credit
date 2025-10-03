package Service;

import Models.Credit;
import Models.Echeance;
import Repository.EcheanceRepository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.HashMap;

public class EcheanceService {

    private final EcheanceRepository repo;

    public EcheanceService() {
        this.repo = new EcheanceRepository();
    }

    public void generateEcheancesForCredit(Credit credit) {
        try {
            int duree = credit.getDureeEnMois();
            BigDecimal montant = credit.getMontantOctroye();

            if (montant.compareTo(BigDecimal.ZERO) <= 0) {
                System.out.println("⚠ Aucun montant octroyé, pas d'échéances à générer.");
                return;
            }

            double tauxMensuel = credit.getTauxInteret() / 100.0 / 12.0;

            double mensualite = montant.doubleValue() * tauxMensuel /
                    (1 - Math.pow(1 + tauxMensuel, -duree));

            LocalDate startDate = credit.getDateDeCredit().plusMonths(1);

            for (int i = 0; i < duree; i++) {
                LocalDate dateEcheance = startDate.plusMonths(i);

                repo.addEcheance(
                        dateEcheance.toString(),
                        (int) Math.round(mensualite),
                        null,
                        credit.getId(),
                        "IMPAYENONREGLE"
                );
            }

            System.out.println("" + duree + " échéances générées pour le crédit " + credit.getId());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public HashMap<Integer, Echeance> getEcheancesByCreditId(int creditId) {
        HashMap<Integer, Echeance> map = new HashMap<>();
        try {
            ResultSet rs = repo.findByCreditId(creditId);
            while (rs.next()) {
                Echeance e = new Echeance();
                e.setId(rs.getInt("id"));
                e.setDateEcheance(rs.getDate("dateEcheance").toLocalDate());
                e.setMensualite(rs.getBigDecimal("montant"));
                e.setCreditId(rs.getInt("credit_id"));
                e.setStatutPaiement(Echeance.PaymentStatus.valueOf(rs.getString("statut")));

                map.put(e.getId(), e);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return map;
    }
}

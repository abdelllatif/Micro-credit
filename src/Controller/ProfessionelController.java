package Controller;

import Models.Professionnel;
import Service.ProfessionnelService;
import Utils.ScoreUtilsNewClient;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ProfessionelController {

    private final ProfessionnelService service;
    private final Scanner scanner = new Scanner(System.in);

    public ProfessionelController() {
        this.service = new ProfessionnelService();
    }

    public void listAllProfessionels() {
        try {
            List<Professionnel> list = service.getAllProfessionnels();
            list.forEach(p -> {
                System.out.println("=== Professionnel " + p.getId() + " ===");
                System.out.println("Nom: " + p.getNom());
                System.out.println("Prenom: " + p.getPrenom());
                System.out.println("Email: " + p.getEmail());
                System.out.println("Date Naissance: " + p.getDateNaissance());
                System.out.println("Ville: " + p.getVille());
                System.out.println("Adresse: " + p.getAdresse());
                System.out.println("Telephone: " + p.getTelephone());
                System.out.println("Nombre Enfants: " + p.getNombreEnfants());
                System.out.println("Investissement: " + p.getInvestissement());
                System.out.println("Placement: " + p.getPlacement());
                System.out.println("Situation Familiale: " + p.getSituationFamiliale());
                System.out.println("Score: " + p.getScore());
                System.out.println("Date Creation: " + p.getDateCreation());
                System.out.println("Revenu: " + p.getRevenu());
                System.out.println("Immatriculation Fiscale: " + p.getImmatriculationFiscale());
                System.out.println("Secteur Activite: " + p.getSecteurActivite());
                System.out.println("Activite: " + p.getActivite());
            });
        } catch (SQLException e) {
            System.out.println("Error fetching professionels: " + e.getMessage());
        }
    }

    public void getProfessionelById() {
        System.out.print("Enter Professionnel ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            Optional<Professionnel> opt = service.getProfessionnelById(id);
            if (opt.isPresent()) {
                Professionnel p = opt.get();
                System.out.println("=== Professionnel Details ===");
                System.out.println("ID: " + p.getId());
                System.out.println("Nom: " + p.getNom());
                System.out.println("Prenom: " + p.getPrenom());
                System.out.println("Email: " + p.getEmail());
                System.out.println("Date Naissance: " + p.getDateNaissance());
                System.out.println("Ville: " + p.getVille());
                System.out.println("Adresse: " + p.getAdresse());
                System.out.println("Telephone: " + p.getTelephone());
                System.out.println("Nombre Enfants: " + p.getNombreEnfants());
                System.out.println("Investissement: " + p.getInvestissement());
                System.out.println("Placement: " + p.getPlacement());
                System.out.println("Situation Familiale: " + p.getSituationFamiliale());
                System.out.println("Score: " + p.getScore());
                System.out.println("Date Creation: " + p.getDateCreation());
                System.out.println("Revenu: " + p.getRevenu());
                System.out.println("Immatriculation Fiscale: " + p.getImmatriculationFiscale());
                System.out.println("Secteur Activite: " + p.getSecteurActivite());
                System.out.println("Activite: " + p.getActivite());
                System.out.println("======================");
            } else {
                System.out.println("Professionnel not found");
            }
        } catch (SQLException ex) {
            System.out.println("Error fetching professionel: " + ex.getMessage());
        }
    }

    public void addProfessionel() {
        try {
            Professionnel p = new Professionnel();

            scanner.nextLine();
            System.out.print("Nom: ");
            p.setNom(scanner.nextLine());

            System.out.print("Prenom: ");
            p.setPrenom(scanner.nextLine());

            System.out.print("Email: ");
            p.setEmail(scanner.nextLine());

            System.out.print("Date Naissance (yyyy-MM-dd): ");
            String dateStr = scanner.nextLine();
            p.setDateNaissance(LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd")));

            System.out.print("Ville: ");
            p.setVille(scanner.nextLine());

            System.out.print("Adresse: ");
            p.setAdresse(scanner.nextLine());

            System.out.print("Telephone: ");
            p.setTelephone(scanner.nextLine());

            System.out.print("Nombre Enfants: ");
            p.setNombreEnfants(scanner.nextInt());
            scanner.nextLine();

            System.out.print("Investissement (true/false): ");
            p.setInvestissement(scanner.nextBoolean());

            System.out.print("Placement (true/false): ");
            p.setPlacement(scanner.nextBoolean());
            scanner.nextLine();

            System.out.print("Situation Familiale: ");
            p.setSituationFamiliale(scanner.nextLine());


            p.setDateCreation(LocalDateTime.now());

            System.out.print("Revenu: ");
            p.setRevenu(scanner.nextFloat());
            scanner.nextLine();

            System.out.print("Immatriculation Fiscale: ");
            p.setImmatriculationFiscale(scanner.nextLine());

            System.out.print("Secteur Activite: ");
            p.setSecteurActivite(scanner.nextLine());

            System.out.print("Activite: ");
            p.setActivite(scanner.nextLine());
            System.out.print("Score: ");
            ScoreUtilsNewClient.calculerScore(p);

            Professionnel saved = service.addProfessionnel(p);
            System.out.println("Professionnel added with ID: " + saved.getId());
        } catch (Exception ex) {
            System.out.println("Error adding professionel: " + ex.getMessage());
        }
    }

    public void updateProfessionel() {
        try {
            System.out.print("Enter Professionnel ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Optional<Professionnel> opt = service.getProfessionnelById(id);
            if (!opt.isPresent()) {
                System.out.println("Professionnel not found with ID: " + id);
                return;
            }

            Professionnel p = opt.get();

            System.out.print("Nom (" + p.getNom() + "): ");
            String nom = scanner.nextLine();
            if (!nom.isEmpty()) p.setNom(nom);

            System.out.print("Prenom (" + p.getPrenom() + "): ");
            String prenom = scanner.nextLine();
            if (!prenom.isEmpty()) p.setPrenom(prenom);

            System.out.print("Email (" + p.getEmail() + "): ");
            String email = scanner.nextLine();
            if (!email.isEmpty()) p.setEmail(email);

            System.out.print("Date Naissance (" + p.getDateNaissance() + "): ");
            String dateStr = scanner.nextLine();
            if (!dateStr.isEmpty()) {
                p.setDateNaissance(LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            }

            System.out.print("Ville (" + p.getVille() + "): ");
            String ville = scanner.nextLine();
            if (!ville.isEmpty()) p.setVille(ville);

            System.out.print("Adresse (" + p.getAdresse() + "): ");
            String adresse = scanner.nextLine();
            if (!adresse.isEmpty()) p.setAdresse(adresse);

            System.out.print("Telephone (" + p.getTelephone() + "): ");
            String telephone = scanner.nextLine();
            if (!telephone.isEmpty()) p.setTelephone(telephone);

            System.out.print("Nombre Enfants (" + p.getNombreEnfants() + "): ");
            String nbEnf = scanner.nextLine();
            if (!nbEnf.isEmpty()) p.setNombreEnfants(Integer.parseInt(nbEnf));

            System.out.print("Investissement (" + p.getInvestissement() + "): ");
            String invest = scanner.nextLine();
            if (!invest.isEmpty()) p.setInvestissement(Boolean.parseBoolean(invest));

            System.out.print("Placement (" + p.getPlacement() + "): ");
            String placement = scanner.nextLine();
            if (!placement.isEmpty()) p.setPlacement(Boolean.parseBoolean(placement));

            System.out.print("Situation Familiale (" + p.getSituationFamiliale() + "): ");
            String sit = scanner.nextLine();
            if (!sit.isEmpty()) p.setSituationFamiliale(sit);

            System.out.print("Score (" + p.getScore() + "): ");
            String score = scanner.nextLine();
            if (!score.isEmpty()) p.setScore(Integer.parseInt(score));

            System.out.print("Revenu (" + p.getRevenu() + "): ");
            String revenu = scanner.nextLine();
            if (!revenu.isEmpty()) p.setRevenu(Float.parseFloat(revenu));

            System.out.print("Immatriculation Fiscale (" + p.getImmatriculationFiscale() + "): ");
            String imf = scanner.nextLine();
            if (!imf.isEmpty()) p.setImmatriculationFiscale(imf);

            System.out.print("Secteur Activite (" + p.getSecteurActivite() + "): ");
            String secteur = scanner.nextLine();
            if (!secteur.isEmpty()) p.setSecteurActivite(secteur);

            System.out.print("Activite (" + p.getActivite() + "): ");
            String activite = scanner.nextLine();
            if (!activite.isEmpty()) p.setActivite(activite);

            service.updateProfessionnel(p);
            System.out.println("Professionnel updated successfully!");

        } catch (Exception ex) {
            System.out.println("Error updating professionel: " + ex.getMessage());
        }
    }

    public void deleteProfessionel() {
        System.out.print("Enter ID to delete: ");
        int id = scanner.nextInt();
        try {
            service.deleteProfessionnel(id);
            System.out.println("Professionnel deleted successfully!");
        } catch (SQLException e) {
            System.out.println("Error deleting professionel: " + e.getMessage());
        }
    }
}

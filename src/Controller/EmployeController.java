package Controller;

import Models.Employe;
import Models.Person;
import Service.EmployeService;
import Utils.ScoreUtilsNewClient;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class EmployeController {

    private final EmployeService service;
    private final Scanner scanner = new Scanner(System.in);

    public EmployeController() {
        this.service = new EmployeService();
    }

    public void listAllEmployes() {
        try {
            List<Employe> employes = service.getAllEmployes();
            employes.forEach(e->{
                System.out.println("=== Employe "+ e.getId() +"  ===");
                System.out.println("Nom: " + e.getNom());
                System.out.println("Prenom: " + e.getPrenom());
                System.out.println("Email: " + e.getEmail());
                System.out.println("Date Naissance: " + e.getDateNaissance());
                System.out.println("Ville: " + e.getVille());
                System.out.println("Adresse: " + e.getAdresse());
                System.out.println("Telephone: " + e.getTelephone());
                System.out.println("Nombre Enfants: " + e.getNombreEnfants());
                System.out.println("Investissement: " + e.getInvestissement());
                System.out.println("Placement: " + e.getPlacement());
                System.out.println("Situation Familiale: " + e.getSituationFamiliale());
                System.out.println("Score: " + e.getScore());
                System.out.println("Anciennete: " + e.getAnciennete());
                System.out.println("Salaire: " + e.getSalaire());
                System.out.println("Poste: " + e.getPost());
                System.out.println("Contract Type: " + e.getContractType());
                System.out.println("Employment Sector: " + e.getEmploymentSector());
                System.out.println("======================");
                    }

            );
        } catch (SQLException e) {
            System.out.println("Error fetching employes: " + e.getMessage());
        }
    }

    public void getEmployeById() {
        System.out.print("Enter Employe ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            Optional<Employe> employeOpt = service.getEmployeById(id);
            if (employeOpt.isPresent()) {
                Employe e = employeOpt.get();
                System.out.println("=== Employe Details ===");
                System.out.println("ID: " + e.getId());
                System.out.println("Nom: " + e.getNom());
                System.out.println("Prenom: " + e.getPrenom());
                System.out.println("Email: " + e.getEmail());
                System.out.println("Date Naissance: " + e.getDateNaissance());
                System.out.println("Ville: " + e.getVille());
                System.out.println("Adresse: " + e.getAdresse());
                System.out.println("Telephone: " + e.getTelephone());
                System.out.println("Nombre Enfants: " + e.getNombreEnfants());
                System.out.println("Investissement: " + e.getInvestissement());
                System.out.println("Placement: " + e.getPlacement());
                System.out.println("Situation Familiale: " + e.getSituationFamiliale());
                System.out.println("Score: " + e.getScore());
                System.out.println("Anciennete: " + e.getAnciennete());
                System.out.println("Salaire: " + e.getSalaire());
                System.out.println("Poste: " + e.getPost());
                System.out.println("Contract Type: " + e.getContractType());
                System.out.println("Employment Sector: " + e.getEmploymentSector());
                System.out.println("======================");
            } else {
                System.out.println("Employe not found");
            }
        } catch (SQLException ex) {
            System.out.println("Error fetching employe: " + ex.getMessage());
        }
    }

    public void updateEmploye() {
        try {
            System.out.print("Enter Employe ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Optional<Employe> employeOpt = service.getEmployeById(id);

            if (!employeOpt.isPresent()) {
                System.out.println("Employe not found with ID: " + id);
                return;
            }

            Employe e = employeOpt.get();

            System.out.print("Nom (" + e.getNom() + "): ");
            String nom = scanner.nextLine();
            if (!nom.isEmpty()) e.setNom(nom);

            System.out.print("Prenom (" + e.getPrenom() + "): ");
            String prenom = scanner.nextLine();
            if (!prenom.isEmpty()) e.setPrenom(prenom);

            System.out.print("Ville (" + e.getVille() + "): ");
            String ville = scanner.nextLine();
            if (!ville.isEmpty()) e.setVille(ville);

            System.out.print("Salaire (" + e.getSalaire() + "): ");
            String salaireStr = scanner.nextLine();
            if (!salaireStr.isEmpty()) e.setSalaire(Float.parseFloat(salaireStr));

            System.out.print("Poste (" + e.getPost() + "): ");
            String post = scanner.nextLine();
            if (!post.isEmpty()) e.setPost(post);

            System.out.print("Contract Type (" + e.getContractType() + "): ");
            String ct = scanner.nextLine();
            if (!ct.isEmpty()) e.setContractType(Employe.ContractType.valueOf(ct));

            System.out.print("Employment Sector (" + e.getEmploymentSector() + "): ");
            String es = scanner.nextLine();
            if (!es.isEmpty()) e.setEmploymentSector(Employe.EmploymentSector.valueOf(es));

            System.out.print("Anciennete (" + e.getAnciennete() + "): ");
            String ancStr = scanner.nextLine();
            if (!ancStr.isEmpty()) e.setAnciennete(Integer.parseInt(ancStr));

            System.out.print("Nombre Enfants (" + e.getNombreEnfants() + "): ");
            String enfantsStr = scanner.nextLine();
            if (!enfantsStr.isEmpty()) e.setNombreEnfants(Integer.parseInt(enfantsStr));

            System.out.print("Investissement (" + e.getInvestissement() + "): ");
            String invStr = scanner.nextLine();
            if (!invStr.isEmpty()) e.setInvestissement(Boolean.parseBoolean(invStr));

            System.out.print("Placement (" + e.getPlacement() + "): ");
            String plStr = scanner.nextLine();
            if (!plStr.isEmpty()) e.setPlacement(Boolean.parseBoolean(plStr));

            System.out.print("Situation Familiale (" + e.getSituationFamiliale() + "): ");
            String sit = scanner.nextLine();
            if (!sit.isEmpty()) e.setSituationFamiliale(Person.SituationFamilial.valueOf(sit));
            System.out.print("Date Naissance (" + e.getDateNaissance() + ":");
            String dn = scanner.nextLine();
            if (!dn.isEmpty()) e.setDateNaissance(LocalDate.parse(dn));
            Integer score= ScoreUtilsNewClient.calculerScore(e);
            e.setScore(score);
            service.updateEmploye(e);
            System.out.println(" Employe updated successfully!");
        } catch (Exception ex) {
            System.out.println(" Error updating employe: " + ex.getMessage());
        }
    }


    public void addEmploye() {
        try {
            Employe e = new Employe();
            scanner.nextLine();
            System.out.print("Nom: ");
            e.setNom(scanner.nextLine());
            System.out.print("Prenom: ");
            e.setPrenom(scanner.nextLine());
            System.out.print("Ville: ");
            e.setVille(scanner.nextLine());
            System.out.print("Salaire: ");
            e.setSalaire(scanner.nextFloat());
            scanner.nextLine();
            System.out.print("Poste: ");
            e.setPost(scanner.nextLine());
            System.out.print("Contract Type: ");
            e.setContractType(Employe.ContractType.valueOf(scanner.nextLine()));
            System.out.print("Employment Sector: ");
            e.setEmploymentSector(Employe.EmploymentSector.valueOf(scanner.nextLine()));
            System.out.print("Anciennete: ");
            e.setAnciennete(scanner.nextInt());
            scanner.nextLine();
            System.out.print("Nombre Enfants: ");
            e.setNombreEnfants(scanner.nextInt());
            scanner.nextLine();
            System.out.print("Investissement: ");
            e.setInvestissement(scanner.nextBoolean());
            scanner.nextLine();
            System.out.print("Placement: ");
            e.setPlacement(scanner.nextBoolean());
            scanner.nextLine();
            System.out.print("Situation Familiale (Celibataire/Marie): ");
            e.setSituationFamiliale(Person.SituationFamilial.valueOf(scanner.nextLine()));
            System.out.print("Date Naissance: ");
            String dateNaissance = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(dateNaissance, formatter);
            e.setDateNaissance(date);
            Integer score= ScoreUtilsNewClient.calculerScore(e);
            e.setScore(score);
            Employe saved = service.addEmploye(e);
            System.out.println("Employe adde'd with ID: " + saved.getId());

        } catch (SQLException ex) {
            System.out.println("Error adding employe: " + ex.getMessage());
        }
    }

    public void deleteEmploye() {
        System.out.print("Enter ID to delete: ");
        int id = scanner.nextInt();
        try {
            service.deleteEmploye(id);
            System.out.println("Employe deleted successfully!");
        } catch (SQLException e) {
            System.out.println("Error deleting employe: " + e.getMessage());
        }
    }

    public void listSortedByScore() {
        try {
            List<Employe> employes = service.getEmployesSortedByScore();
            employes.forEach(e->{
                System.out.println("=== Employe "+ e.getId() +"  ===");
                System.out.println("Nom: " + e.getNom());
                System.out.println("Prenom: " + e.getPrenom());
                System.out.println("Email: " + e.getEmail());
                System.out.println("Date Naissance: " + e.getDateNaissance());
                System.out.println("Ville: " + e.getVille());
                System.out.println("Adresse: " + e.getAdresse());
                System.out.println("Telephone: " + e.getTelephone());
                System.out.println("Nombre Enfants: " + e.getNombreEnfants());
                System.out.println("Investissement: " + e.getInvestissement());
                System.out.println("Placement: " + e.getPlacement());
                System.out.println("Situation Familiale: " + e.getSituationFamiliale());
                System.out.println("Score: " + e.getScore());
                System.out.println("Anciennete: " + e.getAnciennete());
                System.out.println("Salaire: " + e.getSalaire());
                System.out.println("Poste: " + e.getPost());
                System.out.println("Contract Type: " + e.getContractType());
                System.out.println("Employment Sector: " + e.getEmploymentSector());
                System.out.println("======================");
            });
        } catch (SQLException e) {
            System.out.println("Error sorting employes: " + e.getMessage());
        }
    }

    public void searchByVille() {
        System.out.print("Enter city: ");
        String ville = scanner.next();
        try {
            List<Employe> employes = service.searchByVille(ville);
            employes.forEach(e->{
                System.out.println("=== Employe Details ===");
                System.out.println("ID: " + e.getId());
                System.out.println("Nom: " + e.getNom());
                System.out.println("Prenom: " + e.getPrenom());
                System.out.println("Email: " + e.getEmail());
                System.out.println("Date Naissance: " + e.getDateNaissance());
                System.out.println("Ville: " + e.getVille());
                System.out.println("Adresse: " + e.getAdresse());
                System.out.println("Telephone: " + e.getTelephone());
                System.out.println("Nombre Enfants: " + e.getNombreEnfants());
                System.out.println("Investissement: " + e.getInvestissement());
                System.out.println("Placement: " + e.getPlacement());
                System.out.println("Situation Familiale: " + e.getSituationFamiliale());
                System.out.println("Score: " + e.getScore());
                System.out.println("Anciennete: " + e.getAnciennete());
                System.out.println("Salaire: " + e.getSalaire());
                System.out.println("Poste: " + e.getPost());
                System.out.println("Contract Type: " + e.getContractType());
                System.out.println("Employment Sector: " + e.getEmploymentSector());
                System.out.println("======================");
            });
        } catch (SQLException e) {
            System.out.println("Error searching employes: " + e.getMessage());
        }
    }
}

package Controller;

import Models.Employe;
import Service.EmployeService;

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
            employes.forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println("Error fetching employes: " + e.getMessage());
        }
    }

    public void getEmployeById() {
        System.out.print("Enter Employe ID: ");
        int id = scanner.nextInt();
        try {
            Optional<Employe> employe = service.getEmployeById(id);
            System.out.println(employe.orElse(null));
            if (!employe.isPresent()) {
                System.out.println("Employe not found");
            }

        } catch (SQLException e) {
            System.out.println("Error fetching employe: " + e.getMessage());
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
            System.out.print("Situation Familiale: ");
            e.setSituationFamiliale(scanner.nextLine());
            scanner.nextLine();
            System.out.print("Score: ");
            e.setScore(scanner.nextDouble());
            scanner.nextLine();
            System.out.print("Date Naissance: ");
            String dateNaissance = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(dateNaissance, formatter);
            e.setDateNaissance(date);
            Employe saved = service.addEmploye(e);
            System.out.println("Employe added with ID: " + saved.getId());

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
            employes.forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println("Error sorting employes: " + e.getMessage());
        }
    }

    public void searchByVille() {
        System.out.print("Enter city: ");
        String ville = scanner.next();
        try {
            List<Employe> employes = service.searchByVille(ville);
            employes.forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println("Error searching employes: " + e.getMessage());
        }
    }
}

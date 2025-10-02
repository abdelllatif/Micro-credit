package Menu;

import Controller.ProfessionelController;
import java.util.Scanner;

public class ProfessionelMenu {



    public ProfessionelMenu() {

    }

    public static void showMenu() {
        ProfessionelController controller = new ProfessionelController();
        Scanner  scanner = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            System.out.println("\n===== Professionnel Menu =====");
            System.out.println("1. List all Professionnels");
            System.out.println("2. Get Professionnel by ID");
            System.out.println("3. Add Professionnel");
            System.out.println("4. Update Professionnel");
            System.out.println("5. Delete Professionnel");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 :
                    controller.listAllProfessionels();
                    break;
                case 2 :
                    controller.getProfessionelById();
                    break;
                case 3 :
                    controller.addProfessionel();
                    break;
                case 4 :
                    controller.updateProfessionel();
                    break;
                case 5 :
                    controller.deleteProfessionel();
                    break;
                case 0 :
                    System.out.println("Exiting menu...");
                    break;
                default :
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        new ProfessionelMenu().showMenu();
    }
}

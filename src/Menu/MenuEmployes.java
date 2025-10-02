package Menu;

import Controller.EmployeController;

import java.util.Scanner;

public class MenuEmployes {

   public static void afficherMenuEmployes(){

       try{
       EmployeController controller = new EmployeController();
       Scanner scanner = new Scanner(System.in);
       int choice;

       do {
           System.out.println("\n===== Employe Management Menu =====");
           System.out.println("1. List all employes");
           System.out.println("2. Find employe by ID");
           System.out.println("3. Add employe");
           System.out.println("4. Delete employe");
           System.out.println("5. List employes sorted by score");
           System.out.println("6. Search employes by city");
           System.out.println("7. modifier un client");
           System.out.println("0. Exit");
           System.out.print("Choose an option: ");
           choice = scanner.nextInt();

           switch (choice) {
               case 1 :
                   controller.listAllEmployes();
                   break;
               case 2 :
                   controller.getEmployeById();
                   break;
               case 3 :
                   controller.addEmploye();
                   break;
               case 4 :
                   controller.deleteEmploye();
                   break;
               case 5 :
                   controller.listSortedByScore();
                   break;
               case 6 :
                   controller.searchByVille();
                   break;
               case 7 :
                   controller.updateEmploye();
               case 0 :
                   System.out.println("Goodbye!");
                   break;
               default :
                   System.out.println("Invalid choice. Try again.");
           }

       } while (choice != 0);

   } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
   }

}

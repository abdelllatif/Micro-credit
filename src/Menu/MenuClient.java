package Menu;

import java.util.Scanner;

public class MenuClient {
    public static void afficherMenuClients(){
        Integer choix;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("\n===== Client =====");
            System.out.println("selectionne le type de client \n" +
                    "1:Employe\n" +
                    "2:Profitionnel\n" +
                    "0:Quitter");
            System.out.print("entrer votre choix: ");
             choix = scanner.nextInt();
            switch (choix){
                case 1:
                    MenuEmployes.afficherMenuEmployes();
                    break;
                case 2:
                    ProfessionelMenu.showMenu();
                    break;
                case 0:
                    System.out.println("Goodbye!");
            }
        }while(choix!=0);
    }
}

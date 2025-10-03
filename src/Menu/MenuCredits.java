package Menu;

import Controller.CreditController;

import java.util.Scanner;

public class MenuCredits {

    public static void afficherMenuCredits(){
        Integer choix;
        do {
            System.out.println("2. Gestion des Crédits");
            System.out.println("2.1. Créer une demande de crédit");
            System.out.println("2.2. Approuver un crédit (manuellement)");
            System.out.println("2.3. Simuler une offre de crédit");
            System.out.println("2.4. Afficher les détails d'un crédit");
            System.out.println("2.5. Lister les crédits par client");
            System.out.println("2.6. Lister tous les crédits approuvés");
            System.out.print("Entrez votre choix : ");
            Scanner sc=new Scanner(System.in);
            choix=sc.nextInt();



            switch (choix){
                case 1:
                    CreditController cr=new CreditController();
                    cr.addCredit();
                    break;
                case 0   :
                    System.out.println("bye");
                    break;
            }
        }while(choix!=0);

    }

}

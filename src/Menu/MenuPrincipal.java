package Menu;

import java.util.Scanner;

public class MenuPrincipal {


public static void afficherMenuPrincipal(){

  Integer choix;
  do {
      System.out.println("============================================================");
      System.out.println("      Système de Scoring de Crédit - Microfinance           ");
      System.out.println("============================================================");
      System.out.println("Veuillez sélectionner une option :");
      System.out.println("1. Gestion des Clients");
      System.out.println("2. Gestion des Crédits");
      System.out.println("3. Gestion des Paiements");
      System.out.println("4. Analyse et Rapports");
      System.out.println("5. Administration");
      System.out.println("6. Quitter");
      System.out.print("Entrez votre choix : ");
      Scanner sc=new Scanner(System.in);
      choix=sc.nextInt();
      switch (choix) {
          case 1:
              MenuClient.afficherMenuClients();
              break;
          case 2:
              MenuCredits.afficherMenuCredits();
              break;
          case 3:
              //
              break;
          case 4:
              //
              break;
          case 5:
              //
              break;
          case 0:
              System.out.println("Merci d'avoir utilisé le système. Au revoir !");
              break;
          default:
              System.out.println("Choix invalide, veuillez réessayer.");
      }
  }while (choix!=0);
}



}

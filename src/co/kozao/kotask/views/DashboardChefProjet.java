package co.kozao.kotask.views;

import java.util.Scanner;

public class DashboardChefProjet {

	 public static void start(Scanner scanner) {
	  
	        System.out.println("======== Tableau de bord Chef de Projet =======");
	        System.out.println("================ G�rer les t�ches================");
			System.out.println("1 . Cr�er unetache");
			System.out.println("2. Modifier une tache");
			System.out.println("3. Supprimer une tache");
			System.out.println("4. Afficher tous les  taches");
			System.out.println("0. D�connexion");
			System.out.print("Votre choix : ");

	       // System.out.println("2. Voir l�avancement");
	        //System.out.println("3. D�connexion");

	        int choix = scanner.nextInt();
	        scanner.nextLine();
	        // Ici tes actions...
	    }
}

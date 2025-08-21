package co.kozao.kotask.views;

import java.util.Scanner;

public class DashboardChefProjet {

	 public static void start(Scanner scanner) {
	  
	        System.out.println("======== Tableau de bord Chef de Projet =======");
	        System.out.println("================ Gérer les tâches================");
			System.out.println("1 . Créer unetache");
			System.out.println("2. Modifier une tache");
			System.out.println("3. Supprimer une tache");
			System.out.println("4. Afficher tous les  taches");
			System.out.println("0. Déconnexion");
			System.out.print("Votre choix : ");

	       // System.out.println("2. Voir l’avancement");
	        //System.out.println("3. Déconnexion");

	        int choix = scanner.nextInt();
	        scanner.nextLine();
	        // Ici tes actions...
	    }
}

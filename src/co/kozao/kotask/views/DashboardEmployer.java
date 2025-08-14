package co.kozao.kotask.views;

import java.util.Scanner;

public class DashboardEmployer {
	
	public static void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("======== Tableau de bord Employé========");
        System.out.println("1. Voir mes tâches");
        System.out.println("2. Marquer tâche comme terminée");
        System.out.println("3. Déconnexion");

        int choix = sc.nextInt();
        // Actions...
    }

}

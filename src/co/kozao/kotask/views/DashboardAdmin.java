package co.kozao.kotask.views;

import java.util.Scanner;

//import co.kozao.kotask.controllers.UserAccesController;
//import co.kozao.kotask.services.UserServiceImplement;

public class DashboardAdmin {
	
		//UserServiceImplement userservice = new UserServiceImplement();
		//UserAccesController con = new UserAccesController(userservice);

	public static void start() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("======= Tableau de bord ADMIN =======");
		System.out.println("1. Gérer les utilisateurs");
		System.out.println("2. Gérer les projet");
		System.out.println("3. Gérer les taches");
		System.out.println("3. Déconnexion");

		int choix = sc.nextInt();
		// Ici tu mets les fonctionnalités Admin...
	}

}

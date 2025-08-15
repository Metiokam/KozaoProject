package co.kozao.kotask.views;

import co.kozao.kotask.controllers.UserAccessController;
import co.kozao.kotask.models.Role;
import co.kozao.kotask.models.User;


import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		UserAccessController controller = new UserAccessController();

		while (true) {
			System.out.println("\n===== Bienvenue sur Ko-Task =====");
			System.out.println("1. Se connecter");
			//System.out.println("2. Modifier un utilisateur");
			//System.out.println("3. Supprimer un utilisateur");
			//System.out.println("4. Liste des utilisateurs");
			System.out.println("0. Quitter");
			System.out.print("Choisissez une option : ");

			int choix = scanner.nextInt();
			scanner.nextLine(); // Consommer le retour à la ligne

			switch (choix) {
			case 1 -> {
				System.out.print("Email : ");
				String email = scanner.nextLine();
				System.out.print("Mot de passe : ");
				String password = scanner.nextLine();

				User user = controller.authenticate(email, password);
				if (user != null) {
					switch (user.getRole()) {
					case ADMIN:
						DashboardAdmin.start();
					case EMPLOYER:
						DashboardEmployer.start();
					case CHEF_PROJECT:
						DashboardChefProjet.start();
					default:
						System.out.println("Rôle non défini pour cet utilisateur !");
					}
				} else {
					System.out.println("Échec de la connexion. Vérifiez vos identifiants.");
				}
			}
			
			case 0 -> {
				System.out.println("Au revoir !");
				scanner.close();
				return;
			}
			default -> System.out.println("Option invalide.");
			}
		}
	}
}

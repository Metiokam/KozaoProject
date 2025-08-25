package co.kozao.kotask.views;

import java.util.Scanner;

public class DashboardAdmin {

	public static void start(Scanner scanner) {
		UserView userView = new UserView();
		ProjectView projectView = new ProjectView();
		TaskView taskView = new TaskView();

		boolean running = true;

		while (running) {
			System.out.println("================== Tableau de bord ADMIN ==================");

			System.out.println("1. Créer un utilisateur");
			System.out.println("2. Modifier un utilisateur");
			System.out.println("3. Supprimer un utilisateur");
			System.out.println("4. Afficher tous les  utilisateur");

			System.out.println("================= Gérer les projets=======================");

			System.out.println("5. Créer un projet");
			System.out.println("6. Modifier un projet");
			System.out.println("7. Supprimer un projet");
			System.out.println("8. Afficher tous les  projet");

			System.out.println("================ Gérer les tâches================");

			System.out.println("9. Créer une tache");
			System.out.println("10. Modifier une tache");
			System.out.println("11. Supprimer une tache");
			System.out.println("12. Afficher tous les  taches");
			System.out.println("0. Déconnexion");
			System.out.print("Votre choix : ");

			int choix = scanner.nextInt();
			scanner.nextLine();

			switch (choix) {

			case 1:

				userView.createUser();

				break;

			case 2:

				userView.updateUser();

				break;

			case 3:

				userView.deleteUser();

				break;
			case 4:

				userView.getAllUsers();

				break;

			case 5:

				projectView.createProject();

				break;

			case 6:
				projectView.updateProject();

				break;

			case 7:

				projectView.deleteProject();

				break;

			case 8:

				projectView.getAllProject();
				
				break;

			case 9:

				taskView.createTask();
				break;

			case 10:
				taskView.updateTask();
				break;

			case 11:

				taskView.deleteTask();
				break;

			case 12:
				taskView.getAllTask();
				
				break;

			case 0: {
				System.out.println("Déconnexion. Au revoir !");
				running = false;
				scanner.close();
				return;
			}
			default:
				System.out.println("Option invalide.");

				break;
			}
		}

	}
}

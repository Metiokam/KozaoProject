package co.kozao.kotask.views;

import java.util.Scanner;

public class DashboardAdmin {

	public static void start(Scanner scanner) {
	    UserView userView = new UserView();
		ProjectView projectView = new ProjectView();
		TaskView taskView = new TaskView();
		ClientView clientView = new ClientView();

		boolean running = true;

		while (running) {
			System.out.println("================== Tableau de bord ADMIN ==================");

			System.out.println("1. Créer un utilisateur");
			System.out.println("2. Modifier un utilisateur");
			System.out.println("3. Supprimer un utilisateur");
			System.out.println("4. Afficher tous les  utilisateur");
			System.out.println("42. Modifier role");

			System.out.println("================= Gérer les clients=======================");
			
			System.out.println("5. Créer un client");
			System.out.println("6. Modifier un client");
			System.out.println("7. Supprimer un client");
			System.out.println("8. Afficher tous les  client");
			
			System.out.println("================= Gérer les projets=======================");

			System.out.println("9. Créer un projet");
			System.out.println("10. Modifier un projet");
			System.out.println("11. Supprimer un projet");
			System.out.println("12. Afficher tous les  projet");

			System.out.println("================ Gérer les tâches================");

			System.out.println("13. Créer une tache");
			System.out.println("14. Modifier une tache");
			System.out.println("15. Supprimer une tache");
			System.out.println("16. Afficher tous les  taches");
			

			System.out.println("================ Consulter Statitiques================");

			System.out.println("17. Afficher statut global des taches");
			System.out.println("18. Afficher statut global des projet");
			System.out.println("19. Afficher tous les commentaires");
			System.out.println("20. Afficher toutes les notifications");
			System.out.println("21. Afficher toutes documents envoyés");
			
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
				
			case 42:

				userView.updateRole();;

				break;
				
			case 5:

				clientView.createClient();

				break;

			case 6:
				clientView.updateClient();

				break;

			case 7:

				clientView.deleteClient();

				break;

			case 8:

				clientView.getAllClient();

				break;


			case 9:

				projectView.createProject();

				break;

			case 10:
				projectView.updateProject();

				break;

			case 11:

				projectView.deleteProject();

				break;

			case 12:

				projectView.getAllProject();

				break;

			case 13:

				taskView.createTask();
				break;

			case 14:
				taskView.updateTask();
				break;

			case 15:

				taskView.deleteTask();
				break;

			case 16:
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

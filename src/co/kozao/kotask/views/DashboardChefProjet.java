package co.kozao.kotask.views;

import java.util.Scanner;

public class DashboardChefProjet {

	public static void start(Scanner scanner) {

		TaskView taskView = new TaskView();
		DocumentView documentView = new DocumentView();
		CommentView commentView = new CommentView();

		boolean running = true;

		while (running) {

			System.out.println("======== Tableau de bord Chef de Projet =======");

			System.out.println("================ Gérer les tâches================");
			System.out.println("1. Créer une tache");
			System.out.println("2. Modifier une tache");
			System.out.println("3. Supprimer une tache");
			System.out.println("4. Afficher tous les  taches");

			System.out.println("================ Gérer Commentaire================");
			System.out.println("5. Créer un commentaire");
			System.out.println("6. Modifier un commentaire");
			System.out.println("7. Supprimer un commentaire");
			System.out.println("8. Afficher tous les  commentaires");

			System.out.println("================ Gérer les Docuements================");
			System.out.println("9. Ajouter un document");
			System.out.println("10. Supprimer un document");
			System.out.println("11. Afficher un document");
			System.out.println("12. Afficher tous les  documents");

			System.out.println("0. Déconnexion");
			System.out.print("Votre choix : ");

			int choix = scanner.nextInt();
			scanner.nextLine();

			switch (choix) {

			case 1:

				taskView.createTask();
				break;

			case 2:
				taskView.updateTask();
				break;

			case 3:

				taskView.deleteTask();
				break;

			case 4:
				taskView.getAllTask();

				break;

			case 5:
				commentView.createComment();
				break;

			case 6:
				commentView.updateComment();
				break;

			case 7:
				commentView.deleteComment();
				break;

			case 8:
				commentView.getAllComment();

				break;

			case 9:
				documentView.addDocument();

				break;

			case 10:
				documentView.deleteDocument();

				break;

			case 11:
				documentView.getDocument_By_Id();

				break;

			case 12:
				documentView.getAllDocument();

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

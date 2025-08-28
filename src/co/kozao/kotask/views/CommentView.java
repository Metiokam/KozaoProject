package co.kozao.kotask.views;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import co.kozao.kotask.controllers.CommentAccesController;
import co.kozao.kotask.models.CommentModel;

public class CommentView {

	Scanner scanner = new Scanner(System.in);

	CommentAccesController commentController = new CommentAccesController();

	public void createComment() {

		System.out.print("Entrez le Message du commentaire : ");
		String message = scanner.nextLine();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.print("Date de creation (jj/MM/aaaa) : ");
		String datecreated = scanner.nextLine();
		LocalDate dateCreated = LocalDate.parse(datecreated, formatter);

		System.out.print("Identifiant De l'utilisateur : ");

		int idAuthor = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Identifiant De la tache a commenté : ");

		int idTask = scanner.nextInt();
		scanner.nextLine();

		CommentModel comments = commentController.createComment(message, dateCreated, idAuthor, idTask);

		if (comments != null) {
			System.out.println("Commentaire créé avec succès !");
		} else {
			System.out.println("Erreur lors de la création du commentaire.");
		}

	}

	public void updateComment() {

		System.out.print("Identifiant du  commentaire  à modifier : ");
		int idComment = scanner.nextInt();
		scanner.nextLine();

		CommentModel comments = commentController.getCommentById(idComment);

		if (comments != null) {

			System.out.print("Nouveau commentaire : ");
			comments.setMessage(scanner.nextLine());

			DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			System.out.print("Nouvelle date de de creation (jj/MM/aaaa) : ");
			String dateCreateds = scanner.nextLine();
			LocalDate dateCreated = LocalDate.parse(dateCreateds, formatters);
			comments.setDateCreated(dateCreated);

			System.out.print("Identifant de l'auteur : ");
			comments.setIdAuthor(scanner.nextInt());

			System.out.print("Identifiant de la tache : ");
			comments.setIdTask(scanner.nextInt());

			if (commentController.updateComment(comments)) {
				System.out.println("Commentaire mis à jour !");
			} else {
				System.out.println("Échec de la mise à jour.");
			}
		} else {
			System.out.println("Commentaire introuvable !");
		}

	}

	public void deleteComment() {

		System.out.print("Identifiant du commentaire à supprimer : ");
		int idComment = scanner.nextInt();
		scanner.nextLine();

		if (commentController.deleteComment(idComment)) {

			System.out.println("Commentaire supprimé !");
		} else {
			System.out.println("Échec de la suppression.");
		}
	}

	public void getAllComment() {

		List<CommentModel> comment = commentController.getAllComment();
		if (comment.isEmpty()) {
			System.out.println("Aucun commentaire trouvé.");
		} else {
			System.out.println("=== Liste des Commentaires ===");
			for (CommentModel com : comment) {
				System.out.printf(
						"Identifiant du commentaire : %d | Message : %s | Date de creaction : %s | identifiant de l'auteur : %d| identifiant de la tache : %d%n",
						com.getIdComment(), com.getMessage(), com.getDateCreated(), com.getIdAuthor(), com.getIdTask());

			}
		}

	}

}

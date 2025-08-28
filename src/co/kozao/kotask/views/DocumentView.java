package co.kozao.kotask.views;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import co.kozao.kotask.controllers.DocumentAccessController;
import co.kozao.kotask.models.DocumentModel;

public class DocumentView {

	Scanner scanner = new Scanner(System.in);

	DocumentAccessController documentController = new DocumentAccessController();

	public void addDocument() {
		System.out.print("Entrez le nom du document : ");
		String documentName = scanner.nextLine();

		System.out.print("Entrez le lien du document : ");
		String documentPath = scanner.nextLine();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.print("Date d'ajout (jj/MM/aaaa) : ");
		String dateAddeds = scanner.nextLine();
		LocalDate dateAdded = LocalDate.parse(dateAddeds, formatter);

		System.out.print("Identifiant De l'utilisateur : ");
		int idAuthor = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Identifiant Du projet : ");
		int idProject = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Identifiant De la tache  : ");
		int idTask = scanner.nextInt();
		scanner.nextLine();

		DocumentModel documents = documentController.addDocument(documentName, documentPath, dateAdded, idAuthor, idProject,
				idTask);

		if (documents != null) {
			System.out.println("Document ajoute avec succées !");
		} else {
			System.out.println("Erreur lors de l'ajout du document.");
		}
	}

	public void deleteDocument() {

		System.out.print("Identifiant du commentaire à supprimer : ");
		int idDocument = scanner.nextInt();
		scanner.nextLine();

		if (documentController.deleteDocument(idDocument)) {

			System.out.println("Document supprimé !");
		} else {
			System.out.println("Échec de la suppression.");
		}
	}

	public void getDocument_By_Id() {

		System.out.print("Identifiant du document à rechercher : ");
		int idDocument = scanner.nextInt();
		scanner.nextLine();

		DocumentModel documents = documentController.getDocumentById(idDocument);

		if (documents != null) {

			System.out.println("informations du document !");
		} else {
			System.out.println("Échec de la recherche.");
		}

	}

	public void getAllDocument() {

		List<DocumentModel> document = documentController.getAllDocument();
		if (document.isEmpty()) {
			System.out.println("Aucun document trouvé.");
		} else {
			System.out.println("=== Liste des Documents ===");
			for (DocumentModel doc : document) {
				System.out.printf(
						"Identifiant du document : %d | le nom du document : %s | lien du document : %s | Date d'ajout : %s | identifiant de l'auteur : %d | identifiant du projet : %d| identifiant de la tache : %d%n",
						doc.getIdDocument(), doc.getDocumentName(), doc.getDocumentPath(), doc.getDateAdded(),
						doc.getIdAuthor(), doc.getIdProject(), doc.getIdTask());

			}
		}

	}

}

package co.kozao.kotask.controllers;

import java.time.LocalDate;
import java.util.List;

import org.apache.log4j.Logger;
import co.kozao.kotask.models.Document;
import co.kozao.kotask.services.implement.DocumentService;
import co.kozao.kotask.services.interfaces.DocumentServiceInterface;

public class DocumentAccessController {

	private DocumentServiceInterface documentService = new DocumentService();

	private static final Logger LOGGER = Logger.getLogger(DocumentAccessController.class);

	public Document addDocument(String documentName, String documentPath, LocalDate dateAdded, int idAuthor,
			int idProject, int idTask) {

		Document document = new Document();

		document.setDocumentName(documentName);
		document.setDocumentPath(documentPath);
		document.setDateAdded(dateAdded);
		document.setIdAuthor(idAuthor);
		document.setIdProject(idProject);
		document.setIdTask(idTask);

		LOGGER.info("Tentative d'ajout d'un document : " + document);

		try {

			Document addDocument = documentService.addDocument(document);

			if (addDocument != null) {

				LOGGER.info("Document ajoute  avec succès : " + addDocument);

			} else {
				LOGGER.error("Le service n'a pas pu ajouter le document, résultat null.");
			}

			return addDocument;

		} catch (Exception e) {
			LOGGER.error("Erreur lors de l'ajout d'un document : " + e.getMessage());
			return null;
		}
	}

	public boolean deleteDocument(int idDocument) {
		try {

			documentService.deleteDocument(idDocument);

			return true;

		} catch (Exception e) {

			LOGGER.error("Erreur lors de la suppression du document" + e.getMessage());

			return false;

		}

	}

	public List<Document> getAllDocument() {

		try {
			return documentService.getAllDocument();

		} catch (Exception e) {
			LOGGER.error("Erreur lors de la recuperation de tous les documents" + e.getMessage());
			return null;
		}
	}

	public Document getDocumentById(int idDocument) {

		try {
			return documentService.getDocumentById(idDocument);
		} catch (Exception e) {
			LOGGER.error("Erreur lors de la recherche d'un document");
		}
		return null;
	}

}

package co.kozao.kotask.services.interfaces;

import java.util.List;


import co.kozao.kotask.models.DocumentModel;

public interface DocumentServiceInterface {
	
	DocumentModel addDocument(DocumentModel document);
	boolean deleteDocument(int idDocument);
	List<DocumentModel>getAllDocument();
	DocumentModel getDocumentById(int idDocument);

}

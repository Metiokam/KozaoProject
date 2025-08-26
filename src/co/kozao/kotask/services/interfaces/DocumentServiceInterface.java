package co.kozao.kotask.services.interfaces;

import java.util.List;


import co.kozao.kotask.models.Document;

public interface DocumentServiceInterface {
	
	Document addDocument(Document document);
	boolean deleteDocument(int idDocument);
	List<Document>getAllDocument();
	Document getDocumentById(int idDocument);

}

package co.kozao.kotask.models;


import java.time.LocalDate;

public class Document {
	
	private int idDocument;
	private String documentName;
	private String DocumentPath;
	private LocalDate dateAdded;
	private int idAuthor;
	private int idProject;
	private int idTask;
	
	
	public Document() {
		
	}


	public Document(int idDocument, String documentName, String documentPath, LocalDate dateAdded, int idAuthor,
			int idProject, int idTask) {
		
		this.idDocument = idDocument;
		this.documentName = documentName;
		DocumentPath = documentPath;
		this.dateAdded = dateAdded;
		this.idAuthor = idAuthor;
		this.idProject = idProject;
		this.idTask = idTask;
	}


	public int getIdDocument() {
		return idDocument;
	}


	public void setIdDocument(int idDocument) {
		this.idDocument = idDocument;
	}


	public String getDocumentName() {
		return documentName;
	}


	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}


	public String getDocumentPath() {
		return DocumentPath;
	}


	public void setDocumentPath(String documentPath) {
		DocumentPath = documentPath;
	}


	public LocalDate getDateAdded() {
		return dateAdded;
	}


	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}


	public int getIdAuthor() {
		return idAuthor;
	}


	public void setIdAuthor(int idAuthor) {
		this.idAuthor = idAuthor;
	}


	public int getIdProject() {
		return idProject;
	}


	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}


	public int getIdTask() {
		return idTask;
	}


	public void setIdTask(int idTask) {
		this.idTask = idTask;
	}


	@Override
	public String toString() {
		return "Document [idDocument=" + idDocument + ", documentName=" + documentName + ", DocumentPath="
				+ DocumentPath + ", dateAdded=" + dateAdded + ", idAuthor=" + idAuthor + ", idProject=" + idProject
				+ ", idTask=" + idTask + "]";
	}

	
	

}
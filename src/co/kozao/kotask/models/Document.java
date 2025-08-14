package co.kozao.kotask.models;


import java.time.LocalDateTime;

public class Document {
	
	private int idDocument;
	private String nom;
	private String cheminDocument;
	private LocalDateTime dateUpload;
	
	
	public Document() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Document(int idDocument, String nom, String cheminDocument, LocalDateTime dateUpload) {
		super();
		this.idDocument = idDocument;
		this.nom = nom;
		this.cheminDocument = cheminDocument;
		this.dateUpload = dateUpload;
	}


	public int getIdDocument() {
		return idDocument;
	}


	public void setIdDocument(int idDocument) {
		this.idDocument = idDocument;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getCheminDocument() {
		return cheminDocument;
	}


	public void setCheminDocument(String cheminDocument) {
		this.cheminDocument = cheminDocument;
	}


	public LocalDateTime getDateUpload() {
		return dateUpload;
	}


	public void setDateUpload(LocalDateTime dateUpload) {
		this.dateUpload = dateUpload;
	}


	@Override
	public String toString() {
		return "Document [idDocument=" + idDocument + ", nom=" + nom + ", cheminDocument=" + cheminDocument
				+ ", dateUpload=" + dateUpload + "]";
	}
	
	
    
}

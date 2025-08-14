package co.kozao.kotask.models;

public class Project {
	
	public enum Statut{EN_COURS, TERMINE, EN_ATTENTE}
	
	private int idProject;
	private String nomProject;
	private String descriptionProject;
	private String dateDebutProject;
	private String dateFinProject;
	private Statut statutProject;
	
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Project(int idProject, String nomProject, String descriptionProject, String dateDebutProject,
			String dateFinProject, Statut statutProject) {
		super();
		this.idProject = idProject;
		this.nomProject = nomProject;
		this.descriptionProject = descriptionProject;
		this.dateDebutProject = dateDebutProject;
		this.dateFinProject = dateFinProject;
		this.statutProject = statutProject;
	}


	public int getIdProject() {
		return idProject;
	}


	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}


	public String getNomProject() {
		return nomProject;
	}


	public void setNomProject(String nomProject) {
		this.nomProject = nomProject;
	}


	public String getDescriptionProject() {
		return descriptionProject;
	}


	public void setDescriptionProject(String descriptionProject) {
		this.descriptionProject = descriptionProject;
	}


	public String getDateDebutProject() {
		return dateDebutProject;
	}


	public void setDateDebutProject(String dateDebutProject) {
		this.dateDebutProject = dateDebutProject;
	}


	public String getDateFinProject() {
		return dateFinProject;
	}


	public void setDateFinProject(String dateFinProject) {
		this.dateFinProject = dateFinProject;
	}


	public Statut getStatutProject() {
		return statutProject;
	}


	public void setStatutProject(Statut statutProject) {
		this.statutProject = statutProject;
	}


	@Override
	public String toString() {
		return "Project [idProject=" + idProject + ", nomProject=" + nomProject + ", descriptionProject="
				+ descriptionProject + ", dateDebutProject=" + dateDebutProject + ", dateFinProject=" + dateFinProject
				+ ", statutProject=" + statutProject + "]";
	}


	
	
	
	
	

}

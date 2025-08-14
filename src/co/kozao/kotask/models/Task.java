package co.kozao.kotask.models;


import java.sql.Date;

public class Task {
	
	public enum Statut{A_FAIRE, EN_COURS, TERMINE}
	
	public enum Priorite{HAUTE, MOYENNE, BASSE}
	
	private int idTask;
	private String titre;
	private String description;
	private Statut statut;
	private Priorite priorite;
	private Date dateDebut;
	private Date dateFin;
	
	
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Task(int idTask, String titre, String description, Statut statut, Priorite priorite, Date dateDebut,
			Date dateFin) {
		super();
		this.idTask = idTask;
		this.titre = titre;
		this.description = description;
		this.statut = statut;
		this.priorite = priorite;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}



	public int getIdTask() {
		return idTask;
	}



	public void setIdTasks(int idTask) {
		this.idTask = idTask;
	}



	public String getTitre() {
		return titre;
	}



	public void setTitre(String titre) {
		this.titre = titre;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Statut getStatut() {
		return statut;
	}



	public void setStatut(Statut statut) {
		this.statut = statut;
	}



	public Priorite getPriorite() {
		return priorite;
	}



	public void setPriorite(Priorite priorite) {
		this.priorite = priorite;
	}



	public Date getDateDebut() {
		return dateDebut;
	}



	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}



	public Date getDateFin() {
		return dateFin;
	}



	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}



	@Override
	public String toString() {
		return "Tasks [idTasks=" + idTask + ", titre=" + titre + ", description=" + description + ", statut=" + statut
				+ ", priorite=" + priorite + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + "]";
	}
	
	
}



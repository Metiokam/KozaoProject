package co.kozao.kotask.models;

import java.time.LocalDateTime;

public class ActivityLogs {
	
	public enum TypeAction {
		CREATION_TACHE, MISE_A_JOUR_STATUT, AJOUT_COMMENTAIRE, SUPPRESSION_TACHE, ATTRIBUTION_TACHE
	}
	
	private int idLogs;
	private TypeAction typeAction ;
	private String description;
	private LocalDateTime dateAction;
	
	
	public ActivityLogs() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ActivityLogs(int idLogs, TypeAction typeAction, String description, LocalDateTime dateAction) {
		super();
		this.idLogs = idLogs;
		this.typeAction = typeAction;
		this.description = description;
		this.dateAction = dateAction;
	}


	public int getIdLogs() {
		return idLogs;
	}


	public void setIdLogs(int idLogs) {
		this.idLogs = idLogs;
	}


	public TypeAction getTypeAction() {
		return typeAction;
	}


	public void setTypeAction(TypeAction typeAction) {
		this.typeAction = typeAction;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDateTime getDateAction() {
		return dateAction;
	}


	public void setDateAction(LocalDateTime dateAction) {
		this.dateAction = dateAction;
	}


	@Override
	public String toString() {
		return "ActivityLogs [idLogs=" + idLogs + ", typeAction=" + typeAction + ", description=" + description
				+ ", dateAction=" + dateAction + "]";
	}
	
	
	

}

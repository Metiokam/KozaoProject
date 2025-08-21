package co.kozao.kotask.models;


//import java.sql.Date;
import java.time.LocalDateTime;

import co.kozao.kotask.models.enums.PriorityTask;
import co.kozao.kotask.models.enums.StatusTask;

public class Task {
	
	private int idTask;
	private String title;
	private String description;
	private StatusTask statut;
	private PriorityTask priority;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private int idProject;
	private int idUser;
	
	
	public Task() {
	
	}

	public Task(int idTask, String title, String description, StatusTask statut, PriorityTask priority,
			LocalDateTime startDate, LocalDateTime endDate, int idProject, int idUser) {
		super();
		this.idTask = idTask;
		this.title = title;
		this.description = description;
		this.statut = statut;
		this.priority = priority;
		this.startDate = startDate;
		this.endDate = endDate;
		this.idProject = idProject;
		this.idUser = idUser;
	}


	public int getIdTask() {
		return idTask;
	}


	public void setIdTask(int idTask) {
		this.idTask = idTask;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public StatusTask getStatut() {
		return statut;
	}


	public void setStatut(StatusTask statut) {
		this.statut = statut;
	}


	public PriorityTask getPriority() {
		return priority;
	}


	public void setPriority(PriorityTask priorite) {
		this.priority = priorite;
	}


	public LocalDateTime getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}


	public LocalDateTime getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}


	public int getIdProject() {
		return idProject;
	}


	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}


	public int getIdUser() {
		return idUser;
	}


	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}


	@Override
	public String toString() {
		return "Task [idTask=" + idTask + ", title=" + title + ", description=" + description + ", statut=" + statut
				+ ", priority=" + priority + ", startDate=" + startDate + ", endDate=" + endDate + ", idProject="
				+ idProject + ", idUser=" + idUser + "]";
	}
	
	
	
	
}


	
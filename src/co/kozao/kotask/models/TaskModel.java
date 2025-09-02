package co.kozao.kotask.models;

import java.time.LocalDate;
//import java.sql.Date;

import co.kozao.kotask.models.enums.PriorityTask;
import co.kozao.kotask.models.enums.StatusTask;

public class TaskModel {

	private int idTask;
	private String title;
	private String description;
	private StatusTask status;
	private PriorityTask priority;
	private LocalDate startDate;
	private LocalDate endDate;
	private String projectKey;
	private String userName;
	private int idProject;
	private int idUser;

	public TaskModel() {

	}

	public TaskModel(int idTask, String title, String description, StatusTask status, PriorityTask priority,
			LocalDate startDate, LocalDate endDate, String projectKey, String userName, int idProject, int idUser) {
		super();
		this.idTask = idTask;
		this.title = title;
		this.description = description;
		this.status = status;
		this.priority = priority;
		this.startDate = startDate;
		this.endDate = endDate;
		this.projectKey = projectKey;
		this.userName = userName;
		this.idProject = idProject;
		this.idUser = idUser;
	}

	public void updateStatut() {
		LocalDate today = LocalDate.now();

		if (today.isBefore(startDate)) {
			status = StatusTask.A_FAIRE;
		} else if ((today.isEqual(startDate) || today.isAfter(startDate)) && today.isBefore(endDate)) {
			status = StatusTask.EN_COURS;
		} else if (today.isEqual(endDate) || today.isAfter(endDate)) {
			status = StatusTask.TERMINE;
		}
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

	public StatusTask getStatus() {
		return status;
	}

	public void setStatus(StatusTask status) {
		this.status = status;
	}

	public PriorityTask getPriority() {
		return priority;
	}

	public void setPriority(PriorityTask priority) {
		this.priority = priority;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getProjectKey() {
		return projectKey;
	}

	public void setProjectKey(String projectKey) {
		this.projectKey = projectKey;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

}

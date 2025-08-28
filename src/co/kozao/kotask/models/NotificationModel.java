package co.kozao.kotask.models;

import java.time.LocalDate;

public class NotificationModel{
	
	private int idNotification;
	private String message;
	private LocalDate dateCreated;
	private boolean isRead;
	private int idReceiver;
	private int idTask;
	private int idProject;
	
	
	public NotificationModel() {
	}

	public NotificationModel(int idNotification, String message, LocalDate dateCreated, boolean isRead, int idReceiver,
			int idTask, int idProject) {
		super();
		this.idNotification = idNotification;
		this.message = message;
		this.dateCreated = dateCreated;
		this.isRead = isRead;
		this.idReceiver = idReceiver;
		this.idTask = idTask;
		this.idProject = idProject;
	}

	public int getIdNotification() {
		return idNotification;
	}

	public void setIdNotification(int idNotification) {
		this.idNotification = idNotification;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public boolean isIdRead() {
		return isRead;
	}

	public void setIdRead(boolean idRead) {
		this.isRead = idRead;
	}

	public int getIdReceiver() {
		return idReceiver;
	}

	public void setIdReceiver(int idReceiver) {
		this.idReceiver = idReceiver;
	}

	public int getIdTask() {
		return idTask;
	}

	public void setIdTask(int idTask) {
		this.idTask = idTask;
	}

	public int getIdProject() {
		return idProject;
	}

	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}

	@Override
	public String toString() {
		return "Notification [idNotification=" + idNotification + ", message=" + message + ", dateCreated="
				+ dateCreated + ", idRead=" + isRead + ", idReceiver=" + idReceiver + ", idTask=" + idTask
				+ ", idProject=" + idProject + "]";
	}
	
	
	
	
	
	
	
	

}
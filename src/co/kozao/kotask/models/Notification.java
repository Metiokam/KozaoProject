package co.kozao.kotask.models;

import java.time.LocalDateTime;

public class Notification{
	
	private int idNotifications;
	private String messages;
	private String lien;
	private boolean estLu;
	private LocalDateTime date;
	
	
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Notification(int idNotifications, String messages, String lien, boolean estLu, LocalDateTime date) {
		super();
		this.idNotifications = idNotifications;
		this.messages = messages;
		this.lien = lien;
		this.estLu = estLu;
		this.date = date;
	}


	public int getIdNotifications() {
		return idNotifications;
	}


	public void setIdNotifications(int idNotifications) {
		this.idNotifications = idNotifications;
	}


	public String getMessages() {
		return messages;
	}


	public void setMessages(String messages) {
		this.messages = messages;
	}


	public String getLien() {
		return lien;
	}


	public void setLien(String lien) {
		this.lien = lien;
	}


	public boolean isEstLu() {
		return estLu;
	}


	public void setEstLu(boolean estLu) {
		this.estLu = estLu;
	}


	public LocalDateTime getDate() {
		return date;
	}


	public void setDate(LocalDateTime date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Notifications [idNotifications=" + idNotifications + ", messages=" + messages + ", lien=" + lien
				+ ", estLu=" + estLu + ", date=" + date + "]";
	}

	
	

}
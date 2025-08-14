package co.kozao.kotask.models;


import java.time.LocalDateTime;

public class Comment {
	
	private int idComments;
	private String message;
	private LocalDateTime date;
	
	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Comment(int idComments, String message, LocalDateTime date) {
		super();
		this.idComments = idComments;
		this.message = message;
		this.date = date;
	}


	public int getIdComments() {
		return idComments;
	}


	public void setIdCommets(int idCommets) {
		this.idComments = idCommets;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public LocalDateTime getDate() {
		return date;
	}


	public void setDate(LocalDateTime date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Comments [idComments=" + idComments + ", message=" + message + ", date=" + date + "]";
	}
	
	

}

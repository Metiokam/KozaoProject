package co.kozao.kotask.models;


import java.time.LocalDate;


public class CommentModel {
	
	private int idComment;
	private String message;
	private LocalDate dateCreated;
	private int idAuthor;
	private int idTask;
	
	
	public CommentModel() {
		
	}


	public CommentModel(int idComment, String message, LocalDate dateCreated, int idAuthor, int idTask) {
		super();
		this.idComment = idComment;
		this.message = message;
		this.dateCreated = dateCreated;
		this.idAuthor = idAuthor;
		this.idTask = idTask;
	}


	public int getIdComment() {
		return idComment;
	}


	public void setIdComment(int idComment) {
		this.idComment = idComment;
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


	public int getIdAuthor() {
		return idAuthor;
	}


	public void setIdAuthor(int idAuthor) {
		this.idAuthor = idAuthor;
	}


	public int getIdTask() {
		return idTask;
	}


	public void setIdTask(int idTask) {
		this.idTask = idTask;
	}


	@Override
	public String toString() {
		return "Comment [idComment=" + idComment + ", message=" + message + ", dateCreated=" + dateCreated
				+ ", idAuthor=" + idAuthor + ", idTask=" + idTask + "]";
	}
	
	
	
	
	
}
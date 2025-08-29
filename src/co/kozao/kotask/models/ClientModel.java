package co.kozao.kotask.models;

import java.time.LocalDate;

public class ClientModel {
	private int idClient;
	private String name ;
	private String email;
	private LocalDate addDate;
	
	public ClientModel() {
		
	}

	public ClientModel(int idClient, String name, String email, LocalDate addDate) {
		super();
		this.idClient = idClient;
		this.name = name;
		this.email = email;
		this.addDate = addDate;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getAddDate() {
		return addDate;
	}

	public void setAddDate(LocalDate addDate) {
		this.addDate = addDate;
	}
	
	
	

}

package co.kozao.kotask.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TeamProject {
	
	private int idProjectMenber;
	private String name;
	private LocalDateTime dateAjout;
	private LocalDateTime dateSortir;
	private List<User> members = new ArrayList<>();
	
	
	public TeamProject() {
		
			}

	public TeamProject(int idProjectMenber, String name, LocalDateTime dateAjout, LocalDateTime dateSortir,
			List<User> members) {
		
		this.idProjectMenber = idProjectMenber;
		this.name = name;
		this.dateAjout = dateAjout;
		this.dateSortir = dateSortir;
		this.members = members;
	}

	public int getIdProjectMenber() {
		return idProjectMenber;
	}

	public void setIdProjectMenber(int idProjectMenber) {
		this.idProjectMenber = idProjectMenber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(LocalDateTime dateAjout) {
		this.dateAjout = dateAjout;
	}

	public LocalDateTime getDateSortir() {
		return dateSortir;
	}

	public void setDateSortir(LocalDateTime dateSortir) {
		this.dateSortir = dateSortir;
	}

	public List<User> getMembers() {
		return members;
	}

	public void setMembers(List<User> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "TeamProject [idProjectMenber=" + idProjectMenber + ", name=" + name + ", dateAjout=" + dateAjout
				+ ", dateSortir=" + dateSortir + ", members=" + members + "]";
	}
	
	
	
	
	
	

	
	
	
	
	
    
}

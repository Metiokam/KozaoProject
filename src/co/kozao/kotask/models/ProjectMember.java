package co.kozao.kotask.models;



import java.time.LocalDateTime;

public class ProjectMember {
	
	private int idProjectMenber;
	private LocalDateTime dateAjout;
	private LocalDateTime dateSortir;
	
	
	public ProjectMember() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ProjectMember(int idProjectMenber, LocalDateTime dateAjout, LocalDateTime dateSortir) {
		super();
		this.idProjectMenber = idProjectMenber;
		this.dateAjout = dateAjout;
		this.dateSortir = dateSortir;
	}


	public int getIdProjectMenber() {
		return idProjectMenber;
	}


	public void setIdProjectMenber(int idProjectMenber) {
		this.idProjectMenber = idProjectMenber;
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


	@Override
	public String toString() {
		return "ProjectMember [idProjectMenber=" + idProjectMenber + ", dateAjout=" + dateAjout + ", dateSortir="
				+ dateSortir + "]";
	}
	
	
	
	
	
	
	
	
	
    
}

package co.kozao.kotask.models;

import java.time.LocalDate;
//import java.util.List;
import co.kozao.kotask.models.enums.ProjectStatus;

public class ProjectModel {
    private int idProject;
    private String name;           
    private String projectKey;     
    private String description;
    private LocalDate startDate;   
    private LocalDate endDate;     
    private ProjectStatus status; 
    private String projectManagerName;
    private int idProjectManager;
    private String clientName;
    private int idClient;  
   
    
	public ProjectModel() {
		
	}


	public ProjectModel(int idProject, String name, String projectKey, String description, LocalDate startDate,
			LocalDate endDate, ProjectStatus status, String projectManagerName, int idProjectManager, String clientName,
			int idClient) {
		super();
		this.idProject = idProject;
		this.name = name;
		this.projectKey = projectKey;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.projectManagerName = projectManagerName;
		this.idProjectManager = idProjectManager;
		this.clientName = clientName;
		this.idClient = idClient;
	}


	public int getIdProject() {
		return idProject;
	}


	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getProjectKey() {
		return projectKey;
	}


	public void setProjectKey(String projectKey) {
		this.projectKey = projectKey;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
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


	public ProjectStatus getStatus() {
		return status;
	}


	public void setStatus(ProjectStatus status) {
		this.status = status;
	}


	public String getProjectManagerName() {
		return projectManagerName;
	}


	public void setProjectManagerName(String projectManagerName) {
		this.projectManagerName = projectManagerName;
	}


	public int getIdProjectManager() {
		return idProjectManager;
	}


	public void setIdProjectManager(int idProjectManager) {
		this.idProjectManager = idProjectManager;
	}


	public String getClientName() {
		return clientName;
	}


	public void setClientName(String clientName) {
		this.clientName = clientName;
	}


	public int getIdClient() {
		return idClient;
	}


	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	

    
         
}




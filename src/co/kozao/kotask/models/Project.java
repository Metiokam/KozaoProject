package co.kozao.kotask.models;

import java.time.LocalDate;
import java.util.List;
//import co.kozao.kotask.models.ProjectStatus;

public class Project {
    private int id;
    private String name;           
    private String projectKey;     
    private String description;
    private LocalDate startDate;   
    private LocalDate endDate;     
    private ProjectStatus status;  

    private User projectManager;   
    private List<User> members;    
    private List<Task> task;
    
	public Project() {
		
	}

	public Project(int id, String name, String projectKey, String description, LocalDate startDate, LocalDate endDate,
			ProjectStatus status, User projectManager, List<User> members, List<Task> task) {
		super();
		this.id = id;
		this.name = name;
		this.projectKey = projectKey;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.projectManager = projectManager;
		this.members = members;
		this.task = task;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public User getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(User projectManager) {
		this.projectManager = projectManager;
	}

	public List<User> getMembers() {
		return members;
	}

	public void setMembers(List<User> members) {
		this.members = members;
	}

	public List<Task> getTask() {
		return task;
	}

	public void setTask(List<Task> task) {
		this.task = task;
	}  
    
    
	
    
         
}




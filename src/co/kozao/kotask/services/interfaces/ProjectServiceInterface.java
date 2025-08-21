package co.kozao.kotask.services.interfaces;


import java.util.List;

import co.kozao.kotask.models.Project;

public interface ProjectServiceInterface {
	
	List<Project> getAllProjects();
    Project getProjectById(int id);
    Project createProject(Project project);
    boolean updateProject(Project project);
    boolean deleteProject(int id);

}

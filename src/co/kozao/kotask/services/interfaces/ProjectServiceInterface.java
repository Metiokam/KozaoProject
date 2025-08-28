package co.kozao.kotask.services.interfaces;


import java.util.List;

import co.kozao.kotask.models.ProjectModel;

public interface ProjectServiceInterface {
	
	List<ProjectModel> getAllProjects();
    ProjectModel getProjectById(int id);
    ProjectModel createProject(ProjectModel project);
    boolean updateProject(ProjectModel project);
    boolean deleteProject(int id);

}

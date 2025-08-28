package co.kozao.kotask.services.interfaces;


import java.sql.SQLException;
import java.util.List;

import co.kozao.kotask.models.ProjectModel;

public interface ProjectServiceInterface {
	
	List<ProjectModel> getAllProjects()throws SQLException;
    ProjectModel getProjectById(int id)throws SQLException;
    ProjectModel createProject(ProjectModel project) throws SQLException;
    boolean updateProject(ProjectModel project) throws SQLException;
    boolean deleteProject(int id)throws SQLException;

}

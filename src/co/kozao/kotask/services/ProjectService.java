package co.kozao.kotask.services;

import java.util.List;

import co.kozao.kotask.models.Project;

public interface ProjectService {

	List<Project> getAllProjects();
    Project getProjectById(int id);
    void createProject(Project project);
    void updateProject(int id, Project project);
    boolean deleteProject(int id);
}

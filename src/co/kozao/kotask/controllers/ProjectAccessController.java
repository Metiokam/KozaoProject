package co.kozao.kotask.controllers;

import java.time.LocalDate;
import java.util.List;

import org.apache.log4j.Logger;

import co.kozao.kotask.models.ProjectModel;
import co.kozao.kotask.models.enums.ProjectStatus;
import co.kozao.kotask.services.ProjectService;
import co.kozao.kotask.services.interfaces.ProjectServiceInterface;
import co.kozao.kotask.utils.actionvalidation.ProjectActionValidationUtils;

public class ProjectAccessController {
	private ProjectServiceInterface projectService = new ProjectService();
	private static final Logger LOGGER = Logger.getLogger(ProjectAccessController.class);

	public ProjectModel createProject(String name, String projectKey, String description, LocalDate startDate,
			LocalDate endDate, ProjectStatus status, String projectManagerName, String clientName) {
		ProjectModel project = new ProjectModel();
		project.setName(name);
		project.setProjectKey(projectKey);
		project.setDescription(description);
		project.setStartDate(startDate);
		project.setEndDate(endDate);
		project.setStatus(status);
		project.setProjectManagerName(projectManagerName);
		project.setClientName(clientName);

		LOGGER.info("Tentative de création du projet : " + project);

		try {

			ProjectActionValidationUtils.validate(project);

			ProjectModel createdProject = projectService.createProject(project);

			if (createdProject != null) {
				LOGGER.info("Projet créé avec succès : " + createdProject);
			} else {
				LOGGER.error("Le service n'a pas pu créer le projet, résultat null.");
			}

			return createdProject;

		} catch (Exception e) {
			LOGGER.error("Erreur lors de la création du projet : " + e.getMessage());
			return null;
		}
	}

	public boolean updateProject(ProjectModel project) {
		try {
			ProjectActionValidationUtils.validate(project);
			return projectService.updateProject(project);
		} catch (Exception e) {
			LOGGER.error("Erreur lors de la modification du projet : " + e.getMessage());
			return false;
		}
	}

	public boolean deleteProject(int idProject) {
		try {
			if (ProjectActionValidationUtils.validateidProject(idProject)) {
				return false;
			}
			return projectService.deleteProject(idProject);

		} catch (Exception e) {
			LOGGER.error("Erreur lors de la suppression du projet : " + e.getMessage(), e);
			return false;
		}
	}

	public ProjectModel getProjectById(int idProject) {
		try {
			return projectService.getProjectById(idProject);
		} catch (Exception e) {
			LOGGER.error("Erreur lors de la récupération du projet avec ID " + idProject + " : " + e.getMessage());
			return null;
		}
	}

	public List<ProjectModel> getAllProjects() {
		try {
			return projectService.getAllProjects();
		} catch (Exception e) {
			LOGGER.error("Erreur lors de la récupération de la liste des projets : " + e.getMessage());
			return null;
		}
	}
}

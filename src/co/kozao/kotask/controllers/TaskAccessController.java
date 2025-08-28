package co.kozao.kotask.controllers;

import java.time.LocalDate;

import java.util.List;

import org.apache.log4j.Logger;

import co.kozao.kotask.models.TaskModel;
import co.kozao.kotask.models.enums.PriorityTask;
import co.kozao.kotask.models.enums.StatusTask;
import co.kozao.kotask.services.TaskService;
import co.kozao.kotask.services.interfaces.TaskServiceInterface;


public class TaskAccessController {

	private TaskServiceInterface taskService = new TaskService();
	private static final Logger LOGGER = Logger.getLogger(TaskAccessController.class);

	public TaskModel createTask(String title, String description, StatusTask status, PriorityTask priority,
			LocalDate startDate, LocalDate endDate, String projectKey, String userName) {
		TaskModel task = new TaskModel();
		task.setTitle(title);
		task.setDescription(description);
		task.setStatus(status);
		task.setPriority(priority);
		task.setStartDate(startDate);
		task.setEndDate(endDate);
		task.setProjectKey(projectKey);;
		task.setUserName(userName);

		try {

			// ProjectActionValidationUtils.validate(task);

			TaskModel createTask = taskService.createTask(task);

			if (createTask != null) {
				LOGGER.info("Tache créé avec succès : " + createTask);
			} else {
				LOGGER.error("Le service n'a pas pu créer la tache, résultat null.");
			}

			return createTask;

		} catch (Exception e) {
			LOGGER.error("Erreur lors de la création de la tache : " + e.getMessage());
			return null;
		}
	}

	public boolean updateTask(TaskModel task) {
		try {
			return taskService.updateTask(task);
		} catch (Exception e) {
			LOGGER.error("Erreur lors de la modification de la tache : " + e.getMessage());
			return false;
		}

	}

	public boolean deleteTask(int idTask) {
		try {
			return taskService.deleteTask(idTask);
		} catch (Exception e) {
			LOGGER.error("Erreur lors de la suppresion de la tache : " + e.getMessage());
		}
		return false;
	}

	public List<TaskModel> getAllTask() {
		try {
			return taskService.getAllTask();
		} catch (Exception e) {
			LOGGER.error("Erreur lors de l'affichage de la liste des taches  : " + e.getMessage());
			return null;
		}
	}

	public TaskModel getTaskById(int idTask) {
		try {
			return taskService.getTaskById(idTask);

		} catch (Exception e) {
			LOGGER.error("Erreur lors de la recuperation de l'identifiant de la tache : " + e.getMessage());
			return null;
		}

	}

}

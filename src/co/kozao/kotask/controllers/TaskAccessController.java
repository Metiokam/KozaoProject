package co.kozao.kotask.controllers;

//import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;
import co.kozao.kotask.models.Task;
import co.kozao.kotask.models.enums.PriorityTask;
import co.kozao.kotask.models.enums.StatusTask;
import co.kozao.kotask.services.implement.TaskService;
import co.kozao.kotask.services.interfaces.TaskServiceInterface;


public class TaskAccessController {

	private TaskServiceInterface taskService = new TaskService();
	private static final Logger LOGGER = Logger.getLogger(ProjectAccessController.class);

	public Task createTask( String title, String description, StatusTask statut, PriorityTask priority,
			LocalDateTime startDate, LocalDateTime endDate, int idProject, int idUser) {
		Task task = new Task();
		task.setTitle(title);
		task.setDescription(description);
		task.setStatut(statut);
		task.setPriority(priority);
		task.setDescription(description);
		task.setStartDate(startDate);
		task.setEndDate(endDate);
		task.setIdProject(idProject);
		task.setIdUser(idUser);

		try {

			// ProjectActionValidationUtils.validate(task);

			return taskService.createTask(task);

		} catch (Exception e) {
			LOGGER.error("Erreur lors de la création de la tache : " + e.getMessage());
			return null;
		}
	}

	public boolean updateTask(Task task) {
		try {
			return taskService.updateTask(task);
		} catch (Exception e) {
			LOGGER.error("Erreur lors de la modification de l'identifiant de l'utilisateur : " + e.getMessage());
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

	public List<Task> getAllTask() {
		try {
			return taskService.getAllTask();
		} catch (Exception e) {
			LOGGER.error("Erreur lors de l'affichage de la liste des taches  : " + e.getMessage());
			return null;
		}
	}
	
	public Task getTaskById(int idTask) {
		try {
			return taskService.getTaskById(idTask);
			
		}catch(Exception e) {
			LOGGER.error("Erreur lors de la recuperation de l'identifiant de la tache : " + e.getMessage());
			return null;
		}
		
		
	}


}

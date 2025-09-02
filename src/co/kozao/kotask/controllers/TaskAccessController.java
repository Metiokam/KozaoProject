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

    private final TaskServiceInterface taskService;
    private static final Logger LOGGER = Logger.getLogger(TaskAccessController.class);

    public TaskAccessController() {
        this.taskService = new TaskService(); 
    }

    public TaskModel createTask(String title, String description, StatusTask status, PriorityTask priority,
                                LocalDate startDate, LocalDate endDate, String projectKey, String userName) {
        try {
            TaskModel task = new TaskModel();
            task.setTitle(title);
            task.setDescription(description);
            task.setStatus(status);
            task.setPriority(priority);
            task.setStartDate(startDate);
            task.setEndDate(endDate);
            task.setProjectKey(projectKey);
            task.setUserName(userName);

            TaskModel createdTask = taskService.createTask(task);

            if (createdTask != null) {
                LOGGER.info("Tâche créée avec succès : " + createdTask);
            }
            return createdTask;

        } catch (Exception e) {
            LOGGER.error("Erreur lors de la création de la tâche : " + e.getMessage(), e);
            return null;
        }
    }

    public boolean updateTask(TaskModel task) {
        try {
            return taskService.updateTask(task);
        } catch (Exception e) {
            LOGGER.error("Erreur lors de la modification de la tâche : " + e.getMessage(), e);
            return false;
        }
    }

    public boolean deleteTask(int idTask) {
        try {
            return taskService.deleteTask(idTask);
        } catch (Exception e) {
            LOGGER.error("Erreur lors de la suppression de la tâche : " + e.getMessage(), e);
            return false;
        }
    }

    public List<TaskModel> getAllTask() {
        try {
            return taskService.getAllTask();
        } catch (Exception e) {
            LOGGER.error("Erreur lors de l'affichage des tâches : " + e.getMessage(), e);
            return null;
        }
    }

    public TaskModel getTaskById(int idTask) {
        try {
            return taskService.getTaskById(idTask);
        } catch (Exception e) {
            LOGGER.error("Erreur lors de la récupération de la tâche : " + e.getMessage(), e);
            return null;
        }
    }

    public void majStatuts() {
        try {
            taskService.mettreAJourStatuts();
        } catch (Exception e) {
            LOGGER.error("Erreur lors de la mise à jour automatique des statuts : " + e.getMessage(), e);
        }
    }
}

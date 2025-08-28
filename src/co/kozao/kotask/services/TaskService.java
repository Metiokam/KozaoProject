package co.kozao.kotask.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import co.kozao.kotask.models.TaskModel;
import co.kozao.kotask.models.enums.PriorityTask;
import co.kozao.kotask.models.enums.StatusTask;
import co.kozao.kotask.services.connexion.DBConnection;
import co.kozao.kotask.services.interfaces.TaskServiceInterface;
import co.kozao.kotask.utils.Contants;

public class TaskService implements TaskServiceInterface {

	private static final Logger LOGGER = Logger.getLogger(UserService.class);
	private Connection con = DBConnection.getConnection();
	private final String TABLE_NAME = "task";

	@Override
	public TaskModel createTask(TaskModel task) {
		String query = String.format(Contants.CREATED_TASKS, TABLE_NAME, "title", "description", "status", "priority",
				"startDate", "endDate", "idProject", "idUser");
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, task.getTitle());
			ps.setString(2, task.getDescription());
			ps.setString(3, task.getStatus().name());
			ps.setString(4, task.getPriority().name());
			ps.setObject(5, task.getStartDate());
			ps.setObject(6, task.getEndDate());
			ps.setInt(7, task.getIdProject());
			ps.setInt(8, task.getIdUser());

			if (ps.executeUpdate() > 0) {
				
				return task;

			}

		} catch (SQLException e) {
			LOGGER.error("Erreur lors de la creation de la tache " + e.getMessage());
		}
		return null;

	}

	@Override
	public boolean updateTask(TaskModel task) {

		String query = String.format(Contants.UPDATE_TASKS, TABLE_NAME, "title", "description", "status", "priority",
				"startDate", "endDate", "idProject", "idUser","idTask");
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, task.getTitle());
			ps.setString(2, task.getDescription());
			ps.setString(3, task.getStatus().name());
			ps.setString(4, task.getPriority().name());
			ps.setObject(5, task.getStartDate());
			ps.setObject(6, task.getEndDate());
			ps.setInt(7, task.getIdProject());
			ps.setInt(8, task.getIdUser());
			ps.setInt(9, task.getIdTask());

			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			LOGGER.error("Erreur lors de la modifaication d'un projet :" + e.getMessage());

		}
		return false;
	}

	@Override
	public boolean deleteTask(int idTask) {

		String query = String.format(Contants.DELETE_TASKS, TABLE_NAME, "idTask");
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, idTask);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			LOGGER.error("Erreur lors de la suppresion de la tache : " + e.getMessage());
			return false;
		}
	}

	@Override
	public List<TaskModel> getAllTask() {
		List<TaskModel> tasks = new ArrayList<>();
		String query = String.format(Contants.GET_ALL_TASKS, TABLE_NAME);
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				TaskModel task = new TaskModel();
				task.setIdTask(rs.getInt("idTask"));
				task.setTitle(rs.getString("title"));
				task.setDescription(rs.getString("description"));
				task.setStatus(StatusTask.valueOf(rs.getString("status")));
				task.setPriority(PriorityTask.valueOf(rs.getString("priority")));
				task.setStartDate(rs.getObject("startDate", LocalDate.class));
				task.setEndDate(rs.getObject("endDate", LocalDate.class));
				task.setIdProject(rs.getInt("idProject"));
				task.setIdUser(rs.getInt("idUser"));
				
				tasks.add(task);
			}
		} catch (Exception e) {
			LOGGER.error("Erreur lors de l'affichage de tous les taches : " + e.getMessage());
		}
		return tasks;
	}

	@Override
	public TaskModel getTaskById(int idTask) {

		String query = String.format(Contants.GET_TASKS_BY_ID, TABLE_NAME, "idTask");

		try (PreparedStatement ps = con.prepareStatement(query)) {

			ps.setInt(1, idTask);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TaskModel task = new TaskModel();
				task.setIdTask(rs.getInt("idTask"));
				task.setTitle(rs.getString("title"));
				task.setDescription(rs.getString("description"));
				task.setStatus(StatusTask.valueOf(rs.getString("status")));
				task.setPriority(PriorityTask.valueOf(rs.getString("priority")));
				task.setStartDate(rs.getObject("startDate", LocalDate.class));
				task.setEndDate(rs.getObject("endDate", LocalDate.class));
				task.setIdProject(rs.getInt("idProject"));
				task.setIdUser(rs.getInt("idUser"));
				
				return task;

			}
		} catch (SQLException e) {
			LOGGER.error("Erreur lors de la recuperation de l'identifiant de l'utilisateur : " + e.getMessage());
		}
		return null;
	}

}

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

	private static final Logger LOGGER = Logger.getLogger(TaskService.class);
	private final Connection con = DBConnection.getConnection();
	private final String TABLE_NAME = "task";
	private final TaskScheduler scheduler;

	public TaskService() {
		this.scheduler = new TaskScheduler(this);
		this.scheduler.demarrer();
	}

	@Override
	public TaskModel createTask(TaskModel task) throws SQLException {
		task.setIdUser(getUserIdByName(task.getUserName()));
		task.setIdProject(getProjectIdByProjectKey(task.getProjectKey()));

		String query = String.format(Contants.CREATED_TASKS, TABLE_NAME, "title", "description", "status", "priority",
				"startDate", "endDate", "idProject", "idUser");
		try (PreparedStatement ps = con.prepareStatement(query)) {
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
			LOGGER.error("Erreur lors de la création de la tache : " + e.getMessage(), e);
		}
		return null;
	}

	@Override
	public boolean updateTask(TaskModel task) throws SQLException {
		task.setIdUser(getUserIdByName(task.getUserName()));
		task.setIdProject(getProjectIdByProjectKey(task.getProjectKey()));

		String query = String.format(Contants.UPDATE_TASKS, TABLE_NAME, "title", "description", "status", "priority",
				"startDate", "endDate", "idProject", "idUser", "idTask");
		try (PreparedStatement ps = con.prepareStatement(query)) {
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
		} catch (SQLException e) {
			LOGGER.error("Erreur lors de la modification de la tache : " + e.getMessage(), e);
		}
		return false;
	}

	@Override
	public boolean deleteTask(int idTask) throws SQLException {
		String query = String.format(Contants.DELETE_TASKS, TABLE_NAME, "idTask");
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, idTask);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			LOGGER.error("Erreur lors de la suppression de la tache : " + e.getMessage(), e);
			return false;
		}
	}

	@Override
	public List<TaskModel> getAllTask() throws SQLException {
		List<TaskModel> tasks = new ArrayList<>();
		String query = String.format(Contants.GET_ALL_TASKS, TABLE_NAME, "project", "users");
		try (PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				TaskModel task = new TaskModel();
				task.setIdTask(rs.getInt("idTask"));
				task.setTitle(rs.getString("title"));
				task.setDescription(rs.getString("description"));
				task.setStatus(StatusTask.valueOf(rs.getString("status")));
				task.setPriority(PriorityTask.valueOf(rs.getString("priority")));
				task.setStartDate(rs.getObject("startDate", LocalDate.class));
				task.setEndDate(rs.getObject("endDate", LocalDate.class));
				task.setProjectKey(rs.getString("projectKey"));
				task.setUserName(rs.getString("userName"));
				tasks.add(task);
			}
		} catch (SQLException e) {
			LOGGER.error("Erreur lors de l'affichage de tous les taches : " + e.getMessage(), e);
		}
		return tasks;
	}

	@Override
	public TaskModel getTaskById(int idTask) throws SQLException {
		String query = String.format(Contants.GET_TASKS_BY_ID, TABLE_NAME, "idTask");
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, idTask);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
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
			}
		} catch (SQLException e) {
			LOGGER.error("Erreur lors de la récupération de la tâche : " + e.getMessage(), e);
		}
		return null;
	}

	public int getUserIdByName(String name) throws SQLException {
		String query = "SELECT idUser FROM users WHERE name = ?";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, name);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return rs.getInt("idUser");
				}
			}
		}
		throw new SQLException("Aucun utilisateur trouvé avec ce nom : " + name);
	}

	public int getProjectIdByProjectKey(String projectKey) throws SQLException {
		String query = "SELECT idProject FROM project WHERE projectKey = ?";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, projectKey);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return rs.getInt("idProject");
				}
			}
		}
		throw new SQLException("Aucun projet trouvé avec cette clé : " + projectKey);
	}

	public boolean updateTaskStatut(TaskModel task) throws SQLException {
		String query = String.format(Contants.UPDATE_STATUS, TABLE_NAME, "status", "idTask");
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, task.getStatus().name());
			ps.setInt(2, task.getIdTask());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// LOGGER.error("Erreur lors de la modification du statut de la tache : " +
			// e.getMessage(), e);
		}
		return false;
	}

	@Override
	public void mettreAJourStatuts() {
		int nbUpdates = 0;
		try {
			List<TaskModel> tasks = getAllTask();
			for (TaskModel task : tasks) {
				StatusTask ancien = task.getStatus();
				task.updateStatut();
				if (!ancien.equals(task.getStatus())) {
					updateTaskStatut(task);
					nbUpdates++;
					// LOGGER.info("Mise à jour : " + task.getTitle() + " " + task.getStatus());
				}
			}
			if (nbUpdates > 0) {
				// LOGGER.info("Mises à jour effectuées sur " + nbUpdates + " tâche(s).");
			} else {
				// LOGGER.info("Aucune tâche mise à jour.");
			}
		} catch (SQLException e) {
			// LOGGER.error("Erreur lors de la mise à jour des statuts : " + e.getMessage(),
			// e);
		}
	}
}

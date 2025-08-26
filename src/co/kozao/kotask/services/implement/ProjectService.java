package co.kozao.kotask.services.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import co.kozao.kotask.models.Project;
import co.kozao.kotask.models.enums.ProjectStatus;
import co.kozao.kotask.services.interfaces.ProjectServiceInterface;
import co.kozao.kotask.services.connexion.DBConnection;
import co.kozao.kotask.utils.Contants;

public class ProjectService implements ProjectServiceInterface {

	private static final Logger LOGGER = Logger.getLogger(ProjectService.class);
	private Connection con = DBConnection.getConnection();
	private final String TABLE_NAME = "project";

	@Override
	public List<Project> getAllProjects() {

		List<Project> project = new ArrayList<>();
		String query = String.format(Contants.GET_ALL_PROJECTS, TABLE_NAME);
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Project project1 = new Project();

				project1.setIdProject(rs.getInt("idProject"));
				project1.setName(rs.getString("name"));
				project1.setProjectKey(rs.getString("projectKey"));
				project1.setDescription(rs.getString("description"));
				project1.setStartDate(rs.getObject("startDate", LocalDate.class));
				project1.setEndDate(rs.getObject("endDate", LocalDate.class));
				project1.setStatus(ProjectStatus.valueOf(rs.getString("status")));
				project1.setIdProjectManager(rs.getInt("projectManagerId"));

				project.add(project1);
			}

		} catch (SQLException e) {
			LOGGER.error("Erreur lors de recuperation de la liste des projets: " + e.getMessage());
		}
		return project;
	}

	@Override
	public Project createProject(Project project) {

		String query = String.format(Contants.CREATED_PROJECTS, TABLE_NAME, "name", "projectKey", "description",
				"startDate", "endDate", "status", "projectManagerId");
		try {
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, project.getName());
			ps.setString(2, project.getProjectKey());
			ps.setString(3, project.getDescription());
			ps.setObject(4, project.getStartDate());
			ps.setObject(5, project.getEndDate());
			ps.setString(6, project.getStatus().name());
			ps.setInt(7, project.getIdProjectManager());
			

			if (ps.executeUpdate() > 0) {

				return project;
			}

		} catch (SQLException e) {
			LOGGER.error("Erreur lors de la creation du projet " , e);
		}
		return null;

	}

	@Override
	public boolean updateProject(Project project) {

		String query = String.format(Contants.UPDATE__PROJECTS, TABLE_NAME, "name", "projectKey", "description",
				"startDate", "endDate", "status", "projectManagerId");
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, project.getName());
			ps.setString(2, project.getProjectKey());
			ps.setString(3, project.getDescription());
			ps.setObject(4, project.getStartDate());
			ps.setObject(5, project.getEndDate());
			ps.setString(6, project.getStatus().name());
			ps.setInt(7, project.getIdProjectManager());
			ps.setInt(8, project.getIdProject());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			LOGGER.error("Erreur lors de la modification du projet : " + e.getMessage());
		}
		return false;
	}

	@Override
	public boolean deleteProject(int idProject) {

		String query = String.format(Contants.DELETE__PROJECTS, TABLE_NAME, "idProject");
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, idProject);
			
			return ps.executeUpdate() > 0;
			
		} catch (SQLException e) {
			LOGGER.error("Erreur lors de la suppression d'un project : " + e.getMessage());
		}
		return false;
	}

	@Override
	public Project getProjectById(int idProject) {
		String query = String.format(Contants.GET_PROJECT_BY_ID, TABLE_NAME, "idProject");

		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, idProject);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Project project = new Project();
				project.setIdProject(rs.getInt("idProject"));
				project.setName(rs.getString("name"));
				project.setProjectKey(rs.getString("projectKey"));
				project.setDescription(rs.getString("description"));
				project.setStartDate(rs.getObject("startDate", LocalDate.class));
				project.setEndDate(rs.getObject("endDate", LocalDate.class));
				project.setStatus(ProjectStatus.valueOf(rs.getString("status")));
				project.setIdProjectManager(rs.getInt("projectManagerId"));
				return project;
			}

		} catch (SQLException e) {
			LOGGER.error("Erreur lors de la r�cup�ration du projet par ID : " + e.getMessage());
		}

		return null;
	}

}

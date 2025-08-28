package co.kozao.kotask.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import co.kozao.kotask.models.CommentModel;
import co.kozao.kotask.services.connexion.DBConnection;
import co.kozao.kotask.services.interfaces.CommentServiceInterface;
import co.kozao.kotask.utils.Contants;

public class CommentService implements CommentServiceInterface {

	private static final Logger LOGGER = Logger.getLogger(CommentService.class);
	private Connection con = DBConnection.getConnection();
	private final String TABLE_NAME = "comment";

	@Override
	public CommentModel createComment(CommentModel comment) {

		String query = String.format(Contants.CREATED_COMMENTS, TABLE_NAME, "message", "dateCreated",
				"idAuthor", "idTask");
		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, comment.getMessage());
			ps.setObject(2, comment.getDateCreated());
			ps.setInt(3, comment.getIdAuthor());
			ps.setInt(4, comment.getIdTask());

			if (ps.executeUpdate() > 0) {

				return comment;
			}

		} catch (SQLException e) {
			LOGGER.error("Erreur lors de la creation du commentaire ", e);
		}

		return null;
	}

	@Override
	public boolean updateComment(CommentModel comment) {

		String query = String.format(Contants.UPDATE_COMMENTS, TABLE_NAME, "message", "dateCreated",
				"idAuthor", "idTask", "idComment");

		try (PreparedStatement ps = con.prepareStatement(query)) {

			ps.setString(1, comment.getMessage());
			ps.setObject(2, comment.getDateCreated());
			ps.setInt(3, comment.getIdAuthor());
			ps.setInt(4, comment.getIdTask());
			ps.setInt(5, comment.getIdComment());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			LOGGER.error("Erreur lors de la modification du commentaire : " + e.getMessage());
		}

		return false;
	}

	@Override
	public boolean deleteComment(int idComment) {
		String query = String.format(Contants.DELETE_COMMENTS, TABLE_NAME, "idComment");
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, idComment);

			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			LOGGER.error("Erreur lors de la suppression d'un project : " + e.getMessage());
		}
		return false;
	}

	@Override
	public CommentModel getCommentById(int idComment) {
		String query = String.format(Contants.GET_COMMENTS_BY_ID, TABLE_NAME, "idComment");

		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, idComment);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				CommentModel comment = new CommentModel();
				comment.setIdComment(rs.getInt("idComment"));
				comment.setMessage(rs.getString("message"));
				comment.setDateCreated(rs.getObject("dateCreated", LocalDate.class));
				comment.setIdAuthor(rs.getInt("idAuthor"));
				comment.setIdTask(rs.getInt("idTask"));

				return comment;
			}

		} catch (SQLException e) {
			LOGGER.error("Erreur lors de la récupération du projet par ID : " + e.getMessage());
		}

		return null;
	}

	@Override
	public List<CommentModel> getAllComment() {
		List<CommentModel> comment = new ArrayList<>();
		String query = String.format(Contants.GET_ALL_COMMENTS, TABLE_NAME);
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CommentModel comments = new CommentModel();

				comments.setIdComment(rs.getInt("idComment"));
				comments.setMessage(rs.getString("message"));
				comments.setDateCreated(rs.getObject("datecreated", LocalDate.class));
				comments.setIdAuthor(rs.getInt("idAuthor"));
				comments.setIdTask(rs.getInt("idTask"));

				comment.add(comments);
			}

		} catch (SQLException e) {
			LOGGER.error("Erreur lors de recuperation de la liste des projets: " + e.getMessage());
		}
		return comment;
	}

}

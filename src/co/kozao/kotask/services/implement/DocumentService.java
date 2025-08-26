package co.kozao.kotask.services.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import co.kozao.kotask.models.Document;
import co.kozao.kotask.services.connexion.DBConnection;
import co.kozao.kotask.services.interfaces.DocumentServiceInterface;
import co.kozao.kotask.utils.Contants;

public class DocumentService implements DocumentServiceInterface {

	private static final Logger LOGGER = Logger.getLogger(CommentService.class);
	private Connection con = DBConnection.getConnection();
	private final String TABLE_NAME = "document";

	@Override
	public Document addDocument(Document document) {
		String query = String.format(Contants.CREATED_DOCUMENTS, TABLE_NAME, "documentName", "documentPath",
				"dateAdded", "idAuthor", "idProject", "idTask");

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, document.getDocumentName());
			ps.setString(2, document.getDocumentPath());
			ps.setObject(3, document.getDateAdded());
			ps.setInt(4, document.getIdAuthor());
			ps.setInt(5, document.getIdProject());
			ps.setInt(6, document.getIdTask());

			if (ps.executeUpdate() > 0) {

				return document;
			}
		} catch (SQLException e) {
			LOGGER.error("Erreur lors de l'ajout du document ", e);
		}
		return null;
	}

	@Override
	public boolean deleteDocument(int idDocument) {
		String query = String.format(Contants.DELETE_DOCUMENTS, TABLE_NAME, "idDocument");
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, idDocument);

			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			LOGGER.error("Erreur lors de la suppression d'un project : " + e.getMessage());
		}
		return false;
	}

	@Override
	public List<Document> getAllDocument() {

		List<Document> documents = new ArrayList<>();
		String query = String.format(Contants.GET_ALL_DOCUMENTS, TABLE_NAME);
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Document document = new Document();
				document.setIdDocument(rs.getInt("idDocument"));
				document.setDocumentName(rs.getString("documentName"));
				document.setDocumentPath(rs.getString("documentPath"));
				document.setDateAdded(rs.getObject("dateAdded", LocalDate.class));
				document.setIdAuthor(rs.getInt("idAuthor"));
				document.setIdProject(rs.getInt("idProject"));
				document.setIdTask(rs.getInt("idTask"));

				documents.add(document);
			}

		} catch (SQLException e) {
			LOGGER.error("Erreur lors de recuperation de la liste des documents: " + e.getMessage());
		}
		return documents;
	}

	@Override
	public Document getDocumentById(int idDocument) {
		String query = String.format(Contants.GET_DOCUMENTS_BY_ID, TABLE_NAME, "idDocument");

		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, idDocument);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				Document document = new Document();
				document.setIdDocument(rs.getInt("idDocument"));
				document.setDocumentName(rs.getString("documentName"));
				document.setDocumentPath(rs.getString("documentPath"));
				document.setDateAdded(rs.getObject("dateAdded", LocalDate.class));
				document.setIdAuthor(rs.getInt("idAuthor"));
				document.setIdProject(rs.getInt("idProject"));
				document.setIdTask(rs.getInt("idTask"));

				return document;
			}

		} catch (SQLException e) {
			LOGGER.error("Erreur lors de la récupération des document par ID : " + e.getMessage());
		}

		return null;
	}

}

package co.kozao.kotask.controllers;

import java.time.LocalDate;
import java.util.List;

import org.apache.log4j.Logger;

import co.kozao.kotask.models.Comment;
import co.kozao.kotask.services.implement.CommentService;
import co.kozao.kotask.services.interfaces.CommentServiceInterface;


public class CommentAccesController {

	private CommentServiceInterface commentService = new CommentService();
	private static final Logger LOGGER = Logger.getLogger(CommentAccesController.class);

	public Comment createComment(String message, LocalDate datecreated, int idAuthor, int idTask) {

		Comment comment = new Comment();
		comment.setMessage(message);
		comment.setDateCreated(datecreated);
		comment.setIdAuthor(idAuthor);
		comment.setIdTask(idTask);

		LOGGER.info("Tentative de création du projet : " + comment);

		try {

			// ProjectActionValidationUtils.validate(comment);

			Comment createComment = commentService.createComment(comment);

			if (createComment != null) {
				LOGGER.info("Commentaire créé avec succès : " + createComment);
			} else {
				LOGGER.error("Le service n'a pas pu créer le commentaire, résultat null.");
			}

			return createComment;

		} catch (Exception e) {
			LOGGER.error("Erreur lors de la création du commentaire : " + e.getMessage());
			return null;
		}
	}

	public boolean updateComment(Comment comment) {

		try {

			// ProjectActionValidationUtils.validate(comment);

			return commentService.updateComment(comment);

		} catch (Exception e) {
			LOGGER.error("Erreur lors de la modification du commentaire : " + e.getMessage());
			return false;
		}
	}

	public boolean deleteComment(int idComment) {
		try {
			commentService.deleteComment(idComment);

			return true;

		} catch (Exception e) {
			LOGGER.error("Erreur lors de la suppression du commentaire : " + e.getMessage(), e);
			return false;
		}
	}

	public Comment getCommentById(int idComment) {
		try {
			return commentService.getCommentById(idComment);

		} catch (Exception e) {
			LOGGER.error("Erreur lors de la récupération du commentaire avec identifiant " + idComment + " : "
					+ e.getMessage());
			return null;
		}
	}

	public List<Comment> getAllComment() {
		try {
			return commentService.getAllComment();

		} catch (Exception e) {

			LOGGER.error("Erreur lors de la récupération de la liste des commentaires : " + e.getMessage());

			return null;
		}
	}
}

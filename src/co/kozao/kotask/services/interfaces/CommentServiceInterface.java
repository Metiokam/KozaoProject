package co.kozao.kotask.services.interfaces;

import java.util.List;

import co.kozao.kotask.models.CommentModel;

public interface CommentServiceInterface {
	
	List<CommentModel> getAllComment();
	CommentModel getCommentById(int id);
	CommentModel createComment(CommentModel comment);
    boolean updateComment(CommentModel comment);
    boolean deleteComment(int id);

}

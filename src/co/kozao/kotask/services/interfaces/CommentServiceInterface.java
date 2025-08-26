package co.kozao.kotask.services.interfaces;

import java.util.List;

import co.kozao.kotask.models.Comment;

public interface CommentServiceInterface {
	
	List<Comment> getAllComment();
	Comment getCommentById(int id);
	Comment createComment(Comment comment);
    boolean updateComment(Comment comment);
    boolean deleteComment(int id);

}

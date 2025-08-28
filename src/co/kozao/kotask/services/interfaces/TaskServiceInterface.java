package co.kozao.kotask.services.interfaces;

import java.sql.SQLException;
import java.util.List;

//import co.kozao.kotask.models.Project;
import co.kozao.kotask.models.TaskModel;

public interface TaskServiceInterface {
	
	TaskModel createTask(TaskModel task) throws SQLException;
	boolean updateTask(TaskModel task)throws SQLException;
	boolean deleteTask(int idTask)throws SQLException;
	List<TaskModel> getAllTask()throws SQLException;
    TaskModel getTaskById(int task)throws SQLException;

}

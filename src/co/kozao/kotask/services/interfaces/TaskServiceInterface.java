package co.kozao.kotask.services.interfaces;

import java.util.List;

//import co.kozao.kotask.models.Project;
import co.kozao.kotask.models.TaskModel;

public interface TaskServiceInterface {
	
	TaskModel createTask(TaskModel task);
	boolean updateTask(TaskModel task);
	boolean deleteTask(int idTask);
	List<TaskModel> getAllTask();
    TaskModel getTaskById(int task);

}

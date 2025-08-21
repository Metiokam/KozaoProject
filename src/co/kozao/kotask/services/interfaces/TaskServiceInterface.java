package co.kozao.kotask.services.interfaces;

import java.util.List;

//import co.kozao.kotask.models.Project;
import co.kozao.kotask.models.Task;

public interface TaskServiceInterface {
	
	Task createTask(Task task);
	boolean updateTask(Task task);
	boolean deleteTask(int idTask);
	List<Task> getAllTask();
    Task getTaskById(int task);

}

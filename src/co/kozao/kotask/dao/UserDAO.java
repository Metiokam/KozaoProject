package co.kozao.kotask.dao;

import co.kozao.kotask.models.User;
import java.util.List;

public interface UserDAO {
	
	User getUserById(int idUser);
	
	User findByEmail(String email);

	User createUser(User user);

	boolean updateUser(User user);

	boolean deleteUser(int idUser);

	List<User> getAllUsers();

	//User authenticate(String email, String password);
}

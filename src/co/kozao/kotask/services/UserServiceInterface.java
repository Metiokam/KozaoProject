package co.kozao.kotask.services;

import co.kozao.kotask.models.User;

import java.util.List;

public interface UserServiceInterface {
	
	User createUser(User user);

	User authenticate(String email, String password);

	User getUserById(int idUser);

	boolean updateUser(User user);

	boolean deleteUser(int idUser);

	List<User> getAllUsers();
}

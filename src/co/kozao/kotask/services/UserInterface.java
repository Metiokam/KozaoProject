package co.kozao.kotask.services;

import java.util.List;

import co.kozao.kotask.models.User;

public interface UserInterface{

	public User createUser(User user);

	public boolean updateUser(User user);

	public boolean deleteUser(int idUser);

	public List<User> getAllUsers();
	
	public User getUserById(int idUser);

	void findUserById(User idUser);
	
	public User authenticate(String email, String password);

}

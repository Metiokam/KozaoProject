package co.kozao.kotask.services.interfaces;

import co.kozao.kotask.models.UserModel;
//import co.kozao.kotask.models.enums.Role;

import java.util.List;

public interface UserServiceInterface {
	
	UserModel createUser(UserModel user);

	UserModel authenticate(String email, String password);

	UserModel getUserById(int idUser);

	boolean updateUser(UserModel user);

	boolean deleteUser(int idUser);

	List<UserModel> getAllUsers();
	
	UserModel findByEmail(String email);
	
	boolean updateRole(UserModel user);
}

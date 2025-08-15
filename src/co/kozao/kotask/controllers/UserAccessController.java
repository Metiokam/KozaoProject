package co.kozao.kotask.controllers;

import co.kozao.kotask.models.User;
//import co.kozao.kotask.models.Role;
import co.kozao.kotask.services.UserInterface;
import co.kozao.kotask.services.UserServiceImplement;
import co.kozao.kotask.utils.UserActionValidationUtils;
import org.apache.log4j.Logger;
import java.util.List;

public class UserAccessController {
	private UserInterface userService = new UserServiceImplement();
	private static final Logger LOGGER = Logger.getLogger(UserAccessController.class);

	public User authenticate(String email, String password) {
		try {
			if (!UserActionValidationUtils.validateLogin(email, password)) {
				LOGGER.error("Login invalide");
				return null;
			}
			User user = userService.authenticate(email, password);
			if (user == null) {
				LOGGER.error("Échec de l'authentification !");
				return null;
			}
			return user;
		} catch (Exception e) {
			LOGGER.error("Erreur lors de l'authentification : " + e.getMessage(), e);
			return null;
		}
	}

	public User createUser(User user) {
		if (!UserActionValidationUtils.validateUser(user))
			return null;
		return userService.createUser(user);
	}

	public User getUserById(int idUser) {
		return userService.getUserById(idUser);
	}

	public boolean updateUser(User user) {
		return userService.updateUser(user);
	}

	public boolean deleteUser(int idUser) {
		return userService.deleteUser(idUser);
	}

	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
}

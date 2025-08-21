package co.kozao.kotask.controllers;

import co.kozao.kotask.models.enums.Role;
import co.kozao.kotask.models.User;
//import co.kozao.kotask.models.Role;
import co.kozao.kotask.services.interfaces.UserServiceInterface;
import co.kozao.kotask.services.implement.UserService;
import co.kozao.kotask.utils.actionvalidation.UserActionValidationUtils;
import org.apache.log4j.Logger;
import java.util.List;

public class UserAccessController {
	private UserServiceInterface userService = new UserService();
	private static final Logger LOGGER = Logger.getLogger(UserAccessController.class);

	public User createUser(String name, String username, String email, int phoneNumber, Role role, String password,
			String confirmPassword) {
		User user = new User();
		user.setName(name);
		user.setUsername(username);
		user.setEmail(email);
		user.setPhoneNumber(phoneNumber);
		user.setRole(role);
		user.setPassword(password);
		user.setConfirmPassword(confirmPassword);
		try {
			if (!UserActionValidationUtils.validateUser(user)) {

				return null;
			}
			return userService.createUser(user);

		} catch (Exception e) {
			LOGGER.error("Erreur lors de la creaction de l'utilisateur : " + e.getMessage());
			return null;
		}

	}

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

	public User getUserById(int idUser) {
		try {
			return userService.getUserById(idUser);

		} catch (Exception e) {
			LOGGER.error("Erreur lors de la recuperation de l'identifiant de l'utilisateur : " + e.getMessage());
			return null;
		}

	}

	public boolean updateUser(User user) {
		try {
			return userService.updateUser(user);
		} catch (Exception e) {
			LOGGER.error("Erreur lors de la modification de l'identifiant de l'utilisateur : " + e.getMessage());
			return false;
		}

	}

	public boolean deleteUser(int idUser) {
		try {
			return userService.deleteUser(idUser);
		} catch (Exception e) {
			LOGGER.error("Erreur lors de la suppression d'utilisateur de l'utilisateur : " + e.getMessage());
			return false;
		}
	}

	public List<User> getAllUsers() {
		try {
			return userService.getAllUsers();
		} catch (Exception e) {
			LOGGER.error("Erreur lors de l'affichage de la liste des utilisateurs  : " + e.getMessage());
			return null;
		}

	}
}

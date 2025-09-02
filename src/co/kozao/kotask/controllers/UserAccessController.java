package co.kozao.kotask.controllers;

import co.kozao.kotask.models.enums.Role;
import co.kozao.kotask.models.UserModel;
//import co.kozao.kotask.models.Role;
import co.kozao.kotask.services.interfaces.UserServiceInterface;
import co.kozao.kotask.services.UserService;
import co.kozao.kotask.utils.actionvalidation.UserActionValidationUtils;
import org.apache.log4j.Logger;
import java.util.List;

public class UserAccessController {
	private UserServiceInterface userService = new UserService();
	private static final Logger LOGGER = Logger.getLogger(UserAccessController.class);

	public UserModel createUser(String name, String username, String email, int phoneNumber, Role role, String password,
			String confirmPassword) {
		UserModel user = new UserModel();
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

	public UserModel authenticate(String email, String password) {
		try {
			if (!UserActionValidationUtils.validateLogin(email, password)) {
				LOGGER.error("Login invalide");
				return null;
			}
			UserModel user = userService.authenticate(email, password);
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

	public UserModel getUserById(int idUser) {
		try {
			
			if (!UserActionValidationUtils.validateUserId(idUser)) {
				return null;
			}
			
			return userService.getUserById(idUser);

		} catch (Exception e) {
			LOGGER.error("Erreur lors de la recuperation de l'identifiant de l'utilisateur : " + e.getMessage());
			return null;
		}

	}

	public boolean updateUser(UserModel user) {
		try {
			return userService.updateUser(user);
		} catch (Exception e) {
			LOGGER.error("Erreur lors de la modification de l'identifiant de l'utilisateur : " + e.getMessage());
			return false;
		}

	}

	public boolean deleteUser(int idUser) {
		try {
			
			if (!UserActionValidationUtils.validateUserId(idUser)) {
				return false;
			}
			return userService.deleteUser(idUser);
			
		} catch (Exception e) {
			
			LOGGER.error("Erreur lors de la suppression d'utilisateur de l'utilisateur : " , e);
			return false;
		}
	}

	public List<UserModel> getAllUsers() {
		try {
			return userService.getAllUsers();
		} catch (Exception e) {
			LOGGER.error("Erreur lors de l'affichage de la liste des utilisateurs  : " ,e);
			return null;
		}
	}
	
	public boolean updateRole(UserModel user) {
		
		try {
			return userService.updateRole(user);
		} catch (Exception e) {
			LOGGER.error("Erreur lors de la modification du role de l'utilisateur : " ,e);
			
			return false;
		}
		
		
	}
}

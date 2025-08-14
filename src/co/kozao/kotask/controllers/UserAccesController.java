package co.kozao.kotask.controllers;

import java.util.List;

import co.kozao.kotask.models.User;
import co.kozao.kotask.models.Role;
import co.kozao.kotask.services.UserServiceImplement;
import co.kozao.kotask.utils.UserActionValidationUtils;
import co.kozao.kotask.views.DashboardAdmin;
import co.kozao.kotask.views.DashboardChefProjet;
import co.kozao.kotask.views.DashboardEmployer;

public class UserAccesController {

	private UserServiceImplement userServiceImplement;

	public UserAccesController(UserServiceImplement userServiceImplement) {
		super();
		this.userServiceImplement = userServiceImplement;
	}

	public User authenticate(String email, String password) {
		try {

			if (!UserActionValidationUtils.validateLogin(email, password)) {
				System.out.println("Email ou mot de passe invalide !");
				return null;
			}

			User user = userServiceImplement.authenticate(email, password);

			if (user != null) {
				switch (user.getRole()) {

				case ADMIN -> DashboardAdmin.start();
				case EMPLOYER -> DashboardEmployer.start();
				case CHEF_PROJECT -> DashboardChefProjet.start();
				default -> System.out.println("Vous ne correspondez a aucun role !");
				}
			} else {
				System.out.println("Échec de l'authentification. Utilisateur introuvable !");
			}

			return user;

		} catch (Exception e) {
			System.out.println("Erreur lors de l'authentification : " + e.getMessage());
			return null;
		}
	}

	public User createdUser(String name, String username, String email, int phoneNumber, Role role, String password,
			String confirmPassword) {
		User user = new User();
		user.setName(name);
		user.setUsername(username);
		user.setEmail(email);
		user.setPhoneNumber(phoneNumber);
		user.setRole(role);
		user.setPassword(password);
		user.setConfirmPassword(confirmPassword);

		if (!UserActionValidationUtils.validateUser(user)) {
			return null;
		}

		return userServiceImplement.createUser(user);

	}

	public User getUserById(int idUsers) {
		try {
			return userServiceImplement.getUserById(idUsers);
		}

		catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			return null;
		}
	}

	public boolean updateUser(User user) {
		try {

			if (!UserActionValidationUtils.validateUser(user)) {
				return false;
			}
			return userServiceImplement.updateUser(user);

		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());

			return false;
		}

	}

	public boolean deleteUser(int idUser) {

		if (!UserActionValidationUtils.validateUserId(idUser)) {
			System.out.println("Suppression annulée : ID utilisateur est introuvable !");
			return false;
		}

		try {
			boolean success = userServiceImplement.deleteUser(idUser);
			if (success) {
				System.out.println("Utilisateur supprimé avec succès !");
			} else {
				System.out.println("Erreur lors de la suppression de l'utilisateur.");
			}
			return success;
		} catch (Exception e) {
			System.out.println("Erreur lors de la suppression : " + e.getMessage());
			return true;
		}
	}

	public List<User> getAllUsers() {
		return userServiceImplement.getAllUsers();
	}
}

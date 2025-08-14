package co.kozao.kotask.utils;

import co.kozao.kotask.models.Role;
import co.kozao.kotask.models.User;

public class UserActionValidationUtils {

	// Validation complète en ce qui concerner la création et la mise à jour d'un
	// utilisateur

	public static boolean validateUser(User user) {
		if (user == null) {
			System.err.println("L'utilisateur est null !");
			return false;
		}

		if (user.getName() == null || user.getName().trim().isEmpty()) {
			System.err.println("Le nom est obligatoire !");
			return false;
		}

		if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
			System.err.println("Le nom d'utilisateur est obligatoire !");
			return false;
		}

		if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
			System.err.println("L'email est obligatoire !");
			return false;
		}

		if (!user.getEmail().contains("@")) { // simple validation de format
			System.err.println("Format d'email invalide !");
			return false;
		}

		if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
			System.err.println("Le mot de passe est obligatoire !");
			return false;
		}

		if (!user.getPassword().equals(user.getConfirmPassword())) {
			System.err.println("Le mot de passe et la confirmation doivent être identiques !");
			return false;
		}

		if (user.getRole() == null) {
			System.err.println("Le rôle est obligatoire !");
			return false;
		}

		if (!isValidRole(user.getRole())) {
			System.err.println("Le rôle n'est pas valide !");
			return false;
		}

		return true;
	}

	// Validation en ce qui concerne l'authentification

	public static boolean validateLogin(String email, String password) {
		if (email == null || email.trim().isEmpty()) {
			System.err.println("L'email est obligatoire !");
			return false;
		}

		if (!email.contains("@")) {
			System.err.println("Format d'email invalide !");
			return false;
		}

		if (password == null || password.trim().isEmpty()) {
			System.err.println("Le mot de passe est obligatoire !");
			return false;
		}

		return true;
	}

	// Vérifie que le rôle correspond bien a l'un de ces champs

	public static boolean isValidRole(Role role) {
		return role == Role.ADMIN || role == Role.CHEF_PROJECT || role == Role.EMPLOYER;
	}

	// Vérifie l'ID utilisateur (pour suppression ou recherche)
	public static boolean validateUserId(int idUser) {
		if (idUser <= 0) {
			System.err.println("ID utilisateur invalide !");
			return false;
		}
		return true;
	}
}

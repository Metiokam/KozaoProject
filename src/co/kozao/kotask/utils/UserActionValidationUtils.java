package co.kozao.kotask.utils;

import co.kozao.kotask.models.Role;
import co.kozao.kotask.models.User;
import org.apache.log4j.Logger;
import java.util.regex.Pattern;

public class UserActionValidationUtils {
	private static final Logger LOGGER = Logger.getLogger(UserActionValidationUtils.class);
	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

	public static boolean validateUser(User user) {
		if (user == null) {
			LOGGER.error("L'utilisateur est null !");
			return false;
		}
		if (user.getName() == null || user.getName().trim().isEmpty()) {
			LOGGER.error("Le nom est obligatoire !");
			return false;
		}
		if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
			LOGGER.error("Nom d'utilisateur obligatoire !");
			return false;
		}
		if (user.getEmail() == null || !EMAIL_PATTERN.matcher(user.getEmail()).matches()) {
			LOGGER.error("Email invalide !");
			return false;
		}
		if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
			LOGGER.error("Mot de passe obligatoire !");
			return false;
		}
		if (!user.getPassword().equals(user.getConfirmPassword())) {
			LOGGER.error("Mot de passe et confirmation doivent être identiques !");
			return false;
		}
		if (user.getRole() == null || !isValidRole(user.getRole())) {
			LOGGER.error("Rôle invalide !");
			return false;
		}
		return true;
	}

	public static boolean validateLogin(String email, String password) {
		if (email == null || !EMAIL_PATTERN.matcher(email).matches()) {
			LOGGER.error("Email invalide !");
			return false;
		}
		if (password == null || password.trim().isEmpty()) {
			LOGGER.error("Mot de passe obligatoire !");
			return false;
		}
		return true;
	}

	public static boolean validateUserId(int idUser) {
		if (idUser <= 0) {
			LOGGER.error("ID utilisateur invalide !");
			return false;
		}
		return true;
	}

	public static boolean isValidRole(Role role) {
		return role == Role.ADMIN || role == Role.CHEF_PROJECT || role == Role.EMPLOYER;
	}
}

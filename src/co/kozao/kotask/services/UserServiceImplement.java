package co.kozao.kotask.services;

import java.util.List;
import org.apache.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;

import co.kozao.kotask.dao.UserDAO;
import co.kozao.kotask.dao.UserDAOImpl;
//import co.kozao.kotask.models.Role;
import co.kozao.kotask.models.User;
import co.kozao.kotask.utils.UserActionValidationUtils;

public class UserServiceImplement implements UserInterface {

	private static final Logger LOGGER = Logger.getLogger(UserServiceImplement.class);
	private UserDAO userDAO = new UserDAOImpl();

	@Override
	public User createUser(User user) {
		if (!UserActionValidationUtils.validateUser(user)) {
			LOGGER.error("Validation échouée. Création impossible.");
			return null;
		}

		// Hachage du mot de passe
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		user.setConfirmPassword(hashed);

		return userDAO.createUser(user);
	}

	@Override
	public User authenticate(String email, String password) {
		if (!UserActionValidationUtils.validateLogin(email, password)) {
			LOGGER.error("Login invalide.");
			return null;
		}
		User user = userDAO.findByEmail(email);
		if (user != null && BCrypt.checkpw(password, user.getPassword())) {
			return user;
		}
		LOGGER.error("Échec d'authentification : utilisateur introuvable ou mot de passe incorrect.");
		return null;
	}

	@Override
	public User getUserById(int idUser) {
		if (!UserActionValidationUtils.validateUserId(idUser))
			return null;
		return userDAO.getUserById(idUser);
	}

	@Override
	public boolean updateUser(User user) {
		if (!UserActionValidationUtils.validateUser(user)) {
			LOGGER.error("Validation échouée. Modification impossible.");
			return false;
		}

		// Hachage si mot de passe modifié
		if (user.getPassword() != null && !user.getPassword().isEmpty()) {
			String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
			user.setPassword(hashed);
			user.setConfirmPassword(hashed);
		}
		return userDAO.updateUser(user);
	}

	@Override
	public boolean deleteUser(int idUser) {
		if (!UserActionValidationUtils.validateUserId(idUser))
			return false;

		return userDAO.deleteUser(idUser);
	}

	@Override
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}
}

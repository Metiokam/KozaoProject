package co.kozao.kotask.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import co.kozao.kotask.models.Role;
import co.kozao.kotask.models.User;
import co.kozao.kotask.services.connexion.DBConnection;
import co.kozao.kotask.utils.Contants;
import org.apache.log4j.Logger;

public class UserDAOImpl implements UserDAO {

	private static final Logger LOGGER = Logger.getLogger(UserDAOImpl.class);
	private Connection con = DBConnection.getConnection();
	private final String TABLE_NAME = "users";

	@Override
	public User createUser(User user) {
		String query = String.format(Contants.CREATED_USERS, TABLE_NAME, "name", "username", "email", "phoneNumber",
				"role", "password", "confirmPassword");
		try (PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, user.getName());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getEmail());
			ps.setInt(4, user.getPhoneNumber());
			ps.setString(5, user.getRole().name());
			ps.setString(6, user.getPassword());
			ps.setString(7, user.getConfirmPassword());
			int rows = ps.executeUpdate();
			if (rows > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					user.setIdUser(rs.getInt(1));
				}
				return user;
			}
		} catch (SQLException e) {
			LOGGER.error("Erreur lors de la creation d'utilisation au niveau de la DAO : " + e.getMessage());
		}
		return null;
	}

	@Override
	public User getUserById(int idUser) {
		String query = String.format(Contants.GET_USER_BY_ID, TABLE_NAME, "idUser");
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, idUser);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return extractUser(rs);
		} catch (SQLException e) {
			LOGGER.error("Erreur lors de la recuperation de l'identifiant de l'utilisateur : " + e.getMessage());
		}
		return null;
	}

	@Override
	public User findByEmail(String email) {
		String query = String.format(Contants.GET_USER_BY_EMAIL, TABLE_NAME, "email");
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return extractUser(rs);
		} catch (SQLException e) {
			LOGGER.error("Erreur lors de la recherche de l'email de l'utilsateur: " + e.getMessage());
		}
		return null;
	}

	@Override
	public boolean updateUser(User user) {
		String query = String.format(Contants.UPDATE_USERS, TABLE_NAME, "name", "username", "email", "phoneNumber",
				"role", "password", "confirmPassword", "idUser");
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, user.getName());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getEmail());
			ps.setInt(4, user.getPhoneNumber());
			ps.setString(5, user.getRole().name());
			ps.setString(6, user.getPassword());
			ps.setString(7, user.getConfirmPassword());
			ps.setInt(8, user.getIdUser());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			LOGGER.error("Erreur lors de la modification de l'utilisateur au niveau de la dao : " + e.getMessage());
		}
		return false;
	}

	@Override
	public boolean deleteUser(int idUser) {
		String query = String.format(Contants.DELETE_USERS, TABLE_NAME, "idUser");
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, idUser);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			LOGGER.error("Erreur lors de la suppression d'un utilisateur au niveau de la dao : " + e.getMessage());
		}
		return false;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		String query = String.format(Contants.GET_ALL_USERS, TABLE_NAME);
		try (PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
			while (rs.next())
				users.add(extractUser(rs));
		} catch (SQLException e) {
			LOGGER.error("Erreur lors de recuperation de la liste des utilsateurs: " + e.getMessage());
		}
		return users;
	}

	private User extractUser(ResultSet rs) throws SQLException {
		return new User(rs.getInt("idUser"), 
				rs.getString("name"),
				rs.getString("username"), 
				rs.getString("email"),
				rs.getInt("phoneNumber"), 
				Role.valueOf(rs.getString("role")),
				rs.getString("password"),
				rs.getString("confirmPassword"));
	}
}

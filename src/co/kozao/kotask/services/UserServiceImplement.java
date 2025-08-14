package co.kozao.kotask.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import co.kozao.kotask.models.*;
//import org.mindrot.jbcrypt.BCrypt;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import co.kozao.kotask.services.connexion.DBConnection;
import co.kozao.kotask.models.User;
import co.kozao.kotask.utils.Contants;

/**
 * 
 * @author Brinda Metiokam<metiokambrinda@gmail.com> version 1.0
 *
 */

public class UserServiceImplement implements UserInterface {

	public final String TABLE_NAME = "users";

	Connection con = DBConnection.getConnection();

	/**
	 * Recherche un utilisateur grace a son identifiant
	 * 
	 * @param identifaiant de 'utilisateur (idUsers). return un object users de la
	 *                     classe Users
	 */

	@Override
	public User getUserById(int idUser) {
		try {
			String query = String.format(Contants.GET_USER_BY_ID, TABLE_NAME, "idUser");
			System.out.println("id de l utilisateur = " + query);
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, idUser);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {

				int idUsers = rs.getInt("idUser");
				String name = rs.getString("name");
				String username = rs.getString("username");
				String email = rs.getString("email");
				int phoneNumber = rs.getInt("phoneNumber");
				Role role = (Role.valueOf(rs.getString("role").toUpperCase()));
				String password = rs.getString("password");
				String confirmPassword = rs.getString("confirmPassword");

				return new User(idUsers, name, username, email, phoneNumber, role, password, confirmPassword);
			} else {
				return null;

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erreur lors de la recherche de l'utilisateur : " + e.getMessage());

			return null;
		}
	}

	/**
	 * Creation de l'utilisation a l'aide d'un object user de la classe Users return
	 * un object users si la creation est un succes
	 * 
	 * @param user object de la classe Users return user
	 * 
	 */

	@Override
	public User createUser(User user) {
	    String query = String.format(Contants.CREATED_USERS, TABLE_NAME, "name", "username", "email", "phoneNumber",
	            "role", "password", "confirmPassword");

	    try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
	        preparedStatement.setString(1, user.getName());
	        preparedStatement.setString(2, user.getUsername());
	        preparedStatement.setString(3, user.getEmail());
	        preparedStatement.setInt(4, user.getPhoneNumber());
	        preparedStatement.setString(5, user.getRole().name());
	        preparedStatement.setString(6, user.getPassword());
	        preparedStatement.setString(7, user.getConfirmPassword());

	        int rows = preparedStatement.executeUpdate();

	        if (rows > 0) {
	            return user;
	        } else {
	            System.out.println("Aucune ligne insérée.Veuillez recommencer");
	            return null;
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Erreur lors de la création du compte utilisateur : " + e.getMessage());
	        return null;
	    }
	}

	@Override
	public boolean updateUser(User user) {
		try {
			String query = String.format(Contants.UPDATE_USERS, TABLE_NAME, "name", "username", "email", "phoneNumber",
					"role", "password", "confirmPassword", "idUser");

			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setInt(4, user.getPhoneNumber());
			preparedStatement.setString(5, user.getRole().name());
			preparedStatement.setString(6, user.getPassword());
			preparedStatement.setString(7, user.getConfirmPassword());
			preparedStatement.setInt(8, user.getIdUser());

			int rows = preparedStatement.executeUpdate();

			return rows > 0;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erreur lors de la modification du compte de l'utilisateur");
		}
		return false;
	}

	@Override

	public boolean deleteUser(int idUser) {
		try {
			String query = String.format(Contants.DELETE_USERS, TABLE_NAME, "idUser");
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, idUser);
			int rows = preparedStatement.executeUpdate();
			return rows > 0;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erreur lors de la suppression du nom du compte de l'utilisateur");

		}
		return false;

	}

	@Override

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();

		String query = String.format(Contants.GET_ALL_USERS, TABLE_NAME);

		try (PreparedStatement preparedStatement = con.prepareStatement(query);
				ResultSet rs = preparedStatement.executeQuery()) {

			while (rs.next()) {
				User user = new User();
				user.setName(rs.getString("name"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPhoneNumber(rs.getInt("phoneNumber"));
				user.setRole(Role.valueOf(rs.getString("role").toUpperCase()));
				user.setPassword(rs.getString("password"));
				user.setConfirmPassword(rs.getString("confirmPassword"));

				users.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erreur lors de la récupération des comptes : " + e.getMessage());
		}

		return users;
	}

	@Override

	public User authenticate(String email, String password) {
		try {
			String query = String.format(Contants.AUTHENTIFIQUE_USERS, TABLE_NAME, "email", "password");
			PreparedStatement prepareStatement = con.prepareStatement(query);
			prepareStatement.setString(1, email);
			prepareStatement.setString(2, password);
			ResultSet rs = prepareStatement.executeQuery();

			if (rs.next()) {
				// String storedHash = rs.getString("password");
				// if (BCrypt.checkpw(plainPassword, storedHash)) {
				User user = new User();
				user.setIdUser(rs.getInt("idUser"));
				user.setName(rs.getString("name"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPhoneNumber(rs.getInt("phoneNumber"));
				user.setRole(Role.valueOf(rs.getString("role")));
				user.setPassword(rs.getString("password"));
				user.setConfirmPassword(rs.getString("confirmPassword"));
				return user;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erreur lors de l'authentification");
		}
		return null;
	}

	@Override
	public void findUserById(User idUser) {
		// TODO Auto-generated method stub

	}

}

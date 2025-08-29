package co.kozao.kotask.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import co.kozao.kotask.models.ClientModel;
import co.kozao.kotask.services.connexion.DBConnection;
import co.kozao.kotask.services.interfaces.ClientServiceInterface;
import co.kozao.kotask.utils.Contants;

public class ClientService implements ClientServiceInterface {

	private static final Logger LOGGER = Logger.getLogger(ClientService.class);
	private Connection con = DBConnection.getConnection();
	private final String TABLE_NAME = "client";

	@Override
	public ClientModel createClient(ClientModel client) throws SQLException {

		String query = String.format(Contants.CREATED_CLIENTS, TABLE_NAME, "name", "email", "AddDate");
		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, client.getName());
			ps.setString(2, client.getEmail());
			ps.setObject(3, client.getAddDate());

			if (ps.executeUpdate() > 0) {
				return client;
			}
		} catch (SQLException e) {
			LOGGER.error("Erreur lors de la creation du client ", e);
		}
		return null;

	}

	@Override
	public boolean updateClient(ClientModel client) throws SQLException {
		String query = String.format(Contants.UPDATE_CLIENTS, TABLE_NAME, "name", "email", "AddDate", "idClient");
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, client.getName());
			ps.setString(2, client.getEmail());
			ps.setObject(3, client.getAddDate());
			ps.setInt(4, client.getIdClient());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			LOGGER.error("Erreur lors de la modification du client : " + e.getMessage());
		}
		return false;
	}

	@Override
	public boolean deleteClient(int idClient) throws SQLException {
		String query = String.format(Contants.DELETE_CLIENTS, TABLE_NAME, "idClient");
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, idClient);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			LOGGER.error("Erreur lors de la suppression d'un project : " + e.getMessage());
		}
		return false;
	}

	@Override
	public ClientModel getClientById(int idClient) throws SQLException {
		String query = String.format(Contants.GET_CLIENTS_BY_ID, TABLE_NAME, "idClient");

		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, idClient);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				ClientModel client = new ClientModel();

				client.setIdClient(rs.getInt("idClient"));
				client.setName(rs.getString("name"));
				client.setEmail(rs.getString("email"));
				client.setAddDate(rs.getObject("addDate", LocalDate.class));

				return client;
			}

		} catch (SQLException e) {
			LOGGER.error("Erreur lors de la récupération du client par ID : " + e.getMessage());
		}
		return null;
	}

	@Override
	public List<ClientModel> getALLClient() throws SQLException {
		List<ClientModel> clients = new ArrayList<>();
		String query = String.format(Contants.GET_ALL_CLIENTS, TABLE_NAME);
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ClientModel client1 = new ClientModel();

				client1.setIdClient(rs.getInt("idClient"));
				client1.setName(rs.getString("name"));
				client1.setEmail(rs.getString("email"));
				client1.setAddDate(rs.getObject("addDate", LocalDate.class));

				clients.add(client1);
			}

		} catch (SQLException e) {
			LOGGER.error("Erreur lors de recuperation de la liste des projets: ", e);
		}
		return clients;
	}

}

package co.kozao.kotask.controllers;

import java.time.LocalDate;
import java.util.List;

import org.apache.log4j.Logger;

import co.kozao.kotask.models.ClientModel;
import co.kozao.kotask.services.ClientService;
import co.kozao.kotask.services.interfaces.ClientServiceInterface;

public class ClientAccesController {

	private ClientServiceInterface clientService = new ClientService();
	private static final Logger LOGGER = Logger.getLogger(ClientAccesController.class);

	public ClientModel createClient(String name, String email, LocalDate addDate)  {

		ClientModel client = new ClientModel();
		client.setName(name);
		client.setEmail(email);
		client.setAddDate(addDate);

		LOGGER.info("Tentative de cr�ation du projet : " + client);

		try {

			ClientModel createClient = clientService.createClient(client);

			if (createClient != null) {
				LOGGER.info("Client cr�� avec succ�s : " + createClient);
			} else {
				LOGGER.error("Le service n'a pas pu cr�er le client, r�sultat null.");
			}
			return createClient;

		} catch (Exception e) {
			LOGGER.error("Erreur lors de la cr�ation du projet : ", e);
			return null;
		}
	}

	public boolean updateClient(ClientModel clientModel) {
		try {
			return clientService.updateClient(clientModel);
		} catch (Exception e) {
			LOGGER.error("Erreur lors de la modification du client : ", e);
			return false;
		}
	}

	public boolean deleteClient(int idClient){

		try {
			return clientService.deleteClient(idClient);
		} catch (Exception e) {

			LOGGER.error("Erreur lors de la suppression  du client : ", e);
			return false;
		}
	}

	public ClientModel getClientById(int idClient)  {
		try {
			return clientService.getClientById(idClient);
		} catch (Exception e) {
			LOGGER.error("Erreur lors de la suppression  du client : ", e);
		}
		return null;
	}

	public List<ClientModel> getALLClient() {
		try {
			return clientService.getALLClient();
		} catch (Exception e) {
			LOGGER.error("Erreur lors de la recuperation de tous les client : ", e);
		}
		return null;
	}
}

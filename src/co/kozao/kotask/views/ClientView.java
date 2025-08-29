package co.kozao.kotask.views;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import co.kozao.kotask.controllers.ClientAccesController;
import co.kozao.kotask.models.ClientModel;

public class ClientView {

	Scanner scanner = new Scanner(System.in);
	ClientAccesController clientController = new ClientAccesController();

	public void createClient() {
		System.out.print("Nom du client : ");
		String name = scanner.nextLine();

		System.out.print("Email du client : ");
		String email = scanner.nextLine();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(LocalDate.now());
		System.out.print("Date d'ajout (jj/MM/aaaa) : ");
		String addDates = scanner.nextLine();
		LocalDate addDate = LocalDate.parse(addDates, formatter);

		ClientModel client = clientController.createClient(name, email, addDate);
		if (client != null) {
			System.out.println("Compte client créé avec succès !");
		} else {
			System.out.println("Erreur lors de la création du compte du client.");
		}
	}

	public void updateClient() {

		System.out.print("Identifiant du client a à modifier : ");
		int idClient = scanner.nextInt();
		scanner.nextLine();

		ClientModel client = clientController.getClientById(idClient);
		if (client != null) {

			System.out.print("Nouveau client : ");
			client.setName(scanner.nextLine());

			System.out.print("Nouveau email du client : ");
			client.setEmail(scanner.nextLine());

			DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			System.out.print("Nouvelle date d'ajout (jj/MM/aaaa) : ");
			String addDte = scanner.nextLine();
			LocalDate addDate = LocalDate.parse(addDte, formatters);
			client.setAddDate(addDate);

			if (clientController.updateClient(client)) {
				System.out.println("client mis à jour !");
			} else {
				System.out.println("Échec de la mise à jour.");
			}
		} else {
			System.out.println("client introuvable !");
		}
	}

	public void deleteClient() {

		System.out.print("Identifiant du client à supprimer : ");
		int idClient = scanner.nextInt();
		scanner.nextLine();

		if (clientController.deleteClient(idClient)) {
			System.out.println("Client supprimé !");
		} else {
			System.out.println("Échec de la suppression.");
		}
	}

	public void getAllClient() {

		List<ClientModel> client = clientController.getALLClient();
		if (client.isEmpty()) {
			System.out.println("Aucun client trouvé.");
		} else {
			System.out.println("=== Liste des Clients ===");
			for (ClientModel c : client) {
				System.out.printf("Identifiant client : %d | Nom du client : %s | email : %s | Date d'ajout : %s%n",
						c.getIdClient(), c.getName(), c.getEmail(), c.getAddDate());
			}
		}

	}
}

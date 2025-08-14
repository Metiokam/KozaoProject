package co.kozao.kotask.views;

import java.util.List;
import java.util.Scanner;

import co.kozao.kotask.models.Role;
import co.kozao.kotask.models.User;
import co.kozao.kotask.services.UserServiceImplement;
import co.kozao.kotask.controllers.UserAccesController;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		UserServiceImplement userservice = new UserServiceImplement();
		UserAccesController con = new UserAccesController(userservice);

		while (true) {
			System.out.println(
		"\n==============Bienvenue sur votre plateforme ko-task qui est une application concu pour la gestion de vos projets. Veuillez-vous connecter pour en voir d'avantage===================== ");
			System.out.println("1. Se Connecter");
			System.out.println("2.Se  Deconnecter");
			System.out.println("3. Supprimer un utilisateur");
			System.out.println("4. Afficher tous les comptes de l'utilisateur");
			System.out.println("0. Quitter");
			System.out.print("Choix : ");
			int choix = scanner.nextInt();
			scanner.nextLine();

			switch (choix) {
			case 1:
				
				System.out.print("Veuillez entrer votre Email : ");
				String email = scanner.nextLine();

				System.out.print("Veuillez entrer votre password : ");
				String password = scanner.nextLine();
                  
				con.authenticate(email, password);
				break;
				
			case 2:
				Scanner scannerInt = new Scanner(System.in);
				System.out.println("Numéro du compte de l'utilisateur à modifier : ");
				int userNum = scannerInt.nextInt();

				System.out.println("Veuillez entrer Nouveau nom : ");
				String newName = scanner.nextLine();

				System.out.println("Veuillez entrer Nouveau prénom : ");
				String newUsername = scanner.nextLine();

				System.out.println("Veuillez entrer Nouvel email : ");
				String newEmail = scanner.nextLine();

				System.out.println("Veuillez entrer un nouveau numero de telephone: ");
				int newPhoneNumber = scanner.nextInt();
				scanner.nextLine();

				System.out.println("Veuillez entrer votre role (ADMIN, CHEF_DE_PROJET, EMPLOYER) : ");
				String newRoleInput = scanner.nextLine();
				Role newRole = Role.valueOf(newRoleInput);

				System.out.println("Veuillez entrer un nouveau mot de passe: ");
				String newPassword = scanner.nextLine();
				System.out.println("veuillez confirme le mote de passe : ");
				String newConfirmPassword = scanner.nextLine();

				User user1 = con.getUserById(userNum);

				if (user1 != null) {

					user1.setName(newName);
					user1.setUsername(newUsername);
					user1.setEmail(newEmail);
					user1.setRole(newRole);
					user1.setPhoneNumber(newPhoneNumber);
					user1.setPassword(newPassword);
					user1.setConfirmPassword(newConfirmPassword);

					con.updateUser(user1);

					System.out.println("Compte de l'utilisateur a étè modifié.");

				} else {
					System.out.println(
							"id du compte de l'utilisateur est introuvable donc l'utilisateur n'as pas ete modifier");
				}

				break;

			case 3:

				int newNum = 0;
				boolean saisieValide = false;

				while (!saisieValide) {
					System.out.print("Id de compte de l'utilisateur à étè supprimer : ");
					String saisie = scanner.nextLine();

					try {
						newNum = Integer.parseInt(saisie);
						saisieValide = true;
					} catch (NumberFormatException e) {
						System.out.println(" Erreur : veuillez entrer un numéro de compte valide (entier).");
					}
				}

				boolean success = con.deleteUser(newNum);

				if (success) {
					System.out.println("Compte de l'utilisateur a été supprimé avec succès.");
				} else {
					System.out.println("Erreur lors de la suppression du compte utilisateur.");
				}
				break;

			case 4:
				List<User> users = con.getAllUsers();
				System.out.println("--- Liste des comptes des differents utilisateurs ---");
				if (users.isEmpty()) {
					System.out.println("Aucun utilisateur trouvé.");
				} else {
					for (User users1 : users) {
						System.out.printf(users1.toString());
					}

				}

				break;

			case 0:
				System.out.println("Au revoir !");
				scanner.close();
				return;
			default:
				System.out.println("Choix invalide.");
			}
		}
	}

}

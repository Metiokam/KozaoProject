package co.kozao.kotask.views;

import java.util.List;
import java.util.Scanner;

import co.kozao.kotask.models.Role;
import co.kozao.kotask.models.User;
import co.kozao.kotask.controllers.UserAccessController;

public class DashboardAdmin {

	public static void start(Scanner scanner) {
		UserAccessController controller = new UserAccessController();
		
			boolean running = true;

			while (running) {
				System.out.println("================== Tableau de bord ADMIN ==================");
				System.out.println("1. Cr�er un utilisateur");
				System.out.println("2. Modifier un utilisateur");
				System.out.println("3. Supprimer un utilisateur");
				System.out.println("4. Afficher tous les  utilisateur");
				System.out.println("5. G�rer les projets");
				System.out.println("6. G�rer les t�ches");
				System.out.println("0. D�connexion");
				System.out.print("Votre choix : ");

				int choix = scanner.nextInt();
				scanner.nextLine(); // Consommer le retour � la ligne

				switch (choix) {

				case 1:
					
					System.out.print("Nom : ");
					String name = scanner.nextLine();

					System.out.print("Pr�nom : ");
					String username = scanner.nextLine();

					System.out.print("Email : ");
					String email1 = scanner.nextLine();

					System.out.print("T�l�phone : ");
					int phoneNumber = scanner.nextInt();
					scanner.nextLine();

					System.out.print("R�le : ");
					Role role = Role.valueOf(scanner.nextLine().toUpperCase());

					System.out.print("Mot de passe : ");
					String password1 = scanner.nextLine();

					System.out.print("Confirmer mot de passe : ");
					String confirmPassword = scanner.nextLine();

					if (!password1.equals(confirmPassword)) {
						System.out.println("Les mots de passe ne correspondent pas !");
						return;
					}
					User user1 = controller.createUser(name,username,email1,phoneNumber,role,password1,confirmPassword);
					if (user1 != null) {
						System.out.println("Compte cr�� avec succ�s !");
					} else {
						System.out.println("Erreur lors de la cr�ation du compte.");
					}
					break;


				case 2:
					System.out.print("ID utilisateur � modifier : ");
					int idUser = scanner.nextInt();
					scanner.nextLine();

					User user = controller.getUserById(idUser);
					if (user != null) {
						System.out.print("Nouveau nom : ");
						user.setName(scanner.nextLine());
						System.out.print("Nouveau username : ");
						user.setUsername(scanner.nextLine());
						System.out.print("Nouvel email : ");
						user.setEmail(scanner.nextLine());
						System.out.print("Nouveau t�l�phone : ");
						user.setPhoneNumber(scanner.nextInt());
						scanner.nextLine();
						System.out.print("Nouveau r�le (ADMIN, CHEF_PROJECT, EMPLOYER) : ");
						user.setRole(Role.valueOf(scanner.nextLine()));
						System.out.print("Nouveau mot de passe : ");
						String pwd = scanner.nextLine();
						user.setPassword(pwd);
						user.setConfirmPassword(pwd);
						
						if (controller.updateUser(user)) {
							System.out.println("Utilisateur mis � jour !");
						} else {
							System.out.println("�chec de la mise � jour.");
						}
					} else {
						System.out.println("Utilisateur introuvable !");
					}
					
					break;

				case 3: {
					System.out.print("ID utilisateur � supprimer : ");
					int idUser1 = scanner.nextInt();
					scanner.nextLine();

					if (controller.deleteUser(idUser1)) {
						System.out.println("Utilisateur supprim� !");
					} else {
						System.out.println("�chec de la suppression.");
					}
				}
				
				break;
				case 4: {
				    List<User> users = controller.getAllUsers();
				    if (users.isEmpty()) {
				        System.out.println("Aucun utilisateur trouv�.");
				    } else {
				        System.out.println("=== Liste des utilisateurs ===");
				        for (User u : users) {
				            System.out.printf("ID: %d | Nom: %s | Pr�nom: %s | Email: %s | T�l�phone: %d | R�le: %s%n",
				                u.getIdUser(),
				                u.getName(),
				                u.getUsername(),
				                u.getEmail(),
				                u.getPhoneNumber(),
				                u.getRole());
				        }
				    }
				    break;
				}
			
				case 0: {
					System.out.println("D�connexion. Au revoir !");
					running = false;
					scanner.close();
					return;
				}
				default:
					System.out.println("Option invalide.");
					
					break;
				}
			}
		
	}
}

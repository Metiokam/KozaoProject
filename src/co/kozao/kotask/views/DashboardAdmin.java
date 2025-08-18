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
				System.out.println("1. Créer un utilisateur");
				System.out.println("2. Modifier un utilisateur");
				System.out.println("3. Supprimer un utilisateur");
				System.out.println("4. Afficher tous les  utilisateur");
				System.out.println("5. Gérer les projets");
				System.out.println("6. Gérer les tâches");
				System.out.println("0. Déconnexion");
				System.out.print("Votre choix : ");

				int choix = scanner.nextInt();
				scanner.nextLine(); // Consommer le retour à la ligne

				switch (choix) {

				case 1:
					
					System.out.print("Nom : ");
					String name = scanner.nextLine();

					System.out.print("Prénom : ");
					String username = scanner.nextLine();

					System.out.print("Email : ");
					String email1 = scanner.nextLine();

					System.out.print("Téléphone : ");
					int phoneNumber = scanner.nextInt();
					scanner.nextLine();

					System.out.print("Rôle : ");
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
						System.out.println("Compte créé avec succès !");
					} else {
						System.out.println("Erreur lors de la création du compte.");
					}
					break;


				case 2:
					System.out.print("ID utilisateur à modifier : ");
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
						System.out.print("Nouveau téléphone : ");
						user.setPhoneNumber(scanner.nextInt());
						scanner.nextLine();
						System.out.print("Nouveau rôle (ADMIN, CHEF_PROJECT, EMPLOYER) : ");
						user.setRole(Role.valueOf(scanner.nextLine()));
						System.out.print("Nouveau mot de passe : ");
						String pwd = scanner.nextLine();
						user.setPassword(pwd);
						user.setConfirmPassword(pwd);
						
						if (controller.updateUser(user)) {
							System.out.println("Utilisateur mis à jour !");
						} else {
							System.out.println("Échec de la mise à jour.");
						}
					} else {
						System.out.println("Utilisateur introuvable !");
					}
					
					break;

				case 3: {
					System.out.print("ID utilisateur à supprimer : ");
					int idUser1 = scanner.nextInt();
					scanner.nextLine();

					if (controller.deleteUser(idUser1)) {
						System.out.println("Utilisateur supprimé !");
					} else {
						System.out.println("Échec de la suppression.");
					}
				}
				
				break;
				case 4: {
				    List<User> users = controller.getAllUsers();
				    if (users.isEmpty()) {
				        System.out.println("Aucun utilisateur trouvé.");
				    } else {
				        System.out.println("=== Liste des utilisateurs ===");
				        for (User u : users) {
				            System.out.printf("ID: %d | Nom: %s | Prénom: %s | Email: %s | Téléphone: %d | Rôle: %s%n",
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
					System.out.println("Déconnexion. Au revoir !");
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

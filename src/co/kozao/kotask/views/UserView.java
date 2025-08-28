package co.kozao.kotask.views;

import java.util.List;
import java.util.Scanner;

import co.kozao.kotask.controllers.UserAccessController;
import co.kozao.kotask.models.UserModel;
import co.kozao.kotask.models.enums.Role;

public class UserView {

	UserAccessController controller = new UserAccessController();
	

	Scanner scanner = new Scanner(System.in);

	public void createUser() {
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
		UserModel user1 = controller.createUser(name, username, email1, phoneNumber, role, password1, confirmPassword);
		if (user1 != null) {
			System.out.println("Compte créé avec succès !");
		} else {
			System.out.println("Erreur lors de la création du compte.");
		}
	}

	public void updateUser() {

		System.out.print("ID utilisateur à modifier : ");
		int idUser = scanner.nextInt();
		scanner.nextLine();

		UserModel user = controller.getUserById(idUser);
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
			System.out.print("Nouveau rôle (ADMIN, PROJECT_MANAGER, MEMBER, TESTER) : ");
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

	}

	public void deleteUser() {

		System.out.print("ID utilisateur à supprimer : ");
		int idUser1 = scanner.nextInt();
		scanner.nextLine();

		if (controller.deleteUser(idUser1)) {
			System.out.println("Utilisateur supprimé !");
		} else {
			System.out.println("Échec de la suppression.");
		}
	}

	public void getAllUsers() {

		List<UserModel> users = controller.getAllUsers();
		if (users.isEmpty()) {
			System.out.println("Aucun utilisateur trouvé.");
		} else {
			System.out.println("=== Liste des utilisateurs ===");
			for (UserModel u : users) {
				System.out.printf("ID: %d | Nom: %s | Prénom: %s | Email: %s | Téléphone: %d | Rôle: %s%n",
						u.getIdUser(), u.getName(), u.getUsername(), u.getEmail(), u.getPhoneNumber(), u.getRole());
			}
		}
	}

}

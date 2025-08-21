package co.kozao.kotask.views;

import java.util.Scanner;

import co.kozao.kotask.controllers.ProjectAccessController;
import co.kozao.kotask.controllers.TaskAccessController;
import co.kozao.kotask.controllers.UserAccessController;
import co.kozao.kotask.models.User;

public class UserLogin {

	UserAccessController controller = new UserAccessController();
	TaskAccessController taskController = new TaskAccessController();
	ProjectAccessController projectController = new ProjectAccessController();

	Scanner scanner = new Scanner(System.in);

	public void userLogin() {

		System.out.print("Email : ");
		String email = scanner.nextLine();
		System.out.print("Mot de passe : ");
		String password = scanner.nextLine();

		User user = controller.authenticate(email, password);
		if (user != null) {
			if (user.getRole() == null) {
				System.out.println("Rôle non défini pour cet utilisateur !");
			} else {
				switch (user.getRole()) {
				case ADMIN:
					DashboardAdmin.start(scanner);
					break;
				case MEMBER:
					DashboardEmployer.start(scanner);
					break;
				case PROJECT_MANAGER:
					DashboardChefProjet.start(scanner);
					break;
				default:
					System.out.println("Rôle inconnu !");
				}
			}
		} else {
			System.out.println("Email ou mot de passe incorrect !");
		}

	}

}

//boolean running = true;
// while (running) {

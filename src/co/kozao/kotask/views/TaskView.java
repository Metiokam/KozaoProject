package co.kozao.kotask.views;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import co.kozao.kotask.controllers.TaskAccessController;
import co.kozao.kotask.models.TaskModel;
import co.kozao.kotask.models.enums.PriorityTask;
import co.kozao.kotask.models.enums.StatusTask;

public class TaskView {

	private Scanner scanner = new Scanner(System.in);

	private TaskAccessController taskController = new TaskAccessController() ;

	public void createTask() {

		System.out.print("Titre de la tache : ");
		String title = scanner.nextLine();

		System.out.print("Description taches : ");
		String descriptions = scanner.nextLine();

		System.out.print("statut : ");
		StatusTask status = StatusTask.valueOf(scanner.nextLine().toUpperCase());

		System.out.print("Priorite : ");
		PriorityTask priority = PriorityTask.valueOf(scanner.nextLine().toUpperCase());

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(LocalDate.now());
		System.out.print("Date début (jj/MM/aaaa) : ");
		String startDateStr = scanner.nextLine();
		LocalDate startDate = LocalDate.parse(startDateStr, formatter);

		System.out.print("Date fin (jj/MM/aaaa) : ");
		String endDateStr = scanner.nextLine();
		LocalDate endDate = LocalDate.parse(endDateStr, formatter);
		scanner.nextLine();

		System.out.print("Entrer la clé Du project : ");
		String projectKey = scanner.nextLine();

		System.out.print("Entrer le nom De l'utilisateur de la tache : ");
		String userName = scanner.nextLine();

		TaskModel task = taskController.createTask(title, descriptions, status, priority, startDate, endDate,
				projectKey, userName);
		if (task != null) {
			System.out.println("Task créé avec succès !");
		} else {
			System.out.println("Erreur lors de la création de la tache du project.");
		}

	}

	public void updateTask() {

		System.out.print("Identifiant de la tache a à modifier : ");
		int idTasks = scanner.nextInt();
		scanner.nextLine();

		TaskModel tasks = taskController.getTaskById(idTasks);
		if (tasks != null) {

			System.out.print("Nouveau titre: ");
			tasks.setTitle(scanner.nextLine());

			System.out.print("Nouvelle description : ");
			tasks.setDescription(scanner.nextLine());

			System.out.print("Nouveau statut : ");
			tasks.setStatus(StatusTask.valueOf(scanner.nextLine()));

			System.out.print("Nouvelle priorité : ");
			tasks.setPriority(PriorityTask.valueOf(scanner.nextLine()));

			DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			System.out.print("Nouvelle date de début (jj/MM/aaaa HH:mm) : ");
			String startDateS = scanner.nextLine();
			LocalDate startDate = LocalDate.parse(startDateS, formatters);
			tasks.setStartDate(startDate);

			System.out.print("Nouvelle date de fin (jj/MM/aaaa HH:mm) : ");
			String endDateS = scanner.nextLine();
			LocalDate endDate = LocalDate.parse(endDateS, formatters);
			tasks.setEndDate(endDate);

			System.out.print("Nouvelle clé du project : ");
			tasks.setProjectKey(scanner.nextLine());

			System.out.print("Nouveau nom d'utilisateur : ");
			tasks.setUserName(scanner.nextLine());

			if (taskController.updateTask(tasks)) {
				System.out.println("Tache mis à jour !");
			} else {
				System.out.println("Échec de la mise à jour.");
			}
		} else {
			System.out.println("tache introuvable !");
		}

	}

	public void deleteTask() {

		System.out.print("Identifiant de la tache à supprimer : ");
		int idTache = scanner.nextInt();
		scanner.nextLine();

		if (taskController.deleteTask(idTache)) {
			System.out.println("Tache supprimé !");
		} else {
			System.out.println("Échec de la suppression.");
		}

	}

	public void getAllTask() {

		List<TaskModel> task1 = taskController.getAllTask();
		if (task1.isEmpty()) {
			System.out.println("Aucun project trouvé.");
		} else {
			System.out.println("=== Liste des Taches ===");
			for (TaskModel t : task1) {
				System.out.printf(
						"Identifiant tache: %d | Titre: %s | Descritpion: %s | Satut: %s | Priorité: %s | Date debut : %s | Date fin: %s | clé du  projet: %s|  le nom de l'utilisateur: %s%n",
						t.getIdTask(), t.getTitle(), t.getDescription(), t.getStatus(), t.getPriority(),
						t.getStartDate(), t.getEndDate(), t.getProjectKey(), t.getUserName());
			}
		}

	}

}

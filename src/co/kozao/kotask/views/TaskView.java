package co.kozao.kotask.views;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import co.kozao.kotask.controllers.TaskAccessController;
import co.kozao.kotask.models.Task;
import co.kozao.kotask.models.enums.PriorityTask;
import co.kozao.kotask.models.enums.StatusTask;

public class TaskView {

	Scanner scanner = new Scanner(System.in);

	TaskAccessController taskController = new TaskAccessController();

	public void createTask() {

		System.out.print("	Titre de la tache : ");
		String title = scanner.nextLine();

		System.out.print("Description taches : ");
		String descriptions = scanner.nextLine();

		System.out.print("statut : ");
		StatusTask statu = StatusTask.valueOf(scanner.nextLine().toUpperCase());

		System.out.print("Priorite : ");
		PriorityTask priorit = PriorityTask.valueOf(scanner.nextLine().toUpperCase());

		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.print("Date d�but (jj/MM/aaaa) : ");
		// String startDates = scanner.nextLine();
		startDate = LocalDate.parse(scanner.nextLine(), format);

		System.out.print("Date fin (jj/MM/aaaa) : ");
		// String endDates = scanner.nextLine();
		endDate = LocalDate.parse(scanner.nextLine(), format);

		System.out.print("Identifiant Du chef de project : ");
		int idProjects = Integer.parseInt(scanner.nextLine());

		System.out.print("Identifiant Du chef de project : ");
		int idUsers = Integer.parseInt(scanner.nextLine());

		Task task = taskController.createTask(title, descriptions, statu, priorit, null, null, idProjects, idUsers);
		if (task != null) {
			System.out.println("Task cr�� avec succ�s !");
		} else {
			System.out.println("Erreur lors de la cr�ation de la tache du project.");
		}

	}

	public void updateTask() {

		System.out.print("Identifiant de la tache a � modifier : ");
		int idTasks = scanner.nextInt();
		scanner.nextLine();

		Task tasks = taskController.getTaskById(idTasks);
		if (tasks != null) {

			System.out.print("Nouveau titre: ");
			tasks.setTitle(scanner.nextLine());

			System.out.print("Nouvelle description : ");
			tasks.setDescription(scanner.nextLine());

			System.out.print("Nouveau statut : ");
			tasks.setStatut(StatusTask.valueOf(scanner.nextLine()));

			System.out.print("Nouvelle priorit� : ");
			tasks.setPriority(PriorityTask.valueOf(scanner.nextLine()));

			DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			System.out.print("Nouvelle date de d�but (jj/MM/aaaa HH:mm) : ");
			String startDateS = scanner.nextLine();
			LocalDateTime startDate1 = LocalDateTime.parse(startDateS, formatters);
			tasks.setStartDate(startDate1);

			System.out.print("Nouvelle date de fin (jj/MM/aaaa HH:mm) : ");
			String endDateS = scanner.nextLine();
			LocalDateTime endDate1 = LocalDateTime.parse(endDateS, formatters);
			tasks.setEndDate(endDate1);

			System.out.print("Nouveau chef project : ");
			tasks.setIdProject(scanner.nextInt());

			System.out.print("Nouveau chef project : ");
			tasks.setIdUser(scanner.nextInt());

			if (taskController.updateTask(tasks)) {
				System.out.println("Tache mis � jour !");
			} else {
				System.out.println("�chec de la mise � jour.");
			}
		} else {
			System.out.println("tache introuvable !");
		}

	}

	public void deleteTask() {

		System.out.print("Identifiant de la tache � supprimer : ");
		int idTache = scanner.nextInt();
		scanner.nextLine();

		if (taskController.deleteTask(idTache)) {
			System.out.println("Tache supprim� !");
		} else {
			System.out.println("�chec de la suppression.");
		}

	}

	public void getAllTask() {

		List<Task> task1 = taskController.getAllTask();
		if (task1.isEmpty()) {
			System.out.println("Aucun project trouv�.");
		} else {
			System.out.println("=== Liste des Taches ===");
			for (Task t : task1) {
				System.out.printf(
						"Identifiant tache: %d | Titre: %s | Descritpion: %s | Satut: %s | Priorit�: %d | Date debut : %d | Date find: %d | Identifiant utilisateur: %s%n",
						t.getIdTask(), t.getTitle(), t.getDescription(), t.getStatut(), t.getPriority(),
						t.getStartDate(), t.getEndDate(), t.getIdProject(), t.getIdUser());
			}
		}

	}

}

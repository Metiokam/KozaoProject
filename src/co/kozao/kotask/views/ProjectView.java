package co.kozao.kotask.views;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import co.kozao.kotask.controllers.ProjectAccessController;
import co.kozao.kotask.models.Project;
import co.kozao.kotask.models.enums.ProjectStatus;

public class ProjectView {

	Scanner scanner = new Scanner(System.in);

	ProjectAccessController projectController = new ProjectAccessController();

	public void createProject() {

		System.out.print("Nom du projet: ");
		String names = scanner.nextLine();

		System.out.print("Clé Projet : ");
		String projectKey = scanner.nextLine();

		System.out.print("Description : ");
		String description = scanner.nextLine();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.print("Date début (jj/MM/aaaa) : ");
		String startDateStr = scanner.next();
		LocalDate startDate = LocalDate.parse(startDateStr, formatter);

		System.out.print("Date fin (jj/MM/aaaa) : ");
		String endDateStr = scanner.next();
		LocalDate endDate = LocalDate.parse(endDateStr, formatter);
		scanner.nextLine();

		System.out.print("statut : ");
		ProjectStatus status = ProjectStatus.valueOf(scanner.nextLine().toUpperCase());
		// ProjectStatus status = ProjectStatus.valueOf(input.trim().toUpperCase());

		System.out.print("Identifiant Du chef de project : ");

		int idProjectManager = scanner.nextInt();
		scanner.nextLine();

		Project project = projectController.createProject(names, projectKey, description, startDate, endDate, status,
				idProjectManager);
		if (project != null) {
			System.out.println("Projet créé avec succès !");
		} else {
			System.out.println("Erreur lors de la création du projet.");
		}

	}

	public void updateProject() {

		System.out.print("Identifiant du projet a à modifier : ");
		int idProject = scanner.nextInt();
		scanner.nextLine();

		Project projects = projectController.getProjectById(idProject);
		if (projects != null) {

			System.out.print("Nouveau nom : ");
			projects.setName(scanner.nextLine());

			System.out.print("Nouveau clé project : ");
			projects.setProjectKey(scanner.nextLine());

			System.out.print("Nouvelle description : ");
			projects.setDescription(scanner.nextLine());

			DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			System.out.print("Nouvelle date de début (jj/MM/aaaa) : ");
			String startDat = scanner.nextLine();
			LocalDate startDates = LocalDate.parse(startDat, formatters);
			projects.setStartDate(startDates);

			System.out.print("Nouvelle date de fin (jj/MM/aaaa) : ");
			String endDat = scanner.nextLine();
			LocalDate endDates = LocalDate.parse(endDat, formatters);
			projects.setEndDate(endDates);

			System.out.print("Nouveau statut ( EN ATTENTE,EN COURS, TERMINER) : ");
			projects.setStatus(ProjectStatus.valueOf(scanner.nextLine()));

			System.out.print("Nouveau chef project : ");
			projects.setIdProjectManager(scanner.nextInt());

			if (projectController.updateProject(projects)) {
				System.out.println("Projet mis à jour !");
			} else {
				System.out.println("Échec de la mise à jour.");
			}
		} else {
			System.out.println("project introuvable !");
		}

	}

	public void deleteProject() {

		System.out.print("Identifiant du projet à supprimer : ");
		int idPro = scanner.nextInt();
		scanner.nextLine();

		if (projectController.deleteProject(idPro)) {
			System.out.println("Project supprimé !");
		} else {
			System.out.println("Échec de la suppression.");
		}
	}

	public void getAllProject() {

		List<Project> project1 = projectController.getAllProjects();
		if (project1.isEmpty()) {
			System.out.println("Aucun project trouvé.");
		} else {
			System.out.println("=== Liste des Projects ===");
			for (Project p : project1) {
				System.out.printf(
						"Identifiant project : %d | Nom : %s | Description : %s | Date debut : %s | Date fin : %d | Statut : %d | identifiant du chef de project : %s%n",
						p.getIdProject(), p.getName(), p.getDescription(), p.getStartDate(), p.getEndDate(),
						p.getStatus(), p.getIdProjectManager());
			}
		}

	}

}

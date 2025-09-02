package co.kozao.kotask.services;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

public class TaskScheduler {

    private final TaskService taskService;
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private static final Logger LOGGER = Logger.getLogger(TaskScheduler.class);

    public TaskScheduler(TaskService taskService) {
        if (taskService == null) {
            throw new IllegalArgumentException("TaskService ne peut pas être null");
        }
        this.taskService = taskService;
    }

    public void demarrer() {
        scheduler.scheduleAtFixedRate(() -> {
            LOGGER.info("Vérification automatique des statuts...");
            try {
                taskService.mettreAJourStatuts();
            } catch (Exception e) {
                LOGGER.error("Erreur lors de la mise à jour automatique des statuts : " + e.getMessage(), e);
            }
        }, 0, 10, TimeUnit.SECONDS);
    }

    public void arreter() {
        scheduler.shutdown();
        try {
            if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) {
                scheduler.shutdownNow();
            }
        } catch (InterruptedException e) {
            scheduler.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}

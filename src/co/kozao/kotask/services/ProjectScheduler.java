package co.kozao.kotask.services;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
//import org.apache.log4j.Logger;


public class ProjectScheduler {

	 private final ProjectService projectService;
	    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
	    //private static final Logger LOGGER = Logger.getLogger(ProjectScheduler.class);

	    public ProjectScheduler(ProjectService projectService) {
	        if (projectService == null) {
	            throw new IllegalArgumentException("ProjetService ne peut pas être null");
	        }
	        this.projectService = projectService;
	    }
	    public void demarrer() {
	        scheduler.scheduleAtFixedRate(() -> {
	            //LOGGER.debug("Vérification automatique des statuts...");
	            try {
	            	projectService.mettreAJourStatuts();
	            } catch (Exception e) {
	               // LOGGER.error("Erreur lors de la mise à jour automatique des statuts : " , e);
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



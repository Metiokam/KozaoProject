package co.kozao.kotask.controllers;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import co.kozao.kotask.models.NotificationModel;
import co.kozao.kotask.services.NotificationService;
import co.kozao.kotask.services.interfaces.NotificationServiceInterface;

public class NotificationAccessController {
	
	private static final Logger LOGGER = Logger.getLogger(NotificationAccessController.class);
	
	private NotificationServiceInterface notificationService = new NotificationService();

    public void sendNotification(NotificationModel notif) {
    	
        try {
            notificationService.createdNotification(notif);
            LOGGER.info("Notification envoyée : " + notif.getMessage());
        } catch (Exception e) {
            LOGGER.error(" Erreur lors de la création de la notification : " + e.getMessage());
        }
    }

    public List<NotificationModel> getUserNotifications(int idUser) {
        try {
            return notificationService.getALLNotificationByUser(idUser);
        } catch (SQLException e) {
        	LOGGER.error(" Erreur lors de la récupération des notifications : " + e.getMessage());
            return null;
        }
    }

    public void markNotificationAsRead(int idNotification) {
        try {
            notificationService.markAsRead(idNotification);
            LOGGER.info("Notification marquée comme lue.");
        } catch (SQLException e) {
        	LOGGER.error("Erreur lors de la mise à jour : " + e.getMessage());
        }
    }
}


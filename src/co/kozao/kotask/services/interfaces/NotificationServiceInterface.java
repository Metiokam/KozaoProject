package co.kozao.kotask.services.interfaces;

import java.sql.SQLException;
import java.util.List;

import co.kozao.kotask.models.NotificationModel;

public interface NotificationServiceInterface {
	
	NotificationModel createdNotification(NotificationModel notification);
	List<NotificationModel>getALLNotificationByUser(int idUser)throws SQLException;
	//void markAsRead(int idNotification) throws SQLException;
	public void markAsRead(int idNotification) throws SQLException;

}

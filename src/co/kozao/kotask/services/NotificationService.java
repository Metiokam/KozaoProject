package co.kozao.kotask.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import co.kozao.kotask.models.NotificationModel;
import co.kozao.kotask.services.connexion.DBConnection;
import co.kozao.kotask.services.interfaces.NotificationServiceInterface;
import co.kozao.kotask.utils.Contants;

public class NotificationService implements NotificationServiceInterface {

	private static final Logger LOGGER = Logger.getLogger(ProjectService.class);
	private Connection con = DBConnection.getConnection();
	private final String TABLE_NAME = "notification";

	@Override
	public NotificationModel createdNotification(NotificationModel notification) {

		String query = String.format(Contants.CREATED_NOTIFICTIONS, TABLE_NAME, "message", "dateCreated", "isRead",
				"idReceiver", "idTask", "idProject");
		try {

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, notification.getMessage());
			ps.setObject(2, notification.getDateCreated());
			ps.setBoolean(3, notification.isIdRead());
			ps.setInt(4, notification.getIdReceiver());
			ps.setInt(5, notification.getIdTask());
			ps.setInt(6, notification.getIdProject());

			if (ps.executeUpdate() > 0) {

				return notification;
			}

		} catch (SQLException e) {
			LOGGER.error("Erreur lors de la creation de la notification ", e);
		}
		return null;

	}

	@Override
	public List<NotificationModel> getALLNotificationByUser(int idUser) throws SQLException {

		List<NotificationModel> notifs = new ArrayList<>();
		String query = "SELECT * FROM notification WHERE idReceiver = ? ORDER BY dateCreated DESC";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, idUser);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				NotificationModel notif = new NotificationModel();
				notif.setIdNotification(rs.getInt("idNotification"));
				notif.setMessage(rs.getString("message"));
				notif.setDateCreated(rs.getDate("dateCreated").toLocalDate());
				notif.setIdRead(((rs.getBoolean("isRead"))));
				notif.setIdReceiver(rs.getInt("idReceiver"));
				notif.setIdTask((Integer) rs.getObject("idTask"));
				notif.setIdProject((Integer) rs.getObject("idProject"));
				notifs.add(notif);
			}
		}
		return notifs;
	}

	@Override

	public void markAsRead(int idNotification) throws SQLException {
		String query = "UPDATE notification SET isRead = true WHERE idNotification = ?";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, idNotification);
			ps.executeUpdate();
		}
	}

}

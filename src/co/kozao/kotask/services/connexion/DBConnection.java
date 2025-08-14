package co.kozao.kotask.services.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.kozao.kotask.utils.Contants;

public class DBConnection {

	private static Connection instance;
	private static Connection connection = null;
	private static String userName = "root";
	private static String userPass = "1234";
	private static String ipAddress = "localhost";
	private static String databaseName = "ko_tasks";
	private static String databasePort = "3306";

	public static synchronized Connection getInstance() throws SQLException {
		if (instance == null) {
			instance = getConnection();
			return instance;
		}
		return instance;
	}

	public static Connection getConnection() {

		if (connection == null) {
			try {
				try {
					Class.forName(Contants.DRIVER);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Erreur de chargement de JDBC Driver : " + e.getMessage());
				}

				String url = String.format(Contants.url, ipAddress, databasePort, databaseName);
				connection = DriverManager.getConnection(url, userName, userPass);
				System.out.println("Connexion bonnne");

				return connection;

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Erreur de connexion : " + e.getMessage());
			}
		}
		return connection;

	}
}

package co.kozao.kotask.utils;

public class Contants {

	// Constantes

	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String url = "jdbc:mysql://%s:%s/%s";
	public static final String email = "%s, %s.gmail.com";

	// queries SQL

	public static final String CREATED_USERS = "INSERT INTO %s ( %s, %s, %s, %s, %s, %s, %s)"
			+ " VALUES(?, ?, ?, ?, ?, ?, ?)";
	public static final String GET_ALL_USERS = "SELECT * FROM %s";
	public static final String GET_USER_BY_ID = "SELECT * FROM %s WHERE %s = ?";
	public static final String DELETE_USERS = "DELETE FROM %s WHERE %s = ?";
	public static final String UPDATE_USERS = "UPDATE %s SET  %s=?, %s=?, %s=?, %s=? , %s=? , %s=? , %s=?  WHERE %s = ?";
	public static final String AUTHENTIFIQUE_USERS = "SELECT * FROM %s WHERE %s = ? AND %s = ?";
	public static final String GET_USER_BY_EMAIL = "SELECT * FROM %s WHERE %s=?";

	// Projets

	public static final String CREATED_PROJECTS = "INSERT INTO %s ( %s, %s, %s, %s, %s, %s, %s)"
			+ " VALUES(?, ?, ?, ?, ?, ?, ?)";
	public static final String GET_ALL_PROJECTS = "SELECT * FROM %s";
	public static final String DELETE__PROJECTS = "DELETE FROM %s WHERE %s = ?";
	public static final String UPDATE__PROJECTS = "UPDATE %s SET  %s=?, %s=?, %s=?, %s=? , %s=? , %s=? , %s=?  WHERE %s = ?";
	public static final String GET_PROJECT_BY_ID = "SELECT * FROM %s WHERE %s = ?";

	// Taches

	public static final String CREATED_TASKS = "INSERT INTO % (%s,%s, %s, %s, %s, %s, %s)"
			+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
	public static final String DELETE_TASKS = "DELETE FROM %s WHERE %s = ?";
	public static final String UPDATE_TASKS = "UPDATE %s SET  %s=?, %s=?, %s=?, %s=? , %s=? , %s=? , %s=?  WHERE %s = ?";
	public static final String GET_ALL_TASKS = "SELECT * FROM %s";
	public static final String GET_TASKS_BY_ID = "SELECT * FROM %s WHERE %s = ?";
}

package co.kozao.kotask.utils;



public class Contants {
	
	// Constantes
	   public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	   public static final String url = "jdbc:mysql://%s:%s/%s";
	   public static final String email= "%s, %s.gmail.com";

	   //public static String accountNumberFormat = "237_CMR_CR_%s";

	   // queries SQL
	   public static final String CREATED_USERS = "INSERT INTO %s ( %s, %s, %s, %s, %s, %s, %s)"
	         + " VALUES(?, ?, ?, ?, ?, ?, ?)";
	   public static final String GET_ALL_USERS = "SELECT * FROM %s";
	   public static final String GET_USER_BY_ID = "SELECT * FROM %s WHERE %s = ?";
	   public static final String DELETE_USERS = "DELETE FROM %s WHERE %s = ?";
	   public static final String UPDATE_USERS = "UPDATE %s SET  %s=?, %s=?, %s=?, %s=? , %s=? , %s=? , %s=?  WHERE %s = ?";
	   public static final String AUTHENTIFIQUE_USERS = "SELECT * FROM % WHERE % = ? AND % = ?";

}

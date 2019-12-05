package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {
	
	private static final String JDBC_URL = "jdbc:mysql://vl21970.dinaserver.com:3306/ciberkaos004";
	private static Connection instance = null;

	private DBConnection() {
	}

	public static Connection getConnection() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (instance == null) {

			Class.forName("com.mysql.jdbc.Driver");
			Properties props = new Properties();
			props.put("user", "uss004");
			props.put("pasword","elefante2019");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			instance = DriverManager.getConnection(JDBC_URL, "uss004" , "elefante2019");
		}
		return instance;
	}
}

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conexion = DriverManager.getConnection(
				"jdbc:mysql://vl21970.dinaserver.com:3306/ciberkaos004", "uss004" , "elefante2019"  
				);
		
		String sql = "INSERT INTO user(name, lastName) VALUES" + "(?,?)";
		PreparedStatement sentencia = conexion.prepareStatement(sql);
		
		sentencia.setString(1, "lkjl");
		sentencia.setString(2, "tanto");
		
		System.out.println(sql);
		System.out.println(sentencia.executeUpdate());
	}

}

package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.DBConnection;
import modelo.Contacto;

public class DAOContacto {
	private Connection con = null;

	public static DAOContacto instance = null;

	public DAOContacto() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		con = DBConnection.getConnection();
	}

	public static DAOContacto getInstance() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (instance == null)
			instance = new DAOContacto();
		return instance;
	}
	
	public void insert(Contacto c) throws SQLException {
		PreparedStatement ps = con
				.prepareStatement("INSERT INTO contact (nombre, apellido, correo, telefono) VALUES (?,?,?,?)");
		ps.setString(1, c.getNombre());
		ps.setString(2, c.getApellido());
		ps.setString(3, c.getCorreo());
		ps.setInt(4, c.getTelefono());
		System.out.println(ps);
		ps.executeUpdate();
		ps.close();
	}
	
	
}

package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.DBConnection;
import modelo.Contacto;
import modelo.Tarea;

public class DAOTarea {
	private Connection con = null;

	public static DAOTarea instance = null;

	public DAOTarea() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		con = DBConnection.getConnection();
	}

	public static DAOTarea getInstance() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (instance == null)
			instance = new DAOTarea();
		return instance;
	}
	
	//int id, String titulo, String descripcion, int importante, Date fechaInicio, Date fechaFin,int categoria, int dependencia) 
	
	
	public void insert(Tarea t) throws SQLException {
		PreparedStatement ps = con.prepareStatement(
				"INSERT INTO tarea ("
				+ "titulo, "
				+ "descripcion, "
				+ "importante, "
				+ "fechaInicio, "
				+ "fechaFin, "
				+ "categoria, "
				+ "dependencia) "
				+ "VALUES (?,?,?,?,?,?,?)");
		ps.setString(1, t.getTitulo());
		ps.setString(2, t.getDescripcion());
		ps.setInt(3, t.getImportante());
		ps.setDate(4, t.getFechaInicio());
		ps.setDate(5, t.getFechaFin());
		ps.setInt(6, t.getCategoria());
		ps.setInt(7, t.getDependencia());
		ps.executeUpdate();
		ps.close();
	}

	public void update(Tarea t) throws SQLException {
		PreparedStatement ps = con.prepareStatement(
				"UPDATE tarea SET"
				+ " titulo=?,"
				+ " descripcion=?,"
				+ " importante=?, "
				+ " fechaInicio=?, "
				+ " fechaFin=?, "
				+ " categoria=?, "
				+ " dependencia=? "
				+ " WHERE id=?"
				);
		ps.setString(1, t.getTitulo());
		ps.setString(2, t.getDescripcion());
		ps.setInt(3, t.getImportante());
		ps.setDate(4, t.getFechaInicio());
		ps.setDate(5, t.getFechaFin());
		ps.setInt(6, t.getCategoria());
		ps.setInt(7, t.getDependencia());
		ps.setInt(8, t.getId());
		ps.executeUpdate();
		ps.close();
	}
	
	public void delete(String id) throws SQLException {
		PreparedStatement ps = con.prepareStatement(
				"DELETE FROM tarea"
				+ " WHERE id=?"
				);
		ps.setInt(1, Integer.parseInt(id));
		ps.executeUpdate();
		ps.close();
	}
	public Tarea rellenarPorId(int id) throws SQLException {
		Tarea t = new Tarea();
		PreparedStatement ps = con.prepareStatement(
				"SELECT * FROM tarea "
				+ "WHERE id=" + id);
		
		ResultSet resultado = ps.executeQuery();
		while(resultado.next()) {
		t = new Tarea(
				resultado.getInt("id"), 
				resultado.getString("titulo"), 
				resultado.getString("descripcion"),
				resultado.getInt("importante"),
				resultado.getInt("categoria"),
				resultado.getDate("fechaInicio"),
				resultado.getDate("fechaFin"),
				resultado.getInt("dependencia"),
				resultado.getInt("estado")
				);
		}
		
		return t;
	}
	
	
	public ArrayList<Tarea> listaTareas(){
		
		//creo una lista vacia
		ArrayList<Tarea> lista = new ArrayList<Tarea>();
		
		
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM tarea");
			 ResultSet resultado = ps.executeQuery();
			 
				while(resultado.next()) {
	
					Tarea t = new Tarea(
							resultado.getInt("id"), 
							resultado.getString("titulo"), 
							resultado.getString("descripcion"),
							resultado.getInt("importante"),
							resultado.getInt("categoria"),
							resultado.getDate("fechaInicio"),
							resultado.getDate("fechaFin"),
							resultado.getInt("dependencia"),
							resultado.getInt("estado")
							);
					
					lista.add(t); 
				}
				
						} catch (SQLException e) {
			// TODO Auto-generated catch block
							e.printStackTrace();
						}


		return lista;
		}
	
}

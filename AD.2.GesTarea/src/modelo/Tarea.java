package modelo;
import java.sql.Date;
import java.sql.SQLException;

import dao.DAOTarea;


public class Tarea {
	private int id;
	private String titulo;
	private String descripcion;
	private int importante;
	private int categoria;
	private Date fechaInicio;
	private Date fechaFin;
	private int dependencia;
	private int estado;
	
	
	public Tarea(int id, String titulo, String descripcion, int importante, int categoria, Date fechaInicio,
			Date fechaFin, int dependencia, int estado) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.importante = importante;
		this.categoria = categoria;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.dependencia = dependencia;
		this.estado = estado;
	}


	
	public Tarea( String titulo, String descripcion, int importante, Date fechaInicio, Date fechaFin,
			int categoria, int dependencia) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.importante = importante;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.dependencia = dependencia;
		this.categoria = categoria;
	}

	public Tarea() {

		this.titulo = "";
		this.descripcion = "";
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getImportante() {
		return importante;
	}

	public void setImportante(int importante) {
		this.importante = importante;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public int getDependencia() {
		return dependencia;
	}
	public void setDependencia(int dependencia) {
		this.dependencia = dependencia;
	}

	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String imprimeLista() {
		String info = "";
		info += "<tr>";
		info += "<th scope=\"row\">"+this.id+"</th>";
		info += "<td><a href = \"AltaTarea?option=detalle&id="+this.id+"\">"+this.titulo+"</a></td>";
		info += "<td>"+this.descripcion+"</td>";
		info += "<td>"+this.importante+"</td>";
		info += "<td>"+this.fechaInicio+"</td>";
		info += "<td>"+this.fechaFin+"</td>";
		info += "<td>"+this.categoria+"</td>";
		info += "<td>"+this.dependencia+"</td>";
		info += "<td>"+this.estado+"</td>";
		info += "<td><a href=\"AltaTarea?option=edit&id="+ this.id + "\"><img alt=\"\" src=\"./img/edit.png\"></a></td>";
		info += "<td><a href=\"AltaTarea?option=delete&id="+ this.id + "\"><img alt=\"\" src=\"./img/delete.png\"></a></td>";
		info += "</tr>";
		return info;
		
	}
	
	public Tarea rellenarPorId(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		return DAOTarea.getInstance().rellenarPorId(id);
		
	}
	

	@Override
	public String toString() {
		return "Tarea [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", importante=" + importante
				+ ", categoria=" + categoria + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
				+ ", dependencia=" + dependencia + ", estado=" + estado + "]";
	}
	
	
	
	
	
	



	
	
 
}

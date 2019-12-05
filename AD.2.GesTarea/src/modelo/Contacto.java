package modelo;

public class Contacto {
	private String nombre;
	private String apellido;
	private String correo;
	private int telefono;
	
	
	
	public Contacto() {}
	public Contacto(String nombre, String apellido, String correo, int telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.telefono = telefono;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", telefono=" + telefono
				+ "]";
	}
	
	
	
	
}

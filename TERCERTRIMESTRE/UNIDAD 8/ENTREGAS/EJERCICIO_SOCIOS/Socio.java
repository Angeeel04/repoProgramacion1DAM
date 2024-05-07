package coleccionesYExcepciones;
/*HECHO POR ANGEL CHAVEZ 1º DAM*/

public class Socio {
	protected String nombre_apodo;
	protected String telefono;
	protected String dni;
	protected String estado;
	
	public String getNombre() {
		return nombre_apodo;
	}
	public void setNombre(String nombre) {
		this.nombre_apodo = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDni() {
		return dni;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEstado() {
		return estado;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Socio(String nombre, String telefono, String dni) {
		this.nombre_apodo = nombre;
		this.telefono = telefono;
		this.dni = dni;
		this.estado = "ACTIVO";
	}
	
	@Override
	public String toString() {
		return "Nombre: " + nombre_apodo + " | Teléfono: " + telefono + " | DNI: " + dni;
	}
}
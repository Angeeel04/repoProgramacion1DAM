public class Animal {
	String nombre;
	int edad;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public Animal() {
		nombre = "";
		edad = 0;
	}
	
	public Animal (String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
}
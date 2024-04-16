/*HECHO POR ANGEL CHAVEZ 1º DAM*/
public class Caballo {
	private String nombre;
	private int dorsal;
	private int distancia;
	
	public Caballo() {
		this.nombre = "";
		this.dorsal = 0;
		this.distancia = 0;
	}

	public Caballo(String nombre, int dorsal) {
		this.nombre = nombre;
		this.dorsal = dorsal;
		this.distancia = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	
	@Override
	public String toString() {
		return nombre + " con el numero " + dorsal + " (" + distancia + "m) ";
	}
}
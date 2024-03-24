public class Gato extends Animal{
	String pelaje;
	
	public String getPelaje() {
		return pelaje;
	}

	public void setPelaje(String pelaje) {
		this.pelaje = pelaje;
	}

	public Gato() {
		super();
		pelaje = "";
	}

	public Gato(String nombre, int edad, String pelaje) {
		super(nombre, edad);
		this.pelaje = pelaje;
	}
}
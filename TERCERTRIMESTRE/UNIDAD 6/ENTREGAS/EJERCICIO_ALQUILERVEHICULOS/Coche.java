/*HECHO POR ANGEL CHAVEZ 1ºDAM */
public class Coche extends Vehiculo{
	private int numPuertas;
	
	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}
	public int getNumPuertas() {
		return numPuertas;
	}
	public Coche() {
		super();
		this.numPuertas = 0;
	}
	public Coche(String matricula, String marca, String caballosPotencia, int numPuertas) {
		super(matricula, marca, caballosPotencia);
		this.numPuertas = numPuertas;
	}
}
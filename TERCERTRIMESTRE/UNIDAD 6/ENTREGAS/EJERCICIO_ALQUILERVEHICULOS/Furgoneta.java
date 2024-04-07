/*HECHO POR ANGEL CHAVEZ 1ºDAM */
public class Furgoneta extends Vehiculo{
	private double capacidad;

	public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }
    public double getCapacidad() {
		return capacidad;
	}
	public Furgoneta() {
		super();
		capacidad = 0.00;
	}
	public Furgoneta (String matricula, String marca, String caballosPotencia, double capacidad) {
		super(matricula, marca, caballosPotencia);
		this.capacidad = capacidad;
	}
}
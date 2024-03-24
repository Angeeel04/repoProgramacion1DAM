public class Palacio extends Vivienda{
	int habitaciones;

	public int getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(int habitaciones) {
		this.habitaciones = habitaciones;
	}

	public Palacio() {
		super();
		this.habitaciones = 0;
	}
	
	public Palacio(int metrosCuadrados, String calle, int numero, int habitaciones){
		super(metrosCuadrados, calle,numero);
		this.habitaciones = habitaciones;
	}
	
	@Override
	public String toString() {
		return "PALACIO " + super.toString() + "\n" + "- Habitaciones: " + habitaciones;
	}
}
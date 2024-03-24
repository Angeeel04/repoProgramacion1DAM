public class Chalet extends Vivienda{
	boolean jardin;

	public boolean getJardin() {
		return jardin;
	}

	public void setJardin(boolean jardin) {
		this.jardin = jardin;
	}
	
	public Chalet() {
		super();
		this.jardin = false;
	}
	
	public Chalet(int metrosCuadrados, String calle, int numero, boolean jardin) {
		super(metrosCuadrados, calle, numero);
		this.jardin = jardin;
	}
	
	@Override
	public String toString() {
		return "CHALET " + super.toString() + "\n" + "- Jardin: " + jardin;
	}	
}
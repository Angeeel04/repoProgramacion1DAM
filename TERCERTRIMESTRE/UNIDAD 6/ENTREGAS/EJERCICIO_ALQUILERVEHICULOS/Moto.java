public class Moto extends Vehiculo{
	private boolean maletin;
	
	public boolean getMaletin() {
		return maletin;
	}
	public void setMaletin(boolean maletin) {
		this.maletin = maletin;
	}
	public Moto() {
		super();
		maletin = false;
	}
	public Moto (String matricula, String marca, String caballosPotencia, boolean maletin) {
		super(matricula, marca, caballosPotencia);
		this.maletin = maletin;
	}
}
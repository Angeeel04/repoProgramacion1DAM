/*HECHO POR ANGEL CHAVEZ 1ºDAM */
public abstract class Vehiculo {
	private String matricula;
	private String marca;
	private String caballosPotencia;
	private int diasAlquiler;

	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCaballosPotencia() {
		return caballosPotencia;
	}
	public void setCaballosPotencia(String caballosPotencia) {
		this.caballosPotencia = caballosPotencia;
	}
	public int getDiasAlquiler() {
		return diasAlquiler;
	}
	public void setDiasAlquiler(int diasAlquiler) {
		this.diasAlquiler = diasAlquiler;
	}
	public Vehiculo() {
		this.matricula = "";
		this.marca = "";
		this.caballosPotencia = "";
	}
	public Vehiculo(String matricula, String marca, String caballosPotencia) {
		this.matricula = matricula;
		this.marca = marca;
		this.caballosPotencia = caballosPotencia;
		diasAlquiler = 0;
	}
	
	@Override
	public String toString() {
		return marca + " " + matricula;
	}
}
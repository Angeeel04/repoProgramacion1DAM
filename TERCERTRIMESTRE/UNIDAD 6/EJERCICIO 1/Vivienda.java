public class Vivienda {
	int metrosCuadrados;
	String calle;
	int numero;
	
	public int getMetrosCuadrados() {
		return metrosCuadrados;
	}
	public void setMetrosCuadrados(int metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public Vivienda() {
		this.metrosCuadrados = 0;
		this.calle = "";
		this.numero = 0;
	}
	
	public Vivienda(int metrosCuadrados, String calle, int numero) {
		this.metrosCuadrados = metrosCuadrados;
		this.calle = calle;
		this.numero = numero;
	}
	
	@Override
	public String toString() {
		return "DESCRIPCION :" + "\n" + "- Metros Cuadrados: " + metrosCuadrados + "\n" + "- Calle: " + calle + "\n" + "- Numero: " + numero;
	}
}
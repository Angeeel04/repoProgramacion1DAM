package coleccionesYExcepciones;
/*HECHO POR ANGEL CHAVEZ 1º DAM*/

public class TelefonoInvalidFormat extends Exception{

	public TelefonoInvalidFormat () {}
	
	public TelefonoInvalidFormat(String mensaje) {
		super(mensaje);
	}
}
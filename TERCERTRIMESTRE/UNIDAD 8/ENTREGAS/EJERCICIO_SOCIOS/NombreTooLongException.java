package coleccionesYExcepciones;
/*HECHO POR ANGEL CHAVEZ 1º DAM*/

public class NombreTooLongException extends Exception{
	
	public NombreTooLongException() {}
	
	public NombreTooLongException(String mensaje) {
		super(mensaje);
	}
}
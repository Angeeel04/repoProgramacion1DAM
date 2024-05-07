package coleccionesYExcepciones;
/*HECHO POR ANGEL CHAVEZ 1º DAM*/

public class DniInvalidFormat extends Exception{
	
	public DniInvalidFormat() {}
	
	public DniInvalidFormat (String mensaje) {
		super(mensaje);
	}
}
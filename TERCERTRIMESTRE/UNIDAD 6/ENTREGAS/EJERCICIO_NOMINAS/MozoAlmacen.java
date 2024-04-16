/*HECHO POR ANGEL CHAVEZ 1º DAM*/
public class MozoAlmacen extends Empleados{
	public MozoAlmacen(String nombre, String apellido1, String apellido2, String dni, int diasAntiguedad) {
		super(nombre, apellido1, apellido2, dni, "Mozo de almacen", diasAntiguedad);
		setSueldoBruto(1200.00);
		setSueldoNeto(Sueldos(0.05, 0.15));
		setIndemnizacion(Indemnizacion());
	}
}
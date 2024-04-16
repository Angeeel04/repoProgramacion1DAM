/*HECHO POR ANGEL CHAVEZ 1º DAM*/
public class PersonalAdministracion extends Empleados{
	public PersonalAdministracion(String nombre, String apellido1, String apellido2, String dni, int diasAntiguedad) {
		super(nombre, apellido1, apellido2, dni, "Personal Administrativo", diasAntiguedad);
		setSueldoBruto(1600.00);
		setSueldoNeto(Sueldos(0.06,0.13));
		setIndemnizacion(Indemnizacion());
	}
}
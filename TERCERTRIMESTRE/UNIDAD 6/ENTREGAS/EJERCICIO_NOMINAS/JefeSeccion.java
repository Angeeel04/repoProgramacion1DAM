import java.util.Random;
/*HECHO POR ANGEL CHAVEZ 1º DAM*/
public class JefeSeccion extends Empleados{
	private int ventas;
	private double comision;

	public JefeSeccion(String nombre, String apellido1, String apellido2, String dni, int diasAntiguedad) {
		super(nombre, apellido1, apellido2, dni, "Jefe de Seccion", diasAntiguedad);
		Random rnd = new Random();
		ventas = rnd.nextInt(10);
		comision = (ventas * 0.12);
		setSueldoBruto(1700.00);
		setSueldoNeto(Sueldos(0.07, 0.17) + comision);
		setIndemnizacion(Indemnizacion());
	}

	@Override
	public String mostrarDatos(){
		return "Comision sobre las " + ventas + " ventas = " + comision + "\n" + 
		getNombre() + " " + getApellido1() + " " + getApellido2() + " " + getDni() + " " + getSueldoNeto() + " euros " + getAntiguedadDias() + " dias";
	}
}
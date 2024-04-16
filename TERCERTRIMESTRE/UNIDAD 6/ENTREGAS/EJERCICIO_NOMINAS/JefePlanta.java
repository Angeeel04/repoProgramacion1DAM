import java.util.Random;
/*HECHO POR ANGEL CHAVEZ 1º DAM*/
public class JefePlanta extends Empleados{
	private int ventas;
	private double comision;

	public JefePlanta(String nombre, String apellido1, String apellido2, String dni, int diasAntiguedad) {
		super(nombre, apellido1, apellido2, dni, "Jefe de planta", diasAntiguedad);
		Random rnd = new Random();
		ventas = rnd.nextInt(10);
		comision = (ventas * 0.06);
		setSueldoBruto(1800.00);
		setSueldoNeto(Sueldos(0.09, 0.19) + comision);
		setIndemnizacion(Indemnizacion());
	}

	@Override
	public String mostrarDatos(){
		return "Comision sobre las " + ventas + " ventas = " + comision + "\n" + 
		getNombre() + " " + getApellido1() + " " + getApellido2() + " " + getDni() + " " + getSueldoNeto() + " euros " + getAntiguedadDias() + " dias";
	}
}
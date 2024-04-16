import java.util.Random;
/*HECHO POR ANGEL CHAVEZ 1º DAM*/
public class Directivo extends Empleados{
	private boolean cumple;
	private double plus;
	
	public Directivo(String nombre, String apellido1, String apellido2, String dni, int diasAntiguedad) {
		super(nombre, apellido1, apellido2, dni, "Directivo", diasAntiguedad);
		Random rnd = new Random();
		cumple = rnd.nextBoolean();
		setSueldoBruto(2800.00);
		setSueldoNeto(Sueldos(0.10, 0.23));
		setIndemnizacion(Indemnizacion());
	}

	public String mostrarDatos(){
		return "Plus cumplimiento de objetivos: " + this.plus + "\n" + 
		getNombre() + " " + getApellido1() + " " + getApellido2() + " " + getDni() + " " + getSueldoNeto() + " euros " + getAntiguedadDias() + " dias";
	}

	@Override
	public double Sueldos(double porcentajeAumento, double porcentajeRetencion){
		if(cumple){
			plus = (getSueldoBruto() * 0.35);
			setSueldoBruto(getSueldoBruto() + plus);
		}
		return (getSueldoBruto()-getRetencion());
	}
}
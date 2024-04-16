/*HECHO POR ANGEL CHAVEZ 1º DAM*/
public abstract class Empleados implements Cobros{
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String dni;
	private String catLaboral;
	private int antiguedadDias;
	private double indemnizacion;
	private double sueldoNeto;
	private double retencion;
	private double sueldoBruto;
	private double aumento;

	//GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCatLaboral() {
		return catLaboral;
	}

	public void setCatLaboral(String catLaboral) {
		this.catLaboral = catLaboral;
	}

	public int getAntiguedadDias() {
		return antiguedadDias;
	}

	public void setAntiguedadDias(int antiguedadDias) {
		this.antiguedadDias = antiguedadDias;
	}
		
	public double getSueldoBruto() {
		return sueldoBruto;
	}

	public void setSueldoBruto(double sueldoBruto) {
		this.sueldoBruto = sueldoBruto;
	}

	public double getRetencion() {
		return retencion;
	}

	public void setRetencion(double retencion) {
		this.retencion = retencion;
	}
	
	public double getAumento() {
		return aumento;
	}

	public void setAumento(double aumento) {
		this.aumento = aumento;
	}

	public double getSueldoNeto() {
		return sueldoNeto;
	}

	public void setSueldoNeto(double sueldoNeto) {
		this.sueldoNeto = sueldoNeto;
	}

	public double getIndemnizacion() {
		return indemnizacion;
	}

	public void setIndemnizacion(double indemnizacion) {
		this.indemnizacion = indemnizacion;
	}

	//CONSTRUCTOR
	public Empleados() {
		this.nombre = "";
		this.apellido1 = "";
		this.apellido2 = "";
		this.dni = "";
		this.catLaboral = "";
		this.antiguedadDias = 0;
	}

	public Empleados(String nombre, String apellido1, String apellido2, String dni, String catLaboral, int diasAntiguedad) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.catLaboral = catLaboral;
		this.antiguedadDias = diasAntiguedad;
	}

	public double Sueldos(double porcentajeAumento, double porcentajeRetencion){
		if(getAntiguedadDias()>365){
			setAumento(getSueldoBruto() * ((getAntiguedadDias() / 365) * porcentajeAumento));
		}
		setSueldoBruto(getSueldoBruto()+getAumento());
		setRetencion(getSueldoBruto()*porcentajeRetencion);
		return (getSueldoBruto()-getRetencion());
	}

	public double Indemnizacion(){
		double retorno = 0.00;
		if(getAntiguedadDias()>365){
			retorno = ((getSueldoBruto()*20)/30);
		}
		return retorno;
	}

	public String mostrarDatos(){
		return this.nombre + " " + this.apellido1 + " " + this.apellido2 + " " + this.dni + " " + getSueldoNeto() + " euros " + getAntiguedadDias() + " dias";
	}
	
	@Override
	public String toString() {
		return nombre + " " + apellido1 + " " + apellido2 + " " + catLaboral + " " + dni; 
	}
}
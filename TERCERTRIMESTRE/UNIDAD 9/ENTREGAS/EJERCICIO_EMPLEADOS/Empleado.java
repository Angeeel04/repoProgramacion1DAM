package empleadosYHtml;
/*HECHO POR ANGEL CHAVEZ 1º DAM*/

public class Empleado{
    private String dni;
    private String nombre;
    private String ape1;
    private String anyonac;
    private int fijo;
    private int factura;
    private double percent;
    private double total_nomina;

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApe1() {
        return ape1;
    }
    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }
    public String getAnyonac() {
        return anyonac;
    }
    public void setAnyonac(String anyonac) {
        this.anyonac = anyonac;
    }
    public int getFijo() {
        return fijo;
    }
    public void setFijo(int fijo) {
        this.fijo = fijo;
    }
    public int getFactura() {
        return factura;
    }
    public void setFactura(int factura) {
        this.factura = factura;
    }
    public double getPercent() {
        return percent;
    }
    public void setPercent(double percent) {
        this.percent = percent;
    }

    public Empleado(String dni, String nombre, String ape1, String anyonac, int fijo, int factura, double percent){
        this.dni = dni;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.anyonac = anyonac;
        this.fijo = fijo;
        this.factura = factura;
        this.percent = percent;
        this.total_nomina = (double) (fijo + (factura * percent * 0.01));
    }

    @Override
    public String toString(){
        return "DNI: " + this.dni + " Nombre: " + this.nombre + " Apellido1: " + this.ape1 + "\n" +
                "Fijo = " + this.fijo + " Factura = " + this.factura + " Percent = " + this.percent + " NÓMINA: " + this.total_nomina;
    }
}
public class Localidad{
    private String nombre;
    private String provincia;
    private int numHabitantes;
    private int distanciaACapital;
    private int superficie;
    private int rentaPerCapita;

    public static void main(String[] args) {
        Localidad localidad1 = new Localidad("Pinto", "Madrid", 3, 180000, 19000000, 500);
        Localidad localidad2 = new Localidad("Valdemoro", "Madrid", 2, 80000, 14000000, 1000);

        //Comprobar EJERCICIO1.3
            if(localidad1.tieneMasPoblacion(localidad2))
                System.out.println(localidad1.getNombre() + " tiene mayor poblacion que " + localidad2.getNombre());
            else
                System.out.println(localidad2.getNombre() + " tiene mayor poblacion que " + localidad1.getNombre());

        //Comprobar EJERCICIO1.4
            System.out.println("La densidad de " + localidad1.getNombre() + " es: " + localidad1.densidadPoblacional());

        //Comprobar EJERCICIO1.8
            System.out.println("La renta Potencial de " + localidad1.getNombre() + " es: " + localidad1.rentaPotencial());
    }

    // Constructor de LOCALIDAD
    public Localidad (String nombre, String provincia, int numHabitantes, int distanciaACapital, int superficie, int rentaPerCapita){
        this.nombre = nombre;
        this.provincia = provincia;
        this.numHabitantes = numHabitantes;
        this.distanciaACapital = distanciaACapital;
        this.superficie = superficie;
        this.rentaPerCapita = rentaPerCapita;
    }

    // GETTER´s y SETTER´s
    
    // para el atributo nombre
    public String getNombre (){
        return nombre;
    }

    public void setNombre (String dato){
        this.nombre = dato;
    }

    // para el atributo provincia
    public String getProvincia(){
        return provincia;
    }

    public void setProvincia (String dato){
        this.provincia = dato;
    }

    // para el atributo numHabitantes
    public int getNumHabitantes(){
        return numHabitantes;
    }

    public void setNumHabitantes (int dato){
        this.numHabitantes = dato;
    }

    // para el atributo distanciaACapital
    public int getDistanciaACapital(){
        return distanciaACapital;
    }

    public void setDistanciaACapital (int dato){
        this.distanciaACapital = dato;
    }

    // para el atributo superficie
    public int getSuperficie(){
        return superficie;
    }

    public void setSuperficie(int dato){
        this.superficie = dato;
    }

    // para el atributo rentapercapita
    public int getRentaPerCapita(){
        return rentaPerCapita;
    }

    public void setRentaPerCapita(int dato){
        this.rentaPerCapita = dato;
    }

    //METODOS

    //EJERCICIO1.3
    public boolean tieneMasPoblacion (Localidad dato){
        boolean mayorPoblacion = false;

        if(this.getNumHabitantes() > dato.getNumHabitantes())
            mayorPoblacion = true;

        return mayorPoblacion;
    }

    //EJERCICIO1.4
    public float densidadPoblacional(){
        return (this.getNumHabitantes() / this.getSuperficie());
    }

    //EJERCICIO1.8
    public long rentaPotencial(){
        long renta = this.getNumHabitantes() * this.getRentaPerCapita();
        return renta;
    }
}
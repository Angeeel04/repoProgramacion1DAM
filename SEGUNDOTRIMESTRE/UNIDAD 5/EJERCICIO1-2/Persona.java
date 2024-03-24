public class Persona {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;
    private String profesion;
    private int edad;

    public static void main (String args[]){
        Persona persona1 = new Persona("Pedro","Flores", "Perez", "12828122", "Doctor", 15);
        Persona persona2 = new Persona("Rafael","Flores", "Perez", "12828122", "Cirujano", 16);
        Persona persona3 = new Persona("Manuel","Flores", "PerezMargarita", "12828122", "Biologo", 17);

        //Comprobar EJERCICIO1.5
            if(persona1.esMayorQue(persona2))
                System.out.println(persona1.getNombre() + " es mayor que " + persona2.getNombre());
            
            else
                System.out.println(persona2.getNombre() + " es mayor que " + persona1.getNombre());

        //Comprobar EJERCICIO1.6
            if(persona2.esTocayoDe(persona3))
                System.out.println("Son tocayos");

            else
                System.out.println("No son tocayos");
                
        
        //comprobar EJERCICIO1.7
            if(persona2.esFamiliarDe(persona1))
                System.out.println("Son familia");

            else
                System.out.println("No son familia");
            
        
        //comprobar EJERCICIO2.1
            persona1.esJubilado();
        
        //comprobar EJERCICIO2.2
            persona1.esMenor();

        //comprobar EJERCICIO2.3
        //String [] profesiones = {"Doctor", "Programador", "Administrador"};
        //Persona [] personas = {persona1, persona2, persona3};
        //trabajaEnSector(personas,profesiones);      
        
        //comprobar EJERCICIO2.4
            if(persona3.tieneApellidoCompuesto())
                System.out.println("Tiene apellido compuesto");
        
            else
                System.out.println("No tiene apellido compuesto");
    }

    //Constructor de PERSONA
    public Persona(String nombre, String apellido1, String apellido2, String dni, String profesion, int edad){
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.profesion = profesion;
        this.edad = edad;
    }

    //GETTER´s Y SETTER´s

    //para el atributo NOMBRE
    public void setNombre (String dato){
        this.nombre = dato;
    }

    public String getNombre(){
        return nombre;
    }

    //para el atributo APELLIDO1
    public void setApellido1(String dato){
        this.apellido1 = dato;
    }

    public String getApellido1(){
        return apellido1;
    }

    //para el atributo APELLIDO2
    public void setApellido2(String dato){
        this.apellido2 = dato;
    }

    public String getApellido2(){
        return apellido2;
    }

    //para el atributo DNI
    public void setDni(String dato){
        this.dni = dato;
    }

    public String getDni(){
        return dni;
    }

    //para el atributo PROFESION
    public void setProfesion (String dato){
        this.profesion = dato;
    }

    public String getProfesion(){
        return profesion;
    }

    //para el atributo EDAD
    public void setEdad (int dato){
        this.edad = dato;
    }

    public int getEdad(){
        return edad;
    }


    //METODOS
    
    //EJERCICIO1.5
    public boolean esMayorQue(Persona dato1){
        boolean esMayor = false;

        if(this.getEdad() > dato1.getEdad())
            esMayor = true;

        return esMayor;
    }

    //EJERCICIO1.6
    public boolean esTocayoDe(Persona dato1){
        boolean esTocayo = false;

        if(dato1.getNombre().equals(this.getNombre()))
            esTocayo = true;
            
        return esTocayo;
    }

    //EJERCICIO1.7
    public boolean esFamiliarDe(Persona dato1){
        boolean esFamiliar = false;
        
        if(dato1.getApellido1().equals(this.getApellido1()) || dato1.getApellido2().equals(this.getApellido2()) || dato1.getApellido1().equals(this.getApellido2()) || dato1.getApellido2().equals(this.getApellido1()))
            esFamiliar = true;

        return esFamiliar;
    }
    
    //EJERCICIO2.1
    public void esJubilado() {
        if(edad > 67) 
            this.setProfesion(this.getProfesion() + " jubilado");
    }

    //EJERCICIO2.2
    public boolean esMenor() {
        boolean menor = false;

        if(this.edad < 18)
            menor = true;

        return menor;
    }
    
    //EJERCICIO2.3
    public static Persona [] trabajaEnSector(Persona dato1 [], String dato2 []) {
        Persona [] array = new Persona [dato1.length];

        for(int a = 0; a < dato1.length; a++) {
            for(int b = 0; b < dato2.length; b++) {
                if(dato1[a].getProfesion().equals(dato2[b]))
                    array[a] = dato1[a];
            }
        }

        for(int a = 0; a < array.length; a++){
            if (array[a] != null)
                System.out.println(array[a].getNombre() + " pertenece a las profesiones incluidas");
        }

        return array;
    }

    //EJERCICIO2.4
    public boolean tieneApellidoCompuesto(){
        String apellido1 = this.getApellido1(), apellido2 = this.getApellido2();
        boolean apellidoCompuesto = false;

        //para apellido1
        int posicionGuion1 = apellido1.indexOf('-');
        
        if(posicionGuion1 != -1){
            int a = posicionGuion1 - 1, b = posicionGuion1 + 1;

            if((a > 0 && a < apellido1.length()) && (b > 0 && b < apellido1.length()))
                apellidoCompuesto = true;
        }

        //para apellido2
        int posicionGuion2 = apellido2.indexOf('-');

        if(posicionGuion2 != -1){
            int a = posicionGuion2 - 1, b = posicionGuion2 + 1;

            if((a > 0 && a < apellido2.length()) && (b > 0 && b < apellido2.length()))
                apellidoCompuesto = true;
        }
        
        return apellidoCompuesto;
    }

}
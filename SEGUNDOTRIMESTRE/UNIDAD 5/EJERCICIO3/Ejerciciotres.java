class Ejerciciotres {
    String mensaje;
    int numero;

    public static void main(String[] args) {
        Ejerciciotres prueba = new Ejerciciotres("Hola este es un mensaje de prueba", 10);
        prueba.imprimirMensaje();

        String nuevo = "insertando mensaje";
        prueba.cambiarMensaje(nuevo);

        int nuevoNum = 20;
        prueba.aumentarNumero(nuevoNum);

        prueba.imprimirMensaje();
    }


    //GETTER's Y SETTER's
    public void setMensaje(String mensaje1){
        mensaje = mensaje1;
    }

    public String getMensaje(){
        return mensaje;
    }

    public void setNumero(int numero1){
        numero = numero1;
    }

    public int getNumero(){
        return numero;
    }

    //CONSTRUCTOR
    public Ejerciciotres (String mensaje1, int numero1){
        mensaje = mensaje1;
        numero = numero1;
    }

    //METODOS
    public void imprimirMensaje(){
        System.out.println(mensaje + " " + numero);
    }

    public void cambiarMensaje(String mensaje1){
        setMensaje(mensaje1);
    }

    public void aumentarNumero(int numero1){
        setNumero(numero + numero1);
    }
}
class EJERCICIO4 {
  public static void main(String args[]) {
    String cadena1 = "Vamos a ver qué es lo que sale de este cambio de letras";
    String cambio1 = "";
    String cambio2 = "";
    int posicion = 0;
    int ultimaposicion = 0;
    int contador = 0;
      
    while (contador < 3) {
      posicion = cadena1.indexOf('a', ultimaposicion);
      cambio1 = cadena1.substring(0, posicion);
      cambio2 = cadena1.substring(posicion + 1);
      cadena1 = cambio1 + "i" + cambio2;
      ultimaposicion = posicion + 1;
      contador++;
    }

    System.out.println(cadena1);
  }
}
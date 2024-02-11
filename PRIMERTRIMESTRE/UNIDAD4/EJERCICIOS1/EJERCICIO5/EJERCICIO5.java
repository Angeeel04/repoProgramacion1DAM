class EJERCICIO5 {
  public static void main(String args[]) {
    String cadena1 = "Esta es una cadena cualquiera" ;

    int longitud = cadena1.length();
    int contador = longitud - 1;

    System.out.print(cadena1);
    System.out.print("\n");

    while(contador >= 0){
      char inversa = cadena1.charAt(contador);
      System.out.print(inversa);
      contador--;
    }
  }
}
class EJERCICIO3 {
  public static void main(String[] args) {
    String cadena = "A ver cuantos asteriscos salen de aquí";
    String subcadena1,subcadena2;

    System.out.println(cadena);
    
    for(int i = 5; i < cadena.length(); i = i + 5) {
      subcadena1 = cadena.substring(0, i);
      subcadena2 = cadena.substring(i+1);
      cadena = subcadena1 + "*" + subcadena2;
    }
    
    System.out.println(cadena);
    
  }
}
class EJERCICIO2 {
  public static void main (String[] args){
    String frase = "Esta es una frase cualquiera";

    for(int a = 0; a < frase.length(); a = a + 5){
      char seleccion = frase.charAt(a);
      System.out.println(seleccion);
  
    }

    //otra forma de hacerlo (teniendo en cuenta si la variable "a" aumentara en 1)
    /*if(a % 5 == 0){
        char seleccion = frase.charAt(a);
        System.out.println(seleccion);
      } */
  }     

}
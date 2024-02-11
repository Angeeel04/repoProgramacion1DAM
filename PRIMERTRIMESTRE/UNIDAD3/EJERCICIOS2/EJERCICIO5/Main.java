class Main {
  public static void main(String[] args) {

  /*Escribe las sentencias necesarias para que salgan por pantalla tantas letras ‘A’ como se indique con un número entero n dado*/

    char letra = 'A';

    for (int n=10; n > 0; n--)
      System.out.println(letra);

    /*Otras formas de hacerlo:

    int veces = 9;

    //forma 1
    do{
      System.out.println(letra);
      veces --;
    }while(veces != 0 );
    
    //forma2
    while(veces > 0){
      System.out.println(letra);
      veces--;
    }*/
  }
}
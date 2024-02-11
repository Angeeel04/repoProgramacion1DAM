package EJERCICIOS_ARRAYS4;
import java.lang.Math;
import java.util.Arrays;

class EJERCICIO3{
  public static void main(String args []){
    int tamaño = 10;
    arrayAleatorio(tamaño);
  }

  public static void arrayAleatorio(int tamaño){
    int array [] = new int [tamaño];
    boolean comprobacion [] = new boolean [tamaño];
    int numero = 0;

    for(int a = 0; a < array.length; a++){
      do{
        numero = ((int) (Math.random() * tamaño)) + 1;
      }while(comprobacion[numero - 1]);

      array[a] = numero;
      comprobacion[numero - 1] = true;
    }

    imprimirArray(array);
  }

  public static void imprimirArray(int array[]){
  System.out.println(Arrays.toString(array));
    System.out.println("");
  }

}
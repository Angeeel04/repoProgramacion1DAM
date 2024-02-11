package EJERCICIOS_ARRAYS3;
class EJERCICIO3{
  public static void main(String[] args) {
       int array [][] = new int [5][2];
    int numero = 0;

    for(int a = 0; a < array.length; a++){
      for(int b = 0; b < array[a].length; b++){
        array[a][b] = numero;
        System.out.println("Fila: " + a + " Columna: " + b  + " = " + array[a][b]);
        numero++;
      }
      System.out.println("");
    }

    for(int a = 0; a < array.length; a++){
      int suma = 0;

      for(int b = 0; b < array[a].length; b++){
        suma += array[a][b];
      }
      System.out.println("Suma de los elementos de la fila " + a + " = " + suma);
    }
  }
}
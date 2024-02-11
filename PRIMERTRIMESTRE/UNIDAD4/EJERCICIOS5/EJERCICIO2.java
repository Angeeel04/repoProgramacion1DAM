package EJERCICIOS_ARRAYS3;
class EJERCICIO2 {
  public static void main(String[] args) {
    int array [][] = new int [2] [4]; // 5 y 2 filas
    int numero = 0;

    for(int a = 0; a < array.length; a++){
      for(int b = 0; b < array[a].length;b++){
        array [a][b] = numero;
        System.out.println("Fila: " + a + " Columna: " + b + " Valor = " + array[a][b]);
        numero++;
      }
    }
  }
}
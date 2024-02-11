package EJERCICIOS_ARRAYS3;
class EJERCICIO1{
  public static void main(String[] args) {
    int array [][] = new int [5] [2]; // 5 filas y 2 columnas
    int numero = 0;

    for(int a = 0; a < array.length; a++){ //el limite será la longitud de las filas, en este caso 5
      for(int b = 0; b < array[a].length;b++){  //por cada fila hay dos columnas, entonces b será 0 y 1
        array [a][b] = numero;
        System.out.println("Fila: " + a + " Columna: " + b + " Valor = " + array[a][b]);
        numero++;
      }
    }
  }
}
package EJERCICIOS_ARRAYS3;
class EJERCICIO4{
  public static void main(String args []){
    int matriz[][] = new int [5][2];
    int numero = 0;

    for(int a = 0; a < matriz.length; a++){
      for(int b = 0; b < matriz[a].length; b++){
        matriz[a][b] = numero;
        numero++;

        System.out.println("Fila: " + a + " Columna: " + b + " Valor= " + matriz[a][b]);
      }
      System.out.println("");
    }

    int suma = 0;

    for(int a = 0; a < matriz[0].length; a++){ //longitud de las columnas (el numero puede ir de 0 a 4)
      for(int b = 0; b < matriz.length; b++){ //longitud de las filas
        suma += matriz[b][a];
      }
      System.out.println(suma);
    }
  }
}
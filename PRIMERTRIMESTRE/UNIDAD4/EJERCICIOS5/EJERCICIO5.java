package EJERCICIOS_ARRAYS3;
class EJERCICIO5{
  public static void main(String[] args) {
    int matriz[][] = new int [4][4];

    for(int a = 0; a < matriz.length; a++){
      for(int b = 0; b < matriz[a].length; b++){
        matriz[a][b] = a * b;
        System.out.println("Fila: " + a + " Columna: " + b + " Valor: " + matriz[a][b]);
      }
      System.out.println("");
    }
  }
}
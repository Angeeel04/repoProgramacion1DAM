package EJERCICIOS_ARRAYS4;
class EJERCICIO4 {
  public static void main(String args []){
    int array [][] = { {2,3,5,-1}, {6,1,2,7}, {9,4,8,3}, {5,4,2,3}};
    int posicion = 25;
    imprimirArray(array);
    multiplicaPorPosicion(array, posicion);
  }

  public static void multiplicaPorPosicion(int array[][], int posicion){
    int contador = 0, multiplicador = 1;

    for(int a = 0; a < array.length; a++){
      for(int b = 0; b < array[a].length; b++){
        if(contador == posicion){
          multiplicador = array[a][b];
        }
        contador++;
      }
    }

    for(int a = 0; a < array.length; a++){
      for(int b = 0; b < array[a].length; b++){
        if(multiplicador != 1)
          array[a][b] *= multiplicador;
        
        else
          array[a][b] = multiplicador;
      }
    }

    imprimirArray(array);
  }
  
  public static void imprimirArray(int array[][]){
    for(int a = 0; a < array.length; a++){
      System.out.println(Arrays.toString(array[a]));
    }
    
    System.out.println("");
  }
}
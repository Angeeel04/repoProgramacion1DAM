import java.util.Arrays;
class EJERCICIO2{
    public static void main(String args []){
    int array [][] = { {2,3,5,-1}, {6,1,2,7}, {9,4,8,3}, {5,4,2,3}};
    System.out.println("Matriz uno: " + "\n");
    imprimirArray(array);
    
    System.out.println("Matriz traspuesta: " + "\n");
    matrizTraspuesta(array);
  }

  public static void imprimirArray(int array[][]){
    for(int a = 0; a < array.length; a++){
      System.out.println(Arrays.toString(array[a]));
    }
    System.out.println("");
  }

  public static void matrizTraspuesta(int array[][]){
    for(int a = 0; a < array.length; a++){
      for(int b = 0; b < array.length; b++){
        if(a>b){
          int aux = array[a][b];
          array[a][b] = array[b][a];
          array[b][a] = aux;
        }
      }
    }

    imprimirArray(array);
  }
}

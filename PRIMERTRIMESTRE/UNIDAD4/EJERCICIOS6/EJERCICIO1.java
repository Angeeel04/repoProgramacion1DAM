package EJERCICIOS_ARRAYS4;
class EJERCICIO1{
  public static void main(String args []){
    int array [][] = { {2,3,5,-1}, {6,1,2,7}, {9,4,8,3}, {5,4,2,3}};
    System.out.println("Suma externos: " + sumaExternos(array));
  }

  public static int sumaExternos(int array[][]){
    int suma = 0;
    
    for(int a = 0; a < array.length; a++){
      for(int b = 0; b < array[a].length; b++){
        
        if(a == 0 || a == (array.length - 1) || b == 0 || b == (array.length -1))
          suma += array[a][b];
        
      }
    }
    return suma;
  }
}
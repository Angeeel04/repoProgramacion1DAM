public class Main {
      /*Define una función que determine si un número entero dado como parámetro es
    múltiplo del entero que se proporciona como segundo parámetro.*/
  public static void main(String[] args) {
    int num1 = 4, num2 = 2;
    System.out.println(numEnteros(num1, num2));
  }

  public static boolean numEnteros(int num1 , int num2){
    boolean respuesta = false;
      if (num1 % num2 == 0){
        respuesta = true;
      }

    return respuesta;
  }

}
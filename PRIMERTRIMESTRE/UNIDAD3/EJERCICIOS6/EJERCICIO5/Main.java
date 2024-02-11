public class Main {
  /*Define una función que determine cuantos divisores tiene un número entero positivo
  dado como parámetro. Si el número estudiado fuera negativo se ha de indicar con un
  mensaje y devolver cero.*/
  
  public static void main(String[] args) {
    int numero1 = 10;
    numDivisores(numero1);
  }

  public static void numDivisores(int numero1){
    int contador = 0;

    if(numero1 == 0){
      System.out.println("el numero es 0");
      System.out.println("el numero " + numero1 + " tiene " + contador + " divisores.");
    }

    else if(numero1 <= 0){
      System.out.println("el numero es negativo");
      System.out.println("el numero " + numero1 + " tiene " + contador + " divisores.");
    }

    else{  
      for (int a = 1; a <= numero1; a++){
        if (numero1 % a == 0) {
          contador++;
        }
      }
      System.out.println("el numero " + numero1 + " tiene " + contador + " divisores.");
    }
  }
}
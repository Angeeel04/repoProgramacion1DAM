import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num;
    long operacion = 1;

    do{
      System.out.println("Introduce un numero entre el 0 y 20 ");
      num = sc.nextInt(); //ingresamos el numero
    }while(num < 0 || num > 20);

    System.out.println("Tu numero elegido es: " + num); //muestra el numero elegido
    
    for(int factorial = num; factorial > 0; --factorial){ //declaramos e inicializamos la variable factorial
      operacion = operacion * factorial;      
    }
    
    System.out.println("El resultado factorial es: " + operacion);

    sc.close();
  }
}
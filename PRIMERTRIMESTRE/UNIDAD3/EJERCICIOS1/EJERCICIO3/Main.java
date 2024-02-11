import java.util.Scanner;
class Main {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int num;

    System.out.print("Introduce un número entero: ");
    num = sc.nextInt(); // Si el numero introducido es 5 ...

    System.out.println("Número introducido: " + num); // Devuelve "Número introducido: 5"
    System.out.println("Doble de: " + num + " -> " + 2 * num); // Devuelve "Doble de: 5 -> 10"
    System.out.println("Triple de: " + num + " -> " + 3 * num); // Devuelve "Triple de: 5 -> 15"
    
    sc.close();

  }
      
}
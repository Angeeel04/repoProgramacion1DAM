import java.util.Scanner;

class Main {
    public static void main(String args[]) {
      
    Scanner sc = new Scanner(System.in); 
    System.out.println("Introduce un numero...");
    int variable1 = sc.nextInt();

    System.out.println("Tu numero es: " + variable1++);

    System.out.println("Los tres numeros siguientes son: " + (variable1++) + " " + (variable1++) + " " + (variable1++));
  
    sc.close();

    }
}
import java.util.Scanner;
class Main {
    public static void main(String args[]) {
      
    Scanner sc = new Scanner(System.in);
    float num1 = 0;
    float num2 = 0;   
    float division;   

    System.out.println("Ingrese primer valor decimal: ");
    num1 = sc.nextFloat();
      
    System.out.println("Ingrese segundo valor decimal: ");
    num2 = sc.nextFloat();

    division = num1 / num2 ; 

    System.out.println("La división entre ambos es: " + division);
      
    sc.close();
      
    }
}
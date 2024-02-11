import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    
    System.out.println("Ingrese un numero: ");
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt(); //ingresamos el numero
    float variable; //declaramos una variable de tipo float
    variable = (float) num; // convertimos num a float y se la asignamos a variable
    int numCifras = 0; //creamos una variable que aumentara en cada iteracion

        do{
          variable = variable / 10; 
          numCifras ++;
        }while (variable >= 1);

    System.out.print("Tu numero tiene: " + numCifras + " cifras");

    sc.close();

  }
} 
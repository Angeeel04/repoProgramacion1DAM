import java.util.Scanner;
class Main {
  public static void main(String args[]) {

  Scanner sc = new Scanner(System.in);
  int n, muestra = 1;

  do{
    System.out.println("Repita el siguiente número: " + muestra );
    n = sc.nextInt();
    muestra++;

  } while(n != muestra - 1);
   /*ingresamos la siguiente condicion ya que como la variable muestra aumenta en cada iteracion, 
   debemos comparar el numero ingresado con un valor anterior de la muestra */

  sc.close();

  }
      
}
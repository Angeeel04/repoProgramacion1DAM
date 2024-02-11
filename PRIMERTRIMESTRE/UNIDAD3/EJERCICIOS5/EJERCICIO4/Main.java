import java.util.Scanner;
class Main {
  public static void main(String args[]) {

    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese un numero: ");
    int num = sc.nextInt();

    if (num % 2 == 0){
      System.out.println(num + " Es multiplo de 2");
      
      if (num % 3 == 0){
        System.out.println(num + " Es multiplo de 3");
      }
        if (num % 5 == 0){
        System.out.println(num + " Es multiplo de 5");
        }
    }
    
    else{
        System.out.println("No es multiplo de ninguno");
    }

    sc.close();
  }
}
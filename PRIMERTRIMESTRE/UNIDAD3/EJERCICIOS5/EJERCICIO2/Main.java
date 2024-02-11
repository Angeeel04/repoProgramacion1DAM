import java.util.Scanner;
class Main {
  public static void main(String args[]) {
  
  Scanner sc = new Scanner(System.in);
  System.out.println("Ingrese el primer numero: ");
  int numA = sc.nextInt();
    
  System.out.println("Ingrese el segundo numero: ");
  int numB = sc.nextInt();
    
  System.out.println("\n");
    
  System.out.println("Listado descendente: ");

    do{
        System.out.println(numA);
        numA --;
      }while(numA > numB);

    do{
        System.out.println(numB);
        numB --;
      }while(numA < numB);

      sc.close();
  }
}

        /*if(numA>numB){
          System.out.println(numA);
          numA --;
        } else{
          System.out.println(numB);
          numB --;
        }*/
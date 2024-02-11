import java.util.Scanner;
class Main {
  public static void main(String[] args) {

  Scanner sc = new Scanner(System.in);
  int base, altura;
  float area;

  System.out.println("Ingrese un valor para la base: ");
  base = sc.nextInt();
    
  System.out.println("Ingrese un valor para la altura: ");
  altura = sc.nextInt();

  area = ((base * altura) / 2 );

  System.out.println("El area del triangulo es: " + area);

  sc.close();
  }
}    

import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    int base, altura;
    float area;
    Scanner sc = new Scanner(System.in);

    System.out.println("Ingrese un valor para la base: ");
    base = sc.nextInt();
    
    System.out.println("Ingrese un valor para la altura: ");
    altura = sc.nextInt();

    if(base > altura && base % altura == 0.0){
      area = (base * altura);
      System.out.println("El area del rectangulo es: " + area);
    }
    
    else {
      System.out.println("No se puede calcular");
    }

    sc.close();

  }
}    

import java.util.Scanner;

class ENTREGA_2 {

  public static void main(String[] args) {
    /*Hecho por Angel Chavez 1º DAM*/

    System.out.println("Figuras disponibles:  \n  \n");
    System.out.println("1 Rectangulo");
    System.out.println("2 Triangulo");
    System.out.println("3 Rombo \n");
    System.out.print("Pulse el numero de la opcion deseada: ");

    Scanner sc = new Scanner(System.in);
    int opcionUsuario = sc.nextInt();
    menu(opcionUsuario);
    sc.close();
  }

  public static void menu(int num) {

    if(num == 1){
      crearRectangulo();
    }
        
    else if(num == 2){
        crearTriangulo();
    }
      
    else if(num == 3){
        crearRombo();
    }

    else{
      System.out.println("Opción no valida: " + num);
    }
  }

  public static void crearRectangulo() {
    Scanner sc = new Scanner(System.in);
    int baseRectangulo, alturaRectangulo;
    boolean salir = false;

    do { // nos aseguramos de que el usuario introduzca valores positivos para la base y altura
      System.out.print("\n");
      System.out.print("Introduzca la longitud de la base: ");
      baseRectangulo = sc.nextInt();

      System.out.print("\n");

      System.out.print("Introduzca la longitud de la altura: ");
      alturaRectangulo = sc.nextInt();

      System.out.print("\n \n");

      if (baseRectangulo <= 0 || alturaRectangulo <= 0) { // notificamos el error si se detectan valores negativos o nulos
        System.out.println("ERROR: los valores son negativos o nulos");
        salir = false;
      } else {
        salir = true;
      }
    } while (!salir);

    for (int baseAsteriscos = baseRectangulo; baseAsteriscos > 0; baseAsteriscos--) { // se imprime la base superior del rectangulo
      System.out.print("*");
    }

    System.out.print("\n");

    for (int alturaAsteriscos = alturaRectangulo - 2; alturaAsteriscos > 0; alturaAsteriscos--) { // se imprime un lado del rectangulo
      System.out.print("*");

      for (int a = baseRectangulo - 2; a > 0; a--) { // se imprimen los espacios en blanco del centro del rectangulo
        System.out.print(" ");
      }

      System.out.println("*"); // se imprime el otro lado del rectangulo
    }

    for (int baseAsteriscos = baseRectangulo; baseAsteriscos > 0; baseAsteriscos--) { // se imprime la base inferior del rectangulo y tendriamos el rectangulo completo
      System.out.print("*");
    }

    System.out.println("\n");
    System.out.println("Rectángulo terminado");

    sc.close();
  }

  public static void crearTriangulo() {
    Scanner sc = new Scanner(System.in);
    int baseTriangulo, alturaTriangulo;
    boolean salir = false;

    do { // nos aseguramos de que el usuario introduzca valores positivos e impares para la base
      System.out.print("\n");
      System.out.print(
        "Introduzca un valor impar para la longitud de la base: "
      );

      baseTriangulo = sc.nextInt();
      if (baseTriangulo < 0 || baseTriangulo % 2 == 0) {
        System.out.print("\n \n");
        System.out.println("ERROR: la longitud ha de ser positiva e impar"); // notificamos el error si se detectan valores negativos o nulos
        salir = false;
      } else {
        salir = true;
      }
    } while (!salir);

    System.out.print("\n");

    alturaTriangulo = (baseTriangulo - 1) / 2;

    for (int a = 0; a < alturaTriangulo; a++) {
      for (int b = 0; b < baseTriangulo; b++) {
        if (b == alturaTriangulo + a || b == alturaTriangulo - a) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println("");
    }

    for (int a = 0; a < baseTriangulo; a++) { // imprimimos la base del triangulo y tendriamos el triangulo completo
      System.out.print("*");
    }

    System.out.println("\n");
    System.out.println("Triángulo terminado");

    sc.close();
  }

  public static void crearRombo() {
    Scanner sc = new Scanner(System.in);
    int ladoRombo, alturaRombo;
    boolean salir = false;

    do { // nos aseguramos de que el lado del rombo sea positivo e impar
      System.out.print("\n");
      System.out.print("Introduzca un valor impar para la longitud del lado: ");
      ladoRombo = sc.nextInt();

      if (ladoRombo < 0 || ladoRombo % 2 == 0) {
        System.out.print("\n \n");
        System.out.println("ERROR: la longitud ha de ser positiva e impar"); // notificamos el error si se detectan valores negativos o nulos
        salir = false;
      } else {
        salir = true;
      }
    } while (!salir);

    System.out.print("\n");

    alturaRombo = (ladoRombo - 1) / 2;

    for (int a = 0; a < alturaRombo; a++) {
      for (int b = 0; b < ladoRombo; b++) {
        if (b == alturaRombo + a || b == alturaRombo - a) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println("");
    }

    for (int a = 0; a < ladoRombo; a++) {
      if (a == 0 || a == ladoRombo - 1) {
        System.out.print("*");
      } else {
        System.out.print(" ");
      }
    }

    System.out.println("");

    for (int a = alturaRombo - 1; a >= 0; a--) {
      for (int b = 0; b < ladoRombo; b++) {
        if (b == alturaRombo + a || b == alturaRombo - a) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println("");
    }

    System.out.print("\n");
    System.out.println("Rombo terminado"); // separamos el rombo de la frase final con un salto de linea y tendriamos el rombo completo

    sc.close();
  }
}
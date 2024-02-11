class Main {
    public static void main(String args[]) {

      char variable1 = 'A';
      char variable2 = '0';

      System.out.println("valor 1: " + variable1);
      System.out.println("valor 2: " + variable2);
      System.out.println("suma (sin parentesis): " + variable1 + variable2); 
      System.out.println("suma (con parentesis): " + (variable1 + variable2));

      System.out.println("suma: " + (char)(variable1 + variable2));
      //lo que se hace en esta ultima linea es el cast o conversion de la suma de ambas variables, por esa razon nos imprime "q" (caracter 113 en UNICODE)
    }
}
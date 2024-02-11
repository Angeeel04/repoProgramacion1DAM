public class Main {
  public static void main(String[] args) {
    int numero1 = 20;
    System.out.println(numImpar(numero1));

  }
      
    public static boolean numImpar(int numero1){
      boolean resultado = false;
      if (numero1 % 2 != 0)
        resultado = true;

      return resultado;
  }
  
}
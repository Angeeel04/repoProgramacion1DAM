public class Main {
  public static void main(String[] args) {

    float numero1 = 3.00f;
    float numero2 = 3.00f;

    System.out.println(numIguales(numero1, numero2));

  }
      
    public static boolean numIguales(float numero1, float numero2){
      boolean resultado = false;
      if (numero1 == numero2)
        resultado = true;

      return resultado;
  }
  
}
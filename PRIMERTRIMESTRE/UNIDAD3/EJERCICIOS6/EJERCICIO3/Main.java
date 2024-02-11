class Main {
  public static void main(String[] args) {
    int numero1 = 12;
    System.out.println(numPrimo(numero1));

  }
      
  public static boolean numPrimo(int num){
    boolean resultado = false;
    int contador = 0;

    for(int a = 1; a <= num; a++){        
      if(num % a == 0)
        contador++;
      }

      if(contador == 2)
        resultado = false;

      return resultado;
  }
  
}
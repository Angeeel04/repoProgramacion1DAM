class Main {
  public static void main(String[] args) {
    int num = 8;
    int contador = 0;

    for(int divisor=num; divisor >= 1 ; divisor--){
    
      if (num % divisor== 0){
        contador ++;
        System.out.println(divisor);
      }
    }

      System.out.println("Este numero tiene : " + contador + " divisores.");

  }
}
class Main {
  public static void main(String[] args) {
    float [] a = {1,3,5,7,9};
    float [] b = {6,4,2,1,3};
    float numero = 0.0f;

    for(int i = 0 ; i < a.length; i++){    
      numero = (a[i] * b[i]);
      numero = numero / 10;
      System.out.println(numero);
    }

  }
}

class Main {
  public static void main(String[] args) {
    int [] a = {1,4,6,10,-3,4,6,-5};
    int suma = 0;

    for(int i = 0 ; i < a.length; i++){
      suma = suma +  a[i];
    }

    System.out.println(suma);
  }
}

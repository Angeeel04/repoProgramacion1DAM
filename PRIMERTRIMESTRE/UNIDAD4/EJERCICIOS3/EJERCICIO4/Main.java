class Main {
  public static void main(String[] args) {
    int [] a = {2,3,4,7,8,10,11};
    int suma = 0;

    for(int i = 0 ; i < a.length; i++){
      if(a[i] % 2 == 0){
        System.out.println("El numero " + a[i] + " es par");
      }

      else{
        System.out.println("El numero " + a[i] + " es impar");
      }
    }

  }
}

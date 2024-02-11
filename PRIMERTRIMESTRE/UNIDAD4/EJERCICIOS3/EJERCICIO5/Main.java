class Main {
  public static void main(String[] args) {
    int [] a = {2, 3, 4, 7, 8, 10, 11};
    int [] b = new int [a.length];
    int [] c = new int [a.length];

    for(int i = 0 ; i < a.length; i++){
      if(a[i] < 6){
        b[i] = b[i] + a[i];
        System.out.println(a[i] + " es menor que 6");   
      }
        
      else{
        c[i] = c[i] + a[i];
        System.out.println(a[i] + " es mayor que 6");  
      }
    } 

  }
}

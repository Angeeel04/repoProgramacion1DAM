class Main {
  public static void main(String[] args) {
    int [] a = {2,3,4,7,8,10,11};
    int [] par = new int [a.length];
    int [] impar = new int [a.length];

    for(int i = 0 ; i < a.length; i++){
      if(a[i] % 2 == 0){
        par[i] = par[i] + a[i];
        System.out.println(a[i] + " es par");   
      }
        
      else{
        impar[i] = impar[i] + impar[i];
        System.out.println(a[i] + " es impar");  
      }
    } 

  }
}
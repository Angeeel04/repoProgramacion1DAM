class Main {
  public static void main(String[] args) {
    int [] a = {2,3,4,7,8};
    int [] b = new int [a.length];
    int c = 10;

    for(int i = 0 ; i < a.length; i++){    
       b[i] = b[i] + (a[i] * c);
      c = c * 10;
    } 

    for(int i = 0; i < b.length; i++){
      System.out.println(b[i]);
    }

  }
}
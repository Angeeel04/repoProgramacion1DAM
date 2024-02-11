class Main {
  public static void main(String[] args) {
    int [] a = {1,3,5,7,8};
    int [] b = {1,2,3,4,5};
    int [] c = new int [a.length/2];

    for(int i = 1 ; i < a.length; i = i + 2){
      c[i] = a[i] + b [i];
      System.out.println(c[i]);
    }

  }
}

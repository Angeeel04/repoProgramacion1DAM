class Main {
  public static void main(String[] args) {
    int [] a = {1,3,5,7,8};
    int [] b = {1,2,3,4,5};
    int [] c = new int [a.length];

    for(int i = 0 ; i < a.length;i++){
      c[i] = a[i] + b [i];
      System.out.println(c[i]);
    }

  }
}

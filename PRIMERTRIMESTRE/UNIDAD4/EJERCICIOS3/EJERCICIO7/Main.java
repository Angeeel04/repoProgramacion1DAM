class Main {
  public static void main(String[] args) {
    int [] array1 = {2,3,4,7,8,10,11};
    int [] array2 = new int[array1.length * 2];

    for (int i = 0; i < array1.length * 2; i++){
      
      if(i % 2 == 0){
        array2[i] = array1[i/2];
      }
      
      else{
        array2[i] = 0;
      }

      System.out.println(array2[i]);

    }

  }
}
class Main {
  public static void main(String[] args) {
  int suma = 0;
    
  for (int num = 33; num <= 66; num++){

      if (num % 3 == 0){
        suma = suma + num;
      }
    }
    
    System.out.println(suma);
  
    /*int num = 33;

	    while(num <= 66){
	      int resto = num % 3;
       
	      if (resto == 0){
	        suma = suma + num;
	      } 
	      num ++;
	    }
	
	    System.out.println(suma);*/

 }
}
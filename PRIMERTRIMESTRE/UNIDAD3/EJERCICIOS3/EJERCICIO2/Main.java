class Main {
  public static void main(String[] args) {

    //Sumar todos los números desde el 1 hasta el 40, exceptuando los que acaban en 5.
    
    int suma = 0; // esta variable almacenará la suma de los numeros del 1 al 40
    int suma1 = 0; // esta variable almacenará la suma de los numeros que no acaben en 5
    
    for(int num1 = 1; num1 <= 40 ; num1++){
        suma = suma + num1; // esta suma devuelve 820
      
      if(num1 % 5 == 0 && num1 % 10 != 0){
        suma1 = suma1 + num1; // esta suma devuelve 80
      }
    }  

    System.out.println(suma-suma1); // resta 820 - 80 y eso da 740
    
  }
}
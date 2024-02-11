class EJERCICIO1 {
  public static void main(String[] args) {
    String [] array1 = {"coche", "casa", "avión", "tren"};
    int [] array2 = new int [array1.length];

    for(int i = 0; i < array1.length; i++){
      int contador = 0;
      String palabra = array1 [i];

        for(int a = 0; a < palabra.length(); a++){
          contador += 1;
        }

      array2[i] = contador;

    }
        
    //Comprobamos que el array tiene los elementos correctos
    //  for(int a = 0; a < array2.length; a++){
    //    System.out.println(array2[a]);
    //  }


  }
}
class EJERCICIO2 {
  public static void main(String[] args) {
    int [] a = {3,2,4,4,5,6,7,9};
    int [] b = new int [a.length / 2];
    int [] c = new int [a.length / 2];
    int contador = 0;
    
    for(int i = 0; i < a.length; i++){

      if(contador < 4){
        b[i] = a[i];

        //Comprobamos que el array tiene los elementos correctos
        //System.out.println("menor" + b[i]);
      }

      else{
        c[i] = a[i];

        //Comprobamos que el array tiene los elementos correctos
        //System.out.println("mayor" + c[i]);
      }

      contador++;

    }

  }
}

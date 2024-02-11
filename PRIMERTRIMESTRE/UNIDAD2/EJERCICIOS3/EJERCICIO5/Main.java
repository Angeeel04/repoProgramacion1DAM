class Main {
    public static void main(String args[]) {
      short variable1 = 3;
      short variable2 = 6;
      char variable3;

      System.out.println("La variable1 es " + variable1);
      System.out.println("La variable2 es " + variable2);

      //el ejercicio solicitaba el uso del operador ternario, pero se haria mas simple el uso de condicionales
      
      /*variable3 = (variable1>variable2) ?'V':'F' ;
      System.out.println("¿ La variable 1 es mayor que la variable2 ? " + variable3); */

      if(variable1 > variable2){
        variable3 = 'V';
        System.out.println(variable3);
      }
      
      else{
        variable3 = 'F';
        System.out.println(variable3);
      }

    }
}
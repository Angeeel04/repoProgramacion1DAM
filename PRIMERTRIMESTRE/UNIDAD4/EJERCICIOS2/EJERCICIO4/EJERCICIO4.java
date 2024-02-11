class EJERCICIO4 {
  public static void main(String[] args) {
    
    String frase1 = "Comenzamos la cuenta atrás";
    String frase2 = "Llegando al final";
    String frase3 = "!Listo!";


    for(int contador = 15; contador >= 0; contador--){
      switch(contador){

        case 15:
          System.out.println(frase1);
          break;

        case 5:
          System.out.println(frase2);
          break;

        case 0:
          System.out.println(frase3);
          break;
        
        default:
          System.out.println(contador);

      }
    }
    
  }
}
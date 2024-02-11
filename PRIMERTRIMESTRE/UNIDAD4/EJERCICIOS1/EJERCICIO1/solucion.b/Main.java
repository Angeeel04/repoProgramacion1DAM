public class Main {
/*En la frase siguiente “Esta es una frase cualquiera”, eliminar los espacios y mostrar el cambio realizado.*/
 
  public static void main(String[] args) {

    String frase = "Esta es una frase cualquiera";

    String frase1 = frase.substring(0,4);
    String frase2 = frase.substring(5,7);
    String frase3 = frase.substring(8,11);
    String frase4 = frase.substring(12,17);
    String frase5 = frase.substring(18,28);

    System.out.print(frase1 + frase2 + frase3 + frase4 + frase5);
    
  }
  
}
public class Main {
/*Define una función que acepte un carácter como parámetro e imprima un saludo de
“Buenas tardes “ más el carácter suministrado.*/
  
  public static void main(String[] args) {
    char inicial = 'A';
    saludo(inicial);
  }
      
  public static void saludo(char letra){
    System.out.println("Buenas tardes " + letra);
  }
  
}
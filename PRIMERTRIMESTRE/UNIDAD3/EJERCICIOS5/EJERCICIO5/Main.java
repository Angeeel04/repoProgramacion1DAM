import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    //solicitamos al usuario que introduzca 3 numeros distintos
    
    System.out.println("Ingrese 3 numeros distintos ");
    System.out.println(" ");

    System.out.println("Ingrese el primer numero: ");
    int numA = sc.nextInt();

    System.out.println("Ingrese el segundo numero: ");
    int numB = sc.nextInt();

    System.out.println("Ingrese el tercer numero: ");
    int numC = sc.nextInt();

    if(numA != numB && numB != numC && numA != numC){ // iniciará si todos los datos son distintos

      //primer caso
      if(numA > numB && numB > numC){
        System.out.println(" ");
        System.out.println("1º " + numA); 
        System.out.println(" ");
        System.out.println("2º " + numB);
      
        //restamos para saber a cuantos numeros antes o despues se encuentra
        
          int resta1 = numA - numB;
          int resta2 = numB - numC; 

        //comparamos y depende a la resta que sea mayor estará más cerca de uno que de otro
        
        if(resta1>resta2){
        System.out.println("Está a: " + resta2 + " de " + numC);
        }
          
        if(resta2>resta1){
          System.out.println("Está a: " + resta1 + " de " + numA);
        }
          
        //si ambas restas no son ni mayores ni menores a la otra serán iguales, es decir, equidistante
          
        else{ 
          System.out.println("Es equidistante a: " + numA + " y " + numC);
        }
        
        System.out.println(" ");  
        System.out.println("3º " + numC);
      }

      //segundo caso
      if(numA > numC && numC > numB){
        System.out.println(" ");
        System.out.println("1º " + numA);
        System.out.println(" ");
        System.out.println("2º " + numC);
        
        int resta1 = numA - numC;
        int resta2 = numC - numB;

        if(resta1 > resta2){
          System.out.println("Está a: " + resta2 + " de " + numB);
        }
          
        if (resta2 > resta1) {
          System.out.println("Está a: " + resta1 + " de " + numA);
        }

        else{
          System.out.println("Es equidistante a: " + numA + " y " + numB);
        }

        System.out.println(" ");
        System.out.println("3º " + numB);
      }

      //tercer caso
      if(numB > numA && numA > numC){
        System.out.println(" ");
        System.out.println("1º " + numB);
        System.out.println(" ");
        System.out.println("2º " + numA);
          int resta1 = numB - numA;
          int resta2 = numA - numC;

        if(resta1>resta2){
          System.out.println("Está a: " + resta2 + " de " + numC);
        }
          
        if(resta2 > resta1) {
          System.out.println("Está a: " + resta1 + " de " + numB);
        }

        else{
          System.out.println("Es equidistante a: " + numB + " y " + numC);
        }

        System.out.println(" ");
        System.out.println("3º " + numC);
      }

      //cuarto caso
      if(numB > numC && numC > numA){
        System.out.println(" ");
        System.out.println("1º " + numB);
        System.out.println(" ");
        System.out.println("2º " + numC);
          int resta1 = numB- numC;
          int resta2 = numC - numA;

        if(resta1>resta2){
          System.out.println("Está a: " + resta2 + " de " + numA);
        }
          
        if(resta2 > resta1) {
          System.out.println("Está a: " + resta1 + " de " + numB);
        }

        else{
          System.out.println("Es equidistante a: " + numA + " y " + numB);
        }
        
        System.out.println(" ");
        System.out.println("3º " + numA);
      }

      //quinto caso
      if(numC > numA && numA > numB){
        System.out.println(" ");
        System.out.println("1º " + numC);
        System.out.println(" ");
        System.out.println("2º " + numA);
          int resta1 = numC - numA;
          int resta2 = numA - numB;

        if(resta1>resta2){
          System.out.println("Está a: " + resta2 + " de " + numB);
        }
          
        if(resta2 > resta1) {
          System.out.println("Está a: " + resta1 + " de " + numC);
        }
          
        else{
          System.out.println("Es equidistante a: " + numA + " y " + numB);
        }

        System.out.println(" ");
        System.out.println("3º " + numB);
      }

      //sexto caso
      if(numC > numB && numB > numA){
        System.out.println(" ");
        System.out.println("1º " + numC);
        System.out.println(" ");
        System.out.println("2º " + numB);
        int resta1 = numC - numB;
        int resta2 = numB - numA;

        if(resta1>resta2){
          System.out.println("Está a: " + resta2 + "de " + numA);
        }
          
        if(resta2 > resta1) {
          System.out.println("Está a: " + resta1 + "de " + numC);
        }

        else{
          System.out.println("Es equidistante a: " + numA + " y " + numB);
        }

        System.out.println(" ");
        System.out.println("3º " + numA);
      }
    }

    else{
      System.out.println(" ");
      System.out.println("Números inválidos. ");
    }
    
  }
}
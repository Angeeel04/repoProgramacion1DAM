import java.util.Scanner;
class ENTREGA_1{
  public enum Estacion {INVIERNO, PRIMAVERA, VERANO, OTOÑO};
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

      System.out.println("Calcula la estación metereologica de concepción a partir del dia de nacimiento \n" );  
      System.out.print("Introduce el día de nacimiento (1-31): ");  
      int diaNacimiento = sc.nextInt();
  
      System.out.println(" ");
    
      System.out.print("Introduce el mes de nacimiento (1-12): ");
      int mesNacimiento = sc.nextInt();
      
      System.out.println(" ");
  
      int mesConcepcion = mesNacimiento + 3;
  
      if((diaNacimiento >= 1 && diaNacimiento <= 31 && (mesNacimiento == 1 || mesNacimiento == 3 || mesNacimiento == 5|| mesNacimiento == 7 || mesNacimiento ==8 || mesNacimiento == 10 || mesNacimiento ==12)) 
      || (diaNacimiento >= 1 && diaNacimiento <= 30 && (mesNacimiento == 4 || mesNacimiento == 6 || mesNacimiento == 9)) 
      || (mesConcepcion == 2 && diaNacimiento <= 28)){ //creamos una condicion que nos compruebe si el dia y el mes se encuentre en el rangos correcto
          
      switch (mesConcepcion){ //creamos un switch para cada caso que pueda ocurrir para cada mes
        case 1:
        case 2: //en caso de que el mes de concepcion sea enero o febrero
          System.out.println("Eres producto de una pasión de: " + Estacion.INVIERNO);
        break;

        case 3: //en caso de que el mes de concepcion sea marzo
          if(diaNacimiento <= 20){
            System.out.println("Eres producto de una pasión de: " + Estacion.INVIERNO);
          }
              
          else if(diaNacimiento >= 21){
            System.out.println("Eres producto de una pasión de: " + Estacion.PRIMAVERA);
          }
        break;
            
        case 4:
        case 5: //en caso de que el mes de concepcion sea abril o mayo
          System.out.println("Eres producto de una pasión de: " + Estacion.PRIMAVERA);    
        break;

        case 6: //en caso de que el mes de concepcion sea junio
          if(diaNacimiento <= 20){
            System.out.println("Eres producto de una pasión de: " + Estacion.PRIMAVERA);
          }

          else if(diaNacimiento >= 21){
            System.out.println("Eres producto de una pasión de: " + Estacion.VERANO);
          }
        break;

        case 7:
        case 8: //en caso de que el mes de concepcion sea julio o agosto
          System.out.println("Eres producto de una pasión de: " + Estacion.VERANO);
        break;

        case 9: //en caso de que el mes de concepcion sea septiembre
          if(diaNacimiento <= 20){
            System.out.println("Eres producto de una pasión de: " + Estacion.VERANO);
          }

          else if(diaNacimiento >= 21){
            System.out.println("Eres producto de una pasión de: " + Estacion.OTOÑO);
          }
        break;

        case 10:
        case 11: //en caso de que el mes de concepcion sea octubre o noviembre
          System.out.println("Eres producto de una pasión de: " + Estacion.OTOÑO);
        break;
    
        case 12: //en caso de que el mes de concepcion sea diciembre
          if(diaNacimiento <= 20){
            System.out.println("Eres producto de una pasión de: " + Estacion.OTOÑO);
          }

          else if(diaNacimiento >= 21){
            System.out.println("Eres producto de una pasión de: " + Estacion.INVIERNO);
          }
        break;
      }
    
    }

    else{ //en caso de que la fecha introducida sea inválida
      System.out.println(" ");
      System.out.println("Fecha inválida");
    }
    
    System.out.println(" ");  
    System.out.println("Programa terminado"); // finalizamos el programa
      
    sc.close();
      
  }
}
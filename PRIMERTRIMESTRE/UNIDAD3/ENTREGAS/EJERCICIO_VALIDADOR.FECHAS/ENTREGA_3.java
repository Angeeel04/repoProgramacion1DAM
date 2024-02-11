import java.util.Scanner;
public class validador_fechas {
  public static void main(String[] args) {

    /* Hecho por Ángel Chávez 1º DAM */
    
    Scanner sc = new Scanner(System.in);

    //creamos una variable para cada dato que el usuario nos proporcione
    System.out.print("Introduce un día (1-31): ");
    int diaUsuario = sc.nextInt();
    System.out.print("\n");

    System.out.print("Introduce un mes (1-12): ");
    int mesUsuario = sc.nextInt();
    System.out.print("\n"); 

    System.out.print("Introduce un año (1500-2200): ");
    int añoUsuario = sc.nextInt();
    System.out.print("\n");

    //imprimimos la fecha con los datos que el usuario ha introducido
    System.out.println("Fecha introducida: " + diaUsuario + "/" + mesUsuario + "/" + añoUsuario);
    System.out.print("\n");

    //llamamos a la funcion fecha y que nos evalue cada dato del usuario
    boolean valido = fecha(diaUsuario, mesUsuario, añoUsuario);

    //en caso de que la variable valido sea verdadera nos imprimirá que la fecha es correcta y en caso de que sea falsa, incorrecta
    if(valido)
      System.out.println("Fecha válida");
    
    else
        System.out.println("Fecha NO válida");
    
        sc.close();
  }

  public static boolean fecha(int dia, int mes, int año){ //creamos la funcion fecha, y creamos una variable para dia, mes y año
    boolean resultado = false;

    if(año >= 1500 && año <= 2200){ // en caso de que el año sea menor o mayor a lo solicitado, que devuelva false
      switch(mes){ // creamos un switch que evalue la cantidad de dias por cada mes y si el dato se encuentra en el rango especificado devolverá true
        case 1: 
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
          if(dia >=1 && dia <= 31)
            resultado = true;
        break;

        case 2: //en el mes de febrero establecemos condiciones para los meses bisiestos y los no bisiestos
          if(año % 4 == 0 || (año % 100 == 0 || año % 400 == 0)){ //si es bisiesto no debe tener mas de 29 dias
            if(dia >= 1 && dia <= 29)
              resultado = true;
          }

          else{
            if(dia >= 1 && dia <= 28)
              resultado = true;
          }
        break;

        case 4:
        case 6:
        case 9:
        case 11:
          if(dia >=1 && dia <= 30)
            resultado = true;
        break;
      }
    }

    return resultado; // devolverá el valor booleano evaluado
  }
}
import java.util.Scanner;
class Opcional {
  public static void main(String[] args) {
    /* Hecho por Ángel Chávez 1º DAM */
    
    String correo = "";
    String parteUno = "";
    String parteDos = "";
    String parteTres = "";
    String parteCuatro = "";
    String continuacion;
    boolean fin = false;
    boolean validarParteUno = false, validarParteDos = false, validarParteTres = false, validarParteCuatro = false;

    do { //inciamos un bucle para verificar los correos segun las especificaciones
      System.out.print("Introduce una dirección de correo electrónico: "); //invitamos al usuario a introducir un correo electronico
      Scanner sc = new Scanner(System.in); //abrimos el scanner
      correo = sc.next();
      continuacion = "";
      fin = correo.equals("FinPrograma"); //iniciamos la variable para comprobar si el usuario quiere terminar el programa o no

      int a = correo.indexOf('.'); //buscamos y ubicamos si hay un punto para saber cual será el final del string parteUno

      if(a != -1){ //en caso de que encuentre un punto
        parteUno = correo.substring(0,a); //separamos en un string parteUno
        continuacion = correo.substring(a+1); //hacemos otro string que contendrá lo qe resta del correo

        if(parteUno.length() >=3 && parteUno.length() <= 12 ){ //comprobamos si parteUno tiene entre 3 y 12 caracteres
          validarParteUno = true;
        }

        else{ //en caso de que este fuera del rango será incorrecto
          validarParteUno = false;
        }

      }

      else{ //tambien sera incorrecto si no encuentra un punto
        validarParteUno = false;
      }

      int b = continuacion.indexOf('@'); //buscamos y ubicamos si hay un arroba para saber cual será el final del string parteDos

      if(b != -1){ //en caso de que encuentre un arroba
        parteDos = continuacion.substring(0,b); //separamos en un string parteDos
        continuacion = continuacion.substring(b+1); //hacemos otro string que contendrá lo qe resta del correo
            
        if(parteDos.length() >=3 && parteDos.length() <= 12 ){ //comprobamos si parteDos tiene entre 3 y 12 caracteres
          validarParteDos = true;
        }

        else{ //en caso de que este fuera del rango será incorrecto
          validarParteDos = false;
        }
            
     }

      else{ //tambien sera incorrecto si no encuentra un arroba
        validarParteDos = false;
      }

      int c = continuacion.indexOf('.'); //buscamos y ubicamos si hay un punto para saber cual será el final del string parteTres

      if(c != -1){ //en caso de que encuentre un punto
        parteTres = continuacion.substring(0,c); //separamos en un string parteTres
        parteCuatro = continuacion.substring(c+1); //hacemos otro string que contendrá lo qe resta del correo, lo cual será parteCuatro
            
        if(parteTres.length() >= 5 && parteTres.length() <= 15 ){ //comprobamos si parteUno tiene entre 5 y 15 caracteres
          validarParteTres = true;
        }

        else{ //en caso de que este fuera del rango será incorrecto
          validarParteTres = false;
        }
      }

      else{ //tambien sera incorrecto si no encuentra un punto
        validarParteTres = false;
      }

      if(parteCuatro.equals("edu") || parteCuatro.equals("gov") || parteCuatro.equals("org")){ //comprobamos si parteCuatro es alguno de los dominios especificados
        validarParteCuatro = true;
      }

      else{ //en caso de que no, será incorrecto
        validarParteCuatro = false;
      }

      if(fin == true){ //si el usuario ingresa FinPrograma la variable devolverá true y se comunicará que el programa terminará
        System.out.println("\n");
        System.out.println("Gracias por utilizar el comprobador de direcciones de correo electrónico");
        System.out.println("\n");
        System.out.println("Programa terminado");
      }

      else{ //y si no ha ingresado dicha frase, es porque es un correo y se evalua

        if (validarCaracteres(parteUno) && validarCaracteres(parteDos) && validarCaracteres(parteTres) && validarCaracteres(parteCuatro)) { //si todas las validaciones son corretas se ingresa a revisar si las partes contienen los puntos, el arroba y el dominio correcto
          if(validarParteUno && validarParteDos && validarParteTres && validarParteCuatro){ //si todas resultan ser correctas se le informa al usuario que el correo es válido
            System.out.print("\n");
            System.out.println("La dirección: ");
            System.out.println(parteUno + " . " + parteDos + " @ " + parteTres + " . " + parteCuatro);
            System.out.print("\n");
            System.out.println("Es una dirección válida");
            System.out.print("\n");
          }
            
          else{ // en caso de que tengan los caracteres correctos pero no los puntos, el arroba o el dominio correcto será notificado como correo invalido
            System.out.println("\n");
            System.out.println("La direccion " + correo + " es NO VÁLIDA, esa dirección no queda autorizada");
            System.out.println("\n");
          }
  
        }
              
        else{ // en caso de que el correo no contenga los caracteres especificados notificará que el correo es invalido
          
          System.out.println("\n");
          System.out.println("La direccion " + correo + " es NO VÁLIDA, esa dirección no queda autorizada");
          System.out.println("\n");
        }
        
      }

      sc.close(); //cerramos el scanner 
          
    }while(fin == false); //se ejecutará mientras el usuario no introduzca la frase "FinPrograma"; y se detendrá en cuanto lo haga
    
  }

  public static boolean validarCaracteres(String partes){ //creamos una funcion para validar los caracteres que se introducen
    boolean correcto = false;
    
    for (int i = 0; i < partes.length(); i++) { //evaluamos cada caracter del string que introduzca el usuario
      char caracter = partes.charAt(i);
  
        if (caracter >= 'a' && caracter <= 'z' && caracter != 'ñ' || (caracter <= '0' && caracter >= '9')) { //si el string cumple con las condiciones la variable "correcto" sera true
          correcto = true;
        }

        else{ //en caso de que no cumpla con las condiciones, la variable "correcto" devolverá false
          correcto = false;
        }
    }

    return correcto;
    
  }

}
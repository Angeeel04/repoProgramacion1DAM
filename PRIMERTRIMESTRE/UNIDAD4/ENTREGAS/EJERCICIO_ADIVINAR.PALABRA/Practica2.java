import java.util.Scanner;
class Practica2 {
  public static void main(String[] args) {
    
    /*Hecho por Ángel Chávez 1º DAM*/
    
    int numeroAleatorio = (int) (Math.random() * 29); //esta variable genera un numero aleatorio del 0 al 29
    int contadorIntentos = 0;
    int contadorFallos = 5;
    char respuesta;
    String palabra = palabra(numeroAleatorio); //segun haya sido asignado un valor para numero aleatorio, este string almacenará una palabra (funcion palabra)
    String pista = "";
    boolean victoria = false;
    
    Scanner sc = new Scanner(System.in);

    for(int i = 0; i < palabra.length(); i++){ //por cada caracter de palabra, en otro string almacenaremos los caracteres misteriosos (guiones bajos seguidos de un espacio)
      pista = pista + "_ ";
    }
 
    System.out.println("Trata de adivinar la palabra misteriosa \n"); //invitamos al usuario a advinar la palabra mostrando este mensaje y seguido de este, el string de la pista
    System.out.println(pista);
    System.out.println("");

    do{
      System.out.print("Intentos hechos: " + contadorIntentos + " "); //mostramos los intentos que hasta el momento lleva el usuario en cada iteracion
      System.out.print("Fallos restantes: " + contadorFallos + " "); //mostramos los fallos que le restan al usuario en cada iteracion
      System.out.println("\n \n");    
      System.out.print("Introduce una letra: "); // invitamos al usuario a ingresar una letra y la almacenaremos en respuesta
      respuesta = sc.next().charAt(0);
      contadorIntentos++; //por cada vez que el usuario introduzca una letra, el contador de intentos aumentará, sea erroneo o correcto
      boolean acierto = false;

      if(respuesta >= 'a' && respuesta <= 'z'){ //nos aseguramos de que la letra que ingresa el usuario sea minuscula
        
        for(int i = 0; i < palabra.length(); i++){ //evaluamos cada caracter de la variable palabra
          char letra = palabra.charAt(i);
            if(respuesta == letra){ //verificamos si la letra introducida por el usuario está en la variable palabra
              pista = pista.substring(0, 2 * i) + respuesta + pista.substring(2 * i + 1); //en caso de que se acierte se reemplazará un caracter de la variable pista por el caracter introducido del usuario
              acierto = true;
            }
        }

        if(acierto == false){ //si el usuario no acierta, disminuirá el contador de fallos
          contadorFallos--;
        }
  
      } else{ // en caso de que el usuario introduzca alguna mayuscula se lo notificaremos (pero ya cuenta como fallo)
        System.out.println("\n");
        System.out.println("Introduce solo minusculas");
      }

      if (pista.indexOf('_') != -1) { //en cada iteracion, se revisará si el string pista tiene algun guion bajo
        System.out.println(pista);
        System.out.println("\n");
        victoria = false;
      } else{ //cuando el string pista ya no tenga ningun guion bajo informará al usuario que ha completado el juego
        victoria = true;
        System.out.println("\n");
        System.out.println("La palabra misteriosa era: " + palabra + "\n");
        System.out.println("ENHORABUENA, has acertado con " + contadorIntentos + " intentos");
      }

      if(contadorFallos == 0){ //en caso de que el contador de fallos llegue a 0 se le informará al usuario que ha perdido el juego
        System.out.println("La palabra misteriosa era: " + palabra + "\n");
        System.out.println("Lo siento, has fallado tras " + contadorIntentos + " intentos");
      }
    }while(contadorFallos > 0 && victoria == false);
    
    sc.close();
  }

  public static String palabra (int numeroAleatorio){ //esta funcion se encargará de distribuir palabra aleatoria y luego encubrirla
    
    String palabras = "golondrina avetoro codorniz garcilla alcotan abubilla perdiz abejaruco vencejo gavilan papamoscas petirrojo colirrojo pechiazul lavandera mosquitero milano aguila roquero estornino treparriscos halcon buitre canastera picapinos gorrion verderon verdecillo buitron bigotudo ";

    String palabra = "";
    int contador = 0;

    for(int i = 0; i < palabras.length() ; i++){ //analizamos todo el string de palabras caracter por caracter
      char caracter = palabras.charAt(i);

      if(caracter == ' '){ //en cuanto encontremos un caracter en blanco significará que una palabra ha terminado
        contador++;
      }

      if(contador == numeroAleatorio){ //cuando el contador sea igual al numero aleatorio habremos encontrado la palabra aleatoria

        if(caracter != ' '){ //mientras un caracter no sea un espacio en blanco, almacenaremos la palabra caracter por caracter
          palabra = palabra + caracter;
        }

      }

    }

    return palabra; //ya que la palabra está completa caracter por caracter la devolveremos
  }

} 
import java.util.Scanner;

class BUSCAMINAS{
    /* Hecho por Ángel Chavez 1º DAM */

    final static int ALTO = 8;
    final static int ANCHO = 8;
    static char [][] tablero = new char [ANCHO][ALTO];  //tablero posterior en el cual encontraremos las minas y sus posiciones adyacentes
    static char [][] tableroFrontal = new char [ANCHO][ALTO];   //tablero qe se mostrara al usuario

    public static void main (String args[]){
        mostrarMenu();  //mostramos el mensaje de bienvenida y la descripcion de nuestro buscaminas
        generadorFinalTablero(); // llamamos a la funcion que generará el tablero posterior, esta funcion no mostrará nada en pantalla

        ocultarTablero(); //ocultamos las casillas con guiones a el tablero que mostraremos al usuario

        //mostrarTableroPosterior();    //esta funcion (ubicada desde la linea 233 - 266) sirve para revelar por completo el tablero posterior

        boolean valido = false, resultado = false, finalBuscaminas = false;
        int fila = 0, columna = 0;

        do{
            mostrarTablero();   //llamamos a la funcion que nos muestra el tablero frontal

            fila = filaUsuario("Introduzca la fila (1-8) ");    //pedimos al usuario qe nos de una fila
            System.out.println("");

            columna = columnaUsuario("Introduzca la columna (1-8) ");   //pedimos al usuario qe nos de una columna
            System.out.println("");

            valido = intentoValido(fila, columna);  //revisamos los valores mediante una funcion de tipo booleano

            if(valido == true){ //en caso de que ambos valores sean correctos podremos trabajar con ellos
                resultado = procesarIntento(fila, columna); //llamamos a la funcion booleana encargada de actualizar la casilla seleccionada por el usuario (ademas de verificar si hay una mina en dicha casilla)

                if(resultado == true){  //si nos devuelve true significará que el usuario encontró una mina, asi que habrá perdido
                    mostrarTablero();   //mostramos el tablero y luego mostramos por pantalla que el usuario ha perdido

                    System.out.println("¡¡EXPLOSION!! \t Has perdido");
                    finalBuscaminas = true; //esta variable booleana indicará que el juego ha terminado y finalizará el bucle
                }

                int minasEscondidas = 0;

                for(int a = 0; a < ANCHO; a++){ //con este bucle anidado comprobaremos cuantas casillas sin minas quedan por revelar
                    for(int b = 0; b < ALTO; b++){

                        if(tableroFrontal[a][b] == '-'){    //por cada guion encontrado la variable aumentará
                            minasEscondidas++;  
                        }

                    }
                }

                if(minasEscondidas == 10){  //si el bucle anterior encuentra 10 casillas sin revelar serán las minas, por tanto habrá ganado
                    mostrarTablero();   //mostramos el tablero y luego mostramos en pantalla que el usuario ha ganado

                    System.out.println("ENHORABUENA!! \t Has ganado.");
                    finalBuscaminas = true; //esta variable booleana indicará que el juego ha terminado y finalizará el bucle
                }
                
            }
            
        }while (finalBuscaminas != true);   

        System.out.println("");
        System.out.println("Programa terminado");   //mostramos por pantalla que el programa ha terminado
    }

    public static void mostrarMenu(){   //creamos una funcion que mostrará el menú, con las indicaciones especificadas en el ejercicio
        String cadena0 = "Bienvenido al BUSCAMINAS";
        String cadena1 = "Hay una serie de minas escondidas en el tablero.";
        String cadena2 = "Debes desvelar dónde están las bombas buscando casilla por casilla.";
        String cadena3 = "Indica la fila y la columna de la casilla que quieres revelar.";
        String cadena4 = "Cuando la descubras, cada casilla tiene un número que te dice si es que no te ha explotado, claro";
        String cadena5 = "Mucha suerte y cuidado con las explosiones.";

        System.out.println(cadena0 + "\n" + cadena1 + "\n" + cadena2 + "\n" + cadena3 + "\n" + cadena4 + "\n" + cadena5);
        System.out.println("");
    }

    public static int filaUsuario(String mensaje){  //esta funcion habilita un scanner solamente para recibir el valor de la fila y luego devolverlo
        Scanner sc = new Scanner (System.in);
        System.out.print(mensaje);
        int fila = sc.nextInt();
        return fila;
    }

    public static int columnaUsuario(String mensaje){   //esta funcion habilita un scanner solamente para recibir el valor de la columna y luego devolverlo
        Scanner sc = new Scanner (System.in);
        System.out.print(mensaje);
        int columna = sc.nextInt();
        return columna;
    }
    
    public static boolean intentoValido(int fila, int columna){ //esta funcion se encarga de comprobar que los valores introducidos por el usuario son correctos
        boolean valido = false;

        if ((fila >= 1 && fila <= 8) && (columna >= 1 && columna <= 8)) {   //si la fila y/o columna están entre el 1 y 8 entonces será valido
            valido = true;
        }

        else{   //si la fila y/o columna están fuera del rango de 1 y 8 entonces será no valido y se notificará
            valido = false;
            System.out.print("Fila y/o columna incorrectas. Vuelva a introducirlas dentro del rango adecuado");
            System.out.println("\n");
        }
        return valido;
    }

    public static void ocultarTablero(){    //en esta funcion completamos el tablero que mostraremos ocultando todas sus posiciones con guiones
        for(int a = 0; a < tableroFrontal.length; a++){  //creamos un bucle anidado para ir casilla por casilla añadiendole un guion
            for(int b = 0; b < tableroFrontal[a].length; b++){
                tableroFrontal[a][b] = '-';
            }
        }
    }

    public static void mostrarTablero(){    //esta funcion se encarga de mostrar el tablero al usuario
    
        for(int a = 0; a <= 8; a++){    //con este bucle crearemos los inidices de la primera fila del tablero
            if(a == 0){
                System.out.print("- ");
            }

            else{
                System.out.print(a + " ");
            }
        }

        System.out.println("");

        int contadorFilas = 1;

        do{ //y con este otro bucle iremos mostrando los indices de las filas con su contenido

            for(int a  = 0; a < ANCHO; a++){
                System.out.print(contadorFilas);

                for(int b = 0; b < ALTO; b++){
                    System.out.print(" " + tableroFrontal[a][b]);
                }
                
                System.out.println(""); 
                contadorFilas++;    
            }
            
        }while(contadorFilas == 8);

        System.out.println("");

    }

    public static void generadorMinas(){    //esta funcion se encargará de generar las minas en el tablero posterior (el que no se mostrará)
        boolean arrayPosiciones [][] = new boolean [ALTO] [ANCHO];
        int contadorMinas = 0;

        for(int a = 0; a < arrayPosiciones.length; a++){    //creamos un bucle anidado y iteramos sobre un array de posiciones, completando todas sus posiciones con el valor false
            for(int b = 0; b < arrayPosiciones[a].length; b++){
                arrayPosiciones[a][b] = false;
            }
        }

        do{
            int filaAleatoria = (int) (Math.random() * ANCHO);  //creamos un numero aleatorio de filas
            int columnaAleatoria = (int) (Math.random() * ALTO); //creamos un numero aleatorio de columnas

            if(contadorMinas == 0){ //para la primera mina en colocar no habran condiciones especiales, ya que sería la unica mina
                tablero[filaAleatoria][columnaAleatoria] = '*';
                arrayPosiciones [filaAleatoria] [columnaAleatoria] = true;  //segun la posicion en donde se encontrará la mina, la buscaremos en el array booleano e actualizaremos el valor a true, asi no se volverá a repetir la posicion
                contadorMinas++;               
            }

            else{   //desde la segunda mina en adelante colocaremos una condicion especial

                if(arrayPosiciones[filaAleatoria][columnaAleatoria] == false){  //buscamos la posicion generada en el array booleano, si se encuentra en false podremos ingresar la mina en el tablero pero con la misma posicion anteriormente evaluada
                    tablero[filaAleatoria][columnaAleatoria] = '*';
                    arrayPosiciones[filaAleatoria][columnaAleatoria] = true;
                    contadorMinas++;
                }
            }

        }while(contadorMinas != 10);    //en cuanto tengamos 10 minas el bucle se acabará
    }
  
    public static void minasCerca(){    //esta funcion se encargará de completar las casillas segun las minas adyacentes
        for(int a = 0; a < tablero.length; a++){
            for(int b = 0; b < tablero[a].length; b++){ //creamos un bucle el cual evaluará casilla por casilla del tablero
                completarTablero(a, b); //los valores serán enviados a otra funcion, en donde se completará dicha casilla
            }
        }
    }

    public static void completarTablero(int filas, int columnas){   //esta funcion se encarga de introducir un valor en una casilla dada por la funcion "minasCerca"
        
        if(tablero[filas][columnas] != '*'){    //esta funcion actuará solamente en las casillas que no tengan minas
            int contador = 48;
            tablero[filas][columnas] = (char) contador; //introducimos a todas las casillas el caracter ASCII 49 (0)

            for(int a = -1; a <= 1; a++){
                for(int b = -1; b <= 1; b++){   //este bucle anidado se encargará de revisar las posiciones alrededor de una casilla comprobando si hay alguna mina adyacente

                    int filasCercanas = filas + a;
                    int columnasCercanas = columnas + b;

                    if((filasCercanas >= 0 && columnasCercanas >= 0) && (filasCercanas <= 7 && columnasCercanas <= 7)){ //en caso de que los valores no sobrepasen los limites del tablero introduciremos el valor del contador
                        if(tablero[filasCercanas][columnasCercanas] == '*'){
                            contador++;
                            tablero[filas][columnas] = (char) contador;
                        }
                    }
                }
            }
        }
    }

    public static void generadorFinalTablero(){ //esta funcion se encarga de combinar las funciones "minasCerca" y "completarTablero" para obtener el tablero sobre el cual se jugará (pero no se mostrará)
        generadorMinas();
        minasCerca();
    }

    public static boolean procesarIntento(int fila, int columna){   //esta funcion trata de evaluar el intento realizado por el usuario y comprobará si es que pierde
        boolean explosion = false;
        tableroFrontal[fila - 1][columna - 1] = tablero[fila - 1][columna - 1]; //revisa las posiciones introducidas por el usuario pero con una posicion anterior, ya que el tablero está diseñado para ser del 1 al 8, pero el array iniciará en 0 y terminará en 7

        if(tablero[fila - 1][columna - 1] == '*'){  //en caso de observar una mina, el usuario habrá perdido
            explosion = true; 
        }

        return explosion;
    }

    /*public static void mostrarTableroPosterior(){    //esta funcion sirve para observar el tablero resuelto
        System.out.println("TABLERO RESUELTO");

        for(int a = 0; a <= 8; a++){    //con este bucle crearemos los inidices de la primera fila del tablero
            if(a == 0){
                System.out.print("- ");
            }

            else{
                System.out.print(a + " ");
            }
        }

        System.out.println("");

        int contadorFilas = 1;

        do{ //y con este otro bucle iremos mostrando los indices de las filas con su contenido

            for(int a  = 0; a < ANCHO; a++){
                System.out.print(contadorFilas);

                for(int b = 0; b < ALTO; b++){
                    System.out.print(" " + tablero[a][b]);
                }
                
                System.out.println(""); 
                contadorFilas++;    
            }
            
        }while(contadorFilas == 8);

        System.out.println("");
    }*/
}
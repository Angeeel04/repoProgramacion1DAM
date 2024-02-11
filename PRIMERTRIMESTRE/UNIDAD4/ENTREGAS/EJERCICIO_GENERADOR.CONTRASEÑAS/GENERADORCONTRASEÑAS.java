import java.util.Scanner;
class GENERADORCONTRASEÑAS{

    /* Hecho por Ángel Chávez 1º DAM */
    public static void main(String args[]){
        // inicializamos los arrays con los caracteres que usaremos, además de inicializar el scanner
        char letras [] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int numeros [] = {1,2,3,4,5,6,7,8,9,0};
        char especiales [] = {'*','+','-','/','#','$','%','&','_','!' };
        int opcionUsuario = 0;
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("\t \t MENU"); //mostramos las opciones que tiene nuestro programa mediante un menú para que el usuario pueda elegir entre esas opciones
            System.out.println("1. Generar e imprimir contraseña débil.");
            System.out.println("2. Generar e imprimir contraseña fuerte.");
            System.out.println("3. Salir. \n");
            System.out.print("Teclee su opción: ");
            opcionUsuario = sc.nextInt(); //admitimos la entrada del usuario

            switch (opcionUsuario){ //en base a la entrada del usuario propondremos un switch con los posibles casos

                case 1: //si elige la opcion 1, llamará a la funcion contraseña debil y generará dicha contraseña
                    System.out.print("\n");
                    System.out.println("La contraseña es: " + contraseñaDebil(letras, numeros)); //mostramos la contraseña
                    System.out.println("\n");

                break;

                case 2: //si elige la opcion 2, llamará a la funcion contraseña fuerte y generará dicha contraseña
                    System.out.print("\n");
                    System.out.println("La contraseña es: " + contraseñaFuerte(letras, numeros, especiales));
                    System.out.println("\n");
                    break;

                case 3: //si elige la opcion 3, se mostrará un comunicado de agradecimiento e indicará que el programa se terminó
                    System.out.print("\n");
                    System.out.println("Gracias por usar el generador de contraseñas.");
                    System.out.print("\n");   
                    System.out.println("Programa terminado");
                break;

                default: //en caso el usuario no ingrese ninguna de las opciones anteriores mostraremos un comunicado de que es una opcion incorrecta y que vuelva a intentarlo
                    System.out.print("\n");
                    System.out.println("Opción incorrecta vuelve a intentarlo");
                    System.out.println("\n");   
                break;
                }
                    
        }while(opcionUsuario != 3); //en cuanto la opcion elegida por el usuario sea 3, el bucle culminará y por ende el programa
    
    sc.close(); //cerramos el scanner
    }

    public static int aleatorioNumeros(int[] numeros){ //creamos una funcion para que nos genere un valor aleatorio en base a la longitud del array numeros
        int resultado = (int) (Math.random() * numeros.length);
        return resultado;
    }

    public static int aleatorioLetras(char [] letras){ //creamos una funcion para que nos genere un valor aleatorio en base a la longitud del array letras (esto nos servirá solo para la contraseña debil)
        int resultado = (int) (Math.random() * letras.length);
        return resultado;
    }

    public static int aleatorioLetrasMayus(char [] letras){ //creamos una funcion para que nos genere un valor aleatorio en base a la longitud del array letras
        //a diferencia de la otra funcion "aleatorioLetras", esta solo podrá generar numeros aleatorios en relacion a las mayusculas
        int limite = letras.length / 2;
        int resultado = (int) (Math.random() * (limite - 1));

        return resultado;
    }

    public static int aleatorioLetrasMinus(char [] letras){ //creamos una funcion para que nos genere un valor aleatorio en base a la longitud del array letras
        //a diferencia de las funciones "aleatorioLetras" y "aleatorioLetrasMayus", esta solo podrá generar numeros aleatorios en relacion a las minusculas

        int limite = letras.length / 2;
        int resultado = limite + (int) (Math.random() * limite);
        return resultado;
    }

    public static int aleatorioEspeciales(char [] especiales){ //creamos una funcion para que nos genere un valor aleatorio en base a la longitud del array especiales
        int resultado = (int) (Math.random() * especiales.length);

        return resultado;
    }

    public static String contraseñaDebil(char [] letras, int [] numeros){ //creamos una funcion para que en base a los numeros aleatorios generados, los caracteres se vayan implementando en un string
        int contador1 = 8;
        int contadorNumeros = 0;
        int contadorLetras = 0;
        int orden = 0;
        String resultado = "";

        while(contador1 != 0){ //este bucle nos indicará el limite de caracteres, que para la contraseña debil es 8
                        
            orden = (int) (Math.random() * 2); //generamos un numero aleatorio entre 0 y 1, para luego implementar aleatoriamente letras o numeros en el string

            if(orden == 0 && contadorLetras < 5){ //si la variable orden es 0, nos añadirá al string una letra (mientras cumpla con la condicion de ser menor que 5)
                resultado += letras[aleatorioLetras(letras)]; //llamamos a la funcion aleatorioLetras, la cual dará un valor y esta nos permitirá relacionarla con una posicion del array letras
                contadorLetras++; //por cada caracter añadido aumentará el contador de letras
                contador1--; //disminuirá la cantidad de caracteres restantes
            }
            
            if(orden == 1 && contadorNumeros < 3){ //si la variable orden es 1, nos añadirá al string una numero (mientras cumpla con la condicion de ser menor que 3)
                resultado += numeros[aleatorioNumeros(numeros)]; //llamamos a la funcion aleatorioNumeros, la cual dará un valor y esta nos permitirá relacionarla con una posicion del array numeros
                contadorNumeros++; //por cada caracter añadido aumentará el contador de numeros
                contador1--; //disminuirá la cantidad de caracteres restantes
            }
                            
        }

        return resultado;
    }

    public static String contraseñaFuerte(char [] letras, int [] numeros, char[] especiales){       
        int contador2 = 13;
        int contadorNumeros = 0;
        int contadorLetras = 0;
        int contadorEspeciales = 0;
        int orden = 0;
        String resultado = "";
        

        while (contador2 != 0) { //este bucle nos indicará el limite de caracteres, que para la contraseña debil es 13

            orden = (int) (Math.random() * 3); //generamos un numero aleatorio entre 0 y 1, para luego implementar aleatoriamente letras, caracteres especiales o numeros en el string

            if (resultado.length() == 0){ //en cuanto el string esté vacio introduciremos un caracter especial en la primera posicion, ya que es lo que indica la condicion del ejercicio
                resultado += especiales[aleatorioEspeciales(especiales)]; //llamamos a la funcion aleatorioEspeciales, la cual dará un valor y esta nos permitirá relacionarla con una posicion del array especiales
                contadorEspeciales++; //por cada caracter añadido aumentará el contador de especiales
                contador2--; //disminuirá la cantidad de caracteres restantes
            } 
                        
            else {//como el string ya no está vacío podremos introducir los siguientes caracteres
                if (orden == 0 && contadorEspeciales < 3) { //si la variable orden es 0, nos añadirá al string un caracter especial (mientras cumpla con la condicion de ser menor que 3)
                    char caracter1 = especiales[aleatorioEspeciales(especiales)]; //llamamos a la funcion aleatorioEspeciales, la cual dará un valor y esta nos permitirá relacionarla con una posicion del array especiales

                    if (resultado.indexOf(caracter1) == -1) { //verificamos que el caracter generado no se encuentre en nuestro string, y de ser así se añadirá al String
                        resultado += caracter1; //añadimos el caracter al string
                        contadorEspeciales++; //por cada caracter añadido aumentará el contador de especiales
                        contador2--; //disminuirá la cantidad de caracteres restantes
                    }
                }
                            
                if (orden == 1 && contadorLetras < 6) { //si la variable orden es 1, nos añadirá al string un caracter letra (mientras cumpla con la condicion de ser menor que 6)
                    char caracter2 = letras[aleatorioLetrasMinus(letras)]; //llamamos a la funcion aleatorioLetrasMinus, la cual dará un valor y esta nos permitirá relacionarla con una posicion del array letras (en este caso sin contar las mayusculas)


                    if(contadorLetras == 0){ //si es la primera letra que introduciremos deberá ser mayuscula, ya que es lo que indica la condicion del ejercicio
                        resultado += letras[aleatorioLetrasMayus(letras)];// llamamos a la funcion aleatorioLetrasMayus, la cual dará un valor y esta nos permitirá relacionarla con una posicion del array letras (en este caso sin contar las minusculas)
                        contadorLetras++; //por cada caracter añadido aumentará el contador de letras
                        contador2--; //disminuirá la cantidad de caracteres restantes
                    }

                    if (resultado.indexOf(caracter2) == -1) { //verificamos que el caracter generado no se encuentre en nuestro string, y de ser así se añadirá al String
                        resultado += caracter2; //añadimos el caracter al string
                        contadorLetras++; //por cada caracter añadido aumentará el contador de especiales de letras
                        contador2--; //disminuirá la cantidad de caracteres restantes
                    }
                }
                            
                if (orden == 2 && contadorNumeros < 4) { //si la variable orden es 2, nos añadirá al string un caracter numero (mientras cumpla con la condicion de ser menor que 4)
                    int caracter3 = numeros[aleatorioNumeros(numeros)]; //llamamos a la funcion aleatorioNumeros, la cual dará un valor y esta nos permitirá relacionarla con una posicion del array numeros

                    if (resultado.indexOf(caracter3 + '0') == -1){ //verificamos que el caracter generado no se encuentre en nuestro string, y de ser así se añadirá al String
                        resultado += caracter3; //añadimos el caracter al string
                        contadorNumeros++; //por cada caracter añadido aumentará el contador de numeros
                        contador2--; //disminuirá la cantidad de caracteres restantes
                    }
                }
            }
        }
        return resultado;
    }
}
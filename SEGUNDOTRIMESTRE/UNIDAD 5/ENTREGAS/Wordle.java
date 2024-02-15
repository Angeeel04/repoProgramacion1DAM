import java.util.Random;
import java.util.Scanner;

class Wordle{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        /*Hecho por Ángel Chávez 1º DAM */

        // Diccionario de palabras del que se extrae el término a adivinar
        String [] diccionario = {"AGRIO", "AGRIA", "AGUDO", "AGUDA", "ALADO",
        "ALADA", "AMADO", "AMADA", "AMIGO", "AMIGA", "ARABE", "ARDUO", "ARDUA",
        "ARIDO", "ARIDA", "AVIDO", "AVIDA","BELGA", "BELLO", "BELLA", "BIZCO",
        "BIZCA", "BUENO", "BUENA","CAIDO", "CAIDA", "CALMO", "CALMA", "CALVO",
        "CALVA", "CAPAZ", "CHINO", "CHINA", "CORTO", "CORTA", "CRASO", "CRASA",
        "DEBIL", "DENSO", "DENSA", "DOBLE", "DRUSO", "DRUSA", "EBRIO", "EBRIA",
        "EPICO", "EPICA","ILUSO", "ILUSA", "IMPIO", "IMPIA", "FALSO", "FALSA",
        "FELIZ", "FEROZ", "FIADO", "FIADA", "FORAL","GALES", "GORDO", "GORDA",
        "GRASO", "GRASA", "GRAVE", "GUAPO" , "GUAPA", "HABIL","JOVEN", "JUSTO",
        "JUSTA", "LENTO", "LENTA", "LISTO", "LISTA","MAGRO", "MAGRA", "MAYOR",
        "MENOR", "MIXTO", "MIXTA", "NASAL", "NAVAL", "NECIO", "NECIA", "NEGRO",
        "NEGRA", "NOBLE", "OSADO", "OSADA", "PARDO", "PARDA", "PINTO", "PINTA",
        "PLENO", "PLENA", "POBRE","QUEDO", "QUEDA", "RECIO", "RECIA", "RECTO",
        "RECTA","RUBIO", "RUBIA", "RURAL", "SABIO", "SABIA", "SAJON", "SANTO",
        "SANTA", "SAUDI", "SENIL", "SERIO", "SERIA", "SIRIO", "SIRIA", "SORDO",
        "SORDA", "SUAVE", "SUCIO", "SUCIA", "SUIZO", "SUIZA", "SUTIL", "TENAZ",
        "TENSO", "TENSA", "TERCO", "TERCA", "TERSO", "TERSA", "TONTO", "TONTA",
        "TORPE", "TOSCO", "TOSCA", "UFANO", "UFANA", "UNICO", "UNICA", "UNIDO",
        "UNIDA", "USUAL", "VELOZ", "VERAZ", "VERDE", "VIEJO", "VIEJA", "VIVAZ",
        "VORAZ"}; // 150 términos
    
        String palDic = diccionario[((int)(rnd.nextDouble() * (diccionario.length)))]; //linea encargada de seleccionar una palabra del diccionaria
        String palFinal = cambiarFormato(palDic); //cambiamos la palabra a mayusculas y le asignamos un formato para simplificar el trabajo
        String cadAvance = ocultarPalabra(palFinal); //ocultamos la palabra con guiones para que el usuario
        int contIntentos = 0;
        boolean victoria = false;
        System.out.println("\t" + "   Trata de adivinar la palabra oculta" + "\n");
        System.out.println("\t \t \t" + cadAvance + "\n \n");

        //System.out.println(palDic); Esta linea servirá para saber la palabra a adivinar

        do{
            System.out.print("\t \t \t");
            String intento = sc.nextLine(); //abrimos el scanner
            intento = alterarIntento(intento); //revisamos la cadena ingresada por el usuario extrayendo las vocales acentuadas
            cadAvance = comprobandoIntento(intento, palFinal, cadAvance); //con esta funcion vamos actualizando la pista segun los aciertos del usuario
            cadAvance = contieneCaracter(intento, palFinal, cadAvance); //con esta funcion vamos actualizando la pista segun los casi-aciertos del usuario
            System.out.println("\n");
            System.out.print("\t \t     " + (contIntentos+1) + " : " + cadAvance + "\n \n"); //mostramos la actualizacion de la pista

            if(intento.equals(palDic)){ //si el usuario introduce la palabra adivinada el booleano finalizará el bucle
                victoria = true;
            }
            contIntentos++; //esta variable se aumentará por cada intento
        }while(contIntentos<6 && victoria == false);

        System.out.println("La palabra buscada era : " + palDic + "\n");
        if(victoria){
            System.out.println("ENHORABUENA, HAS ACERTADO EN TU INTENTO NUMERO " + contIntentos + "\n");
        } else{
            System.out.println("Esta vez no has acertado. Mucha suerte en tu próxima vez." + "\n");
        }

        System.out.println("Programa terminado");
        sc.close(); //se cierra el scanner
    }

    public static String cambiarFormato(String palabra){ //esta funcion cambia el formato de cada palabra, tal que así: X X X X X
        String resultado = "";

        if(palabra.length()>5){
            palabra=palabra.substring(0,5);
        }

        for(int a=0;a<palabra.length();a++){
            if(a!=(palabra.length()-1)){
                resultado += palabra.charAt(a) +" ";
            } else{
                resultado += palabra.charAt(a);
            }
        }
        return resultado;
    }

    public static String ocultarPalabra(String palabra){ //por cada caracter de la palabra se introducirá un guion bajo para ocultarla
        String resultado = "";
        for(int a=0;a<palabra.length();a++){
            if(a!=palabra.length()-1){
                if(palabra.charAt(a)!=' '){
                    resultado += "_ ";
                } 
            } else{
                resultado += "_";
            }
        }
        return resultado;
    }

    public static String alterarIntento(String palabra){ //buscamos las vocales tildadas, las reemplazamos y por ultimo la convertimos a mayusculas
        palabra=palabra.replace('á', 'a');
        palabra=palabra.replace('é', 'e');
        palabra=palabra.replace('í', 'i');
        palabra=palabra.replace('ó', 'o');
        palabra=palabra.replace('ú', 'u');
        palabra=palabra.toUpperCase();
        return palabra;
    }

    public static String comprobandoIntento(String intento, String palFinal, String cadAvance){ //se encarga de actualizar la pista por cada que el usuario acierte una letra
        cadAvance = ocultarPalabra(cadAvance);
        intento = cambiarFormato(intento);  //cambiamos el formato del intento del usuario

        for(int a=0; a<intento.length(); a+=2){ //usamos un bucle para comparar caracteres en una misma posicion
            if(palFinal.charAt(a) == intento.charAt(a)){ //en caso de que sean iguales
                if(a==0){ //si está en la posicion inicial
                    cadAvance = intento.charAt(a) + cadAvance.substring(a+1); //manejamos el substring añadiendo el caracter revelado en la misma posicion
                } else{ //en otras posiciones
                    cadAvance = cadAvance.substring(0,a) + intento.charAt(a) + cadAvance.substring(a+1); //manejamos dos substrings añadiendo el caracter revelado
                }
            }
        }
        return cadAvance;
    }

    public static String contieneCaracter(String intento, String palFinal, String cadAvance){ //se encarga de actualizar la pista por cada que el usuario ingrese una letra en una posicion equivocada
        intento = cambiarFormato(intento);

        for(int a=0; a<palFinal.length();a+=2){
            for(int b=0;b<intento.length();b+=2){
                if(palFinal.charAt(a) == intento.charAt(b)){ //usamos un bucle anidado para buscar si encontramos alguna letra en alguna posicion equivocada
                    if(cadAvance.charAt(b) == '_'){ //nos aseguramos de que la posicion no haya sido revelada
                        int posicion = intento.indexOf(intento.charAt(b)); //nos dirá la posicion del casi acierto
                        cadAvance = cadAvance.substring(0, posicion) + '*' + cadAvance.substring(posicion+1); //con la posicion sabremos hasta donde recortar el string e introducir un *
                    }
                }
            }
        }
        return cadAvance;
    }
}
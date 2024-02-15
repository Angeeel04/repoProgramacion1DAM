import java.util.Random;
import java.util.Scanner;

class Wordle1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

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
    
        String palDic = diccionario[((int)(rnd.nextDouble() * (diccionario.length)))];
        String palFinal = cambiarFormato(palDic);
        String cadAvance = ocultarPalabra(palFinal);
        int contIntentos = 0;
        boolean victoria = false;
        System.out.println("\t" + "Trata de adivinar la palabra oculta" + "\n");
        System.out.println(palDic);

        do{
            System.out.print("\t \t" + (contIntentos+1) + " : " + cadAvance + "\n \n \t \t    ");
            String intento = sc.nextLine();
            intento = alterarIntento(intento);
            cadAvance = comprobandoIntento(intento, palFinal, cadAvance);
            //cadAvance = contieneCaracter(intento, palFinal, cadAvance);

            if(intento.equals(palDic)){
                victoria = true;
            }
            contIntentos++;
        }while(contIntentos<6 && victoria == false);

        System.out.println("La palabra buscada era : " + palDic);
        if(victoria){
            System.out.println("ENHORABUENA, HAS ACERTADO EN TU INTENTO NUMERO " + contIntentos);
        } else{
            System.out.println("Esta vez no has acertado. Mucha suerte en tu próxima vez.");
        }

        System.out.println("Programa terminado");
        sc.close();
    }

    public static String cambiarFormato(String palabra){
        String resultado = "";
        for(int a=0;a<palabra.length();a++){
            if(a!=(palabra.length()-1)){
                resultado += palabra.charAt(a) +" ";
            } else{
                resultado += palabra.charAt(a);
            }
        }
        return resultado;
    }

    public static String ocultarPalabra(String palabra){
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

    public static String alterarIntento(String palabra){
        palabra=palabra.replace('á', 'a');
        palabra=palabra.replace('é', 'e');
        palabra=palabra.replace('í', 'i');
        palabra=palabra.replace('ó', 'o');
        palabra=palabra.replace('ú', 'u');
        palabra=palabra.toUpperCase();
        return palabra;
    }

    public static String comprobandoIntento(String intento, String palFinal, String cadAvance){
        cadAvance = ocultarPalabra(cadAvance);

        if(intento.length()>=5){
            intento = intento.substring(0, 5);
            intento = cambiarFormato(intento);

            for(int a=0; a<intento.length(); a+=2){
                if(palFinal.charAt(a) == intento.charAt(a)){
                    if(a==0){
                        cadAvance = intento.charAt(a) + cadAvance.substring(a+1);
                    } else{
                        cadAvance = cadAvance.substring(0,a) + intento.charAt(a) + cadAvance.substring(a+1);
                    }
                }
            }   
        } else{
            intento = cambiarFormato(intento);

            for(int a=0; a<intento.length(); a+=2){
                if(palFinal.charAt(a) == intento.charAt(a)){
                    if(a==0){
                        cadAvance = intento.charAt(a) + cadAvance.substring(a+1);
                    } else{
                        cadAvance = cadAvance.substring(0,a) + intento.charAt(a) + cadAvance.substring(a+1);
                    }
                }
            }
        }
        return cadAvance;
    }

    public static String contieneCaracter(String intento, String palFinal, String cadAvance){
        intento = cambiarFormato(intento);
        
        for(int a=0; a<palFinal.length();a+=2){
            for(int b=0;b<intento.length();b+=2){
                if(palFinal.charAt(a) == intento.charAt(b)){
                    if(cadAvance.charAt(a) == '_'){
                        int posicion = intento.indexOf(intento.charAt(b));
                        cadAvance = cadAvance.substring(0, posicion) + '*' + cadAvance.substring(posicion+1);
                    }
                }
            }
        }
        return cadAvance;
    }
}
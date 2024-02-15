import java.util.Random;
import java.util.Scanner;

class Wordle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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
        boolean prueba = false;
        
        Random rnd = new Random();
        int numRnd = (int)(rnd.nextDouble() * (diccionario.length));
        String palabraDic = diccionario[numRnd];
        String pista = encubrirPalabra(palabraDic);
        int contIntentos = 1;

        System.out.println("Trata de adivinar la palabra oculta: ");
        System.out.println("\t \t" + pista+ "\n \n");
        do{
            System.out.print("\t \t");
            String intentoUsuario = sc.nextLine().substring(0,5);
            intentoUsuario = alterandoCadena(intentoUsuario);
            pista = revisandoAciertos(palabraDic, intentoUsuario, pista);

            System.out.println("\n" + "\t     " + contIntentos + " : " + pista + "\n");
            contIntentos++;

        }while(contIntentos <= 6);

        System.out.println("Programa terminado");

    }

    public static String encubrirPalabra(String palabra){
        String pistas = "";

        for(int a=0; a<palabra.length(); a++){
            pistas += "_";

            if(a!=palabra.length()-1)
                pistas += " ";
        }
        return pistas;
    }

    public static String alterandoCadena(String palabra){
        palabra = palabra.replace('á','a');
        palabra = palabra.replace('é','e');
        palabra = palabra.replace('í','i');
        palabra = palabra.replace('ó','o');
        palabra = palabra.replace('ú','u');
        palabra = palabra.toUpperCase();
        return palabra;
    }

    public static String revisandoAciertos(String palabraDic, String intento, String pista){
        if(palabraDic.length()>=5){
            for(int a=0; a<palabraDic.length(); a++){
                if(palabraDic.charAt(a) == intento.charAt(a)){
                    if(a==0){
                        pista = intento.charAt(a) + pista.substring((a*2)+1);
                    }
                    
                    else if(a==palabraDic.length()-1){
                        pista = pista.substring(0,(a*2)) + intento.charAt(a);
                    }
                    
                    else{
                        pista = pista.substring(0,a*2) + intento.charAt(a) + pista.substring((a*2)+1);
                    }
                    
                } 
            }
        } else{
            
        }

        


        return pista;
    }
} 
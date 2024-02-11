class Main{
    public static void main(String[] args) {
        String texto = "8Vz,emfxexfhfitejrejpej2fgjreDijeuwtlwfgfhn:rE("; //le asignamos un texto al String
        int desplazamiento = 59;
          
        System.out.println(Descifrado(texto, desplazamiento));
    }
          
    public static String Cifrado(String texto, int desplazamiento){
        String alfabeto = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ abcdefghijklmnñopqrstuvwxyz0123456789ÁÉÍÓÚÜáéíóúü,.:+-*/=¡!¿?@'%&()"; //declaramos el alfabeto
        String textoCifrado = "";
        int longitudAlfabeto = alfabeto.length();

        for (int a = 0; a < texto.length(); a++) {
            char letra = texto.charAt(a);
            int posicion = alfabeto.indexOf(letra);

            posicion = (posicion + desplazamiento) % longitudAlfabeto;

            if (posicion < 0) {
                posicion += longitudAlfabeto;
            }

            char letraCifrada = alfabeto.charAt(posicion);
            textoCifrado += letraCifrada;
        }

        return textoCifrado;
    }

    public static String Descifrado(String texto, int desplazamiento){
        String alfabeto = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ abcdefghijklmnñopqrstuvwxyz0123456789ÁÉÍÓÚÜáéíóúü,.:+-*/=¡!¿?@'%&()";
        String textoDescifrado = "";
        int longitudAlfabeto = alfabeto.length();

        for (int a = 0; a < texto.length(); a++) {
            char letraCifrada = texto.charAt(a);
            int posicion = alfabeto.indexOf(letraCifrada);

            posicion = (posicion - desplazamiento) % longitudAlfabeto;

            if (posicion < 0) {
                posicion += longitudAlfabeto;
            }

            char letraDescifrada = alfabeto.charAt(posicion);
            textoDescifrado += letraDescifrada;
        }

        return textoDescifrado;
    }
}   
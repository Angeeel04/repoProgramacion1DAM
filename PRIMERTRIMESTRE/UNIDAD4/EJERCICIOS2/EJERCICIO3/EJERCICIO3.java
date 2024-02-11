class EJERCICIO3{
    public static void main(String[] args) {
        String frase = "Esta es una frase completa de principio a fin.";
        
        String resultado = "";
        int contador = 0, ultimaPosicion = 0;
        boolean fin =  false;

        while (!fin) {
            int espacio = frase.indexOf(" ", ultimaPosicion);
            String palabra = "";

            if(espacio != -1){
                palabra = frase.substring(ultimaPosicion, espacio);
                ultimaPosicion = espacio + 1;
                contador++;
            }

            else{
                palabra = frase.substring(ultimaPosicion);
                contador++;
                fin = true;
            }

            if(contador % 2 == 0){
                for(int a = (palabra.length() - 1); a >= 0; a--){
                    char letra = palabra.charAt(a);
                    resultado += letra;
                }

                resultado += " ";
            }

            else{
                resultado += palabra + " ";
            }
        }

        System.out.println(resultado);
    }
}
class REPASANDO{
    public static void main(String[] args) {
        String frase = "Esta es una frase completa de principio a fin.";
        int posicion = 0, contador = 0, espacio = 0;
        String frasesPares = "", frasesImpares = "";
        boolean fin = false;

        while(!fin){
            String palabra = "";
            espacio = frase.indexOf(' ', posicion);

            if(espacio != -1){
                palabra = frase.substring(posicion, espacio);
                posicion = espacio + 1;
                contador++;
            }

            else{
                palabra = frase.substring(posicion);
                contador++;
                fin = true;
            }

            if(contador % 2 == 0){
                frasesPares += palabra + " ";
            }

            else{
                frasesImpares += palabra + " ";
            }

        }

        System.out.println(frase);
        System.out.println(frasesPares);
        System.out.println(frasesImpares);
    }
}
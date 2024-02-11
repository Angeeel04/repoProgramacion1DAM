class EJERCICIO5 {
  public static void main(String[] args) {
    String fraseMalsonanteRep = "El dipuTAdo dijo: el muy hijo de puta está imputado por la amputación de una PUta oreja" ;
    String fraseFinal ="";
    String fraseFinalMinusculas = fraseMalsonanteRep.toLowerCase();
    int posicion = 0;
    int resultado = 0;

    do {
      resultado = fraseFinalMinusculas.indexOf(" puta ", posicion);

      if (resultado > -1) {
        fraseFinal = fraseFinal +
        fraseMalsonanteRep.substring(posicion, resultado) + " **** ";
        posicion = resultado +6;
      }
      
      else {
        fraseFinal = fraseFinal +
        fraseMalsonanteRep.substring(posicion);
      }

    } while (resultado > -1);

    System.out.println(fraseFinal);

  }
}

/*
        String frase = "El dipuTAdo dijo: el muy hijo de puta está imPUtado por la amputación de una PUta oreja";
        String resultado = "";
        String minusculas = frase.toLowerCase();
        int ultimaPosicion = 0;
        boolean fin = false;

        do {
            int espacio = minusculas.indexOf(" ", ultimaPosicion);
            String palabra = "", palabra2 = "";

            if(espacio != -1){
                palabra = minusculas.substring(ultimaPosicion, espacio);
                palabra2 = frase.substring(ultimaPosicion, espacio);
                ultimaPosicion = espacio + 1;
            }

            else{
                palabra = minusculas.substring(ultimaPosicion);
                palabra2 = frase.substring(ultimaPosicion);
                fin = true;
            }

            if(palabra.equals("puta")){
                for(int a = 0; a < palabra.length(); a++){
                    resultado += '*';
                }

                resultado += " ";
            }

            else{
                resultado += palabra2 + " ";
            }

        } while (!fin);

        System.out.println(resultado);
*/
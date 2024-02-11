package EJERCICIOS_ARRAYS4;
import java.util.Arrays;

class EJERCICIO5{
    public static void main(String[] args) {
        char array [] = {'a', 's', 'm', 'i', 't', 'f', 'e', 'r', 'o'};
        String palabra = "mmmesa";
        boolean encontrado = evaluaPalabra(array, palabra);

        if(encontrado == true){
            System.out.println("Encontrada: " + palabra);
        }

        else{
            System.out.println("Lo siento, no se halla: " + palabra);
        }
    }

    public static boolean evaluaPalabra (char array [], String palabra){
        boolean posible = false;

        for(int a = 0; a < palabra.length(); a++){
            char caracter = palabra.charAt(a);
            int contador = 0;

            for(int b = 0; b < array.length; b++){

                if(contador == 0){
                    if(caracter == array[b]){
                        array [b] = ' ';
                        posible = true;
                        contador++;
                    }

                    else{
                        posible = false;
                    }
                }
            }
        }

        return posible;
    }   
}
import java.util.Arrays;
class EJERCICIO5{
  public static void main(String args []){
    int [] numeros = {34,12,7,2,4,1,5};
    System.out.println(Arrays.toString(numeros));

    for(int a = 0; a < numeros.length; a++){
        for(int b = a + 1; b < numeros.length; b++){
            if(numeros[a] > numeros[b]){
                int aux = numeros[a];
                numeros[a] = numeros[b];
                numeros[b] = aux;
            }
        }
    }

    System.out.println(Arrays.toString(numeros));
  }
}
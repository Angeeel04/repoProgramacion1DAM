import java.util.Arrays;
class EJERCICIO4{
  public static void main(String args []){
    int numerosEnteros [] = {7, 5, 6, 14, 2, 4, 89, 9, 55};
    int longitud = ((numerosEnteros.length - 1) / 2); //longitud nos sirve para identificar el medio del array y la longitud de los nuevos arrays
    int array1 [] = new int [longitud];
    int array2 [] = new int [longitud];
    int indice1 = 0, indice2 = 0, medio = 0;

    for(int a = 0; a < numerosEnteros.length; a++){
        if(a < longitud){
            array1[indice1] = numerosEnteros [a];
            indice1++;
        }

        else if(a > longitud){
            array2[indice2] = numerosEnteros [a];
            indice2++;
        }

        else{
            medio = numerosEnteros[a];
        }
    }

    for(int a = 0; a < longitud; a++){
        array1[a] *= medio;
        array2[a] *= medio;
    }

    System.out.println(Arrays.toString(array1));
    System.out.println(Arrays.toString(array2));


  }
}
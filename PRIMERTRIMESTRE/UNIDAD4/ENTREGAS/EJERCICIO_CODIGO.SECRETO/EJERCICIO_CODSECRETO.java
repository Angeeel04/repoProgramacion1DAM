class EJERCICIO_CODSECRETO {
    public static void main (String args []){
        int array [][] = {{2,3,9,-1}, {6,1,2,7}, {9,4,8,3}, {5,4,2,3}};
        int array2 [][] = {{2,3,5,1}, {6,2,7}, {9,4,8,3,6}, {5,1}};
        System.out.println("El codigo secreto es: " + generadorCodSecreto(array));
        System.out.println("El codigo secreto es: " + generadorCodSecreto(array2));
    }

    public static int generadorCodSecreto(int matriz[][]){
        int codSecreto = 0;
        for(int a = 0; a < matriz.length; a++){
            int mayor = 0, menor = 0, diferencia = 0;

            for(int b = 0; b < matriz[a].length; b++){
                int numero = matriz[a][b];

                if(b == 0)
                    menor = numero;
                
                else{
                    if(menor>numero)
                        menor = numero;
                }

                if(numero>mayor)
                    mayor = numero;

            }
            diferencia = mayor - menor;
            codSecreto += diferencia;
        }

        return codSecreto;
    }
    
}
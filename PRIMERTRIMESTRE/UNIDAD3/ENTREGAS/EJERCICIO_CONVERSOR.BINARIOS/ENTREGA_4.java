import java.util.Scanner;
class ENTREGA_4{
    public static void main (String args[]){
        int numero = 0;
        double resultado = 0.0, exponente = 0.0;
        boolean terminado = false;
        Scanner sc = new Scanner (System.in);

        do{
            int contador = 0;
            System.out.print("Introduce un numero binario: ");
            numero = sc.nextInt();
            
            for(int a = 1; a < numero; a *= 10){
                int digito = (numero / a) % 10;
                
                if(digito < 0 || digito > 1){
                    contador++;
                }

                else{
                    double multiplicador = Math.pow (2, exponente);
                    resultado += (digito * multiplicador);
                    exponente++;
                }
            }

            if(contador != 0){
                System.out.println("");
                System.out.println("ERROR teclea solo 0's y 1's");
            }else{
                terminado = true;
            }

        }while(!terminado);

        System.out.println("");
        System.out.println("Binario: " + numero + " ---> " + "Decimal: " + (int) resultado);
        System.out.println("Programa terminado");

        sc.close();
    }
}
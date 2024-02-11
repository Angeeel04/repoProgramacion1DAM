class EJERCICIO2{
    public static void main(String[] args) {
        String frase = "Esta es una frase completa de principio a fin.";
        String resultado = "";

        for(int a = 0; a < frase.length(); a++){
            String aux1 = frase.toUpperCase();
            String aux2 = frase.toLowerCase();

            if(a % 2 == 0){
                char letra1 = aux1.charAt(a);
                resultado += letra1;
            }

            else{
                char letra2 = aux2.charAt(a);
                resultado += letra2;
            }
        }

        System.out.println(resultado);
    }
}
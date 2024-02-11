import java.util.Scanner;
class Main{
  public static void main(String args []){
    Scanner sc = new Scanner (System.in);
    String palabra = "", fraseCambiada = "";
    int contadorCuatroPalabras = 0;
    int ultimaPosicion = 0;
    boolean fin = false;

    System.out.print("Ingrese una frase para que podamos evaluarla: ");
    String frase = sc.nextLine();
    
    System.out.println("");

    do{
        int espacio = frase.indexOf(' ', ultimaPosicion);

        if(espacio != -1){
            palabra = frase.substring(ultimaPosicion, espacio);
            ultimaPosicion = espacio + 1;
        } else{
            palabra = frase.substring(ultimaPosicion);
            fin = true;
        }

        System.out.println(palabra +"\n" + palabra.length());

        if(palabra.length() == 4){
            fraseCambiada += " **** ";
            contadorCuatroPalabras++;
        }else{
            fraseCambiada += palabra + ' ';
        }

    }while(!fin);

    System.out.println("Su frase evaluada ahora es: " + fraseCambiada + "\n");
    System.out.println("En ella hay " + contadorCuatroPalabras + " palabras de 4 letras");
    
    sc.close();
  }
}
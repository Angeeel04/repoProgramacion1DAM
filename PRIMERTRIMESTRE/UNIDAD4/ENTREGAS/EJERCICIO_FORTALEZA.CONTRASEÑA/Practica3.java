import java.util.Scanner;
public class Practica3 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String contraseña1 = "", contraseña2 = "";
        boolean fin = false;

        do{
            System.out.print("Introduce una contraseña: ");
            contraseña1 = sc.nextLine();
            String errores = "La contraseña tiene los siguientes errores: \n";

            if((evaluarInicio(contraseña1) && evaluarMayus(contraseña1) && evaluarMinus(contraseña1) &&
            evaluarNums(contraseña1) && evaluarEspeciales(contraseña1) &&
            (!(evaluarCaracaterVacio(contraseña1))) && evaluarLongitud(contraseña1))){
                System.out.print("Esta contraseña parece ser segura, ingrese la contraseña para confirmarla: ");
                contraseña2 = sc.nextLine();

                if(contraseña1.equals(contraseña2)){
                    System.out.println("\n" + "Esta contraseña está confirmada \n");
                    System.out.println("Programa Terminado");
                    fin = true;
                } else{
                    System.out.println("\n Las contraseñas no coinciden. Contraseña no confirmada \n");
                }

            } else{
                if(!(evaluarInicio(contraseña1))){
                    errores += "- No empieza con una letra aceptable \n";
                }
                if(!(evaluarMayus(contraseña1))){
                    errores += "- No contiene una mayuscula \n";
                }
                if(!(evaluarMinus(contraseña1))){
                    errores += "- No contiene una minuscula \n";
                }
                if(!(evaluarNums(contraseña1))){
                    errores += "- No contiene un numero \n";
                }
                
                if(!(evaluarEspeciales(contraseña1))){
                    errores += "- No contiene caracteres especiales \n";
                }
                if((evaluarCaracaterVacio(contraseña1))){
                    errores += "- Contiene un caracter vacio \n";
                }
                
                if(!(evaluarLongitud(contraseña1))){
                    errores += "- Contiene menos de 8 caracteres \n";
                }

                System.out.println(errores);
            }
        }while(!fin);
        sc.close();
    }

    public static boolean evaluarInicio(String contraseña){
        boolean result = false;
        if((contraseña.charAt(0) >= 65 && contraseña.charAt(0) <= 90) || (contraseña.charAt(0)>= 98 && contraseña.charAt(0) <= 122)){
            result = true;
        }
        return result;
    }

    public static boolean evaluarMayus(String contraseña){
        boolean result = false;
        int contador = 0;

        for(int a = 0; a < contraseña.length(); a++){
            if(contraseña.charAt(a)>= 65 && contraseña.charAt(a) <= 90){
                contador++;
            }
        }

        if(contador>0){
            result = true;
        }
        return result;
    }

    public static boolean evaluarMinus(String contraseña){
        boolean result = false;
        int contador = 0;

        for(int a = 0; a < contraseña.length(); a++){
            if(contraseña.charAt(a)>= 97 && contraseña.charAt(a) <= 122){
                contador++;
            }
        }
        
        if(contador>0){
            result = true;
        }
        return result;
    }

    public static boolean evaluarNums(String contraseña){
        boolean result = false;
        int contador = 0;

        for(int a = 0; a < contraseña.length(); a++){
            if(contraseña.charAt(a)>= 48 && contraseña.charAt(a) <= 57){
                contador++;
            }
        }
        
        if(contador>0){
            result = true;
        } 
        return result;
    }

    public static boolean evaluarEspeciales(String contraseña){
        boolean result = false;
        int contador = 0;

        for(int a = 0; a < contraseña.length(); a++){
            if((contraseña.charAt(a)== 42 || contraseña.charAt(a)== 43 || 
            contraseña.charAt(a)== 45 || contraseña.charAt(a)== 95 ||
            contraseña.charAt(a)== 35 || contraseña.charAt(a)== 36 ||
            contraseña.charAt(a)== 37 || contraseña.charAt(a)== 48)){
                contador++;
            }
        }
        
        if(contador>0){
            result = true;
        }
        return result;
    }

    public static boolean evaluarCaracaterVacio(String contraseña){
        boolean result = false;
        int contador = 0;

        for(int a = 0; a < contraseña.length(); a++){
            if(contraseña.charAt(a) == ' '){
                contador++;
            }
        }
        
        if(contador>0){
            result = true;
        }

        return result;
    }

    public static boolean evaluarLongitud(String contraseña){
        boolean result = true;
        if(contraseña.length()>=8){
            result = true;
        } else{
            result = false;
        }

        return result;
    }
}
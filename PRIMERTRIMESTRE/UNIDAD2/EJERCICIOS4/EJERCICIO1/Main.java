import java.util.*;
class Main {
    public static void main(String args[]) {
    
    Scanner sc = new Scanner(System.in);  
    int variable1 = sc.nextInt();
    int variable2 = variable1 * variable1;
    int variable3 = variable1 * variable1 * variable1;

    System.out.println("Tú numero es:  " + variable1);
    System.out.println("Tú numero al cuadrado es:  " + variable2);
    System.out.println("Tú numero al cubo es:  " + variable3);

    sc.close();
    
    }
}
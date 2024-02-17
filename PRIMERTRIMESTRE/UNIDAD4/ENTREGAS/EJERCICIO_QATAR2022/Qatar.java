import java.util.Scanner;
import java.lang.Character;

class Qatar {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String [] esquemaTactico = new String []{"4-4-2", "4-3-3", "5-3-1-1", "3-5-2", "4-1-4-1"};
        String [] jugadores = new String []{"Unai Simón", "Carvajal", "Pau T.", "Laporte", "Alba", "Busquets", "Pedri", "Gavi", "Sarabia", "Asensio", "Ansu Fati" };
        System.out.print("Elige el esquema para este partido: (1-5): ");
        boolean fin = false;
        int opUser = sc.nextInt();

        if(opUser>=1&&opUser<=esquemaTactico.length){
            System.out.println("Esquema elegido: " + esquemaTactico[opUser-1] + "\n");
            int contJugadores = 0;
            System.out.println("\t \t" + jugadores[contJugadores] + "\n");

            while(!fin){
                String eleccion = esquemaTactico[opUser-1];

                for(int a=0; a<eleccion.length(); a++){
                    if(eleccion.charAt(a)!='-'){
                        int repeticiones = Character.getNumericValue(eleccion.charAt(a));
                        String espacios = "     ";

                        if(repeticiones<4){
                            switch (repeticiones) {
                                case 1:
                                    System.out.print(espacios + espacios + espacios);    
                                break;

                                case 2:
                                    System.out.print(espacios + espacios);    
                                break;

                                case 3:    
                                    System.out.print(espacios);    
                                break;
                            }
                        }

                        for(int b=0; b<repeticiones; b++){
                            contJugadores++;
                            System.out.print(jugadores[contJugadores] + espacios);

                            if(b==repeticiones-1){
                                System.out.println("");
                            }
                        }

                    }
                    System.out.print("\n");
                }

                if(contJugadores <= 11){
                    fin = true;
                }
            }
        } else{
            System.out.println("Esquema táctico no entrenado");
        }

    }
}
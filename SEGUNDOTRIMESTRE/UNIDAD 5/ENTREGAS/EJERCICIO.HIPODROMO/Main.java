import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
/*HECHO POR ANGEL CHAVEZ 1º DAM*/

public class Main {
	public static void main(String [] args) {
		ArrayList<Caballo> arrayCaballos = new ArrayList<Caballo>();
		arrayCaballos.add(new Caballo("Rocinante", 1));
		arrayCaballos.add(new Caballo("Babieca", 2));
		arrayCaballos.add(new Caballo("Rufio", 3));
		arrayCaballos.add(new Caballo("Perla", 4));
		arrayCaballos.add(new Caballo("Rosado", 5));
		
		hipica(arrayCaballos);
	}
	
	public static void hipica(ArrayList<Caballo> arrayCaballos) {
		Caballo ganador = new Caballo();
		mensajeInicial(arrayCaballos);
		ganador = guardarCaballo(arrayCaballos, iniciarCarrera());
		carreraIniciada(arrayCaballos, ganador);
	}
	
	public static void mensajeInicial(ArrayList<Caballo> lista) {
		System.out.println("Los caballos participantes son: ");
		mostrarCaballos(lista);
	}

	public static void mostrarCaballos(ArrayList<Caballo> arrayCaballos) {
		for(Caballo cab : arrayCaballos) {
			System.out.println(cab.getNombre() + " con el dorsal " + cab.getDorsal());
		}
	}
	
	public static void mostrarCaballosyDistancias(ArrayList<Caballo> arrayCaballos) {
		for(Caballo cab : arrayCaballos) {
			System.out.println(cab.toString());
		}
	}
	
	public static ArrayList<Caballo> ordenarCaballos(ArrayList<Caballo> lista) {
	    int longitud = lista.size();
	    boolean intercambiado;

	    do {
	        intercambiado = false;
	        for (int i = 1; i < longitud; i++) {
	            if (lista.get(i - 1).getDistancia() < lista.get(i).getDistancia()) {
	                Caballo temp = lista.get(i - 1);
	                lista.set(i - 1, lista.get(i));
	                lista.set(i, temp);
	                intercambiado = true;
	            }
	        }
	        longitud--;
	    } while (intercambiado);

	    return lista;
	}

	
	public static int iniciarCarrera() {
		Scanner sc = new Scanner(System.in);
		boolean fin = false;
		int opUsuario = 0;
		
		System.out.println("");
		System.out.print("La carrera comenzará cuando apueste por un caballo: ");
		
		do {
			opUsuario = sc.nextInt();
			if(opUsuario>0 && opUsuario<6) {
				fin = true;
			} else {
				System.out.print("Las carreras constan de 5 caballos (elige del 1 al 5) : ");
			}
		}while(!fin);
		
		System.out.println("\n" + "COMIENZA LA CARRERA");
		return opUsuario;
	}
	
	public static Caballo guardarCaballo(ArrayList<Caballo> arrayCaballos, int opUsuario) {
		Caballo cabGuardado = arrayCaballos.get(opUsuario-1);
		return cabGuardado;
	}
	
	public static void carreraIniciada(ArrayList<Caballo> arrayCaballos, Caballo cab) {
		do {
			System.out.println("");
			System.out.println("Posicion en la carrera de los caballos del primero al ultimo" + "\n");
			caballoCaido(arrayCaballos);
			
			for(Caballo caballo : arrayCaballos) {
				caballo.setDistancia(caballo.getDistancia() + generandoDistancias());
			}
			
			mostrarCaballosyDistancias(ordenarCaballos(arrayCaballos));
			continuar();
			
		}while((arrayCaballos.get(0)).getDistancia() <= 700 || arrayCaballos.size() == 0);
		
		if(arrayCaballos.size() != 0) {
			System.out.println("FIN DE LA CARRERA \n");
			System.out.println("El ganador es " + arrayCaballos.get(0).getNombre() + " con el dorsal " + arrayCaballos.get(0).getDorsal());
			
			if(arrayCaballos.get(0).equals(cab)) {
				System.out.println("!ENHORABUENA, has ganado tu apuesta!");
			} else {
				System.out.println("Lo sentimos, no has ganado tu apuesta. Vuelve a intentarlo");
			}
		}else {
			System.out.println("Todos los caballos se han caido, carrera terminada");
		}
		
	}
	
	public static void caballoCaido(ArrayList<Caballo> arrayCaballos) {
		int indx = 0;
		
		do {
			if(generandoCaidas()) {
				System.out.println("ATENCION CAIDA " + arrayCaballos.get(indx).toString() + " ha caido");
				arrayCaballos.remove(indx);
			}
			indx++;
		}while(indx<arrayCaballos.size());
	}
	
	public static int generandoDistancias() {
		Random rnd = new Random();
		int [] distancias = {50, 60, 70,80};
		return distancias[rnd.nextInt(4)];
	}
	
	public static boolean generandoCaidas() {
		boolean caida = false;
		Random rnd = new Random();
		int probabilidad = rnd.nextInt(16);
		if(probabilidad==15) {
			caida = true;
		}
		return caida;
	}
	
	public static boolean continuar() {
		boolean siguiente = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		System.out.print("Pulse ENTER para continuar");
		String enter = sc.nextLine();
		do {
			if(enter.length() == 0) {
				siguiente = true;
			}
		}while(!siguiente);
		
		return siguiente;
	}
}
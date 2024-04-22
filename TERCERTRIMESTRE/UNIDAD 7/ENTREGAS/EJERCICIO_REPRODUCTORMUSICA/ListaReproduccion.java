package EJERCICIO_REPRODUCTORMUSICA;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/*HECHO POR ANGEL CHAVEZ 1º DAM*/

public class ListaReproduccion {
	protected String nombre;
	protected ArrayList<Cancion> listaCanciones;
	protected String duracion;
	
	public ListaReproduccion() {
	}
	public ListaReproduccion(String nombre, ArrayList<Cancion> listaCanciones) {
		this.nombre = nombre;
		this.listaCanciones = listaCanciones;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Cancion> getListaCanciones() {
		return listaCanciones;
	}
	public void setListaCanciones(ArrayList<Cancion> listaCanciones) {
		this.listaCanciones = listaCanciones;
	}
	
	public void duracionLista() {
		Random rnd = new Random();
		int duracionMin = 0;
		int duracionSegundos = rnd.nextInt(60); 

		for(Cancion canX : listaCanciones) {
			duracionMin += canX.getDuracionSeg();
		}
		
		this.duracion = String.format("%d:%02d", duracionMin, duracionSegundos);
	}

	public void rellenadoCompleto(Cancion[] canDisponibles) {
		for (Cancion cancion : canDisponibles) {
			this.listaCanciones.add(cancion);
		}
		this.duracionLista();
	}

	public void rellenadoAleatorio(Cancion[] canDisponibles) {
		Random rnd = new Random();
		int capacidad = rnd.nextInt(canDisponibles.length - 1) + 1;
		boolean[] posiciones = new boolean[canDisponibles.length];

		while (capacidad != 0) {
			int indxAleatorio = rnd.nextInt(canDisponibles.length - 1);
			if (!posiciones[indxAleatorio]) {
				this.listaCanciones.add(canDisponibles[indxAleatorio]);
				posiciones[indxAleatorio] = true;
				capacidad--;
			}
		}
		
		this.duracionLista();
	}

	public void reproduccionLista(){
		for (Cancion canX : this.listaCanciones) {
			System.out.println(canX.toString());
			canX.Reproducir();
			System.out.println("");
		}
	}

	public void reproduccionAleatoriaLista(){
		Random rnd = new Random();
		int tamanoLista = this.listaCanciones.size();
		int reproducciones = 0;
		boolean[] posiciones = new boolean[tamanoLista];

		while (reproducciones != tamanoLista) {
			int numRnd = rnd.nextInt(tamanoLista);

			if (!posiciones[numRnd]) {
				Cancion canX = this.listaCanciones.get(numRnd);
				System.out.println(canX.toString());
				canX.Reproducir();
				System.out.println("");
				posiciones[numRnd] = true;
				reproducciones++;
			}
		}
	}

	public void reproducirDesdePosicion(int opUsuario){
		Cancion canSelec = this.listaCanciones.get(opUsuario - 1);
		int posicionCancionElegida = this.conocerPosicion(canSelec);

		System.out.println("Reproduciendo: " + this.toString());
		System.out.println("Se inicia la reproduccion desde la posicion " + opUsuario + "\n");

		do {
			Cancion canAux = this.listaCanciones.get(posicionCancionElegida);
			System.out.println(canAux.toString());
			canAux.Reproducir();
			posicionCancionElegida++;
			System.out.println("");
		} while (posicionCancionElegida < this.listaCanciones.size());
	}

	public void anadirCanciones(Cancion [] canciones){
		Scanner sc = new Scanner(System.in);
		boolean fin = false;
		System.out.println("");

		do {
			System.out.print("¿Canción a añadir? ");
			int numCancion = sc.nextInt();
			if (numCancion > 0 && numCancion < canciones.length + 1) {
				this.listaCanciones.add(canciones[numCancion - 1]);
				System.out.println("Cancion añadida" + "\n");
			} else if (numCancion == 0) {
				System.out.println("Canciones añadidas");
				fin = true;
			} else {
				System.out.println("Número de canción no encontrada" + "\n");
			}
		} while (!fin);
		this.duracionLista();
		System.out.println("");
	}

	public void eliminarCanciones(){
		Scanner sc = new Scanner(System.in);
		boolean fin = false;
		int canEliminadas = 0;
		
		do{
			this.mostrarCancionesLista();
			System.out.print("¿Que canción va a eliminar?: ");
			int opUsuario = sc.nextInt();
			
			if (opUsuario>0&&opUsuario<this.listaCanciones.size()+1) {
				listaCanciones.remove(opUsuario-1);
				System.out.println("Cancion eliminada" + "\n");
				canEliminadas++;
			} else if(opUsuario==0){
				if(canEliminadas>0){
					System.out.println("Canciones eliminadas");
				} else{
					System.out.println("No se ha eliminado ninguna cancion");
				}
				fin = true;
			}
		}while (!fin);
		this.duracionLista();
		System.out.println("");
	}

	public void cambiarNombre(){
		Scanner sc = new Scanner(System.in);
		boolean fin = false;
		
		do{
			System.out.print("¿Cuál será el nuevo nombre que tendrá la lista " + this.nombre + "?");
			String nuevoNombre = sc.nextLine();
			if(nuevoNombre.length()>0){
				this.setNombre(nuevoNombre);
				fin = true;
			}else{
				System.out.println("Ingrese un nombre de almenos 1 caracter" + "\n");
			}
		}while (!fin);
		System.out.println("");
	}

	public int conocerPosicion(Cancion canX) {
		int posicion = 0;
		boolean fin = false;
		
		do {
			Cancion cancionAux = this.listaCanciones.get(posicion);
			if(canX.equals(cancionAux)) {
				fin = true;
			} else {
				posicion++;
			}
		}while(!fin);
		
		return posicion;
	}

	public void mostrarCancionesLista() {
		int indx = 1;
		for (Cancion canX : this.listaCanciones) {
			System.out.println(indx + ". " + canX.titulo + " de " + canX.autor);
			indx++;
		}
		System.out.println("");
	}
	
	@Override
    public String toString() {
		return  nombre + " (" + this.duracion + ")";
    }
}
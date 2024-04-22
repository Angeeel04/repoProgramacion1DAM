package EJERCICIO_REPRODUCTORMUSICA;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
/*HECHO POR ANGEL CHAVEZ 1º DAM*/

public class Main {
	public static void main(String[] args) {
		Cancion can1 = new Cancion("Givenchy", "Duki", "Trap", 0, 3);
		Cancion can2 = new Cancion("Flaca", "Andrés Calamaro", "Rock", 1, 2);
		Cancion can3 = new Cancion("De Música Ligera", "Soda Stereo", "Rock", 2, 3);
		Cancion can4 = new Cancion("Rockstar", "Duki", "Trap", 3, 1);
		Cancion can5 = new Cancion("La Muralla Verde", "Los Enanitos Verdes", "Rock", 4, 1);
		Cancion can6 = new Cancion("Magalenha", "Sérgio Mendes", "Samba", 5, 3);
		Cancion can7 = new Cancion("Repeat It", "Lil Tecca, Gunna", "Trap", 6, 2);
		Cancion can8 = new Cancion("Goteo", "Duki", "Trap", 7, 4);
		Cancion can9 = new Cancion("Bank Teller", "Lil Tecca, Lil Yachty", "Trap", 8, 1);
		Cancion can10 = new Cancion("Hello Cotto", "Duki", "Trap", 9, 2);

		Cancion[] canciones = { can1, can2, can3, can4, can5, can6, can7, can8, can9, can10 };

		ListaReproduccion lista1 = new ListaReproduccion("Toda la musica", new ArrayList<Cancion>());
		ListaReproduccion lista2 = new ListaReproduccion("Solo español", new ArrayList<Cancion>());
		ListaReproduccion lista3 = new ListaReproduccion("Musicas 2024", new ArrayList<Cancion>());

		lista1.rellenadoCompleto(canciones);
		lista2.rellenadoAleatorio(canciones);
		lista3.rellenadoAleatorio(canciones);

		ArrayList<ListaReproduccion> listasCreadas = new ArrayList<ListaReproduccion>();
		listasCreadas.add(lista1);
		listasCreadas.add(lista2);
		listasCreadas.add(lista3);

		iniciarAplicacion(listasCreadas, canciones);
	}

	public static void iniciarAplicacion(ArrayList<ListaReproduccion> listaX, Cancion[] canciones) {
		boolean fin = false;

		do {
			mostrarMenu();

			switch (pedirOpcion()) {
				case 1:
					opcion1(listaX.get(0));
					break;

				case 2:
					opcion2(listaX.get(0));
					break;

				case 3:
					opcion3(listaX.get(0));
					break;

				case 4:
					opcion4(listaX);
					break;

				case 5:
					opcion5(listaX, canciones);
					break;

				case 6:
					opcion6(listaX, canciones);
					break;

				case 7:
					opcion7(listaX);
					break;

				case 8:
					opcion8(listaX);
					break;

				case 9:
					fin = opcion9();
					break;
			}

			System.out.println("\n");
		} while (!fin);
	}

	public static void mostrarMenu() {
		System.out.println("REPRODUCTOR DE MÚSICA");
		System.out.println("======================");
		System.out.println("1. Reproducir lista desde incio ");
		System.out.println("2. Reproducir lista aleatoriamente");
		System.out.println("3. Reproducir lista desde una posición");
		System.out.println("4. Reproducir otra lista");
		System.out.println("5. Crear lista");
		System.out.println("6. Modificar lista");
		System.out.println("7. Borrar lista");
		System.out.println("8. Reproducir lista de un genero");
		System.out.println("9. Salir \n");
	}

	public static int pedirOpcion() {
		Scanner sc = new Scanner(System.in);
		boolean fin = false;
		int opUsuario = 0;

		do {
			System.out.print("Elija su opción: ");
			opUsuario = sc.nextInt();
			if (opUsuario > 0 && opUsuario < 10) {
				System.out.println("");
				fin = true;
			} else {
				System.out.println("Opcion no encontrada. Vuelva a intentarlo." + "\n");
			}
		} while (!fin);
		return opUsuario;
	}

	public static void opcion1(ListaReproduccion listaX) {
		System.out.println("Reproduciendo: " + listaX.toString() + "\n");
		listaX.reproduccionLista();
	}

	public static void opcion2(ListaReproduccion listaX) {
		System.out.println("Reproduciendo aleatoriamente: " + listaX.toString() + "\n");
		listaX.reproduccionAleatoriaLista();
		
	}

	public static void opcion3(ListaReproduccion listaX) {
		Scanner sc = new Scanner(System.in);
		listaX.mostrarCancionesLista();

		System.out.print("Introduzca la posicion de la cancion inicial: ");
		int opUsuario = sc.nextInt();
		System.out.println("\n");

		if (opUsuario > 0 && opUsuario < listaX.listaCanciones.size() + 1) {
			listaX.reproducirDesdePosicion(opUsuario);
		} else {
			System.out.println("Opcion no encontrada. Se inicia la reproduccion desde la posicion 1");
			opcion1(listaX);
		}
	}

	public static void opcion4(ArrayList<ListaReproduccion> listaX) {
		Scanner sc = new Scanner(System.in);
		mostrarListas(listaX);
		System.out.print("\n" + "Por favor, escoja una: ");
		int opUsuario = sc.nextInt();

		if (opUsuario > 0 && opUsuario < listaX.size() + 1) {
			System.out.println("");
			ListaReproduccion listaAux = listaX.get(opUsuario - 1);
			listaX.remove(opUsuario - 1);
			listaX.add(0, listaAux);
			System.out.println("Seleccionada lista Nº" + opUsuario + " " + listaAux.toString() + "\n");
			seleccionarModo(listaX.get(0));
		} else {
			ListaReproduccion listaPrincipal = buscarListaPrincipal(listaX);
			System.out.println("Lista no encontrada, se seleccionará la lista " + listaPrincipal.nombre + "\n");
			seleccionarModo(listaPrincipal);
		}
	}

	public static void seleccionarModo(ListaReproduccion listaX) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Modo de reproduccion: " + "\n" + "1. Desde inicio" + "\n" + "2. Aleatoriamente" + "\n" + "3. Desde una posicion" + "\n");

		System.out.print("¿Su elección?: ");
		int opUsuario = sc.nextInt();
		System.out.println("\n");
		
		switch (opUsuario) {
			case 1:
				opcion1(listaX);
				break;

			case 2:
				opcion2(listaX);
				break;

			case 3:
				opcion3(listaX);
				break;
		}
	}

	public static void opcion5(ArrayList<ListaReproduccion> listaX, Cancion[] canciones) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Teclee el nombre de la nueva lista: ");
		String listaUsuario = sc.nextLine();
		ArrayList<Cancion> cancionesSelec = new ArrayList<Cancion>();
		ListaReproduccion nuevaLista = new ListaReproduccion(listaUsuario, cancionesSelec);
		
		mostrarCancionesDisponibles(canciones);
		System.out.println("\n" + "Añade las canciones por su numero. Pulse 0 para acabar.");
		nuevaLista.anadirCanciones(canciones);

		if (nuevaLista.listaCanciones.size() > 0) {
			listaX.add(nuevaLista);
			System.out.println(nuevaLista.nombre + " se ha añadido con éxito" + "\n");
		} else {
			nuevaLista = null;
			System.out.println(listaUsuario + " no tiene canciones" + "\n" + "No se ha creado " + listaUsuario + "\n");
		}
		mostrarListas(listaX);
	}

	public static void opcion6(ArrayList<ListaReproduccion> listaX, Cancion[] canciones) {
		Scanner sc = new Scanner(System.in);
		boolean fin = false;

		do {
			mostrarListas(listaX);
			System.out.print("Por favor, escoja una: ");
			int opUsuario = sc.nextInt();

			if (opUsuario > 0 && opUsuario < listaX.size() + 1) {
				ListaReproduccion listaAux = listaX.get(opUsuario - 1);
				System.out.println("\n" + "Seleccionada lista Nº" + opUsuario + " " + listaAux.toString() + "\n");
				modificarLista(listaX, listaAux, canciones);
				fin = true;
			}else {
				ListaReproduccion listaPrincipal = buscarListaPrincipal(listaX);
				System.out.println("Lista no encontrada, se seleccionará la lista " + listaPrincipal.nombre + "\n");
				modificarLista(listaX, listaPrincipal, canciones);
			}
		} while (!fin);
	}

	public static void modificarLista(ArrayList<ListaReproduccion> listas, ListaReproduccion listaX, Cancion[] canciones) {
		Scanner sc = new Scanner(System.in);
		ListaReproduccion listaPrincipal = buscarListaPrincipal(listas);
		
		System.out.println("¿Que desea hacer con la lista " + listaX.nombre + " ?");
		System.out.print("1. Añadir canciones \n" + "2. Eliminar canciones \n" + "3. Cambiar nombre \n" + "¿Su eleccion?: ");
		int opUsuario = sc.nextInt();
		switch (opUsuario) {
			case 1:
				System.out.println("\n" + "Añadir canciones a la lista " + listaX.nombre);
				
				if(!(listaPrincipal.equals(listaX))){
					mostrarCancionesDisponibles(canciones);
					System.out.println("\n" + "Escoja el número de la canción a añadir, pulse 0 para acabar:");
					listaX.anadirCanciones(canciones);
				} else{
					System.out.println("\n" + "La lista Nº1 no se puede modificar" + "\n" + "Operacion cancelada" + "\n");
				}
			break;

			case 2:
				System.out.println("\n" + "Eliminar canciones de lista " + listaX.nombre + "\n");

				if(!(listaPrincipal.equals(listaX))){
					listaX.eliminarCanciones();
				}else{
					System.out.println("La lista Nº1 no se puede modificar" + "\n" + "Operacion cancelada" + "\n");
				}
			break;

			case 3:
				System.out.println("\n" + "Cambiar nombre a la lista " + listaX.nombre + "\n");

				if(!(listaPrincipal.equals(listaX))){
					listaX.cambiarNombre();
					mostrarListas(listas);
				}else{
					System.out.println("La lista Nº1 no se puede modificar" + "\n" + "Operacion cancelada" + "\n");
				}
			break;

			default:
				System.out.println("Opcion no encontrada. Saliendo de Modificar lista");
			break;
		}
		System.out.println("Saliendo de Modificar lista");
	}

	public static void mostrarCancionesDisponibles(Cancion[] canciones) {
		System.out.println("Las canciones disponibles son: ");
		for (int a = 0; a < canciones.length; a++) {
			System.out.println((a + 1) + "." + canciones[a].titulo);
		}
	}

	public static void opcion7(ArrayList<ListaReproduccion> listaX) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Eliminacion de listas" + "\n");
		mostrarListas(listaX);

		System.out.print("Por favor, escoja una: ");
		int opUsuario = sc.nextInt();
		ListaReproduccion listaAux = listaX.get(opUsuario - 1);
		ListaReproduccion listaPrincipal = buscarListaPrincipal(listaX);
		
		if (!(listaPrincipal.equals(listaAux))) {
			boolean terminado = false;
			System.out.println("\n" + "Seleccionada lista Nº" + opUsuario + " " + listaAux.toString() + "\n");
			System.out.println("¿Seguro que desea eliminar la lista de reproduccion?" + "\n" + "Lista Nº" + opUsuario+ " " + listaAux.toString() + "\n");
			do {
				Scanner sc1 = new Scanner(System.in);
				System.out.print("Confirme con S/s si se elimina: ");
				String elecUsuario = sc1.nextLine();
				if (elecUsuario.equals("S") || elecUsuario.equals("s")) {
					listaX.remove(listaAux);
					if(opUsuario==1) {
						listaX.remove(buscarListaPrincipal(listaX));
						listaX.add(0,listaPrincipal);
					}
					System.out.println("\n" + "Lista eliminada");
					terminado = true;
				} else if (elecUsuario.equals("N") || elecUsuario.equals("n")) {
					System.out.println("\n" + "Eliminacion abortada. La lista sigue disponible");
					terminado = true;
				}
			} while (!terminado);
		} else {
			System.out.println("La lista " + listaAux.nombre + " no se puede eliminar." + "\n" + "Operacion cancelada");
			listaAux = null;
		}
	}

	public static void mostrarListas(ArrayList<ListaReproduccion> listaX) {
		int indx = 1;
		System.out.println("Listas disponibles: ");
		for (ListaReproduccion listaAux : listaX) {
			System.out.println(indx + ". " + listaAux.toString());
			indx++;
		}
		System.out.println("");
	}

	public static ListaReproduccion buscarListaPrincipal(ArrayList<ListaReproduccion> listaX) {
		ListaReproduccion listaPrincipal = new ListaReproduccion();
		
		for(ListaReproduccion listaAux : listaX) {
			if(listaAux.nombre.equals("Toda la musica")) {
				listaPrincipal = listaAux;
			}
		}

		return listaPrincipal;
	}

	public static void opcion8(ArrayList<ListaReproduccion> listaX){
		Scanner sc = new Scanner(System.in);
		ListaReproduccion listaPrincipal = buscarListaPrincipal(listaX);
		ArrayList<String> generosAgrupados = new ArrayList<String>(agruparGeneros(listaPrincipal));
		mostrarGeneros(generosAgrupados);
		
		boolean fin = false;

		do{
			System.out.print("Elija un genero: ");
			int opUsuario = sc.nextInt();

			if(opUsuario>0&&opUsuario<generosAgrupados.size()+1){
				String generoElegido = generosAgrupados.get(opUsuario-1);
				ListaReproduccion nuevaCreada = crearListaPorGenero(listaPrincipal, generoElegido);
				System.out.println("\n" + "Reproduciendo: " + nuevaCreada.toString());
				nuevaCreada.reproduccionLista();
				listaX.add(nuevaCreada);
				System.out.println("(La lista se ha añadido)");
				fin = true;
			}

		}while(!fin);
	}
	
	public static HashSet<String> agruparGeneros(ListaReproduccion listaPrincipal){
		HashSet<String> generos = new HashSet<String>();		
		for(Cancion canX : listaPrincipal.listaCanciones) {
			generos.add(canX.genero);
		}
		return generos;
	}
	
	public static void mostrarGeneros(ArrayList<String> listaGeneros) {
		int indx = 1;
		
		for(String genero : listaGeneros) {
			System.out.println(indx + " ." + genero);
			indx++;
		}
		System.out.println("");
	}

	public static ListaReproduccion crearListaPorGenero(ListaReproduccion listaPrincipal, String generoElegido) {
		ArrayList<Cancion> listaAux = new ArrayList<Cancion>();
		ListaReproduccion nuevaLista = new ListaReproduccion("Lista " + generoElegido, listaAux);
		
		for(Cancion canX : listaPrincipal.listaCanciones) {
			if(canX.genero.equals(generoElegido)) {
				nuevaLista.listaCanciones.add(canX);
			}
		}
		nuevaLista.duracionLista();
		return nuevaLista;
	}

	public static boolean opcion9() {
		Scanner sc = new Scanner(System.in);
		boolean fin = false;
		System.out.print("Confirme con S/s si decia salir: ");
		String elecUsuario = sc.nextLine();

		if (elecUsuario.equals("S") || elecUsuario.equals("s")) {
			fin = true;
			System.out.println("\n" + "Gracias por usar Reproductor de musica" + "\n");
			System.out.println("Aplicacion terminada" + "\n");
		}
		return fin;
	}
}
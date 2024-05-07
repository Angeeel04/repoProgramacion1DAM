package coleccionesYExcepciones;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
/*HECHO POR ANGEL CHAVEZ 1º DAM*/

public class Main {
	public static void main(String [] args) {
		ArrayList<Socio> listaSocios = new ArrayList<Socio>();
		LinkedHashMap<String, Integer> coleccionSocios = new LinkedHashMap<>();
		eleccionOpcion(listaSocios, coleccionSocios);
		System.out.println("Aplicacion terminada");
	}
	
	public static void mostrarMenu(ArrayList<Socio> listaSocios) {
		System.out.println("");
		System.out.println("Socios de alta: " + listaSocios.size()+ "\n");
		System.out.println("Socios activos: " + contadorActivos(listaSocios) + "\n");
		System.out.println("\t   MENU   ");
		System.out.println("\t==========");
		System.out.println("1. Dar de alta socio");
		System.out.println("2. Ver datos socio");
		System.out.println("3. Dar de baja socio");
		System.out.println("4. Salir del programa" + "\n");
	}
	public static int contadorActivos(ArrayList<Socio> listaSocios) {
		int contador = 0;
		for(Socio socioAux : listaSocios) {
			if(socioAux.estado.equals("ACTIVO")) {
				contador++;
			}
		}
		return contador;
	}
	
	public static void eleccionOpcion(ArrayList<Socio> listaSocios, LinkedHashMap<String, Integer> coleccionSocios){
		boolean salir = false;
		do {
			mostrarMenu(listaSocios);
			System.out.print("Elije opcion: ");
			
			try {
				Scanner sc = new Scanner(System.in);
				int opUsuario = sc.nextInt();
				System.out.println("");
				
				switch(opUsuario) {
					case 1:
						opcion1(listaSocios, coleccionSocios);
					break;
					
					case 2:
						opcion2(listaSocios, coleccionSocios);
					break;
					
					case 3:
						opcion3(listaSocios, coleccionSocios);
					break;
					
					case 4:
						opcion4();
						salir = true;
					break;
					
					default:
						System.out.println("Opcion no disponible");
						System.out.println("Opciones válidas de 1 a 4.");
					break;
				}
			}catch(InputMismatchException e) {
				System.out.println("Solo números por favor. Inténtalo otra vez.");
				System.out.println("Opciones válidas de 1 a 4.");
			}
		}while(!salir);
	}
	
	public static void opcion1(ArrayList<Socio> listaSocios, LinkedHashMap<String, Integer> coleccionSocios){
		System.out.print("Opción 1.-Alta de socio" + "\n \n");
		
		String nombre = pedirNombre();
		String numTelef = pedirNumTelef();
		String dni = pedirDni(coleccionSocios);
		
		if(nombre.length()>5 && nombre.length()<=20 && numTelef.length()==9 && dni.length()==9) {	// comprobamos que los datos correspondan a las especificaciones
			Socio nuevoSocio = new Socio(nombre, numTelef, dni);
			listaSocios.add(nuevoSocio);
			coleccionSocios.put(dni, listaSocios.indexOf(nuevoSocio));
		} else {
			System.out.print("Entrada de socio abortada por datos incorrectos" + "\n \n");
		}
	}

	public static String pedirNombre() {
		System.out.print("Introduce tu nombre o apodo (máximo 20 caracteres): ");
		String nombre_apodo = "";
		
		try {
			Scanner sc = new Scanner(System.in);
			nombre_apodo = sc.nextLine();
			
			if(nombre_apodo.length()<5) {	// (condicion extra) el nombre almenos deberá tener 5 caracteres, sobretodo para que no acepte nombres vacios
				System.out.println("Nombre muy corto, este socio no se agregará.");
			}
			
			if(nombre_apodo.length()>20) {	// en caso de que el nombre contenga mas de 20 caracteres se instancia una excepcion, para luego manejarla correctamente	
				throw new NombreTooLongException();
			}
			
		}catch(NombreTooLongException e) {
			System.out.println("Nombre demasiado largo" + "\n \n" + "Se recorta el nombre a 20 caracteres");
			nombre_apodo = nombre_apodo.substring(0,20);
		}
		
		System.out.println("");
		return nombre_apodo;
	}
	
	public static String pedirNumTelef() {
		System.out.print("Introduce tu telefono (9 digitos sin espacios): ");
		String numTelef = "";
		
		try {
			numTelef = validarNumTelef();
		}catch(TelefonoInvalidFormat e) {
			System.out.println("Teléfono incorrecto. Formato correcto nueve digitos sin espacios : 123456789");
			numTelef = "";
		}
		
		System.out.println("");
		return numTelef;
	}

	public static String validarNumTelef() throws TelefonoInvalidFormat {
		Scanner sc = new Scanner(System.in);
		String numTelef = "";
		numTelef = sc.nextLine();
		
		if(numTelef.length()==9) {
			int indx = 0;
			boolean fin = false;
			
			while(!fin && indx<9) {
				char caracter = numTelef.charAt(indx);
				
				if(caracter == ' ') {	// en caso de que el numero contenga caracteres vacios instanciamos una excepcion
					fin = true;
					throw new TelefonoInvalidFormat();
				} else if(caracter < 48 || caracter > 57) {	// el numero solo podrá contener numeros, no letras ni simbolos
					fin = true;
					throw new TelefonoInvalidFormat();
				} else {
					indx++;
				}
			}
		} else {
			throw new TelefonoInvalidFormat();
		}
		
		System.out.println("Teléfono válido");
		return numTelef;
	}
	
	public static String pedirDni(LinkedHashMap<String, Integer> coleccionSocios) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce tu DNI (8 digitos + una mayúscula): ");
		String dni = "";
		
		try {
			dni = validarDni();
		}catch(DniInvalidFormat e) {
			System.out.println("DNI incorrecto. Formato correcto ocho dígitos + letra mayúscula: 12345678A");
			dni = "";
		}
		
		if(coleccionSocios.containsKey(dni)) {
			System.out.println("\n" + "Este DNI ya está registrado con otro socio.");
			dni = "";
		}
		
		System.out.println("");
		return dni;
	}
	
	public static String validarDni() throws DniInvalidFormat{
		Scanner sc = new Scanner(System.in);
		String dni = sc.nextLine().toUpperCase();
		
		if(dni.length()==9) {
			String recorte1 = dni.substring(0,8);
			String recorte2 = dni.substring(8);
			
			boolean fin = false;
			int indx=0;
			
			while(!fin && indx<8) {	// este bucle revisará la parte numerica del DNI, en caso de que encuentre algo mal finalizará el bucle e instanciará una excepcion
				if(recorte1.charAt(indx) >= 48 && recorte1.charAt(indx) <= 57) {
					indx++;
				} else {
					fin = true;
					throw new DniInvalidFormat();
				}
			}
			
			if(recorte2.charAt(0) < 65 || recorte2.charAt(0) > 90) {	// esta condicion evalua la última letra mayúsucula
				throw new DniInvalidFormat();
			}
			
		}else {
			throw new DniInvalidFormat();
		}
		
		System.out.println("DNI válido");
		return dni;
	}

	public static void opcion2(ArrayList<Socio> listaSocios, LinkedHashMap<String, Integer> coleccionSocios){
		System.out.print("Opción 2.-Ver datos socio" + "\n \n");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Inserta el DNI de la operacion: ");
		String dni = "";
		boolean seguir = true;
		
		try {
			dni = validarDni();
		}catch(DniInvalidFormat e) {
			System.out.println("DNI invalido.");
			seguir =  false;
		}
		
		if(seguir) {
			if(coleccionSocios.containsKey(dni)) {	// en caso de que el DNI esté registrado en la coleccion
				Socio socioAux = listaSocios.get(coleccionSocios.get(dni));
				
				if(socioAux.estado.equals("ACTIVO")) {
					System.out.println("\n" + "Los datos de esta persona son: ");
					System.out.println(socioAux.toString());
				} else {
					System.out.println("\n" + "Este socio no está activo en este momento ");
				}
			} else {
				System.out.println("\n" + "No hay socio con ese DNI");
			}
			
			System.out.println("");
		}
	}

	public static void opcion3(ArrayList<Socio> listaSocios, LinkedHashMap<String, Integer> coleccionSocios){
		System.out.print("Opción 3.-Dar de baja socio" + "\n \n");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Inserta el DNI de la operacion: ");
		String dni = "";
		boolean seguir = true;
		
		try {
			dni = validarDni();
		}catch(DniInvalidFormat e) {
			System.out.println("DNI invalido.");
			seguir =  false;
		}

		if(seguir) {
			if(coleccionSocios.containsKey(dni)) {	// en caso de que el DNI esté registrado en la coleccion
				Socio socioAux = listaSocios.get(coleccionSocios.get(dni));
				
				if(socioAux.getEstado().equals("BAJA")){
					System.out.println("\n" + "Ya estaba dado el socio de baja");
				}else {
					socioAux.setEstado("BAJA");
					System.out.println("\n" + "Se ha dado el socio de baja");
				}
			}else {
				System.out.println("\n" + "No hay socio con ese DNI");
			}
			
			System.out.println("");
		}
	}
	
	public static void opcion4(){
		System.out.print("Opción 4.-Salir de la aplicación" + "\n \n");
	}
}
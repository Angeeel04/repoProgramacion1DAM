import java.util.ArrayList;
import java.util.Scanner;
/*HECHO POR ANGEL CHAVEZ 1º DAM*/
public class Main {
	public static void main(String [] args) {
		ArrayList<Empleados> listaEmpleados = new ArrayList<Empleados>();
		listaEmpleados.add(new MozoAlmacen("Luis","Villar", "Torres", "95135764J",880));
		listaEmpleados.add(new JefeSeccion("Paco","López", "Moreno", "1234567K", 500));
		listaEmpleados.add(new JefePlanta("Pablo","Pereda", "Puig", "14725836F", 480));
		listaEmpleados.add(new PersonalAdministracion("Paulo","Baleares", "Ramirez", "1251824A", 240));
		listaEmpleados.add(new Directivo("Ana","Recio", "Ramos", "8945621P", 300));
		Scanner sc = new Scanner(System.in);

		while(true) {
			mostrarMensaje();
			dirigiendoOpcion(seleccionarOpcion(sc), listaEmpleados);
			System.out.println("");
		}
	}
	
	public static void mostrarMensaje() {
		System.out.println("\t \t" +  " MENU ");
		System.out.println("\t \t" +  "======");
		System.out.println("1. Introducir trabajador");
		System.out.println("2. Eliminar trabajador");
		System.out.println("3. Mostrar sueldo e indemnización trabajador");
		System.out.println("4. Ver empleados de una categoria" + "\n");
	}
	
	public static int seleccionarOpcion(Scanner sc) {
		int opUsuario = 0;
		boolean fin = false;
		do {
			System.out.print("Elija opción: ");
			opUsuario = sc.nextInt();
			
			if(opUsuario>0 && opUsuario<5) {
				fin = true;
			}
			System.out.println("");
		}while(!fin);
		
		return opUsuario;
	}
	
	public static void dirigiendoOpcion(int opcion, ArrayList<Empleados> lista) {
		switch(opcion){
			case 1:
				creaEmpleado(lista);
			break;
			
			case 2:
				eliminarEmpleado(lista);
			break;
			
			case 3:
				mostrarSueldoIndemnizacion(lista);
			break;
			
			case 4:
				empleadosCategoria(lista);
			break;
		}
	}

	public static void creaEmpleado(ArrayList<Empleados> lista) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nombre: ");
		String nombre = sc.next();
		System.out.println("");
		
		System.out.print("Primer apellido: ");
		String apellido1 = sc.next();
		System.out.println("");
		
		System.out.print("Segundo apellido: ");
		String apellido2 = sc.next();
		System.out.println("");
		
		System.out.print("DNI: ");
		String dni = sc.next();
		System.out.println("");
		
		System.out.print("Puesto: 1: Mozo | 2: Jefe de seccion | 3: Jefe de planta | 4: Personal administrativo | 5 : Directivo : ");
		añadeEmpleado(sc.nextInt(),nombre, apellido1, apellido2, dni, lista);
	}
	
	public static void añadeEmpleado(int puesto,String nombre, String apellido1, String apellido2, String dni, ArrayList<Empleados> lista) {		
		switch (puesto) {
			case 1:
				MozoAlmacen emp1 = new MozoAlmacen (nombre, apellido1, apellido2, dni, introducirAntiguedad());
				lista.add(emp1);
			break;
			
			case 2:
				JefeSeccion emp2 = new JefeSeccion (nombre, apellido1, apellido2, dni, introducirAntiguedad());
				lista.add(emp2);
			break;
				
			case 3:
				JefePlanta emp3 = new JefePlanta (nombre, apellido1, apellido2, dni, introducirAntiguedad());
				lista.add(emp3);
			break;
				
			case 4:
				PersonalAdministracion emp4 = new PersonalAdministracion (nombre, apellido1, apellido2, dni, introducirAntiguedad());
				lista.add(emp4);
			break;
				
			case 5:
				Directivo emp5 = new Directivo (nombre, apellido1, apellido2, dni, introducirAntiguedad());
				lista.add(emp5);
			break;

			default:
				System.out.println("No ha elegido una opcion correcta. Trabajador NO introducido");;
			break;
		}
	}
	
	public static int introducirAntiguedad() {
		System.out.println("");
		Scanner sc = new Scanner (System.in);
		int diasAntiguedad = 0;
		boolean fin = false;
		do {
			System.out.print("Dias antiguedad: ");
			diasAntiguedad = sc.nextInt();
			if(diasAntiguedad>0) {
				fin = true;
			}
		}while(!fin);

		return diasAntiguedad;
	}

	public static void mostrarEmpleados(ArrayList<Empleados> lista) {
		if(lista.size()>0) {
			int indx = 0;
			do {
				System.out.println(indx+1 + ".- " + lista.get(indx).toString());
				indx++;
			}while(indx<lista.size());
		} else {
			System.out.println("No hay trabajadores registrados");
		}
		System.out.println("");
	}
	
	public static void eliminarEmpleado(ArrayList<Empleados> lista) {
		Scanner sc = new Scanner (System.in);
		mostrarEmpleados(lista);

		if(lista.size()>0){
			boolean fin = false;
			do{
				System.out.print("¿Que empleado desea eliminar? ");
				int opcion = sc.nextInt();

				if(opcion>0 && opcion<=lista.size()){
					lista.remove(opcion-1);
					fin = true;
				}
			}while(!fin);
		}
	}

	public static void mostrarSueldoIndemnizacion(ArrayList<Empleados> lista){
		Scanner sc = new Scanner(System.in);
		mostrarEmpleados(lista);

		if(lista.size()>0){
			boolean fin = false;
			do{
				System.out.print("¿De que empleado desea ver sueldo e indemnizacion? ");
				int opcion = sc.nextInt();
				if(opcion>0 && opcion<=lista.size()){
					System.out.println("");
					Empleados emp1 = (Empleados) lista.get(opcion-1);
					System.out.println(emp1.mostrarDatos());
					complementoDatos(emp1);
					fin = true;
				}
			}while(!fin);
		}
	}

	public static void empleadosCategoria(ArrayList <Empleados> lista){
		if(lista.size()>0){
			Scanner sc = new Scanner(System.in);
			System.out.println("¿Los empleados de que categoria quiere mostrar?");
			System.out.println("1.- Mozos");
			System.out.println("2.- Jefes de seccion");
			System.out.println("3.- Jefes de planta");
			System.out.println("4.- Personal administrativo");
			System.out.println("5.- Directivos" + "\n");

			if(lista.size()>0){
				boolean fin = false;
				int opcion = 0;	
				do{
					System.out.print("Elige una opcion: ");
					opcion = sc.nextInt();
					if(opcion>0&&opcion<6){
						System.out.println("");
						elegirMostrarInstancia(lista, opcion);
						fin=true;
					}
				}while(!fin);
			}
		} else{
			System.out.println("No hay trabajadores registrados");
		}
	}

	public static void elegirMostrarInstancia(ArrayList <Empleados> lista, int opcion){
		switch (opcion) {
			case 1:
				for (Empleados emp1 : lista) {
					if(emp1 instanceof MozoAlmacen){
						System.out.println(emp1.mostrarDatos());
						complementoDatos(emp1);
					}
				}
			break;

			case 2:
				for (Empleados emp1 : lista) {
					if(emp1 instanceof JefeSeccion){
						System.out.println(emp1.mostrarDatos());
						complementoDatos(emp1);
					}
				}
			break;

			case 3:
				for (Empleados emp1 : lista) {
					if(emp1 instanceof JefePlanta){
						System.out.println(emp1.mostrarDatos());
						complementoDatos(emp1);
					}
				}
			break;

			case 4:
				for (Empleados emp1 : lista) {
					if(emp1 instanceof PersonalAdministracion){
						System.out.println(emp1.mostrarDatos());
						complementoDatos(emp1);
					}
				}
			break;

			case 5:
				for (Empleados emp1 : lista) {
					if(emp1 instanceof Directivo){
						System.out.println(emp1.mostrarDatos());
						complementoDatos(emp1);
					}
				}
			break;
		}

	}

	public static void complementoDatos(Empleados emp1){
		System.out.println("Sueldo neto: " + emp1.getSueldoNeto() + " Indemnizacion: " + emp1.getIndemnizacion());
		System.out.println("");
	}
}
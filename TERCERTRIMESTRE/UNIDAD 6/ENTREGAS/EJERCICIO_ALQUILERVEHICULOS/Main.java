import java.util.ArrayList;
import java.util.Scanner;
/*HECHO POR ANGEL CHAVEZ 1ºDAM */
public class Main {
	public static void main (String [] args) {
		//CREAMOS LOS OBJETOS QUE NECESITAREMOS
		Coche co1 = new Coche("9845LKS", "Renault Clio", "203 hp", 4);
		Coche co2 = new Coche("4365LLF", "Citroen C3", "375 hp", 4);
		Coche co3 = new Coche("7423KZF", "Peugeot 208", "228 hp", 2);
		Coche co4 = new Coche("7190LLB", "Volkswagen Golf", "670 hp", 4);
		Coche co5 = new Coche("1122KTL", "Mercedes CLA", "306 hp", 4);
		Coche co6 = new Coche("4447LLM", "Seat Ateca", "490 hp", 2);
		Coche co7 = new Coche("2356LBM", "Seat Leon ", "285 hp", 4);
		
		Furgoneta fu1 = new Furgoneta("1998KZZ", "Peugeot Boxer", "188 hp", 14.00);
		Furgoneta fu2 = new Furgoneta("4321LCC", "Reanault Kangoo ZE", "275 hp", 12.00);
		Furgoneta fu3 = new Furgoneta("5557LH3", "Ford Transit", "150 hp", 17.00);
		
		Moto mo1 = new Moto("9987LDD", "Kawasaki J300", "200 hp", false);
		Moto mo2 = new Moto("5554LDD", "Yamaha NMAX", "93 hp", true);
		
		Empresa emp1 = new Empresa("NorAuto", "F26707414");
		Empresa emp2 = new Empresa("IKEA", "B24683674");
		Empresa emp3 = new Empresa("Alcampo", "U19287887");
		Empresa emp4 = new Empresa("Mercadona", "G19862267");
		Empresa emp5 = new Empresa("MediaMarkt", "V10309102");
		Empresa emp6 = new Empresa("Supeco", "G49006091");
		
		//CREAMOS ARRAYS PARA FACILITAR EL AÑADIR A LOS ARRAYSLISTS
		Vehiculo [] vehiculos = {co1, co2, co3, co4, co5, co6, co7, fu1, fu2, fu3, mo1, mo2};
		Empresa [] empresas = {emp1, emp2, emp3, emp4, emp5, emp6};
		
		//CREAMOS ARRAYSLISTS Y AÑADIMOS LOS OBJETOS CON METODOS
		ArrayList<Vehiculo> alquilerEmp0 = new ArrayList<Vehiculo>();
		ArrayList<Vehiculo> alquilerEmp1 = new ArrayList<Vehiculo>();
		ArrayList<Vehiculo> alquilerEmp2 = new ArrayList<Vehiculo>();
		ArrayList<Vehiculo> alquilerEmp3 = new ArrayList<Vehiculo>();
		ArrayList<Vehiculo> alquilerEmp4 = new ArrayList<Vehiculo>();
		ArrayList<Vehiculo> alquilerEmp5 = new ArrayList<Vehiculo>();

		ArrayList<Vehiculo> vehiculosNoAlquilados = añadirVehiculos(vehiculos);
		ArrayList<ArrayList<Vehiculo>> listaContenedorEmpresas = añadirListas(alquilerEmp0, alquilerEmp1, alquilerEmp2, alquilerEmp3, alquilerEmp4, alquilerEmp5);
		
		//VARIABLES
		int dias = 1, opCliente = 0;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("DIA " + dias);
			
			do {
				System.out.print("¿Qué empresa desea alquilar un vehiculo? : ");
				opCliente = sc.nextInt();				
				
				if(opCliente > 0 && opCliente <= listaContenedorEmpresas.size()) {
					System.out.println("\n" + empresas[opCliente-1].getNombre() + "\n");
					seleccionarVehiculo(listaContenedorEmpresas.get(opCliente-1), vehiculosNoAlquilados);
				}
				
			}while(opCliente != -1);
			
			mostrarVehiculosSinAlquilar(vehiculosNoAlquilados);
			mostrarVehiculosAlquilados(listaContenedorEmpresas, empresas);
			dias++;
			restarDias(listaContenedorEmpresas, vehiculosNoAlquilados);
		}
	}
	
	public static ArrayList<Vehiculo> añadirVehiculos(Vehiculo [] vehiculos) {	//este metodo recibe un array, los introduce en un ArrayList y lo devuelve
		ArrayList<Vehiculo> vehiculosNoAlquilados = new ArrayList<>();
		for(int a=0; a<vehiculos.length;a++) {
			vehiculosNoAlquilados.add(vehiculos[a]);
		}
		return vehiculosNoAlquilados;
	}	

	public static ArrayList<ArrayList<Vehiculo>> añadirListas(ArrayList<Vehiculo> emp1, ArrayList<Vehiculo> emp2, ArrayList<Vehiculo> emp3, ArrayList<Vehiculo> emp4, ArrayList<Vehiculo> emp5, ArrayList<Vehiculo> emp6) {	//este metodo recibe 6 ArrayLists y los agrupa en un ArrayList mayor, esto para facilitar el manejo de las listas
		ArrayList<ArrayList<Vehiculo>> listaContenedor = new ArrayList<ArrayList<Vehiculo>>();
		listaContenedor.add(emp1);
		listaContenedor.add(emp2);
		listaContenedor.add(emp3);
		listaContenedor.add(emp4);
		listaContenedor.add(emp5);
		listaContenedor.add(emp6);
		return listaContenedor;
	}
	
	public static void seleccionarVehiculo(ArrayList<Vehiculo> empresaX, ArrayList<Vehiculo> listaVehiculos) {	//metodo encargado de elegir el vehiculo a alquilar (está enlazado con otros metodos)
		Scanner sc = new Scanner (System.in);
		int opVehiculo = 0;
		
		do {
			System.out.print("¿Qué vehículo se desea alquilar? (1: Coche  2: Furgoneta  3: Moto): ");
			opVehiculo = sc.nextInt();
			System.out.println("");
			
			if(opVehiculo > 0 && opVehiculo < 4) {				
				switch(opVehiculo) {
					case 1:
						seleccionCoche(empresaX, listaVehiculos);
					break;
					
					case 2:
						seleccionFurgoneta(empresaX, listaVehiculos);
					break;
					
					case 3:
						seleccionMoto(empresaX, listaVehiculos);
					break;
				}
			}
			System.out.println("");
		}while(opVehiculo != -1);
	}
	
	public static void seleccionCoche(ArrayList<Vehiculo> empresaX, ArrayList<Vehiculo> listaVehiculos) {	//metodo encargado de trasladar objetos de clase Coche de una lista a otra, segun pida el cliente
		boolean fin = false;
		int indx = 0;

		while (!fin) {
			if(indx<listaVehiculos.size()){
				if(listaVehiculos.get(indx) instanceof Coche){
					diasAlquiler(listaVehiculos.get(indx));
					empresaX.add(listaVehiculos.get(indx));
					listaVehiculos.remove(listaVehiculos.get(indx));
					fin = true;
				} else{
					indx++;
				}
			} else{
				System.out.println("No quedan coches disponibles");
				fin = true; 
			}
		}
	}

	public static void seleccionFurgoneta(ArrayList<Vehiculo> empresaX, ArrayList<Vehiculo> listaVehiculos) { //metodo encargado de trasladar objetos de clase Furgoneta de una lista a otra, segun pida el cliente
		boolean fin = false;
		int indx = 0;
		
		while (!fin) {
			if(indx<listaVehiculos.size()){
				if(listaVehiculos.get(indx) instanceof Furgoneta){
					diasAlquiler(listaVehiculos.get(indx));
					empresaX.add(listaVehiculos.get(indx));
					listaVehiculos.remove(listaVehiculos.get(indx));
					fin = true;
				} else{
					indx++;
				}
			} else{
				System.out.println("No quedan furgonetas disponibles");
				fin = true;
			}
		}
	}
	
	public static void seleccionMoto(ArrayList<Vehiculo> empresaX, ArrayList<Vehiculo> listaVehiculos) { //metodo encargado de trasladar objetos de clase Moto de una lista a otra, segun pida el cliente
		boolean fin = false;
		int indx = 0;
		
		while (!fin) {
			if(indx<listaVehiculos.size()){
				if(listaVehiculos.get(indx) instanceof Moto){
					diasAlquiler(listaVehiculos.get(indx));
					empresaX.add(listaVehiculos.get(indx));
					listaVehiculos.remove(listaVehiculos.get(indx));
					fin = true;
				} else{
					indx++;
				}
			} else{
				System.out.println("No quedan motos disponibles");
				fin = true;
			}
		}
	}
	
	public static void diasAlquiler(Vehiculo ob) {	//metodo encargado de solicitar y almacenar los dias de alquiler de cada vehiculo, asegurandose de que el alquiler sea mayor a 1 día
		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		do{
			System.out.print("¿Durante cuantos dias?: ");
			int diasCliente = sc.nextInt();
			if(diasCliente>0){
				ob.setDiasAlquiler(diasCliente);
				salir=true;
			}
		}while(!salir);
	}

	public static void restarDias(ArrayList<ArrayList<Vehiculo>> listaContenedorEmpresas, ArrayList<Vehiculo> listaSinAlquiler){	//metodo encargado de disminuir los dias de alquiler de cada objeto y en caso de que la cuenta de dias llegue a 0 se trasladará a otra lista
		for(ArrayList<Vehiculo> lista: listaContenedorEmpresas){
			int indx = 0;
			while (indx<lista.size()) {
				if(lista.get(indx).getDiasAlquiler()>1){
					int dias = (lista.get(indx)).getDiasAlquiler() - 1;
					(lista.get(indx)).setDiasAlquiler(dias);
				}else{
					listaSinAlquiler.add(lista.get(indx));
					lista.remove(lista.get(indx));
					indx--;
				}
				indx++;
			}
		}
	}

	public static int[] contadorVehiculos(ArrayList<Vehiculo> lista) {	//metodo encargado de contar los objetos segun el tipo de vehiculo, devuelve un array con dichos datos (empleado en el "mostrarVehiculosSinAlquilar")
		int contCoches=0, contFurgonetas=0, contMotos=0;
		int [] contadores= new int[3];

		if(lista.size()>0){
			for(Vehiculo ob: lista) {
				if(ob instanceof Coche) {
					contCoches++;
				} else if(ob instanceof Furgoneta) {
					contFurgonetas++;
				} else{
					contMotos++;
				}
			}
			contadores = new int[]{contCoches, contFurgonetas, contMotos};
		} else{
			contadores = new int[]{contCoches, contFurgonetas, contMotos};
		}
		return contadores;
	}

	public static void mostrarVehiculosSinAlquilar(ArrayList<Vehiculo> lista) {	//metodo encargado de mostrar los vehiculos que aun se encuentran sin ser alquilados
		int [] numVehiculos = contadorVehiculos(lista);

		if(numVehiculos[0]>0){
			System.out.println("\n" + "Coches sin alquilar" + "\n" + "======================");
			for(Vehiculo ob: lista) {
				if(ob instanceof Coche) {
					System.out.println(ob.toString());
				}
			}
		}

		if(numVehiculos[1]>0){
			System.out.println("\n" + "Furgonetas sin alquilar" + "\n" + "======================");
			for(Vehiculo ob: lista) {
				if(ob instanceof Furgoneta) {
					System.out.println(ob.toString());
				}
			}
		}

		if(numVehiculos[2]>0){
			System.out.println("\n" + "Motos sin alquilar" + "\n" + "======================");
			for(Vehiculo ob: lista) {
				if(ob instanceof Moto) {
					System.out.println(ob.toString());
				}
			}	
		}
		System.out.println("");
	}
	
	public static void mostrarVehiculosAlquilados(ArrayList<ArrayList<Vehiculo>> listaContenedorEmpresas, Empresa [] empresas) {	//metodo encargado de mostrar los vehiculos alquilados
		int indx = 0;

		for (ArrayList<Vehiculo> lista: listaContenedorEmpresas) {
			if(lista.size()>0){
				System.out.println(empresas[indx].getNombre());
				for(Vehiculo ob : lista){
					System.out.println(ob.toString() + " quedan " + ob.getDiasAlquiler() + " de alquiler");
				}
				System.out.println("");
			}
			indx++;
		}
	}
}
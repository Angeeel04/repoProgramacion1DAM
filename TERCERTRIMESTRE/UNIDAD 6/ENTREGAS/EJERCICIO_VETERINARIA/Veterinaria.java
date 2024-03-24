import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Veterinaria{
	/*HECHO POR ANGEL CHAVEZ 1º DAM */
	public static void main(String [] args){
		//INTRODUCIENDO ANIMALES
		Perro perro1 = new Perro("Chispa", 7, "RazaP1");
		Perro perro2 = new Perro("Keylor", 5, "RazaP2");
		Perro perro3 = new Perro("Tobi", 3, "RazaP3");

		Gato gato1 = new Gato("Elliot", 2, "Corto");
		Gato gato2 = new Gato("Loren", 4, "Largo");
		Gato gato3 = new Gato("Kiko", 1, "Mediano");

		Loro loro1 = new Loro("Frodo", 5, "Verde");
		Loro loro2 = new Loro("Nely", 6, "Azul");
		Loro loro3 = new Loro("Bilbo", 9, "Amarillo");
		
		//INTRODUCEMOS LOS ANIMALES EN UN ARRAY PARA FACILITAR SU MANEJO
		Animal [] listaPacientes = {perro1, perro2, perro3, gato1, gato2, gato3, loro1, loro2, loro3};
		
		//CREAMOS DOS ARRAYLISTS, PARA LOS ANIMALES SANOS Y LOS ENFERMOS
		ArrayList<Animal> ALAnimalesSanos = new ArrayList<Animal>();
		ArrayList<Animal> ALAnimalesEnfermos = new ArrayList<Animal>();
		generarEnfermos(listaPacientes, ALAnimalesSanos, ALAnimalesEnfermos); //funcion que nos genera tres animales enfermos aleatoriamente

		int numeroDias = 1, opUsuario = 0;
		Scanner sc = new Scanner(System.in);

		while (true) {
			boolean finB1 = false, finB2 = false;
			System.out.println("DIA " + numeroDias);

			do{
				if(ALAnimalesEnfermos.size()>0){	//en caso de que la lista contenga animales enfermos
					System.out.println("\n Animales Enfermos");
					mostrarLista(ALAnimalesEnfermos);

					System.out.println("");
					System.out.print("¿Qué animal se ha recuperado ya?" + " (1 - " + ALAnimalesEnfermos.size() + ") (-1: ninguno) ");
					opUsuario = sc.nextInt();

					if(opUsuario > 0 && opUsuario <= ALAnimalesEnfermos.size()){	//establecemos las condiciones para las entradas del usuario
						ALAnimalesSanos.add(ALAnimalesEnfermos.get(opUsuario-1));	//realizamos el intercambio entre la lista de animales enfermos y sanos
						ALAnimalesEnfermos.remove(opUsuario-1);	//eliminamos el animal enfermo, ya que ahora está sano
					}

					else if(opUsuario == -1){	//en caso de que el usuario introduzca un -1
						finB1 = true;
					}	
				} else{	//en caso de que la lista ya no contenga animales enfermos
					System.out.println("");
					System.out.println("No hay animales enfermos");
					finB1 = true;
				}		
			}while(!finB1); //el bucle se ejecutará mientras el booleano sea falso

			System.out.println("");

			do{
				if(ALAnimalesSanos.size()>0){	//en caso de que la lista contenga animales sanos
					System.out.println("\n Animales Sanos");
					mostrarLista(ALAnimalesSanos);

					System.out.println("");
					System.out.print("¿Qué animal se ha enfermado?" + " (1 - " + ALAnimalesSanos.size() + ") (-1: ninguno) ");
					opUsuario = sc.nextInt();

					if(opUsuario > 0 && opUsuario <= ALAnimalesSanos.size()){	//establecemos las condiciones para las entradas del usuario
						ALAnimalesEnfermos.add(ALAnimalesSanos.get(opUsuario-1));	//realizamos el intercambio entre la lista de animales sanos y enfermos
						ALAnimalesSanos.remove(opUsuario-1);	//eliminamos el animal sano, ya que ahora está enfermo
					}

					else if(opUsuario == -1){	//en caso de que el usuario introduzca un -1
						finB2 = true;
					}
				}	else{	//en caso de que la lista ya no contenga animales sanos
					System.out.println("");
					System.out.println("No hay animales sanos");
					finB2 = true;
				}
			}while(!finB2);

			System.out.println("");
			numeroDias++;
		}
	}

	public static void generarEnfermos(Animal [] listaPacientes, ArrayList<Animal> ALAnimalesSanos, ArrayList<Animal> ALAnimalesEnfermos){
		boolean [] posicionesUsadas = new boolean [listaPacientes.length];
		int contador = 0;

		do {
			Random rnd = new Random();
			int numRnd = (int) (rnd.nextDouble()*listaPacientes.length);	//generamos un numero aleatorio respecto al tamaño de la lista del array recibido por parametro

			if(contador < 3 && !posicionesUsadas[numRnd]){	//controlamos que sean solo 3 enfermos y que el numero aleatorio no haya sido usado
				ALAnimalesEnfermos.add(listaPacientes[numRnd]);	//añadimos el animal a la lista de enfermos
				posicionesUsadas[numRnd] = true;	//a la posicion del numero que se ha generado le asignamos a true, de esta manera ya no se podrá usar dicho numero
				contador++;
			}
				
			else if(contador >= 3 && !posicionesUsadas[numRnd]){	//controlamos los numeros restantes y que se añadan a la lista de animales sanos
				ALAnimalesSanos.add(listaPacientes[numRnd]);	//añadimos el animal a la lista de animales sanos
				posicionesUsadas[numRnd] = true;	//a la posicion del numero que se ha generado le asignamos a true, de esta manera ya no se podrá usar dicho numero
				contador++;
			}

		}while(contador<listaPacientes.length);	//controlamos que el contador no se exceda en relacion a la longitud del array de pacientes
	}

	public static void mostrarLista(ArrayList<Animal> lista){
		int indx = 1;
		for (Animal lector : lista) { //FOR-EACH ENCARGADO DE ENUMERAR Y MOSTRAR LOS ANIMALES
			System.out.println(indx + ". " + lector.nombre);
			indx++;
		}
	}
}	
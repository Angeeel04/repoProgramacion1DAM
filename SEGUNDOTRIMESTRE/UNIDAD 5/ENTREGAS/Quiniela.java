import java.util.Random;
import java.util.Scanner;

public class Quiniela {
	
	//Atributos
	private final int NUMERO_PARTIDOS = 15;
	private final static int LIMITE_QUINIELAS = 20;

	/**
	 * Atributo partido array de String que almacena los encuentros de la quiniela. 
	 * Dimensionado a NUMERO_PARTIDOS. Ejemplo: "Betis-Osasuna"
	 */
	private String [] partido; 
	
	/**
	 * Atributo apuesta array de char que almacena los pron?sticos para los encuentros de la quiniela. 
	 * Dimensionado a NUMERO_PARTIDOS. Ejemplo: '1', o 'X' o '2'
	 */
	private char [] apuesta; 

	//Constructores
	
	/** 
	 * Constructor vac?o que solo crea los atributos sin darles valor
	 */
	public Quiniela() {
		partido = new String [NUMERO_PARTIDOS];
		apuesta = new char [NUMERO_PARTIDOS];
	}
	

	/** 
	 * Constructor con dos atributos inicializados al valor de sus par?metros
	 * @param partido Array de String con los partidos de la quiniela
	 * @param apuesta Array de char con las apuestas para los partidos de la quiniela
	 */
	public Quiniela(String[] partido, char[] apuesta) {
		this.partido = partido;
		this.apuesta = apuesta;
	}

	//Métodos
	
	/**
	 * M?todo que establece los partidos de acuerdo al valor del par?metro suministrado.
	 * @param partido Array de String con los partidos de la quiniela
	 */
	public void setPartido(String[] partido) {
		this.partido = partido;
	}

	/**
	 * M?todo que establece las apuestas de acuerdo al valor del par?metro suministrado.
	 * @param apuesta Array de char con las apuestas de la quiniela
	 */
	public void setApuesta(char[] apuesta) {
		this.apuesta = apuesta;
	}

	/**
	 * M?todo que devuelve los partidos de la quiniela.
	 * @return partido Array de String con los partidos de la quiniela
	 */
	public String[] getPartido() {
		return partido;
	}

	/**
	 * M?todo que devuelve las apuestas de la quiniela.
	 * @return apuesta Array de char con las apuestas de la quiniela
	 */
	public char[] getApuesta() {
		return apuesta;
	}
	
	/**
	 * M?todo que pide los emparejamientos uno a uno por teclado para asignar valor a los partidos.
	 */
	public void pedirPartidos() {
		Scanner sc = new Scanner(System.in);
		String enfrentamiento="";
		for(int pos = 0; pos < partido.length; pos++) {
			System.out.print("\nEscriba el partido a disputar en la posici?n " + pos+ " : ");
			enfrentamiento = sc.nextLine();
			partido[pos] = enfrentamiento;
		}
	}

	/**
	 * M?todo que muestra los partidos por pantalla.
	 */
	public void mostrarPartidos() {
		for(int pos = 0; pos < partido.length; pos++) {
			System.out.print("\nPartido " + (pos + 1) + " : " + partido[pos]);
		}

		System.out.println("\n");
	}
	
	/**
	 * M?todo que muestra los partidos uno a uno por pantalla y pide las apuestas por teclado para asignarles valor.
	 */
	public void pedirApuestas() {
		Scanner sc = new Scanner(System.in);
		char pronostico;
		boolean apuestaValida = false;
		for(int pos = 0; pos < partido.length; pos++) {
			do {
				apuestaValida = false;
				System.out.print("\nEscriba su pronóstico para el partido " + partido[pos] +" : ");
				
				pronostico = sc.next().charAt(0);
				if (pronostico == '1' || pronostico == 'X' || pronostico == 'x' || pronostico == '2') {
					apuestaValida = true;				
					System.out.println("\nRecibido partido " + partido[pos]);
					if (pronostico == '1' || pronostico == '2') {
						apuesta[pos] = pronostico;
					}
					else apuesta[pos]= 'X'; 
				}
				else 
					System.out.println("\nError, las únicas apuestas posibles son 1 X 2, por favor, inténtelo de nuevo ");
			} while (!apuestaValida);
			
		}

		System.out.println("\n \n" + "Boleto rellenado" + "\n");
	}
	
	/**
	 * M?todo que muestra por pantalla los partidos uno a uno con la apuesta realizada en cada uno.
	 */
	public void mostrarPartidosyApuestas() {
		System.out.println();
		for(int pos = 0; pos < partido.length; pos++) {
			System.out.println(pos + 1  + ". " + this.partido[pos] + " : " + this.apuesta[pos]);
		}
	}

	/**
	 * M?todo que genera una apuesta aleatoria para cada partido.
	 */
	public void generarApuestasAleatorias() {
		Random rnd = new Random();
		int apAle = 0;
		for(int i = 0; i < partido.length; i++) {
			apAle = (int)(rnd.nextDouble() * 3 + 1);
			switch (apAle) {
				case 1: 
					apuesta[i] = '1';
					break;
				case 2: 
					apuesta[i] = '2';
					break;
				case 3: 
					apuesta[i] = 'X';
					break;
			}
		}
		
		System.out.println("\n \n" + "Boleto rellenado" + "\n");
	}

	/**
	 * M?todo que compara la apuesta realizada en cada uno de los partidos de la quiniela que se pasa por par?metro con las apuestas de la quiniela que recibe el mensaje y devuelve el n?mero de aciertos.
	 * @param quiniela Es la quiniela cuyos aciertos se desea comprobar
	 * @return Un valor entero que representa el n?mero de aciertos
	 */
	public int comprobarApuestas(Quiniela quiniela) {
		int numAciertos = 0;	
		for(int pos = 0; pos <this.partido.length; pos++) {
			if (this.apuesta[pos] == quiniela.apuesta[pos])	
				numAciertos++;
			}
		return(numAciertos);			
	}
	
	/**
	 * M?todo que copia los partidos del par?metro al objeto que recibe el mensaje
	 * @param quiniela
	 */
	public void copiarPartidos(Quiniela quiniela) {
		
		for(int pos = 0; pos < partido.length; pos++) {
			this.partido[pos] = quiniela.partido[pos];
		}
	}	
	
	/**
	 * M?todo que recibe un array de String por par?metro y lo copia para los partidos del objeto que recibe el mensaje.
	 * Si el par?metro tiene una longitud distinta del atributo no realiza la copia y muestra un mensaje por pantalla indicando este hecho.
	 * @param partidosExternos
	 */
	public void copiarPartidos(String [] partidosExternos) {
		if (partidosExternos.length == this.partido.length ) {
			for(int pos = 0; pos < partido.length; pos++) {
				this.partido[pos] = partidosExternos[pos];
			}
		}
		else
			System.out.print("Copia no realizada, número de partidos distinto");
	}
	
	/**
	 * M?todo que recibe una quiniela por par?metro y copia las apuestas del par?metro al objeto que recibe el mensaje.
	 * @param quiniela
	 */
	public void copiarApuestas(Quiniela quiniela) {
		
		for(int pos = 0; pos < apuesta.length; pos++) {
			this.apuesta[pos] = quiniela.apuesta[pos];
		}
	}
	
	/**
	 * M?todo que recibe unas apuestas por par?metro y las copia al atributo del objeto que recibe el mensaje.
	 * Si el par?metro tiene una longitud distinta del atributo no realiza la copia y muestra un mensaje por pantalla indicando este hecho.
	 * @param apuestasExternas
	 */
	public void copiarApuestas(char [] apuestasExternas) {
		if (apuestasExternas.length == this.apuesta.length ) {
			for(int pos = 0; pos < apuesta.length; pos++) {
				this.apuesta[pos] = apuestasExternas[pos];
			}
		}
		else
			System.out.print("Copia no realizada, número de apuestas distinto");
	}

	//Funciones
	public static void bienvenida(){	//funcion que imprime el menú quinielas
		System.out.println("\t Menú Quinielas");
		System.out.println("==============================================");
		System.out.println("1.  Rellenar una quiniela nueva manualmente");
		System.out.println("2.  Rellenar una quiniela nueva aleatoriamente");
		System.out.println("3.  Seleccionar la quiniela activa");
		System.out.println("4.  Comprobar los aciertos de la quiniela");
		System.out.println("5.  Mostrar los partidos de la jornada");
		System.out.println("6.  Mostrar los partidos y las apuestas");
		System.out.println("7.  Salir de la aplición" + "\n");
	}

	//Main
	public static void main(String[] args) {
	String [] enfrentamientos = {"Betis-Levante", "Osasuna-Villareal", "R. Madrid-Ath. Bilbao", "Granada_At. Madrid", "R. Sociedad-Barcelona", "Celta-Valladolid", "Sevilla-Cádiz", "Getafe-Huesca", "Valencia-Eibar", "Alavés-Elche", "Rayo V.-Español", "Mallorca-Sporting", "Zaragoza-Leganés", "Tenerife-Girona", "Cartagena-Almería"};
	char [] resultados = {'1', '2', '1', '1', '1', '2','X', 'X', '1', 'X', '2', '1', '2', '1', 'X'};
	Quiniela jornada = new Quiniela(enfrentamientos, resultados);

	Scanner sc = new Scanner(System.in);
	boolean finPrograma = false;
	int opcionUsuario = 0;

	Quiniela [] jugadas = new Quiniela [LIMITE_QUINIELAS];
	
	for(int a=0; a<jugadas.length; a++){
		if(a==0){
			jugadas[0] = jornada;
		} else{
			jugadas[a] = new Quiniela();
		}

	}
	int indice1 = 1; // indice utilizado para manejar el array quinielas, se inicia desde el 1 ya que la posicion 0 es la quiniela de la jornada

	do{
		bienvenida();
		System.out.print("Elige la opción deseada (1-7): ");
		opcionUsuario = sc.nextInt();

		if(opcionUsuario >= 1 && opcionUsuario <= 7){	//el usuario solo podrá elegir de la opcion 1 hasta la opcion 7
			System.out.println("\n" + "Opción elegida: " + opcionUsuario);

			switch (opcionUsuario){
				case 1:
					if(indice1<jugadas.length-1){	//en caso de elegir la opcion 1 y no sobrepasar el limite de quinielas
						jugadas[indice1].copiarPartidos(jugadas[0]); // seleccionará una quiniela y copiará los partidos de la quiniela oficial
						jugadas[indice1].pedirApuestas(); //llamará el metodo de pedir apuestas
						indice1++;
					} else{
						System.out.println("\n" + "Límite de quinielas alcanzado. Juega con responsabilidad" + "\n");
					}
				break;
	
				case 2:
					if(indice1<jugadas.length-1){
						jugadas[indice1].copiarPartidos(jugadas[0]); // seleccionará una quiniela y copiará los partidos de la quiniela oficial
						jugadas[indice1].generarApuestasAleatorias();	//llamará al metodo para generar apuestas aleatorias
						indice1++;
					} else{
						System.out.println("\n" + "Límite de quinielas alcanzado. Juega con responsabilidad" + "\n");
					}
				break;
	
				case 3:
					int abierta = indice1 - 1; // quinielas abiertas en este momento
					if(abierta==0){ // si no hay quinielas abiertas se muestra un mensaje por consola
						System.out.println("\n" + "No has ellenado ninguna quiniela aún" + "\n");
					} 
					
					else{
						System.out.print("\n" + "Elige la quiniela activa (0-" + (indice1-1) + ") ");
						Scanner sc3 = new Scanner(System.in);
						int activa = sc3.nextInt();
						System.out.println("Quiniela elegida " + activa);

						if(activa>0&&activa<indice1){ // DUDAAA DUDAAA DUDAAA
							Quiniela aux = new Quiniela(); //creamos una quiniela auxiliar para reservar los valores de una quiniela
							aux.copiarApuestas(jugadas[1]); //dentro de aux guardamos los valores de la jugada1
							jugadas[1].copiarApuestas(jugadas[activa]);	//ahora copiamos las apuestas de la jugada especificada por el usuario en la jugada1
							jugadas[activa].copiarApuestas(aux); //por ultimo reemplazamos las apuestas de la jugada especificada por el usuario y copiamos las apuestas de aux
						} else{
							System.out.println("Quiniela elegida incorrecta. Se activa la quiniela oficial");
						}
					}
				break;

				case 4:
					System.out.println("\n" + "Aciertos: " + jugadas[1].comprobarApuestas(jugadas[0]) + "\n"); //llama al metodo para comparar la quiniela de la jornada y la quiniela principal del usuario
				break;
	
				case 5:
					jugadas[0].mostrarPartidos();	//llama al metodo y muestra los partidos de la jornada
				break;

				case 6:
					jugadas[1].mostrarPartidosyApuestas();	//llama al metodo y muestra las apuestas y partidos de la quiniela principal del usuario
					System.out.println("");
				break;

				case 7:
					finPrograma = true;	//cambia el valor booleano y finalizará el bucle
				break;
				
				default:
					System.out.println("\n \n" + "Opcion no encontrada" + "\n");	//en caso de que el usuario indique una opcion fuera del rango, se le mostrará por un mensaje
				break;
			}
		}

		else{
			System.out.println("Opción no encontrada");
		}

	}while(!finPrograma);

	System.out.println("\n \n" + "Gracias por usar quinielas");
	System.out.println("\n" + "Aplicación terminada");
		
	} // Del main
	
} // De la clase Quiniela
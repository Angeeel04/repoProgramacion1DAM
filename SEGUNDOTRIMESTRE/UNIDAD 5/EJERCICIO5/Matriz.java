import java.util.Arrays;
public class Matriz{
	private int longitud = 0;
	private int [][] arreglo = new int [longitud][longitud]; 
	
	//GETTER's - SETTER's
	public int [][] getArreglo() {
		return arreglo;
	}

	public void setArreglo(int [][] arreglo) {
		this.arreglo = arreglo;
	}
	
	public int getLongitud(){
		return longitud;
	}
	
	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	
	//CONSTRUCTORES
	public Matriz() {
		this.longitud = 3;
		this.arreglo = new int[this.longitud][this.longitud];
	}
	
	public Matriz(int longitud) {
		this.longitud = longitud;
		this.arreglo = new int[this.longitud][this.longitud];
	}
	
	//METODOS
	public void asignarDatos(int [] vector){
		int raizCuadrada = (int) (Math.sqrt (vector.length));
		
		if(raizCuadrada*raizCuadrada == vector.length){
			this.setLongitud(raizCuadrada);
			int indice = 0;

			for(int a = 0; a < this.longitud; a++){
				for(int b = 0; b < this.longitud; b++){
					this.getArreglo()[a][b] = vector[indice]; //mmmmmm
					indice++;
				}
			}
		}

		else{
			System.out.println("NO es una matriz cuadrada");
		}
	}

	public void suma(Matriz m){
		int suma = 0;

		if(m.longitud == this.longitud){
			for(int a = 0; a<this.longitud; a++){
				for(int b = 0; b<this.longitud; b++){
					suma += m.getArreglo()[a][b] + this.getArreglo()[a][b];
				}
			}
			//System.out.println(suma);
		}

		else{
			System.out.println("NO tienen el mismo tamaño");
		}
	}

	public void traspuesta(){
		for(int a = 0; a<this.longitud;a++){
			for(int b=0; b<this.longitud;b++){
				if(a<b){
					int aux = this.getArreglo()[a][b];
					this.getArreglo()[a][b] = this.getArreglo()[b][a];
					this.getArreglo()[b][a] = aux;
				}
			}
		}

		this.mostrar();
	}

	public void mostrar(){
		for(int a = 0; a < this.longitud;a++){
			System.out.println(Arrays.toString(this.getArreglo()[a]));
		}
	}

	public int totalAgregado(){
		int suma = 0;

		for(int a = 0; a < this.longitud;a++){
			for(int b = 0; b < this.longitud; b++){
				suma = this.getArreglo()[a][b];
			}
		}

		return suma;
	}

	public int [] rellenaArray(){
		int [] array = new int[this.longitud * this.longitud];
		int indice = 0;

		for(int a = 0; a<this.longitud; a++){
			for(int b = 0; b<this.longitud;b++){
				array[indice] = this.getArreglo()[a][b];
				indice++;
			}
		}

		return array;
	}
	
	public boolean contiene(int numero){
		boolean resultado = false;
		for(int a = 0; a < this.longitud; a++){
			for(int b = 0; b < this.longitud; b++){
				if(numero == this.getArreglo()[a][b])
					resultado = true;
			}
		}
		return resultado;
	}

	public int valorFila(int numero){
		int suma = 0;

		if(0 < numero && numero<=this.longitud){
			numero = numero-1;
			for(int a = 0; a<this.longitud;a++){
				suma += this.getArreglo()[numero][a];
			}
		}

		return suma;
	}

	public int valorColumna(int numero){
		int suma = 0;

		if(0 < numero && numero <=this.longitud){
			numero = numero-1;
			for(int a = 0; a<this.longitud;a++){
				suma += this.getArreglo()[a][numero];
			}
		}

		return suma;
	}

	public void reemplazaColumna(int numero, int [] array){	
		if(0<numero && numero<=this.longitud){
			if(array.length == this.longitud){
				numero = numero - 1;
				int indice = 0;
				for(int a = 0; a<this.longitud;a++){
					for(int b = 0; b<this.longitud;b++){
						if(b==numero){
							this.getArreglo()[a][b] = array[indice];
							indice++;
						}
					}
				}
			} else{
				System.out.println("la longitud no es compatible");
			}
		} else{
			System.out.println("columna no encontrada");
		}

		this.mostrar();
	}

	//MAIN	
	public static void main(String [] args) {
		
		/*COMPROBACIONES

		//METODO1
		int [] vectorA = {1,2,3,4,5,6,7,8,9};
		Matriz dato = new Matriz();
		dato.asignarDatos(vectorA);
		for(int a = 0; a<dato.longitud;a++){
			System.out.println(Arrays.toString(dato.getArreglo()[a]));
		}

		//METODO2
		int [] vectorA = {1,2,3,4,5,6,7,8,9};
		int [] vectorB = {1,2,3,4,5,6,7,8,9};
		Matriz dato = new Matriz();
		Matriz datoB = new Matriz();
		
		dato.asignarDatos(vectorA);
		datoB.asignarDatos(vectorB);
		dato.suma(datoB);

		//METODO3
		Matriz dato = new Matriz();
		int [] vectorA = {1,2,3,4,5,6,7,8,9};
		dato.asignarDatos(vectorA);
		dato.traspuesta();

		//METODO5
		Matriz dato = new Matriz();
		int [] vectorA = {1,2,3,4,5,6,7,8,9};
		dato.asignarDatos(vectorA);
		dato.totalAgregado();

		//METODO6
		Matriz dato = new Matriz();
		int [] vectorA = {1,2,3,4,5,6,7,8,9};
		dato.asignarDatos(vectorA);
		System.out.println(Arrays.toString(dato.rellenaArray()));

		//METODO7
		Matriz dato = new Matriz();
		int [] vectorA = {1,2,3,4,5,6,7,8,9};
		dato.asignarDatos(vectorA);
		System.out.println(dato.contiene(10));

		//METODO8
		Matriz dato = new Matriz();
		int [] vectorA = {1,2,3,4,5,6,7,8,9};
		dato.asignarDatos(vectorA);
		System.out.println(dato.contiene(10));

		//METODO9-10
		Matriz dato = new Matriz();
		int [] vectorA = {1,2,3,4,5,6,7,8,9};
		dato.asignarDatos(vectorA);
		System.out.println(dato.valorFila(3));

		//METODO11
		Matriz dato = new Matriz();
		int [] vectorA = {1,2,3,4,5,6,7,8,9};
		int [] vectorB = {1,2,3,3};

		dato.asignarDatos(vectorA);
		dato.reemplazaColumna(3,vectorB);

		*/
		
	}
}
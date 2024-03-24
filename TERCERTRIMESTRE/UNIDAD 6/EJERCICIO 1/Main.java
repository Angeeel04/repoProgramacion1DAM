public class Main {
	public static void main(String[] args) {
		//Creando objetos de la clase vivienda, chalet y palacio
		Vivienda vivienda1 = new Vivienda(100, "calle vivienda1", 5);
		Vivienda vivienda2 = new Vivienda(90, "calle vivienda2", 10);
		Vivienda vivienda3 = new Vivienda();

		Chalet chalet1 = new Chalet(200, "calle chalet1", 4, false);
		Chalet chalet2 = new Chalet(80, "calle chalet2", 2, true);
		Chalet chalet3 = new Chalet();
		
		Palacio palacio1 = new Palacio(300, "calle palacio1", 6, 9);
		Palacio palacio2 = new Palacio(70, "calle palacio2", 7, 5);
		Palacio palacio3 = new Palacio();

		Vivienda [] arrayObjetos = new Vivienda [] {vivienda1, vivienda2, vivienda3, chalet1, chalet2, chalet3, palacio1, palacio2, palacio3};
		
		for(int i=0;i<arrayObjetos.length;i++) {
			System.out.println(arrayObjetos[i].toString());
			System.out.println("");
		}
	}
}
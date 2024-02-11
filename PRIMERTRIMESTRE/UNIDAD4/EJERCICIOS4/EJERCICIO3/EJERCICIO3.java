class EJERCICIO3 {
  public static void main(String[] args) {
    String borrasca = "Filomena";
    char [] caracteres = new char[borrasca.length()];

    for(int i = 0; i < borrasca.length(); i++){
      char letra = borrasca.charAt(i);
      caracteres[i] = letra;
    }

    //Comprobamos que el array tiene los elementos correctos
    
    //for(int j = 0; j < caracteres.length; j++){
    //  System.out.println(caracteres[j]);
    //}

  }
}
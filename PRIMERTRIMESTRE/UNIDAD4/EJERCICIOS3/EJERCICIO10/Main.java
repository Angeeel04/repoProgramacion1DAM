class Main {
  public static void main(String[] args) {
    char [] caracteres = {'P','a','l','a','b','r','a'};
    String frase = "";

    for(int i = 0; i < caracteres.length; i++){
      char letra = caracteres[i];
      frase = frase + letra;
    }

    System.out.println(frase);

  }
}
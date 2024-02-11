public class Main{
/*Define una función que tome dos int y realice la potencia del primer int elevado al
segundo parámetro. Debe devolver ese resultado. Recuerda que tanto la base como el
exponente pueden ser positivos o negativos y eso afecta a los resultados obtenidos.*/
  
  public static void main(String[] args) {
    int num1 = -2, num2 = 3;
    System.out.println(potencia(num1, num2));
  }
      
  public static float potencia(int base, int exponente){
    float resultado = 1.00f;

    if(base > 0 || base < 0) { //base es positiva

      if(exponente > 0){ //exponente es positivo
        for(int a = exponente; a > 0; a--)
          resultado *= base;
      }

      else if(exponente == 0){  //exponente es 0
        resultado = 1.00f;
      }

      else{ //exponente es negativo
        for(int a = exponente; a < 0; a++)
          resultado /= base;
      }
    }

    else{
      resultado = 0.00f;
    }

    return resultado;
  }
}
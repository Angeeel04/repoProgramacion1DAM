class Intervalo{
    double minimo;    
    double maximo;

    //CONSTRUCTORES
    public Intervalo(){
        minimo = 0.0;
        maximo = 0.0;
    }

    public Intervalo (double num1, double num2){
        minimo = num1;
        maximo = num2;
    }

    public Intervalo (double num1){
        maximo = num1;
        minimo = 0.0;
    }

    public Intervalo (Intervalo rango){
        minimo = rango.getMinimo(); //this.minimo = minimo
        maximo = rango.getMaximo(); // this.maximo = maximo
    }

    //GETTER's y SETTER's
    public void setMinimo(double dato){
        minimo = dato;
    }

    public void setMaximo(double dato){
        maximo = dato;
    }

    public double getMinimo(){
        return minimo;
    }

    public double getMaximo(){
        return maximo;
    }

    //METODOS
    public boolean valido(){
        return (minimo <= maximo);
    }

    public double longitud(){
        return (maximo - minimo);
    }

    public double puntoMedio(){
        return ((maximo + 1) / 2);
    }

    public void desplazar(double dato){
        minimo += dato;
        maximo += dato;
    }

    /*public Intervalo copia(Intervalo dato){
        return ;
    }*/

    public boolean iguales(Intervalo dato){
        return (this.maximo == dato.getMaximo() && this.minimo == dato.getMinimo());
    }

    public boolean incluye(double dato){
        return (this.maximo >= dato && dato >= this.minimo);
    }

    public boolean incluye(Intervalo dato){
        return(this.maximo > dato.getMaximo() && dato.getMinimo() > this.minimo);
    }

    public Intervalo [] troceado(int tamaño){
        Intervalo [] array = new Intervalo[tamaño];
        double numero = this.minimo;
        double numeroAumentado = 0;

        for(int a = 0; a < tamaño; a++){
            if(numeroAumentado < maximo){
                numeroAumentado = numero + tamaño;
                Intervalo range = new Intervalo (numero, numeroAumentado);
                array[a] = range;
                numero = numeroAumentado;
            }
        }

        return array;
    }

    public void escalar(double dato){
        double longitud = maximo - minimo;
        double multiplicador = dato * longitud;
        maximo *= multiplicador;
        minimo *= multiplicador;
    }

    public Intervalo desplazado(double dato){
        Intervalo nuevo = new Intervalo((maximo+dato), (minimo + dato));
        return nuevo;
    }

    public Intervalo interseccion(Intervalo dato){
        Intervalo resultado = new Intervalo(0.0, 0.0);

        if(this.maximo>dato.minimo && this.maximo<dato.maximo){
            resultado = new Intervalo(0.0, 0.0);
            resultado.setMinimo(dato.minimo);
            resultado.setMaximo(this.maximo);
        }

        else if(this.minimo<dato.maximo && dato.maximo<this.maximo){
            resultado.setMinimo(this.minimo);
            resultado.setMaximo(dato.maximo);
        }

        return resultado;
    }

    public Intervalo simetrico(Intervalo dato){
        Intervalo resultado = new Intervalo(0, 0);
        double diferencia = dato.maximo - dato.minimo;
        resultado.setMinimo(minimo-diferencia);
        resultado.setMaximo(maximo-diferencia);

        return resultado;
    }
}
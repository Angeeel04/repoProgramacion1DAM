public class Asignatura {
    public String nomAsig;
    public int precio;

    //GETTERS Y SETTERS
    public String getNomAsig(){
        return nomAsig;
    }
    public void setNomAsig(String nomAsig){
        this.nomAsig = nomAsig;
    }

    public int getPrecio(){
        return precio;
    }
    public void setPrecio(int precio){
        this.precio = precio;
    }

    //CONSTRUCTORES
    public Asignatura(String nomAsig, int precio){
        this.nomAsig = nomAsig;
        this.precio = precio;
    }
}

package EJERCICIO_REPRODUCTORMUSICA;
import java.util.concurrent.TimeUnit;
/*HECHO POR ANGEL CAHVEZ 1º DAM*/

public class Cancion {
    protected String titulo;
    protected String genero;
    protected String autor;
    protected int codIdentificacion;
    protected int duracionSeg;

    public Cancion(String titulo, String autor, String genero, int codIdentificacion, int duracionSeg) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.codIdentificacion = codIdentificacion;
        this.duracionSeg = duracionSeg;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getCodIdentificacion() {
        return codIdentificacion;
    }
    public void setCodIdentificacion(int codIdentificacion) {
        this.codIdentificacion = codIdentificacion;
    }
    public int getDuracionSeg() {
        return duracionSeg;
    }
    public void setDuracionSeg(int duracionSeg) {
        this.duracionSeg = duracionSeg;
    }

    public void Reproducir(){
        try {
            TimeUnit.SECONDS.sleep(duracionSeg);
        }catch(Exception e) {
            System.out.println("Error en la reproducción:" + e);
        }
    }
    
    @Override
    public String toString() {
    	return "Sonando: \n" + "\t \t" + titulo.toUpperCase() + "\n" + autor;
    }
}
public class Alumno {
    final int CANTASIG = 5;
    public int dni;
    public String nombre;
    public String curso;
    public String codigoAlumno;
    public Asignatura [] asignaturas = new Asignatura[CANTASIG];
    int aux = 0;
    
    //GETTERS Y SETTERS
    public int getDni(){
        return dni;
    }
    public void setDni(int dni){
        this.dni = dni;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getCurso(){
        return curso;
    }
    public void setCurso(String curso){
        this.curso = curso;
    }

    public String getCodigoAlumno(){
        return curso;
    }
    public void getCodigoAlumno(String CodigoAlumno){
        this.codigoAlumno = CodigoAlumno;
    }

    public Asignatura [] getAsignaturas(){
        return asignaturas;
    }
    public void setAsignaturas(Asignatura [] asignaturas){
        this.asignaturas = asignaturas;
    }

    //CONSTRUCTORES
    public Alumno(){}

    public Alumno(int dni, String nombre, String curso, String codigoAlumno, Asignatura [] asignaturas, int cantAsignaturas){
        this.dni = dni;
        this.nombre = nombre;
        this.curso = curso;
        this.codigoAlumno = codigoAlumno;
        this.asignaturas = asignaturas;
    }

    public Alumno(int dni, String nombre, String curso, String codigoAlumno){
        this.dni = dni;
        this.nombre = nombre;
        this.curso = curso;
        this.codigoAlumno = codigoAlumno;
    }

    //METODOS
    public void matricularDe(Asignatura asig){
        boolean matriculado = false;
        for(int a=0; a<aux;a++){
            if(asig.nomAsig == asignaturas[a].nomAsig){
                matriculado = true;
            }
        }
        if(aux<CANTASIG){
            if(matriculado == false){
                asignaturas[aux] = asig;
                aux++;
                System.out.println(this.nombre + " matriculado de: " + asig.nomAsig);
            }else{
                System.out.println(this.nombre + " ya está matriculado de " + asig.nomAsig + ". Matrícula no realizada");
            }
        } else{
            System.out.println("Límite de asignaturas alcanzado para " + this.nombre + ". Matricula de " + asig.nomAsig + " no realizada");
        }
    }

    public void eliminarMatriculaDe(Asignatura asig){
        boolean existe = false;
        for(int a=0; a<asignaturas.length;a++){
            if(asignaturas[a].nomAsig==asig.nomAsig){
                existe = true;
            }
            if(existe==true){
                asignaturas[a] = null;
                System.out.println(this.nombre + " anulada matrícula de " + asig.nomAsig);
            }
        }
    }

    public String verListadoAsignaturas(){
        String cadena = "";
        for(int a=0; a<asignaturas.length; a++){
            if(asignaturas[a]!=null){
                cadena += asignaturas[a].nomAsig;
            }

            cadena += " ";
        }
        return cadena;
    }

    public int verImporteTotal(){
        int resultado = 0;
        for(int a=0; a<asignaturas.length; a++){
            if(asignaturas[a]!=null){
                resultado += asignaturas[a].precio;
            }
        }
        return resultado;
    }

    @Override
    public String toString(){
        String cadena = "";
        System.out.println("Datos del alumno: ");
        System.out.println("Nombre\t: " + nombre);
        System.out.println("DNI\t: " + dni);
        System.out.println("Curso\t: " + curso);
        System.out.println("Código alumno\t: " + codigoAlumno);
        System.out.println("Datos de matrícula\t: " + this.verListadoAsignaturas());
        System.out.println("Numero de asignaturas\t: " + asignaturas.length);
        System.out.println("Importe total\t: " + this.verImporteTotal());
        return cadena;
    }
}
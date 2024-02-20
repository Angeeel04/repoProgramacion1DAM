class PrincipalMatriculaUniversidad {
    public static void main(String[] args) {
        Alumno estudiante = new Alumno(111111,"Paco", "1º DAM", "B-15");
        Asignatura asig1 = new Asignatura("LM", 100);
        Asignatura asig2 = new Asignatura("BBDD", 100);
        Asignatura asig3 = new Asignatura("FOL", 100);
        Asignatura asig4 = new Asignatura("PROG", 100);
        Asignatura asig5 = new Asignatura("SI", 100);

        estudiante.matricularDe(asig1);
        estudiante.matricularDe(asig2);
        estudiante.matricularDe(asig3);
        estudiante.matricularDe(asig4);
        estudiante.matricularDe(asig5);
    
        estudiante.toString();
    }
}

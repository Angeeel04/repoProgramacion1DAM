package empleadosYHtml;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
/*HECHO POR ANGEL CHAVEZ 1º DAM*/

public class Main {
    public static void main(String[] args) {
        metodosRelacionadosConArchivo();
        System.out.println("\nPrograma finalizado.");
    }

    public static void metodosRelacionadosConArchivo() {
        String ruta = retornaRuta();
        String contenidoRuta = retornaContenidoArchivo(ruta);
        ArrayList<String> almacenarData = almacenarLineasConDatos(contenidoRuta);
        ArrayList<Empleado> listaEmpleados = generarListaEmpleados(almacenarData);
        if (listaEmpleados.size() > 0) {
            ArrayList<Empleado> listaFinalEmpleados = seleccionDeEmpleados(listaEmpleados);
            generarHtml(listaFinalEmpleados);
            mostrarEmpleados(listaEmpleados);
        }
    }

    public static String retornaRuta() {
        Scanner sc = new Scanner(System.in);
        String rutaArchivo = "";
        System.out.println("Introduce la ruta completa del archivo a leer.\n" +
                "Ejemplo: C:/Pruebas/ArchivoEmpleados.dat\n");
        boolean verificada = false;

        try {
            System.out.print("Ruta: ");
            rutaArchivo = sc.nextLine();
            verificada = verificaRuta(rutaArchivo);
        } catch (RouteInvalidFormatException e) {
            System.out.println("\nLa ruta del archivo es inválida");
            verificada = false;
        } finally {
            if (!verificada) {
                rutaArchivo = "";
            } else {
                rutaArchivo = rutaArchivo.replace('/', '\\');
            }
        }

        return rutaArchivo;
    }

    public static boolean verificaRuta(String rutaArchivo) throws RouteInvalidFormatException {
        boolean rutaAceptada = true;
        int indx = 0;

        if (rutaArchivo.length() <= 1) {
            rutaAceptada = false;
            throw new RouteInvalidFormatException();
        } else {
            if (rutaArchivo.substring(1, 3).equals(":/")) {
                while (rutaAceptada && indx < rutaArchivo.length()) {
                    char caracterRuta = rutaArchivo.charAt(indx);
                    if (indx == 0 && (caracterRuta < 65 || caracterRuta > 90)) {
                        rutaAceptada = false;
                        throw new RouteInvalidFormatException();
                    } else if (caracterRuta == '?' || caracterRuta == '¿' || caracterRuta == '<' ||
                            caracterRuta == '>' || caracterRuta == '|' || caracterRuta == 92) {
                        rutaAceptada = false;
                        throw new RouteInvalidFormatException();
                    }
                    indx++;
                }
            } else {
                rutaAceptada = false;
                throw new RouteInvalidFormatException();
            }
        }
        return rutaAceptada;
    }

    public static String retornaContenidoArchivo(String ruta) {
        String contenidoArchivo = "";
        if (!ruta.isEmpty()) {
            File archivo = new File(ruta);
            if (archivo.exists()) {
                try {
                    FileReader lector = new FileReader(archivo);
                    BufferedReader bufReader = new BufferedReader(lector);
                    String linea = "";
                    boolean fin = false;
                    do {
                        linea = bufReader.readLine();
                        if (linea != null) {
                            contenidoArchivo += linea + "\n";
                        } else {
                            fin = true;
                        }
                    } while (!fin);
                    bufReader.close();

                } catch (FileNotFoundException e) {
                    System.out.println("\nERROR: No se ha encontrado un archivo con esa ruta");
                } catch (IOException e) {
                    System.out.println("\nERROR: Ha ocurrido un error mientras el fichero se estaba leyendo");
                }

            } else {
                System.out.println("\nERROR: El archivo no existe.");
            }
        }

        return contenidoArchivo;
    }

    public static ArrayList<String> almacenarLineasConDatos(String contenidoArchivo) {
        String[] lineas = contenidoArchivo.split("\n");
        ArrayList<String> lineasLimpias = new ArrayList<>();

        for (String linea : lineas) {
            linea = linea.trim();
            if (!linea.isEmpty() && !linea.startsWith("#")) {
                lineasLimpias.add(linea);
            }
        }
        return lineasLimpias;
    }

    public static ArrayList<Empleado> generarListaEmpleados(ArrayList<String> lineasLimpias) {
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        for (int a = 0; a < lineasLimpias.size(); a += 2) {
            String linea1 = lineasLimpias.get(a);
            String linea2 = lineasLimpias.get(a + 1);
            String[] datosEmpleadoPrimPt = linea1.split("#");
            String[] datosEmpleadoSegPt = linea2.split("#");
            String dni = datosEmpleadoPrimPt[0];
            String nombre = datosEmpleadoPrimPt[1];
            String apellido = datosEmpleadoPrimPt[2];
            String anyonac = datosEmpleadoPrimPt[3];
            int fijo = Integer.parseInt(datosEmpleadoSegPt[0]);
            int factura = Integer.parseInt(datosEmpleadoSegPt[1]);
            double percent = Double.parseDouble(datosEmpleadoSegPt[2]);
            Empleado nuevoEmpleado = new Empleado(dni, nombre, apellido, anyonac, fijo, factura, percent);
            empleados.add(nuevoEmpleado);
        }
        return empleados;
    }

    public static void mostrarEmpleados(ArrayList<Empleado> listaEmpleados) {
        System.out.println("\n\nLISTA DE EMPLEADOS:");
        for (Empleado empleadoAux : listaEmpleados) {
            System.out.println(empleadoAux.toString());
        }
    }

    public static int pideCantFacturacion() {
        boolean valorAceptado = false;
        int cantUsuario = 0;
        do {
            System.out.println("\nEstablece la cantidad de facturación a mostrar\n" +
                    "Ejemplo: 1500\n");
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Cantidad: ");
                cantUsuario = sc.nextInt();
                if (cantUsuario > 0) {
                    valorAceptado = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("\nSolo números enteros porfavor. Intentelo otra vez.");
            }
        } while (!valorAceptado);

        return cantUsuario;
    }

    public static ArrayList<Empleado> seleccionDeEmpleados(ArrayList<Empleado> listaEmpleados) {
        ArrayList<Empleado> empleadosSeleccionados = new ArrayList<Empleado>();
        int cantUsuario = pideCantFacturacion();

        for (Empleado empAux : listaEmpleados) {
            if (empAux.getFactura() > cantUsuario) {
                empleadosSeleccionados.add(empAux);
            }
        }

        Collections.sort(empleadosSeleccionados, new CompararEmpleado());
        return empleadosSeleccionados;
    }

    public static String generarFilas(ArrayList<Empleado> empleadosSeleccionados) {
        String filasTotales = "";
        for (Empleado empAux : empleadosSeleccionados) {
            String filas = "\t<tr>\n" +
                    "\t\t<td>" + empAux.getDni() + "</td>\n" +
                    "\t\t<td>" + empAux.getNombre() + "</td>\n" +
                    "\t\t<td>" + empAux.getApe1() + "</td>\n" +
                    "\t\t<td>" + empAux.getFactura() + "</td>\n" +
                    "\t</tr>\n";

            filasTotales += filas;
        }
        return filasTotales;
    }

    public static String tablaGenerada(ArrayList<Empleado> listaFinalEmpleados) {
        String estructuraPtUno = "<table>\n" +
                "\t<tr>\n" +
                "\t\t<th>DNI</th>\n" +
                "\t\t<th>Nombre</th>\n" +
                "\t\t<th>Apellido</th>\n" +
                "\t\t<th>Facturacion</th>\n" +
                "\t</tr>\n";
        String estructuraPtDos = generarFilas(listaFinalEmpleados);
        String estructuraPtTres = "</table>\n";
        String estructuraPtCuatro = "<div style=\"margin-left: 22.5em;\">" +"<b>" + "TOTAL DE EMPLEADOS EN TABLA " + listaFinalEmpleados.size() + "</b>" + "</div>";
        String contenido = estructuraPtUno + estructuraPtDos + estructuraPtTres + estructuraPtCuatro;
        return contenido;
    }

    public static void generarHtml(ArrayList<Empleado> listaFinalEmpleados) {
        String estructuraPtUno = "<!DOCTYPE html>\n" +
                "<html lang=\"es\">\n";

        String estructuraPtDos = "<head>\n" +
                "\t<meta charset=\"UTF-8\">\n" +
                "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "\t<title>AngelChavezEmp</title>\n" +
                "</head>\n";

        String estructuraPtTres = "<body>\n" +
                tablaGenerada(listaFinalEmpleados) + "\n" +
                "</body>\n" +
                "</html>";

        String estructuraCompleta = estructuraPtUno + estructuraPtDos + estructuraPtTres;

        try {
            File nuevoArchivo = new File("D:\\Pruebas\\AngelChavezEmp.html");
            FileWriter escritor = new FileWriter(nuevoArchivo);
            BufferedWriter bufWriter = new BufferedWriter(escritor);
            bufWriter.write(estructuraCompleta);
            bufWriter.close();
        } catch (NullPointerException e) {
            System.out.println("No se ha podido crear el archivo HTML");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error con el archivo HTML");
        }
    }
}
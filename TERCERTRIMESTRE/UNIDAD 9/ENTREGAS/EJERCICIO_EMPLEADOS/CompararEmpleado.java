package empleadosYHtml;
import java.util.Comparator;
/*HECHO POR ANGEL CHAVEZ 1º DAM*/

public class CompararEmpleado implements Comparator<Empleado>{
    @Override
    public int compare(Empleado emp1, Empleado emp2){
        if(emp1.getFactura()<emp2.getFactura()){
            return -1;
        }else if(emp1.getFactura()>emp2.getFactura()){
            return 0;
        }else{
            return 1;
        }
    }
}

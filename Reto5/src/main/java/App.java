import java.sql.Connection;
import java.sql.SQLException;
import util.JDBCUtilities;
import view.VistaRequerimientosReto4;
import Controler.ControladorRequerimientosReto4;

/**
 * Aplicacion Proyectos construccion
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Casos de prueba 

        // //Requerimiento 1 - Reto3
        // VistaRequerimientosReto4.requerimiento1();
        // System.out.println();

        // //Requerimiento 3 - Reto3
        // VistaRequerimientosReto4.requerimiento3();
        // System.out.println();

        // // //Requerimiento 5 - Reto3
        // VistaRequerimientosReto4.requerimiento5();
        // System.out.println();        

        //iniciamos aplicacion
        ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();
        controlador.iniciaraplicacion();
    }
}

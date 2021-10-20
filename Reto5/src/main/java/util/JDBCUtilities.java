package util;
//librerias para conexxion a bases de datos
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.io.File;//libreria para manejo archivos

public class JDBCUtilities {
    //Ubicacion de la base de datos que usaremos en este SW
    private static final String Ubicacion_BD = "ProyectosConstruccion.db"; //ruta absoluta

    //metodo para proveer conexion
    public static Connection getConnection() throws SQLException{
        String url = "jdbc:sqlite:" + JDBCUtilities.Ubicacion_BD;
        return  DriverManager.getConnection(url);
    }

    //metodo complementario--> sqlite si no existe la base de dato, la crea(vacia)
    public static boolean estaVacia(){
        File archivo = new File(JDBCUtilities.Ubicacion_BD);
        return archivo.length() ==0;
    }
}

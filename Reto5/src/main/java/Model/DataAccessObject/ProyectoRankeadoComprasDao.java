package Model.DataAccessObject;

import Model.ValueObject.*;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import util.JDBCUtilities;


public class ProyectoRankeadoComprasDao {
    //Obtener los 10 proyectos rankeados según las compras
    public ArrayList<ProyectoRankeadoCompras> rankingProyectosComprasDescendente10() throws SQLException {

        ArrayList<ProyectoRankeadoCompras> respuesta = new ArrayList<ProyectoRankeadoCompras>() ;
        Connection conexion = null;

        try {
            conexion = JDBCUtilities.getConnection();

            String consulta = "SELECT Compra.ID_Proyecto, Proyecto.Clasificacion, SUM(Compra.Cantidad * MaterialConstruccion.Precio_Unidad) AS  Gasto_compras, Proyecto.Serial "+
                
                "FROM Compra JOIN MaterialConstruccion ON Compra.ID_MaterialConstruccion = MaterialConstruccion.ID_MaterialConstruccion JOIN Proyecto ON Proyecto.ID_Proyecto = Compra.ID_Proyecto "+
                "GROUP BY Compra.ID_Proyecto "+
                "ORDER BY Gasto_compras DESC "+
                "LIMIT 10";

            PreparedStatement statement = conexion.prepareStatement(consulta);
            
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ProyectoRankeadoCompras proyecto = new ProyectoRankeadoCompras();
                //asignamos los valores de la consulta a nuestro ValueObject
                proyecto.setIdProyecto(resultSet.getInt("Id_Proyecto"));

                proyecto.setClasificacion(resultSet.getString("Clasificacion"));

                proyecto.setGastoCompra(resultSet.getInt("Gasto_compras"));

                proyecto.setSerial(resultSet.getString("Serial"));

                respuesta.add(proyecto);

            }
            resultSet.close();
            statement.close();


            
        } catch (SQLException e) {
            System.err.println("Error consultando los proyectos rankeados por compras" + e);
        }finally{
            //cierre del controlador
            if (conexion != null) {
                conexion.close();  
            }
        }
        // retornamos la coleccion de VO's obtenido de la BD
        return respuesta;
    } 

}

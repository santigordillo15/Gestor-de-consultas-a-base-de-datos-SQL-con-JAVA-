package Model.DataAccessObject;
import Model.ValueObject.*;
import java.util.ArrayList;
import util.JDBCUtilities;
import java.sql.SQLException;
import java.sql.Connection;

//clase para construir objetos de consultas (query)
import java.sql.PreparedStatement;
//clase para manejar la respuesta de la BD--> contenedor(iterador)
import java.sql.ResultSet;

public class BancoRankeadoAreaPromedioDao {

    //consultar los bancos rankeados por area promedio de los proyectos que financia
    public ArrayList<BancoRankeadoAreaPromedio> rankingBancosAreaPromedioDescendente() throws SQLException {
        //contenedor de la respuesta -->coleccion banco
        ArrayList<BancoRankeadoAreaPromedio> respuesta = new ArrayList<BancoRankeadoAreaPromedio>();
        Connection conexion = null;

        try {
            conexion = JDBCUtilities.getConnection();
            //hacemos nuestra sentencia SQL
            String consulta = "SELECT  p.Banco_Vinculado,"+
                                        "AVG(t.Area_Max) as Area_Promedio "+
                                "FROM Proyecto p "+
                                "JOIN Tipo t ON "+
                                    "p.ID_Tipo = t.ID_Tipo "+
                                "GROUP BY p.Banco_Vinculado "+
                                "ORDER BY Area_Promedio DESC";

            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultset = statement.executeQuery();

            //moviendo apuntador por cada registro
            while(resultset.next()){
                //cargar el registro actual en un Value Object
                BancoRankeadoAreaPromedio banco = new BancoRankeadoAreaPromedio();
                banco.setAreaPromedio(resultset.getDouble("Area_Promedio"));

                banco.setBancoVinculado(resultset.getString("Banco_Vinculado"));

                respuesta.add(banco);

            }
            resultset.close();
            statement.close();

        } catch (SQLException e){
            
            System.err.println("Error al consultar bancos rankeados"+ e);
        }finally{
            if (conexion != null) {
                conexion.close();
                
            }

        }
        // retornamos la coleccion de VO's obtenido de la BD
        return respuesta;
    }
}

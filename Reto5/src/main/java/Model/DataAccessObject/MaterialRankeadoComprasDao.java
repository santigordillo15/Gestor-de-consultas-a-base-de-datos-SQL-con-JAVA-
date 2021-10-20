package Model.DataAccessObject;
import Model.ValueObject.*;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import util.JDBCUtilities;

public class MaterialRankeadoComprasDao {
    //Obtener los importados más comprados
    public ArrayList<MaterialRankeadoCompras> rankingMaterialesComprasDescendente() throws SQLException {
        ArrayList<MaterialRankeadoCompras> resultado = new ArrayList<MaterialRankeadoCompras>();
        Connection conexion = null;

        try {
            
            conexion = JDBCUtilities.getConnection();
            String consulta = "SELECT MaterialConstruccion.Nombre_Material, MaterialConstruccion.Importado, "+ 
            "COUNT(*)AS  No_Compras "+
                "FROM MaterialConstruccion JOIN Compra ON "+
                "MaterialConstruccion.ID_MaterialConstruccion = Compra.ID_MaterialConstruccion "+
                "WHERE MaterialConstruccion.Importado LIKE '%S%' "+
                "GROUP BY MaterialConstruccion.Nombre_Material "+
                "ORDER BY No_Compras DESC, MaterialConstruccion.Nombre_Material;";
            PreparedStatement consultaSql = conexion.prepareStatement(consulta);
            ResultSet resultSet = consultaSql.executeQuery();

            while (resultSet.next()) {
                MaterialRankeadoCompras material = new MaterialRankeadoCompras();
                material.setNombre_Material(resultSet.getString(1)); //obtenemos de la columna 1 el valor del resultado de la consulta y se lo asignamos al Value object
                material.setImportado(resultSet.getString("Importado"));
                material.setNo_Compras(resultSet.getInt("No_Compras"));

                resultado.add(material);

            }
            resultSet.close();
            consultaSql.close();
            
        } catch (SQLException e) {
            System.err.println("Error consultando los materiales rankeados" + e);
            
        }finally{
            //cierre del controlador
            if (conexion != null) {
                conexion.close();  
            }
        }
        // retornamos la coleccion de VO's obtenido de la BD
        return resultado;
    }


}

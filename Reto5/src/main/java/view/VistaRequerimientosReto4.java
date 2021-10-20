package view;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.ValueObject.*;
import Controler.ControladorRequerimientosReto4;

public class VistaRequerimientosReto4 {

    //atributos-->controlador
    public static final  ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();

    //Menu Pincipal de los lideres
    public static void requerimiento1(){

        System.out.println("-----10 Proyectos Mayor Gasto-------");       

        try{

            ArrayList<ProyectoRankeadoCompras>rankingProyectosCompras = controlador.consultarProyectosCompras10();

            //Encabezado del resultado
            System.out.println("ID_Proyecto Clasificación Gasto_Compras Serial");

            for (ProyectoRankeadoCompras proyecto : rankingProyectosCompras) {
                System.out.printf("%d %s %d %s %n", 
                proyecto.getIdProyecto(),
                proyecto.getClasificacion(),
                proyecto.getGastoCompra(),
                proyecto.getSerial());   
            }

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }

    }
    
    //bancos rankeados segun area promedio de los proyectos que financia
    
    public static void requerimiento3(){
        System.out.println("-----Ranking Descendente Bancos (Área Proyectos)-------");
        try{

            ArrayList<BancoRankeadoAreaPromedio> rankingBancosArea = controlador.consultarBancosRankeadosAreaPromedio();
            System.out.println("Banco_Vinculado Area_Promedio");
            for(BancoRankeadoAreaPromedio banco : rankingBancosArea ){
                System.out.printf("%s %f %n",
                    banco.getBancoVinculado(),
                    banco.getAreaPromedio()
                    
                );
            }            

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }

    }

    public static void requerimiento5(){

        System.out.println("-----Ranking Descendente Materiales Importados (Compras)-------");       

        try{

            ArrayList<MaterialRankeadoCompras> rankingMaterialesImportados = controlador.consultarMaterialesRankeadosCompras();

            //Encabezado del resultado
            System.out.println("Nombre_Material Importado No_Compras");
            for (MaterialRankeadoCompras material : rankingMaterialesImportados) {
                System.out.printf("%s %s %d %n",
                    material.getNombre_Material(),
                    material.isImportado(),
                    material.getNo_Compras()
                    
                );
                
            }
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }

    }
    
}

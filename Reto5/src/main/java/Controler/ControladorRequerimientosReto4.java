package Controler;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;

//view
import view.menuprincipalConInterfazGrafica;
import view.Req1ConInterfazGrafica;
import view.Req2ConInterfazGrafica;
import view.Req3ConInterfazGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//model
import Model.ValueObject.*;
import Model.DataAccessObject.*;



public class ControladorRequerimientosReto4 implements ActionListener {

    //alojar objetos de clases del modelo
    private final BancoRankeadoAreaPromedioDao bancoDao;

    private final ProyectoRankeadoComprasDao ComprasDao;

    private final MaterialRankeadoComprasDao materialDao;
    //alojar objetos de la vista
    private final menuprincipalConInterfazGrafica menuPrincipalGUI;
    private Req1ConInterfazGrafica Req1_GUI;
    private Req2ConInterfazGrafica Req2_GUI;
    private Req3ConInterfazGrafica Req3_GUI;



    //constructor
    public ControladorRequerimientosReto4(){
        this.ComprasDao = new ProyectoRankeadoComprasDao();
        
        this.bancoDao = new BancoRankeadoAreaPromedioDao();

        this.materialDao = new MaterialRankeadoComprasDao();

        //instanciamos la interfaces
        this.menuPrincipalGUI = new menuprincipalConInterfazGrafica();        
    }



    //cada requerimiento solicitado --> cada caso de uso
    
    //req 1.--> listar los 10 proyectos que mas compras hizo
    public ArrayList<ProyectoRankeadoCompras>consultarProyectosCompras10() throws SQLException{
        return this.ComprasDao.rankingProyectosComprasDescendente10();
    }

    // req 3. --> listar todos los bancos rankeados por el area promedio de los proyectos que financian
    public ArrayList<BancoRankeadoAreaPromedio> consultarBancosRankeadosAreaPromedio() throws SQLException{
        return this.bancoDao.rankingBancosAreaPromedioDescendente();
    }

    //req 5 --> listar los materiales mas comprados
    public ArrayList<MaterialRankeadoCompras> consultarMaterialesRankeadosCompras() throws SQLException {
        return this.materialDao.rankingMaterialesComprasDescendente();
    }
    


    //controlador iniciando la aplicacion
    public void iniciaraplicacion(){
        this.menuPrincipalGUI.iniciarGUI(this);
    }

    //esto siempre se debe generar, para que cuando de clic en algun boton de la vista se comunique con el controlador y haya un cambio de estado
    @Override
    public void actionPerformed(ActionEvent e) {
        // actionlistener
        //obtener el evento asociado al boton
        String actionCommand = ((JButton)e.getSource()).getActionCommand();

        switch (actionCommand) {
            case "rankingProyectos":
            
                try {

                    this.Req1_GUI = new Req1ConInterfazGrafica(this.ComprasDao.rankingProyectosComprasDescendente10(), this);
                    
                } catch (SQLException eProyecto) {
                    System.err.println("error cargando req1 GUI"+eProyecto);
                    
                }
            break;

            case "rankingBancos":
                try {
                    this.Req2_GUI = new Req2ConInterfazGrafica(this.bancoDao.rankingBancosAreaPromedioDescendente(), this);
                    
                } catch (Exception eBancos) {
                    System.err.println("error cargando req2 GUI"+eBancos);
                }    


            break;
            case "rankingMaterialesImportados":
                try {
                    this.Req3_GUI = new Req3ConInterfazGrafica(this.materialDao.rankingMaterialesComprasDescendente(), this);
                    
                } catch (Exception eMaterial) {
                    System.err.println("error cargando req3 GUI"+eMaterial);
                }    

            break;  
        }
        
    }
}

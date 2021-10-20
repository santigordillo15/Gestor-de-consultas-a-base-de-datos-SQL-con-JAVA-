package view;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.GridLayout;

import Controler.ControladorRequerimientosReto4;
import Model.ValueObject.BancoRankeadoAreaPromedio;
import Model.ValueObject.ProyectoRankeadoCompras;
import java.util.ArrayList;

public class Req2ConInterfazGrafica extends JFrame {
    //atributos, definimos los componentes
    private JTable jtProyectos;

    //constructor inicial
    public Req2ConInterfazGrafica(ArrayList<BancoRankeadoAreaPromedio> bancos,ControladorRequerimientosReto4 controlador){

        //propiedades del frame
        super.setTitle("Req. 2 ---- Bancos ordenados de mayor a menor según el área de construcción promedio de los proyectos que respaldan. ---- ");//asignar titulo a la ventana inicial
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//cierra solo la subventana, no toda la app


        //encabezado de la tabla
        String[] encabezado = {"Banco", "Area Construccion promedio"};
         
        //tabla con los datos
        this.jtProyectos = new JTable(this.formatoregistros(bancos, encabezado.length), encabezado);
        jtProyectos.setBackground(Color.BLACK);
        jtProyectos.setForeground(Color.WHITE);

        //crear scroll
        JScrollPane sp = new JScrollPane(this.jtProyectos);
        sp.setBackground(Color.black);


        //componente intermedio
        JPanel panel = new JPanel(new GridLayout());
        panel.setBorder(new TitledBorder("Bancos con mayor área de construcción financiada")) ;
        panel.add(sp);

        //contenedor
        getContentPane().add(panel);
        getContentPane().setBackground(Color.BLACK);
        
        

        //mostrar ventana
        super.setSize(500,400);
        super.setLocationRelativeTo(null);
        setVisible(true);

    }

    //metodo para convertir los ValueObject a strings, para que los use el JTable
    private String[][] formatoregistros(ArrayList<BancoRankeadoAreaPromedio> bancos, int numeroEncabezados){
        String[][] registros = new String[bancos.size()][numeroEncabezados];

        //llenamos la matriz estatica
        for (int i = 0; i < bancos.size(); i++) {
            registros[i][0]= String.valueOf(bancos.get(i).getBancoVinculado());
            registros[i][1]= String.valueOf( bancos.get(i).getAreaPromedio());
                 
        }
        //retornar los registros en formato JTable
        return registros;
    }

}

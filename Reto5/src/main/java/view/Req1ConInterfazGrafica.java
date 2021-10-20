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
import Model.ValueObject.ProyectoRankeadoCompras;
import java.util.ArrayList;

public class Req1ConInterfazGrafica extends JFrame {
    //atributos, definimos los componentes
    private JTable jtProyectos;

    //constructor inicial
    public Req1ConInterfazGrafica(ArrayList<ProyectoRankeadoCompras> proyectos,ControladorRequerimientosReto4 controlador){

        //propiedades del frame
        super.setTitle("Req. 1 ---- 10 Proyectos Con Mayor gasto ---- ");//asignar titulo a la ventana inicial
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//cierra solo la subventana, no toda la app


        //encabezado de la tabla
        String[] encabezado = {"ID_Proyecto", "Clasificación", "Gasto_Compras", "Serial"};
         
        //tabla con los datos
        this.jtProyectos = new JTable(this.formatoregistros(proyectos, encabezado.length), encabezado);
        jtProyectos.setBackground(Color.BLACK);
        jtProyectos.setForeground(Color.WHITE);

        //crear scroll
        JScrollPane sp = new JScrollPane(this.jtProyectos);
        sp.setBackground(Color.black);


        //componente intermedio
        JPanel panel = new JPanel(new GridLayout());
        panel.setBorder(new TitledBorder("Ranking de los 10 Proyectos con mayor gasto en compras")) ;
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
    private String[][] formatoregistros(ArrayList<ProyectoRankeadoCompras> proyectos, int numeroEncabezados){
        String[][] registros = new String[proyectos.size()][numeroEncabezados];

        //llenamos la matriz estatica
        for (int i = 0; i < proyectos.size(); i++) {
            registros[i][0]= String.valueOf(proyectos.get(i).getIdProyecto());
            registros[i][1]= proyectos.get(i).getClasificacion();
            registros[i][2]= String.valueOf(proyectos.get(i).getGastoCompra());
            registros[i][3]= proyectos.get(i).getSerial();      
        }
        //retornar los registros en formato JTable
        return registros;
    }

}

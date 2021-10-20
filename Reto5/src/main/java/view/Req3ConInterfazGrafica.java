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
import Model.ValueObject.MaterialRankeadoCompras;
import Model.ValueObject.ProyectoRankeadoCompras;
import java.util.ArrayList;

public class Req3ConInterfazGrafica extends JFrame {
    //atributos, definimos los componentes
    private JTable jtProyectos;

    //constructor inicial
    public Req3ConInterfazGrafica(ArrayList<MaterialRankeadoCompras> materiales,ControladorRequerimientosReto4 controlador){

        //propiedades del frame
        super.setTitle("Req. 3 ---- Los materiales importados más comprados en los proyectos, mostrando cuántas compras se han hecho de cada uno. Desempatar alfabéticamente ---- ");//asignar titulo a la ventana inicial
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//cierra solo la subventana, no toda la app


        //encabezado de la tabla
        String[] encabezado = {"Nombre Material", "Importado", "No Compras"};
         
        //tabla con los datos
        this.jtProyectos = new JTable(this.formatoregistros(materiales, encabezado.length), encabezado);
        jtProyectos.setBackground(Color.BLACK);
        jtProyectos.setForeground(Color.WHITE);

        //crear scroll
        JScrollPane sp = new JScrollPane(this.jtProyectos);
        sp.setBackground(Color.black);


        //componente intermedio
        JPanel panel = new JPanel(new GridLayout());
        panel.setBorder(new TitledBorder("Ranking de los materiales importados más comprados en los proyectos")) ;
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
    private String[][] formatoregistros(ArrayList<MaterialRankeadoCompras> materiales, int numeroEncabezados){
        String[][] registros = new String[materiales.size()][numeroEncabezados];

        //llenamos la matriz estatica
        for (int i = 0; i < materiales.size(); i++) {
            registros[i][0]= String.valueOf(materiales.get(i).getNombre_Material());
            registros[i][1]= materiales.get(i).isImportado();
            registros[i][2]= String.valueOf(materiales.get(i).getNo_Compras());
                 
        }
        //retornar los registros en formato JTable
        return registros;
    }

}

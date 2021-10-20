package view;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;

import Controler.ControladorRequerimientosReto4;;

public class menuprincipalConInterfazGrafica extends JFrame {
    //atributos, definimos los componentes
    private JButton Req1;
    private JButton Req2;
    private JButton Req3;

    //constructor inicial
    public menuprincipalConInterfazGrafica(){

    }

    //metodo para composicion
    public void iniciarGUI(ControladorRequerimientosReto4 controlador){
        //propiedades del frame
        super.setTitle("Gestor de consultas SQL con JAVA");//asignar titulo a la ventana inicial
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);//cierra la app

        //agregar componentes
        Req1 = new JButton("Ranking Proyectos");
        //quien me va a escuchar
        Req1.addActionListener(controlador);
        //que voy a decir para que se haga lo que tengo asociado
        Req1.setActionCommand("rankingProyectos");

        Req2 = new JButton("Ranking Bancos");
        //quien me va a escuchar
        Req2.addActionListener(controlador);
        //que voy a decir para que se haga lo que tengo asociado
        Req2.setActionCommand("rankingBancos");

        Req3 = new JButton("Ranking Materiales Importados");
        //quien me va a escuchar
        Req3.addActionListener(controlador);
        //que voy a decir para que se haga lo que tengo asociado
        Req3.setActionCommand("rankingMaterialesImportados");

        

        //asociar los componentes al componente intermedio o al contedenor
        //componente intermedio
        JPanel panel = new JPanel(new GridLayout(3,1));
        panel.add(Req1);
        panel.add(Req2);
        panel.add(Req3);
        panel.setBackground(Color.BLACK);
        //contenedor
        getContentPane().add(panel);
        getContentPane().setBackground(Color.BLACK);
        
        
        

        //mostrar ventana
        super.setSize(400,400);
        super.setLocationRelativeTo(null);
        setVisible(true);
    }

}

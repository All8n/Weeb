package presentacion;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaLogin extends JFrame {
	
	public VentanaLogin() {
		 
		 //le damos el titulo a traves del constructor de la superclase
		 super("Primera ventana");	
		 //tamaño y posicion
		 this.setBounds(100, 50, 700, 500);
		 //configurar boton de cierre de la ventana
		 this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		 //cambiar color de fondo
		 this.getContentPane().setBackground(Color.BLACK);
		 inicializarComponentes();
		 //hace la ventana visible
		 this.setVisible(true);
		 
	 

	}
	
	 void inicializarComponentes() {
		 
		 //anular el gestor de organizacion(layout)
		 this.setLayout(null);
		 JLabel lb1=new JLabel("Usuario: ");
		 JLabel lb2=new JLabel("Contraseña: ");
		 JTextField tx1=new JTextField();
		 JTextField tx2=new JTextField();
		 JButton bt=new JButton("Validar");
		 lb1.setBounds(150,50,150,30);
		 lb2.setBounds(150,100,150,30);
		 tx1.setBounds(350,50,200,30);
		 tx2.setBounds(350,100,200,30);
		 bt.setBounds(300,170,200,30);
		 //añadir el control a la ventana
		 this.add(lb1);
		 this.add(lb2);
		 this.add(tx1);
		 this.add(tx2);
		 this.add(bt);

	 }

}

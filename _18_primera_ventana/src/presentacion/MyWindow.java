package presentacion;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyWindow extends JFrame {
	 public MyWindow() {
		 
		 //le damos el titulo a traves del constructor de la superclase
		 super("Primera ventana");	
		 //tamaño y posicion
		 this.setBounds(100, 50, 700, 500);
		 //configurar boton de cierre de la ventana
		 this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		 //cambiar color de fondo
		 this.getContentPane().setBackground(Color.YELLOW);
		 inicializarComponentes();
		 //hace la ventana visible
		 this.setVisible(true);
		 
	 }
	 void inicializarComponentes() {
		 //anular el gestor de organizacion(layout)
		 this.setLayout(null);
		 JButton bt=new JButton("Pulsar aqui");
		 bt.setBounds(50,50,200,30);
		 //añadir el control a la ventana
		 this.add(bt);
	 }
}

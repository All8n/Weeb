package presentacion;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
		
		this.setLayout(null);
		JLabel lb1=new JLabel("Numero: ");
		JTextField tx1=new JTextField();
		JButton bt=new JButton("Resultado");
		JLabel lb=new JLabel("");
	    lb1.setBounds(150,50,150,30);
		tx1.setBounds(350,50,200,30);
		bt.setBounds(300,170,200,30);
		lb.setBounds(200,250,200,30);

		bt.addActionListener(e->lb.setText("El resultado es: "+tx1));

		this.add(lb1);
		this.add(tx1);
		this.add(bt);
		this.add(lb);



}
}

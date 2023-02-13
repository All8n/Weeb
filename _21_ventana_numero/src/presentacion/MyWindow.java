package presentacion;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.stream.IntStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyWindow extends JFrame {
	public MyWindow() {
		//valores "predeterminados" para una ventana 

		//le damos el titulo a traves del constructor de la superclase
		super("Primera ventana");	
		//tamaño y posicion
		this.setBounds(100, 50, 700, 500);
		//configurar boton de cierre de la ventana
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		//cambiar color de fondo
		this.getContentPane().setBackground(Color.YELLOW);
		inicializarComponentes();
		//hace la ventana visible
		this.setVisible(true);

	}
	void inicializarComponentes() {
		
		this.setLayout(null);
		JLabel lb=new JLabel("Numero: ");
		JTextField tf=new JTextField();
		JButton bt=new JButton("Factorial");
		JLabel lbRes=new JLabel("");
	    lb.setBounds(50,50,100,30);
		tf.setBounds(170,50,100,30);
		bt.setBounds(100,100,120,30);
		lbRes.setBounds(100,200,120,30);

		bt.addActionListener(e->lbRes.setText("El Factorial es: "+factorial(Integer.parseInt(tf.getText()))));
		
		this.addWindowListener(new WindowAdapter() {
			
		
			@Override
			public void windowClosing(WindowEvent e) {
				//cerramos la ventana si dice que si
				int res=JOptionPane.showConfirmDialog(MyWindow.this,"¿desea salir?");
				if(res==JOptionPane.YES_OPTION) {
					MyWindow.this.dispose();
				}
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				//cambia el color de fondo de la ventana con un color aleatorio
				Color color=new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
				MyWindow.this.getContentPane().setBackground(color);
			}
		});
		
		this.add(lb);
		this.add(tf);
		this.add(bt);
		this.add(lbRes);



}
	int factorial(int n) {
		/*int r=1;
		for(int i=1;i<=n;i++) {
			r*=1;
		}
		return n;*/
		return IntStream.rangeClosed(1, n).reduce(1,(a,b)->a*b);
	}
}

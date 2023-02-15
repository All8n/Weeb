package presentacion;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import model.Libro;
import javax.swing.JScrollPane;

public class VentanaLibros extends JFrame {

	private JPanel contentPane;

	private List<Libro> libros;
	

	/**
	 * Create the frame.
	 */
	public VentanaLibros(List<Libro> libros) {
		this.libros=libros;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btSalir = new JButton("salir");
		btSalir.setBounds(194, 196, 89, 23);
		contentPane.add(btSalir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(107, 22, 235, 144);
		contentPane.add(scrollPane);
		
		JTextArea taLibros = new JTextArea();
		scrollPane.setViewportView(taLibros);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				libros.forEach(l->taLibros.setText(taLibros.getText()+l.getTitulo()+"<br>"));
			}
		});
		this.setVisible(true);
	}
}


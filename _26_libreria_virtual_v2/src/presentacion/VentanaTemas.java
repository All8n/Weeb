package presentacion;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import model.Libro;
import model.Temas;
import presentacion.datamodel.AdaptadorListaTemas;
import presentacion.datamodel.AdaptadorTablaLibros;

public class VentanaTemas extends JFrame {

		private JPanel contentPane;
		private List<Temas> temas;
		private JTable tableLibros;
		private List<Libro> libros;

  
	public VentanaTemas(List<Temas> temas) {
		
		//this llama a la variable del private List<Temas> y lo iguala a temas 
		this.temas=temas;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione  tema:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setBounds(50, 11, 315, 30);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollLista = new JScrollPane();
		scrollLista.setBounds(50, 52, 560, 36);
		contentPane.add(scrollLista);
		
		JComboBox<Temas> comboTemas =new JComboBox<>();
		comboTemas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//cogemos el tema seleccionado 
				Temas tema=(Temas)comboTemas.getSelectedItem();
				//creamos 
				var adapter=new AdaptadorTablaLibros(tema.getIdTema());
				tableLibros.setModel(adapter);
			}
		});
		comboTemas.setFont(new Font("Tahoma", Font.PLAIN, 21));
		scrollLista.setViewportView(comboTemas);
		
		JScrollPane scrollLibros = new JScrollPane();
		scrollLibros.setBounds(50, 99, 560, 297);
		contentPane.add(scrollLibros);
		
		tableLibros =new JTable();
		tableLibros.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollLibros.setViewportView(tableLibros);
		
		JLabel lbHora = new JLabel("New label");
		lbHora.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbHora.setBounds(589, 11, 71, 14);
		contentPane.add(lbHora);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				var adapter=new AdaptadorListaTemas();
				comboTemas.setModel(adapter);
				comboTemas.addItem(new Temas(0,"-Seleccione uno-"));
				
				ScheduledExecutorService executor=Executors.newSingleThreadScheduledExecutor();
				executor.scheduleAtFixedRate(()->{
					LocalTime time=LocalTime.now();
					lbHora.setText(time.toString());
				},0, 1, TimeUnit.SECONDS);
				
				
			}
		});
		this.setVisible(true);

	}
}

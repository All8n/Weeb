package presentacion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import service.ClientesService;
import service.LibreriaServiceFactory;
import service.LibrosService;
import service.TemasService;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textUsu;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaLogin() {
		setFont(new Font("Bauhaus 93", Font.PLAIN, 12));
		setTitle("Verificacion de usuario");
		ClientesService clientesService=LibreriaServiceFactory.getClientesService();
		LibrosService librosService=LibreriaServiceFactory.getLibrosService();
		TemasService temasService=LibreriaServiceFactory.getTemasService();

		setBackground(UIManager.getColor("Button.focus"));
		setForeground(UIManager.getColor("Button.background"));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\manana\\Pictures\\Saved Pictures\\cat..png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbUsuario = new JLabel("Usuario:");
		lbUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbUsuario.setBounds(26, 48, 64, 19);
		contentPane.add(lbUsuario);
		
		textUsu = new JTextField();
		textUsu.setBounds(121, 47, 115, 20);
		contentPane.add(textUsu);
		textUsu.setColumns(10);
		
		JLabel lbPass = new JLabel("Password:");
		lbPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbPass.setBounds(26, 83, 79, 20);
		contentPane.add(lbPass);
		
		JButton btVerf = new JButton("Verificacion");
		btVerf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					btVerf.doClick();
				}
			}
		});
		btVerf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btVerf.setForeground(Color.BLACK);
		btVerf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String mensaje;
				if(clientesService.existe(textUsu.getText(), passwordField.getText())) {
				//creamos la ventana de libros y le pasamos la lista de libros
				//para que los muestre 
					new VentanaTemas(temasService.temas());
				
				}else {
				}
				JOptionPane.showMessageDialog(VentanaLogin.this, "Usuario no valido");
				
			}
		});
		btVerf.setBounds(26, 125, 106, 23);
		contentPane.add(btVerf);
		
		JLabel lbRes = new JLabel("");
		lbRes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbRes.setBounds(87, 159, 177, 14);
		contentPane.add(lbRes);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(121, 82, 115, 21);
		contentPane.add(passwordField);
	}
}

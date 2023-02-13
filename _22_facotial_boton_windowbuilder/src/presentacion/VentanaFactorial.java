package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.stream.IntStream;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Toolkit;

public class VentanaFactorial extends JFrame {

	private JPanel contentPane;
	private JTextField tf;
	private JLabel lbRes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaFactorial frame = new VentanaFactorial();
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
	public VentanaFactorial() {
		setTitle("Ecuacion Factorial");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\manana\\Pictures\\Saved Pictures\\cat..png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 541, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton bt = new JButton("Factorial");
		bt.setBounds(94, 153, 104, 23);
		bt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lbRes.setText("Factorial: "+factorial(Integer.parseInt(tf.getText())));
			}
		});
		contentPane.setLayout(null);
		
		lbRes = new JLabel("");
		lbRes.setBounds(77, 187, 276, 17);
		contentPane.add(lbRes);
		
		JLabel lblNewLabel = new JLabel("Numero: ");
		lblNewLabel.setBounds(47, 103, 58, 17);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblNewLabel);
		
		tf = new JTextField();
		tf.setBounds(129, 103, 86, 20);
		contentPane.add(tf);
		tf.setColumns(10);
		contentPane.add(bt);
	}
	int factorial(int n) {
		
		return IntStream.rangeClosed(1, n).reduce(1,(a,b)->a*b);
	}
}

package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;

public class VBusqueda extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VBusqueda frame = new VBusqueda();
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
	public VBusqueda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCP = new JLabel("*CP*");
		lblCP.setBounds(10, 11, 82, 22);
		contentPane.add(lblCP);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(384, 33, 82, 23);
		contentPane.add(btnBuscar);
		
		JList listRest = new JList();
		listRest.setBounds(24, 67, 442, 198);
		contentPane.add(listRest);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(20, 33, 67, 23);
		contentPane.add(btnAtras);
		
		textField = new JTextField();
		textField.setBounds(114, 34, 260, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}

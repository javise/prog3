package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;

public class VProducto extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VProducto frame = new VProducto();
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
	public VProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(10, 11, 89, 23);
		contentPane.add(btnAtras);
		
		JLabel lblNomProducto = new JLabel("NomProducto");
		lblNomProducto.setBounds(123, 15, 231, 14);
		contentPane.add(lblNomProducto);
		
		JButton btnAnadir = new JButton("A\u00F1adir");
		btnAnadir.setBounds(108, 274, 89, 23);
		contentPane.add(btnAnadir);
		
		JRadioButtonMenuItem seleccionProducto = new JRadioButtonMenuItem("");
		buttonGroup.add(seleccionProducto);
		seleccionProducto.setBounds(22, 57, 258, 206);
		contentPane.add(seleccionProducto);
	}
}

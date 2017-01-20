package ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class VInfoUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTlf;
	private JTextField txtDir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VInfoUsuario frame = new VInfoUsuario();
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
	public VInfoUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("PEDIDO - RESTAURANTE");
		label.setBounds(123, 15, 166, 14);
		contentPane.add(label);
		
		JButton button = new JButton("Atras");
		button.setBounds(10, 11, 89, 23);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VPedido newPedido = new VPedido();
				newPedido.setVisible(true);
				dispose();
				
			}
		});
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(36, 76, 63, 14);
		contentPane.add(lblNombre);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(36, 111, 63, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(36, 147, 63, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblHoraDeEntrega = new JLabel("Hora de entrega");
		lblHoraDeEntrega.setBounds(36, 183, 94, 14);
		contentPane.add(lblHoraDeEntrega);
		
		JLabel lblComentario = new JLabel("Comentario:");
		lblComentario.setBounds(36, 208, 94, 14);
		contentPane.add(lblComentario);
		
		JTextArea txtrComentario = new JTextArea();
		txtrComentario.setBounds(36, 233, 275, 69);
		contentPane.add(txtrComentario);
		
		JComboBox comboBoxHora = new JComboBox();
		comboBoxHora.setBounds(144, 180, 28, 20);
		contentPane.add(comboBoxHora);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(114, 73, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTlf = new JTextField();
		txtTlf.setBounds(114, 108, 86, 20);
		contentPane.add(txtTlf);
		txtTlf.setColumns(10);
		
		txtDir = new JTextField();
		txtDir.setBounds(114, 144, 86, 20);
		contentPane.add(txtDir);
		txtDir.setColumns(10);
	}
}

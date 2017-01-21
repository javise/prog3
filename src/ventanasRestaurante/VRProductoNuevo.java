package ventanasRestaurante;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;

public class VRProductoNuevo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VRProductoNuevo frame = new VRProductoNuevo();
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
	public VRProductoNuevo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 403, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(10, 11, 89, 23);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VRPrincipal vrp = new VRPrincipal();
				vrp.setVisible(true);
				dispose();
			}
		});
		
		JLabel lblNuevoProducto = new JLabel("NUEVO PRODUCTO");
		lblNuevoProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNuevoProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoProducto.setBounds(109, 11, 176, 19);
		contentPane.add(lblNuevoProducto);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(10, 73, 89, 14);
		contentPane.add(lblNombre);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescripcion.setBounds(10, 108, 89, 14);
		contentPane.add(lblDescripcion);
		
		textField = new JTextField();
		textField.setBounds(131, 70, 229, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(130, 103, 230, 61);
		contentPane.add(textArea);
		
		JLabel lblElegible = new JLabel("Elegible");
		lblElegible.setHorizontalAlignment(SwingConstants.RIGHT);
		lblElegible.setBounds(10, 181, 89, 14);
		contentPane.add(lblElegible);
		
		JRadioButton rdbtnSi = new JRadioButton("Si");
		rdbtnSi.setBounds(131, 177, 46, 23);
		contentPane.add(rdbtnSi);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(181, 177, 46, 23);
		contentPane.add(rdbtnNo);
		rdbtnNo.setSelected(true);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnSi);
		buttonGroup.add(rdbtnNo);
		
		JLabel lblOpciones = new JLabel("Opciones");
		lblOpciones.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOpciones.setBounds(10, 217, 89, 14);
		contentPane.add(lblOpciones);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecio.setBounds(10, 254, 89, 14);
		contentPane.add(lblPrecio);
		
		textField_1 = new JTextField();
		textField_1.setBounds(131, 251, 132, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("\u20AC");
		label.setBounds(273, 254, 46, 14);
		contentPane.add(label);
		
		JButton btnAadir = new JButton("Añadir");
		btnAadir.setBounds(154, 304, 89, 23);
		contentPane.add(btnAadir);
	}
}

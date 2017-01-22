package ventanasRestaurante;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Producto;
import gestiones.Datos;
import gestiones.PrincipalRestaurante;
import ventanas.DError;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;

public class VRProductoNuevo extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNom;
	private JTextField textFieldPr;
	private JTextField textFieldCat;

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
		setBounds(100, 100, 403, 402);
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
		lblNombre.setBounds(10, 63, 89, 14);
		contentPane.add(lblNombre);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescripcion.setBounds(10, 96, 89, 14);
		contentPane.add(lblDescripcion);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(132, 60, 229, 20);
		contentPane.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		JTextArea textAreaDesc = new JTextArea();
		textAreaDesc.setBounds(131, 91, 230, 61);
		contentPane.add(textAreaDesc);
		
		JLabel lblElegible = new JLabel("Elegible");
		lblElegible.setHorizontalAlignment(SwingConstants.RIGHT);
		lblElegible.setBounds(10, 163, 89, 14);
		contentPane.add(lblElegible);
		
		JRadioButton rdbtnSi = new JRadioButton("Si");
		rdbtnSi.setBounds(131, 159, 46, 23);
		contentPane.add(rdbtnSi);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(179, 159, 46, 23);
		contentPane.add(rdbtnNo);
		rdbtnNo.setSelected(true);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnSi);
		buttonGroup.add(rdbtnNo);
		
		JLabel lblOpciones = new JLabel("Opciones");
		lblOpciones.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOpciones.setBounds(10, 196, 89, 14);
		contentPane.add(lblOpciones);
		lblOpciones.setVisible(false);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecio.setBounds(10, 253, 89, 14);
		contentPane.add(lblPrecio);
		
		textFieldPr = new JTextField();
		textFieldPr.setBounds(131, 250, 132, 20);
		contentPane.add(textFieldPr);
		textFieldPr.setColumns(10);
		
		JLabel label = new JLabel("\u20AC");
		label.setBounds(272, 253, 46, 14);
		contentPane.add(label);
		
		JButton btnAadir = new JButton("Añadir");
		btnAadir.setBounds(155, 316, 89, 23);
		contentPane.add(btnAadir);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoria.setBounds(10, 288, 89, 14);
		contentPane.add(lblCategoria);
		
		textFieldCat = new JTextField();
		textFieldCat.setBounds(131, 285, 132, 20);
		contentPane.add(textFieldCat);
		textFieldCat.setColumns(10);
		
		JTextArea textAreaOp = new JTextArea();
		textAreaOp.setBounds(130, 191, 230, 23);
		contentPane.add(textAreaOp);
		textAreaOp.setVisible(false);
		
		JLabel lblMensaje = new JLabel("(Opciones separadas por comas, sin espacios)");
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblMensaje.setBounds(132, 214, 229, 14);
		contentPane.add(lblMensaje);
		lblMensaje.setVisible(false);
		
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					if(rdbtnSi.isSelected()){
						Producto p = new Producto(textFieldNom.getText(), Double.parseDouble(textFieldPr.getText()), textAreaDesc.getText(), new ArrayList<String>(Arrays.asList(textAreaOp.getText().split("\\,"))));
						p.setElegible(true);
						Datos.nuevoProductoAlMenu(p, textFieldCat.getText(), PrincipalRestaurante.idEsteRestaurante);
					}else{
						Producto p = new Producto(textFieldNom.getText(), Double.parseDouble(textFieldPr.getText()), textAreaDesc.getText());
						p.setElegible(false);
						Datos.nuevoProductoAlMenu(p, textFieldCat.getText(), PrincipalRestaurante.idEsteRestaurante);
					}
					VRPrincipal vrp = new VRPrincipal();
					vrp.setVisible(true);
					dispose();
				}catch(NumberFormatException nfe){
					DError de = new DError("Rellene los campos vacíos");
					de.setVisible(true);
				}
			}
		});
		
		rdbtnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnSi.isSelected()){
					lblOpciones.setVisible(true);
					textAreaOp.setVisible(true);
					lblMensaje.setVisible(true);
				}
			}
		});
		rdbtnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnNo.isSelected()){
					lblOpciones.setVisible(false);
					textAreaOp.setVisible(false);
					lblMensaje.setVisible(false);
				}
			}
		});
	}
}

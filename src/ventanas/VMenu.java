package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;

public class VMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VMenu frame = new VMenu();
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
	public VMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPedido = new JButton("Pedido");
		btnPedido.setBounds(455, 11, 89, 40);
		contentPane.add(btnPedido);
		btnPedido.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VPedido newPedido = new VPedido();
				newPedido.setVisible(true);
				VMenu.this.dispose();
				
			}
		});
		
		JTextPane txtpnDescripcion = new JTextPane();
		txtpnDescripcion.setText("Descripcion");
		txtpnDescripcion.setBounds(271, 279, 273, 58);
		contentPane.add(txtpnDescripcion);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(10, 11, 89, 23);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VRestaurante newVRestaurante = new VRestaurante();
				newVRestaurante.setVisible(true);
				VMenu.this.dispose();
				
			}
		});
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(118, 15, 304, 14);
		contentPane.add(lblNombre);
		
		JLabel lblCategorias = new JLabel("CATEGORIAS");
		lblCategorias.setBounds(10, 68, 206, 14);
		contentPane.add(lblCategorias);
		
		JLabel lblProductos = new JLabel("PRODUCTOS");
		lblProductos.setBounds(277, 68, 256, 14);
		contentPane.add(lblProductos);
		
		JList listCat = new JList();
		listCat.setBounds(10, 93, 246, 244);
		contentPane.add(listCat);
		
		JList listProd = new JList();
		listProd.setBounds(271, 93, 273, 178);
		contentPane.add(listProd);
	}
}

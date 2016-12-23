package ventanas;


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

public class VRestaurante extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VRestaurante frame = new VRestaurante();
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
	public VRestaurante() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

//		JButton btnPedido = new JButton("Pedido");
//		btnPedido.setBounds(455, 39, 89, 40);
//		contentPane.add(btnPedido);
//		btnPedido.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				VPedido newPedido = new VPedido();
//				newPedido.setVisible(true);
//				VRestaurante.this.dispose();
//				
//			}
//		});

		//		JButton btnPedido = new JButton("Pedido");
//		btnPedido.setBounds(455, 39, 89, 40);
//		contentPane.add(btnPedido);
//		btnPedido.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				VPedido newPedido = new VPedido();
//				newPedido.setVisible(true);
//				VRestaurante.this.dispose();
//				
//			}
//		});

		
		JButton btnMenu = new JButton("VER MENU");
		btnMenu.setBounds(10, 297, 534, 40);
		contentPane.add(btnMenu);
		btnMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VMenu newVMenu = new VMenu();
				newVMenu.setVisible(true);
				VRestaurante.this.dispose();
			}
		});
		
		JTextPane txtpnDescripcion = new JTextPane();
		txtpnDescripcion.setText("Descripcion");
		txtpnDescripcion.setBounds(272, 97, 272, 189);
		contentPane.add(txtpnDescripcion);
		
		JLabel lblMapa = new JLabel("MAPA");
		lblMapa.setHorizontalAlignment(SwingConstants.CENTER);
		lblMapa.setBounds(10, 97, 252, 189);
		contentPane.add(lblMapa);
		
		JPanel panel = new JPanel();
		panel.setBounds(92, 11, 353, 75);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblImagen = new JLabel("IMAGEN");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setBounds(9, 11, 81, 42);
		panel.add(lblImagen);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(100, 11, 219, 14);
		panel.add(lblNombre);
		
		JLabel lblDescriptitulo = new JLabel("DescripTitulo");
		lblDescriptitulo.setBounds(100, 25, 219, 14);
		panel.add(lblDescriptitulo);
		
		JLabel lblCp = new JLabel("CP");
		lblCp.setBounds(101, 36, 218, 14);
		panel.add(lblCp);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(15, 11, 67, 40);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VBusqueda newVBusqueda  = new VBusqueda();
				newVBusqueda.setVisible(true);
				VRestaurante.this.dispose();
				
			}
		});
	}
}

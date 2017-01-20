package ventanas;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Pedido;
import gestiones.Principal;

import javax.swing.ImageIcon;
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
					VRestaurante frame = new VRestaurante(1);
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
	//La variable deDondeViene define que ventana le precede.2-VBusqueda; 1-VPricipal; 0-VMenu.
	//Cuando viene de la ventana VMenu es imposible que haya habido un cambio de restaurante asi que se conserva el pedido.
	//El pedido es para un unico restaurante, si se sale de ese restaurante el pedido se reinicia.
	public VRestaurante(int deDondeViene) {
		if(deDondeViene!=0){
			if(Principal.pedidoEnCurso == null){
				Principal.pedidoEnCurso = new Pedido();
			}else{
				Principal.pedidoEnCurso.nuevoPedido();
			}
		}
		
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
				try{
					VMenu newVMenu = new VMenu();
					newVMenu.setVisible(true);
					VRestaurante.this.dispose();
				}catch(NullPointerException npe){
					DError decp = new DError("Lo sentimos, este menú no está disponible");
					decp.setVisible(true);
				}
				
			}
		});
		
		JTextPane txtpnDescripcion = new JTextPane();
		txtpnDescripcion.setText(Principal.selectedRest.getDesc());
		txtpnDescripcion.setBounds(272, 97, 272, 189);
		contentPane.add(txtpnDescripcion);
		
		ImageIcon mapa = new ImageIcon("img/mapa"+Principal.selectedRest.getNombre()+".png");
		JLabel lblMapa = new JLabel(mapa);
		lblMapa.setHorizontalAlignment(SwingConstants.CENTER);
		lblMapa.setBounds(10, 97, 252, 189);
		contentPane.add(lblMapa);
		
		JPanel panel = new JPanel();
		panel.setBounds(92, 11, 353, 75);
		contentPane.add(panel);
		panel.setLayout(null);
		
		ImageIcon imagen = new ImageIcon("img/"+Principal.selectedRest.getNombre()+".png");
		JLabel lblImagen = new JLabel(imagen);
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setBounds(9, 11, 81, 42);
		panel.add(lblImagen);
		
		JLabel lblNombre = new JLabel(Principal.selectedRest.getNombre());
		lblNombre.setBounds(100, 11, 219, 14);
		panel.add(lblNombre);
		
		JLabel lblDescriptitulo = new JLabel(Principal.selectedRest.getTipo());
		lblDescriptitulo.setBounds(100, 25, 219, 14);
		panel.add(lblDescriptitulo);
		
		JLabel lblCp = new JLabel(String.valueOf(Principal.selectedRest.getCodPost()));
		lblCp.setBounds(101, 36, 218, 14);
		panel.add(lblCp);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(15, 11, 67, 40);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(deDondeViene==2){
					VBusqueda vb = new VBusqueda();
					vb.setVisible(true);
					dispose();
				}else{
					VPrincipal vp = new VPrincipal();
					vp.setVisible(true);
					dispose();
				}
			}
		});
	}
}

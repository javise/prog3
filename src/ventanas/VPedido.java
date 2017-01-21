package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Producto;
import gestiones.Principal;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class VPedido extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VPedido frame = new VPedido();
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
	public VPedido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(10, 11, 89, 23);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VMenu newVMenu = new VMenu();
				newVMenu.setVisible(true);
				VPedido.this.dispose();
			}
		});
		
		JLabel labelPedido = new JLabel("PEDIDO - "+Principal.selectedRest.getNombre());
		labelPedido.setBounds(119, 15, 166, 14);
		contentPane.add(labelPedido);
		
		JButton btnRecogida;
		if(Principal.pedidoEnCurso.isDomicilio()){
			btnRecogida = new JButton("DOMICILIO");
		}else{
			btnRecogida = new JButton("LOCAL");
		}
		btnRecogida.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnRecogida.setBounds(295, 11, 89, 40);
		contentPane.add(btnRecogida);
		
		JLabel lblResumen = new JLabel("RESUMEN:");
		lblResumen.setBounds(30, 57, 72, 23);
		contentPane.add(lblResumen);
		
		JLabel lblMensaje = new JLabel("(Doble click sobre un producto para quitarlo)");
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblMensaje.setBounds(30, 182, 255, 14);
		contentPane.add(lblMensaje);
		
		JList<Producto> list = new JList<Producto>(Principal.pedidoEnCurso.modelProductos());
		list.setBounds(30, 86, 354, 98);
		
		JLabel lblSubtotal = new JLabel("SUBTOTAL");
		lblSubtotal.setBounds(30, 207, 237, 14);
		contentPane.add(lblSubtotal);
		
		JLabel lblGastoDeEnvio = new JLabel("GASTO DE ENVIO");
		lblGastoDeEnvio.setBounds(30, 232, 237, 14);
		contentPane.add(lblGastoDeEnvio);
		
		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setBounds(30, 271, 237, 14);
		contentPane.add(lblTotal);
		
		JButton btnPedir = new JButton("Pedir Ahora");
		btnPedir.setBounds(151, 296, 116, 23);
		contentPane.add(btnPedir);
		btnPedir.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VInfoUsuario viu = new VInfoUsuario();
				viu.setVisible(true);
				VPedido.this.dispose();
			}
		});
		
		JLabel lblPrecioSubtotal = new JLabel(Double.toString(Principal.pedidoEnCurso.getCantidad())+" €");
		lblPrecioSubtotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecioSubtotal.setBounds(277, 207, 78, 14);
		contentPane.add(lblPrecioSubtotal);
		
		JLabel lblPrecioGastoEnvio = new JLabel(Double.toString(gastos())+" €");
		lblPrecioGastoEnvio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecioGastoEnvio.setBounds(277, 232, 78, 14);
		contentPane.add(lblPrecioGastoEnvio);
		
		JLabel lblPreciototal = new JLabel(Double.toString(Principal.pedidoEnCurso.getCantidad()+gastos())+" €");
		lblPreciototal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPreciototal.setBounds(277, 271, 78, 14);
		contentPane.add(lblPreciototal);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 86, 356, 98);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(list);
		
		list.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		    	try{
		    		if (evt.getClickCount() == 2) {
			    		Principal.pedidoEnCurso.quitarProducto(list.getSelectedValue());
			    		list.setModel(Principal.pedidoEnCurso.modelProductos());
			    		lblPrecioSubtotal.setText(Double.toString(Principal.pedidoEnCurso.getCantidad())+" €");
			    		lblPreciototal.setText(Double.toString(Principal.pedidoEnCurso.getCantidad()+gastos())+" €");
			    	}
		    	}catch(NullPointerException npe){}
		    }
		});
		
		btnRecogida.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Principal.pedidoEnCurso.isDomicilio()){
					btnRecogida.setText("LOCAL");
					Principal.pedidoEnCurso.setDomicilio(false);
				}else{
					btnRecogida.setText("DOMICILIO");
					Principal.pedidoEnCurso.setDomicilio(true);
				}
				lblPrecioGastoEnvio.setText(Double.toString(gastos())+" €");
				lblPreciototal.setText(Double.toString(Principal.pedidoEnCurso.getCantidad()+gastos())+" €");
			}
		});
	}
	public double gastos(){
		double g;
		if(Principal.pedidoEnCurso.isDomicilio()){
			g=Principal.selectedRest.getGastosEnvio();
		}else {
			g=0.0;
		}
		return g;
	}
}

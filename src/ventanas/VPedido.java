package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class VPedido extends JFrame {

	private JPanel contentPane;
	private boolean domicilio = true; //f-local; t-domicilio

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
		setBounds(100, 100, 429, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(10, 11, 89, 23);
		contentPane.add(btnAtras);
		
		JLabel labelPedido = new JLabel("PEDIDO - RESTAURANTE");
		labelPedido.setBounds(119, 15, 166, 14);
		contentPane.add(labelPedido);
		
		JButton btnRecogida = new JButton("DOMICILIO");
		btnRecogida.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnRecogida.setBounds(295, 11, 89, 40);
		contentPane.add(btnRecogida);
		
		btnRecogida.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(domicilio){
					btnRecogida.setText("LOCAL");
					domicilio = false;
				}else{
					btnRecogida.setText("DOMICILIO");
					domicilio = true;
				}
			}
		});
		
		JLabel lblResumen = new JLabel("RESUMEN:");
		lblResumen.setBounds(30, 57, 135, 23);
		contentPane.add(lblResumen);
		
		JList list = new JList();
		list.setBounds(30, 89, 354, 98);
		contentPane.add(list);
		
		JLabel lblSubtotal = new JLabel("SUBTOTAL");
		lblSubtotal.setBounds(30, 198, 237, 14);
		contentPane.add(lblSubtotal);
		
		JLabel lblGastoDeEnvio = new JLabel("GASTO DE ENVIO");
		lblGastoDeEnvio.setBounds(30, 223, 237, 14);
		contentPane.add(lblGastoDeEnvio);
		
		JLabel lblDescuento = new JLabel("DESCUENTO");
		lblDescuento.setBounds(30, 251, 237, 14);
		contentPane.add(lblDescuento);
		
		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setBounds(30, 287, 237, 14);
		contentPane.add(lblTotal);
		
		JButton btnPedir = new JButton("Pedir Ahora");
		btnPedir.setBounds(141, 315, 116, 23);
		contentPane.add(btnPedir);
		
		JLabel lblPrecioSubtotal = new JLabel("€");
		lblPrecioSubtotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecioSubtotal.setBounds(277, 198, 78, 14);
		contentPane.add(lblPrecioSubtotal);
		
		JLabel lblPrecioGastoEnvio = new JLabel("€");
		lblPrecioGastoEnvio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecioGastoEnvio.setBounds(277, 223, 78, 14);
		contentPane.add(lblPrecioGastoEnvio);
		
		JLabel lblPrecioDescuento = new JLabel("€");
		lblPrecioDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecioDescuento.setBounds(277, 251, 78, 14);
		contentPane.add(lblPrecioDescuento);
		
		JLabel lblPreciototal = new JLabel("€");
		lblPreciototal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPreciototal.setBounds(277, 287, 78, 14);
		contentPane.add(lblPreciototal);
	}

}

package ventanasRestaurante;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class VRPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VRPrincipal frame = new VRPrincipal();
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
	public VRPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 10, 10));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(2, 1, 10, 10));
		
		JButton btnCola = new JButton("Ver cola de pedidos");
		btnCola.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(btnCola);
		btnCola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VRColaPedidos vrcp = new VRColaPedidos();
		    	vrcp.setVisible(true);
		    	dispose();
			}
		});
		
		JButton btnHistorial = new JButton("Historial");
		btnHistorial.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnHistorial);
		btnHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VRHistorial vrh = new VRHistorial();
		    	vrh.setVisible(true);
		    	dispose();
			}
		});
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(3, 0, 10, 10));
		
		JButton btnPrNuevo = new JButton("Producto nuevo");
		btnPrNuevo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(btnPrNuevo);
		btnPrNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VRProductoNuevo vrpn = new VRProductoNuevo();
		    	vrpn.setVisible(true);
		    	dispose();
			}
		});
		
		JButton btnPrEliminar = new JButton("Eliminar Producto");
		btnPrEliminar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(btnPrEliminar);
		btnPrEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VREliminarProducto vrep = new VREliminarProducto();
		    	vrep.setVisible(true);
		    	dispose();
			}
		});
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VRInicio vri = new VRInicio();
				vri.setVisible(true);
		    	dispose();
			}
		});
	}

}

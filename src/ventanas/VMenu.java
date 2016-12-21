package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.GridLayout;

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
		contentPane.setBorder(new EmptyBorder(8, 8, 8, 8));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 0, 5, 0));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(10, 0));
		
		JButton btnAtras = new JButton("Atras");
		panel.add(btnAtras, BorderLayout.WEST);
		
		JLabel lblNombre = new JLabel("Nombre");
		panel.add(lblNombre, BorderLayout.CENTER);
		
		JButton btnPedido = new JButton("Pedido");
		panel.add(btnPedido, BorderLayout.EAST);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(15, 0, 5, 0));
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblCategorias = new JLabel("CATEGORIAS");
		panel_2.add(lblCategorias);
		
		JLabel lblProductos = new JLabel("PRODUCTOS");
		panel_2.add(lblProductos);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(0, 2, 5, 0));
		
		JList listCat = new JList();
		panel_3.add(listCat);
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 5));
		
		JList listProd = new JList();
		panel_4.add(listProd);
		
		JTextPane txtpnDescripcion = new JTextPane();
		panel_4.add(txtpnDescripcion);
		txtpnDescripcion.setText("Descripcion");
	}
}

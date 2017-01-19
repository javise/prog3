package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Producto;
import gestiones.Datos;
import gestiones.Principal;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.GridLayout;
import java.awt.FlowLayout;

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
		
		JLabel lblNombre = new JLabel("Nombre");
		panel.add(lblNombre, BorderLayout.CENTER);
		
		JButton btnPedido = new JButton("Pedido");
		panel.add(btnPedido, BorderLayout.EAST);
		btnPedido.setBounds(455, 11, 89, 40);
		
		JButton btnAtras = new JButton("Atras");
		panel.add(btnAtras, BorderLayout.WEST);
		btnAtras.setBounds(10, 11, 89, 23);
		btnAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VRestaurante newVRestaurante = new VRestaurante();
				newVRestaurante.setVisible(true);
				VMenu.this.dispose();
				
			}
		});
		btnPedido.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VPedido newPedido = new VPedido();
				newPedido.setVisible(true);
				VMenu.this.dispose();
				
			}
		});
		
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
		
		JTextPane txtpnDescripcion = new JTextPane();
		txtpnDescripcion.setText("Descripcion");
		txtpnDescripcion.setBounds(271, 279, 273, 58);
		
		Datos.leerMenu();
		
		JList<String> listCat = new JList<String>(Principal.selectedRest.getMenu().categorias());
		listCat.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel_3.add(listCat);
		
		JList<Producto> listProd = new JList<Producto>();
		listProd.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		listCat.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		    	listProd.setModel(Principal.selectedRest.getMenu().productosPorCategoria(listCat.getSelectedValue()));
		    }
		});
		
		listProd.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		    	txtpnDescripcion.setText(listProd.getSelectedValue().getDescripcion());
		    }
		});
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 5));
		
		panel_4.add(listProd);
		panel_4.add(txtpnDescripcion);
		
		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new FlowLayout(FlowLayout.RIGHT, 75, 5));
		
		JButton btnAnyadir = new JButton("A\u00F1adir al pedido");
		panel_5.add(btnAnyadir);
	}
}

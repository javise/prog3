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
import java.awt.Font;
import javax.swing.JScrollPane;

public class VMenu extends JFrame {

	private JPanel contentPane;
	private JLabel lblContador;

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
		
		JButton btnAtras = new JButton("Atras");
		panel.add(btnAtras, BorderLayout.WEST);
		btnAtras.setBounds(10, 11, 89, 23);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6, BorderLayout.EAST);
		
		lblContador = new JLabel(Integer.toString(Principal.pedidoEnCurso.getPedido().size()));
		panel_6.add(lblContador);
		
		JButton btnPedido = new JButton("Pedido");
		panel_6.add(btnPedido);
		btnPedido.setBounds(455, 11, 89, 40);
		btnPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VPedido newPedido = new VPedido();
				newPedido.setVisible(true);
				VMenu.this.dispose();
				
			}
		});
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VRestaurante newVRestaurante = new VRestaurante(0);
				newVRestaurante.setVisible(true);
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
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JLabel lblProductos = new JLabel("PRODUCTOS");
		panel_7.add(lblProductos, BorderLayout.WEST);
		
		JLabel lblMensaje = new JLabel("Doble click para añadir");
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 9));
		panel_7.add(lblMensaje, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(0, 2, 5, 0));
		
		JTextPane txtpnDescripcion = new JTextPane();
		txtpnDescripcion.setText("Descripcion");
		txtpnDescripcion.setBounds(271, 279, 273, 58);
		
		Principal.selectedRest.setMenu(Datos.leerMenu(Principal.selectedRest.getIdRestaurante()));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane);
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 5));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_4.add(scrollPane_1);
		
		JList<Producto> listProd = new JList<Producto>();
		scrollPane_1.setViewportView(listProd);
		listProd.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JList<String> listCat = new JList<String>(Principal.selectedRest.getMenu().categorias());
		scrollPane.setViewportView(listCat);
		listCat.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		listCat.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		    	try{
		    		listProd.setModel(Principal.selectedRest.getMenu().productosPorCategoria(listCat.getSelectedValue()));
		    	}catch(NullPointerException npe){}
		    }
		});
		
		listProd.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		    	try{
			    	txtpnDescripcion.setText(listProd.getSelectedValue().getDescripcion());
			    	if (evt.getClickCount() == 2) {
			    		productoSeleccionado(listProd, lblContador);
			    	}
		    	}catch(NullPointerException npe){}
		    }
		});
		panel_4.add(txtpnDescripcion);
		
		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new FlowLayout(FlowLayout.RIGHT, 75, 5));
		
		JButton btnAnyadir = new JButton("Añadir al pedido");
		panel_5.add(btnAnyadir);
		btnAnyadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listProd.getSelectedValue()!=null){
					productoSeleccionado(listProd, lblContador);
				}else{
					DError decp = new DError("Seleccione un producto");
					decp.setVisible(true);
				}
			}
		});
	}
	
	private void productoSeleccionado(JList<Producto> listP, JLabel lblC){
		if(listP.getSelectedValue().isElegible()){
			DProducto vpr = new DProducto(listP.getSelectedValue(), this);
			vpr.setVisible(true);
		}else{
			Principal.pedidoEnCurso.anyadirProducto(listP.getSelectedValue());
			lblC.setText(Integer.toString(Principal.pedidoEnCurso.getPedido().size()));
		}
	}
	
	public void actualizarContador(){
		lblContador.setText(Integer.toString(Principal.pedidoEnCurso.getPedido().size()));
	}
}

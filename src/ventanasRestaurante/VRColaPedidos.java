package ventanasRestaurante;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Pedido;
import domain.Producto;
import gestiones.Datos;
import gestiones.PrincipalRestaurante;
import ventanas.DError;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VRColaPedidos extends JFrame {

	private JPanel contentPane;
	private boolean abierta = true; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VRColaPedidos frame = new VRColaPedidos();
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
	private JList<Pedido> listPed; 
	
	Thread hilo = new Thread() {
		public void run() {
			while (abierta){
				actualizarlista();
				try {
					sleep(10000);//Cada 10 segundos
				} catch (InterruptedException e) {e.printStackTrace();}
			}
		}
	};
	
	public VRColaPedidos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 10));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnAtras = new JButton("Atras");
		panel.add(btnAtras, BorderLayout.WEST);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VRPrincipal vrp = new VRPrincipal();
				vrp.setVisible(true);
				dispose();
				abierta=false;
			}
		});
		
		JLabel lblTitulo = new JLabel("COLA DE PEDIDOS");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblTitulo, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 2, 5, 5));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane);
		
		listPed = new JList<Pedido>(Datos.cola(PrincipalRestaurante.idEsteRestaurante));
		scrollPane.setViewportView(listPed);
		
		JPanel panel_1 = new JPanel();
		panel_2.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 5, 5));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1);
		
		JList<Producto> listProd = new JList<Producto>();
		scrollPane_1.setViewportView(listProd);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblPrecio = new JLabel("Precio: ");
		panel_5.add(lblPrecio);
		
		JLabel lblPr = new JLabel("");
		panel_5.add(lblPr);
		
		JLabel lblDomiciliolocal = new JLabel("Dir/Local: ");
		panel_5.add(lblDomiciliolocal);
		
		JLabel lblDom = new JLabel("");
		panel_5.add(lblDom);
		
		JLabel lblHora = new JLabel("Hora: ");
		panel_5.add(lblHora);
		
		JLabel lblHo = new JLabel("");
		panel_5.add(lblHo);
		
		JLabel lblComentario = new JLabel("");
		panel_3.add(lblComentario);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.SOUTH);
		
		JButton btnTerminado = new JButton("terminado");
		panel_4.add(btnTerminado);
		btnTerminado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		    	try{
		    		Datos.terminarPedido(listPed.getSelectedValue());
		    		actualizarlista();
		    		listProd.setModel(new DefaultListModel<Producto>());
		    		lblPr.setText("");
		    		lblDom.setText("");
		    		lblHo.setText("");
		    		lblComentario.setText("");
		    	}catch(NullPointerException npe){
		    		DError de = new DError("Seleccione un pedido");
					de.setVisible(true);
		    	}
		    }
		});
		
		listPed.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		    	try{
		    		listProd.setModel(listPed.getSelectedValue().modelProductos());
		    		lblPr.setText(listPed.getSelectedValue().getCantidad()+" �");
		    		if(listPed.getSelectedValue().isDomicilio()){
		    			lblDom.setText(listPed.getSelectedValue().getDireccion());
		    		}else{
		    			lblDom.setText("local");
		    		}
		    		lblHo.setText(listPed.getSelectedValue().getHora());
		    		lblComentario.setText(listPed.getSelectedValue().getComentario());
		    	}catch(NullPointerException npe){}
		    }
		});
		
		hilo.start();
	}
	public void actualizarlista(){
		listPed.setModel(Datos.cola(PrincipalRestaurante.idEsteRestaurante));
	}

}

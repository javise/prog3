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

public class VRHistorial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VRHistorial frame = new VRHistorial();
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
	public VRHistorial() {
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
			}
		});
		
		JLabel lblHistorial = new JLabel("HISTORIAL");
		lblHistorial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHistorial.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblHistorial, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 2, 5, 5));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane);
		
		JList<Pedido> listPed = new JList<Pedido>(Datos.historial(PrincipalRestaurante.idEsteRestaurante));
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
		panel_3.setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel lblPrecio = new JLabel("Precio: ");
		panel_3.add(lblPrecio);
		
		JLabel lblPr = new JLabel("");
		panel_3.add(lblPr);
		
		JLabel lblDomiciliolocal = new JLabel("Domicilio/Local: ");
		panel_3.add(lblDomiciliolocal);
		
		JLabel lblDom = new JLabel("");
		panel_3.add(lblDom);
		
		JLabel lblHora = new JLabel("Hora: ");
		panel_3.add(lblHora);
		
		JLabel lblHo = new JLabel("");
		panel_3.add(lblHo);
		
		JLabel lblCliente = new JLabel("Cliente (id): ");
		panel_3.add(lblCliente);
		
		JLabel lblCl = new JLabel("");
		panel_3.add(lblCl);
		
		listPed.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		    	try{
		    		listProd.setModel(listPed.getSelectedValue().modelProductos());
		    		lblPr.setText(listPed.getSelectedValue().getCantidad()+" €");
		    		if(listPed.getSelectedValue().isDomicilio()){
		    			lblDom.setText("domicilio");
		    		}else{
		    			lblDom.setText("local");
		    		}
		    		lblHo.setText(listPed.getSelectedValue().getHora());
		    		lblCliente.setText(Integer.toString(listPed.getSelectedValue().getIdCliente()));
		    	}catch(NullPointerException npe){}
		    }
		});
	}

}

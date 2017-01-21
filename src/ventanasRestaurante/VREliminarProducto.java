package ventanasRestaurante;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Producto;
import gestiones.Datos;
import gestiones.PrincipalRestaurante;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VREliminarProducto extends JFrame {

	private JPanel contentPane;
	private JList<Producto> list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VREliminarProducto frame = new VREliminarProducto();
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
	public VREliminarProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 10));
		
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
		
		JLabel lblTitulo = new JLabel("ELIMINAR PRODUCTO");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblTitulo, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnEliminar = new JButton("Eliminar");
		panel_2.add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		list = new JList<Producto>(Datos.productosPorRestaurante(PrincipalRestaurante.idEsteRestaurante));
		scrollPane.setViewportView(list);
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					DEliminar de = new DEliminar(PrincipalRestaurante.idEsteRestaurante, list.getSelectedValue(), VREliminarProducto.this);
					de.setVisible(true);
				}catch(NullPointerException npe){}
			}
		});
	}
	public void actualizarlista(){
		list.setModel(Datos.productosPorRestaurante(PrincipalRestaurante.idEsteRestaurante));
	}

}

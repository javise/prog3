package ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Restaurante;
import gestiones.Datos;
import gestiones.Principal;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.BorderLayout;

public class VBusqueda extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VBusqueda frame = new VBusqueda();
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
	public VBusqueda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 0, 5, 0));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		
		JTextField textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(25);
		
		JButton btnBuscar = new JButton("Buscar");
		panel_2.add(btnBuscar);
		
		JButton btnAtras = new JButton("Atras");

		btnAtras.setBounds(20, 33, 67, 23);
		contentPane.add(btnAtras);
		panel.add(btnAtras, BorderLayout.WEST);
		
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VPrincipal newVPrincipal = new VPrincipal();
				newVPrincipal.setVisible(true);
				dispose();
			}
		});
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JList<Restaurante> listRest = new JList<Restaurante>();
		panel_1.add(listRest);
		
		listRest.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		    	try{
		    		Principal.setSelectedRest(listRest.getSelectedValue());
			    	VRestaurante vr = new VRestaurante(2);
					vr.setVisible(true);
					dispose();
		    	}catch(NullPointerException npe){}
		    }
		});
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listRest.setModel(Datos.buscarCoincidencias(textField.getText()));
			}
		});
	}
}

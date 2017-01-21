package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Restaurante;
import gestiones.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.JScrollPane;

public class VPrincipal extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VPrincipal frame = new VPrincipal();
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
	public VPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.WEST);
		
		JLabel lblTipo = new JLabel("TIPO");
		panel_4.add(lblTipo);
		
		String[] tiposStrings = { "Todos", "Americano", "Sushi", "Kebab", "Italiano", "Chino", "Pizza"};
		JComboBox<String> comboBoxTipos = new JComboBox<String>(tiposStrings);
		panel_4.add(comboBoxTipos);
		
		JButton btnBusqueda = new JButton("Busqueda");
		btnBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(btnBusqueda, BorderLayout.EAST);
		
		btnBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VBusqueda vb = new VBusqueda();
				vb.setVisible(true);
				dispose();
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblCP = new JLabel(String.valueOf(Principal.CP));
		panel_1.add(lblCP);
		
		JLabel lblNRest = new JLabel(Datos.restaurantesCercanos().size()+" restaurantes encotrados");
		lblNRest.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNRest.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(lblNRest);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane, BorderLayout.CENTER);
		
		JList<Restaurante> listRest = new JList<Restaurante>(Datos.restaurantesCercanos());
		scrollPane.setViewportView(listRest);
		listRest.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		listRest.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		    	try{
		    		Principal.setSelectedRest(listRest.getSelectedValue());
			    	VRestaurante vr = new VRestaurante(1);
					vr.setVisible(true);
					dispose();
		    	}catch(NullPointerException npe){}
		    }
		});
		
		comboBoxTipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((String)comboBoxTipos.getSelectedItem()=="Todos"){
					listRest.setModel(Datos.tipoTodos());
				}else{
					listRest.setModel(Datos.restaurantesPorTipo((String)comboBoxTipos.getSelectedItem()));
				}
				lblNRest.setText(listRest.getModel().getSize()+" restaurantes encotrados");
			}
		});
	}
}

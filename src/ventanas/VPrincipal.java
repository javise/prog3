package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;

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
		setBounds(100, 100, 503, 340);
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
		
		JComboBox comboBoxTipos = new JComboBox();
		panel_4.add(comboBoxTipos);
		
		JButton btnBusqueda = new JButton("Busqueda");
		btnBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(btnBusqueda, BorderLayout.EAST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblCP = new JLabel("*CP*");
		panel_1.add(lblCP);
		
		JLabel lblNRest = new JLabel("n restaurantes encotrados");
		lblNRest.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(lblNRest);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JList listRest = new JList();
		listRest.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel_3.add(listRest);
	}
}

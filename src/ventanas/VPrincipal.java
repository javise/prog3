package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCP = new JLabel("*CP*");
		lblCP.setBounds(10, 11, 82, 22);
		contentPane.add(lblCP);
		
		JLabel lblNRest = new JLabel("n restaurantes encotrados");
		lblNRest.setBounds(129, 15, 172, 14);
		contentPane.add(lblNRest);
		
		JLabel lblTipo = new JLabel("TIPO");
		lblTipo.setBounds(24, 55, 46, 14);
		contentPane.add(lblTipo);
		
		JComboBox comboBoxTipos = new JComboBox();
		comboBoxTipos.setBounds(56, 52, 82, 20);
		contentPane.add(comboBoxTipos);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(384, 36, 82, 36);
		contentPane.add(btnBuscar);
		
		JList listRest = new JList();
		listRest.setBounds(24, 85, 442, 198);
		contentPane.add(listRest);
	}
}

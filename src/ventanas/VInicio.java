package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gestiones.Principal;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VInicio extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VInicio frame = new VInicio();
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
	public VInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 348, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{59, 220, 0};
		gbl_contentPane.rowHeights = new int[]{48, 24, 41, 14, 24, 23, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblTitulo = new JLabel("APLICACION COMIDA RAPIDA");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.fill = GridBagConstraints.BOTH;
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitulo.gridx = 1;
		gbc_lblTitulo.gridy = 1;
		contentPane.add(lblTitulo, gbc_lblTitulo);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int cp = Integer.parseInt(textFieldCP.getText());
					Principal.setCP(cp);
					VPrincipal vp = new VPrincipal(cp);
					vp.setVisible(true);
					dispose();
				} catch (NumberFormatException nfe){
					DErrorCp decp = new DErrorCp();
					decp.setVisible(true);
				}
			}
		});
		
		JLabel lblInstruccion = new JLabel("Introduce tu codigo postal:");
		lblInstruccion.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblInstruccion = new GridBagConstraints();
		gbc_lblInstruccion.anchor = GridBagConstraints.NORTH;
		gbc_lblInstruccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblInstruccion.insets = new Insets(0, 0, 5, 0);
		gbc_lblInstruccion.gridx = 1;
		gbc_lblInstruccion.gridy = 3;
		contentPane.add(lblInstruccion, gbc_lblInstruccion);
		
		textFieldCP = new JTextField(5);
		textFieldCP.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_textFieldCP = new GridBagConstraints();
		gbc_textFieldCP.fill = GridBagConstraints.VERTICAL;
		gbc_textFieldCP.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCP.gridx = 1;
		gbc_textFieldCP.gridy = 4;
		contentPane.add(textFieldCP, gbc_textFieldCP);
		textFieldCP.setColumns(10);
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.anchor = GridBagConstraints.NORTH;
		gbc_btnAceptar.gridx = 1;
		gbc_btnAceptar.gridy = 5;
		contentPane.add(btnAceptar, gbc_btnAceptar);
	}

}

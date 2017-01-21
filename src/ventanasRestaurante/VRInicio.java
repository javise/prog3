package ventanasRestaurante;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import gestiones.PrincipalRestaurante;
import ventanas.DError;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VRInicio extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnEntrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VRInicio frame = new VRInicio();
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
	public VRInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 298, 169);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setBounds(66, 30, 149, 14);
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblContrasea);
		
		textField = new JTextField();
		textField.setBounds(66, 55, 149, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(95, 86, 89, 23);
		contentPane.add(btnEntrar);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals(PrincipalRestaurante.contraseña)){
					VRPrincipal vrp = new VRPrincipal();
					vrp.setVisible(true);
					dispose();
				}else{
					DError decp = new DError("Contraseña incorrecta");
					decp.setVisible(true);
				}
			}
		});
	}
}

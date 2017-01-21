package ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import domain.Producto;
import gestiones.Principal;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.BoxLayout;

public class DProducto extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DProducto frame = new DProducto(null, null);
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
	public DProducto(Producto p, VMenu vm) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(10, 11, 89, 23);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DProducto.this.dispose();
			}
		});
		
		JLabel lblNomProducto = new JLabel(p.getNombreProducto());
		lblNomProducto.setBounds(123, 15, 231, 14);
		contentPane.add(lblNomProducto);
		
		JPanel panel = new JPanel();
		panel.setBounds(42, 70, 222, 166);
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		ArrayList<JRadioButton> rbList = new ArrayList<JRadioButton>();
		for(String s : p.getOpciones()){
			rbList.add(new JRadioButton(s));
		}
		for(JRadioButton rb : rbList){
			buttonGroup.add(rb);
			panel.add(rb);
		}
		
		JButton btnAnadir = new JButton("Añadir");
		btnAnadir.setBounds(109, 256, 89, 23);
		contentPane.add(btnAnadir);
		
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Producto pr;
				for(JRadioButton rb : rbList){
					if(rb.isSelected()){
						//Hay que duplicar el producto p y despues modificar para que no se 
						//haga el cambio en la lista de productos original
						pr = new Producto(p);
						pr.setOpEscogida(rb.getText());
						Principal.pedidoEnCurso.anyadirProducto(pr);
					}
				}
				DProducto.this.dispose();
				vm.actualizarContador();
			}
		});
		
	}
}

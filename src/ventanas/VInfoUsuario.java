package ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Cliente;
import domain.Pedido;
import gestiones.Datos;
import gestiones.Principal;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class VInfoUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTlf;
	private JTextField txtDir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VInfoUsuario frame = new VInfoUsuario();
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
	public VInfoUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("PEDIDO - "+Principal.selectedRest.getNombre());
		label.setBounds(123, 15, 166, 14);
		contentPane.add(label);
		
		JButton button = new JButton("Atras");
		button.setBounds(10, 11, 89, 23);
		contentPane.add(button);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(36, 76, 63, 14);
		contentPane.add(lblNombre);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(36, 111, 63, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(36, 147, 63, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblHoraDeEntrega = new JLabel("Hora de entrega");
		lblHoraDeEntrega.setBounds(36, 183, 94, 14);
		contentPane.add(lblHoraDeEntrega);
		
		JLabel lblComentario = new JLabel("Comentario:");
		lblComentario.setBounds(36, 208, 94, 14);
		contentPane.add(lblComentario);
		
		JTextArea txtrComentario = new JTextArea();
		txtrComentario.setBounds(36, 233, 275, 69);
		contentPane.add(txtrComentario);
		
		String[] horas = { "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45", 
				           "14:00", "14:15", "14:30", "14:45", "15:00", "15:15", "15:30", "15:45", "16:00", "16:15", "16:30", "16:45",
				           "17:00", "17:15", "17:30", "17:45", "18:00", "18:15", "18:30", "18:45", "19:00", "19:15", "19:30", "19:45",
				           "20:00", "20:15", "20:30", "20:45", "21:00", "21:15", "21:30", "21:45", "22:00", "22:15", "22:30", "22:45",
				           "23:00", "23:15", "23:30", "23:45", "24:00", "24:30"};
		JComboBox<String> comboBoxHora = new JComboBox<String>(horas);
		comboBoxHora.setBounds(144, 180, 72, 20);
		contentPane.add(comboBoxHora);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(114, 73, 175, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTlf = new JTextField();
		txtTlf.setBounds(114, 108, 175, 20);
		contentPane.add(txtTlf);
		txtTlf.setColumns(10);
		
		txtDir = new JTextField();
		txtDir.setBounds(114, 144, 197, 20);
		contentPane.add(txtDir);
		txtDir.setColumns(10);
		
		JButton btnEnviarPedido = new JButton("Enviar Pedido");
		btnEnviarPedido.setBounds(114, 312, 111, 23);
		contentPane.add(btnEnviarPedido);
		//Se guarda en el array (imita DB) una copia del que se maneja en la aplicacion, tanto para cliente como para pedido,
		//de lo contrario la siguiente vez el objeto estaría apuntando a la misma instancia y se modificarían ambos.
		btnEnviarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.clienteActual.setNombre(txtNombre.getText());
				Principal.clienteActual.setTelefono(txtTlf.getText());
				Principal.clienteActual.setDireccion(txtDir.getText());
				Principal.pedidoEnCurso.setHora((String)comboBoxHora.getSelectedItem());
				Principal.pedidoEnCurso.setComentario(txtrComentario.getText());
				Datos.anyadirCliente(new Cliente(Principal.clienteActual));
				Datos.enviarPedido(new Pedido(Principal.pedidoEnCurso), Principal.clienteActual.getIdCliente(), Principal.selectedRest.getIdRestaurante());
				Principal.pedidoEnCurso.nuevoPedido();//Disponemos para realizar un nuevo pedido
				VPrincipal vp = new VPrincipal();
				vp.setVisible(true);
				dispose();
			}
		});
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.clienteActual.setNombre(txtNombre.getText());
				Principal.clienteActual.setTelefono(txtTlf.getText());
				Principal.clienteActual.setDireccion(txtDir.getText());
				Principal.pedidoEnCurso.setHora((String)comboBoxHora.getSelectedItem());
				Principal.pedidoEnCurso.setComentario(txtrComentario.getText());
				VPedido newPedido = new VPedido();
				newPedido.setVisible(true);
				dispose();
				
			}
		});
		
		if(Principal.clienteActual!=null){
			txtNombre.setText(Principal.clienteActual.getNombre());
			txtTlf.setText(Principal.clienteActual.getTelefono());
			txtDir.setText(Principal.clienteActual.getDireccion());
			comboBoxHora.setSelectedItem((String)Principal.pedidoEnCurso.getHora());
			txtrComentario.setText(Principal.pedidoEnCurso.getComentario());
		}else{
			Principal.clienteActual = new Cliente(); //El id se lo dará la DB
		}
	}
}

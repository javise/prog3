package ventanasRestaurante;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Producto;
import gestiones.Datos;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class DEliminar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DEliminar frame = new DEliminar(0, null, null);
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
	public DEliminar(int idR, Producto p, VREliminarProducto vrep) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 163);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEliminar = new JLabel("¿Seguro que desea eliminar "+p.toString()+"?");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setBounds(10, 23, 334, 26);
		contentPane.add(lblEliminar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(55, 76, 89, 23);
		contentPane.add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Datos.eliminarProducto(idR, p);
				vrep.actualizarlista();
				dispose();
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(204, 76, 89, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
	}

}

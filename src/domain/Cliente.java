package domain;

import java.util.ArrayList;

public class Cliente {
	
	int idCliente;
	boolean invitado;
	String nombre;
	String passwd;
	String telefono;
	String direccion;
	ArrayList<Pedido> pedidos;
	public Cliente(String nombre, String telefono, String direccion) {
		super();
		this.direccion = direccion;
		this.telefono = telefono;
		this.nombre = nombre;
		this.invitado = false;
		pedidos = null;
	}
	public Cliente() {
		super();
		this.invitado=true;
		this.nombre= "invitado";
		this.passwd= " ";
		pedidos = null;
	}
	public Cliente(Cliente c) {
		this.idCliente = c.idCliente;
		this.invitado = c.invitado;
		this.nombre = c.nombre;
		this.passwd = c.passwd;
		this.telefono = c.telefono;
		this.direccion = c.direccion;
		this.pedidos = c.pedidos;
	}
	
	public String toString() {
		return "Cliente [invitado=" + invitado + ", nombre=" + nombre + ", passwd=" + passwd + ", pedidos=" + pedidos + "]";
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	public boolean isInvitado() {
		return invitado;
	}
	public void setInvitado(boolean invitado) {
		this.invitado = invitado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


}

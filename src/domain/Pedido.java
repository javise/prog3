package domain;


import java.util.ArrayList;

import javax.swing.DefaultListModel;

import gestiones.Principal;

public class Pedido {
	ArrayList<Producto> pedido;
	double cantidad;
	private boolean domicilio = true; //f-local; t-domicilio. Por defecto a domicilio
	private boolean pendiente = true; //Por defecto esta pendiente
	private String hora;
	private String comentario;
	int idCliente;
	
	public Pedido() {
		super();
		this.pedido= new ArrayList<Producto>();
		this.cantidad = 0.00;
	}
	public void nuevoPedido() {
		this.pedido.clear();
		this.cantidad = 0.00;
		this.domicilio = true;
		this.hora = "";
		this.comentario = "";
	}
	
	public boolean isPendiente() {
		return pendiente;
	}
	public void setPendiente(boolean pendiente) {
		this.pendiente = pendiente;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public boolean isDomicilio() {
		return domicilio;
	}
	public void setDomicilio(boolean domicilio) {
		this.domicilio = domicilio;
	}
	public void anyadirProducto(Producto p) {
		this.pedido.add(p);
		this.cantidad = this.cantidad + p.getPrecio();
	}
	public void quitarProducto(Producto p) {
		this.pedido.remove(p);
		this.cantidad = this.cantidad - p.getPrecio();
	}
	public double calcularCuenta(){
		cantidad = 0.0;
		for(int i=0; i<pedido.size(); i++)
			this.cantidad= this.cantidad + pedido.get(i).precio;
		return cantidad;
	}
	public ArrayList<Producto> getPedido() {
		return pedido;
	}
	public void setPedido(ArrayList<Producto> pedido) {
		this.pedido = pedido;
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	public DefaultListModel<Producto> modelProductos() {
		DefaultListModel<Producto> listProductos = new DefaultListModel<Producto>();
		for ( Producto p : pedido ) {
			listProductos.addElement(p);
		}
		return listProductos;
	}
}

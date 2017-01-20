package domain;


import java.util.ArrayList;

import javax.swing.DefaultListModel;

import gestiones.Principal;

public class Pedido {
	ArrayList<Producto> pedido;
	double cantidad;
	
	public Pedido() {
		super();
		this.pedido= new ArrayList<Producto>();
		this.cantidad = 0.00;
	}
	public void nuevoPedido() {
		this.pedido.clear();
		this.cantidad = 0.00;
	}
	public void anyadirProducto(Producto p) {
		this.pedido.add(p);
		this.cantidad = this.cantidad + p.getPrecio();
	}
	public void quitarProducto(Producto p) {
		this.pedido.remove(p);
		this.cantidad = this.cantidad - p.getPrecio();
	}
	/*
	public double calcularCuenta(){
		cantidad = 0.0;
		for(int i=0; i<pedido.size(); i++)
			this.cantidad= this.cantidad + pedido.get(i).precio;
		return cantidad;
	}
	*/
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

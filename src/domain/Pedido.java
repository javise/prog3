package domain;


import java.util.ArrayList;

public class Pedido {
	ArrayList<Producto> pedido;
	double cantidad;
	public Pedido() {
		super();
		this.pedido=null;
		this.cantidad = 0.00;
	}
	public void calcularCuenta(){
		for(int i=0; i<pedido.size(); i++)
			this.cantidad= this.cantidad + pedido.get(i).precio;
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
}

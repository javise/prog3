package domain;


import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class Pedido {
	private ArrayList<Producto> pedido;
	private double cantidad;
	private boolean domicilio = true; //f-local; t-domicilio. Por defecto a domicilio
	private boolean pendiente = true; //Por defecto esta pendiente
	private String hora;
	private String comentario;
	private String direccion;
	private int idCliente;
	private int idRestaurante;
	
	public Pedido() {
		super();
		this.pedido= new ArrayList<Producto>();
		this.cantidad = 0.00;
	}
	public void nuevoPedido() {
		this.pedido.clear();
		this.cantidad = 0.00;
		this.domicilio = true;
		this.pendiente = true;
		this.hora = "";
		this.comentario = "";
		this.direccion = "";
	}
	
	public Pedido(Pedido pedido) { //Metodo para duplicar un pedido
		this.pedido = new ArrayList<Producto>(pedido.pedido);
		this.cantidad = pedido.cantidad;
		this.domicilio = pedido.domicilio;
		this.pendiente = pedido.pendiente;
		this.hora = pedido.hora;
		this.comentario = pedido.comentario;
		this.idCliente = pedido.idCliente;
		this.idRestaurante = pedido.idRestaurante;
		this.direccion = pedido.direccion;
	}
	
	public String toString() {
		return "cliente: "+this.idCliente+" ("+this.hora+")";
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getIdRestaurante() {
		return idRestaurante;
	}
	public void setIdRestaurante(int idRestaurante) {
		this.idRestaurante = idRestaurante;
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
			this.cantidad= this.cantidad + pedido.get(i).getPrecio();
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

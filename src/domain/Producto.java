package domain;

import java.util.ArrayList;

import gestiones.Principal;

public class Producto {

	String NombreProducto;
	String ClaveProducto;
	String descripcion;
	boolean elegible;
	String opEscogida="";
	ArrayList<String> opciones;
	double precio;
	
	public Producto(String nombreProducto, String claveProducto, double precio, String descripcion) {
		super();
		this.elegible = false;
		this.descripcion = descripcion;
		this.NombreProducto = nombreProducto;
		this.ClaveProducto = claveProducto;
		this.precio = precio;
	}
	
	//Producto con opciones
	public Producto(String nombreProducto, String claveProducto, double precio, String descripcion, ArrayList<String> opciones) {
		super();
		this.opciones = opciones;
		this.elegible = true;
		this.descripcion = descripcion;
		this.NombreProducto = nombreProducto;
		this.ClaveProducto = claveProducto;
		this.precio = precio;
	}
	
	public Producto(Producto p) { //Metodo para duplicar un producto
		super();
		this.opciones = p.opciones;
		this.elegible = p.elegible;
		this.descripcion = p.descripcion;
		this.NombreProducto = p.NombreProducto;
		this.ClaveProducto = p.ClaveProducto;
		this.precio = p.precio;
	}
	
	public String getOpEscogida() {
		return opEscogida;
	}

	public void setOpEscogida(String opEscogida) {
		this.opEscogida = opEscogida;
	}

	public boolean isElegible() {
		return elegible;
	}

	public ArrayList<String> getOpciones() {
		return opciones;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreProducto() {
		return NombreProducto;
	}
	
	public void setNombreProducto(String nombreProducto) {
		NombreProducto = nombreProducto;
	}
	
	public String getClaveProducto() {
		return ClaveProducto;
	}
	
	public void setClaveProducto(String claveProducto) {
		ClaveProducto = claveProducto;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public String toString() {
		return NombreProducto+" "+opEscogida;
	}

}

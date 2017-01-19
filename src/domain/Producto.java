package domain;

import gestiones.Principal;

public class Producto {

	String NombreProducto;
	String ClaveProducto;
	String descripcion;
	double precio;
	
	public Producto(String nombreProducto, String claveProducto, double precio, String descripcion) {
		super();
		this.descripcion = descripcion;
		this.NombreProducto = nombreProducto;
		this.ClaveProducto = claveProducto;
		this.precio = precio;
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
		return NombreProducto;
	}

}

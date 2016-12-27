package domain;

public class Producto {
	String NombreProducto;
	String ClaveProducto;
	double precio;
	
	public Producto(String nombreProducto, String claveProducto, double precio) {
		super();
		NombreProducto = nombreProducto;
		ClaveProducto = claveProducto;
		this.precio = precio;
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

}

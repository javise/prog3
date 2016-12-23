package domain;

public class Producto {
String NombreProducto;
String ClavePreducto;
double precio;

public Producto(String nombreProducto, String clavePreducto, double precio) {
	super();
	NombreProducto = nombreProducto;
	ClavePreducto = clavePreducto;
	this.precio = precio;
}

public String getNombreProducto() {
	return NombreProducto;
}

public void setNombreProducto(String nombreProducto) {
	NombreProducto = nombreProducto;
}

public String getClavePreducto() {
	return ClavePreducto;
}

public void setClavePreducto(String clavePreducto) {
	ClavePreducto = clavePreducto;
}

public double getPrecio() {
	return precio;
}

public void setPrecio(double precio) {
	this.precio = precio;
}

}

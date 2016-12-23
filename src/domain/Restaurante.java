package domain;

import java.util.HashMap;

public class Restaurante {
String nombre;
Menu menu;
HashMap< Cliente, Pedido> Clientepedido; 
public HashMap<Cliente, Pedido> getClientepedido() {
	return Clientepedido;
}
public void setClientepedido(HashMap<Cliente, Pedido> clientepedido) {
	Clientepedido = clientepedido;
}
public Restaurante(String nombre, Menu menu) {
	super();
	this.nombre = nombre;
	this.menu = menu;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public Menu getMenu() {
	return menu;
}
public void setMenu(Menu menu) {
	this.menu = menu;
}

}

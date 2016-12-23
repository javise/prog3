package domain;

import java.util.ArrayList;

public class Cliente {
boolean invitado;
String nombre;
String passwd;
ArrayList<Pedido> pedidos;
public Cliente(String nombre, String passwd) {
	super();
	this.nombre = nombre;
	this.passwd = passwd;
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
@Override
public String toString() {
	return "Cliente [invitado=" + invitado + ", nombre=" + nombre + ", passwd=" + passwd + ", pedidos=" + pedidos + "]";
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

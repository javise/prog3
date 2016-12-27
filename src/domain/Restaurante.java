package domain;

import java.util.HashMap;

public class Restaurante {
	
	int idRestaurante;
	int CodPost;
	String nombre;
	String resumen;
	String desc;
	Menu menu;
	HashMap< Cliente, Pedido> Clientepedido; 
	public HashMap<Cliente, Pedido> getClientepedido() {
		return Clientepedido;
	}
	public void setClientepedido(HashMap<Cliente, Pedido> clientepedido) {
		Clientepedido = clientepedido;
	}
	public Restaurante(int idRestaurante, int CodPost, String nombre) {
		super();
		this.idRestaurante = idRestaurante;
		this.CodPost = CodPost;
		this.nombre = nombre;
	}
	
	public Restaurante(int idRestaurante, int CodPost, String nombre, Menu menu, String resumen, String desc) {
		super();
		this.idRestaurante = idRestaurante;
		this.CodPost = CodPost;
		this.nombre = nombre;
		this.menu = menu;
		this.resumen = resumen;
		this.desc = desc;
	}
	
	public String getResumen() {
		return resumen;
	}
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getIdRestaurante() {
		return idRestaurante;
	}
	public void setIdRestaurante(int idRestaurante) {
		this.idRestaurante = idRestaurante;
	}
	public int getCodPost() {
		return CodPost;
	}
	public void setCodPost(int codPost) {
		CodPost = codPost;
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
	public String toString() {
		return nombre;
	}

}

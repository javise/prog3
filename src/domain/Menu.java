package domain;

import java.util.ArrayList;

public class Menu {
ArrayList<Producto> listProductos;

	public Menu() {
		this.listProductos = new ArrayList<Producto>();
	}
	public void anyadir(Producto p){
		listProductos.add(p);
	}
	public ArrayList<Producto> getListProductos() {
		return listProductos;
	}
	public void setListProductos(ArrayList<Producto> listProductos) {
		this.listProductos = listProductos;
	}
}

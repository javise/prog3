package domain;

import java.util.ArrayList;

public class Menu {
ArrayList<Producto> listProductos;

public Menu() {
	this.listProductos=null;
}
public void anyadir(Producto p){
	int i=0;
	while(this.listProductos.get(i)!=null)
		i++;
	listProductos.add(p);
}
public ArrayList<Producto> getListProductos() {
	return listProductos;
}
public void setListProductos(ArrayList<Producto> listProductos) {
	this.listProductos = listProductos;
}
}

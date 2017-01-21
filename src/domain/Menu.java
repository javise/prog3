package domain;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultListModel;

public class Menu {
	//El menu esta dividido en categorias: HashMap <categoria, lista de productos>
	private HashMap<String, ArrayList<Producto>> listProductos;

	public Menu() {
		this.listProductos =  new HashMap<String, ArrayList<Producto>>();
	}
	
	public HashMap<String, ArrayList<Producto>> getHashMap(){
		return listProductos;
	}
	
	public void anyadirProducto(Producto p, String cat){
		if(listProductos.get(cat)==null){
			listProductos.put(cat, new  ArrayList<Producto>());
		}
		listProductos.get(cat).add(p);
	}
	
	public ArrayList<Producto> getListProductos(String cat) {
		return listProductos.get(cat);
	}
	
	public DefaultListModel<String> categorias() {
		DefaultListModel<String> listCategorias = new DefaultListModel<String>();
		for ( String cat : listProductos.keySet() ) {
			listCategorias.addElement(cat);
		}
		return listCategorias;
	}
	
	public DefaultListModel<Producto> productosPorCategoria(String cat) {
		DefaultListModel<Producto> modelProdCat = new DefaultListModel<Producto>();
		for(Producto p : listProductos.get(cat)){
			modelProdCat.addElement(p);
	    }
		return modelProdCat;
	}
	
	public void setListProductos(ArrayList<Producto> listPr, String cat) {
		this.listProductos.replace(cat, listPr);
	}
}

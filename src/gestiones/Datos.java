package gestiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import domain.Menu;
import domain.Producto;
import domain.Restaurante;

import java.lang.Class;

public class Datos {
	
	private static ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();//Lo que ser�a la BD
	private static DefaultListModel<Restaurante> restCercanos;
	
	public static void datosEjemplo(){ //Utilizado en el constructor de VInicio para trabajar con datos de ejemplo
		String d = "Un restaurante nacido el 1985 con exquisitos productos de primera calidad y el puro sabor americano";
		restaurantes.add(new Restaurante(1, 0, "r2", null, null, null));
		restaurantes.add(new Restaurante(2, 0, "r3", null, null, null));
		restaurantes.add(new Restaurante(3, 0, "r4", null, null, null));
		restaurantes.add(new Restaurante(4, 1, "Ribs", null, "Americano", d));
		restaurantes.add(new Restaurante(0, 1, "Foster's Hollywood", null, "Americano", ""));
		restaurantes.add(new Restaurante(5, 1, "New York Dinner", null, "Americano", ""));
		restaurantes.add(new Restaurante(6, 1, "Crazy Horse", null, "Americano", ""));
		restaurantes.add(new Restaurante(7, 1, "Florida", null, "Americano", ""));
		restaurantes.add(new Restaurante(8, 1, "Deluxe", null, "Americano", ""));
		restaurantes.add(new Restaurante(9, 1, "Don Angelo", null, "Italiano", ""));
		restaurantes.add(new Restaurante(10, 1, " La Tagliatella", null, "Italiano", ""));
		restaurantes.add(new Restaurante(11, 1, "Sumo", null, "Sushi", ""));
		restaurantes.add(new Restaurante(12, 1, "Sushi Artist", null, "Sushi", ""));
		restaurantes.add(new Restaurante(13, 1, "Miu", null, "Sushi", ""));
	}
	
	//Imita la toma de datos de la BD considerando que los datos de los menus son demasiados para leerlos desde
	//el principio y se piden solo los datos del menu necesitado en el constructor de la ventana VMenu
	public static void leerMenu() {
		Menu m = new Menu();
		m.anyadirProducto(new Producto("pizza jamon", null, 7, "pizza jamon descripcion"), "Pizza");
		m.anyadirProducto(new Producto("pizza 4 quesos", null, 8, "pizza 4 quesos descripcion"), "Pizza");
		m.anyadirProducto(new Producto("pizza carbonara", null, 8, "pizza carbonara descripcion"), "Pizza");
		m.anyadirProducto(new Producto("hamburguesa", null, 5, "hamburguesa con queso"), "Burguer");
		m.anyadirProducto(new Producto("sandwich vegetal", null, 3, "sandwich de tomate, lechuga y huevo"), "Sandwich");
		m.anyadirProducto(new Producto("sandwich mixto", null, 3, "sandwich de jamon y queso"), "Sandwich");
		Principal.selectedRest.setMenu(m);
	}
	
	public static DefaultListModel<Restaurante> restaurantesCercanos() {
		restCercanos = new DefaultListModel<Restaurante>();
		for(int i=0; i<restaurantes.size(); i++) {
			if(restaurantes.get(i).getCodPost() == Principal.CP){
				restCercanos.addElement(restaurantes.get(i));
			}
		}
		return restCercanos;
	}
	
	public static DefaultListModel<Restaurante> tipoTodos() {
		return restCercanos;
	}
	
	public static DefaultListModel<Restaurante> restaurantesPorTipo(String tipo) {
		DefaultListModel<Restaurante> restTipo = new DefaultListModel<Restaurante>();
		for(int i=0; i<restCercanos.size(); i++) {
			if(restCercanos.get(i).getTipo() == tipo){
				restTipo.addElement(restCercanos.get(i));
			}
		}
		return restTipo;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
    	Connection con = DriverManager.getConnection("jdbc:sqlite:n.db");
    }

}

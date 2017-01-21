package gestiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultListModel;

import domain.Cliente;
import domain.Menu;
import domain.Pedido;
import domain.Producto;
import domain.Restaurante;

import java.lang.Class;

public class Datos {
	
	private static ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();//La tabla restaurante en la DB
	private static DefaultListModel<Restaurante> restCercanos;
	private static ArrayList<Pedido> pedidos = new ArrayList<Pedido>(); //La tabla pedidos en la DB
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>(); //La tabla clientes en la DB
	
	public static void datosEjemplo(){ //Utilizado en el constructor de VInicio para trabajar con datos de ejemplo
		String d = "Un restaurante nacido el 1985 con exquisitos productos de primera calidad y el puro sabor americano";
		restaurantes.add(new Restaurante(1, 0, "r2", null, null, null, 0));
		restaurantes.add(new Restaurante(2, 0, "r3", null, null, null, 0));
		restaurantes.add(new Restaurante(3, 0, "r4", null, null, null, 0));
		restaurantes.add(new Restaurante(4, 1, "Ribs", null, "Americano", d, 2.5));
		restaurantes.add(new Restaurante(0, 1, "Foster's Hollywood", null, "Americano", "", 0));
		restaurantes.add(new Restaurante(5, 1, "New York Dinner", null, "Americano", "", 0));
		restaurantes.add(new Restaurante(6, 1, "Crazy Horse", null, "Americano", "", 0));
		restaurantes.add(new Restaurante(7, 1, "Florida", null, "Americano", "", 0));
		restaurantes.add(new Restaurante(8, 1, "Deluxe", null, "Americano", "", 0));
		restaurantes.add(new Restaurante(9, 1, "Don Angelo", null, "Italiano", "", 0));
		restaurantes.add(new Restaurante(10, 1, " La Tagliatella", null, "Italiano", "", 0));
		restaurantes.add(new Restaurante(11, 1, "Sumo", null, "Sushi", "", 0));
		restaurantes.add(new Restaurante(12, 1, "Sushi Artist", null, "Sushi", "", 0));
		restaurantes.add(new Restaurante(13, 1, "Miu", null, "Sushi", "", 0));
	}
	
	public static void enviarPedido(Pedido pe, Cliente c){
		pe.setIdCliente(c.getIdCliente());
		pedidos.add(pe);
	}
	
	public static void anyadirCliente(Cliente c){
		if(c.isInvitado()){
			c.setInvitado(false);//Cuando se registra deja de ser invitado
			clientes.add(c);
		}
	}
	
	//Imita la toma de datos de la BD considerando que los datos de los menus son demasiados para leerlos desde
	//el principio y se piden solo los datos del menu necesitado en el constructor de la ventana VMenu
	//Cada menu es una tabla parte en la DB identificada con el id del restaurante al que pertenece
	public static void leerMenu(int idR) {
		switch(idR){
		case 4:
			Menu m = new Menu();
			m.anyadirProducto(new Producto("pizza jamon", 7, "pizza jamon descripcion"), "Pizza");
			m.anyadirProducto(new Producto("pizza 4 quesos", 8, "pizza 4 quesos descripcion"), "Pizza");
			m.anyadirProducto(new Producto("pizza carbonara", 8, "pizza carbonara descripcion"), "Pizza");
			m.anyadirProducto(new Producto("hamburguesa", 5, "hamburguesa con queso", new ArrayList<String>(Arrays.asList("Vacuno", "Pollo", "Vegana"))), "Burguer");
			m.anyadirProducto(new Producto("sandwich vegetal", 3, "sandwich de tomate, lechuga y huevo"), "Sandwich");
			m.anyadirProducto(new Producto("sandwich mixto", 3, "sandwich de jamon y queso"), "Sandwich");
			Principal.selectedRest.setMenu(m);
		}
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
	
	public static DefaultListModel<Restaurante> buscarCoincidencias(String trozo) {
		DefaultListModel<Restaurante> restCoinciden = new DefaultListModel<Restaurante>();
		for(int i=0; i<restCercanos.size(); i++) {
			if(restCercanos.getElementAt(i).getNombre().indexOf(trozo) != -1){
				restCoinciden.addElement(restCercanos.get(i));
			}
		}
		return restCoinciden;
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

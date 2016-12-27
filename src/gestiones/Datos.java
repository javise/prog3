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
	
	static ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();
	
	public static void datosEjemplo(){ //Utilizado en el constructor de VInicio para trabajar con datos de ejemplo
		Menu m = new Menu();
		m.anyadir(new Producto("pizza", null, 8));
		m.anyadir(new Producto("hamburguesa", null, 5));
		m.anyadir(new Producto("sandwich", null, 3));
		String d = "Un restaurante nacido el 1985 con exquisitos productos de primera calidad y el puro sabor americano";
		restaurantes.add(new Restaurante(0, 1, "r1", m, "Restaurante Americano", d));
		restaurantes.add(new Restaurante(1, 0, "r2", null, null, null));
		restaurantes.add(new Restaurante(2, 0, "r3", null, null, null));
		restaurantes.add(new Restaurante(3, 0, "r4", null, null, null));
	}
	
	public static DefaultListModel<Restaurante> restaurantesCercanos() {
		DefaultListModel<Restaurante> restCercanos = new DefaultListModel<Restaurante>();
		for(int i=0; i<restaurantes.size(); i++) {
			if(restaurantes.get(i).getCodPost() == Principal.CP){
				restCercanos.addElement(restaurantes.get(i));
			}
		}
		return restCercanos;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
    	Connection con = DriverManager.getConnection("jdbc:sqlite:n.db");
    }

}

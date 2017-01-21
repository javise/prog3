/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiones;

import java.util.ArrayList;

import domain.Pedido;
import domain.Restaurante;
import ventanasRestaurante.VRInicio;

public class PrincipalRestaurante {
	
	public static Restaurante esteRestaurante;
	public static ArrayList<Pedido> colaPedidos = new ArrayList<Pedido>();
	public static String contraseña="1111";
	
	public static void main(String[] args) {
    	VRInicio ventanaRInicio = new VRInicio();
    	ventanaRInicio.setVisible(true);
    }
    
    
    
}

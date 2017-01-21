/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiones;

import domain.Cliente;
import domain.Pedido;
import domain.Restaurante;
import ventanas.VInicio;

public class Principal {
	
	public static Restaurante selectedRest;
	public static Pedido pedidoEnCurso;
	public static Cliente clienteActual;
	public static int CP;
	
	public static void setCP(int cP) {
		CP = cP;
	}
	
	public static void setSelectedRest(Restaurante r) {
		selectedRest = r;
	}

	public static void main(String[] args) {
    	VInicio ventanaInicio = new VInicio();
    	ventanaInicio.setVisible(true);
    }
    
    
    
}

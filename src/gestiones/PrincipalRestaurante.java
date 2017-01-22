/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiones;

import ventanasRestaurante.VRInicio;

public class PrincipalRestaurante {
	
	public static int idEsteRestaurante = 4;
	public static String contraseña="1111";
	
	public PrincipalRestaurante(){
		VRInicio ventanaRInicio = new VRInicio();
    	ventanaRInicio.setVisible(true);
	}
	
	public static void main(String[] args) {
		Datos.datosEjemplo();
    	VRInicio ventanaRInicio = new VRInicio();
    	ventanaRInicio.setVisible(true);
    }
    
}

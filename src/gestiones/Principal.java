/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiones;

import ventanas.VInicio;

public class Principal {
	
	public static int CP;

    public int getCP() {
		return CP;
	}

	public static void setCP(int cP) {
		CP = cP;
	}

	public static void main(String[] args) {
    	VInicio ventanaInicio = new VInicio();
    	ventanaInicio.setVisible(true);
    }
    
    
    
}

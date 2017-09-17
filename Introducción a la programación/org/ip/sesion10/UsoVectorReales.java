package org.ip.sesion10;

import org.ip.entradaInteractiva.EntradaInteractiva;

public class UsoVectorReales {
	public static void main(String[] args) {
		// Declaraci�n de variables
		VectorReales v1 = null; // vector v1
		VectorReales v2 = null; // vector v2
		VectorReales vRes = null; // vector para almacenar resultados
		int dim; // dimensi�n de los vectores
		System.out.println("Introduzca el valorde la dimensi�n:");
		dim = EntradaInteractiva.leerEntero();
		v1 = new VectorReales(dim);
		v2 = new VectorReales(dim);
		System.out.println("Vamos a realizar operaciones con "
				+ VectorReales.getNumVectores() + " vectores");
		// operaci�n sumar
		vRes = v1.sumar(v2);
		System.out.println("v1+v2 = " + vRes.toString());
		
		// operaci�n restar 
		vRes = v1.restar(v2);
		System.out.println("v1-v2 = " + vRes.toString());
		
		vRes = v2.restar(v1);
		System.out.println("v2-v1 = " + vRes.toString()); 
		
		 // m�dulo de v1 
		System.out.println("|v1| = " + v1.norma()); 
		
		// producto de un vector por un escalar 
		System.out.println("10v1 = " + v1.productoEscalar(10));
		
		// producto escalar de dos vectores v1v2
		 System.out.println("v1v2 = " + v1.productoEscalar(v2));
		 
		 
		// distancia entre 2 vectores 
		 System.out.println("dist(v1,v2) = " +v1.distancia(v2)); 
		 System.out.println("dist(v2,v1) = " +v2.distancia(v1));
		 
		 // �ngulo entre 2 vectores
		  System.out.println("angulo(v1,v2) = " + v1.angulo(v2));
		  System.out.println("angulo(v2,v1) = " + v2.angulo(v1));
		 
	}
}
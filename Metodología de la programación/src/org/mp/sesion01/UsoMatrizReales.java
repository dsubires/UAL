package org.mp.sesion01;

import org.mp.entradaInteractiva.EntradaInteractiva;

// TODO: Auto-generated Javadoc
/**
 * The Class UsoMatrizReales.
 */
public class UsoMatrizReales {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
	
System.out.print("Introduzca el valor de la 1ª Dimensión: ");		
int dim1 = EntradaInteractiva.leerEntero();
System.out.print("Introduzca el valor de la 2ª Dimensión: ");
int dim2 = EntradaInteractiva.leerEntero();
long tI, tF;
MatrizReales m1 = new MatrizReales(dim1,dim2);
MatrizReales m2 = new MatrizReales(dim1,dim2);
MatrizReales mR = null;
System.out.println("m1: \n" + m1);
System.out.println("m2: \n" + m2);
tI = System.nanoTime();
mR = m1.sumar(m2);
tF = System.nanoTime();
System.out.println("m1+m2 = \n" + mR);
System.out.println("\n\t Operación suma realizada en " + (tF-tI) + " ns\n");
tI = System.nanoTime();
mR = m1.restar(m2);
tF = System.nanoTime();
System.out.println("m1-m2 = \n" + mR);
System.out.println("\n\t Operación resta realizada en " + (tF-tI) + " ns\n");
System.out.println("\nEl método clone() " + (m1.equals(m1.clone())?"SI":"NO") +" funciona correctamente");
}
}
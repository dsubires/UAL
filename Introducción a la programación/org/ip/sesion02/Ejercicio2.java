package org.ip.sesion02;

public class Ejercicio2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, a, b, c;
		i = 8;
		a = i;
		b = i++;
		c = i;
		System.out.println("\t\tAntes \tDurante\tDespues");
		System.out.println("Operador i++ \t  "+ a +"\t   " + b + "\t   " + c);
		i = 8;
		a = i;
		b = i--;
		c = i;		
		System.out.println("Operador i-- \t  "+ a +"\t   " + b + "\t   " + c);
		i = 8;
		a = i;
		b = ++i;
		c = i;		
		System.out.println("Operador ++i \t  "+ a +"\t   " + b + "\t   " + c);
		i = 8;
		a = i;
		b = --i;
		c = i;		
		System.out.println("Operador --i \t  "+ a +"\t   " + b + "\t   " + c);
		
	}

}

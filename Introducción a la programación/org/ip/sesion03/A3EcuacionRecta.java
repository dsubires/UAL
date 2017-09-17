package org.ip.sesion03;

import org.ip.entradaInteractiva.EntradaInteractiva;

public class A3EcuacionRecta {
	public static void main(String[] args) {
		// DECLARACI�N DE VARIABLES
		int x1, y1, x2, y2;
		double a, b;
		String y;
		// INTRODUCCI�N DE DATOS POR TECLADO
		System.out.println("Programa Ecuaci�n Recta");
		System.out.println("Introduce los puntos (x1,y1) (x2,y2)");
		System.out.print("x1: ");
		x1 = EntradaInteractiva.leerEntero();
		System.out.print("y1: ");
		y1 = EntradaInteractiva.leerEntero();
		System.out.print("x2: ");
		x2 = EntradaInteractiva.leerEntero();
		System.out.print("y2: ");
		y2 = EntradaInteractiva.leerEntero();
		// OPERACIONES E IMPRESI�N POR PANTALLA DEL RESULTADO
		if (x1 == x2) {
			System.out.println("Para x1 = x2 la ecuaci�n no tiene resultado.");
		} else {
			a = (y2 - y1) / (x2 - x1);
			b = y1 - x1 * ((y2 - y1) / (x2 - x1));
			y = a + "x+" + b;
			System.out.println("La ecuaci�n que pasa por la recta: P1=(" + x1
					+ "," + y1 + ") y P2=(" + x2 + "," + y2 + ") es:");
			System.out.println(y);
		}

	}

}

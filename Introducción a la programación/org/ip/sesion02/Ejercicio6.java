package org.ip.sesion02;

import org.ip.entradaInteractiva.*;

public class Ejercicio6 {

	/**
	 * Esta sería la primera parte del ejercicio, en la que solo se introducía
	 * un número
	 * 
	 * System.out.println("Programa genere un número aleatorio entre 0 y N-1:");
	 * int num; System.out.println(
	 * "Escribe un número (n) para generar un aleatorio entre n-1 y 0:"); num =
	 * EntradaInteractiva.leerEntero(); --num;
	 * System.out.println("Número aleatorio entre "+num+" y 0:\t"+
	 * Math.random()*num+0);
	 */

	public static void main(String[] args) {
		System.out
				.println("Programa que genera un número aleatorio entre n y m:");

		// Declaración de variables
		int aleatorio1, aleatorio2;

		// Entrada de datos por teclado
		System.out
				.println("Escribe dos números (n y m) para generar uno aleatorio entre ambos:");
		aleatorio1 = EntradaInteractiva.leerEntero();
		aleatorio2 = EntradaInteractiva.leerEntero();
		int aleatorio = (int) (Math.random() * (aleatorio1 - aleatorio2 + 1) + aleatorio2);
		System.out.println("Número aleatorio entre " + aleatorio1 + " y "
				+ aleatorio2 + ":\t" + aleatorio);

	}

}

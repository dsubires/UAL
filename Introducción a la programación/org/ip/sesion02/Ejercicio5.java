package org.ip.sesion02;

import org.ip.entradaInteractiva.*;

public class Ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out
				.println("Programa para calcular el enfriamiento del viento (w) usando la fórmula del National Weather Service:");

		// Declaración de variables
		int temp, viento;

		// Entrada de datos por teclado
		System.out.println("Escribe la temperatura (º fahrenheit)");
		temp = EntradaInteractiva.leerEntero();
		System.out.println("Escribe la velocidad del viento");
		viento = EntradaInteractiva.leerEntero();

		// Resolución e impresión de datos
		System.out
				.println("A una temperatura de:\t\t" + temp + "º(fahrenheit)");
		System.out.println("Y con la velocidad del viento a:\t" + viento
				+ "(millas por hora)");
		System.out.println("El enfriamiento del viento sería de:\t"
				+ (35.74 + 0.6215 * temp + (0.4275 * temp - 35.75)
						* Math.pow(viento, 0.16)));
	}

}

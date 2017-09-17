package org.ip.sesion02;

import org.ip.entradaInteractiva.*;

public class Ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out
				.println("Programa para calcular el enfriamiento del viento (w) usando la f�rmula del National Weather Service:");

		// Declaraci�n de variables
		int temp, viento;

		// Entrada de datos por teclado
		System.out.println("Escribe la temperatura (� fahrenheit)");
		temp = EntradaInteractiva.leerEntero();
		System.out.println("Escribe la velocidad del viento");
		viento = EntradaInteractiva.leerEntero();

		// Resoluci�n e impresi�n de datos
		System.out
				.println("A una temperatura de:\t\t" + temp + "�(fahrenheit)");
		System.out.println("Y con la velocidad del viento a:\t" + viento
				+ "(millas por hora)");
		System.out.println("El enfriamiento del viento ser�a de:\t"
				+ (35.74 + 0.6215 * temp + (0.4275 * temp - 35.75)
						* Math.pow(viento, 0.16)));
	}

}

package org.ip.sesion03;

import org.ip.entradaInteractiva.EntradaInteractiva;

public class A5isbn {
	public static void main(String[] args) {

		// Variables
		double precio;
		int isbn, ultimo, primero, tamanio;
		String isbn2;
		boolean restriccion;

		// Introduccion de ISBN por teclado
		System.out.println("Programa para cálcular el precio de los libros");
		System.out.print("Introduce el ISBN: ");
		isbn = EntradaInteractiva.leerEntero();

		// Comprobar que ISBN cumple la restricción [1,10.000]
		restriccion = isbn >= 1 && isbn <= 10000;
		if (!restriccion) {
			System.out
					.println("El ISBN debe estar entre el rango [1 , 10 000]");
			System.exit(0);
		}
		// Obtener el primer y el último dígito del ISBN
		isbn2 = isbn + "";
		tamanio = isbn2.length();
		ultimo = isbn % 10;
		primero = isbn / Double.valueOf(Math.pow(10, tamanio - 1)).intValue();

		// Condiciones para calcular el precio del libro

		if (ultimo == 1) {
			if (primero == 2) {
				precio = 25;
			} else {
				precio = 15;
			}
		} else {
			precio = 22;
		}

		if (isbn % 7 == 0) {
			precio = precio * 1.2;
		}
		if (isbn % 2 == 0) {
			precio = precio + 13;
		}

		if (precio > 30) {
			precio = precio * 0.9;
		}

		System.out.println("El precio del libro con ISBN " + isbn + " es: "
				+ precio);
	}

}

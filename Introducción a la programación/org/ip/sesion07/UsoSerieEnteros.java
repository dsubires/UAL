package org.ip.sesion07;

import org.ip.entradaInteractiva.EntradaInteractiva;

public class UsoSerieEnteros {
	public static void main(String[] args) {
		int numero = 0;
		SerieEnteros serie = null;
		System.out.print("Introduzca el valor máximo de la serie:");
		numero = EntradaInteractiva.leerEntero();
		serie = new SerieEnteros(numero);
		System.out.println("La serie estudiada es: " + serie.toString());
		System.out.println("Sumatoria = " + serie.calcularSum());
		System.out.println("Productorio = " + serie.calcularProd());
		System.out.println("Sum. Pares = " + serie.calcularSumPares());
		System.out.println("Sum. Impares = " + serie.calcularSumImpares());
	}
}
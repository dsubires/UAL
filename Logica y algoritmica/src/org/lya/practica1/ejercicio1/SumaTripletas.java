package org.lya.practica1.ejercicio1;

import java.util.Arrays;
import java.util.LinkedList;

import org.lya.utilidades.ControlTime;
import org.lya.utilidades.EntradaInteractiva;

/**
 * 
 * @author David Subires Parra
 * 
 */
public class SumaTripletas {

	private static LinkedList<String> tripletas;

	/**
	 * Metodo estatico que calcula el numero de tripletas existentes dentro de
	 * una secuencia de enteros
	 * 
	 * @param s
	 *            Secuencia de enteros
	 * @return Numero de tripletas
	 */
	public static int tripletaSumCount(SecuenciaEnteros s) {
		tripletas = new LinkedList<String>();
		int[] elementos = s.getElementos();
		int n = elementos.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					if (elementos[i] + elementos[j] + elementos[k] == 0) {
						count++;
					}
				}
			}
		}
		return count;
	}

	/**
	 * Metodo estatico que almacena en nuestra LinkedList todas las tripletas
	 * existentes dentro de SecuenciaEnteros
	 * 
	 * @param s
	 *            Secuencia de enteros
	 */
	public static LinkedList<String> tripletaSumShow(SecuenciaEnteros s) {
		tripletas = new LinkedList<String>();
		int[] elementos = s.getElementos();
		int n = elementos.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					if (elementos[i] + elementos[j] + elementos[k] == 0) {
						tripletas.add(elementos[i] + " + " + elementos[j]
								+ " + " + elementos[k] + " = 0\n");
					}
				}
			}
		}
		return tripletas;
	}

	/**
	 * Metodo principal main. Programa principal que permite elegir entre: a)
	 * mostrar por pantalla las tripletas y b) buscarlas y mostrar los tiempos
	 * de ejecucion.
	 */
	public static void main(String[] args) {

		System.out.println("*** Programa SUMA TRIPLETAS ***");
		/*
		 * String eleccion; double tiempo; SecuenciaEnteros s = new
		 * SecuenciaEnteros(1024, 50); System.out.println
		 * ("Escribe 'a)' para mostrar tripletas por pantalla");
		 * System.out.println("o 'b)' para ver el número de tripletas");
		 * eleccion = EntradaInteractiva.leerCadena(); if
		 * (eleccion.contains("a")) {
		 * System.out.println(SumaTripletas.tripletaSumShow(s)); } else {
		 * ControlTime time = new ControlTime(); int numTripletas =
		 * SumaTripletas.tripletaSumCount(s); tiempo = time.finalTime();
		 * System.out.println("Numero de tripletas: " + numTripletas);
		 * System.out.println(tiempo + " segundos"); }
		 */

		// Codigo para obtener las medias de todos los tamaños de entrada
/*
		double tiempoTotal;
		ControlTime timeTotal = new ControlTime();
		int[] numEntradas = { 512, 1024, 2048, 4096, 8192 };
		double[][] tiempos = new double[5][10];
		double[] mediasFinales = new double[5];
		for (int i = 0; i < numEntradas.length; i++) {
			SecuenciaEnteros s = new SecuenciaEnteros(numEntradas[i], 50);
			for (int j = 0; j < 10; j++) {
				ControlTime time = new ControlTime();
				SumaTripletas.tripletaSumCount(s);
				tiempos[i][j] = time.finalTime();
				
			}
		}

		double tempMedia;
		for (int k = 0; k < numEntradas.length; k++) {
			tempMedia = 0;
			for (int l = 0; l < 10; l++) {
				tempMedia += tiempos[k][l];
			}
			mediasFinales[k] = tempMedia / 10;
		}

		System.out
				.println("*** Tiempos medios para cada tamaño de entrada ***\n\n");
		System.out.println("Tamaño entrada 512. Tiempo medio ejecucion: "
				+ mediasFinales[0] + " s");
		System.out.println("Tamaño entrada 1024. Tiempo medio ejecucion: "
				+ mediasFinales[1] + " s");
		System.out.println("Tamaño entrada 2048. Tiempo medio ejecucion: "
				+ mediasFinales[2] + " s");
		System.out.println("Tamaño entrada 4096. Tiempo medio ejecucion: "
				+ mediasFinales[3] + " s");
		System.out.println("Tamaño entrada 8192. Tiempo medio ejecucion: "
				+ mediasFinales[4] + " s");
		tiempoTotal = timeTotal.finalTime();
		System.out
				.println("\nTiempo total para obtener las medias de los diferentes tamaños de entrada: "
						+ tiempoTotal + " s");
						
						*/
		
		double tiempoTotal;
		ControlTime timeTotal = new ControlTime();
		int[] numEntradas = { 30000, 32768 };
		double[][] tiempos = new double[2][10];
		double[] mediasFinales = new double[2];
		for (int i = 0; i < numEntradas.length; i++) {
			SecuenciaEnteros s = new SecuenciaEnteros(numEntradas[i], 50);
			for (int j = 0; j < 10; j++) {
				ControlTime time = new ControlTime();
				SumaTripletas.tripletaSumCount(s);
				tiempos[i][j] = time.finalTime();
				
			}
		}

		double tempMedia;
		Arrays.sort(tiempos[0]);
		Arrays.sort(tiempos[1]);
		for (int k = 0; k < numEntradas.length; k++) {
			tempMedia = 0;
			for (int l = 0; l < 8; l++) {
				tempMedia += tiempos[k][l];
			}
			mediasFinales[k] = tempMedia / 8;
		}

		System.out
				.println("*** Tiempos medios para cada tamaño de entrada ***\n\n");
		System.out.println("Tamaño entrada 30.000. Tiempo medio ejecucion: "
				+ mediasFinales[0] + " s");
		System.out.println("Tamaño entrada 332768. Tiempo medio ejecucion: "
				+ mediasFinales[1] + " s");
		
		tiempoTotal = timeTotal.finalTime();
		System.out
				.println("\nTiempo total para obtener las medias de los diferentes tamaños de entrada: "
						+ tiempoTotal + " s");


	}
}

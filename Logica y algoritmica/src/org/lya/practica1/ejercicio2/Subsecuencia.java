package org.lya.practica1.ejercicio2;

import java.util.Arrays;

import org.lya.utilidades.ControlTime;

/**
 * Clase con metodos estáticos para obtener la subsecuencia máxima. Implementa
 * tres algoritmos de subsecuencia máxima, subsecuenciaFuerzaBruta,
 * subsecuenciaMejorado y subsecuenciaLineal
 * 
 * @author David Subires Parra
 * 
 */
public class Subsecuencia {

	private static int secIni, secFin, sumaMax, sumaActual, suma;

	/**
	 * Metodo estatico que calcula la subsecuencia maxima de una
	 * secuenciaEnteros.
	 * Algoritmo cúbico.
	 * 
	 * @param s
	 *            Secuencia enteros donde se buscara la subsecuenia maxima
	 */
	public static void SubsecuenciaFuerzaBruta(SecuenciaEnteros s) {
		int sumaMax = 0;

		int[] a = s.getValoresSecuencia();

		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				int sumaActual = 0;
				for (int k = i; k <= j; k++) {
					sumaActual += a[k];

					if (sumaActual > sumaMax) {

						sumaMax = sumaActual;
						secIni = i;
						secFin = j;
					}
				}
			}

		}
		suma = sumaMax;
		if (suma == 0) {
			secIni = 0;
			secFin = 0;
		}
	}

	/**
	 * Metodo estatico que calcula la subsecuencia maxima de una secuenciaEnteros.
	 *  Algoritmo cuadrático.
	 * @param s SecuenciaEnteros donde se buscara la subsecuencia maxima
	 */
	public static void SubsecuenciaMejorado(SecuenciaEnteros s) {
		int sumaMax = 0;
		int[] a = s.getValoresSecuencia();

		for (int i = 0; i < a.length; i++) {
			int sumaActual = 0;

			for (int j = i; j < a.length; j++) {
				sumaActual += a[j];

				if (sumaActual > sumaMax) {
					sumaMax = sumaActual;
					secIni = i;
					secFin = j;
				}
			}
		}
		suma = sumaMax;
	}

	/**
	 * Metodo estatico que calcula la subsecuencia maxima de una secuenciaEnteros
	 * Algoritmo lineal
	 * @param s SecuenciaEnteros donde se buscara la subsecuencia maxima
	 */
	public static void SubsecuenciaLineal(SecuenciaEnteros s) {
		int sumaMax = 0;
		int sumaActual = 0;

		int[] a = s.getValoresSecuencia();

		for (int i = 0, j = 0; j < a.length; j++) {
			sumaActual += a[j];

			if (sumaActual > sumaMax) {
				sumaMax = sumaActual;
				secIni = i;
				secFin = j;
			} else if (sumaActual < 0) {
				i = j + 1;
				sumaActual = 0;
			}
		}
		suma = sumaMax;
	}
	
	/**
	 * Metodo getter de la suma maxima
	 * @return la suma maxima 
	 */
	public static int getSuma() {
		return suma;
	}

	/**
	 * Metodo getter del inicio de la subsecuencia maxima calculada
	 * @return indice de posicion de inicio de subsecuencia maxima
	 */
	public static int getPrimer() {
		return secIni;
	}

	/**
	 * Metodo getter de la posicion final de la subsecuencia maxima calculada
	 * @return indice de posicion final de subsecuencia maxima
	 */
	public static int getUltimo() {
		return secFin;
	}
	
	/**
	 * Metodo principal main para obtener los tiempos medios
	 */
	
	public static void main(String[] args) {

		System.out.println("*** Programa Sub-Secuencia Máxima ***");
		double tiempoTotal;
		ControlTime timeTotal = new ControlTime();
		int[] numEntradas = { 500,1000,2000,4000,8000,16000,32000 };
		double[][] tiemposBruta = new double[7][10];
		double[][] tiemposMejorado = new double[7][10];
		double[][] tiemposLineal = new double[7][10];
		double[] mediasFinalesB = new double[7];
		double[] mediasFinalesM = new double[7];
		double[] mediasFinalesL = new double[7];
		for (int i = 0; i < numEntradas.length; i++) {
			SecuenciaEnteros s = new SecuenciaEnteros(numEntradas[i], 40);
			for (int j = 0; j < 10; j++) {
				ControlTime time = new ControlTime();
				Subsecuencia.SubsecuenciaFuerzaBruta(s);
				tiemposBruta[i][j] = time.finalTime();
				
				time = new ControlTime();
				Subsecuencia.SubsecuenciaMejorado(s);
				tiemposMejorado[i][j] = time.finalTime();
				
				time = new ControlTime();
				Subsecuencia.SubsecuenciaMejorado(s);
				tiemposLineal[i][j] = time.finalTime();
			}
		}

		double tempMedia1;
		double tempMedia2;
		double tempMedia3;

		for (int k = 0; k < numEntradas.length; k++) {
			Arrays.sort(tiemposBruta[k]);
			Arrays.sort(tiemposMejorado[k]);
			Arrays.sort(tiemposLineal[k]);
			tempMedia1 = 0;
			tempMedia2 = 0;
			tempMedia3 = 0;
			for (int l = 0; l < 8; l++) {
				tempMedia1 += tiemposBruta[k][l];
				tempMedia2 += tiemposMejorado[k][l];
				tempMedia3 += tiemposLineal[k][l];
			}
			mediasFinalesB[k] = tempMedia1 / 8;
			mediasFinalesM[k] = tempMedia2 / 8;
			mediasFinalesL[k] = tempMedia3 / 8;
		}
		
		System.out.println("Tamaño n \t Fuerza Bruta \t Mejorado \t Lineal");
		for(int i=0; i<7; i++){
			System.out.println(numEntradas[i]+"\t"+mediasFinalesB[i]+"\t"+mediasFinalesM[i]+"\t"+mediasFinalesL[i]);
		}

	}
	
	

}

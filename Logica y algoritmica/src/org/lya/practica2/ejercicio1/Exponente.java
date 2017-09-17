package org.lya.practica2.ejercicio1;

import java.util.Arrays;

import org.lya.utilidades.*;

public class Exponente {

	private int base;
	private int exp;

	public Exponente(int base, int exp) {
		this.base = base;
		this.exp = exp;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public void setExpon(int exp) {
		this.exp = exp;
	}

	public int getBase() {
		return base;
	}

	public int getExpon() {
		return exp;
	}

	public double exponenFuerzaBruta() {
		double temp = 1;
		if (exp == 1) {
			return base;
		} else if (exp == 0) {
			return 1;
		} else {
			for (int i = 0; i < exp; i++) {
				temp = base * temp;
			}
			return temp;
		}
	}

	public double exponenRecursivoDyV() {
		Exponente aux;
		if (exp == 0) {
			return 1;
		} else if (exp == 1) {
			return base;
		} else if (exp % 2 == 0) {
			aux = new Exponente(base, exp / 2);
			double solucion = aux.exponenRecursivoDyV();
			return solucion * solucion;
		} else {
			aux = new Exponente(base, exp - 1);
			return base * aux.exponenRecursivoDyV();
		}
	}

	public static void main(String[] args) {

		double t1, t2, media;
		int[] numeroN = { 128, 256, 512, 1024, 2048, 4096, 8192, 16384 };
		double[] tiempoFB = new double[numeroN.length];
		double[] tiempoDyV = new double[numeroN.length];
		double[] aux = new double[10];
		NumerosAleatorios na = new NumerosAleatorios();
		Exponente exponente;

		for (int i = 0; i < numeroN.length; i++) {
			exponente = new Exponente(na.randomInt(2, 10), numeroN[i]);
			for (int j = 0; j < 10; j++) {
				t1 = System.nanoTime();
				 exponente.exponenFuerzaBruta();
				t2 = System.nanoTime();
				aux[j] = t2 - t1;
			}

			Arrays.sort(aux);
			media = 0;
			for (int j = 0; j < 8; j++) {
				media += aux[j];
			}
			tiempoFB[i] = media / 8;

			for (int j = 0; j < 10; j++) {
				t1 = System.nanoTime();
				 exponente.exponenRecursivoDyV();
				t2 = System.nanoTime();
				aux[j] = t2 - t1;
			}

			Arrays.sort(aux);
			media = 0;
			for (int j = 0; j < 8; j++) {
				media += aux[j];
			}
			tiempoDyV[i] = media / 8;

		}

		System.out.println("****Tabla de tiempos****");
		System.out.println("n \t TIter(n) \t TRecur(n)");
		for (int i = 0; i < numeroN.length; i++) {
			System.out.println(numeroN[i] + " \t " + tiempoFB[i] + " \t "
					+ tiempoDyV[i]);
		}
	}

}

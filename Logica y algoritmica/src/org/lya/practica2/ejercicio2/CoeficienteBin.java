package org.lya.practica2.ejercicio2;

import java.util.Arrays;

public class CoeficienteBin {

	private int n;
	private int k;

	public CoeficienteBin(int n, int k) {
		this.n = n;
		this.k = k;
	}

	public void setN(int n) {
		this.n = n;
	}

	public void setK(int k) {
		this.k = k;
	}

	public int coefBinomialRecursivo() {
		return coefBinRec(this.n, this.k);
	}

	private int coefBinRec(int n, int k) {
		if (k == 0 || k == n) {
			return 1;
		}
		if (k > n) {
			return 0;
		} else {
			return (coefBinRec(n - 1, k - 1) + coefBinRec(n - 1, k));
		}
	}

	public int coefBinomialProgDinam() {
		return coefBinProgDim(this.n, this.k);
	}

	private int coefBinProgDim(int n, int k) {
		int[][] tabla = new int[n + 1][k + 1];
		tabla[0][0] = 1;
		if (k == 0 || k == n) {
			return 1;
		}
		if (k > n) {
			return 0;
		} else {
			for (int i = 1; i < tabla.length; i++) {
				for (int j = 0; j < tabla[i].length; j++) {
					if (j == 0) {
						tabla[i][j] = 1;
					} else {
						tabla[i][j] = (tabla[i - 1][j] + tabla[i - 1][j - 1]);
					}
				}
			}
			return tabla[n][k];
		}
	}

	public static void main(String[] args) {
		double media,t1,t2;
		int[] numeroN = new int[17];
		for (int i = 4; i < 21; i++) {
			numeroN[i-4] = i;
		}
		double[] tiempoR = new double[numeroN.length];
		double[] tiempoProgDin = new double[numeroN.length];
		double[] aux = new double[10];
		CoeficienteBin cb;

		for (int i = 0; i < numeroN.length; i++) {
			cb = new CoeficienteBin(2 * numeroN[i], numeroN[i]);
			for (int j = 0; j < 10; j++) {
				t1 = System.nanoTime();
				cb.coefBinomialRecursivo();
				t2 = System.nanoTime();
				aux[j] = t2 - t1;
			}

			Arrays.sort(aux);
			media = 0;
			for (int j = 0; j < 8; j++) {
				media += aux[j];
			}
			tiempoR[i] = media / 8;

			for (int j = 0; j < 10; j++) {
				t1 = System.nanoTime();
				cb.coefBinomialProgDinam();
				t2 = System.nanoTime();
				aux[j] = t2 - t1;
			}

			Arrays.sort(aux);
			media = 0;
			for (int j = 0; j < 8; j++) {
				media += aux[j];
			}
			tiempoProgDin[i] = media / 8;

		}

		System.out.println("****Tabla de tiempos****");
		System.out.println("CoeficienteBin (2n,n) \t T Recursivo \t T ProgDin");
		for (int i = 0; i < numeroN.length; i++) {
			System.out.println("("+2 * numeroN[i]+","+numeroN[i]+") \t " + tiempoR[i] + " \t "
					+ tiempoProgDin[i]);
		}
		
	}

}

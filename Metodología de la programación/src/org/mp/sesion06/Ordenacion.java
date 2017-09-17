package org.mp.sesion06;

import java.util.Arrays;

/**
 * Clase con metodos estaticos de ordenacion, por insercion, mergeSort y
 * Arrays.sort
 * 
 * @author David Subires Parra
 * 
 */
public class Ordenacion {
	/**
	 * Metodo estatico que realiza una ordenacion por insercion. Para ello llama
	 * al metodo privado ordenacionPorInsercion
	 * 
	 * @param datos
	 *            array comparable de datos a ordenar
	 */
	@SuppressWarnings("rawtypes")
	public static void ordenacionPorInsercion(Comparable[] datos) {
		ordenacionPorInsercion(datos, 0, datos.length - 1);
	}

	/**
	 * Metodo estatico privado que realiza realmente la ordenacion por
	 * insercion.
	 * 
	 * @param datos
	 *            array comparable de datos a ordenar
	 * @param izq
	 *            Posicion izquierda (primera) del array
	 * @param der
	 *            Posicion derecha (ultima) del array
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void ordenacionPorInsercion(Comparable[] datos, int izq,
			int der) {
		int j;
		Comparable tmp;
		for (int p = izq + 1; p <= der; p++) {
			tmp = datos[p];
			for (j = p; j > izq && (tmp.compareTo(datos[j - 1]) < 0); j--) {
				datos[j] = datos[j - 1];
			}
			datos[j] = tmp;
		}
	}

	/**
	 * Metodo de ordenacion mergeSort
	 * 
	 * @param datos
	 *            array comparable de datos a ordenar
	 */
	@SuppressWarnings("rawtypes")
	public static void mergeSort(Comparable[] datos) {
		Comparable[] vectorTemp = new Comparable[datos.length];
		mergeSort(datos, vectorTemp, 0, datos.length - 1);
	}

	/**
	 * Metodo privado recursivo mergeSort. Divide el conjunto de datos en
	 * subconbjuntos mas pequeños
	 * 
	 * @param datos
	 *            array comparable de datos a ordenar
	 * @param vectorTemp
	 *            array comparable temporal para almacenar los resultados
	 * @param izq
	 *            posicion izquierda (primera) del array
	 * @param der
	 *            posicion derecha (final) del array
	 */
	@SuppressWarnings("rawtypes")
	private static void mergeSort(Comparable[] datos, Comparable[] vectorTemp,
			int izq, int der) {
		if (izq < der) {
			int centro = (izq + der) / 2;
			mergeSort(datos, vectorTemp, izq, centro);
			mergeSort(datos, vectorTemp, centro + 1, der);
			mezclar(datos, vectorTemp, izq, centro + 1, der);

		}
	}

	/**
	 * Metodo privado que se encarga de mezclar de forma ordenada los
	 * subconjuntos que genera el metodo anterior, obteniendo un solo array
	 * ordenado
	 * 
	 * @param datos
	 *            array comparable de datos a ordenar
	 * @param vectorAux
	 *            array comparable temporal para almacenar resultados
	 * @param posIzq
	 *            posicion izquierda del array. Primera posicion del primer
	 *            subconjunto
	 * @param posDer
	 *            posicion derecha del array. Primera posicion del segundo
	 *            subconjunto
	 * @param posFin
	 *            posicional final del array
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void mezclar(Comparable[] datos, Comparable[] vectorAux,
			int posIzq, int posDer, int posFin) {

		int finIzq = posDer - 1;
		int posAux = posIzq;
		int numElementos = posFin - posIzq + 1;
		while ((posIzq <= finIzq) && (posDer <= posFin))
			if (datos[posIzq].compareTo(datos[posDer]) <= 0)
				vectorAux[posAux++] = datos[posIzq++];
			else
				vectorAux[posAux++] = datos[posDer++];

		// Copiar el resto de la primera mitad
		while (posIzq <= finIzq)
			vectorAux[posAux++] = datos[posIzq++];
		// Copiar el resto de la segunda mitad
		while (posDer <= posFin)
			vectorAux[posAux++] = datos[posDer++];
		// Copiar el vector temporal en el original
		for (int i = 0; i < numElementos; i++, posFin--)
			datos[posFin] = vectorAux[posFin];

	}

	/**
	 * Metodo de ordenacion mediante Arrays.sort
	 * 
	 * @param datos
	 *            array comparable de dato a ordenar
	 */
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] datos) {
		Arrays.sort(datos);
	}

}

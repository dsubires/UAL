package org.mp.sesion02;

// TODO: Auto-generated Javadoc
/**
 * The Class Mayor.
 */
public class Mayor {

	/**
	 * elEnteroMayor.
	 *
	 * @param vector Un array de enteros no vacio
	 * @return El entero mayor en el array
	 */
	public static int elEnteroMayor(int[] vector) {

		int indice;
		int max = Integer.MIN_VALUE;

	/*	if (vector.length == 1) {
			max = vector[0];
		} else {*/
			for (indice = 0; indice < vector.length; indice++) {
				if (vector[indice] > max) {
					max = vector[indice];
				}
			/*}*/
		}
		return max;
	}

}

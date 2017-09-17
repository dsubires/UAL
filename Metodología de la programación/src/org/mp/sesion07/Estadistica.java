package org.mp.sesion07;

/**
 * Clase estadistica. Se instancia mediante un ConjuntoDatos. Esta clase nos
 * permite obtener media, maximo, minimo y suma de una columna.
 * 
 * @author David Subires Parra
 */
public class Estadistica {

	private ConjuntoDatos cd;

	/**
	 * Construcor Estadistica. Instancia un objeto de clase estadistica
	 * asignandole un ConjuntoDatos como parametro.
	 * 
	 * @param cd
	 *            ConjuntoDatos que se asignará al nuevo objeto Estadistica
	 *            instanciado
	 */
	public Estadistica(ConjuntoDatos cd) {
		this.cd = cd;
	}

	/**
	 * Metodo media. Devuelve la media de todos los datos de una columna pasada
	 * por parametro
	 * 
	 * @param columna
	 *            Columna de la cual se obtendrá la media
	 * @return media de los datos de la columna
	 */
	public double media(String columna) {
		double[] temp = cd.getColumna(columna);
		double media = 0;
		for (int i = 0; i < temp.length; i++) {
			media += temp[i];
		}
		return media / temp.length;
	}

	/**
	 * Metodo max. Devuelve el maximo de todos los datos de una columna pasada
	 * por parametro
	 * 
	 * @param columna
	 *            Columna de la cual se obtendrá el maximo
	 * @return maximo de los datos de la columna
	 */
	public double max(String columna) {
		double[] temp = cd.getColumna(columna);
		double max = 0;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] > max) {
				max = temp[i];
			}
		}
		return max;
	}

	/**
	 * Metodo min. Devuelve el minimo de todos los datos de una columna pasada
	 * por parametro
	 * 
	 * @param columna
	 *            columna de la cual se obtendrá el minimo
	 * @return minimo de los datos de la columna
	 */
	public double min(String columna) {
		double[] temp = cd.getColumna(columna);

		double min = temp[0];
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] < min) {
				min = temp[i];
			}
		}
		return min;
	}

	/**
	 * Metodo suma. Devuelve la suma de todos los datos de una columna pasada
	 * por parametro
	 * 
	 * @param columna
	 *            de la cual se obtendrá la suma
	 * @return suma de los datos de la columna
	 */
	public double suma(String columna) {
		double[] temp = cd.getColumna(columna);
		double suma = 0;
		for (int i = 0; i < temp.length; i++) {
			suma += temp[i];
		}
		return suma;
	}

}

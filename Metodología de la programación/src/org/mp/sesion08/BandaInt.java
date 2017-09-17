package org.mp.sesion08;

/**
 * Clase BandaInt. Representa una banda de una imagen binaria BSQ, almacena los
 * datos en formato int.
 * 
 * @author David Subires Parra
 * 
 */
public class BandaInt {

	private String nombreBanda;
	private int[][] datos;

	/**
	 * Constructor BandaInt. Instancia una BandaInt pasando como parametro el
	 * nombre de la banda, numero de columnas y numero de lineas.
	 * 
	 * @param nombre
	 *            nombre d e la banda
	 * @param x
	 *            numero de columnas
	 * @param y
	 *            numero de lineas
	 */
	public BandaInt(String nombre, int x, int y) {
		nombreBanda = nombre;
		datos = new int[x][y];
	}

	/**
	 * Constructor BandaInt. Instancia una BandaInt pasando como parametro el
	 * nombre de la banda y uma matriz int con los datos.
	 * 
	 * @param nombre
	 *            nombre d e la banda
	 * @param datos
	 *            matriz int con los datos de la banda
	 */

	public BandaInt(String nombre, int[][] datos) {
		nombreBanda = nombre;
		this.datos = datos;
	}

	/**
	 * Metodo getter del nombre de la banda
	 * 
	 * @return nombre de la banda
	 */
	public String getNombreBanda() {
		return nombreBanda;
	}

	/**
	 * Metodo setter del nombre de la banda
	 * 
	 * @param n
	 *            nombre de la banda
	 */
	public void setNombreBanda(String n) {
		nombreBanda = n;
	}

	/**
	 * Metodo getter de los datos de la banda
	 * 
	 * @return int[][] con los datos de la banda
	 */
	public int[][] getDatos() {
		return datos;
	}

	/**
	 * Metodo setter de los datos de la banda
	 * 
	 * @param d
	 *            int[][] con los datos de la banda
	 */
	public void setDatos(int[][] d) {
		datos = d;
	}

	/**
	 * Metodo getter de un dato (x,y) de la banda
	 * 
	 * @param x
	 *            numero de columna
	 * @param y
	 *            numero de linea
	 * @return dato (x,y) de la banda
	 */
	public int getDatoXY(int x, int y) {
		return datos[y][x];
	}

	/**
	 * Metodo setter de un dato (x,y) de la banda
	 * 
	 * @param dato
	 *            dato a añadir a la banda
	 * @param x
	 *            numero de columna de la banda
	 * @param y
	 *            numero de linea de la banda
	 * @return dato (x,y) de la banda ¿¿¿???
	 */
	public int setDatoXY(int dato, int x, int y) {
		return datos[x][y] = dato;
	}

	/**
	 * Metodo toString de BandaInt. Devuelve el nombre de la banda
	 * 
	 *  @return nombre de la banda
	 */
	@Override
	public String toString() {
		return nombreBanda;
	}

}

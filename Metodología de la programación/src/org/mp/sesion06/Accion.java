package org.mp.sesion06;

@SuppressWarnings("rawtypes")
/**
 * Clase Accion. 
 * @author David Subires Parra
 *
 */
public class Accion implements Comparable {
	/**
	 * Nombre de la accion
	 */
	private String nombre;
	/**
	 * Volumen de la accion
	 */
	private long volumen;

	/**
	 * Constructor de Accion. Instancia una nueva accion
	 * 
	 * @param n
	 *            nombre de la accion
	 * @param v
	 *            volumen de la accion
	 */
	public Accion(String n, long v) {
		nombre = n;
		volumen = v;
	}

	/**
	 * Devuelve el nombre de la accion
	 * 
	 * @return nombre accion
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Asigna un nuevo nombre de accion
	 * 
	 * @param n
	 *            nuevo nombre de accion
	 */
	public void setNombre(String n) {
		nombre = n;
	}

	/**
	 * Devuelve el volumen de la accion
	 * 
	 * @return volumen accion
	 */
	public long getVolumen() {
		return volumen;
	}

	/**
	 * Asigna un nuevo volumen de accion
	 * 
	 * @param v
	 *            nuevo volumen de accion
	 */
	public void setVolumen(long v) {
		volumen = v;
	}

	/**
	 * Compara dos acciones para ver si son iguales, la que llama al metodo y la
	 * que se pasa por parametro
	 * 
	 * @return true si son iguales, false en caso contrario
	 */
	@Override
	public boolean equals(Object o) {
		Accion tempCast = (Accion) o;
		return nombre.equals(tempCast.getNombre())
				&& volumen == tempCast.getVolumen();
	}

	/**
	 * Imprime el contenido de una accion
	 * 
	 * @return contenido de una accion
	 */
	@Override
	public String toString() {
		return "Info de Accion:\n Nombre:" + nombre + "\n Volumen: " + volumen;
	}

	/**
	 * Compara dos acciones, la que llama al metodo y la que se pasa por
	 * parametro
	 * 
	 * @return -1, 0, o 1 en caso de que la accion que llama al metodo sea
	 *         menor, igual o mayor que la accion pasada por parametro
	 */
	@Override
	public int compareTo(Object o) {
		Accion tempCast = (Accion) o;
		if (volumen > tempCast.getVolumen()) {
			return 1;
		} else if (volumen < tempCast.getVolumen()) {
			return -1;
		} else {
			return 0;
		}
	}

}

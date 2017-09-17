package org.mp.sesion06;

/**
 * Excepcion para elementos no encontrados
 */
@SuppressWarnings("serial")
public class ElementoNoEncontradoException extends Exception {
	/**
	 * Constructor para la excepcion
	 * 
	 * @param s
	 *            contiene mensaje con el error
	 */
	public ElementoNoEncontradoException(String s) {
		super(s);
	}
}
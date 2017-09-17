package junioMP;

/**
 * Excepcion para elementos no encontrados
 */
public class NoSuchElementException extends Exception {
	/**
	 * Constructor para la excepcion
	 * 
	 * @param s
	 *            contiene mensaje con el error
	 */
	public NoSuchElementException(String s) {
		super(s);
	}
}
package junioMP;

// TODO: Auto-generated Javadoc
// Nodo basico almacenado en una lista enlazada

/**
 * The Class ListNode.
 *
 * @param <T> the generic type
 */
public class ListNodeDoubly<T> {
	// Atributos
	/** The element. */
	protected T element;
	
	protected ListNodeDoubly<T> previous;
	
	/** The next. */
	protected ListNodeDoubly<T> next;

	/**
	 * Constructor para nodo cabecera.
	 *
	 * @param theElement the the element
	 */
	public ListNodeDoubly(T theElement) {
		previous = null;
		element = theElement;
		next = null;
	}
	
	/**
	 * Constructor para crear e insertar elemento en lista.
	 *
	 * @param theElement the the element
	 * @param n - Nodo de lista que precede al insertado
	 */

	public ListNodeDoubly(ListNodeDoubly<T> p, T theElement, ListNodeDoubly<T> n) {
		previous = p;
		element = theElement;
		next = n;
	}
}


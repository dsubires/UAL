package org.mp.sesion04;

// TODO: Auto-generated Javadoc
// Nodo basico almacenado en una lista enlazada

/**
 * The Class ListNode.
 *
 * @param <T> the generic type
 */
public class ListNode<T> {
	// Atributos
	/** The element. */
	protected T element;
	
	/** The next. */
	protected ListNode<T> next;

	/**
	 * Constructor para nodo cabecera.
	 *
	 * @param theElement the the element
	 */
	public ListNode(T theElement) {
		this.element = theElement;
		this.next = null;
	}
	
	/**
	 * Constructor para crear e insertar elemento en lista.
	 *
	 * @param theElement the the element
	 * @param n - Nodo de lista que precede al insertado
	 */

	public ListNode(T theElement, ListNode<T> n) {
		element = theElement;
		next = n;
	}
}


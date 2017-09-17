package org.mp.sesion05;

/**
 * Clase que genera un nodo basico de almacenamiento en LinkedList
 * 
 * @author David Subires Parra
 * 
 * @param <T>Tipo generico
 */
public class ListNode<T> {
	/** Elemento almacenado en el nodo */
	protected T element;

	/** Referencia al siguiente nodo */
	protected ListNode<T> next;

	/**
	 * Constructor de un nodo. Genera un nodo almacenando el elemento T pasado
	 * como parametro y estableciendo null al next
	 * 
	 * @param theElement
	 *            elemento que almacenara el nodo
	 */

	public ListNode(T theElement) {
		this.element = theElement;
		this.next = null;
	}

	/**
	 * Constructor para crear e insertar elemento en lista.
	 * 
	 * @param theElement
	 *            the the element
	 * @param n
	 *            - Nodo de lista que precede al insertado
	 */

	public ListNode(T theElement, ListNode<T> n) {
		element = theElement;
		next = n;
	}
}

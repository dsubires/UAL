package org.mp.sesion05;

/**
 * Clase que genera una Linked List. LinkedList esta formada por un nodo
 * cabecera con un element vacio y en el next del nodo cabecera se añadira el
 * primer nodo y asi sucesivamente
 * 
 * @author David Subires Parra
 * 
 * @param <T>
 *            Tipo generico
 */
public class LinkedList<T> implements List<T> {

	protected ListNode<T> headNode;

	/**
	 * Constructor de una Linked List Genera un ListNode cabecera con
	 * contenido(element) null
	 */
	public LinkedList() {
		headNode = new ListNode<T>(null);
	}

	/**
	 * Metodo que devuelve si la Linked List esta vacia
	 * 
	 * @return true si esta vacia, false en caso contrario
	 */
	public boolean isEmpty() {
		return headNode.next == null;
	}

	/**
	 * Vacia locigamente la Linked List
	 */
	public void clear() {
		headNode.next = null;
	}

}

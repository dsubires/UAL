package org.mp.sesion05;


/**
 * 
 * @author David Subires Parra
 * 
 * @param <T>
 *            Tipo generico
 */

public class LinkedListIterator<T> implements ListIterator<T> {

	protected LinkedList<T> theList;
	protected ListNode<T> current;

	/**
	 * Constructor de un LinkedListIterator
	 * 
	 * @param list
	 *            LinkedList que sera el contenido de LinkedListIterator
	 */
	public LinkedListIterator(LinkedList<T> list) {
		theList = list;
		current = null;
	}

	/**
	 * Inserta x despues de la posicion actual La posicion actual apunta al
	 * nuevo nodo insertado.
	 * 
	 * @param x
	 *            Elemento generico que sera añadido
	 * 
	 * @throws NoSuchElementException
	 *             LinkedList no tiene nodo cabecera
	 * 
	 */
	public void add(T x) throws NoSuchElementException {

		if (theList.headNode == null) {
			throw new NoSuchElementException("Linked List no inicializada");

		}

		if (current == null) {
			theList.headNode.next = new ListNode<T>(x);
			current = theList.headNode.next;
		} else {
			current.next = new ListNode<T>(x);
			next();
			// current = current.next;
		}

	}

	/**
	 * Elimina la primera aparicion de x
	 * 
	 * @param x
	 *            elemento generico a eliminar
	 * @throws NoSuchElementException
	 *             no se ha encontrado el elemento a eliminar
	 */
	public void remove(T x) throws NoSuchElementException {
		ListNode<T> temp = theList.headNode;
		boolean removeOk = false;
		while (temp.next != null) {
			if (temp.next.element.equals(x)) {
				temp.next = temp.next.next;
				removeOk = true;
				break;
			}
			temp = temp.next;
		}
		if (!removeOk) {
			throw new NoSuchElementException("Elemento no encontrado");
		}
	}

	/**
	 * Establece la posicion actual al primer nodo que contiene x.
	 * 
	 * @param x
	 *            elemento generico a buscar
	 * @throws NoSuchElementException
	 *             no encontrado nodo que contiene x
	 */
	public boolean contains(T x) throws NoSuchElementException {
		ListNode<T> temp = theList.headNode;
		boolean containsOk = false;
		while (temp.next != null) {
			if (temp.element != null) {
				if (temp.element.equals(x)) {
					current = temp;
					containsOk = true;
					break;
				}
			}
			temp = temp.next;
		}
		if (!containsOk) {
			throw new NoSuchElementException("Elemento no encontrado");
		}
		return true;
	}

	/**
	 * Posicion actual al nodo cabecera.
	 */
	public void zero() {
		current = theList.headNode;
	}

	/**
	 * Posicion actual en el primer nodo de la lista.
	 * 
	 * @throws NoSuchElementException
	 *             nodo cabecera no tiene nodo next asignado
	 */
	public void first() throws NoSuchElementException {
		if (theList.isEmpty()) {
			throw new NoSuchElementException("LinkedList Vacia");
		}
		current = theList.headNode.next;
	}

	/**
	 * Avanza la posicion actual al siguiente nodo de la lista.
	 */
	public void next() {
		current = current.next;
	}

	/**
	 * Comprueba que la posicion actual referencia un nodo de la lista.
	 * 
	 * @return true si referencia un nodo; false en caso contrario
	 */
	public boolean hasNext() {
		return current != null;
	}

	/**
	 * Devuelve el elemento del nodo de la posicion actual de la lista.
	 * 
	 * @return elemento generico del nodo de la posicion actual
	 * @throws NoSuchElementException
	 *             linked list vacia
	 */
	public T get() throws NoSuchElementException {
		if (theList.isEmpty()) {
			throw new NoSuchElementException("LinkedList Vacia");
		}
		if (hasNext()) {
			return current.element;
		} else {
			return null;
		}
	}

}

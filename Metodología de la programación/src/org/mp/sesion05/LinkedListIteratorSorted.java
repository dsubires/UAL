package org.mp.sesion05;

public class LinkedListIteratorSorted<T> extends LinkedListIterator<T> {

	public LinkedListIteratorSorted(LinkedList<T> list) {
		super(list);

	}

	/**
	 * Inserta x de forma ordenada en la LinkedList, de menor a mayor
	 * 
	 * @param x
	 *            nodo a insertar
	 * @throws NoSuchElementException
	 *             Linked List no tiene nodo cabecera
	 */

	@SuppressWarnings("unchecked")
	@Override
	public void add(T x) throws NoSuchElementException {
		if (theList.headNode == null) {
			throw new NoSuchElementException("Linked List no inicializada");

		}
		addSorted((Comparable<T>) x);
	}

	// Metodo privado que realmente se encarga de insertar x de forma ordenada
	// en la Linked List
	@SuppressWarnings("unchecked")
	private void addSorted(Comparable<T> x) throws NoSuchElementException {
		// si la lista esta vacia, inserta x al next del headNode
		if (current == null) {
			theList.headNode.next = new ListNode<T>((T) x);
			first();
		} else {

			first();
			while (current.next != null) {
				next();
			}
			if (x.compareTo((T) current.element) > 0) {
				current.next = new ListNode<T>((T) x);
				next();
			} else {

				ListNode<T> nodoTemp = null;
				zero();
				// se compara x con los elementos de los nodos desde el primero
				// hasta el ultimo, si x es menor se inserta antes que el nodo
				// en cuestion
				while (current.next != null) {
					if ((x.compareTo((T) current.next.element) < 0)) {
						nodoTemp = current.next;
						current.next = new ListNode<T>((T) x);
						current.next.next = nodoTemp;
						break;
					}
					next();
				}
				/*
				 * Si el valor es mayor que todos los almacenados en la lista,
				 * // lo // insertamos al final if (!addOk) { current.next = new
				 * ListNode<T>((T) x); current = current.next; }
				 */
			}
		}

	}
}

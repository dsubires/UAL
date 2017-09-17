package org.mp.sesion05;

import java.util.LinkedList;

/**
 * Clase que genera una Cola sobre una LinkedList
 * 
 * @author David Subires Parra
 * 
 * @param <T>
 *            Tipo generico
 */
public class QueueLinkedListApi<T> implements Queue<T> {

	private LinkedList<T> cola;

	/**
	 * Constructor de la cola Genera una LinkedLista vacia usada como cola
	 */
	public QueueLinkedListApi() {
		cola = new LinkedList<T>();
	}

	/**
	 * Inserta un elemento nuevo en la cola.
	 * 
	 * @param x
	 *            elemento a insertar.
	 */
	public void addLast(T x) {
		cola.addLast(x);
	}

	/**
	 * Devuelve el elemento insertado primero en la cola. No altera la cola.
	 * 
	 * @return Devuelve el elemento insertado primero en la cola.
	 * @throws EmptyQueueException
	 *             si la cola es vacia.
	 */
	public T getFirst() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException("Cola Vacia");
		}
		return cola.getFirst();

	}

	/**
	 * Devuelve y elimina el elemento insertado primero en la cola. No altera la
	 * cola.
	 * 
	 * @return Devuelve el elemento insertado primero en la cola.
	 * @throws EmptyQueueException
	 *             si la cola es vacia.
	 */
	public T removeFirst() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException("Cola Vacia");
		}
		return cola.pollFirst();
	}

	/**
	 * Comprueba si la cola esta logicamente vacia.
	 * 
	 * @return true si esta vacia, sino false.
	 */
	public boolean isEmpty() {
		return cola.isEmpty();
	}

	/**
	 * Hace la cola vacia logicamente.
	 */
	public void clear() {
		cola.clear();
	}

	/**
	 * Devuelve el tamaño de la cola.
	 * 
	 * @return the int
	 */
	public int size() {
		return cola.size();
	}

}

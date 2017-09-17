package org.mp.sesion05;

import java.util.LinkedList;

/**
 * 
 * @author David Subires Parra
 * 
 * @param <T>
 *            Tipo generico
 */
public class StackLinkedListApi<T> implements Stack<T> {

	private LinkedList<T> stackLinkedListApi;

	/**
	 * Constructor de la pila. Genera una LinkedList vacia, usada como pila
	 */
	public StackLinkedListApi() {
		stackLinkedListApi = new LinkedList<T>();
	}

	/**
	 * Inserta un elemento nuevo en la pila.
	 * 
	 * @param x
	 *            elmento a insertar
	 */
	public void push(T x) {
		stackLinkedListApi.add(x);
	}

	/**
	 * Elimina el elemento mas recientemente insertado.
	 * 
	 * @throws EmptyStackException
	 *             si la pila esta vacia
	 */
	public void pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException("Pila Vacia");
		}
		stackLinkedListApi.removeLast();
	}

	/**
	 * Obtiene el elemento mas recientemente insertado en pila No altera pila.
	 * 
	 * @return el elemento mas recientemente insertado
	 * @throws EmptyStackException
	 *             si la pila esta vacia
	 */
	public T peek() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException("Pila Vacia");
		}
		return stackLinkedListApi.peekLast();
	}

	/**
	 * Devuelve y elimina el elemento mas recientemente inserta en pila.
	 * 
	 * @return elemento insertado
	 * @throws EmptyStackException
	 *             si la pila esta vacia
	 */
	public T peekAndPop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException("Pila Vacia");
		}
		return stackLinkedListApi.pollLast();
	}

	/**
	 * Comprueba si la pila esta vacia.
	 * 
	 * @return true si pila vacia, sino false
	 */
	public boolean isEmpty() {
		return stackLinkedListApi.isEmpty();
	}

	/**
	 * Pone pila logicamente a vacio.
	 */
	public void clear() {
		stackLinkedListApi.clear();
	}

	/**
	 * Devuelve el tamaño de la pila
	 * 
	 * @return Tamano de la pila
	 */
	public int size() {
		return stackLinkedListApi.size();
	}

}

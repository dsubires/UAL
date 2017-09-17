package org.eda1.examenParcialGrupoB.ejercicio01;

import java.util.NoSuchElementException;

public interface MyPriorityQueue<T> {
	/**
	 * Devuelve el n�mero de elementos en este objeto MyPriorityQueue
	 * 
	 * @return n�mero de elementos que hay en este objeto MyPriorityQueue.
	 * 
	 */
	int size();

	/**
	 * Determina si el objeto MyPriorityQueue no tiene elementos (est� vacio).
	 * 
	 * @return true - si este MyPriorityQueue no tiene elementos, en otro caso
	 *         - false;
	 * 
	 */
	boolean isEmpty();

	/**
	 * Inserta un elemento dado en este objeto MyPriorityQueue.
	 * 
	 * @param element
	 *            - el elemento a inserte en este objeto MyPriorityQueue
	 * 
	 */
	void add(T element);

	/**
	 * Devuelve el elemento situado a la cabeza de MyPriorityQueue.
	 * Si est� vacia, devuelve null. No lo elimina.
	 * 
	 * @return el elemento situado a la cabeza de MyPriorityQueue.
	 * 
	 * @throws NoSuchElementException
	 *             - si el objeto MyPriorityQueue est� vac�o.
	 * 
	 */
	T peek();

	/**
	 * Devuelve y elimina el elemento situado a la cabeza de MyPriorityQueue.
	 * Si est� vacia, devulve null.
	 * 
	 * @return el elemento eliminado.
	 * 
	 * @throws NoSuchElementException
	 *             - si este objeto MyPriorityQueue est� vac�o.
	 * 
	 */
	T poll();

} // interface MyPriorityQueue

package org.mp.sesion04;

// TODO: Auto-generated Javadoc
// Interfaz Cola (Queue)
//
// CONSTRUCCION: sin ninguna inicializacion
//
// ******************OPERACIONES PUBLICAS**************************************
// void addLast( x ) 		-> Inserta x
// T getFirst( ) 			-> Devuelve el primer elemento insertado
// T removeFirst( ) 		-> Devuelve y elimina el primer elemento insertado
// boolean isEmpty( ) 		-> Devuelve true if empty; sino false
// void clear( ) 			-> Elimina todos los elementos
// int size()				-> Devuelve el tamano de la cola
// ******************ERRORES***************************************************
// getFirst o removeFirst en una cola vacia

/**
 * The Interface Queue.
 *
 * @param <T> the generic type
 */
public interface Queue<T> {
	
	/**
	 * Inserta un elemento nuevo en la cola.
	 * 
	 * @param x el elemento a insertar.
	 */
	void addLast(T x);
	
	/**
	 * Devuelve el elemento insertado primero en la cola. No altera la cola.
	 *
	 * @return Devuelve el elemento insertado primero en la cola.
	 * @throws EmptyQueueException si la cola es vacia.
	 */
	T getFirst() throws EmptyQueueException;
	
	/**
	 * Devuelve y elimina el elemento insertado primero en la cola.
	 * No altera la cola.
	 *
	 * @return Devuelve el elemento insertado primero en la cola.
	 * @throws EmptyQueueException si la cola es vacia.
	 */
	T removeFirst() throws EmptyQueueException;
	
	/**
	 * Comprueba si la cola esta logicamente vacia.
	 * 
	 * @return true si esta vacia, sino false.
	 */
	boolean isEmpty();

	/**
	 * Hace la cola vacia logicamente.
	 */
	void clear();

	/**
	 * Devuelve el tamaño de la cola.
	 *
	 * @return the int
	 */
	int size();
}

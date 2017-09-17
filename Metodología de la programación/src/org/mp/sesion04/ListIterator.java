package org.mp.sesion04;

// TODO: Auto-generated Javadoc
// Interfaz ListIterator; mantiene la posicion actual
//
// *********************** OPERACIONES PUBLICAS ****************************
// void add( x ) 			-> Inserta x despues de la posicion actual
// void remove( x )			-> Elimina x
// boolean contains( x )	-> Posiciona la posicion actual para acceder a x
// void zero( )				-> Posiciona actual antes del primer nodo
// void first( )			-> Posiciona actual al primer nodo
// void next( ) 			-> Avanza la posicion actual
// boolean hasNext( )	 	-> True si Actual es una posicion valida de lista
// T get( ) 				-> Devuelve el elmento del nodo actual
// ******************ERRORES************************************************
// Excepciones generadas por acceso, insercciones o eliminaciones erroneas

/**
 * Protocolo para los iteradores de listas utilizando nodo cabecera.
 *
 * @param <T> the generic type
 * @see List
 */

public interface ListIterator<T> {
	
	/**
	 * Inserta x despues de la posicion actual
	 * La posicion actual apunta al nuevo nodo insertado.
	 *
	 * @param x the x
	 * @throws NoSuchElementException the no such element exception
	 */
	void add(T x) throws NoSuchElementException;
	
	/**
	 * Elimina la primera aparicion de x.
	 *
	 * @param x the x
	 * @throws NoSuchElementException the no such element exception
	 */
	void remove(T x) throws NoSuchElementException;
	
	/**
	 * Establece la posicion actual al primer nodo que contiene x.
	 *
	 * @param x the x
	 * @return true, if successful
	 * @throws NoSuchElementException the no such element exception
	 */
	boolean contains(T x) throws NoSuchElementException;

	/**
	 * Posicion actual al nodo cabecera.
	 */
	void zero();
	
	/**
	 * Posicion actual en el primer nodo de la lista.
	 *
	 * @throws NoSuchElementException the no such element exception
	 */
	void first() throws NoSuchElementException;
	
	/**
	 * Avanza la posicion actual al siguiente nodo de la lista.
	 */
	void next();
	
	/**
	 * Comprueba que la posicion actual referencia un nodo de la lista.
	 *
	 * @return true si referencia a nodo; false en caso contrario
	 */
	boolean hasNext();
	
	/**
	 * Devuelve el elemento del nodo de la posicion actual de la lista.
	 *
	 * @return the t
	 * @throws NoSuchElementException the no such element exception
	 */
	T get() throws NoSuchElementException ;	
}

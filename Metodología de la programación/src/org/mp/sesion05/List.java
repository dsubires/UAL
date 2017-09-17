package org.mp.sesion05;

// TODO: Auto-generated Javadoc
// Interfaz List
// 
// Acceso mediante la interfaz ListIterator
//
// *********************** OPERACIONES PUBLICAS **********************
// boolean isEmpty()      	-> Devuelve true si vacia, sino false
// void clear()	            -> Elimina todos los nodos
// ******************ERRORES******************************************
// No se tratan errores

/**
 * Protocolo para listas. Acceso a la lista mediante objeto ListIterator
 * Operaciones de Interfaz List:  Estado de la lista
 * Resto de operaciones en la interfaz ListIterator
 *
 * @param <T> Tipo generico
 * @see ListIterator
 */

public interface List<T> {
	
	/**
	 * Comprueba si la lista esta vacia.
	 *
	 * @return true si lista vacia, sino false
	 */
	boolean isEmpty();

	/**
	 * Vacia la lista logicamente.
	 */
	void clear();
}

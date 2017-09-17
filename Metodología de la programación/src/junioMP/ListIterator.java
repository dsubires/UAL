package junioMP;

// Interfaz ListIterator; mantiene la posicion actual
//
// *********************** OPERACIONES PUBLICAS ****************************
// void addAfter( x )		-> Inserta despues de la posicion actual
// void addBefore( x )		-> Inserta antes de la posicion actual
// void remove( )			-> Elimina el elemento de la posicion actual
// boolean contains( x )		-> Posiciona la posicion actual para acceder a x
// void zero( )				-> Posiciona actual antes del primer nodo
// void first( )				-> Posiciona actual al primer nodo
// void last() 				-> Posiciona actual al ultimo nodo de la lista
// void next( ) 				-> Avanza la posicion actual al siguiente
// void previous( ) 			-> Avanza la posicion actual al anterior
// boolean isCurrentValid( )	-> True si actual es una posicion valida de lista
// boolean hasNext( )		-> True si actual tiene un nodo siguiente
// boolean hasPrevious( )	-> True si actual tiene un nodo anterior
// T get( ) 					-> Devuelve el elmento del nodo actual
// ******************ERRORES************************************************
// Excepciones generadas por acceso, insercciones o eliminaciones erroneas

/**
 * Protocolo para los iteradores de listas utilizando nodo cabecera
 * @see List
 */

public interface ListIterator<T> {
	
	/**
	 * TODO
	 */
	void addAfter(T x) throws NoSuchElementException;
	
	/**
	 * TODO
	 */
	void addBefore(T x) throws NoSuchElementException;
	
	/**
	 * TODO
	 */
	void remove(T x) throws NoSuchElementException;
	
	/**
	 * Establece la posicion actual al primer nodo que contiene x
	 * @exception NoSuchElementException
	 */
	boolean contains(T x) throws NoSuchElementException;

	/**
	 * Posicion actual al nodo cabecera
	 */
	void zero();
	
	/**
	 * Posicion actual en el primer nodo de la lista
	 */
	void first() throws NoSuchElementException;
	
	/**
	 * Posicion actual en el ultimo nodo de la lista
	 */
	public void last() throws NoSuchElementException;
	
	/**
	 * Avanza la posicion actual al siguiente nodo de la lista
	 */
	void next();
	
	/**
	 * Avanza la posicion actual al nodo anterior de la lista
	 */
	void previous();
	
	/**
	 * Comprueba que la posicion actual referencia un nodo de la lista
	 * @return true si referencia a nodo; false en caso contrario
	 */
	boolean isCurrentValid();

	/**
	 * Comprueba que la posicion actual tiene un nodo siguiente
	 * @return true si existe; false en caso contrario
	 */
	boolean hasNext();

	/**
	 * Comprueba que la posicion actual tiene un nodo anterior
	 * @return true si existe; false en caso contrario
	 */
	boolean hasPrevious();
	
	/**
	 * Devuelve el elemento del nodo de la posicion actual de la lista
	 */
	T get() throws NoSuchElementException ;	
}

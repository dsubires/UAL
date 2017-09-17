package org.mp.sesion04;

// TODO: Auto-generated Javadoc
// Interfaz Pila (Stack)
// *********************** OPERACIONES PUBLICAS **********************
// void push(x)          -> Inserta x
// void pop()     		 -> Elimina el ultimo elmento insertado
// T peek() 	         -> Devuelve el ultimo elmento insertado
// T peekAndPop()	     -> Devuelve y elimina elemento mas reciente
// boolean isEmpty()     -> Devuelve true si pila vacia, sino false
// void clear()        	 -> Elimina todos los elementos
// int size()			 -> Devuelve el tamaño de la pila
// ******************ERRORES******************************************
// peek, pop o peekAndPop sobre pila vacia

/**
 * The Interface Stack.
 *
 * @param <T> the generic type
 */
public interface Stack<T> {	
	
	/**
	 * Inserta un elemento nuevo en la pila.
	 *
	 * @param x el elmento a insertar
	 */
	void push(T x);
	
	/**
	 * Elimina el elemento mas recientemente insertado.
	 *
	 * @throws EmptyStackException si la pila esta vacia
	 */
	void pop() throws EmptyStackException;
		
	/**
	 * Obtiene el elemento mas recientemente insertado en pila No altera pila.
	 *
	 * @return el elemento mas recientemente insertado
	 * @throws EmptyStackException si la pila esta vacia
	 */
	 T peek() throws EmptyStackException;
	
	/**
	 * Devuelve y elimina el elemento mas recientemente inserta en pila.
	 *
	 * @return elemento insertado
	 * @throws EmptyStackException si la pila esta vacia
	 */
	T peekAndPop() throws EmptyStackException;
	
	/**
	 * Comprueba si la pila esta vacia.
	 *
	 * @return true si pila vacia, sino false
	 */
	boolean isEmpty();

	/**
	 * Pone pila logicamente a vacio.
	 */
	void clear();

	/**
	 * Size.
	 *
	 * @return Tamano de la pila
	 */
	int size();
}

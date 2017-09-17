package org.mp.sesion04;

// TODO: Auto-generated Javadoc
/**
 * The Class StackArray.
 *
 * @param <T> the generic type
 */
public class StackArray<T> implements Stack<T> {

	// atributo - pila StackArray
	/** The stack array. */
	private T[] stackArray;
	// atributo - parte superior pila
	/** The top of stack. */
	private int topOfStack;
	// atributo - capacidad por defecto pila
	/** The Constant DEFAULT_CAPACITY. */
	private static final int DEFAULT_CAPACITY = 10;
	// atributo - tamaño de la pila
	/** The size. */
	private int size;

	/**
	 * Instantiates a new stack array.
	 */
	public StackArray() {
		stackArray = (T[]) new Object[DEFAULT_CAPACITY];
		topOfStack = -1;
		size = 0;
	}

	/**
	 * Inserta un elemento nuevo en la pila.
	 *
	 * @param x the x
	 */
	public void push(T x) {
		ensureCapacity();
		stackArray[topOfStack + 1] = x;
		topOfStack++;
		size++;
	}
	
	/**
	 * Ensure capacity.
	 */
	private void ensureCapacity(){
		if(topOfStack+1 == stackArray.length){
		T [] temp = (T[]) new Object[stackArray.length * 2];
		for(int i=0;i<stackArray.length;i++){
			temp[i] = stackArray[i];
		}
		stackArray = temp;
		}
	}

	/**
	 * *
	 * Elimina el elemento mas reciente insertado.
	 *
	 * @throws EmptyStackException the empty stack exception
	 */
	public void pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException("Pila Vacia");
		}
		topOfStack--;
		size--;
	}
	

	/**
	 * Obtiene el elemento mas recientemente insertado en la pila. no altera la
	 * pila
	 *
	 * @return the t
	 * @throws EmptyStackException the empty stack exception
	 */

	public T peek() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException("Pila Vacia");
		}
		T temp = stackArray[topOfStack];
		return temp;

	}

	/**
	 * Devuelve y elimina el elemento mas reciente insertado en la pila.
	 *
	 * @return the t
	 * @throws EmptyStackException the empty stack exception
	 */
	public T peekAndPop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException("Pila Vacia");
		}
		T temp = (T) stackArray[topOfStack];
		topOfStack--;
		size--;
		return temp;
	}

	/**
	 * Comprueba si la pila esta vacia.
	 *
	 * @return true, if is empty
	 */
	public boolean isEmpty() {
		return topOfStack == -1;
	}

	/**
	 * Pone pila logicamente a vacio.
	 */
	public void clear() {
		stackArray = (T[]) new Object[DEFAULT_CAPACITY];
		topOfStack = -1;
		size = 0;
	}

	/**
	 * return tamaño de la pila.
	 *
	 * @return the int
	 */
	public int size() {
		return size;
	}
	
	
}

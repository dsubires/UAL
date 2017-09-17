package junioMP;

import java.util.Iterator;

import org.mp.sesion04.EmptyStackException;

public class StackLinkedListIterable<T> implements Stack<T> {

	private ListNode<T> topOfStack;
	private int size;

	public StackLinkedListIterable() {
		topOfStack = null;
		size = 0;

	}

	public void push(T x) {
		topOfStack = new ListNode<T>(x, topOfStack);
		size++;
	}

	/**
	 * Elimina el elemento mas recientemente insertado.
	 * 
	 * @throws EmptyStackException
	 *             si la pila esta vacia
	 */
	public void pop() throws EmptyStackException {
		topOfStack = topOfStack.next;
		size--;
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
		return topOfStack.element;
	}

	/**
	 * Devuelve y elimina el elemento mas recientemente inserta en pila.
	 * 
	 * @return elemento insertado
	 * @throws EmptyStackException
	 *             si la pila esta vacia
	 */
	public T peekAndPop() throws EmptyStackException {
		T temp = peek();
		pop();
		return temp;
	}

	/**
	 * Comprueba si la pila esta vacia.
	 * 
	 * @return true si pila vacia, sino false
	 */
	public boolean isEmpty() {
		return topOfStack == null;
	}

	/**
	 * Pone pila logicamente a vacio.
	 */
	public void clear() {
		topOfStack = null;
	}

	/**
	 * Size.
	 * 
	 * @return Tamano de la pila
	 */
	public int size() {
		return size;
	}

	public Iterator<T> iterator() {
		return new StackIterator<T>(topOfStack);
	}

}

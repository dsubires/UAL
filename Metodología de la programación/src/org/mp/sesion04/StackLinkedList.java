package org.mp.sesion04;

// TODO: Auto-generated Javadoc
/**
 * The Class StackLinkedList.
 *
 * @param <T> the generic type
 */
public class StackLinkedList<T> implements Stack<T> {

	/** The top of stack. */
	private ListNode<T> topOfStack;
	
	/** The size. */
	private int size;
	
	/**
	 * Instantiates a new stack linked list.
	 */
	public StackLinkedList(){
		topOfStack = null;
		size = 0;
	}
	
	/**
	 * Inserta un elemento nuevo en la pila.
	 *
	 * @param x the x
	 */
	public void push(T x){
		topOfStack = new ListNode<T>(x, topOfStack);
		size++;
	}
	
	/**
	 * Elimina el elemento mas reciente.
	 *
	 * @throws EmptyStackException the empty stack exception
	 */
	public void pop() throws EmptyStackException{
		if(isEmpty()){
			throw new EmptyStackException("Pila Vacia");
		}
		topOfStack = topOfStack.next;
		size--;
	}
	
	/**
	 * Obtiene el elemento mas reciente. No altera la pila
	 *
	 * @return the t
	 * @throws EmptyStackException the empty stack exception
	 */
	public T peek() throws EmptyStackException{
		if(isEmpty()){
			throw new EmptyStackException("Pila Vacia");
		}
		return topOfStack.element;
	}
	
	/**
	 * Obtiene y elimina el elemento mas reciente de la pila.
	 *
	 * @return the t
	 * @throws EmptyStackException the empty stack exception
	 */
	public T peekAndPop()throws EmptyStackException{
		if(isEmpty()){
			throw new EmptyStackException("Pila Vacia");
		}
		T temp = topOfStack.element;
		topOfStack = topOfStack.next;
		return temp;
	}
	
	/**
	 * Comprueba si la pila esta vacia.
	 *
	 * @return true, if is empty
	 */
	public boolean isEmpty(){
		return (topOfStack == null);
	}
	
	/* (non-Javadoc)
	 * @see org.mp.sesion04.Stack#clear()
	 */
	public void clear(){
		topOfStack = null;
	}
	
	/* (non-Javadoc)
	 * @see org.mp.sesion04.Stack#size()
	 */
	public int size(){
		return size;
	}

}

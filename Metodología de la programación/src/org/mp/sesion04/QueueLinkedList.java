package org.mp.sesion04;

// TODO: Auto-generated Javadoc
/**
 * The Class QueueLinkedList.
 *
 * @param <T> the generic type
 */
public class QueueLinkedList<T> implements Queue<T>, List<T>{
	
	/** The first queue. */
	protected ListNode<T> firstQueue;
	
	/** The last queue. */
	protected ListNode<T> lastQueue;
	
	/** The size. */
	protected int size; 

	/**
	 * Instantiates a new queue linked list.
	 */
	public QueueLinkedList(){
		firstQueue = null;
		lastQueue = null;
		size = 0;
	}
	
	/* (non-Javadoc)
	 * @see org.mp.sesion04.Queue#addLast(java.lang.Object)
	 */
	public void addLast(T x){
		if(isEmpty()){
			firstQueue = lastQueue = new ListNode<T>(x);
			size++;
		}else{
			lastQueue = lastQueue.next = new ListNode<T>(x);
			size++;
		}
	}
	

	/* (non-Javadoc)
	 * @see org.mp.sesion04.Queue#getFirst()
	 */
	public T getFirst() throws EmptyQueueException{
		if(isEmpty()){
			throw new EmptyQueueException("Cola Vacia");
		}else{
			return firstQueue.element;
		}
	}
	

	/* (non-Javadoc)
	 * @see org.mp.sesion04.Queue#removeFirst()
	 */
	public T removeFirst() throws EmptyQueueException{
		if(isEmpty()){
			throw new EmptyQueueException("Cola Vacia");
		}
		T temp = firstQueue.element;
		firstQueue = firstQueue.next;
		size--;
		return temp;
	}
	

	/* (non-Javadoc)
	 * @see org.mp.sesion04.Queue#isEmpty()
	 */
	public boolean isEmpty(){
		return (size == 0);
	}
	
	/* (non-Javadoc)
	 * @see org.mp.sesion04.Queue#clear()
	 */
	public void clear(){
		firstQueue = null;
		lastQueue = null;
		size = 0;
	}
	
	/* (non-Javadoc)
	 * @see org.mp.sesion04.Queue#size()
	 */
	public int size(){
		return size;
	}
	


}

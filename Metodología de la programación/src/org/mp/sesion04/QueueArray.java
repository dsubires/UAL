package org.mp.sesion04;

// TODO: Auto-generated Javadoc
/**
 * The Class QueueArray.
 *
 * @param <T> the generic type
 */
public class QueueArray<T> implements Queue<T> {

	/** The array queue. */
	private T[] arrayQueue;
	
	/** The size queue. */
	private int sizeQueue;
	
	/** The first queue. */
	private int firstQueue;
	
	/** The last queue. */
	private int lastQueue;
	
	/** The size. */
	protected int size;

	/**
	 * Instantiates a new queue array.
	 */
	public QueueArray() {
		arrayQueue = (T[]) new Object[5];
		sizeQueue = 0;
		firstQueue = 0;
		lastQueue = -1;
		size = arrayQueue.length;
	}

	/* (non-Javadoc)
	 * @see org.mp.sesion04.Queue#addLast(java.lang.Object)
	 */
	public void addLast(T x) {
		if (sizeQueue == size) {
			ensureCapacity();
		}
		if(lastQueue == size-1){
			for(int i = 0; i<size;i++){
				if(arrayQueue[i] == null){
					lastQueue = i;
					arrayQueue[lastQueue] = x;
					sizeQueue++;
					break;
				}
			}
		}else{
		lastQueue++;
		arrayQueue[lastQueue] = x;
		sizeQueue++;
		}

	}

	/**
	 * Ensure capacity.
	 */
	private void ensureCapacity() {
		T[] temp = (T[]) new Object[size*2];
		for (int i = 0; i < size; i++) {
			temp[i] = arrayQueue[i];

		}
		arrayQueue = temp;
		size = arrayQueue.length;
	}

	/* (non-Javadoc)
	 * @see org.mp.sesion04.Queue#getFirst()
	 */
	public T getFirst() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException("Cola Vacia");
		}
		return arrayQueue[firstQueue];
	}

	/* (non-Javadoc)
	 * @see org.mp.sesion04.Queue#removeFirst()
	 */
	public T removeFirst() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException("Cola Vacia");
		}
		sizeQueue--;
		T temp = arrayQueue[firstQueue];
		arrayQueue[firstQueue] = null;
		firstQueue++;
		return temp;
	}

	/* (non-Javadoc)
	 * @see org.mp.sesion04.Queue#isEmpty()
	 */
	public boolean isEmpty() {
		return (sizeQueue == 0);
	}

	/* (non-Javadoc)
	 * @see org.mp.sesion04.Queue#clear()
	 */
	public void clear() {
		arrayQueue = (T[]) new Object[5];
		sizeQueue = 0;
		firstQueue = 0;
		lastQueue = -1;
		size = arrayQueue.length;
	}

	/* (non-Javadoc)
	 * @see org.mp.sesion04.Queue#size()
	 */
	public int size() {
		return sizeQueue;
	}

	/**
	 * Gets the array tam.
	 *
	 * @return the array tam
	 */
	public int getArrayTam() {
		return size;
	}

	/**
	 * Gets the first queue.
	 *
	 * @return the first queue
	 */
	public int getFirstQueue() /*throws EmptyQueueException*/  {
		int temp = firstQueue;
		//firstQueue++;
		return temp;
	}

	/**
	 * Gets the last queue.
	 *
	 * @return the last queue
	 */
	public int getLastQueue() /*throws EmptyQueueException */ {
		int temp = lastQueue;
		//lastQueue--;
		return temp;
	}

}

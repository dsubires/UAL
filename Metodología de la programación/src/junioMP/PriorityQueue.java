package junioMP;

public interface PriorityQueue<T extends Comparable<T>> {
	
	void addPriorityQueue(Comparable<T> x);
	Comparable<T> getMin() throws EmptyQueueException;
	Comparable<T> removeMin() throws EmptyQueueException;
	void clear();
	boolean isEmptyPriorityQueue();
	int sizePriorityQueue();	

}

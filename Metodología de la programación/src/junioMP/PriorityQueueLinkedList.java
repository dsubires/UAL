package junioMP;

/**
 * 
 * @author David Subires
 *
 */

public class PriorityQueueLinkedList<T extends Comparable<T>> implements PriorityQueue<T> {

	private ListNode<T> firstQueue;
	private ListNode<T> addQueue;
	private int size;
	
	
	public PriorityQueueLinkedList(){
		firstQueue = null;
		addQueue = null;
		size = 0;
	}


	@Override
	public void addPriorityQueue(Comparable<T> x) {
		
		if(size == 0){
			firstQueue = new ListNode<T>((T) x);
		}else if(x.compareTo(firstQueue.element) < 0){
			firstQueue = new ListNode<T>((T) x,firstQueue);
		}else{
			addQueue = firstQueue;
			while( addQueue.next != null){
				
				if(x.compareTo(addQueue.next.element) < 0){
					ListNode<T> temp = addQueue.next;
					addQueue.next = new ListNode<T>((T) x,temp);
					break;
				}
				addQueue = addQueue.next;													
			}
			//si dentro del while no se ha añadido ningun nodo, lo añadimos al final
			if(addQueue.next == null){
				addQueue.next = new ListNode<T>((T) x);
			}
		}
		size++;
	}


	@Override
	public Comparable<T> getMin() throws EmptyQueueException {
		if(isEmptyPriorityQueue()){
			throw new EmptyQueueException("Cola vacía");
		}
		return firstQueue.element;
	}


	@Override
	public Comparable<T> removeMin() throws EmptyQueueException {
		if(isEmptyPriorityQueue()){
			throw new EmptyQueueException("Cola vacía");
		}
		T temp = firstQueue.element;
		firstQueue = firstQueue.next;
		size--;
		return temp;
	}


	@Override
	public void clear() {
		firstQueue = null;
		addQueue = null;
		size = 0;
	}


	@Override
	public boolean isEmptyPriorityQueue() {
		return size == 0;
	}


	@Override
	public int sizePriorityQueue() {
		return size;
	}
	
	
	public static void main(String[] args){
		
		PriorityQueueLinkedList<Integer> colaPrioridad = new PriorityQueueLinkedList<Integer>();
		
		colaPrioridad.addPriorityQueue(new Integer(1));
		colaPrioridad.addPriorityQueue(new Integer(8));
		colaPrioridad.addPriorityQueue(new Integer(7));
		colaPrioridad.addPriorityQueue(new Integer(6));
		colaPrioridad.addPriorityQueue(new Integer(5));
		colaPrioridad.addPriorityQueue(new Integer(4));
		colaPrioridad.addPriorityQueue(new Integer(3));
		colaPrioridad.addPriorityQueue(new Integer(2));
		colaPrioridad.addPriorityQueue(new Integer(8));
		
		
		
		try{
		System.out.println(colaPrioridad.removeMin());
		System.out.println(colaPrioridad.removeMin());
		System.out.println(colaPrioridad.removeMin());
		System.out.println(colaPrioridad.removeMin());
		System.out.println(colaPrioridad.removeMin());
		System.out.println(colaPrioridad.removeMin());
		System.out.println(colaPrioridad.removeMin());
		System.out.println(colaPrioridad.removeMin());
		System.out.println(colaPrioridad.removeMin());
		System.out.println(colaPrioridad.removeMin());
		
		
		
		}catch(EmptyQueueException e){
			e.printStackTrace();
		}
		
	}

	
}
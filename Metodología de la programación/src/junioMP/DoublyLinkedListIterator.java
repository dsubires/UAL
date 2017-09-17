package junioMP;

public class DoublyLinkedListIterator<T> implements ListIterator<T> {

	protected DoublyLinkedList<T> theDoubleList;
	protected ListNodeDoubly<T> current;
	
	public DoublyLinkedListIterator(DoublyLinkedList<T> list){
		theDoubleList = list;
		current = null;
	}


	public void addAfter(T x) throws NoSuchElementException {

		ListNodeDoubly<T> temp;
		if(theDoubleList == null){
			throw new NoSuchElementException("Doubly List no inicializada");
		}
		
		if(theDoubleList.headNode.next.element == null){
			current = new ListNodeDoubly<T>(theDoubleList.headNode.next,x,theDoubleList.headNode.previous);
			theDoubleList.headNode.next = current;
			theDoubleList.headNode.previous = current;
		}else{
			current = theDoubleList.headNode.next;
			temp = new ListNodeDoubly<T>(theDoubleList.headNode, x, current);
			theDoubleList.headNode.next = temp;
			current.previous = temp;
		}
		
	}


	public void addBefore(T x) throws NoSuchElementException {

		ListNodeDoubly<T> temp;
		if(theDoubleList == null){
			throw new NoSuchElementException("Doubly List Vacia");
		}
		
		if(theDoubleList.headNode.next.element == null){
			current = new ListNodeDoubly<T>(theDoubleList.headNode.next,x,theDoubleList.headNode.previous);
			theDoubleList.headNode.next = current;
			theDoubleList.headNode.previous = current;
		}else{
			current = theDoubleList.headNode.previous;
			temp = new ListNodeDoubly<T>(current, x, theDoubleList.headNode);
			theDoubleList.headNode.previous = temp;
			current.next = temp;
		}

	}


	public void remove(T x) throws NoSuchElementException {
		ListNodeDoubly<T> temp;
		current = theDoubleList.headNode;
		
		while(hasNext()){
			if(current.next.element.equals(x)){
				temp = current.next;
				current.next = temp.next;
				temp = temp.next;
				temp.previous = current;
				break;
			}
			previous();
		}
		
	}


	public boolean contains(T x) throws NoSuchElementException {

		return false;
	}


	public void zero() {
		theDoubleList = new DoublyLinkedList<>();
		current = null;
	}

	@Override
	public void first() throws NoSuchElementException {
		current = theDoubleList.headNode.previous;
	}

	@Override
	public void last() throws NoSuchElementException {
		current = theDoubleList.headNode.next;
	}

	@Override
	public void next() {
		current = current.previous;
	}

	@Override
	public void previous() {
		current = current.next;
	}

	@Override
	public boolean isCurrentValid() {
		return current.element != null;
	}

	@Override
	public boolean hasNext() {
		return current.next != null;
	}

	@Override
	public boolean hasPrevious() {
		return current.previous != null;
	}

	@Override
	public T get() throws NoSuchElementException {
		if(theDoubleList.isEmpty()){
			throw new NoSuchElementException("Current null");
		}
		return current.element;
	}
	

	



}

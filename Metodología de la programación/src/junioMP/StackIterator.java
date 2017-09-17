package junioMP;

public class StackIterator<T> implements java.util.Iterator<T> {
	
	private ListNode<T> current;
	
	public StackIterator(ListNode<T> current){
		this.current = current;
	}
	
	public boolean hasNext(){
		return current.next != null;
	}
	
	public void remove(){
		throw new UnsupportedOperationException();
	}
	
	public T next(){
		T temp = current.element;
		current = current.next;
		return temp;
	}
	

}

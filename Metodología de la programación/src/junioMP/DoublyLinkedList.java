package junioMP;

public class DoublyLinkedList<T> implements List<T> {

	protected ListNodeDoubly<T> headNode;

	
	public DoublyLinkedList(){

		/*		
		 headNode = null;
		headNode.previous = headNode.next;
		headNode.next = headNode.previous;
		*/
		
		headNode = new ListNodeDoubly<T>(null);
		headNode.next = headNode;
		headNode.previous = headNode;

	}
	
	public boolean isEmpty() {
		return headNode.next.element == null && headNode.previous.element == null; 
	}


	public void clear() {
		headNode = new ListNodeDoubly<T>(null);
		headNode.next = headNode;
		headNode.previous = headNode;
		}

	

}

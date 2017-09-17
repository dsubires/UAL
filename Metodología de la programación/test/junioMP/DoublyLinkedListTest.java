package junioMP;

public class DoublyLinkedListTest {

	public static void main(String[] args) {
		List<Integer> laLista = new DoublyLinkedList<Integer>();
		ListIterator<Integer> iterador = 
			new DoublyLinkedListIterator<Integer>((DoublyLinkedList<Integer>) laLista);
		
/*		for (int i = 0; i < 10; i++)
			try{
				iterador.addAfter(i); // Explicar la inserccion
			}catch (Exception e){
			}		
*/
		iterador.zero();
		
		for (int i = 0; i < 10; i++)
			try{
				iterador.addBefore(i+10); // Explicar la inserccion
			}catch (Exception e){
			}	

		
//		iterador.zero();
		
/*		try{
			System.out.println("Contenido de Lista Doblemente Enlazada Recorrido Previo");
			for (iterador.last(); iterador.isCurrentValid(); iterador.previous())
				System.out.print(iterador.get().toString() + " ");
		}
		catch (NoSuchElementException e){
			
		} */
		try{
				System.out.println("Contenido de ListaEnlazada");
				for (iterador.first(); iterador.isCurrentValid(); iterador.next())
					System.out.print(iterador.get().toString() + " ");
			}catch (NoSuchElementException e){
					
			} 
	}
}

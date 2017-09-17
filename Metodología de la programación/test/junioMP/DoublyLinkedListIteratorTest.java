package junioMP;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class DoublyLinkedListIteratorTest {
	
	private String mensaje;
	
	private DoublyLinkedList<Integer> theList = new DoublyLinkedList<Integer>();
	
	private ListIterator<Integer> iteratorList;

	@Before
	public void setUp() throws Exception {
		iteratorList = new DoublyLinkedListIterator<Integer>(theList);
		
	}

	@Test
	public void testIsEmpty() {

	    assertTrue(theList.isEmpty());

	    try {
	          iteratorList.get();
	          mensaje = "Debe saltar la excepcion";
	          fail(mensaje);
	        }catch (NoSuchElementException e) {
	        }
	}

	@Test
	public void testClear() {
		mensaje = "Debe estar vacia";
	    
		theList.clear();
		assertTrue(mensaje,theList.isEmpty());
		
		try{
			iteratorList.addAfter(new Integer(11));
			iteratorList.addAfter(new Integer(23));
			iteratorList.addAfter(new Integer(40));
		}catch (Exception e){
			
		}

		mensaje = "No debe estar vacia";
	    assertFalse(mensaje,theList.isEmpty());

	    theList.clear();

	    mensaje = "Debe estar vacia";
	    assertTrue(mensaje,theList.isEmpty());

	    try {
	        iteratorList.get();
	        mensaje = "Debe saltar la excepcion";
	        fail(mensaje);
	        } catch (NoSuchElementException e) {

	        }
	    }

	@Test
	public void testAddAfter() {

		theList.clear();
		
		assertTrue(theList.isEmpty());

		for (int i = 0; i < 100; i++)
			try{
				iteratorList.addAfter(i);
			}catch (Exception e){
				
			}		
		
		try{
			iteratorList.first();
			for (int i = 0; i < 100; i++)
			{
				assertEquals((Integer) i, iteratorList.get());
				iteratorList.next();
			}
		}catch (Exception e){
			mensaje = "Debe fallar si metodo no implementado";
			fail(mensaje);
		}

		int i = 0;
		
		try{
			for (iteratorList.first(); iteratorList.isCurrentValid(); iteratorList.next())
				assertEquals((Integer) (i++), iteratorList.get());
		}
		catch (Exception e){
			
		}
		
		i = 100;
				
		try{
			for (iteratorList.last(); iteratorList.isCurrentValid(); iteratorList.previous())
				assertEquals((Integer) (--i), iteratorList.get());
		}
		catch (Exception e){
			
		}
		
	}
	
	@Test
	public void testAddBefore() {

		theList.clear();
		
		assertTrue(theList.isEmpty());

		for (int i = 0; i < 100; i++)
			try{
				iteratorList.addBefore(i);
			}catch (Exception e){
			}		

		try{
			iteratorList.first();
				assertEquals((Integer) 99, iteratorList.get());
		}catch (Exception e){
			mensaje = "Debe fallar si metodo no implementado";
			fail(mensaje);
		}
		
		int i = 100;
		
		try{
			for (iteratorList.first(); iteratorList.isCurrentValid(); iteratorList.next()){
				assertEquals((Integer) (--i), iteratorList.get());
			}
		}
		catch (Exception e){
			
		}
		
		i = 0;
				
		try{
			for (iteratorList.last(); iteratorList.isCurrentValid(); iteratorList.previous())
				assertEquals((Integer) (i++), iteratorList.get());
		}
		catch (Exception e){
			
		}
		
	}
	
	@Test
	public void testRemoveElement() {

		theList.clear();
		assertTrue(theList.isEmpty());
		
		try{
			iteratorList.remove(0);
		}catch(Exception e){
			assertTrue(true);
		}
		
		try{
			for (int i=0 ; i<100 ; i++)
				iteratorList.addAfter((Integer)i);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			iteratorList.remove(99);
			iteratorList.remove(90);
		}catch (Exception e) {
			assertTrue(true);
		}
		
		try{
			iteratorList.first();
			for (int i = 0; i < 90; i++){
				assertEquals((Integer) i, iteratorList.get());
				iteratorList.next();
			}
		}catch (Exception e){
			assertTrue(true);
		}
		
		try{
			for (int i= 0; i < 8 ; i++){
				assertEquals((Integer) (i+91), iteratorList.get());
				iteratorList.next();
			}
		}catch (Exception e){
			assertTrue(true);
		}
		
		try{
			iteratorList.remove((Integer) 100);
		}catch (Exception e){
			assertTrue(true);
		}
		
		try{
			assertFalse(iteratorList.contains((Integer) 100));
		}catch (Exception e){
			assertTrue(true);
		}
		
		assertFalse(theList.isEmpty());				
	}

	@Test
	public void testContainElement() {
	
		theList.clear();
		assertTrue(theList.isEmpty());
		
		try{
			iteratorList.contains(0);
		}catch(Exception e){
			assertTrue(true);
		}
		
		try{
			for (int i=0 ; i<100 ; i++)
				iteratorList.addAfter((Integer)i);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			iteratorList.contains(99);
			iteratorList.contains(90);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try{
			iteratorList.first();
			for (int i = 0; i < 90; i++){
				assertEquals((Integer) i, iteratorList.get());
				iteratorList.next();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		
		try{
			for (int i= 0; i < 9 ; i++){
				assertEquals((Integer) (i+90), iteratorList.get());
				iteratorList.next();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		
		try{
			iteratorList.contains((Integer) 100);
		}catch (Exception e){
			assertTrue(true);
		}
				
		assertFalse(theList.isEmpty());				
	}
}
package org.mp.sesion05;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LinkedListIteratorSortedTest {

	private LinkedList<Integer> theList = new LinkedList<Integer>();
	
	private LinkedListIteratorSorted<Integer> iteratorListSorted;

	@Before
	public void setUp() throws Exception {
		iteratorListSorted = 
				new LinkedListIteratorSorted<Integer>(theList);
		
	}

	@Test
	public void testAddSortedList() {

		assertTrue(theList.isEmpty());

		try{
			iteratorListSorted.add(new Integer(3));
			iteratorListSorted.add(new Integer(14));
			iteratorListSorted.add(new Integer(2));
			iteratorListSorted.add(new Integer(9));
			
		}catch (NoSuchElementException e){
			e.printStackTrace();
		}

		
		assertFalse(theList.isEmpty());
		
		try{
			iteratorListSorted.first();
			assertEquals(new Integer(2), iteratorListSorted.get());
			iteratorListSorted.next();
			assertEquals(new Integer(3), iteratorListSorted.get());
			iteratorListSorted.next();
			assertEquals(new Integer(9), iteratorListSorted.get());
			iteratorListSorted.next();
			assertEquals(new Integer(14), iteratorListSorted.get());
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}
	}
}



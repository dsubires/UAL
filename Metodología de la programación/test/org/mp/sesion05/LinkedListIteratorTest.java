package org.mp.sesion05;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LinkedListIteratorTest {

	private LinkedList<Integer> theList = new LinkedList<Integer>();
	
	private LinkedListIterator<Integer> iteratorList;

	@Before
	public void setUp() throws Exception {
		iteratorList = new LinkedListIterator<Integer>(theList);
		
	}

	@Test
	public void testAddEmptyList() {

		assertTrue(theList.isEmpty());

		try{
			iteratorList.add(new Integer(3));
		}catch (NoSuchElementException e){
			
		}

		assertFalse(theList.isEmpty());
		try{
			assertFalse(iteratorList.contains(new Integer(6)));
			assertFalse(iteratorList.contains(new Integer(6)));
		}catch(NoSuchElementException e){
			
		}
		
		try{
			assertEquals(new Integer(3), iteratorList.get());
		}catch (NoSuchElementException e){
			e.printStackTrace();
		}
	}

	@Test
	public void testInListTraverse() {

		theList.clear();
		iteratorList.zero();
		
		try{
			for (int i = 0; i < 10; i++)
				iteratorList.add(new Integer(i));
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}
		
		int i=0;

		try{
			for (iteratorList.first(); iteratorList.hasNext(); iteratorList.next()){
				assertEquals((Integer)i, iteratorList.get());
				i++;
			}
		}catch (NoSuchElementException e){
				e.printStackTrace();
			}
	}
	
	
	@Test
	public void testAddBetweenElement() {

		theList.clear();
		iteratorList.zero();
		
		try{
			iteratorList.add(new Integer(1));
			iteratorList.add(new Integer(2));
			iteratorList.first();
			iteratorList.add(new Integer(0));
		}catch (NoSuchElementException e){
			e.printStackTrace();
		}
		
		assertFalse(theList.isEmpty());
		
		try{
			iteratorList.first();
			assertEquals((Integer) 1 , iteratorList.get());
		}catch (NoSuchElementException e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAddBeforeFirstElement() {

		theList.clear();
		iteratorList.zero();
	
		try{
			iteratorList.add(0);
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}

		iteratorList.zero();
		
		try{
			iteratorList.add(1);
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}
		
		
		try{
			iteratorList.first();
			assertEquals((Integer) 1, (Integer) iteratorList.get());
		}catch (NoSuchElementException e){
			e.printStackTrace();
		}
	}

	@Test
	public void testAddAfterLastElement() {
	
		theList.clear();
		iteratorList.zero();
	
		try{
			iteratorList.add(0);
			iteratorList.add(1);
			iteratorList.add(2);
		}catch (NoSuchElementException e){
			e.printStackTrace();
		}
		

		try{
			iteratorList.add(3);
		}catch (NoSuchElementException e){
			e.printStackTrace();
		}
		
		try{
			assertEquals((Integer)3, (Integer)iteratorList.get());
		}catch (NoSuchElementException e){
			e.printStackTrace();
		}
	}

	@Test
	public void testRemoveElement() {

		theList.clear();
		
		try{
			iteratorList.remove(0);
		}catch(NoSuchElementException e){
			assertTrue(true);
		}
		
		try{
			iteratorList.add(0);
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}
		
		try{
			assertEquals((Integer) 0, iteratorList.get());
		}catch (NoSuchElementException e){
			e.printStackTrace();
		}
		
		try{
			iteratorList.remove(0);
			iteratorList.remove(1);
		}catch (NoSuchElementException e) {
			assertTrue(true);
		}
		
		assertTrue(theList.isEmpty());				
	}
	
	@Test
	public void testGetInEmptyList() {
		
		theList.clear();
		try{
			System.out.println(iteratorList.get().toString());
		}catch(NoSuchElementException e){
			assertTrue(true);
		}
		
		
		try {
			iteratorList.add(5);
			iteratorList.get();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
		
	@Test
	public void testContainsInEmptyList() {

		theList.clear();
		
		iteratorList.zero();
		
		try{
			iteratorList.contains(3);
		}catch (NoSuchElementException e){
			assertTrue(true);
		}
	}
	
	@Test
	public void testEmptyIterator() {

		theList.clear();

		assertFalse(iteratorList.hasNext());

		try {
			iteratorList.get();
			fail();
		} catch (NoSuchElementException e) {
			/*esperado*/
			assertTrue(true);
		}
	}

	@Test
	public void testListIterator() {

		try{
			
			iteratorList.add(1);
			iteratorList.add(2);
			iteratorList.add(40);
		
			iteratorList.first();
			assertTrue(iteratorList.hasNext());
			assertEquals((Integer) 1, (Integer) iteratorList.get());

			iteratorList.next();
			assertTrue(iteratorList.hasNext());
			assertEquals((Integer) 2, (Integer) iteratorList.get());

			iteratorList.next();
			assertTrue(iteratorList.hasNext());
			assertEquals((Integer) 40, (Integer) iteratorList.get());

			iteratorList.next();
			assertFalse(iteratorList.hasNext());

			iteratorList.get();
			
		} catch (NoSuchElementException e) {
            /*esperado*/
			assertTrue(true);
		}
	}

	@Test
	public void testClear() {

		try {
			iteratorList.add(20);
			iteratorList.add(40);
			iteratorList.add(50);
		}catch (NoSuchElementException e){
			e.printStackTrace();
		}

		assertFalse(theList.isEmpty());
		theList.clear();
		assertTrue(theList.isEmpty());
	}

}



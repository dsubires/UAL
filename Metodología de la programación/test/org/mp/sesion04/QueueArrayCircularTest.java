package org.mp.sesion04;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QueueArrayCircularTest {

    private QueueArray<Integer> queue;

    @Before
    public void setUp() throws Exception {
        queue = new QueueArray<Integer>();
    }
   
    @Test
    public void testCicularQueue() {
    	
    	for (int i=0; i<queue.getArrayTam(); i++)
    		queue.addLast(i+10);
        
        assertEquals((Integer)(queue.size()-1), (Integer) queue.getLastQueue());
      	
      	assertEquals((Integer) 0, (Integer) queue.getFirstQueue());
      	
        
        try {
        	assertEquals((Integer) 10, (Integer) queue.removeFirst());
        } catch(EmptyQueueException e) {
        	e.printStackTrace();
        }
        		
        try {
        	assertEquals((Integer) 11, (Integer) queue.removeFirst());
        } catch(EmptyQueueException e) {
        	e.printStackTrace();
        }
        
        assertEquals((Integer) (queue.getArrayTam()-1), (Integer) queue.getLastQueue());
      	
       	assertEquals((Integer) 2, (Integer) queue.getFirstQueue());

       	queue.addLast(60);
 
      	assertEquals((Integer) 0, (Integer) queue.getLastQueue());
      	
      	queue.addLast(70);
      	
      	assertEquals((Integer) 1, (Integer) queue.getLastQueue());
      	
      	assertEquals((Integer) 2, (Integer) queue.getFirstQueue());
    }

}

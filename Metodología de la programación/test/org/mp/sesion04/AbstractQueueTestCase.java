package org.mp.sesion04;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public abstract class AbstractQueueTestCase {

	private String mensaje;
    private Queue<Integer> queue;

    @Before
    public void setUp() throws Exception {
        queue = makeQueue();
    }

    protected abstract Queue<Integer> makeQueue();

    @Test
    public void testIsEmpty() {

    	mensaje = "El tamano de la cola debe ser 0";
        assertEquals(mensaje,0, queue.size());
        mensaje = "Debe estar vacia";
        assertTrue(mensaje,queue.isEmpty());

        try {
            queue.removeFirst();
            mensaje = "Debe saltar la excepcion";
            fail(mensaje);
        } catch (EmptyQueueException e) {

        }
    }

    @Test
    public void testClear() {

    	mensaje = "Debe estar vacia";
        assertTrue(mensaje,queue.isEmpty());

        queue.addLast(new Integer(11));
        queue.addLast(new Integer(23));
        queue.addLast(new Integer(40));

        mensaje = "No debe estar vacia";
        assertFalse(mensaje,queue.isEmpty());

        queue.clear();

        mensaje = "El tamano de la cola debe ser 0";
        assertEquals(mensaje,0, queue.size());
        mensaje = "Debe estar vacia";
        assertTrue(mensaje,queue.isEmpty());

        try {
            queue.removeFirst();
            mensaje = "Debe saltar la excepcion";
            fail(mensaje);
        } catch (EmptyQueueException e) {

        }
    }

    @Test
    public void testAddLastAndRemoveFirst() {

        Integer entero1 = new Integer(11);
        Integer entero2 = new Integer(35);
        Integer entero3 = new Integer(20);

        queue.addLast(entero1);
        queue.addLast(entero2);
        queue.addLast(entero3);

        mensaje = "El tamano de la cola debe ser 3";
        assertEquals(mensaje,3, queue.size());
        mensaje = "No debe estar vacia";
        assertFalse(mensaje,queue.isEmpty());

        try {
        	mensaje = "Deben ser iguales";
            assertEquals(mensaje,entero1, queue.removeFirst());
        } catch (EmptyQueueException e3) {

            e3.printStackTrace();
        }

        mensaje = "El tamano de la cola debe ser 2";
        assertEquals(mensaje,2, queue.size());
        mensaje = "No debe estar vacia";
        assertFalse(mensaje,queue.isEmpty());

        try {
        	mensaje = "Deben ser iguales";
            assertEquals(mensaje,entero2, queue.removeFirst());
        } catch (EmptyQueueException e2) {

            e2.printStackTrace();
        }

        mensaje = "El tamano de la cola debe ser 1";
        assertEquals(mensaje,1, queue.size());
        mensaje = "No debe estar vacia";
        assertFalse(mensaje,queue.isEmpty());

        try {
        	mensaje = "Deben ser iguales";
            assertEquals(mensaje,entero3, queue.removeFirst());
        } catch (EmptyQueueException e1) {

            e1.printStackTrace();
        }

        mensaje = "El tamano de la cola debe ser 0";
        assertEquals(mensaje,0, queue.size());
        mensaje = "Debe estar vacia";
        assertTrue(mensaje,queue.isEmpty());

        try {
            queue.removeFirst();
            mensaje = "Debe saltar la excepcion";
            fail(mensaje);

        } catch (EmptyQueueException e) {

        }
    }

    @Test
    public void testAddLast() {

        for (int i = 0; i < 1000; i++) {
            Integer entero = new Integer(i);
            queue.addLast(entero);
        }

        mensaje = "No debe estar vacia";
        assertFalse(mensaje,queue.isEmpty());

        for (int i = 0; i < 1000; i++) {
            Integer entero = new Integer(i);
            try {
            	mensaje = "Deben ser iguales";
                assertEquals(mensaje,queue.removeFirst(), entero);
            } catch (EmptyQueueException e) {

                e.printStackTrace();
            }
        }

        mensaje = "Debe estar vacia";
        assertTrue(mensaje,queue.isEmpty());

    }

}

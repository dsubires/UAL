package org.mp.sesion04;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public abstract class AbstractStackTestCase {

	private String mensaje;
    private Stack<Integer> stack;

    @Before
    public void setUp() throws Exception {
        stack = makeStack();
    }

    protected abstract Stack<Integer> makeStack();

    @Test
    public void testIsEmpty() {

    	mensaje = "Debe estar vacia";
        assertTrue(mensaje,stack.isEmpty());
        stack.push(new Integer(1));
        mensaje = "NO debe estar vacia";
        assertFalse(mensaje,stack.isEmpty());
        stack.clear();
        mensaje = "Debe estar vacia";
        assertTrue(mensaje,stack.isEmpty());

    }

    @Test
    public void testClear() {

        stack.clear();
        mensaje = "Debe estar vacia";
        assertTrue(mensaje,stack.isEmpty());
        stack.push(new Integer(11));
        mensaje = "NO debe estar vacia";
        assertFalse(mensaje,stack.isEmpty());
        stack.clear();
        mensaje = "Debe estar vacia";
        assertTrue(mensaje,stack.isEmpty());
    }

    @Test
    public void testPeek() {

        for (int i = 0; i < 100; i++) {
            Integer entero = new Integer(i);
            stack.push(entero);
        }
        try {
        	mensaje = "El ultimo en entrar fue el 99";
            assertEquals(mensaje,stack.peek(), new Integer(99));
        } catch (EmptyStackException e1) {

            e1.printStackTrace();
        }

        stack.clear();

        try {
            stack.peek();

        } catch (EmptyStackException e1) {

            EmptyStackException e = new EmptyStackException("Pila Vacia");
            mensaje = "No es la excepcion esperada";
            assertEquals(mensaje,e.getMessage(), e1.getMessage());
            //e1.printStackTrace();
        }

    }

    @Test
    public void testPop() throws EmptyStackException {

        for (int i = 0; i < 100; i++) {
            Integer entero = new Integer(i);
            stack.push(entero);
        }
        stack.pop();
        mensaje = "Deberia ser 98";
        assertEquals(mensaje, stack.peek(), new Integer(98));
        mensaje = "NO debe estar vacia";
        assertFalse(mensaje,stack.isEmpty());

    }

    @Test
    public void testPeekAndPoop() throws EmptyStackException {

        stack.clear();
        for (int i = 0; i < 100; i++) {
            Integer entero = new Integer(i);
            stack.push(entero);
        }
        mensaje = "Deberia ser 99";
        assertEquals(mensaje, stack.peek(), new Integer(99));
        for (int i = 0; i < 100; i++) {
            assertEquals(stack.peekAndPop(), new Integer(99 - i));
        }
        mensaje = "Debe estar vacia";
        assertTrue(mensaje,stack.isEmpty());

    }

    @Test
    public void testPush() throws EmptyStackException {

        for (int i = 0; i < 100; i++) {
            Integer entero = new Integer(i);
            stack.push(entero);
            assertEquals(stack.peek(), entero);
        }
        mensaje = "NO debe estar vacia";
        assertFalse(mensaje,stack.isEmpty());

    }
}

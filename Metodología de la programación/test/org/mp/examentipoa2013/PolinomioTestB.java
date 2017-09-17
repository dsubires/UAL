package org.mp.examentipoa2013;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PolinomioTestB {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSuma() {
		double[] a ={2, 1};
		double[] b ={1, 1};
		Polinomio p = new Polinomio(a);
		Polinomio q = new Polinomio(b);
		Polinomio suma = p.suma(q);
		double[] result ={3, 2};
		Polinomio r = new Polinomio(result);
		System.out.println("p: " + p);
		System.out.println("q: " + q);
		System.out.println("r: " + r);
		assertTrue(suma.equals(r));
	}

	@Test
	public void testResta() {
		double[] a ={2, 1};
		double[] b ={1, 1};
		Polinomio p = new Polinomio(a);
		Polinomio q = new Polinomio(b);
		Polinomio suma = p.resta(q);
		double[] result ={1};
		Polinomio r = new Polinomio(result);
		assertTrue(suma.equals(r));
	}


	@Test
	public void testToString() {
		double[] a ={3, -8, 0, 0, 2, 1};
		double[] b ={0, 5, 6, 9};
		Polinomio p = new Polinomio(a);
		System.out.println("p: " + p);
		Polinomio q = new Polinomio(b);
		System.out.println("q: " + q);
		
		assertTrue(p.toString().contains("3,00 - 8,00x + 2,00x^4 + 1,00x^5"));
		assertTrue(q.toString().contains(" 5,00x + 6,00x^2 + 9,00x^3"));
	}
	
	
	
}

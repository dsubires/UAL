package org.mp.examentipoa2013;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PolinomioTestA {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIsCero() {
		Polinomio p = new Polinomio();
		assertTrue(p.isCero());
	}
	
	@Test
	public void testGetCoeficientes() {
		double[] a ={3, -8, 0, 0, 2, 1};
		Polinomio p = new Polinomio(a);
		double[] coef = p.getCoeficientes();
		for (int i = 0; i < coef.length; i++) {
			System.out.print(coef[i]+" ");
			assertTrue(a[i]==coef[i]);
		}
		System.out.println();
	}
	
	@Test
	public void testGrado() {
		double[] a ={3, -8, 0, 0, 2, 1};
		Polinomio p = new Polinomio(a);
		assertTrue(p.grado()==5);
		double[] b ={0, 5, 6, 9};
		Polinomio q = new Polinomio(b);
		assertTrue(q.grado()==3);
	}

	@Test
	public void testMultiplicacionEscalar() {
		double[] a ={3, -8, 0, 0, 2, 1};
		Polinomio p = new Polinomio(a);
		for (int i = 0; i < a.length; i++) {
			a[i]=a[i]*2.0;
		}
		Polinomio result = new Polinomio(a);
		assertTrue(p.multiplicacion(2.0).equals(result));
	}
	
	@Test
	public void testMultiplicacionPolinomio() {
		double[] d ={1,1};
		double[] e ={-2,1};
		Polinomio r = new Polinomio(d);
		Polinomio s = new Polinomio(e);
		//System.out.println("r: " + r);
		//System.out.println("s: " + s);
		Polinomio rs = new Polinomio(r.multiplicacion(s));
		//System.out.println("r*s: " +rs);
		double[] result ={-2,-1,1};
		Polinomio presult = new Polinomio(result);
		
		assertTrue(rs.equals(presult));
		
		double[] f = { -1,1};
		Polinomio t = new Polinomio(f);
		//System.out.println("t: " + t);
		Polinomio rst = new Polinomio(rs.multiplicacion(t));
		//System.out.println("r*s*t: " + rst);
		double[] result1 ={2,-1,-2,1};
		Polinomio presult1 = new Polinomio(result1);
		
		assertTrue(rst.equals(presult1));
	}	
	
	@Test
	public void testEvaluar() {
		
		double[] a ={3, -8, 0, 0, 2, 1};
		double[] b ={0, 5, 6, 9};
		Polinomio p = new Polinomio(a);
		System.out.println("p: " + p);
		Polinomio q = new Polinomio(b);
		System.out.println("q: " + q);
	
		System.out.println(p.evaluar(2.0));
		assertTrue(p.evaluar(2.0)==51);
		System.out.println(p.evaluar(1.0));
		assertTrue(p.evaluar(1.0)==-2);
	
	}
	
}

package org.lya.practica2.ejercicio1;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;




public class ExponenteTest{
	private Exponente solEXP;
	
	@Before
	

	@Test		
	public void testExponenCero() {
		solEXP = new Exponente(4,0); 
		assertTrue(solEXP.exponenFuerzaBruta() == 1.0);
		assertTrue(solEXP.exponenRecursivoDyV() == 1.0);
	}
	
	@Test
	public void testExponenUno() {
		solEXP =  new Exponente(4,1); 
		assertTrue(solEXP.exponenFuerzaBruta() == 4 );
		assertTrue(solEXP.exponenRecursivoDyV() == 4);
	}

	@Test
	public void testExponenFuerzaBruta() {
		solEXP =  new Exponente(3,10); 
		assertTrue(solEXP.exponenFuerzaBruta() == 59049);
	}

	@Test
	public void testExponenRecursivoDyVExponente() {
		solEXP =  new Exponente(3,10); 
		assertTrue(solEXP.exponenRecursivoDyV() == 59049);
	}
	
	@Test
	public void testExponenTwoPowers() {
		solEXP =  new Exponente(2, 2); 
		
		for (int expon=2; expon<=30; expon++){		
		   solEXP.setExpon(expon);	
		   assertTrue(solEXP.exponenRecursivoDyV() == Math.pow(2, expon));
		 
		}
	}

}

package org.lya.practica2.ejercicio2;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class CoeficienteBinTest{
	private CoeficienteBin solCB;

	@Before
	
	@Test		
	public void testCoefBinomialUno() {
		solCB = new CoeficienteBin(6,0); // (6,0)
		assertTrue(solCB.coefBinomialRecursivo() == 1 );
		assertTrue(solCB.coefBinomialProgDinam() == 1 );
		solCB.setK(6); // (6,6)
		assertTrue(solCB.coefBinomialRecursivo() == 1 );
		assertTrue(solCB.coefBinomialProgDinam() == 1 );
	}
	
	@Test
	public void testCoefBinomialCero() {
		solCB = new CoeficienteBin(0,5); 
		assertTrue(solCB.coefBinomialRecursivo() == 0 );
		assertTrue(solCB.coefBinomialProgDinam() == 0 );
		solCB.setN(1); // (1,5)
		assertTrue(solCB.coefBinomialRecursivo() == 0 );
		assertTrue(solCB.coefBinomialProgDinam() == 0 );

	}
	
	@Test
	public void testCoefBinomialRecursivo() {
		solCB = new CoeficienteBin(6,4);
		assertTrue(solCB.coefBinomialRecursivo() == 15 );
		solCB.setK(3); // (6,3)
		assertTrue(solCB.coefBinomialRecursivo() == 20 );
	}

	@Test
	public void testCoefBinomialProgDinam() {
		solCB = new CoeficienteBin(6,4);
		assertTrue(solCB.coefBinomialProgDinam() == 15 );
		solCB.setK(3); // (6,3)
		assertTrue(solCB.coefBinomialProgDinam() == 20 );
	}

}

package org.mp.sesion09;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Sesion09TestA {

	@Before
	public void setUp() throws Exception {
	}



	@Test
	public void testIndalo() {
		String[] args = null;
		Indalo.main(args);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGrafo() {
		String[] args = null;
		Grafo.main(args);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCalculadora() {
		String[] args = null;
		CalculadoraSencilla.main(args);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAnalisisDatos() {
		String[] args = null;
		AnalisisDatos.main(args);
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package org.mp.sesion02;

import static org.junit.Assert.*;

import org.junit.Test;


public class MayorTest {

	@Test
	public void testNormal() {
		int[] arr = new int[3];
		arr[0] = 9;
		arr[1] = 8;
		arr[2] = 7;
		assertEquals(9, Mayor.elEnteroMayor(arr));
	}

	@Test
	public void testOrden() {
		assertEquals(9, Mayor.elEnteroMayor(new int[] { 9, 8, 7 }));
		assertEquals(9, Mayor.elEnteroMayor(new int[] { 7, 9, 8 }));
		assertEquals(9, Mayor.elEnteroMayor(new int[] { 7, 8, 9 }));
	}

	@Test
	public void testNegativo() {
		assertEquals(-7, Mayor.elEnteroMayor(new int[] { -9, -8, -7 }));
	}

	@Test
	public void testDuplicados() {
		assertEquals(9, Mayor.elEnteroMayor(new int[] { 9, 8, 9, 7 }));
	}

	@Test
	public void testSoloUno() {
		assertEquals(1, Mayor.elEnteroMayor(new int[] { 1 }));
	}


}

package org.mp.sesion02;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FigurasTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testNombres() {

		double lado1 = 2.0;
		double lado2 = 3.0;

		Rectangulo rectangulo = new Rectangulo(lado1, lado2);
		Cuadrado cuadrado = new Cuadrado(lado1);
		Circulo circulo = new Circulo(lado1);

		assertEquals("Rectangulo", rectangulo.getNombre());
		assertEquals("Cuadrado", cuadrado.getNombre());
		assertEquals("Circulo", circulo.getNombre());

	}

	@Test
	public void testAreas() {

		double lado1 = 2.0;
		double lado2 = 3.0;
		Rectangulo rectangulo = new Rectangulo(lado1, lado2);

		assertEquals(6.0, rectangulo.area(), 0.00001);

		Cuadrado cuadrado = new Cuadrado(lado1);
		assertEquals(4, cuadrado.area(), 0.00001);

		double radio = 1.1;
		Circulo circulo = new Circulo(radio);

		assertEquals(radio * radio * 3.1415, circulo.area(), 0.001);

		assertTrue(circulo.compareTo(circulo) == 0);
		assertTrue(circulo.compareTo(rectangulo) == -1);
		assertTrue(cuadrado.compareTo(rectangulo) == -1);
		assertFalse(cuadrado.compareTo(circulo) == -1);
	}

	@Test
	public void testOrdenacionAreas() {

		Figura[] figuras = new Figura[300];
		NumerosAleatorios r = new NumerosAleatorios();

		for (int i = 0; i < 100; i++) {
			Circulo circulo = new Circulo(r.randomReal() * i);
			figuras[i] = circulo;
		}
		for (int i = 100; i < 200; i++) {
			double lado1 = r.randomReal() * i;
			double lado2 = r.randomReal() * i;
			Rectangulo rectangulo = new Rectangulo(lado1, lado2);
			figuras[i] = rectangulo;
		}
		for (int i = 200; i < 300; i++) {
			double lado1 = r.randomReal() * i;
			Cuadrado cuadrado = new Cuadrado(lado1);
			figuras[i] = cuadrado;
		}

		Figura[] figurasCopia1 = (Figura[]) figuras.clone();
		Figura[] figurasCopia2 = (Figura[]) figuras.clone();

		PruebaFigura.ordenacionPorInsercion(figurasCopia1);

		Arrays.sort(figurasCopia2);

		for (int i = 1; i < figurasCopia1.length; i++) {
			assertEquals(figurasCopia1[i], figurasCopia2[i]);
		}

		for (int i = 1; i < figuras.length; i++) {
			assertTrue(figurasCopia1[i - 1].area() <= figurasCopia1[i].area());
			assertTrue(figurasCopia2[i - 1].area() <= figurasCopia2[i].area());
		}

		// for (int i = 0; i < figurasCopia1.length; i++) {
		// System.out.printf("%1$-10s %2$8.2f \n",figurasCopia1[i].getNombre(),
		// figurasCopia1[i].area());
		// }

	}

}

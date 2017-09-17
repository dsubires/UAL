package org.mp.sesion04;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EvaluadorTest {

	private String mensaje;
	private Evaluador evaluador;

	@Before
	public void setUp() throws Exception {
		evaluador = new Evaluador();
	}

	@Test
	public void testParser() {

		String expresion= "  22 + 2 ";

		String[] array = evaluador.parser(expresion);

		String salida="";

		for (int i = 0; i < array.length; i++) {
			 salida += array[i];
		}
		mensaje = "Debe quitar los blancos";
		assertEquals(mensaje, "22+2", salida);

		expresion = salida;

		array = evaluador.parser(expresion);

		salida="";

		for (int i = 0; i < array.length; i++) {
			 salida += array[i];
		}
		mensaje = "Debe obtener la misma cadena";
		assertEquals(mensaje, expresion, salida);

	}

	@Test
	public void testPostfija() {

		String[] expresion1 = {"3","2","+"};

		mensaje = "Resultado debe ser 5";
		assertEquals(mensaje,5, evaluador.postfija(expresion1));

		String[] expresion2 = {"3","3","+","2","/"};

		mensaje = "Resultado debe ser 3";
		assertEquals(mensaje,3, evaluador.postfija(expresion2));

	}

}

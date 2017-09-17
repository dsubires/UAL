package org.mp.sesion08;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;
import org.mp.sesion04.Stack;

public abstract class AbstractResidenciaTestDAO {

	private DataAccessObject residenciaDAO;
	
	public abstract DataAccessObject makeDataAccessObject();

	@Before
	public void setUp() throws Exception {

		residenciaDAO = makeDataAccessObject();
		
		escribirDatosPrueba();
		
	}
	
	@Test
	public void testLeer() throws IOException {

		Residencia residencia = (Residencia) residenciaDAO.leer();

		assertTrue(residencia.getNombre().equals("La Mar Salá"));

		Habitacion[] habitaciones = residencia.getHabitaciones();

		assertEquals(habitaciones[0].getNumero(), "101");
		assertEquals(habitaciones[1].getNumero(), "102");
		assertEquals(habitaciones[2].getNumero(), "103");
		assertEquals(habitaciones[3].getNumero(), "201");
		assertEquals(habitaciones[4].getNumero(), "202");

	}
	
	public void escribirDatosPrueba() throws IOException, ParseException {


		Habitacion habitacion1 = new Habitacion("101");
		Habitacion habitacion2 = new Habitacion("102");
		Habitacion habitacion3 = new Habitacion("103");
		Habitacion habitacion4 = new Habitacion("201");
		Habitacion habitacion5 = new Habitacion("202");

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		Residente residente1 = new Residente("Martinez Gomez, Adrian", "27272727", 'V',
				dateFormat.parse("12-02-1940"));
		Residente residente2 = new Residente("Lopez Lopez, Luisa", "27272728", 'M',
				dateFormat.parse("12-03-1940"));


		Habitacion[] habitaciones = { habitacion1, habitacion2, habitacion3,
				habitacion4, habitacion5 };

		Residencia residencia = new Residencia("La Mar Salá",  habitaciones);

		residencia.ingreso(residente1, habitacion1,
				dateFormat.parse("12-01-2007"), dateFormat.parse("12-06-2007"));
		residencia.ingreso(residente2, habitacion2,
				dateFormat.parse("12-02-2007"), dateFormat.parse("12-06-2007"));

		residenciaDAO.escribir(residencia);

	}
}

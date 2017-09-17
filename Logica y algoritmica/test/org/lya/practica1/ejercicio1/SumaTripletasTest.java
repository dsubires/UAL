package org.lya.practica1.ejercicio1;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SumaTripletasTest {
	private SecuenciaEnteros secuenciaProblema;


	@Before
	


	@Test
       public void testEjemplotripletaSumCount() {

        int[] datos = {30, -30, -20, -10, 40, 0, 10, 6, 5};

        secuenciaProblema = new SecuenciaEnteros(datos);

        int num = SumaTripletas.tripletaSumCount(secuenciaProblema);
        assertTrue(num == 4);
    
	}
  }

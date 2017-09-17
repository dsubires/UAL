package org.lya.practica1.ejercicio2;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SubsecuenciaTest {
	private SecuenciaEnteros secuenciaProblema;


	@Before
	


	@Test
       public void testSubsecuenciaNormal() {

        int[] datos = { 1, 2, 3, 0, 0, 0, -1, 0 };

        secuenciaProblema = new SecuenciaEnteros(datos);

        Subsecuencia.SubsecuenciaFuerzaBruta(secuenciaProblema);
        assertTrue(Subsecuencia.getSuma() == 6);
        assertTrue(Subsecuencia.getPrimer() == 0);
        assertTrue(Subsecuencia.getUltimo() == 2);

        Subsecuencia.SubsecuenciaMejorado(secuenciaProblema);
        assertTrue(Subsecuencia.getSuma() == 6);
        assertTrue(Subsecuencia.getPrimer() == 0);
        assertTrue(Subsecuencia.getUltimo() == 2);

        Subsecuencia.SubsecuenciaLineal(secuenciaProblema);
        assertTrue(Subsecuencia.getSuma() == 6);
        assertTrue(Subsecuencia.getPrimer() == 0);
        assertTrue(Subsecuencia.getUltimo() == 2);

    }

	@Test
    public void testSubsecuenciaCero() {

        int[] datos = { 0, 0, 0, 0, 0, 0, 0, 0 };

        secuenciaProblema = new SecuenciaEnteros(datos);

        Subsecuencia.SubsecuenciaFuerzaBruta(secuenciaProblema);
        assertTrue(Subsecuencia.getSuma() == 0);
        assertTrue(Subsecuencia.getPrimer() == 0);
        assertTrue(Subsecuencia.getUltimo() == 0);

        Subsecuencia.SubsecuenciaMejorado(secuenciaProblema);
        assertTrue(Subsecuencia.getSuma() == 0);
        assertTrue(Subsecuencia.getPrimer() == 0);
        assertTrue(Subsecuencia.getUltimo() == 0);

        Subsecuencia.SubsecuenciaLineal(secuenciaProblema);
        assertTrue(Subsecuencia.getSuma() == 0);
        assertTrue(Subsecuencia.getPrimer() == 0);
        assertTrue(Subsecuencia.getUltimo() == 0);

    }

	@Test
    public void testSubsecuenciaNegativos() {

        int[] datos = { -1, -2, -3, -4, -5, -6, -7, -8 };

        secuenciaProblema = new SecuenciaEnteros(datos);

        Subsecuencia.SubsecuenciaFuerzaBruta(secuenciaProblema);
        assertTrue(Subsecuencia.getSuma() == 0);
        assertTrue(Subsecuencia.getPrimer() == 0);
        assertTrue(Subsecuencia.getUltimo() == 0);
        
        Subsecuencia.SubsecuenciaMejorado(secuenciaProblema);
        assertTrue(Subsecuencia.getSuma() == 0);
        assertTrue(Subsecuencia.getPrimer() == 0);
        assertTrue(Subsecuencia.getUltimo() == 0);
        
        Subsecuencia.SubsecuenciaLineal(secuenciaProblema);
        assertTrue(Subsecuencia.getSuma() == 0);
        assertTrue(Subsecuencia.getPrimer() == 0);
        assertTrue(Subsecuencia.getUltimo() == 0);
    }

	@Test
    public void testSubsecuenciaIguales() {

        int[] datos = { 1, 1, 1, 1, 1, 1, 1, 1 };

        secuenciaProblema = new SecuenciaEnteros(datos);

        Subsecuencia.SubsecuenciaFuerzaBruta(secuenciaProblema);
        assertTrue(Subsecuencia.getSuma() == 8);
        assertTrue(Subsecuencia.getPrimer() == 0);
        assertTrue(Subsecuencia.getUltimo() == 7);

        Subsecuencia.SubsecuenciaMejorado(secuenciaProblema);
        assertTrue(Subsecuencia.getSuma() == 8);
        assertTrue(Subsecuencia.getPrimer() == 0);
        assertTrue(Subsecuencia.getUltimo() == 7);

        Subsecuencia.SubsecuenciaLineal(secuenciaProblema);
        assertTrue(Subsecuencia.getSuma() == 8);
        assertTrue(Subsecuencia.getPrimer() == 0);
        assertTrue(Subsecuencia.getUltimo() == 7);

    }

	@Test
    public void testSubsecuenciaAleatorio() {

        int[] sumaMax = new int[3];
        int[] secIni = new int[3];
        int[] secFin = new int[3];

        secuenciaProblema = new SecuenciaEnteros(1000,10);

        Subsecuencia.SubsecuenciaFuerzaBruta(secuenciaProblema);
        sumaMax[0] = Subsecuencia.getSuma();
        secIni[0] = Subsecuencia.getPrimer();
        secFin[0] = Subsecuencia.getUltimo();

        Subsecuencia.SubsecuenciaMejorado(secuenciaProblema);
        sumaMax[1] = Subsecuencia.getSuma();
        secIni[1] = Subsecuencia.getPrimer();
        secFin[1] = Subsecuencia.getUltimo();

        Subsecuencia.SubsecuenciaLineal(secuenciaProblema);
        sumaMax[2] = Subsecuencia.getSuma();
        secIni[2] = Subsecuencia.getPrimer();
        secFin[2] = Subsecuencia.getUltimo();

        assertTrue(sumaMax[0] == sumaMax[1]);
        assertTrue(sumaMax[1] == sumaMax[2]);

        assertTrue(secIni[0] == secIni[1]);
        assertTrue(secIni[1] == secIni[2]);

        assertTrue(secFin[0] == secFin[1]);
        assertTrue(secFin[1] == secFin[2]);

    }

}

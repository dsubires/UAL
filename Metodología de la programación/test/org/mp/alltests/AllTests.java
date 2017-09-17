package org.mp.alltests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	
	org.mp.sesion02.BarajaTestA.class, 
	org.mp.sesion02.FigurasTest.class, 
	org.mp.sesion02.MayorTest.class,
	
	org.mp.sesion03.BibliotecaTestA.class,
	org.mp.sesion03.ResidenciaTestA.class,
	org.mp.sesion03.ResidenciaTestB.class,
	
	org.mp.sesion04.StackArrayTest.class,
	org.mp.sesion04.StackLinkedListTest.class,
	org.mp.sesion04.QueueArrayTest.class,
	org.mp.sesion04.QueueLinkedListTest.class,
	org.mp.sesion04.EvaluadorTest.class,
	org.mp.sesion04.ParadaTaxisTest.class,
	
	org.mp.sesion05.StackLinkedListApiTest.class,
	org.mp.sesion05.QueueLinkedListApiTest.class,
	org.mp.sesion05.LinkedListIteratorTest.class,
	org.mp.sesion05.LinkedListIteratorSortedTest.class,
	
	org.mp.sesion06.OrdenacionTestA.class,
	org.mp.sesion06.SolucionesBusquedaTestA.class,
	org.mp.sesion06.BarajaTestA.class, 
	org.mp.sesion06.BarajaTestB.class, 
	org.mp.sesion06.AccionesTestA.class,
	
	org.mp.sesion07.UtilidadArchivosTestA.class,
	org.mp.sesion07.ConjuntoDatosTestA.class,
	org.mp.sesion07.EstadisticaTestA.class,
	
	org.mp.sesion08.ImagenTestA.class,
	org.mp.sesion08.ResidenciaTestA.class,
	org.mp.sesion08.ResidenciaTestB.class,
	org.mp.sesion08.ResidenciaTestSER.class,
	org.mp.sesion08.ResidenciaTestXML.class,
	

	
	
})

public class AllTests {

}

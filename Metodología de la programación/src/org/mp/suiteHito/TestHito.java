package org.mp.suiteHito;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import org.mp.sesion02.*;
import org.mp.sesion03.*;
import org.mp.sesion04.*;

@RunWith(Suite.class)
@SuiteClasses({ 
	BarajaTestA.class,
	FigurasTest.class, 
	MayorTest.class,
	BibliotecaTestA.class,
	ResidenciaTestA.class, 
	ResidenciaTestB.class,
	EvaluadorTest.class, 
	ParadaTaxisTest.class, 
	QueueLinkedListTest.class,
	QueueArrayTest.class, 
	StackArrayTest.class, 
	StackLinkedListTest.class,
	QueueArrayCircularTest.class 
	})
public class TestHito {

}
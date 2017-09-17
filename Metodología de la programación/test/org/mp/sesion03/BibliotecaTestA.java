package org.mp.sesion03;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BibliotecaTestA {
	
	Biblioteca biblioteca;

	@Before
	public void setUp() throws Exception {
		
		biblioteca = new Biblioteca("Atenas");
	}

	@Test
	public void testIncluirLibro() {
		
		assertTrue(biblioteca.numLibrosBiblioteca()==0);

		Libro libro1 = new Libro("Java5", "Antonio", 1);
		biblioteca.incluirLibro(libro1);
		
		assertTrue(biblioteca.numLibrosBiblioteca()==1);
		
		Libro libro2 = new Libro("Java6", "Julio", 2);
		biblioteca.incluirLibro(libro2);
		
		assertTrue(biblioteca.numLibrosBiblioteca()==2);
		
		Libro[] librosTemp = biblioteca.getLibrosDisponiblesParaPrestamo();
		
		boolean b = false;
		for (int i = 0; i < librosTemp.length; i++) {
			if(librosTemp[i].equals(libro1)){
				b = true;
				break;
			}
		}
		assertTrue(b == true);
		
		b= false;
		for (int i = 0; i < librosTemp.length; i++) {
			if(librosTemp[i].equals(libro2)){
				b = true;
				break;
			}
		}
		assertTrue(b == true);
		
	
		Libro libro3 = new Libro("Java7", "Manuel", 3);
		
		b=false;
		for (int i = 0; i < librosTemp.length; i++) {
			if(librosTemp[i].equals(libro3)){
				b = true;
				break;
			}
		}
		assertFalse(b == true);
	}
	
	@Test
	public void testIncluirSocios() {
		
		assertTrue(biblioteca.numSociosBiblioteca()==0);
		
		Socio socio = new Socio("Luis");
		biblioteca.registrarSocio(socio);
		
		assertTrue(biblioteca.numSociosBiblioteca()==1);
		biblioteca.getSocios();
		
		Socio[] sociosTemp = biblioteca.getSocios();
		
		boolean b = false;
		for (int i = 0; i < sociosTemp.length; i++) {
			if(sociosTemp[i].equals(socio)){
				b = true;
				break;
			}
		}
		assertTrue(b == true);
	}
	
	@Test
	public void testPrestarLibro() {
		
		Socio socio = new Socio("Juan");
	
		Libro libro1 = new Libro("Java5", "Ken", 1);
		biblioteca.incluirLibro(libro1);
		
		Libro libro2 = new Libro("Java6", "Ken2", 2);
		biblioteca.incluirLibro(libro2);
	
		biblioteca.prestarLibro(libro2, socio);

		Libro[] librosTemp1 = biblioteca.getLibrosDisponiblesParaPrestamo();
		
		boolean b = false;
		for (int i = 0; i < librosTemp1.length; i++) {
			if(librosTemp1[i].equals(libro2)){
				b = true;
				break;
			}
		}
		assertFalse(b == true);
		
		Libro[] librosTemp2 = biblioteca.getLibrosEnPrestamo();
		
		b = false;
		for (int i = 0; i < librosTemp2.length; i++) {
			if(librosTemp2[i].equals(libro2)){
				b = true;
				break;
			}
		}
		assertTrue(b == true);
	}
	
	@Test
	public void testDevolverLibro() {
		
		Socio socio = new Socio("Miguel");
		
		Libro libro1 = new Libro("Java", "Ken", 1);
		biblioteca.incluirLibro(libro1);
		
		Libro libro2 = new Libro("Java2", "Ken2", 2);
		biblioteca.incluirLibro(libro2);
		
		biblioteca.prestarLibro(libro1, socio);
		
		Libro[] librosTemp1 = biblioteca.getLibrosDisponiblesParaPrestamo();
		
		boolean b = false;
		for (int i = 0; i < librosTemp1.length; i++) {
			if(librosTemp1[i].equals(libro1)){
				b = true;
				break;
			}
		}
		assertFalse(b == true);

		Libro[] librosTemp2 = biblioteca.getLibrosEnPrestamo();
		
		b = false;
		for (int i = 0; i < librosTemp2.length; i++) {
			if(librosTemp2[i].equals(libro1)){
				b = true;
				break;
			}
		}
		assertTrue(b == true);

		biblioteca.devolverLibro(libro1);
		Libro[] librosTemp3 = biblioteca.getLibrosEnPrestamo();
		
		b = false;
		for (int i = 0; i < librosTemp3.length; i++) {
			if(librosTemp3[i].equals(libro1)){
				b = true;
				break;
			}
		}
		assertFalse(b == true);
	}


}

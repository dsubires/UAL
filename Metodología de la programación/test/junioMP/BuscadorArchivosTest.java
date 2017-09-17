package junioMP;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BuscadorArchivosTest {

	List listadoControl;
	
	@Before
	public void setUp() throws Exception {
		listadoControl = new ArrayList();
	}

	@Test
	public void testListadoFile() {
		String directorioEntrada = System.getProperty("user.dir");

		directorioEntrada = directorioEntrada + File.separator + "src"
				+ File.separator + "org"  ;
		
		BuscadorArchivos buscadorArchivos = new BuscadorArchivos();

		List lista = null;
	
		lista = buscadorArchivos.listado(new File(directorioEntrada));
	
		
		todosArchivosDirectorios(new File(directorioEntrada));
		
		for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
			File file = (File) iterator.next();
			assertTrue(listadoControl.contains(file));
			//System.out.println(file.getAbsolutePath());
		}
	}
	
	@Test
	public void testListadoString() {
		String directorioEntrada = System.getProperty("user.dir");

		directorioEntrada = directorioEntrada + File.separator + "src"
				+ File.separator + "org"  ;
		
		BuscadorArchivos buscadorArchivos = new BuscadorArchivos();
		List lista = null;
	
		lista = buscadorArchivos.listado(directorioEntrada);
	
		
		todosArchivosDirectorios(new File(directorioEntrada));
		
		for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
			File file = (File) iterator.next();
			assertTrue(listadoControl.contains(file));
			//System.out.println(file.getAbsolutePath());
		}
	}
	
	@Test	
	public void testListadoStringException() {
		String directorioEntrada = System.getProperty("user.dir");

		directorioEntrada = directorioEntrada + File.separator + "src1"
				+ File.separator + "org"  ;
		
		BuscadorArchivos buscadorArchivos = new BuscadorArchivos();
		
		try {
			buscadorArchivos.listado(directorioEntrada);
			fail();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void testBuscarArchivo() {
		String directorioEntrada = System.getProperty("user.dir");

		directorioEntrada = directorioEntrada + File.separator + "src"
				+ File.separator + "org"
				+ File.separator + "mp"
				+ File.separator + "solucionexamentipoa2012"
				+ File.separator 
				;
		
		BuscadorArchivos buscadorArchivos = new BuscadorArchivos();
	
		List lista = null;

		lista = buscadorArchivos.buscar(directorioEntrada,"BuscadorArchivos");
	
		for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
			File file = (File) iterator.next();
			assertTrue(file.getName().contains("BuscadorArchivos"));
			System.out.println(file.getAbsolutePath());
		}
	
	}
	
	// Procesa todos los archivos y directorios bajo dir
	public void todosArchivosDirectorios(File dir) {
		listadoControl.add(dir);
		
	    if (dir.isDirectory()) {
	        String[] hijos = dir.list();
	        for (int i=0; i<hijos.length; i++) {
	        	todosArchivosDirectorios(new File(dir, hijos[i]));
	        }
	    }
	 }
}

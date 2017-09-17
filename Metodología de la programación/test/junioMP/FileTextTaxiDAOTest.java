package junioMP;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import junit.framework.TestCase;


public class FileTextTaxiDAOTest extends TestCase {

	String mensaje;
	String directorioEntrada;
	String archivoDatos;
	FileTextDAO taxiDao;
	Taxi taxi1;
	Taxi taxi2;
	Taxi taxi3;
	Taxi taxi4;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		directorioEntrada = System.getProperty("user.dir");
		archivoDatos = directorioEntrada + 
						File.separator + "src"+
						File.separator + "junioMP"+
						File.separator + "Taxis.txt";
		
		taxiDao = new FileTextTaxiDAO(archivoDatos, ";");

		taxi1 = new Taxi(1, "Juan Perez", true);
		taxi2 = new Taxi(2, "Jose Martinez", false);
		taxi3 = new Taxi(3, "Luis Gonzalez", false);
		taxi4 = new Taxi(4, "Andres Iniesta", true);

		File f = new File(archivoDatos);
		FileWriter fw = new FileWriter(f);
		BufferedWriter bf = new BufferedWriter(fw);

		bf.write("1" + ";" + "Juan Perez" + ";" + true + "\n");
		bf.write("2" + ";" + "Jose Martinez" + ";" + false + "\n");
		bf.write("3" + ";" + "Luis Gonzalez" + ";" + false + "\n");
		bf.close();
	}
	
	
	public void testBuscar()  {
		// System.out.println(taxiDao.buscar(taxi2));
		assertEquals(taxi2, (Taxi)taxiDao.buscar(taxi2));
		assertNull(taxiDao.buscar(taxi4));
	}

	public void testAnadir() {
		assertNull(taxiDao.buscar(taxi4));
		taxiDao.anadir(taxi4);
		assertEquals(taxi4, (Taxi)taxiDao.buscar(taxi4));
	}

	public void testEliminar()  {
		assertEquals(taxi1, (Taxi) taxiDao.buscar(taxi1));
		taxiDao.eliminar(taxi1);
		assertNull(taxiDao.buscar(taxi1));
	}

	public void testModificar() {
		taxi2.setPropietario("Alberto Gomez");
		taxi2.setMinusvalido(true);
		taxiDao.modificar(taxi2);
		Taxi taxi = (Taxi) taxiDao.buscar(taxi2);
		assertEquals(taxi.getPropietario(),"Alberto Gomez");
		assertTrue(taxi.isMinusvalido()==true);
	}
	
	public void testExcepciones() {
		
		String taxi = "Hola Mundo";
		try {
			taxiDao.buscar(taxi);
			fail("debe saltar la excepción");
		} catch (Exception e) {
			//System.out.println(e);
			assertTrue(e.getClass().getName()=="java.lang.ClassCastException");
			
		}
	}
}

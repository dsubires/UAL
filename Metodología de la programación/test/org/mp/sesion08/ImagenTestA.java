package org.mp.sesion08;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mp.sesion08.BandaInt;
import org.mp.sesion08.Imagen;
import org.mp.sesion08.ImagenDAO;
import org.mp.sesion08.XYFueraImagenException;

public class ImagenTestA {
	
	String mensaje;
	String directorioEntrada;
	String cabecera;
	String directorioDatos;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		directorioEntrada = System.getProperty("user.dir");

		directorioDatos = directorioEntrada + File.separator + "test"
				+ File.separator + "org" + File.separator + "mp"
				+ File.separator + "sesion08" + File.separator;

		cabecera = directorioDatos + "imagen.cabecera";

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
    public void testLeerEscribirImagen() throws IOException {

        Imagen imagen = ImagenDAO.leerArchivo(cabecera);

        // Todas estas aserciones deben ser ciertas.
        assertTrue(imagen.getFormatoImagen().equals("BSQ"));
        assertTrue(imagen.getNumeroBandas() == 5);
        assertTrue(imagen.getLineas() == 100);
        assertTrue(imagen.getColumnas() == 100);

        assertEquals(((BandaInt) imagen.getBandas().get(0)).getNombreBanda(),"Banda1");
        assertEquals(((BandaInt) imagen.getBandas().get(1)).getNombreBanda(),"Banda2");
        assertEquals(((BandaInt) imagen.getBandas().get(2)).getNombreBanda(),"Banda3");
        assertEquals(((BandaInt) imagen.getBandas().get(3)).getNombreBanda(),"Banda4");
        assertEquals(((BandaInt) imagen.getBandas().get(4)).getNombreBanda(),"Banda5");

        imagen.eliminarBanda(0);
        mensaje = "Debe haber una banda menos";
        assertTrue(mensaje,imagen.getNumeroBandas() == 4);

        String salida = directorioDatos + "imagen1.cabecera";
        ImagenDAO.escribirArchivo(salida, imagen);

        String nombreFichero1 = directorioDatos + "imagen.dat";
        File fichero1 = new File(nombreFichero1);
        String nombreFichero2 = directorioDatos + "imagen1.dat";
        File fichero2 = new File(nombreFichero2);

        mensaje = "El archivo nuevo debe ser mayor";
        assertTrue(mensaje, fichero1.length() > fichero2.length());

        // Comprobación del archivo escrito

        imagen = ImagenDAO.leerArchivo(salida);

        // Todas estas aserciones deben ser ciertas.

        assertTrue(imagen.getFormatoImagen().equals("BSQ"));
        assertTrue(imagen.getNumeroBandas() == 4);
        assertTrue(imagen.getLineas() == 100);
        assertTrue(imagen.getColumnas() == 100);

        assertEquals(((BandaInt) imagen.getBandas().get(0)).getNombreBanda(),"Banda2");
        assertEquals(((BandaInt) imagen.getBandas().get(1)).getNombreBanda(),"Banda3");
        assertEquals(((BandaInt) imagen.getBandas().get(2)).getNombreBanda(),"Banda4");
        assertEquals(((BandaInt) imagen.getBandas().get(3)).getNombreBanda(),"Banda5");

    }
	
	@Test
    public void testExtraerDatosPixel() throws IOException {

        Imagen imagen = ImagenDAO.leerArchivo(cabecera);

        int[] control = {10000, 20000, 30000, 40000, 50000};
        try {
			int[] pixel = imagen.getDatosPixel(0, 0);
			for (int i = 0; i < control.length; i++) {
				assertTrue(control[i]==pixel[i]);
			}

		} catch (XYFueraImagenException e) {
			e.printStackTrace();
		}

		int[] control1 = {10001, 20001, 30001, 40001, 50001};
        try {
			int[] pixel = imagen.getDatosPixel(1, 0);
			for (int i = 0; i < control1.length; i++) {
				assertTrue(control1[i]==pixel[i]);
			}

		} catch (XYFueraImagenException e) {
			e.printStackTrace();
		}

		int[] control2 = {10099, 20099, 30099, 40099, 50099};
        try {
			int[] pixel = imagen.getDatosPixel(99, 0);
			for (int i = 0; i < control2.length; i++) {
				assertTrue(control2[i]==pixel[i]);
			}

		} catch (XYFueraImagenException e) {
			e.printStackTrace();
		}

		int[] control3 = {10499, 20499, 30499, 40499, 50499};
        try {
			int[] pixel = imagen.getDatosPixel(99, 4);
			for (int i = 0; i < control3.length; i++) {
				assertTrue(control3[i]==pixel[i]);
			}

		} catch (XYFueraImagenException e) {
			e.printStackTrace();
		}

		//Debe saltar la excepción por acceso no valido.

		try {
			int[] pixel = imagen.getDatosPixel(101, 4);
			fail("Debe saltar la excepción");
		} catch (XYFueraImagenException e) {
			/*esperado*/
			assertTrue(true);
		}

		try {
			int[] pixel = imagen.getDatosPixel(-1, 4);
			fail("debe saltar la excepción");
		} catch (XYFueraImagenException e) {
			/*esperado*/
			assertTrue(true);
		}

    }
	
	
	@Test
    public void testExtraerImagen() throws IOException {

        Imagen imagen = ImagenDAO.leerArchivo(cabecera);
        // Todas estas aserciones deben ser ciertas.
        assertTrue(imagen.getFormatoImagen().equals("BSQ"));
        assertTrue(imagen.getNumeroBandas() == 5);
        assertTrue(imagen.getLineas() == 100);
        assertTrue(imagen.getColumnas() == 100);

        try {
			Imagen imagenNueva = imagen.extraerImagen(0, 0, 9, 9);
			assertTrue(imagenNueva.getFormatoImagen().equals("BSQ"));
	        assertTrue(imagenNueva.getNumeroBandas() == 5);
	        assertTrue(imagenNueva.getLineas() == 10);
	        assertTrue(imagenNueva.getColumnas() == 10);
		} catch (XYFueraImagenException e) {
			e.printStackTrace();
		}

		try {
			Imagen imagenNueva = imagen.extraerImagen(0, 0, 9, 2);
			assertTrue(imagenNueva.getFormatoImagen().equals("BSQ"));
	        assertTrue(imagenNueva.getNumeroBandas() == 5);
	        assertTrue(imagenNueva.getLineas() == 3);
	        assertTrue(imagenNueva.getColumnas() == 10);
		} catch (XYFueraImagenException e) {
			e.printStackTrace();
		}

		try {
			Imagen imagenNueva = imagen.extraerImagen(80, 80, 90, 90);
			assertTrue(imagenNueva.getFormatoImagen().equals("BSQ"));
	        assertTrue(imagenNueva.getNumeroBandas() == 5);
	        assertTrue(imagenNueva.getLineas() == 11);
	        assertTrue(imagenNueva.getColumnas() == 11);
		} catch (XYFueraImagenException e) {
			e.printStackTrace();
		}

		try {
			Imagen imagenNueva = imagen.extraerImagen(80, 80, 101, 101);
			fail("Debe saltar la excepción");
		} catch (XYFueraImagenException e) {
			/*esperado*/
			assertTrue(true);
		}

    }


}

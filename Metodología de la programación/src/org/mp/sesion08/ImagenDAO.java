package org.mp.sesion08;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Clase ImagenDAO. Permite escribir una imagen binaria BSQ en un fichero de
 * texto, y leer el fichero y devolver una Imagen
 * 
 * @author David Subires Parra
 * 
 */
public class ImagenDAO {

	/**
	 * Escribe un fichero de texto cabecera con los datos necesarios para
	 * procesar la imagen y llama al metodo privado escribirBSQ() para
	 * escribirla en disco
	 * 
	 * @param nombreArchivo
	 *            nombre del archivo cabecera
	 * @param imagen
	 *            imagen a escribir en disco
	 */
	public static void escribirArchivo(String nombreArchivo, Imagen imagen) {

		try {
			File f = new File(nombreArchivo);

			int posicionPunto = f.getName().indexOf(".");
			String ficheroB = f.getName().substring(0, posicionPunto) + ".dat";

			FileWriter fw = new FileWriter(nombreArchivo);
			BufferedWriter bw = new BufferedWriter(fw);	
			PrintWriter pw = new PrintWriter(bw);
			pw.println(ficheroB);
			pw.println(imagen.getFormatoImagen());
			pw.println(imagen.getNumeroBandas());
			String cabecera = "[";
			ArrayList<BandaInt> arrayList = imagen.getBandas();
			for (int i = 0; i < arrayList.size(); i++) {
				cabecera = cabecera + arrayList.get(i).toString() + ";";
			}
			cabecera = cabecera + "]";
			pw.println(cabecera);
			pw.println(imagen.getLineas());
			pw.println(imagen.getColumnas());
			pw.close();
			ficheroB = f.getParent() + File.separator + ficheroB;

			escribirBSQ(ficheroB, imagen);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Metodo privado escribirBSQ. Se encarga de escribir la imagen en disco en
	 * formato binario.
	 * 
	 * @param nombreArchivo
	 *            nombre y ruta del archivo donde se escribira la imagen
	 * @param imagen
	 *            imagen a escribir en disco
	 */
	private static void escribirBSQ(String nombreArchivo, Imagen imagen) {
		try {
			// Creamos flujo de escritura
			FileOutputStream fos = new FileOutputStream(nombreArchivo);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			DataOutputStream escribir = new DataOutputStream(bos);
			ArrayList<BandaInt> bandas = imagen.getBandas();

			ListIterator<BandaInt> iterador = bandas.listIterator();
			while (iterador.hasNext()) {

				BandaInt bandaTemp = iterador.next();

				for (int j = 0; j < imagen.getLineas(); j++) {
					for (int k = 0; k < imagen.getColumnas(); k++) {
						escribir.writeInt(bandaTemp.getDatoXY(k, j));
					}

				}
			}
			escribir.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Lee el fichero cabecera para obtener los datos y llama al metodo privado
	 * leerBSQ() para leer la imagen desde un fichero binario
	 * 
	 * @param nombreArchivo
	 *            nombre del fichero de texto cabecera a leer
	 * @return Imagen leida del archivo
	 */
	public static Imagen leerArchivo(String nombreArchivo) {
		String ficheroB, formato, temp;
		int nBandas;
		String[] bandas;
		int lineas, columnas;

		try {
			// Abrimos el archivo cabecera
			File file = new File(nombreArchivo);
			FileInputStream fstream = new FileInputStream(file);
			// Creamos el objeto de entrada
			DataInputStream entrada = new DataInputStream(fstream);
			// Creamos el buffer de lectura
			BufferedReader buffer = new BufferedReader(new InputStreamReader(
					entrada));
			// Leer el archivo linea por linea
			ficheroB = file.getParent() + File.separator + buffer.readLine();

			formato = buffer.readLine();
			nBandas = Integer.parseInt(buffer.readLine());
			temp = buffer.readLine();
			temp = temp.replace("[", "");
			temp = temp.replace("]", "");
			bandas = temp.split(";");
			lineas = Integer.parseInt(buffer.readLine());
			columnas = Integer.parseInt(buffer.readLine());
			entrada.close();
			return leerBSQ(ficheroB, new Imagen(lineas, columnas, formato),
					bandas);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	/**
	 * Metodo privado que se encarga de leer la imagen desde un fichero binario
	 * y devolverla.
	 * 
	 * @param nombreArchivo
	 *            nombre del fichero binario a leer
	 * @param imagen
	 *            Imagen instanciada con el numero de lineas, columnas y formato
	 *            de la imagen a leer
	 * @param nbandas
	 *            nombre de las bandas de la imagen a leer
	 * @return Imagen con todas los datos y bandas leidos de fichero
	 */
	private static Imagen leerBSQ(String nombreArchivo, Imagen imagen,
			String[] nbandas) {

		// Creamos flujo de lectura
		File f = new File(nombreArchivo);
		DataInputStream leer;
		try {

			// Se abre el fichero a leer
			leer = new DataInputStream(new FileInputStream(f));

			for (int i = 0; i < nbandas.length; i++) {
				BandaInt banda = new BandaInt(nbandas[i], imagen.getColumnas(),
						imagen.getLineas());
				for (int j = 0; j < imagen.getLineas(); j++) {
					for (int k = 0; k < imagen.getColumnas(); k++) {
						banda.setDatoXY(leer.readInt(), j, k);
					}

				}
				imagen.añadirBanda(banda);
			}
			leer.close();

			return imagen;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}

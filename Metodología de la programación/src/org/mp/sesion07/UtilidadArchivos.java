package org.mp.sesion07;

import java.io.*;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@SuppressWarnings("rawtypes")
/**
 * Clase Utilidad Archivos. Permite copiar archivos, obtener la lista de directorios/archivos(de manera recurrente) 
 * de un directorio y comprimir un archivo.
 * 
 * @author David Subires Parra
 *
 */
public class UtilidadArchivos {

	private ArrayList lista;

	public UtilidadArchivos() {
		lista = new ArrayList();
	}

	/**
	 * Metodo estatico copiar. Copia el archivo origen al destino especificado
	 * 
	 * @param origen
	 *            Archivo origen a copiar
	 * @param destino
	 *            Ruta donde se almacenara la copia del archivo.
	 * @throws IOException
	 *             Archivo origen no se ha podido encontrar
	 */
	public static void copiar(File origen, File destino) throws IOException {
		if (origen == null) {
			throw new IOException("Archivo origen no encontrado");
		}
		InputStream in = new FileInputStream(origen);
		OutputStream out = new FileOutputStream(destino);

		byte[] buf = new byte[1024];
		int len;

		while ((len = in.read(buf)) > 0) {
			out.write(buf, 0, len);
		}

		in.close();
		out.close();
	}

	/**
	 * Metodo listarDirectoriosArchivos. Obtiene los archivos/directorios de una
	 * direccion o ruta mediante el metodo privado DirectoriosArchivosRec
	 * 
	 * @param dir
	 *            File con la direccion para listar sus archivos/directorios
	 * @return Todos los archivos/directorios de dir
	 */
	public ArrayList listarDirectoriosArchivos(File dir) {
		// limpiamos la lista
		lista.clear();
		// añadimos el elemento a la lista
		DirectoriosArchivosRec(dir);
		return lista;
	}

	/**
	 * Metodo privado que añade un archivo/directorio a la lista, en caso de ser
	 * directorio se ejecuta este metodo para añadir todos los elementos de
	 * dicho directorio de manera recurrente.
	 * 
	 * @param dir
	 *            File con la direccion para listar sus archivos/directorios
	 */
	private void DirectoriosArchivosRec(File dir) {
		lista.add(dir);
		if (dir.isDirectory()) {
			String[] contenido = dir.list();
			for (int i = 0; i < contenido.length; i++) {
				DirectoriosArchivosRec(new File(dir, contenido[i]));
			}
		}
	}

	/**
	 * Metodo para comprimir un archivo, especificado el nombre del archivo a
	 * comprimir, el camino de salida y el nombre final del archivo comprimido.
	 * 
	 * @param dir
	 *            Fichero o directorio a comprimir
	 * @param caminoSalida
	 *            Ruta de salida donde guardar el archivo comprimido
	 * @param nombreArchivo
	 *            Nombre del archivo comprimido
	 */
	public void zip(File dir, String caminoSalida, String nombreArchivo) {
		ArrayList elementos = listarDirectoriosArchivos(dir);
		String salidaZip = caminoSalida + File.separator + nombreArchivo;
		byte buffer[] = new byte[1024];

		try {
			String outputFile = caminoSalida + File.separator + nombreArchivo;
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
					salidaZip));

			for (int i = 0; i < lista.size(); i++) {
				File aux = (File) lista.get(i);
				if (aux.isFile()) {
					FileInputStream in = new FileInputStream(
							aux.getAbsolutePath());
					out.putNextEntry(new ZipEntry(aux.getAbsolutePath()));
					int len;
					while ((len = in.read(buffer)) > 0) {
						out.write(buffer, 0, len);
					}
					out.closeEntry();
					in.close();
				}
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

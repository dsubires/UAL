package org.mp.sesion08;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Clase ResidenciaSER. Permite guardar una residencia en disco, o reconstruirla
 * desde un archivo, mediante la Serialización de objetos.
 * 
 * @author David Subies Parra
 * 
 */
public class ResidenciaSER implements DataAccessObject {

	private String nombreArchivo;

	/**
	 * Instancia una nueva ResdienciaSER
	 * 
	 * @param nombreArchivo
	 *            nombre del archivo donde se guardara o leera una residencia
	 */
	public ResidenciaSER(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	/**
	 * Lee desde archivo una residencia, la reconstruye y la devuelve.
	 * 
	 * @return residencia des-serializada
	 */
	@Override
	public Object leer() {
		Residencia residencia = null;
		File f = new File(nombreArchivo);
		try {
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			residencia = (Residencia) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return residencia;
	}

	/**
	 * Serializa el objeto pasado como parametro a un fichero en disco.
	 * 
	 * @param object
	 *            objeto a serializar
	 */
	@Override
	public void escribir(Object object) {
		Residencia residencia = (Residencia) object;
		File f = new File(nombreArchivo);
		try {
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(residencia);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
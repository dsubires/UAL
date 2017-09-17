package org.mp.sesion08;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Clase ResidenciaXML. Almacena y recupera residencias desde/hacia ficheros XML
 * 
 * @author David Subires Parra
 * 
 */
public class ResidenciaXML implements DataAccessObject {

	private String nombreArchivo;
	private XStream xs;

	/**
	 * Instancia una ResidenciaXML
	 * 
	 * @param nombreArchivo
	 *            nombre del fichero mediante el cual se leera/escribira una
	 *            residencia
	 */
	public ResidenciaXML(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
		xs = new XStream(new DomDriver("UTF-8"));

		xs.alias("residencia", Residencia.class);
		xs.alias("residente", Residente.class);
		xs.alias("reserva", Reserva.class);
		xs.alias("habitacion", Habitacion.class);

	}

	
	/**
	 * Lee desde archivo una residencia, la reconstruye y la devuelve.
	 * 
	 * @return residencia reconstruida a partir de fichero XML
	 */
	@Override
	public Object leer() {
		return (Residencia) xs.fromXML(new File(nombreArchivo));
	}
	/**
	 * Escribe el objeto pasado como parametro a un fichero XML en disco.
	 * 
	 * @param object
	 *            objeto a escribir en disco en fichero XML
	 */
	@Override
	public void escribir(Object object) {
		FileOutputStream fs;
		try {
			fs = new FileOutputStream(nombreArchivo);
			xs.toXML(object, fs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}

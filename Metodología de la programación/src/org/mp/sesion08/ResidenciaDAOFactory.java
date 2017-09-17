package org.mp.sesion08;

/**
 * Clase ResidenciaDAOFactory. Permite reconstruir una residencia mediante un
 * archivo binario Serializado o mediante un xml
 * 
 * @author David Subires Parra
 * 
 */
public class ResidenciaDAOFactory {

	protected String nombreArchivo;

	/**
	 * Metodo estatico que devuelve un objeto tipo ResidenciaSER o ResidenciaXML
	 * 
	 * @param nombreArchivo
	 *            nombre y ruta del archivo donde estan almacenados los datos de
	 *            la residencia a reconstruir
	 * @param tipo
	 *            tipo de reconstruccion que se hará, Serializable o XML.
	 * @return instancia ResidenciaSER o ResidenciaXML preparada para
	 *         reconstruir o guardar residencias en/desde archivo
	 */
	public static DataAccessObject createResidenciaDAOFactory(
			String nombreArchivo, String tipo) {

		DataAccessObject dao = null;
		if (tipo.equals("ser")) {
			dao = new ResidenciaSER(nombreArchivo);
		}

		if (tipo.equals("xml")) {
			dao = new ResidenciaXML(nombreArchivo);
		}
		return dao;
	}

	/**
	 * Metodo getter del nombre del archivo
	 * 
	 * @return nombre archivo
	 */
	public String getNombreArchivo() {
		return nombreArchivo;
	}

	/**
	 * Metodo setter del nombre del archivo
	 * 
	 * @param nombreArchivo
	 *            nombre del archivo
	 */
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

}

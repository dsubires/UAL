package org.mp.sesion06;

/**
 * Clase con metodos estaticos que implementan diferentes algoritmos de busqueda
 * Busqueda lineal, Busqueda binaria iterativa y busqueda binaria recursiva
 * 
 * @author David Subires Parra
 * 
 */
public class SolucionesBusqueda {
	/**
	 * Metodo estatico que implementa un algoritmo de busqueda lineal. Se invoca
	 * con un elemento Busqueda como parametro. Devuelve el numero buscado en
	 * caso de encontarlo o la excepcion en caso contrario.
	 * 
	 * @param b
	 *            Elemento Busqueda que contiene los datos y el numero buscado
	 * @return El numero buscado
	 * @throws ElementoNoEncontradoException
	 *             Numero no encontrado
	 */
	public static int busquedaLineal(Busqueda b)
			throws ElementoNoEncontradoException {

		int buscado = b.getNumBuscado();
		int[] temp = b.getDatos();
		boolean encontrado = false;

		for (int i = 0; i < temp.length; i++) {
			if (buscado == temp[i]) {
				encontrado = true;
				break;
			}
		}
		if (!encontrado) {
			throw new ElementoNoEncontradoException("No encontrado");
		}

		return buscado;
	}

	/**
	 * Metodo estatico que implementa un algoritmo de busqueda binaria
	 * iterativa. Se invoca con un elemento Busqueda como parametro. Devuelve el
	 * numero buscado en caso de encontarlo o la excepcion en caso contrario.
	 * 
	 * @param b
	 *            Elemento Busqueda que contiene los datos y el numero buscado
	 * @return El numero buscado
	 * @throws ElementoNoEncontradoException
	 *             Numero no encontrado
	 */
	public static int busquedaBinariaIter(Busqueda b)
			throws ElementoNoEncontradoException {
		int[] datos = b.getDatos();
		int inicio = 0;
		int fin = datos.length - 1;
		int buscado = b.getNumBuscado();

		while (inicio <= fin) {
			int pos = (inicio + fin) / 2;
			if (buscado < datos[pos]) {
				fin = pos - 1;
			} else if (buscado > datos[pos]) {
				inicio = pos + 1;
			} else {
				return buscado;
			}
		}
		throw new ElementoNoEncontradoException("No encontrado");
	}

	/**
	 * Metodo estatico que implementa un algoritmo de busqueda binaria
	 * recursiva. Se invoca con un elemento Busqueda como parametro. Devuelve el
	 * numero buscado en caso de encontarlo o la excepcion en caso contrario.
	 * 
	 * @param b
	 *            Elemento Busqueda que contiene los datos y el numero buscado
	 * @return El numero buscado
	 * @throws ElementoNoEncontradoException
	 *             Numero no encontrado
	 */
	public static int busquedaBinariaRec(Busqueda b)
			throws ElementoNoEncontradoException {

		int[] datos = b.getDatos();
		int inicio = 0;
		int fin = datos.length - 1;
		int buscado = b.getNumBuscado();
		return busquedaBinariaRec(datos, inicio, fin, buscado);
	}


	/**
	 * Metodo privado estatico que es llamado por el metodo busquedaBinariaRec.
	 * Realiza la busqueda binaria recursiva
	 * 
	 * @param datos
	 *            array de datos donde buscar el elemento
	 * @param inicio
	 *            posicion inicial del subconjunto donde buscar el elemento
	 * @param fin
	 *            posicion final del subconjunto donde buscar el elemento
	 * @param buscado
	 *            el elemento a buscar
	 * @return Devuelve el elemento buscado en caso de encontrarlo
	 * @throws ElementoNoEncontradoException
	 *             En caso de no encontrar el elemento buscado, devuelve
	 *             excepcion No encontrado
	 */
	private static int busquedaBinariaRec(int[] datos, int inicio, int fin,
			int buscado) throws ElementoNoEncontradoException {

		if (inicio > fin) {
			throw new ElementoNoEncontradoException("No encontrado");
		} else {
			int pos = (inicio + fin) / 2;
			if (buscado < datos[pos]) {
				return busquedaBinariaRec(datos, inicio, pos - 1, buscado);
			} else if (buscado > datos[pos]) {
				return busquedaBinariaRec(datos, pos + 1, fin, buscado);
			} else {
				return buscado;
			}
		}

	}

}

package org.mp.sesion06;

import java.util.List;
import java.util.LinkedList;

/**
 * Clase acciones. Contiene una lista de acciones.
 * 
 * @author David Subires Parra
 * 
 */
public class Acciones {
	/**
	 * Lista de acciones
	 */
	private List<Accion> acciones;

	/**
	 * Constructor de Acciones. Instancia una LinkedList en la variable acciones
	 * List<Acciones>
	 */
	public Acciones() {
		acciones = new LinkedList<Accion>();

	}

	/**
	 * Añade una nueva acciones a la lista
	 * 
	 * @param a
	 *            Accion a añadir
	 */
	public void add(Accion a) {
		acciones.add(a);
	}

	/**
	 * Devuelve la lista de acciones
	 * 
	 * @return lista de acciones
	 */
	public List<Accion> getAcciones() {
		return acciones;
	}
}

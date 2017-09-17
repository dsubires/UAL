package org.mp.sesion06;

import java.util.Comparator;

/**
 * Clase VolumenComparator. Implementa comparator.
 * 
 * @author David Subires Parra
 * 
 */
@SuppressWarnings("rawtypes")
public class VolumenComparator implements Comparator {

	/**
	 * Compara dos acciones pasadas por parametro
	 * 
	 * @return -1, 1 o 0 en caso de que la primera accion pasada por parametro
	 *         sea menor, mayor o igual que la segunda.
	 */
	@Override
	public int compare(Object o1, Object o2) {
		Accion tempCast1 = (Accion) o1;
		Accion tempCast2 = (Accion) o2;
		if (tempCast1.getVolumen() > tempCast2.getVolumen()) {
			return 1;
		} else if (tempCast1.getVolumen() < tempCast2.getVolumen()) {
			return -1;
		} else {
			return 0;
		}
	}

}

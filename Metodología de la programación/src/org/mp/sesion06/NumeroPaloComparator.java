package org.mp.sesion06;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
/**
 * Clase que ordena una baraja de cartas. Las ordena por varios criterios, primero por numero, 
 * de menor a mayor, y en caso de tener igual numero, las ordena por palo en este orden : (Oros, Copas, Espadas, Bastos) 
 * 
 * @author David Subires Parra
 *
 */
public class NumeroPaloComparator implements Comparator {

	/**
	 * Metodo publico que compara dos objetos de tipo Carta
	 * 
	 * @param o1
	 *            Primera carta a comparar
	 * @param o2
	 *            Segunda carta a comparar
	 * @return Devuelve -1 o 1 en caso de que carta1 sea menor o mayor que
	 *         carta2. No devuelve 0 puesto que en una baraja no debe haber dos
	 *         cartas del mismo numero y palo.
	 */
	@Override
	public int compare(Object o1, Object o2) {
		Carta carta1 = (Carta) o1;
		Carta carta2 = (Carta) o2;

		if (carta1.getNumero() == carta2.getNumero()) {
			if (carta1.getPalo().equals("O"))
				return -1;
			if (carta2.getPalo().equals("O"))
				return 1;
			if (carta1.getPalo().equals("C"))
				return -1;
			if (carta1.getPalo().equals("E")) {
				if (carta2.getPalo().equals("B"))
					return -1;
			} else {
				return 1;
			}
			if (carta1.getPalo().equals("B"))
				return 1;

		} else {
			if (carta1.getNumero() > carta2.getNumero()) {
				return 1;
			} else {
				return -1;
			}
		}
		return 0;
	}
}

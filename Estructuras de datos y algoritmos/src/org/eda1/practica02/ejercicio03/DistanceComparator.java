package org.eda1.practica02.ejercicio03;
import java.util.Comparator;
/**
 * Comparator que evalua objetos PalabraDistancia segun su distancia
 *
 */
public class DistanceComparator implements Comparator<PalabraDistancia> {
	
	
	@Override
	public int compare(PalabraDistancia o1, PalabraDistancia o2) {
		if(o1.getDistancia() < o2.getDistancia())
			return -1;
		else if(o1.getDistancia() > o2.getDistancia())
			return 1;
		else
			return 0;
	}
	
}
package org.eda1.actividad01.serializacionED;

import java.io.Serializable;

public class CiudadBarrios implements Serializable {
	
	public String ciudad;
	public Double latitud;
	public Double longitud;
	LinkedList<String> barrios = new LinkedList<String>();

	public CiudadBarrios(String ciudad, Double latitud, Double longitud) {
		this.ciudad = ciudad;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public boolean addBarrio(String barrio) {

		boolean isOk = true;
		Iterator<String> i = barrios.iterator();
		while (i.hasNext()) {
			String aux = (String) i.next();
			if (aux.equals(barrio)) {
				isOk = false;
			}
		}
		if (isOk) {
			barrios.add(barrio);
		}
		return isOk;
	}

	public LinkedList<String> getBarrios() {
		return barrios;
	}
}
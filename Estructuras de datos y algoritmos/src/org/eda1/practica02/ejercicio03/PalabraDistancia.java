package org.eda1.practica02.ejercicio03;

import java.util.Comparator;

// TODO: Auto-generated Javadoc
/**
 * The Class PalabraDistancia.
 */
public class PalabraDistancia implements Comparable<Object>, Comparator<PalabraDistancia>{

	/** The palabra. */
	private String palabra;
	
	/** The distancia. */
	private int distancia;
	
	/**
	 * Instantiates a new palabra distancia.
	 *
	 * @param pal the pal
	 * @param dis the dis
	 */
	public PalabraDistancia(String pal, int dis){
		palabra = pal;
		distancia = dis;
	}
	
	/**
	 * Instantiates a new palabra distancia.
	 *
	 * @param pal the pal
	 */
	public PalabraDistancia(String pal){
		palabra = pal;
		distancia = 0;
	}
	
	/**
	 * Instantiates a new palabra distancia.
	 */
	public PalabraDistancia(){
		palabra = null;
		distancia = 0;
	}
	
	/**
	 * Sets the palabra.
	 *
	 * @param pal the new palabra
	 */
	public void setPalabra(String pal){
		palabra = pal;
	}
	
	/**
	 * Gets the palabra.
	 *
	 * @return the palabra
	 */
	public String getPalabra(){
		return palabra;
	}
	
	/**
	 * Sets the distancia.
	 *
	 * @param dis the new distancia
	 */
	public void setDistancia(int dis){
		distancia = dis;
	}
	
	/**
	 * Gets the distancia.
	 *
	 * @return the distancia
	 */
	public int getDistancia(){
		return distancia;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Object o) {
		return palabra.compareTo(((PalabraDistancia)o).palabra);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o){
		return palabra.equals( ((PalabraDistancia)o).palabra );
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return palabra;
	}

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(PalabraDistancia o1, PalabraDistancia o2) {
		// TODO Auto-generated method stub
		return compare(o1,o2);
	}

}

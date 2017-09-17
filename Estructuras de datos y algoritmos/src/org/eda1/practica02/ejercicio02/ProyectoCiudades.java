package org.eda1.practica02.ejercicio02;

import java.util.Iterator;

import org.eda1.estructurasdedatos.AVLTree;
import org.eda1.practica02.ejercicio01.MaquinaContador;

/**
 * The Class ProyectoCiudades.
 */
public class ProyectoCiudades implements Comparable<Object> {

	/** The proyecto. */
	private String proyecto;
	
	/** The ciudades. */
	private AVLTree<String> ciudades;
	
	/**
	 * Instantiates a new proyecto ciudades.
	 */
	public ProyectoCiudades(){
		proyecto = "";
		ciudades = new AVLTree<String>();
	}
	
	/**
	 * Instantiates a new proyecto ciudades.
	 *
	 * @param p the p
	 */
	public ProyectoCiudades(String p){
		proyecto = p;
		ciudades = new AVLTree<String>();		
	}
	
	/**
	 * Sets the proyecto.
	 *
	 * @param p the new proyecto
	 */
	public void setProyecto(String p){
		proyecto = p;
	}
	
	/**
	 * Gets the proyecto.
	 *
	 * @return the proyecto
	 */
	public String getProyecto(){
		return proyecto;
	}
	
	/**
	 * Adds the ciudad.
	 *
	 * @param ciudad the ciudad
	 * @return true, if successful
	 */
	public boolean addCiudad(String ciudad){
		return ciudades.add(ciudad);
	}
	
	/**
	 * Gets the ciudades.
	 *
	 * @return the ciudades
	 */
	public AVLTree<String> getCiudades(){
		return ciudades;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object o){
		return proyecto.compareTo(((ProyectoCiudades) o).proyecto);
	}
	
	/**
	 * Size.
	 *
	 * @return the int
	 */
	public int size(){
		return ciudades.size();
	}
	
	@Override
	public String toString(){
		String aux = proyecto+"<";
		Iterator<String> iterador = ciudades.iterator();
		while(iterador.hasNext()){
			aux += iterador.next();
			if(iterador.hasNext())
				aux += ", ";
		}
		aux += ">";
		return aux;
	}
	
}

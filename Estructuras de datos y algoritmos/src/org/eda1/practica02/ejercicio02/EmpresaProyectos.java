package org.eda1.practica02.ejercicio02;

import java.util.Iterator;

import org.eda1.estructurasdedatos.AVLTree;

// TODO: Auto-generated Javadoc
/**
 * The Class EmpresaProyectos.
 */
public class EmpresaProyectos implements Comparable<Object> {
	
	/** The empresa. */
	private String empresa;
	
	/** The proyectos ciudades. */
	private AVLTree<ProyectoCiudades> proyectosCiudades;
	
	/**
	 * Instantiates a new empresa proyectos.
	 */
	public EmpresaProyectos(){
		empresa = "";
		proyectosCiudades = new AVLTree<ProyectoCiudades>(); 
	}
	
	/**
	 * Instantiates a new empresa proyectos.
	 *
	 * @param e the e
	 */
	public EmpresaProyectos(String e){
		empresa = e;
		proyectosCiudades = new AVLTree<ProyectoCiudades>() ;
	}
	
	/**
	 * Adds the proyecto ciudad.
	 *
	 * @param proyecto the proyecto
	 * @param ciudad the ciudad
	 * @return true, if successful
	 */
	public boolean addProyectoCiudad(String proyecto,String ciudad){
		ProyectoCiudades pc = new ProyectoCiudades(proyecto);
		pc.addCiudad(ciudad);
		
		if(!proyectosCiudades.add(pc))
			return proyectosCiudades.find(pc).addCiudad(ciudad);
		return true;
	}
	
	/**
	 * Sets the empresa.
	 *
	 * @param e the new empresa
	 */
	public void setEmpresa(String e){
		empresa = e;
	}
	
	/**
	 * Gets the empresa.
	 *
	 * @return the empresa
	 */
	public String getEmpresa(){
		return empresa;
	}
	
	/**
	 * Gets the proyectosciudades.
	 *
	 * @return the proyectosciudades
	 */
	public AVLTree<ProyectoCiudades> getProyectosciudades(){
		return proyectosCiudades;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object o){
		return empresa.compareTo(((EmpresaProyectos) o).empresa);
	}
	
	/**
	 * Size.
	 *
	 * @return the int
	 */
	public int size(){
		return proyectosCiudades.size();
	}
	
	@Override
	public String toString(){
		// example output:
		// Adobe: Flash<Boston, Charleston, Washington>; Illustrator<Miami, New_Orleans, Sacramento>; Photoshop<Houston, San_Antonio, Seattle>" + "\n";
		String salida = empresa+": ";
		ProyectoCiudades pc;
		Iterator<ProyectoCiudades> iterador = proyectosCiudades.iterator();
		while(iterador.hasNext()){
			pc = iterador.next();
			salida += pc;
			if(iterador.hasNext())
				salida += "; ";
			else
				salida += "\n";
		}
			
		return salida;
	}

}

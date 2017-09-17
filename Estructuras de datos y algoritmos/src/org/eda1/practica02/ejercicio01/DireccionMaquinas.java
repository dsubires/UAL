package org.eda1.practica02.ejercicio01;

import java.util.Iterator;

import org.eda1.estructurasdedatos.BSTree;

// TODO: Auto-generated Javadoc
/**
 * The Class DireccionMaquinas.
 */
public class DireccionMaquinas implements Comparable<Object> {
	
	/** The direccion. */
	private String direccion;
	
	/** The maquinas. */
	private BSTree<MaquinaContador> maquinas;
	
	/**
	 * Instantiates a new direccion maquinas.
	 */
	public DireccionMaquinas(){
		direccion = "";
		maquinas = new BSTree<MaquinaContador>();
	}
	
	/**
	 * Instantiates a new direccion maquinas.
	 *
	 * @param dir the dir
	 */
	public DireccionMaquinas(String dir){
		direccion = dir;
		maquinas = new BSTree<MaquinaContador>();
	}
	
	/**
	 * Instantiates a new direccion maquinas.
	 *
	 * @param dir the dir
	 * @param maq the maq
	 */
	public DireccionMaquinas(String dir,String maq){
		direccion = dir;
		maquinas = new BSTree<MaquinaContador>();
		maquinas.add(new MaquinaContador(maq));
	}

	/**
	 * Instantiates a new direccion maquinas.
	 *
	 * @param dir the dir
	 * @param maq the maq
	 * @param c the c
	 */
	public DireccionMaquinas(String dir, String maq, int c){
		direccion = dir;
		maquinas = new BSTree<MaquinaContador>();
		maquinas.add(new MaquinaContador(maq,c));
	}
	
	/**
	 * Sets the direccion.
	 *
	 * @param dir the new direccion
	 */
	public void setDireccion(String dir){
		direccion = dir;
	}
	
	/**
	 * Gets the direccion.
	 *
	 * @return the direccion
	 */
	public String getDireccion(){
		return direccion;
	}
	
	/**
	 * Gets the maquinas.
	 *
	 * @return the maquinas
	 */
	public BSTree<MaquinaContador> getMaquinas(){
		return maquinas;
	}
	
	/**
	 * Adds the maquina.
	 *
	 * @param mc the mc
	 * @return true, if successful
	 */
	public boolean addMaquina(MaquinaContador mc){
		return maquinas.add(mc);
	}
	
	/**
	 * Adds the maquina with find.
	 *
	 * @param mc the mc
	 * @return true, if successful
	 */
	public boolean addMaquinaWithFind(MaquinaContador mc){
		if(maquinas.contains(mc))
			return false;
		maquinas.add(mc);
		return true;
	}
	
	/**
	 * Compare to.
	 *
	 * @param obj the obj
	 * @return the int
	 */
	@Override
	public int compareTo(Object obj){
		return direccion.compareTo(( (DireccionMaquinas) obj).direccion);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj){
		return direccion.equals(((DireccionMaquinas) obj).direccion);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		String aux = "("+direccion+", [";
		Iterator<MaquinaContador> iterador = maquinas.iterator();
		while(iterador.hasNext()){
			aux += iterador.next();
			if(iterador.hasNext())
				aux += "\n";
			else
				aux += "])";
		}
		return aux;
	}


	
}

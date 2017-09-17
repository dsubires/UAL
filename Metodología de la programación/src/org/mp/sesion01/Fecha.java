package org.mp.sesion01;

// TODO: Auto-generated Javadoc
/**
 * The Class Fecha.
 */
public class Fecha {

	/** The dia. */
	private int dia;
	
	/** The mes. */
	private int mes;
	
	/** The año. */
	private int año;
	
	
	/**
	 * Instantiates a new fecha.
	 *
	 * @param dia the dia
	 * @param mes the mes
	 * @param año the año
	 */
	public Fecha(int dia, int mes, int año){
		this.dia = dia;
		this.mes = mes;
		this.año = año;
	}
	
	
	/**
	 * Gets the dia.
	 *
	 * @return the dia
	 */
	public int getDia(){
		return dia;
	}
	
	/**
	 * Gets the mes.
	 *
	 * @return the mes
	 */
	public int getMes(){
		return mes;
	}
	
	/**
	 * Gets the año.
	 *
	 * @return the año
	 */
	public int getAño(){
		return año;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return dia+"-"+mes+"-"+año;
	}
	
	
	

}

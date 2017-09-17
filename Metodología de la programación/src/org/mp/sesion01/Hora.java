package org.mp.sesion01;

// TODO: Auto-generated Javadoc
/**
 * The Class Hora.
 */
public class Hora {
	
	/** The minuto. */
	private int minuto;
	
	/** The hora. */
	private int hora;
	
	/**
	 * Instantiates a new hora.
	 *
	 * @param minuto the minuto
	 * @param hora the hora
	 */
	public Hora(int minuto, int hora){
		this.minuto = minuto;
		this.hora = hora;
	}

	/**
	 * Gets the minuto.
	 *
	 * @return the minuto
	 */
	public int getMinuto(){
		return minuto;
	}
	
	/**
	 * Gets the hora.
	 *
	 * @return the hora
	 */
	public int getHora(){
		return hora;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return hora+":"+minuto;
	}
	
}

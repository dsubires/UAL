package org.mp.sesion04;

// TODO: Auto-generated Javadoc
/**
 * The Class Taxi.
 */
public class Taxi {

	/** The licencia. */
	private int licencia;
	
	/** The a minusvalido. */
	private boolean aMinusvalido;
	
	/**
	 * Instantiates a new taxi.
	 *
	 * @param l the l
	 * @param m the m
	 */
	public Taxi(int l,boolean m){
		licencia = l;
		aMinusvalido = m;
	}
	
	
	/**
	 * Gets the licencia.
	 *
	 * @return the licencia
	 */
	public int getLicencia(){
		return licencia;
	}
	
	/**
	 * Gets the minusvalido.
	 *
	 * @return the minusvalido
	 */
	public boolean getMinusvalido(){
		return aMinusvalido;
	}
	
	/**
	 * Equals.
	 *
	 * @param t the t
	 * @return true, if successful
	 */
	public boolean equals(Taxi t){
		return (licencia == t.licencia);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return licencia+"";
	}

}

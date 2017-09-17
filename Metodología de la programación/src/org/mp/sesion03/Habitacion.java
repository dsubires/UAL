package org.mp.sesion03;

// TODO: Auto-generated Javadoc
/**
 * The Class Habitacion.
 */
public class Habitacion {

	/** The numero. */
	private String numero;
   // private boolean ocupada;

	/**
    * Instantiates a new habitacion.
    *
    * @param num the num
    */
   public Habitacion(String num) {
		numero = num;
	//	ocupada = false;
	}

	/**
	 * Gets the numero.
	 *
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}
	
/*	public boolean getLibre(){
		return ocupada;
	}
*/
	/**
 * Sets the numero.
 *
 * @param s the new numero
 */
public void setNumero(String s) {
		numero = s;
	}
/*	
	public void setOcupada(boolean b){
		ocupada = b;
	}
*/
	/* (non-Javadoc)
 * @see java.lang.Object#clone()
 */
public Habitacion clone(){
		return new Habitacion(this.getNumero());
	}
	
	/**
	 * Equals.
	 *
	 * @param h the h
	 * @return true, if successful
	 */
	public boolean equals(Habitacion h) {
		return (numero.equals(h.numero)) ? true : false;
	}

}

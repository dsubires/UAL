package org.mp.sesion08;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * Claes habitacion. Representa la habitacion de un hotel
 */
public class Habitacion implements Serializable {

	private String numero;

	// private boolean ocupada;

	/**
	 * Instancia una nueva habitacion
	 * 
	 * @param num
	 *            numero de la habitacion
	 */
	public Habitacion(String num) {
		numero = num;
		// ocupada = false;
	}

	/**
	 * Metodo getter del numero de habitacion
	 * 
	 * @return numero de habitacion
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Metodo setter del numero de habitacion
	 * 
	 * @param s
	 *            numero habitacion
	 */
	public void setNumero(String s) {
		numero = s;
	}

	/**
	 * Devuelve una habitacion igual a la que llama al metodo
	 * 
	 * @see java.lang.Object#clone()
	 */
	public Habitacion clone() {
		return new Habitacion(this.getNumero());
	}

	/**
	 * Compara la habitacion que llama al metodo con otra pasada por parametro
	 * 
	 * @param h
	 *            habitacion para comprarar con la que llama al metodo
	 * 
	 * @return true si son iguales, false en caso contrario
	 */
	public boolean equals(Habitacion h) {
		return (numero.equals(h.numero)) ? true : false;
	}

}

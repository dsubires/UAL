package org.mp.sesion03;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Reserva.
 */
public class Reserva {
	
	/** The num reservas. */
	private static int numReservas;
	
	/** The residente. */
	private Residente residente;
	
	/** The habitacion. */
	private Habitacion habitacion;
	
	/** The fecha entrada. */
	private Date fechaEntrada;
	
	/** The fecha salida. */
	private Date fechaSalida;
	
	/** The num reserva. */
	private int numReserva;

	/**
	 * Instantiates a new reserva.
	 *
	 * @param r the r
	 * @param h the h
	 * @param fechaE the fecha e
	 * @param fechaS the fecha s
	 */
	public Reserva(Residente r, Habitacion h, Date fechaE, Date fechaS) {
		++numReservas;
		residente = r;
		habitacion = h;
		fechaEntrada = fechaE;
		fechaSalida = fechaS;
		numReserva = numReservas;

	}

	/**
	 * Gets the residente.
	 *
	 * @return the residente
	 */
	public Residente getResidente() {
		return residente;
	}

	/**
	 * Gets the habitacion.
	 *
	 * @return the habitacion
	 */
	public Habitacion getHabitacion() {
		return habitacion;
	}

	/**
	 * Gets the fecha entrada.
	 *
	 * @return the fecha entrada
	 */
	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	/**
	 * Gets the fecha salida.
	 *
	 * @return the fecha salida
	 */
	public Date getFechaSalida() {
		return fechaSalida;
	}

	/**
	 * Gets the numero reserva.
	 *
	 * @return the numero reserva
	 */
	public int getNumeroReserva() {
		return numReserva;
	}

	/**
	 * Gets the ultimo numero.
	 *
	 * @return the ultimo numero
	 */
	public static int getUltimoNumero() {
		return numReservas;
	}

	/**
	 * Sets the fecha salida.
	 *
	 * @param d the new fecha salida
	 */
	public void setFechaSalida(Date d) {
		fechaSalida = d;
	}

	/**
	 * Equals.
	 *
	 * @param r the r
	 * @return true, if successful
	 */
	public boolean equals(Reserva r) {
		return (numReserva == (r.getNumeroReserva())) ? true : false;
	}

}

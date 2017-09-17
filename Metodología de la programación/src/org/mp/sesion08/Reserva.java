package org.mp.sesion08;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * Clase reserva. Representa la reserva que realiza un residente en un htoel
 */
public class Reserva implements Serializable {

	private static int numReservas;

	private Residente residente;

	private Habitacion habitacion;

	private Date fechaEntrada;

	private Date fechaSalida;

	private int numReserva;

	/**
	 * Instancia una nueva reserva
	 * 
	 * @param r
	 *            residente que solicita la reserva
	 * @param h
	 *            habitacion que solicita el residente para su reserva
	 * @param fechaE
	 *            fecha de entrada de la reserva
	 * @param fechaS
	 *            fecha de salida de la reserva
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
	 * Metodo getter del residetne de la reserva
	 * 
	 * @return residente
	 */
	public Residente getResidente() {
		return residente;
	}

	/**
	 * Metodo getter de la habitacion de la reserva
	 * 
	 * @return habitacion
	 */
	public Habitacion getHabitacion() {
		return habitacion;
	}

	/**
	 * Metodo getter de la fecha entrada de la reserva
	 * 
	 * @return fecha entrada
	 */
	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	/**
	 * Metodo getter de la fecha de salida de la reserva
	 * 
	 * @return fecha salida
	 */
	public Date getFechaSalida() {
		return fechaSalida;
	}

	/**
	 * Metodo getter del numero de la reserva
	 * 
	 * @return numero reserva
	 */
	public int getNumeroReserva() {
		return numReserva;
	}

	/**
	 * Metodo getter del numero de la ultima reserva
	 * 
	 * @return ultimo numero de reserva
	 */
	public static int getUltimoNumero() {
		return numReservas;
	}

	/**
	 * Metodo setter de la fecha de salida de la resera
	 * 
	 * @param d
	 *            fecha de salida
	 */
	public void setFechaSalida(Date d) {
		fechaSalida = d;
	}

	/**
	 * Compara dos reservas
	 * 
	 * @param r
	 *            reserva a comparar con la que llama al metodo
	 * 
	 * @return true si son iguales, false en caso contrario
	 */
	public boolean equals(Reserva r) {
		return (numReserva == (r.getNumeroReserva())) ? true : false;
	}

}

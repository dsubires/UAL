package org.mp.sesion08;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;

/**
 * Clase Residendia
 * 
 * @author David Subires Parra
 * 
 */
public class Residencia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Nombre. */
	private String nombre;

	/** Habitaciones. */
	private ArrayList<Habitacion> habitaciones;

	/** Residentes. */
	private ArrayList<Residente> residentes;

	/** Reservas. */
	private ArrayList<Reserva> reservas;

	/**
	 * Instancia una nueva residencia
	 * 
	 * @param nombre
	 *            nombre de la residencia
	 * @param habitaciones
	 *            habitaciones de la residencia.
	 */
	public Residencia(String nombre, Habitacion[] habitaciones) {
		this.nombre = nombre;
		this.habitaciones = new ArrayList<Habitacion>();
		for (int i = 0; i < habitaciones.length; i++) {
			if (habitaciones[i] != null) {
				this.habitaciones.add(habitaciones[i]);
			}
		}
		residentes = new ArrayList<Residente>();
		reservas = new ArrayList<Reserva>();
	}

	/**
	 * Insertar habitacion.
	 * 
	 * @param h
	 *            Habitacion a insertar
	 */
	public void insertarHabitacion(Habitacion h) {

		if (buscarHabitacion(h.getNumero()) == null) {
			habitaciones.add(h);
		}
	}

	/**
	 * Buscar habitacion.
	 * 
	 * @param s
	 *            String con el numero de habitacion
	 * @return Si encuentra habitación con ese numero la devuevle, sino devuelve
	 *         null
	 */
	public Habitacion buscarHabitacion(String s) {

		Iterator<Habitacion> iterador = habitaciones.iterator();
		Habitacion habitacion;
		while (iterador.hasNext()) {
			habitacion = iterador.next();
			if (habitacion.getNumero().equals(s)) {
				return habitacion;
			}
		}

		return null;

	}

	/**
	 * Eliminar habitacion.
	 * 
	 * @param h
	 *            Habitacion a eliminar
	 */
	public void eliminarHabitacion(Habitacion h) {
		habitaciones.remove(h);

	}

	/**
	 * Ingreso reserva.
	 * 
	 * @param r
	 *            Residente que solicita la reserva
	 * @param h
	 *            Habitacion que solicita el residente
	 * @param entrada
	 *            Fecha de entrada
	 * @param salida
	 *            Fecha de salida
	 */
	private void ingresoReserva(Residente r, Habitacion h, Date entrada,
			Date salida) {
		reservas.add(new Reserva(r, h, entrada, salida));
	}

	/**
	 * Ingreso residente.
	 * 
	 * @param nombre
	 *            Nombre Residente
	 * @param dni
	 *            Dni residente
	 * @param sexo
	 *            Sexo residente
	 * @param fechaNacimiento
	 *            Fecha nacimiento residente
	 */
	private void ingresoResidente(String nombre, String dni, char sexo,
			Date fechaNacimiento) {

		boolean residenteExiste = false;

		Iterator<Residente> it = residentes.iterator();
		while (it.hasNext()) {
			Residente r = it.next();
			if (r.getDni().equals(dni)) {
				residenteExiste = true;
				break;
			}
		}

		Residente residente = new Residente(nombre, dni, sexo, fechaNacimiento);
		if (!residenteExiste) {
			residentes.add(residente);
		}

	}

	/**
	 * Ingreso.
	 * 
	 * @param r
	 *            Residente a ingresar
	 * @param h
	 *            Habitacion asignada
	 * @param entrada
	 *            Fecha de entrada
	 * @param salida
	 *            Fecha de salida
	 */
	public void ingreso(Residente r, Habitacion h, Date entrada, Date salida) {
		if (entrada.before(salida) || entrada.equals(salida)) {
			if (!(isHabitacionOcupada(h, entrada) || isHabitacionOcupada(h,
					salida))) {
				ingresoReserva(r, h, entrada, salida);
				ingresoResidente(r.getNombre(), r.getDni(), r.getSexo(),
						r.getFechaNacimiento());
			}
		}
	}

	/**
	 * Cambiar habitacion.
	 * 
	 * @param r
	 *            Residente que solicita cambio de habitacion
	 * @param h
	 *            Habitacion elegida por el residente
	 * @param entrada
	 *            Fecha entrada
	 * @param salida
	 *            Fecha salida
	 */
	public void cambiarHabitacion(Residente r, Habitacion h, Date entrada,
			Date salida) {
		/**
		 * Para realizar el cambio de habitación, primero buscamos la reserva
		 * anterior del residente, utilizando como criterio de búsqueda al
		 * Residente y comprobando que la fecha de Salida aun no ha pasado. Acto
		 * seguido se modifica la fecha de salida de la reserva anterior y se
		 * genera la nueva reserva.
		 */
		Date fecha = new Date();

		Iterator<Reserva> iterador = reservas.iterator();

		while (iterador.hasNext()) {
			Reserva reserva = iterador.next();
			if (reserva.getResidente().equals(r)
					&& reserva.getFechaSalida().after(fecha)) {
				reserva.setFechaSalida(fecha);
				break;
			}
		}

		ingresoReserva(r, h, entrada, salida);
	}

	/**
	 * Salida de un residente.
	 * 
	 * @param r
	 *            Residente de la salida
	 * @param salida
	 *            Fecha de la salida
	 */
	public void salida(Residente r, Date salida) {

		// Date fecha = new Date();

		Iterator<Reserva> iterador = reservas.iterator();

		while (iterador.hasNext()) {
			Reserva reserva = iterador.next();
			if (reserva.getResidente().equals(r)
					&& reserva.getFechaSalida().after(salida)) {
				reserva.setFechaSalida(salida);
				break;
			}
		}

		/*
		 * for(int i=0; i < reservas.size(); i++){ Reserva reserva =
		 * reservas.get(i); if(reserva.getResidente().equals(r) &&
		 * reserva.getFechaEntrada().after(salida)){
		 * reserva.setFechaSalida(salida); } }
		 */
		/*
		 * Iterator<Residente> iterator = residentes.iterator();
		 * 
		 * while (iterator.hasNext()) { Residente residente = iterator.next();
		 * if (residente.equals(r)) { iterator.remove(); } }
		 */

		for (int i = 0; i < residentes.size(); i++) {
			Residente residente = residentes.get(i);
			if (residente.equals(r)) {
				residentes.remove(i);
			}
		}

	}
	
	

	/**
	 * Metodo getter del nombre de la residencia
	 * 
	 * @return Nombre de la residencia
	 */
	public String getNombre(){
		return nombre;
	}

	/**
	 * Metodo getter del Nº de habitaciones
	 * 
	 * @return Nº d habitaciones
	 */
	public int getNHabitaciones() {
		return habitaciones.size();
	}

	/**
	 * Metodo getter del Nº de reservas
	 * 
	 * @return Nº de reservas
	 */
	public int getNReservas() {
		return reservas.size();
	}

	/**
	 * Metodo getter del nº de residentes
	 * 
	 * @return Nº de residentes
	 */
	public int getNResidentes() {
		return residentes.size();
	}
	
	
	/**
	 * Metodo getter de los residentes
	 * 
	 * @return Array con los residentes
	 */
	public Residente[] getResidentes() {
		Residente[] residente = new Residente[residentes.size()];
		for (int i = 0; i < residente.length; i++) {
			residente[i] = residentes.get(i);
		}
		return residente;
	}
	

	/**
	 * Metodo getter de las habitaciones
	 * 
	 * @return Array con las habitaciones
	 */
	public Habitacion[] getHabitaciones() {
		Habitacion[] habitacion = new Habitacion[habitaciones.size()];
		for (int i = 0; i < habitacion.length; i++) {
			habitacion[i] = habitaciones.get(i);
		}
		return habitacion;
	}

	/**
	 * Metodo getter de las reservas
	 * 
	 * @return ArrayList con las reseras
	 */
	public Reserva[] getReservas() {
		Reserva[] reserva = new Reserva[reservas.size()];
		for (int i = 0; i < reserva.length; i++) {
			reserva[i] = reservas.get(i);
		}
		return reserva;
	}

	/**
	 * Comprueba si una habitacion esta ocupada en una fecha determiada
	 * 
	 * @param h
	 *            Habitacion a comprobar si esta ocupada o no
	 * 
	 * @param d
	 *            Fecha para determinar si la habitacion esta ocupada
	 * @return true si la habitacion esta ocupada, false en caso contrario
	 */
	public boolean isHabitacionOcupada(Habitacion h, Date d) {

		Iterator<Reserva> iterador = reservas.iterator();

		while (iterador.hasNext()) {
			Reserva reserva = iterador.next();
			if (reserva.getHabitacion().equals(h)
					&& (reserva.getFechaEntrada().before(d) || reserva
							.getFechaEntrada().equals(d))
					&& (reserva.getFechaSalida().after(d) || reserva
							.getFechaSalida().equals(d))) {
				return true;
			}
		}
		return false;

	}

	/**
	 * Listado habitaciones libres.
	 * 
	 * @param d
	 *            Fecha para comprobar habitaciones libres
	 * @return String con las habitaciones libres
	 */
	public String listadoHabitacionesLibres(Date d) {
		String aux = "Habitaciones libres a fecha de " + d + ": [";

		Iterator<Habitacion> iterador = habitaciones.iterator();
		while (iterador.hasNext()) {
			Habitacion habitacion = iterador.next();
			if (!isHabitacionOcupada(habitacion, d)) {
				aux += habitacion.getNumero() + " ";
			}
		}
		aux += "]";

		return aux;
	}

	/**
	 * Listado residentes habitaciones.
	 * 
	 * @param d
	 *            Fecha para comprobar residentes
	 * @return String con los nombres de los residentes alojados en la fecha d,
	 *         con sus habitaciones asignadas.
	 */
	public String listadoResidentesHabitaciones(Date d) {
		
		Residente[] residenteAux = new Residente[reservas.size()];
		int contResidenteAux = 0;
		
		String aux = "";

		for(int i=0; i<reservas.size(); i++){
			if(isHabitacionOcupada(reservas.get(i).getHabitacion(),d)){
				residenteAux[contResidenteAux] = reservas.get(i).getResidente();
				contResidenteAux++;
			}
		}
		
		ordenarAlfabeticamente(residenteAux,contResidenteAux);
		
		for(int j=0; j<contResidenteAux; j++){
			aux = aux + residenteAux[j].getNombre()+"\n";
		}

		return aux;
	}

	/**
	* Metodo que ordenar alfabeticamente un array de residentes (por nombre)
	* @param residentes el array de residentes
	* @param numeroResidentes el numero de residentes
	*/
	private void ordenarAlfabeticamente(Residente[] residentes, int numeroResidentes){
		Residente temp;
		for(int i = 0; i < numeroResidentes-1; i++){
			for(int j = i+1; j < numeroResidentes; j++){
				if(residentes[j].getNombre().compareToIgnoreCase(residentes[i].getNombre()) < 0){
					temp = residentes[i];
					residentes[i] = residentes[j];
					residentes[j] = temp;
				}
			}
			
		}
	}
	
	
	/**
	 * Listado edad media por sexo.
	 * 
	 * @param d
	 *            Fecha para obtener los datos del listado de edad media por
	 *            sexo de residentes
	 * @return String con
	 */
	public String listadoEdadMediaPorSexo(Date d) {
		String aux = "";
		if (getNResidentes() == 0) {
			return "0.0";
		} else {
			double mediaHombres = 0;
			int contHombres = 0;
			double mediaMujeres = 0;
			int contMujeres = 0;

			Iterator<Reserva> iterador = reservas.iterator();
			while (iterador.hasNext()) {
				Reserva reserva = iterador.next();
				if (reserva.getFechaEntrada().before(d)
						|| reserva.getFechaEntrada().equals(d)
						&& reserva.getFechaSalida().after(d)
						|| reserva.getFechaSalida().equals(d)) {
					if (reserva.getResidente().getSexo() == "V".charAt(0)) {
						mediaHombres += reserva.getResidente().getEdad(d);
						contHombres++;
					} else {
						mediaMujeres += reserva.getResidente().getEdad(d);
						contMujeres++;
					}
				}
			}

			aux += "Listado de edad media por sexo:\n";
			if (mediaHombres == 0) {
				aux += "- Media de los hombres: 0.0\n";
			} else {
				aux += "- Media de los hombres: " + mediaHombres / contHombres
						+ "\n";
			}

			if (contMujeres == 0) {
				aux += "- Media de las mujeres: 0.0\n";
			} else {
				aux += "- Media de las mujeres: " + mediaMujeres / contMujeres
						+ "\n";
			}
			return aux;
		}
	}
}

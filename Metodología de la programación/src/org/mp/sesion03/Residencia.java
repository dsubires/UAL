package org.mp.sesion03;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Residencia.
 */
public class Residencia {

	/** The nombre. */
	private String nombre;
	
	/** The habitaciones. */
	private Habitacion[] habitaciones;
	
	/** The residentes. */
	private Residente[] residentes;
	
	/** The reservas. */
	private Reserva[] reservas;

	/**
	 * Instantiates a new residencia.
	 *
	 * @param nombre the nombre
	 * @param habitaciones the habitaciones
	 */
	public Residencia(String nombre, Habitacion[] habitaciones) {
		this.nombre = nombre;
		this.habitaciones = habitaciones;
		residentes = new Residente[5];
		reservas = new Reserva[5];
	}

	/**
	 * Insertar habitacion.
	 *
	 * @param h the h
	 */
	public void insertarHabitacion(Habitacion h) {
		/**
		 * Antes de insertar, comprobamos que el array tiene algún hueco libre
		 * para poder realizar la operación correctamente. En caso de no
		 * encontrarlo, se crea un array copiando el contenido del anterior pero
		 * añadiendo 100 huecos más con contenido null
		 */

		if (buscarHabitacion(h.getNumero()) == null) {

			int cont = 0;
			for (int i = 0; i < habitaciones.length; i++) {
				if (habitaciones[i] == null) {
					cont++;
				}
			}

			if (cont < 1) {
				Habitacion[] temp = new Habitacion[habitaciones.length + 100];
				for (int i = 0; i < habitaciones.length; i++) {
					temp[i] = habitaciones[i];
				}
				habitaciones = temp;
			}

			for (int i = 0; i < habitaciones.length; i++) {
				if (habitaciones[i] == null) {
					habitaciones[i] = h;
					break;
				}

			}
		}
	}

	/**
	 * Buscar habitacion.
	 *
	 * @param s the s
	 * @return the habitacion
	 */
	public Habitacion buscarHabitacion(String s) {
		for (int i = 0; i < habitaciones.length; i++) {
			if (habitaciones[i] != null) {
				if (habitaciones[i].getNumero().equals(s)) {
					return habitaciones[i];
				}
			}
		}
		return null;
	}

	/**
	 * Eliminar habitacion.
	 *
	 * @param h the h
	 */
	public void eliminarHabitacion(Habitacion h) {
		for (int i = 0; i < habitaciones.length; i++) {
			if (habitaciones[i].equals(h)) {
				habitaciones[i] = null;
				break;
			}
		}
	}

	/**
	 * Ingreso reserva.
	 *
	 * @param r the r
	 * @param h the h
	 * @param entrada the entrada
	 * @param salida the salida
	 */
	private void ingresoReserva(Residente r, Habitacion h, Date entrada,
			Date salida) {

		int cont = 0;
		for (int i = 0; i < reservas.length; i++) {
			if (reservas[i] == null) {
				cont++;
			}
		}

		if (cont < 1) {
			Reserva[] temp = new Reserva[reservas.length + 100];
			for (int i = 0; i < reservas.length; i++) {
				temp[i] = reservas[i];
			}
			reservas = temp;
		}

		for (int i = 0; i < reservas.length; i++) {
			if (reservas[i] == null) {
				reservas[i] = new Reserva(r, h, entrada, salida);
				break;
			}

		}

	}

	/**
	 * Ingreso residente.
	 *
	 * @param nombre the nombre
	 * @param dni the dni
	 * @param sexo the sexo
	 * @param fechaNacimiento the fecha nacimiento
	 */
	private void ingresoResidente(String nombre, String dni, char sexo,
			Date fechaNacimiento) {
		boolean residenteExiste = false;
		for (int i = 0; i < residentes.length; i++) {
			if (residentes[i] != null) {
				if (residentes[i].getDni().equals(dni)) {
					residenteExiste = true;
				}
			}
		}
		if (!residenteExiste) {
			int cont = 0;
			for (int i = 0; i < residentes.length; i++) {
				if (residentes[i] == null) {
					cont++;
				}
			}

			if (cont < 1) {
				Residente[] temp2 = new Residente[residentes.length + 100];
				for (int i = 0; i < residentes.length; i++) {
					temp2[i] = residentes[i];
				}
				residentes = temp2;
			}

			for (int i = 0; i < residentes.length; i++) {
				if (residentes[i] == null) {
					residentes[i] = new Residente(nombre, dni, sexo,
							fechaNacimiento);
					break;
				}

			}
		}
	}

	/**
	 * Ingreso.
	 *
	 * @param r the r
	 * @param h the h
	 * @param entrada the entrada
	 * @param salida the salida
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
	 * @param r the r
	 * @param h the h
	 * @param entrada the entrada
	 * @param salida the salida
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
		for (int i = 0; i < reservas.length; i++) {
			if (reservas[i] != null) {
				if (reservas[i].getResidente().equals(r)
						&& reservas[i].getFechaSalida().after(fecha)) {
					reservas[i].setFechaSalida(fecha);
					break;
				}
			}
		}

		ingresoReserva(r, h, entrada, salida);
	}

	/**
	 * Salida.
	 *
	 * @param r the r
	 * @param salida the salida
	 */
	public void salida(Residente r, Date salida) {
		// numResidentes--;
		for (int i = 0; i < residentes.length; i++) {
			if (residentes[i] != null) {
				if (residentes[i].equals(r)) {
					residentes[i] = null;
				}
			}
		}
	}

	/**
	 * Gets the nombre residencia.
	 *
	 * @return the nombre residencia
	 */
	public String getNombreResidencia() {
		return nombre;
	}

	/**
	 * Gets the n habitaciones.
	 *
	 * @return the n habitaciones
	 */
	public int getNHabitaciones() {
		int cont = 0;
		for (int i = 0; i < habitaciones.length; i++) {
			if (habitaciones[i] != null)
				cont++;
		}
		return cont;
	}

	/**
	 * Gets the n reservas.
	 *
	 * @return the n reservas
	 */
	public int getNReservas() {
		int cont = 0;
		for (int i = 0; i < reservas.length; i++) {
			if (reservas[i] != null)
				cont++;
		}
		return cont;
	}

	/**
	 * Gets the n residentes.
	 *
	 * @return the n residentes
	 */
	public int getNResidentes() {
		int cont = 0;
		for (int i = 0; i < residentes.length; i++) {
			if (residentes[i] != null)
				cont++;
		}
		return cont;
	}

	/**
	 * Gets the habitaciones.
	 *
	 * @return the habitaciones
	 */
	public Habitacion[] getHabitaciones() {
		Habitacion[] auxiliar = new Habitacion[habitaciones.length];
		for (int i = 0; i < habitaciones.length; i++) {
			auxiliar[i] = habitaciones[i].clone();
		}
		return auxiliar;
	}

	/**
	 * Gets the reservas.
	 *
	 * @return the reservas
	 */
	public Reserva[] getReservas() {
		return reservas;
	}

	/**
	 * Checks if is habitacion ocupada.
	 *
	 * @param h the h
	 * @param d the d
	 * @return true, if is habitacion ocupada
	 */
	public boolean isHabitacionOcupada(Habitacion h, Date d) {
		for (int i = 0; i < reservas.length; i++) {
			if (reservas[i] != null) {
				if (reservas[i].getHabitacion().equals(h)
						&& (reservas[i].getFechaEntrada().before(d) || reservas[i]
								.getFechaEntrada().equals(d))
						&& (reservas[i].getFechaSalida().after(d) || reservas[i]
								.getFechaSalida().equals(d))) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Listado habitaciones libres.
	 *
	 * @param d the d
	 * @return the string
	 */
	public String listadoHabitacionesLibres(Date d) {
		String aux = "Habitaciones libres a fecha de " + d + ": [";
		for (int i = 0; i < habitaciones.length; i++) {
			if (habitaciones[i] != null) {
				if (!isHabitacionOcupada(habitaciones[i], d)) {
					aux += habitaciones[i].getNumero() + " ";
				}
			}
			aux += "]";
		}
		return aux;
	}

	/**
	 * Listado residentes habitaciones.
	 *
	 * @param d the d
	 * @return the string
	 */
	public String listadoResidentesHabitaciones(Date d) {
		ordenarNombresResidentes(residentes);
		String aux = "";
		for (int i = 0; i < residentes.length; i++) {
			for (int j = 0; j < reservas.length; j++) {
				if (reservas[j] != null && residentes[i] != null) {
					if (residentes[i].equals(reservas[j].getResidente())
							&& (reservas[j].getFechaEntrada().before(d) || reservas[j]
									.getFechaEntrada().equals(d))
							&& reservas[j].getFechaSalida().after(d)
							|| reservas[j].getFechaSalida().equals(d))

					{

						aux += "Residente " + residentes[i].getNombre()
								+ " en habitación: "
								+ reservas[j].getHabitacion().getNumero()
								+ "\n";

					}
				}
			}

		}
		return aux;
	}

	/**
	 * Ordenar nombres residentes.
	 *
	 * @param residentes the residentes
	 */
	private void ordenarNombresResidentes(Residente[] residentes) {
		Residente temp;
		for (int i = 0; i < getNResidentes() - 1; i++) {
			for (int j = i + 1; j < getNResidentes(); j++) {
				if (residentes[j].getNombre().compareTo(
						residentes[i].getNombre()) < 0) {
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
	 * @param d the d
	 * @return the string
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

			for (int i = 0; i < reservas.length; i++) {
				if (reservas[i] != null) {
					if (reservas[i].getFechaEntrada().before(d)
							|| reservas[i].getFechaEntrada().equals(d)
							&& reservas[i].getFechaSalida().after(d)
							|| reservas[i].getFechaSalida().equals(d)) {
						if (residentes[i].getSexo() == "V".charAt(0)) {
							mediaHombres += residentes[i].getEdad(d);
							contHombres++;
						} else {
							mediaMujeres += residentes[i].getEdad(d);
							contMujeres++;
						}
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

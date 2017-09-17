package org.mp.sesion01;

// TODO: Auto-generated Javadoc
/**
 * The Class Examen.
 */
public class Examen {

	/** The nombre asignatura. */
	private String nombreAsignatura;
	
	/** The aula. */
	private String aula;
	
	/** The fecha examen. */
	private Fecha fechaExamen;
	
	/** The hora examen. */
	private Hora horaExamen;
	
	/** The contador examenes. */
	private static int contadorExamenes;

	/**
	 * Instantiates a new examen.
	 *
	 * @param asignatura the asignatura
	 * @param aula the aula
	 * @param fecha the fecha
	 * @param hora the hora
	 */
	public Examen(String asignatura, String aula, Fecha fecha, Hora hora) {
		nombreAsignatura = asignatura;
		this.aula = aula;
		fechaExamen = fecha;
		horaExamen = hora;
		contadorExamenes++;
	}

	/**
	 * Sets the fecha.
	 *
	 * @param dia the dia
	 * @param mes the mes
	 * @param año the año
	 */
	public void setFecha(int dia, int mes, int año) {
		fechaExamen = new Fecha(dia, mes, año);
	}

	/**
	 * Sets the hora.
	 *
	 * @param minuto the minuto
	 * @param hora the hora
	 */
	public void setHora(int minuto, int hora) {
		horaExamen = new Hora(minuto, hora);
	}

	/**
	 * Gets the numero examenes.
	 *
	 * @return the numero examenes
	 */
	public static int getNumeroExamenes() {
		return contadorExamenes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {

		String aux = "";

		aux += "Información examen: \n";
		aux += "Asignatura----> " + nombreAsignatura+"\n";
		aux += "Aula----------> " + aula+"\n";
		aux += "Fecha---------> " + fechaExamen+"\n";
		aux += "Hora----------> " + horaExamen+"\n";

		return aux;
	}

}

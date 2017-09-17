package org.mp.sesion03;

import java.util.Date;
import java.text.SimpleDateFormat;



// TODO: Auto-generated Javadoc
/**
 * The Class Residente.
 */
public class Residente implements Comparable<Object> {

	/** The dni. */
	private String dni;
	
	/** The nombre. */
	private String nombre;
	
	/** The fecha nacimiento. */
	private Date fechaNacimiento;
	
	/** The sexo. */
	private char sexo;


	/**
	 * Instantiates a new residente.
	 *
	 * @param nombre the nombre
	 * @param dni the dni
	 * @param sexo the sexo
	 * @param fecha the fecha
	 */
	public Residente(String nombre, String dni, char sexo, Date fecha) {
		this.nombre = nombre;
		this.dni = dni;
		this.sexo = sexo;
		this.fechaNacimiento = fecha;	
	}
		

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Gets the dni.
	 *
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Gets the fecha nacimiento.
	 *
	 * @return the fecha nacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Gets the sexo.
	 *
	 * @return the sexo
	 */
	public char getSexo() {
		return sexo;
	}

	/**
	 * Sets the nombre.
	 *
	 * @param s the new nombre
	 */
	public void setNombre(String s) {
		nombre = s;
	}

	/**
	 * Sets the dni.
	 *
	 * @param s the new dni
	 */
	public void setDni(String s) {
		dni = s;
	}

	/**
	 * Sets the sexo.
	 *
	 * @param c the new sexo
	 */
	public void setSexo(char c) {
		sexo = c;
	}

	/**
	 * Sets the fecha nacimiento.
	 *
	 * @param d the new fecha nacimiento
	 */
	public void setFechaNacimiento(Date d) {
		fechaNacimiento = d;
	}

	/**
	 * Gets the edad.
	 *
	 * @param date the date
	 * @return the edad
	 */
	public int getEdad(Date date){
		int edad;
		
		String formato="yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
		int anio = Integer.parseInt(dateFormat.format(date));
		int anio2 = Integer.parseInt(dateFormat.format(fechaNacimiento));
		edad = anio - anio2;
		
		formato="MM";
		dateFormat = new SimpleDateFormat(formato);
		int mes = Integer.parseInt(dateFormat.format(date));
		int mes2 = Integer.parseInt(dateFormat.format(fechaNacimiento));
		
		formato="dd";
		dateFormat = new SimpleDateFormat(formato);
		int dia = Integer.parseInt(dateFormat.format(date));
		int dia2 = Integer.parseInt(dateFormat.format(date));
		
		if(mes2 > mes){
			edad--;
		}else if(mes == mes2){
			if(dia2 > dia){
				edad--;
			}
		}
		
		return edad;
	}
	
	/**
	 * Equals.
	 *
	 * @param r the r
	 * @return true, if successful
	 */
	public boolean equals(Residente r){
		return (dni.equals(r.getDni())) ? true : false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Object o) {
		Residente r = (Residente) o;
		String[] splitNombre1 = nombre.split(",");
		String nombre1 = splitNombre1[1].replace(" ", "");
		String[] splitNombre2 = r.getNombre().split(",");
		String nombre2 = splitNombre2[1].replace(" ", "");
		
		
		if(nombre1.compareTo(nombre2) == 0){
			return 0;
		}else if(nombre1.compareTo(nombre2) == 1){
			return 1;
		}else{
			return -1;
		}
	}
}

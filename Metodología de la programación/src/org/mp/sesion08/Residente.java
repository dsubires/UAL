package org.mp.sesion08;

import java.util.Date;
import java.io.Serializable;
import java.text.SimpleDateFormat;

/**
 * Clase residente. Representa un residente de un hotel
 */
public class Residente implements Comparable<Object>, Serializable {

	
	private String dni;
	
	
	private String nombre;
	
	
	private Date fechaNacimiento;
	
	
	private char sexo;


	/**
	 * Instancia un nuevo residente
	 *
	 * @param nombre nombre residente
	 * @param dni dni residente
	 * @param sexo sexo residente
	 * @param fecha fecha nacimiento residente
	 */
	public Residente(String nombre, String dni, char sexo, Date fecha) {
		this.nombre = nombre;
		this.dni = dni;
		this.sexo = sexo;
		this.fechaNacimiento = fecha;	
	}
		

	/**
	 * Metodo getter del nombre de residente
	 *
	 * @return nombre residente
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo getter del dni del residente
	 *
	 * @return dni residente
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Metodo getter de la fecha de nacimiento del residente
	 *
	 * @return fecha nacimiento residente
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Metodo getter del sexo del residente
	 *
	 * @return sexo del residente
	 */
	public char getSexo() {
		return sexo;
	}

	/**
	 * Metodo setter del nombre del residente
	 *
	 * @param s nombre del residente
	 */
	public void setNombre(String s) {
		nombre = s;
	}

	/**
	 * Metodo setter del dni del residente
	 *
	 * @param s dni a asignar al residente
	 */
	public void setDni(String s) {
		dni = s;
	}

	/**
	 * Metodo setter del sexo del residente
	 *
	 * @param c sexo residente a asignar
	 */
	public void setSexo(char c) {
		sexo = c;
	}

	/**
	 * Metodo setter de la fecha de nacimiento del residente
	 *
	 * @param d fecha nacimiento residente
	 */
	public void setFechaNacimiento(Date d) {
		fechaNacimiento = d;
	}

	/**
	 * Metodo getter de la edad del residente
	 *
	 * @param date fecha para determinar edad del residente
	 * @return edad del residete
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
	 * Compara dos residentes
	 *
	 * @param r residente a comparar con el que llama al metodo
	 * @return true si son iguales, false en caso contrario
	 */
	public boolean equals(Residente r){
		return (dni.equals(r.getDni())) ? true : false;
	}
	
	/**
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

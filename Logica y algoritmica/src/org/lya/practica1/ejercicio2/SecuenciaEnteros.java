//
// Universidad de Almería
// Grado en Inform\'atica
//
// PRACTICA : 1
// ASIGNATURA : Logica y Algoritmica 
//
package org.lya.practica1.ejercicio2;

import org.lya.utilidades.*;

/**
 * Clase Secuencia de enteros.
 * Representa un conjunto de nœmeros enteros, pueden ser negativos.
 * @author David Subires Parra
 * 
 */
public class SecuenciaEnteros {
	
	/**
	 * Numero de elementos de la secuencia
	 */
	private int numeroElementos;
	
		
	/**
	 * Array con los valores de la secuencia: a_1, a_2,... a_n
	 */
	private int[] valoresSecuencia;

	
	/**
	 * Constructor.
	 * El array ya ha sido creado.
	 * @param datos 
	 */
	
	public SecuenciaEnteros(int[] datos) {
		numeroElementos = datos.length;
		valoresSecuencia = datos;
	}

	/**
	 * Constructor. 
	 * Genera los enteros de la secuencia aleatoriamente entre -rango y rango
	 * @param  Numero de elementos de la secuencia
	 * @param rango  de valores
	 */
	public SecuenciaEnteros(int numElem, int rango) {
		NumerosAleatorios aleatorio = new NumerosAleatorios();
		numeroElementos = numElem;
		valoresSecuencia = new int[numElem];
		for(int i=0; i<numElem;i++){
			valoresSecuencia[i] = aleatorio.randomInt(-rango, rango);
		}
	}


	// MŽtodos de acceso get/set
	
	public int getNumElementos(){
		return numeroElementos;
	}
	
	
	public int[] getValoresSecuencia(){
		return valoresSecuencia;
	}
}

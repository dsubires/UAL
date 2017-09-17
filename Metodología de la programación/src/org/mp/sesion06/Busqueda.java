
package org.mp.sesion06;

import java.util.Arrays;

import org.mp.utilidades.NumerosAleatorios;



// TODO: Auto-generated Javadoc
/**
 * Clase Busqueda.
 */
public class Busqueda {

	/** Numero de elementos. */
	private int numElementos;
	
	/** Elementos donde se buscara un numero  */
	private int[] datos;
	
	/** Numero buscado */
	private int numBuscado;

	/**
	 * Instantiates a new busqueda.
	 *
	 * @param numElementos the num elementos
	 */
	public Busqueda(int numElementos) {
		this.numElementos = numElementos;
		datos = new int[numElementos];
		inicializaDatos();
	}
	
	/**
	 * Inicializa datos.
	 */
	private void inicializaDatos() {

		NumerosAleatorios aleatorio = new NumerosAleatorios();
		for (int i = 0; i < datos.length; i++) {
			datos[i] = aleatorio.randomInt(5 * i, (5 * i) + 4);
		}
		Arrays.sort(datos);
		numBuscado = datos[aleatorio.randomInt(0, (datos.length - 1))];
	}

	/**
	 * Gets the num elementos.
	 *
	 * @return the num elementos
	 */
	public int getNumElementos() {
		return numElementos;
	}

	/**
	 * Gets the datos.
	 *
	 * @return the datos
	 */
	public int[] getDatos() {
		return datos;
	}

	/**
	 * Sets the datos.
	 *
	 * @param datosModelo the new datos
	 */
	public void setDatos(int[] datosModelo) {
		this.datos = (int[])datosModelo.clone();
		
	}

	/**
	 * Gets the num buscado.
	 *
	 * @return the num buscado
	 */
	public int getNumBuscado() {
		return numBuscado;
	}

	/**
	 * Sets the num buscado.
	 *
	 * @param buscar the new num buscado
	 */
	public void setNumBuscado(int buscar) {
		numBuscado = buscar;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		if (datos == null) {
			return null;
		} else {
			String s = "Problema busqueda con " + numElementos +"\n" + "{";
			for (int i = 0; i < datos.length; i++) {
				s += datos[i];
				s += (i < datos.length - 1 ? ", " : "}");
			}
			return s;
		}
	}
	

}
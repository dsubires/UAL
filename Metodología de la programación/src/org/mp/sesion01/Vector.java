package org.mp.sesion01;

// TODO: Auto-generated Javadoc
/**
 * The Class Vector.
 */
public class Vector {
	
	/** The elementos. */
	private int[] elementos;
	// Contador de Vectores
	/** The num vectores. */
	private static int numVectores;
	
	/**
	 * Instantiates a new vector.
	 */
	public Vector() {
		elementos = new int[(int) Math.random() * 10];
		for (int i = 0; i < this.elementos.length; i++) {
			this.elementos[i] = (int) (Math.random() * 100);
		}
		numVectores++;
	}

	/**
	 * Instantiates a new vector.
	 *
	 * @param num the num
	 */
	public Vector(int num) {
		elementos = new int[num];
		for (int i = 0; i < this.elementos.length; i++) {
			this.elementos[i] = (int) (Math.random() * 100);
		}
		numVectores++;
	}

	/**
	 * Instantiates a new vector.
	 *
	 * @param vector the vector
	 */
	public Vector(int[] vector) {
		elementos = new int[vector.length];
		for (int i = 0; i < elementos.length; i++) {
			elementos[i] = vector[i];
		}
		numVectores++;
	}
	
	/**
	 * Gets the num vectores.
	 *
	 * @return the num vectores
	 */
	public static int getNumVectores() {
		return numVectores;
	}

	/**
	 * Media aritmetica.
	 *
	 * @return the int
	 */
	public int mediaAritmetica() {
		int aux = 0;

		for (int i = 0; i < elementos.length; i++) {
			aux += elementos[i];
		}

		return (aux / elementos.length);
	}
	

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		int[] myArray = {-10,5,0,7,20};
		Vector myVector = new Vector (myArray);		
		System.out.println(myVector.mediaAritmetica());

	}

}

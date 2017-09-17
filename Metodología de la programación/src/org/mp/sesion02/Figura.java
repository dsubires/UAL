package org.mp.sesion02;

// TODO: Auto-generated Javadoc
/**
 * The Class Figura.
 */
@SuppressWarnings("rawtypes")
public abstract class Figura implements Comparable {
	
	/**
	 * Area.
	 *
	 * @return the double
	 */
	abstract public double area();

	/** The nombre. */
	private String nombre;

	/**
	 * Instantiates a new figura.
	 *
	 * @param nombreFigura the nombre figura
	 */
	public Figura(String nombreFigura) {
		nombre = nombreFigura;
	}

	/**
	 * Menor que.
	 *
	 * @param lder the lder
	 * @return true, if successful
	 */
	final public boolean menorQue(Figura lder) {
		return area() < lder.area();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	final public String toString() {

		return nombre + " con area " + area();
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Object o) {

		Figura figura = (Figura) o;
		if (area() == figura.area()) {
			return 0;
		} else if (area() > figura.area()) {
			return 1;
		} else {
			return -1;
		}

	}

}

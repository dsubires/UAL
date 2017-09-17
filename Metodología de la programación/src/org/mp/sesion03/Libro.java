package org.mp.sesion03;

// TODO: Auto-generated Javadoc
/**
 * The Class Libro.
 */
public class Libro {

	/** The titulo. */
	private String titulo;
	
	/** The autor. */
	private String autor;
	
	/** The num catalogo. */
	private int numCatalogo;
	
	/** The disponible. */
	private boolean disponible;

	/**
	 * Instantiates a new libro.
	 *
	 * @param titulo the titulo
	 * @param autor the autor
	 * @param num the num
	 */
	public Libro(String titulo, String autor, int num) {
		this.titulo = titulo;
		this.autor = autor;
		numCatalogo = num;
		disponible = true;
	}

	/**
	 * Instantiates a new libro.
	 *
	 * @param titulo the titulo
	 * @param autor the autor
	 * @param num the num
	 * @param d the d
	 */
	public Libro(String titulo, String autor, int num, boolean d) {
		this.titulo = titulo;
		this.autor = autor;
		numCatalogo = num;
		disponible = d;
	}

	/**
	 * Gets the disponible.
	 *
	 * @return the disponible
	 */
	public boolean getDisponible() {
		return disponible;
	}

	/**
	 * Gets the titulo.
	 *
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Gets the autor.
	 *
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * Gets the num catalogo.
	 *
	 * @return the num catalogo
	 */
	public int getNumCatalogo() {
		return numCatalogo;
	}

	/**
	 * Prestado.
	 */
	public void prestado() {
		disponible = false;

	}

	/**
	 * Devuelto.
	 */
	public void devuelto() {
		disponible = true;
	}

	/**
	 * Equals.
	 *
	 * @param l the l
	 * @return true, if successful
	 */
	public boolean equals(Libro l) {
		if (titulo.equals(l.titulo) && autor.equals(l.autor)) {
			return true;
		} else {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return titulo + " " + autor;
	}

}

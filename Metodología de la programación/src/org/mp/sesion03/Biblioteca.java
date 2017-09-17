package org.mp.sesion03;

// TODO: Auto-generated Javadoc
/**
 * The Class Biblioteca.
 */
public class Biblioteca {

	/** The nombre. */
	private String nombre;
	
	/** The libros. */
	private Libro[] libros;
	
	/** The socios. */
	private Socio[] socios;
	
	/** The contador socios. */
	private int contadorSocios;

	/**
	 * Instantiates a new biblioteca.
	 *
	 * @param nombre the nombre
	 */
	public Biblioteca(String nombre) {
		this.nombre = nombre;
		contadorSocios = 0;
		socios = new Socio[1000];
		libros = new Libro[1000];
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
	 * Num libros biblioteca.
	 *
	 * @return the int
	 */
	public int numLibrosBiblioteca() {
		int aux = 0;
		for (int i = 0; i < libros.length; i++) {
			if (libros[i] != null) {
				aux++;
			}
		}
		return aux;
	}

	/**
	 * Incluir libro.
	 *
	 * @param l the l
	 */
	public void incluirLibro(Libro l) {
		for (int i = 0; i < libros.length; i++) {
			if (libros[i] == null) {
				libros[i] = l;
				break;
			}
		}
	}

	/**
	 * Gets the libros disponibles para prestamo.
	 *
	 * @return the libros disponibles para prestamo
	 */
	public Libro[] getLibrosDisponiblesParaPrestamo() {
		int numDisponibles = 0;
		for (int i = 0; i < libros.length; i++) {
			if (libros[i] != null)
				if (libros[i].getDisponible())
					numDisponibles++;
		}
		Libro[] disponibles = new Libro[numDisponibles];
		for (int i = 0; i < libros.length; i++) {
			if (libros[i] != null)
				if (libros[i].getDisponible()) {
					for (int j = 0; j < disponibles.length; j++) {
						if (disponibles[j] == null) {
							disponibles[j] = libros[i];
							break;
						}
					}
				}

		}
		return disponibles;
	}

	/**
	 * Num socios biblioteca.
	 *
	 * @return the int
	 */
	public int numSociosBiblioteca() {
		return contadorSocios;
	}

	/**
	 * Registrar socio.
	 *
	 * @param s the s
	 */
	public void registrarSocio(Socio s) {
		for (int i = 0; i < socios.length; i++) {
			if (socios[i] == null) {
				socios[i] = s;
				break;
			}
		}
		contadorSocios++;
	}

	/**
	 * Gets the socios.
	 *
	 * @return the socios
	 */
	public Socio[] getSocios() {
		return socios;
	}

	/**
	 * Prestar libro.
	 *
	 * @param l the l
	 * @param s the s
	 */
	public void prestarLibro(Libro l, Socio s) {
		l.prestado();
	}

	/**
	 * Gets the libros en prestamo.
	 *
	 * @return the libros en prestamo
	 */
	public Libro[] getLibrosEnPrestamo() {
		int numEnPrestamo = 0;
		for (int i = 0; i < libros.length; i++) {
			if (libros[i] != null)
				if (!libros[i].getDisponible())
					numEnPrestamo++;
		}
		Libro[] prestamos = new Libro[numEnPrestamo];
		for (int i = 0; i < libros.length; i++) {
			if (libros[i] != null)
				if (!libros[i].getDisponible()) {
					for (int j = 0; j < prestamos.length; j++) {
						if (prestamos[j] == null) {
							prestamos[j] = libros[i];
							break;
						}
					}
				}

		}
		return prestamos;

	}

	/**
	 * Devolver libro.
	 *
	 * @param l the l
	 */
	public void devolverLibro(Libro l) {
		l.devuelto();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String aux = "";
		for (int i = 0; i < libros.length; i++) {
			if (libros[i] != null)
				aux += libros[i].getTitulo() + " " + libros[i].getAutor()
						+ "\n";
		}
		return aux;
	}

}

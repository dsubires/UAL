package org.mp.sesion01;

// TODO: Auto-generated Javadoc
/**
 * The Class Multimedia.
 */
public class Multimedia {

	/** The titulo. */
	private String titulo;
	
	/** The autor. */
	private String autor;
	
	/** The formato. */
	private String formato;
	
	/** The duracion. */
	private int duracion;

	/**
	 * Instantiates a new multimedia.
	 *
	 * @param titulo the titulo
	 * @param autor the autor
	 * @param formato the formato
	 * @param duracion the duracion
	 */
	public Multimedia(String titulo, String autor, String formato, int duracion) {
		this.titulo = titulo;
		this.autor = autor;
		if (formato.equals("wav") || formato.equals("mp3")
				|| formato.equals("midi") || formato.equals("avi")
				|| formato.equals("mov") || formato.equals("mpg")
				|| formato.equals("cdAudio") || formato.equals("dvd")) {
			this.formato = formato;
		} else {
			this.formato = "???";
		}
		this.duracion = duracion;
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
	 * Gets the formato.
	 *
	 * @return the formato
	 */
	public String getFormato() {
		return formato;
	}

	/**
	 * Gets the duracion.
	 *
	 * @return the duracion
	 */
	public int getDuracion() {
		return duracion;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String aux = "Información sobre elemento multimedia: \n";

		aux += "Titulo------------>" + titulo+"\n";
		aux += "Autor------------->" + autor+"\n";
		aux += "Formato----------->" + formato+"\n";
		aux += "Duración---------->" + duracion+"\n";

		return aux;
	}

	/**
	 * Equals.
	 *
	 * @param multimedia the multimedia
	 * @return true, if successful
	 */
	public boolean equals(Multimedia multimedia){
		return (this.titulo.equals(multimedia.titulo) && this.autor.equals(multimedia.autor))?true:false;
	}
	
	
}

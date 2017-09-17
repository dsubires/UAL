package org.mp.sesion01;

// TODO: Auto-generated Javadoc
/**
 * The Class Disco.
 */
public class Disco extends Multimedia {
	
	/** The genero. */
	private String genero;
	
	/**
	 * Instantiates a new disco.
	 *
	 * @param titulo the titulo
	 * @param autor the autor
	 * @param formato the formato
	 * @param duracion the duracion
	 * @param genero the genero
	 */
	public Disco(String titulo, String autor, String formato, int duracion, String genero){
		super(autor, titulo, formato, duracion);
		this.genero = genero;
	}
	
	/**
	 * Gets the genero.
	 *
	 * @return the genero
	 */
	public String getGenero(){
		return genero;
	}
	
	/* (non-Javadoc)
	 * @see org.mp.bloque1.ejercicio01.Multimedia#toString()
	 */
	public String toString() {
		String aux = super.toString() + "\n";

		aux += "Datos Disco: \n";
		aux += "Género------------>" +genero+"\n";

		return aux;
	}


}

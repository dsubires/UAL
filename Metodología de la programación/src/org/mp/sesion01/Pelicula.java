package org.mp.sesion01;

// TODO: Auto-generated Javadoc
/**
 * The Class Pelicula.
 */
public class Pelicula extends Multimedia{ 

	/** The actor principal. */
	private String actorPrincipal;
	
	/** The actriz principal. */
	private String actrizPrincipal;

	/**
	 * Instantiates a new pelicula.
	 *
	 * @param autor the autor
	 * @param titulo the titulo
	 * @param formato the formato
	 * @param duracion the duracion
	 * @param actorPrincipal the actor principal
	 * @param actrizPrincipal the actriz principal
	 * @throws Exception the exception
	 */
	public Pelicula(String autor, String titulo, String formato, int duracion,
			String actorPrincipal, String actrizPrincipal) throws Exception{
		
		super(autor, titulo, formato, duracion);
		this.actorPrincipal = actorPrincipal;
		this.actrizPrincipal = actrizPrincipal;
		if(actorPrincipal == null && actrizPrincipal == null){
			throw new Exception("Error: Actor y Actriz vacíos en "+titulo+" de "+autor);
		}
	}

	/**
	 * Gets the actor principal.
	 *
	 * @return the actor principal
	 */
	public String getActorPrincipal() {
		return actorPrincipal;
	}

	/**
	 * Gets the actriz principal.
	 *
	 * @return the actriz principal
	 */
	public String getActrizPrincipal() {
		return actrizPrincipal;
	}

	/* (non-Javadoc)
	 * @see org.mp.bloque1.ejercicio01.Multimedia#toString()
	 */
	public String toString() {
		String aux = super.toString() + "\n";

		aux += "Datos Pelicula: \n";
		aux += "Actor Principal--->" + actorPrincipal+"\n";
		aux += "Actriz principal-->" + actrizPrincipal+"\n";

		return aux;
	}

}

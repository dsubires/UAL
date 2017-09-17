package org.mp.sesion01;

// TODO: Auto-generated Javadoc
/**
 * The Class AparatoElectrico.
 */
public class AparatoElectrico {
	
	/** The nombre. */
	private String nombre;
	
	/** The potencia. */
	private int potencia;
	
	/** The estado. */
	private boolean estado;
	//private static int consumoTotal;
	
	/**
	 * Instantiates a new aparato electrico.
	 *
	 * @param nombre the nombre
	 * @param potencia the potencia
	 */
	public AparatoElectrico(String nombre,int potencia) {
		this.nombre = nombre;
		this.potencia = potencia;
		this.estado = false; // por defecto, el aparato está apagado
	}

	/**
	 * Gets the nombre aparato.
	 *
	 * @return the nombre aparato
	 */
	public String getNombreAparato(){
		return this.nombre;
	}
	
	/**
	 * Gets the potencia aparato.
	 *
	 * @return the potencia aparato
	 */
	public int getPotenciaAparato(){
		return this.potencia;
	}
	
	/**
	 * Gets the consumo aparato.
	 *
	 * @return the consumo aparato
	 */
	public int getConsumoAparato() {
		return (estado) ? potencia : 0;
	}
	
	/**
	 * Clic.
	 */
	public void clic() {
		this.estado = !this.estado;
	//	consumoTotal += (this.estado)?this.potencia:-this.potencia;
		}
	
//	public static int getConsumoTotal(){
//		return consumoTotal;
//	}

	/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
	public String toString() {
		return this.nombre+" "+ this.potencia + ((this.estado) ? "(On )" : "(Off)");
	}


}

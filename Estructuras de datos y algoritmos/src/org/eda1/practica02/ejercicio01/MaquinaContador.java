package org.eda1.practica02.ejercicio01;


/**
 * The Class MaquinaContador.
 */
public class MaquinaContador implements Comparable<Object> {

	/** The maquina. */
	private String maquina;
	
	/** The contador. */
	private int contador;
	
	
	/**
	 * Instantiates a new maquina contador.
	 *
	 * @param maq the maq
	 * @param c the c
	 */
	public MaquinaContador(String maq, int c){
		maquina = maq;
		contador = c;
	}
	
	/**
	 * Instantiates a new maquina contador.
	 *
	 * @param maq the maq
	 */
	public MaquinaContador(String maq){
		maquina = maq;
		contador = 1;
	}
	
	/**
	 * Instantiates a new maquina contador.
	 */
	public MaquinaContador(){
		maquina = null;
		contador = 1;
	}
	
	/**
	 * Sets the maquina.
	 *
	 * @param maq the new maquina
	 */
	public void setMaquina(String maq){
		maquina = maq;
	}
	
	/**
	 * Gets the maquina.
	 *
	 * @return the maquina
	 */
	public String getMaquina(){
		return maquina;
	}
	
	/**
	 * Sets the contador.
	 *
	 * @param c the new contador
	 */
	public void setContador(int c){
		contador = c;
	}
	
	/**
	 * Gets the contador.
	 *
	 * @return the contador
	 */
	public int getContador(){
		return contador;
	}
	
	/**
	 * Incrementar contador.
	 */
	public void incrementarContador(){
		contador++;
	}

	/**
	 * Compare to.
	 *
	 * @param otraMaquina the otra maquina
	 * @return the int
	 */
	@Override
	public int compareTo(Object otraMaquina){		
		MaquinaContador mc = (MaquinaContador) otraMaquina;
	
		return maquina.compareTo(mc.maquina);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj){
		return maquina.equals(((MaquinaContador) obj).maquina);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return "["+maquina+", "+contador+"]";
	}
	
	
}

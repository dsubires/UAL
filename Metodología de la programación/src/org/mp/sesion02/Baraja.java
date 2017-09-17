package org.mp.sesion02;


// TODO: Auto-generated Javadoc
/**
 * The Class Baraja.
 */
public class Baraja {

	/** The nombre baraja. */
	private String nombreBaraja;
	
	/** The cartas. */
	private Carta[] cartas;

	/**
	 * Instantiates a new baraja.
	 *
	 * @param nombreBaraja the nombre baraja
	 * @param carta the carta
	 */
	public Baraja(String nombreBaraja, Carta[] carta){
		this.nombreBaraja = nombreBaraja;
		cartas = new Carta[carta.length];
		for(int i=0; i<cartas.length;i++){
			cartas[i] = carta[i].clone();
		}
		
	}
	
	/**
	 * Gets the nombre baraja.
	 *
	 * @return the nombre baraja
	 */
	public String getNombreBaraja(){
		return nombreBaraja;
	}
	
	/**
	 * Gets the cartas.
	 *
	 * @return the cartas
	 */
	public Carta[] getCartas(){
		return cartas;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		String aux = "";
		for(int i=0; i > cartas.length; i++){
			aux += cartas[i]+" \n";
		}
		return aux;
	}
}

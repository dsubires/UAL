package org.mp.sesion06;

// TODO: Auto-generated Javadoc
/**
 * The Class Carta.
 */
@SuppressWarnings("rawtypes")
public class Carta implements Comparable {

	/** The palo. */
	private String palo;
	
	/** The numero. */
	private int numero;
	
	/** The valor. */
	private double valor;

	
	/**
	 * Instantiates a new carta.
	 *
	 * @param palo the palo
	 * @param numero the numero
	 */
	public Carta(String palo,int numero){
		this.palo = palo;
		this.numero = numero;
		if(palo.equals("O")){
			valor = numero;	
		}else if(palo.equals("C")){
			valor = numero * 100;
		}else if(palo.equals("E")){
			valor = numero * 10000;
		}else if(palo.equals("B")){
			valor = numero * 1000000;
		}
	}
	
	/**
	 * Gets the palo.
	 *
	 * @return the palo
	 */
	public String getPalo(){
		return palo;
	}
	
	/**
	 * Gets the numero.
	 *
	 * @return the numero
	 */
	public int getNumero(){
		return numero;
	}
	
	/**
	 * Gets the valor.
	 *
	 * @return the valor
	 */
	public double getValor(){
		return valor;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Carta clone() {
		return new Carta(palo,numero);
	}

	
	/**
	 * Equals.
	 *
	 * @param c the c
	 * @return true, if successful
	 */
	public boolean equals(Carta c) {
		return (this.palo.equals(c.palo) && this.numero == c.numero)? true : false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return "Inf carta:\n"+numero+" de "+palo+"\nValor: "+valor;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Object o) {
		Carta carta = (Carta) o;
		if(this.valor == carta.valor){
			return 0;
		}else if(this.valor > carta.valor){
			return 1;
		}else{
			return -1;	
		}
	}
}

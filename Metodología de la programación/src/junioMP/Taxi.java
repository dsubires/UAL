package junioMP;

/**
 * The Class Taxi.
 */
public class Taxi {

	/** The licencia. */
	private int licencia;
	private String propietario;
	
	/** The a minusvalido. */
	private boolean minusvalido;
	
	
	
	/**
	 * Instantiates a new taxi.
	 *
	 * @param l the l
	 * @param m the m
	 */
	public Taxi(int l, String p,boolean m){
		licencia = l;
		propietario = p;
		minusvalido = m;
	}
	
	
	/**
	 * Gets the licencia.
	 *
	 * @return the licencia
	 */
	public int getLicencia(){
		return licencia;
	}
	
	/**
	 * Gets the minusvalido.
	 *
	 * @return the minusvalido
	 */
	public boolean isMinusvalido(){
		return minusvalido;
	}
	
	public String getPropietario(){
		return propietario;
	}
	
	public void setPropietario(String p){
		propietario = p;
	}
	
	public void setMinusvalido(boolean m){
		minusvalido = m;
	}
	
	@Override
	public String toString(){
		return "Licencia "+licencia+" Propietario "+propietario+" Minusvalido "+minusvalido;
	}
	
	/**
	 * Equals.
	 *
	 * @param t the t
	 * @return true, if successful
	 */
	public boolean equals(Object o){
		Taxi t = (Taxi) o;
		return (licencia == t.licencia);
	}

}

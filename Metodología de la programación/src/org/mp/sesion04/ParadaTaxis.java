package org.mp.sesion04;

// TODO: Auto-generated Javadoc
/**
 * The Class ParadaTaxis.
 */
public class ParadaTaxis {

	/** The nombre. */
	private String nombre;
	
	/** The direccion. */
	private String direccion;
	
	/** The taxis. */
	private QueueLinkedList<Taxi> taxis;
	
	/**
	 * Instantiates a new parada taxis.
	 *
	 * @param n the n
	 * @param d the d
	 */
	public ParadaTaxis(String n,String d){
		nombre = n;
		direccion = d;
		taxis = new QueueLinkedList<Taxi>();
	}
	
	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre(){
		return nombre;
	}
	
	/**
	 * Direccion.
	 *
	 * @return the string
	 */
	public String direccion(){
		return direccion;
	}
	
	/**
	 * Numero taxis.
	 *
	 * @return the int
	 */
	public int numeroTaxis(){
		return taxis.size();
	}
	
	/**
	 * Entrada taxi.
	 *
	 * @param t the t
	 */
	public void entradaTaxi(Taxi t){
		taxis.addLast(t);
	}
	
	/**
	 * Salida taxi.
	 *
	 * @return the taxi
	 * @throws EmptyQueueException the empty queue exception
	 */
	public Taxi salidaTaxi() throws  EmptyQueueException{
		if(taxis.isEmpty()){
			throw new EmptyQueueException("Cola Vacia");
		}
		return taxis.removeFirst();
	}
	
	/**
	 * Primer taxi.
	 *
	 * @return the taxi
	 * @throws EmptyQueueException the empty queue exception
	 */
	public Taxi primerTaxi() throws  EmptyQueueException{
		if(taxis.isEmpty()){
			throw new EmptyQueueException("Cola Vacia");
		}
		return taxis.getFirst();
	}

	
	/**
	 * Listado.
	 *
	 * @return the string
	 * @throws EmptyQueueException the empty queue exception
	 */
	public String listado()throws  EmptyQueueException{
		if(taxis.isEmpty()){
			throw new EmptyQueueException("Cola Vacia");
		}
		String aux = "";
		ListNode<Taxi> nodeAux = taxis.firstQueue;
		for(int i=0; i<taxis.size; i++){
			aux += nodeAux.element+"\n";
			nodeAux = nodeAux.next;
		}
		return aux;
	}
	
	/**
	 * Minusvalido taxi.
	 *
	 * @return the taxi
	 * @throws EmptyQueueException the empty queue exception
	 */
	public Taxi minusvalidoTaxi() throws  EmptyQueueException{
		if(taxis.isEmpty()){
			throw new EmptyQueueException("Cola Vacia");
		}
		QueueLinkedList<Taxi> taxisAux = new QueueLinkedList<Taxi>();
		ListNode<Taxi> nodeAux = taxis.firstQueue;
		Taxi taxiAdaptado = null;
		//Atributo que nos permite obtener SOLO el primer taxi adaptado para minusvalidos
		boolean taxiAdaptadoOk = false;
		for(int i=0; i<taxis.size; i++){
			if(nodeAux.element.getMinusvalido() && !taxiAdaptadoOk){
				taxiAdaptado = nodeAux.element;
				nodeAux = nodeAux.next;
				taxiAdaptadoOk = true;
			}else{
				taxisAux.addLast(nodeAux.element);
				nodeAux = nodeAux.next;
			}
		}
		taxis = taxisAux;
		return taxiAdaptado;
	}
	


}

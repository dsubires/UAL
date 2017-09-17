package junioMP;

import java.util.LinkedList;

public class ColaDobleLinkedList implements ColaDoble {

	private LinkedList<Object> colaDobleLinkedList;
	
	public ColaDobleLinkedList(){
		colaDobleLinkedList = new LinkedList<Object>();
	}
	
	public boolean esVaciaColaDoble(){
		return colaDobleLinkedList.size() == 0;
	}
	

	public void insertarPorDelante(Object x) {
			colaDobleLinkedList.addFirst(x);		
	}

	@Override
	public void insertarPorDetras(Object x) {
		colaDobleLinkedList.addLast(x);
		
	}

	@Override
	public Object eliminarPorDelante() throws DesbordamientoInferiorException {
		if(esVaciaColaDoble()){
			throw new DesbordamientoInferiorException("Cola doble vacia");
		}
		return colaDobleLinkedList.removeFirst();
	}

	@Override
	public Object eliminarPorDetras() throws DesbordamientoInferiorException {
		if(esVaciaColaDoble()){
			throw new DesbordamientoInferiorException("Cola doble vacia");
		}
		return colaDobleLinkedList.removeLast();
	}

	@Override
	public Object verPrimero() throws DesbordamientoInferiorException {
		if(esVaciaColaDoble()){
			throw new DesbordamientoInferiorException("Cola doble vacia");
		}
		return colaDobleLinkedList.getFirst();
	}

	@Override
	public Object verFinal() throws DesbordamientoInferiorException {
		if(esVaciaColaDoble()){
			throw new DesbordamientoInferiorException("Cola doble vacia");
		}
		return colaDobleLinkedList.getLast(); 
	}

	@Override
	public int tamanoColaDoble() {
		return colaDobleLinkedList.size();
	}



}

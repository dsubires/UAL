package junioMP;


public class ColaLista implements Cola {
	
	protected ListNode cabeza;
	protected ListNode fin;
	protected int tamano;
	
	public ColaLista(){
		cabeza = null;
		fin = null;
		tamano = 0;
	}
	
	public void insertar(Object o){
		if(esVacia()){
			cabeza = new ListNode(o);
			tamano++;
		}else{
			if(tamano() == 1){
				fin = new ListNode(o);
				cabeza.next = fin;
				tamano++;
			}else{
			fin.next = new ListNode(o);
			fin = fin.next;
			tamano++;
			}
		}
	}
	
	public Object primero() throws DesbordamientoInferiorException{
		if(esVacia()){
			throw new  DesbordamientoInferiorException("Cola Lista Vacia");
		}
		return cabeza.element;
		
	}
	
	public Object quitarPrimero() throws DesbordamientoInferiorException{
		if(esVacia()){
			throw new DesbordamientoInferiorException("Cola Lista Vacia");
		}
		Object o = cabeza.element;
		cabeza = cabeza.next;
		tamano--;
		return o;
	}
	
	public boolean esVacia(){
		return tamano == 0;
	}
	
	public void vaciar(){
		cabeza = null;
		fin = null;
		tamano = 0;
	}
	
	public int tamano(){
		return tamano;
	}
	
	
}

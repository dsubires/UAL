package junioMP;

public class ColaDobleLista extends ColaLista implements ColaDoble {

	public ColaDobleLista() {
		super();
	}

	public boolean esVaciaColaDoble() {
		return esVacia();
	}

	public void insertarPorDelante(Object x) {
		ListNode temp = cabeza;
		cabeza = new ListNode(x, temp);
		if (tamano == 0) {
			fin = cabeza;
		}
		tamano++;
	}

	public void insertarPorDetras(Object x) {
		insertar(x);
	}

	public Object eliminarPorDelante() throws DesbordamientoInferiorException {
		if (esVacia()) {
			throw new DesbordamientoInferiorException("Cola doble vacia");
		}
		return quitarPrimero();
	}

	public Object eliminarPorDetras() throws DesbordamientoInferiorException {
		if (esVacia()) {
			throw new DesbordamientoInferiorException("Cola doble vacia");
		}
		Object o = fin.element;
		if (tamano == 1) {
			vaciar();
		} else {
			ListNode current = cabeza;
			for (int i = 0; i < tamano; i++) {
				if (i == tamano - 2) {
					current.next = null;
					fin = current;
					tamano--;
					break;
				}
				current = current.next;
			}
		}
		return o;

	}

	public Object verPrimero() throws DesbordamientoInferiorException {
		if (esVacia()) {
			throw new DesbordamientoInferiorException("Cola doble vacia");
		}
		return primero();
	}

	public Object verFinal() throws DesbordamientoInferiorException {
		if (esVacia()) {
			throw new DesbordamientoInferiorException("Cola doble vacia");
		}
		return fin.element;
	}

	public int tamanoColaDoble() {
		return tamano;
	}

}

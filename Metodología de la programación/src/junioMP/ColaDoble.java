package junioMP;

public interface ColaDoble {


	boolean esVaciaColaDoble();
	
	void insertarPorDelante(Object x);
	
	void insertarPorDetras(Object x);
	
	Object eliminarPorDelante() throws DesbordamientoInferiorException;
	
	Object eliminarPorDetras() throws DesbordamientoInferiorException;
	
	Object verPrimero()throws DesbordamientoInferiorException;
	
	Object verFinal()throws DesbordamientoInferiorException;
	
	int tamanoColaDoble();
	
}

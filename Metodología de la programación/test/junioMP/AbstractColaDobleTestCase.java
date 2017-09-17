package junioMP;

import junit.framework.TestCase;

public abstract class AbstractColaDobleTestCase extends TestCase {

	private String mensaje;
    private ColaDoble cola;

    protected void setUp() throws Exception {
        super.setUp();
        cola = crearCola();
    }

    protected abstract ColaDoble crearCola();

    public final void testEsVacia() {

    	mensaje = "El tamano de la cola debe ser 0";
        assertEquals(mensaje, (Integer) 0, (Integer)cola.tamanoColaDoble());

        try {
            cola.eliminarPorDelante();
            mensaje = "Debe saltar la excepcion";
            fail(mensaje);
        } catch (DesbordamientoInferiorException e) {

        }
    }

    public void testVaciar() {

    	mensaje = "Debe estar vacia";
        assertTrue(mensaje,cola.esVaciaColaDoble());

        cola.insertarPorDetras(new Integer(11));
        cola.insertarPorDetras(new Double(11));
        cola.insertarPorDetras(new Float(11));

        mensaje = "No debe estar vacia";
        assertFalse(mensaje,cola.esVaciaColaDoble());

    }

    public void testEncolarDesencolar() {

        Integer entero = new Integer(11);
        Double realdoble = new Double(11);
        Float real = new Float(11);

        cola.insertarPorDetras(entero);
        cola.insertarPorDetras(realdoble);
        cola.insertarPorDetras(real);

        mensaje = "El tamano de la cola debe ser 3";
        assertEquals(mensaje,3, cola.tamanoColaDoble());
        mensaje = "No debe estar vacia";
        assertFalse(mensaje,cola.esVaciaColaDoble());

        try {
        	mensaje = "Deben ser iguales";
            assertEquals(mensaje,entero, (Integer) cola.eliminarPorDelante());
        } catch (DesbordamientoInferiorException e3) {

            e3.printStackTrace();
        }

        mensaje = "El tamano de la cola debe ser 2";
        assertEquals(mensaje,2, cola.tamanoColaDoble());
        mensaje = "No debe estar vacia";
        assertFalse(mensaje,cola.esVaciaColaDoble());

        try {
        	mensaje = "Deben ser iguales";
            assertEquals(mensaje,realdoble, (Double) cola.eliminarPorDelante());
        } catch (DesbordamientoInferiorException e2) {

            e2.printStackTrace();
        }

        mensaje = "El tamano de la cola debe ser 1";
        assertEquals(mensaje,1, cola.tamanoColaDoble());
        mensaje = "No debe estar vacia";
        assertFalse(mensaje,cola.esVaciaColaDoble());

        try {
        	mensaje = "Deben ser iguales";
            assertEquals(mensaje,real, (Float) cola.eliminarPorDelante());
        } catch (DesbordamientoInferiorException e1) {

            e1.printStackTrace();
        }

        mensaje = "El tamano de la cola debe ser 0";
        assertEquals(mensaje,0, cola.tamanoColaDoble());
        mensaje = "Debe estar vacia";
        assertTrue(mensaje,cola.esVaciaColaDoble());

        try {
            cola.eliminarPorDelante();
            mensaje = "Debe saltar la excepcion";
            fail(mensaje);

        } catch (DesbordamientoInferiorException e) {

        }
    }

    public final void testInsertarPorDetras() {

        for (int i = 0; i < 1000; i++) {
            Integer entero = new Integer(i);
            cola.insertarPorDetras(entero);
        }

        mensaje = "No debe estar vacia";
        assertFalse(mensaje,cola.esVaciaColaDoble());
        
        try{
        	mensaje = "El primer valor debe ser 0";
        	assertEquals(mensaje,(Integer) 0, (Integer) cola.verPrimero());
        	
        }catch(DesbordamientoInferiorException e){
        	
        }
        
        try{
        	mensaje = "El ultimo valor debe ser 999";
            assertEquals(mensaje,(Integer) 999, (Integer) cola.verFinal());	
            
        }catch(DesbordamientoInferiorException e){
        	
        }
        
        for (int i = 0; i < 1000; i++) {
            Integer entero = new Integer(i);
            try {
            	mensaje = "Deben ser iguales";
                assertEquals(mensaje,cola.eliminarPorDelante(), entero);
            } catch (DesbordamientoInferiorException e) {

                e.printStackTrace();
            }
        }

        mensaje = "Debe estar vacia";
        assertTrue(mensaje,cola.esVaciaColaDoble());

    }
    
    public final void testInsertarPorDelante() {
    	
        for (int i = 0; i < 1000; i++) {
            Integer entero = new Integer(i);
            cola.insertarPorDelante(entero);
        }

        mensaje = "No debe estar vacia";
        assertFalse(mensaje,cola.esVaciaColaDoble());
        
        try{
        	mensaje = "El primer valor debe ser 999";
        	assertEquals(mensaje,(Integer) 999, (Integer) cola.verPrimero());
        	
        }catch(DesbordamientoInferiorException e){
        	
        }
        
        try{
        	mensaje = "El ultimo valor debe ser 0";
            assertEquals(mensaje,(Integer) 0, (Integer) cola.verFinal());	
            
        }catch(DesbordamientoInferiorException e){
        	
        }
      
        for (int i = 0; i < 1000; i++) {
            Integer entero = new Integer(i);
            try {
            	mensaje = "Deben ser iguales";
                assertEquals(mensaje,cola.eliminarPorDetras(), entero);
            } catch (DesbordamientoInferiorException e) {

                e.printStackTrace();
            }
        }

        mensaje = "Debe estar vacia";
        assertTrue(mensaje,cola.esVaciaColaDoble());   

    }
   
}


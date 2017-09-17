package org.mp.sesion02;
// TODO: Auto-generated Javadoc

/**
 * The Class Cuadrado.
 */
public class Cuadrado extends Rectangulo {
	
	/** The lado. */
	private double lado;

    /**
     * Instantiates a new cuadrado.
     *
     * @param lado the lado
     */
    public Cuadrado( double lado )
    {
        super( lado, lado );
        this.lado = lado;
        
    }
    
  /*  public int compareTo(Figura figura){
    	if(figura.getNombre().equals("Cuadrado") || figura.getNombre().equals("Rectangulo")){
    	if(this.area() == figura.area() ){
    		return 0;
    	}else{
    		return -1;
    	}
    	}
    	return 0; 
    }
         
    */    

    /* (non-Javadoc)
   * @see org.mp.bloque2.ejercicios.Rectangulo#area()
   */
  public double area( )
    {
        return lado*lado;
    }
    
}
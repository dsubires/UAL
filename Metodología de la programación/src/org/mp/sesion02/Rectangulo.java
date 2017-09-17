package org.mp.sesion02;
// TODO: Auto-generated Javadoc

/**
 * The Class Rectangulo.
 */
public class Rectangulo extends Figura
{
    
    /**
     * Instantiates a new rectangulo.
     *
     * @param largo the largo
     * @param ancho the ancho
     */
    public Rectangulo( double largo, double  ancho )
    {
        super ((largo == ancho)?"Cuadrado":"Rectangulo");
        base = largo;
        alt = ancho;
    }
    
    /* (non-Javadoc)
     * @see org.mp.bloque2.ejercicios.Figura#area()
     */
    public double area( )
    {
        return base * alt;
    }
    
    
    /** The base. */
    private double base;
    
    /** The alt. */
    private double alt;
}
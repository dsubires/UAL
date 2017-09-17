package org.mp.sesion02;
// TODO: Auto-generated Javadoc

/**
 * The Class Circulo.
 */
public class Circulo extends Figura
{
    
    /**
     * Instantiates a new circulo.
     *
     * @param r the r
     */
    public Circulo( double r )
    {
        super( "Circulo" );
        radio = r;
    }
    
    /* (non-Javadoc)
     * @see org.mp.bloque2.ejercicios.Figura#area()
     */
    public double area( )
    {
        return PI * radio * radio;
    }

    /** The Constant PI. */
    private static final double PI = 3.14159265358979323;
    
    /** The radio. */
    private double radio;
}
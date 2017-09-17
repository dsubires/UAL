package org.mp.sesion02;
import java.io.*;
import java.util.Arrays;

// TODO: Auto-generated Javadoc
/**
 * The Class PruebaFigura.
 */
class PruebaFigura
{
    
    /** The in. */
    private static BufferedReader in;

    /**
     * Ordenacion por insercion.
     *
     * @param a the a
     */
    public static void ordenacionPorInsercion( Figura [ ] a )
    {
       /* for( int p = 1; p < a.length; p++ )
        {
            int j = p;
            Figura tmp = a[ p ];

            for( ; j > 0 && tmp.menorQue( a[ j - 1 ] ); j-- )
                a[ j ] = a[ j - 1 ];
            a[ j ] = tmp;
        }*/
    	Arrays.sort(a);
    }

    /**
     * Leer figura.
     *
     * @return the figura
     */
    private static Figura leerFigura( )
    {
        double rad;
        double largo;
        double ancho;
        String unaLinea;

        try
        {
            System.out.println( "Introduzca el tipo de figura:" );
            do
            {
                unaLinea = in.readLine( );
            } while( unaLinea.length( ) == 0 );
            
            switch( unaLinea.charAt( 0 ) )
            {
              case 'c':
                System.out.println( "Introduzca el radio: " );
                rad = Double.valueOf( in.readLine( ) ).doubleValue( );
                return new Circulo( rad );
              case 's':
                System.out.println( "Introduzca el lado: " );
                largo = Double.valueOf( in.readLine( ) ).doubleValue( );
                return new Cuadrado( largo );
              case 'r':
                System.out.println( "Introduzca el largo y el ancho "
                                  + "en líneas separadas: " );
                largo = Double.valueOf( in.readLine( ) ).doubleValue( );
                ancho = Double.valueOf( in.readLine( ) ).doubleValue( );
                return new Rectangulo( largo, ancho );
              default:
                System.err.println( "Escriba c, r, or s" );
                return new Circulo( 0 );
            }
        }
        catch( IOException e )
        {
            System.err.println( e );
            return new Circulo( 0 );
        }
    }


    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main( String [ ] args )
    {
        try
        {
                //  Lectura del número de figuras
            System.out.println( "Introduzca # de figuras: " );
            in = new BufferedReader( new InputStreamReader( System.in ) );
            int numFiguras = Integer.parseInt( in.readLine() );

                // Lectura de las figuras
            Figura [ ] array = new Figura[ numFiguras ];
            for( int i = 0; i < numFiguras; i++ )
                array[ i ] = leerFigura( );

                // Ordeanción y salida
            ordenacionPorInsercion( array );
            System.out.println( "Ordenados por area:" );
            for( int i = 0; i < numFiguras; i++ )
                System.out.println( array[ i ] );
        }
        catch( Exception e )
          { System.out.println( e ); }
    }
}


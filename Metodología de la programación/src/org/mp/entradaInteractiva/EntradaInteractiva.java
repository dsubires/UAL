package org.mp.entradaInteractiva;
import java.util.Scanner;
// TODO: Auto-generated Javadoc

/**
 * The Class EntradaInteractiva.
 */
public class EntradaInteractiva {

/** The lector. */
private static Scanner lector = new Scanner(System.in);

/**
 * Leer entero.
 *
 * @return the int
 */
public static int leerEntero(){
return lector.nextInt();
}

/**
 * Leer double.
 *
 * @return the double
 */
public static double leerDouble(){
return lector.nextDouble();
}

/**
 * Leer caracter.
 *
 * @return the double
 */
public static double leerCaracter(){
return lector.nextLine().charAt(0);
}

/**
 * Leer cadena.
 *
 * @return the string
 */
public static String leerCadena(){
return lector.nextLine();
}
}
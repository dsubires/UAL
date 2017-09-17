package org.mp.sesion01;
// TODO: Auto-generated Javadoc

/**
 * The Class StringEquals.
 */
public class StringEquals {
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        String s1 = "Hello World";
        String s2 = new String("Hello World");
 
        //
        // Comparar la igualdad de String utilizando el método equals.
        //
        if (s1.equals(s2)) {
            System.out.println("String es igual");
        }
        else {
            System.out.println("String no es igual");
        }
 
        //
        // No utilice el operador == para comparar por su contenido
        //
        if (s1 == s2) {
            System.out.println("String es igual");
        }
        else {
            System.out.println("String no es igual");
        }
    }
}
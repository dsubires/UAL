package org.ip.entradaInteractiva;
import java.util.Scanner;
public class EntradaInteractiva {
private static Scanner lector = new Scanner(System.in);
public static int leerEntero(){
return lector.nextInt();
}
public static double leerDouble(){
return lector.nextDouble();
}
public static double leerCaracter(){
return lector.nextLine().charAt(0);
}
public static String leerCadena(){
return lector.nextLine();
}
}
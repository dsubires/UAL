package org.ip.sesion03;
import org.ip.entradaInteractiva.EntradaInteractiva;
public class A2Contrato {
	public static void main(String[] args) {
int edad,prueba1,prueba2;

System.out.println("Programa Contrato");
System.out.println("Para saber si está contratado tiene que ingresar sus datos..");
System.out.print("Introduzca su edad:");
edad = EntradaInteractiva.leerEntero();
System.out.println("Introduzca la calificación obtenida en las dos pruebas:");
prueba1 = EntradaInteractiva.leerEntero();
prueba2 = EntradaInteractiva.leerEntero();

if(edad>=18 && prueba1>85 || prueba2>85){
	System.out.println("Contratado");
}else{
	System.out.println("INEM: TFN 666555444");
}

	}

}

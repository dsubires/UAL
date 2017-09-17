package org.ip.sesion03;
import org.ip.entradaInteractiva.*;
public class A1TarifaTaxi {
	public static void main(String[] args) {
int tiempo,tarifa;
System.out.println("Programa tarifa taxi");
System.out.print("Introduce el tiempo de la carrera: ");
tiempo = EntradaInteractiva.leerEntero();
tarifa= (40+(tiempo-30)*2);
if(tiempo <= 30){
	System.out.println("El importe de la tarifa es: 40€");
}else{
	System.out.println("El importe de la tarifa es: "+tarifa+"€");
}

	}

}

package org.ip.sesion03;
import org.ip.entradaInteractiva.EntradaInteractiva;
public class A4 {
	public static void main(String[] args) {
int codigo;
System.out.println("Calcular si un c�digo de producto es o no defectuoso:");
System.out.println("Introduce un n�mero entero para formar el c�digo del producto:");
System.out.print("C�digo:");
codigo = EntradaInteractiva.leerEntero();

if(codigo>=14500 && codigo<=15000){
System.out.println("El c�digo introducido es un producto defectuoso. Est� entre el rango 14500 - 15000");
}
else if (codigo>=33300 && codigo<=45000) {
System.out.println("El c�digo introducido es un producto defectuoso. Est� entre el rango 33300 - 45000");
}else { 
System.out.println("El c�digo introducido NO es un producto defectuoso.");
}
}
}
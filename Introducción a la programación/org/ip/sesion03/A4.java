package org.ip.sesion03;
import org.ip.entradaInteractiva.EntradaInteractiva;
public class A4 {
	public static void main(String[] args) {
int codigo;
System.out.println("Calcular si un código de producto es o no defectuoso:");
System.out.println("Introduce un número entero para formar el código del producto:");
System.out.print("Código:");
codigo = EntradaInteractiva.leerEntero();

if(codigo>=14500 && codigo<=15000){
System.out.println("El código introducido es un producto defectuoso. Está entre el rango 14500 - 15000");
}
else if (codigo>=33300 && codigo<=45000) {
System.out.println("El código introducido es un producto defectuoso. Está entre el rango 33300 - 45000");
}else { 
System.out.println("El código introducido NO es un producto defectuoso.");
}
}
}
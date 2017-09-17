package org.ip.sesion05;
import org.ip.entradaInteractiva.EntradaInteractiva;
public class CalculoIntereses {
	public static void main(String[] args) {

double inversion,interesInversion,aCobrar,meses,interesAnual,retencion;


System.out.println("Programa CalculoIntereses del banco UALb");
System.out.print("Introduce la cantidad a ingresar: ");
inversion = EntradaInteractiva.leerDouble();
System.out.print("Introduce el interes anual: ");
interesAnual = EntradaInteractiva.leerDouble();
System.out.print("Introduce el plazo en el que desea mantener la inversion(meses) : ");
meses = EntradaInteractiva.leerDouble();

interesInversion = cantidadGenerada(inversion,interesAnual,meses);
retencion = retencion(interesInversion);
aCobrar = totalAcobrar(interesInversion,retencion);

System.out.println("Dinero a invertir: "+inversion+"€");
System.out.println("El interes anual es: "+interesAnual+"%");
System.out.println("La cantidad en intereses generada a los "+meses+" meses de inversion ha sido de: "+interesInversion+"€");
System.out.println("La retencion aplicada es de "+retencion+"€");
System.out.println("Total a cobrar: "+aCobrar+"€");
	}

	private static double cantidadGenerada(double num, double interes, double plazo){
		num = (num*(interes/12/100)*plazo);
		return num;
		}
	private static double retencion(double num){
	num = num*18/100;
	return num;
	}
	private static double totalAcobrar(double num,double retencion){
		num = num - retencion;
		return num;
	}
}

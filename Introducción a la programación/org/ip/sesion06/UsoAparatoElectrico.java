package org.ip.sesion06;

public class UsoAparatoElectrico {

	public static void main(String[] args) {
		//CREO MIS OBJETOS
		AparatoElectrico bombilla, radiador, plancha;
		
		bombilla = new AparatoElectrico(100);
		radiador = new AparatoElectrico(2000);
		plancha  = new AparatoElectrico(1200);
		System.out.println("Consumo de aparatos: bombilla=100w, radiador=2000w, plancha=1200w.");
		System.out.println("Consumo total al inicio: "+AparatoElectrico.consumo()+" watios");
		
		plancha.enciende();
		bombilla.enciende();
		
		System.out.println("El consumo con la plancha y la bombilla es de: "+AparatoElectrico.consumo()+" watios");
		
		plancha.apaga();
		radiador.enciende();
		
		
		System.out.println("El consumo con el radiador y la bombilla es de: "+AparatoElectrico.consumo()+" watios");
		
		
		
		
		

	}

}

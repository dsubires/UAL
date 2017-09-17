package org.ip.actividad02;

public class UsoRectangulo {
	public static void main(String[] args) {
		//  Creo varios rectangulos para probar todos los constructores y el método clone()
		Rectangulo rect1 = new Rectangulo(0, 0, 100, 200);
		Rectangulo rect2 = new Rectangulo(10, 10, 400, 600);
		Rectangulo rect3 = rect1.clone();
		Rectangulo rect4 = new Rectangulo(50,50);

		System.out.println("******Antes de desplazar rect1******");
		System.out.println(rect1.toString());
		System.out.println(rect2.toString());
		System.out.println(rect3.toString());
		System.out.println(rect4.toString());	
		rect1.desplazar(20, 20);
		
		System.out.println("******Después de desplazar rect1******");
		System.out.println(rect1.toString());
		System.out.println(rect2.toString());
		System.out.println(rect3.toString());
		System.out.println(rect4.toString());
				
		System.out.println("******Antes de redimensionar rect3******");
		System.out.println(rect1.toString());
		System.out.println(rect2.toString());
		System.out.println(rect3.toString());
		System.out.println(rect4.toString());
				
		rect3.redimensionar(250, 100);
		
		System.out.println("******Después de redimensionar rect3******");
		System.out.println(rect1.toString());
		System.out.println(rect2.toString());
		System.out.println(rect3.toString());
		System.out.println(rect4.toString());
				
		System.out.println("******Area de rect3******");
		System.out.println(rect3.calcularArea());
		
		System.out.println("******Perimetro rect1******");
		System.out.println(rect1.calcularPerimetro());

		System.out.println("******Longitud rect2******");
		System.out.println(rect2.getLongitud());
		System.out.println("******Altura rect2******");
		System.out.println(rect2.getAltura());
		System.out.println("******Origen x rect2******");
		System.out.println(rect2.getOrigenX());
		System.out.println("******Origen y rect2******");
		System.out.println(rect2.getOrigenY());

		
	}
}
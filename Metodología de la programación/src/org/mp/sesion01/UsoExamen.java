package org.mp.sesion01;

// TODO: Auto-generated Javadoc
/**
 * The Class UsoExamen.
 */
public class UsoExamen {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		Examen prueba = new Examen("Metodología","Aula 8 Aulario II", new Fecha(8,5,2013), new Hora(10,10));
		System.out.println(prueba);
		
		prueba.setFecha(1, 2, 2014);
		prueba.setHora(12, 12);
		
		System.out.println(prueba);
		
		

	}

}

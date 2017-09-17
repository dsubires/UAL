package org.mp.sesion01;

// TODO: Auto-generated Javadoc
/**
 * The Class UsoInstalacionElectrica.
 */
public class UsoInstalacionElectrica {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		AparatoElectrico[] myArray = {new AparatoElectrico("bombilla",100),new AparatoElectrico("radiador",2000),new AparatoElectrico("plancha",1200)};
		InstalacionElectrica myInstalacion = new InstalacionElectrica(myArray);
		System.out.println("Al inicio--------------------> "+myInstalacion.getConsumoInstalacion());
		myInstalacion.getAparato(0).clic();
		myInstalacion.getAparato(2).clic();
		System.out.println("Con bombilla y plancha ON----> "+myInstalacion.getConsumoInstalacion());
		myInstalacion.getAparato(2).clic();
		myInstalacion.getAparato(1).clic();
		System.out.println("Con bombilla y radiador ON---> "+myInstalacion.getConsumoInstalacion());
		System.out.println(myInstalacion);
		
		
				 
				
	}

}

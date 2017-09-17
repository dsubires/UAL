package org.mp.sesion01;

// TODO: Auto-generated Javadoc
/**
 * The Class UsoMultimedia.
 */
public class UsoMultimedia {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		try{

		Pelicula peli = new Pelicula("Santiago Segura","Torrente", "dvd", 78, "Subires",null);
		
		System.out.println(peli);
	
		}catch(Exception e){
			System.out.println(e.getMessage()); 
		}
	}

}

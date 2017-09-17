package org.mp.sesion01;

// TODO: Auto-generated Javadoc
/**
 * The Class ListaMultimedia.
 */
public class ListaMultimedia {
	
	/** The elementos. */
	private Multimedia [] elementos;
	
	/** The contador objetos. */
	private int contadorObjetos = 0;
	
	/**
	 * Instantiates a new lista multimedia.
	 *
	 * @param max the max
	 */
	public ListaMultimedia(int max){
		elementos = new Multimedia [max];
	}
	
	/**
	 * Size.
	 *
	 * @return the int
	 */
	public int size(){
		return elementos.length;
	}
	
	/**
	 * Gets the ndiscos.
	 *
	 * @return the ndiscos
	 */
	public int getNdiscos(){
		return contadorObjetos;
	}
	
	/**
	 * Adds the.
	 *
	 * @param m the m
	 * @return true, if successful
	 */
	public boolean add(Multimedia m){
		for(int i=0; i < elementos.length; i++){
			if(elementos[i] == null){
				elementos[i]=m;
				contadorObjetos++;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Gets the.
	 *
	 * @param posicion the posicion
	 * @return the multimedia
	 */
	public Multimedia get(int posicion){
		return elementos[posicion];
	}
	
	/**
	 * Index of.
	 *
	 * @param m the m
	 * @return the int
	 */
	public int indexOf(Multimedia m){
		for(int i=0; i < elementos.length; i++){
			if(elementos[i].equals(m)){
				return i;
			}
		}
		return -1;
		
	}
	
	/**
	 * Gets the length.
	 *
	 * @return the length
	 */
	public int getLength(){
		return elementos.length;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String aux = "Lista Multimedia: \n\n";
		
		for(int i=0; i<elementos.length; i++){
			if(elementos[i] != null){
				aux += "****Película "+(i+1)+" de "+(elementos.length)+"*****\n";
				aux += elementos[i]+"\n\n";
			}
		}
		return aux;

	}


}

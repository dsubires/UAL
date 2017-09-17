package org.mp.sesion01;

// TODO: Auto-generated Javadoc
/**
 * The Class InstalacionElectrica.
 */
public class InstalacionElectrica {

	/** The instalacion. */
	private AparatoElectrico[] instalacion;

	/**
	 * Instantiates a new instalacion electrica.
	 *
	 * @param dim the dim
	 */
	public InstalacionElectrica(int dim) {
		instalacion = new AparatoElectrico[dim];			
	}
	
	/**
	 * Instantiates a new instalacion electrica.
	 *
	 * @param array the array
	 */
	public InstalacionElectrica(AparatoElectrico[] array) {
		instalacion = new AparatoElectrico[array.length];
		for(int i=0; i<instalacion.length; i++){
			instalacion[i] = new AparatoElectrico(array[i].getNombreAparato(),array[i].getPotenciaAparato());
		}
					
	}
	
	/**
	 * Gets the aparato.
	 *
	 * @param posicion the posicion
	 * @return the aparato
	 */
	public AparatoElectrico getAparato(int posicion){
		return this.instalacion[posicion];
	}
	
/*	public void clicAparato(int posicion){
				instalacion[posicion].clic();
	}*/
		
	/**
 * Gets the consumo instalacion.
 *
 * @return the consumo instalacion
 */
public String getConsumoInstalacion(){
		int consumo=0;
		for(int i=0; i<instalacion.length;i++){
			consumo+=instalacion[i].getConsumoAparato();
		}	
		return "Consumo total de la instalación: "+consumo+"";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String aux = "Instalación: \n";
		
		for(int i=0; i<instalacion.length; i++){
			aux += instalacion[i]+"\n"; 	
		}
		
		return aux;

	}
}
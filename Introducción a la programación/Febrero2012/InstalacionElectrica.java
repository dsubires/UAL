package Febrero2012;

public class InstalacionElectrica {

	private AparatoElectrico[] aparatos;

	public InstalacionElectrica(int dim) {
		aparatos = new AparatoElectrico[dim];
		
		for(int i=0; i<aparatos.length;i++){
			aparatos[i] = new AparatoElectrico((Math.random()*(10000 - 1000+1)+1000));
		}

	}

	public String toString() {
		String aux = "";
		
		for(int i=0; i<aparatos.length; i++){
			String estado = (aparatos[i].getStatus())? "(encendido)" : "(apagado)";
			aux += "Aparato "+i+":  "+Math.floor(aparatos[i].getPotencia()/100)*100+" "+estado+"\n";	
		}
		
		return aux;

	}
}
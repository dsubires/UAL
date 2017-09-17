package Febrero2012;

public class AparatoElectrico {
	private double potencia;
	private boolean encendido;
	private static double consumoTotal = 0;

	public AparatoElectrico(double potencia) {
		this.potencia = potencia;
		encendido = false;
	}

	public double getPotencia(){		
		return this.potencia;
	}
	
	public boolean getStatus(){
		return this.encendido;
	}
}
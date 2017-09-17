package org.ip.sesion06;

public class AparatoElectrico {
	// atributos de clase
	private int potencia;
	private boolean encendido;

	private static int consumoTotal;

	// constructor
	public AparatoElectrico(int potenciaAparato) {
		potencia = potenciaAparato;
		encendido = false;
	}

	// metodos de acceso
	public void enciende() {
		if (!this.encendido) {
			consumoTotal += this.potencia;
			this.encendido = true;
		}
	}

	public void apaga() {
		if (this.encendido) {
			consumoTotal -= this.potencia;
			this.encendido = false;
		}
	}

	public static int consumo() {
		return consumoTotal;
	}

}

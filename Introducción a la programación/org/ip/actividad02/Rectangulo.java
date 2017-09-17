package org.ip.actividad02;
public class Rectangulo {
	// Atributos
	private int origenX; // coordenada x del punto de origen
	private int origenY; // coordenada y del punto de origen
	private int ancho;
	private int alto;

	// Constructores
	public Rectangulo(int origenX, int origenY, int ancho, int alto) {
		this.origenX = origenX;
		this.origenY = origenY;
		this.ancho = ancho;
		this.alto = alto;
	}

	public Rectangulo(int ancho, int alto) {
		this.origenX = 0;
		this.origenY = 0;
		this.ancho = ancho;
		this.alto = alto;
	}

	public Rectangulo() {
		this.origenX = 0;
		this.origenY = 0;
		this.ancho = 0;
		this.alto = 0;
	}

	// m�todos
	public void desplazar(int dX, int dY) {
		origenX += dX;
		origenY += dY;
	}

	public void redimensionar(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;
	}

	public int calcularArea() {
		return alto * ancho;
	}

	public int calcularPerimetro() {
		return 2 * alto + 2 * ancho;
	}

	// m�todo toString()
	public String toString() {

		return new String("Rect�ngulo de dimensi�n " + alto + "x" + ancho
				+ " con origen en (" + origenX + "," + origenY + ")");
	}
	
	// m�todo clone()
	public Rectangulo clone(){
		return new Rectangulo(this.origenX, this.origenY, this.ancho, this.alto);
	}

	// m�todos de acceso. S�lo especificaremos los get()
	public int getLongitud() {
		return ancho;
	}

	public int getAltura() {
		return alto;
	}

	public int getOrigenX() {
		return origenX;
	}

	public int getOrigenY() {
		return origenY;
	}
}
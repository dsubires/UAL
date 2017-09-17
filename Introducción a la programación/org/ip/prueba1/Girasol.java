package org.ip.prueba1;

public class Girasol {

	private Coordenadas posicion;
	private int contadorLuz;
	private static boolean modo; // true activo y false descanso
	
	//	Constructor
	public Girasol(Coordenadas posicion) {
		this.posicion = posicion;
		this.contadorLuz = (int) (Math.random() * 5);
	}

	// Get y Set
	public void setPosicion(Coordenadas posicion) {
		this.posicion = posicion;
	}
	
	public void setPosicionX(int x){
		this.posicion.setX(x);
	}

	public String getPosicion() {
		return this.posicion.getCoordenadas();
	}
	
	public int getPosicionX(){
		return this.posicion.getX();
	}
	
	public int getPosicionY(){
		return this.posicion.getY();
	}

	public int getContLuz() {
		return this.contadorLuz;
	}

	public void setContLuz() {
		this.contadorLuz += 1 ;
	}

	public static void setModo(boolean valor) {
		modo = valor;
	}

	public static boolean getModo() {
		return modo;
	}
	
	public boolean validarContador() {
		 return (contadorLuz < 20) ?  true :  false ;
	}

	// método giro simulamos que se pone mirando al sol asignando la misma
	// coordenada que el
	// sol

	public void giro(int x) {
		
		if (validarContador() == true){
			this.posicion.setX(x);
			this.contadorLuz++;
		}
		
	}

}

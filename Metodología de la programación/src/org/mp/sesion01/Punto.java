package org.mp.sesion01;

// TODO: Auto-generated Javadoc
/**
 * The Class Punto.
 */
public class Punto {
	// atributos
	/** The x. */
	private int x;
	
	/** The y. */
	private int y;

	// constructores
	/**
	 * Instantiates a new punto.
	 *
	 * @param iniX the ini x
	 * @param iniY the ini y
	 */
	Punto(int iniX, int iniY) {
		this.x = iniX;
		this.y = iniY;
	}

	/**
	 * Instantiates a new punto.
	 */
	Punto() {
		this.x = 0;
		this.y = 0;
	}

	// métodos
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY() {
		return this.y;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "[" + this.x + "," + this.y + "]";
	}

	/**
	 * Distancia.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the punto
	 */
	public Punto distancia(int x,int y) {
		int distX = 0;
		int distY = 0;
		
		if(this.x>x){
			distX = this.x - x;
		}else{
			distX = x - this.x;
		}
		
		if(this.y>y){
			distY = this.y - y;
		}else{
			distY = y - this.y;
		}
		
		return new Punto(distX,distY);
	}
	
	/**
	 * Distancia.
	 *
	 * @param punto the punto
	 * @return the punto
	 */
	public Punto distancia(Punto punto) {
		int distX = 0;
		int distY = 0;
		
		if(this.x>punto.x){
			distX = this.x - punto.x;
		}else{
			distX = punto.x - this.x;
		}
		
		if(this.y>punto.y){
			distY = this.y - punto.y;
		}else{
			distY = punto.y - this.y;
		}
		
		return new Punto(distX,distY);
	}
	
	/**
	 * Distancia.
	 *
	 * @return the punto
	 */
	public Punto distancia(){
		return new Punto(Math.abs(this.x),Math.abs(this.y));
	}
	

	// UsoPunto
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		Punto punto1 = new Punto();
		Punto punto2 = new Punto(5, 3);
		Punto punto3 = new Punto(2, -1);
		Punto punto4 = new Punto(((punto2.getX() + punto3.getX()) / 2),
				((punto2.getY() + punto3.getY()) / 2));
		System.out.println(punto1);
		System.out.println(punto4);
		System.out.println(punto2.distancia(punto3));
		System.out.println(punto3.distancia());

	}

}
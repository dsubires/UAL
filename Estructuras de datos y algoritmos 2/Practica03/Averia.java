package Practica03;

public class Averia implements Comparable {

	private int numInter;
	private double porcentaje;
	private Ubicacion ubica;
	
	public Averia (int numInter, double porcentaje) {
		this.numInter = numInter;
		this.porcentaje = porcentaje;
	}

	public Averia (int numInter, double porcentaje, String nombreUbicacion) {
		this.numInter = numInter;
		this.porcentaje = porcentaje;
		this.ubica = new Ubicacion (nombreUbicacion);
	}

	public int getNumInter() {
		return numInter;
	}

	public void setNumInter(int numInter) {
		this.numInter = numInter;
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	public double calcularDistancia (Averia averia) {
		return ubica.calcularDistancia(averia.ubica);
	}

	public Ubicacion getUbica() {
		return ubica;
	}

	public void setUbica(Ubicacion ubica) {
		this.ubica = ubica;
	}
	
	public String toString () {
		return numInter+" "+porcentaje+" "+ubica.getNombre();
//		return numInter+"";
	}

	@Override
	public int compareTo(Object obj) {
		Averia a = (Averia) obj;
		if (this.porcentaje < a.porcentaje)
			return -1;
		if (this.porcentaje > a.porcentaje)
			return 1;
		if (this.numInter < a.numInter)
			return -1;
		if (this.numInter > a.numInter)
			return 1;
		return 0;
	}
	
	public boolean equals(Object obj){
		Averia av = (Averia) obj;
		return this.numInter == av.numInter && this.porcentaje == av.porcentaje;
	}
}

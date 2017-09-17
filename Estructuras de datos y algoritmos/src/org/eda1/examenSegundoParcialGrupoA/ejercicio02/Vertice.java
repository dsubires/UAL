package org.eda1.examenSegundoParcialGrupoA.ejercicio02;

public class Vertice implements Comparable {
	private String pueblo; // nombre pueblo
	private double poblacion; // poblacion pueblo

	public Vertice() { 
		pueblo = "";
		poblacion = 0.0;
	}

	public Vertice(String pue, double pob) { 
		pueblo = pue;
		poblacion = pob;
	}

	public void setPueblo(String pue) {
		pueblo = pue;
	}

	public String getPueblo() {
		return pueblo;
	}

	public double getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(double pob) {
		poblacion = pob;
	}

	public int compareTo(Object obj) {
		Vertice v = (Vertice) obj;
		return Double.compare(poblacion, v.poblacion);
	}

	public boolean equals(Object obj) {
		Vertice v = (Vertice) obj;
		if(pueblo.equals(v.pueblo) && poblacion == v.poblacion)
			return true;
		return false;
	}

	public String toString() {
		return "[" + pueblo + ", " + poblacion + "]";
	}
}
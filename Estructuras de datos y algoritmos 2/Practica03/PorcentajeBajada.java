package Practica03;

public class PorcentajeBajada implements Comparable {

	private int izq;
	private int der;
	private double porc;
	
	public PorcentajeBajada(int izq, int der, double porc) {
		this.izq = izq;
		this.der = der;
		this.porc = porc;
	}

	public int getIzq() {
		return izq;
	}

	public int getDer() {
		return der;
	}

	public double getPorc() {
		return porc;
	}

	@Override
	public int compareTo(Object arg0) {
		PorcentajeBajada p = (PorcentajeBajada) arg0;
		if (this.porc < p.porc)
			return +1;
		if (this.porc > p.porc)
			return -1;
		return 0;
	}
	
	
}

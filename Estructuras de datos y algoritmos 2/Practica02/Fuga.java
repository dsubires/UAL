package Practica2;

public class Fuga implements Comparable {

	private double porcentaje;
	int posI, posF;

	public Fuga(double inicio, int posI, double fin, int posF) {
		porcentaje = (inicio / 100) *(inicio- fin);
		this.posI = posI;
		this.posF = posF;
	}

	public Fuga(double inicio, double fin) {
		porcentaje = (inicio / 100) *(inicio- fin);

	}

	public int getPosI() {
		return posI;
	}

	public void setPosI(int posI) {
		this.posI = posI;
	}

	public int getPosF() {
		return posF;
	}

	public void setPosF(int posF) {
		this.posF = posF;
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public int compareTo(Object x) {
		if (x instanceof Fuga) {
			Fuga fuga = (Fuga) x;
			if (porcentaje < fuga.getPorcentaje())
				return 1;

			if (porcentaje > fuga.getPorcentaje())
				return -1;

			return 0;
		}

		return 0;
	}
	public String toString(){
		
		return "["+posI+"]-["+posF+"]";
	}

	public int compareTo(Fuga fuga) {

		if (porcentaje < fuga.getPorcentaje())
			return 1;

		if (porcentaje > fuga.getPorcentaje())
			return -1;

		return 0;

	}
}

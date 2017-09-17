package org.mp.examentipoa2013;

public class Termino {
	private double coef;
	private int exp;

	public Termino(double coef, int exp) {
		//if (coef == 0.0 || exp < 0) {
		if ( exp < 0) {
			throw new IllegalArgumentException();
		}
		this.coef = coef;
		this.exp = exp;
	}

	public Termino(Termino that) { // copy constructor
		this(that.coef, that.exp);
	}

	public double getCoef() {
		return coef;
	}

	public int getExp() {
		return exp;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Termino other = (Termino) obj;
		if (Double.doubleToLongBits(coef) != Double
				.doubleToLongBits(other.coef))
			return false;
		if (exp != other.exp)
			return false;
		return true;
	}
	
	
}


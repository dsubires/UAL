package org.mp.sesion01;

// TODO: Auto-generated Javadoc
/**
 * The Class MatrizReales.
 */
public class MatrizReales {

	/** The matriz. */
	private double[][] matriz;

	// Constructores
	/**
	 * Instantiates a new matriz reales.
	 *
	 * @param dim1 the dim1
	 * @param dim2 the dim2
	 */
	public MatrizReales(int dim1, int dim2) {
		this.matriz = new double[dim1][dim2];
		for (int i = 0; i < this.matriz.length; i++) {
			for (int j = 0; j < this.matriz[0].length; j++) {
				this.matriz[i][j] = (int) (Math.random() * 100);
			}
		}
	}

	/**
	 * Instantiates a new matriz reales.
	 *
	 * @param matrizAux the matriz aux
	 */
	public MatrizReales(double[][] matrizAux) {
		this.matriz = new double[matrizAux.length][matrizAux[0].length];
		for (int i = 0; i < matrizAux.length; i++) {
			for (int j = 0; j < matrizAux[0].length; j++) {
				this.matriz[i][j] = matrizAux[i][j];
			}
		}
	}

	// metodos de acceso

	/**
	 * Sumar.
	 *
	 * @param matriz2 the matriz2
	 * @return the matriz reales
	 */
	public MatrizReales sumar(MatrizReales matriz2) {
		double[][] aux = null;
		if (this.matriz.length + this.matriz[0].length != matriz2.matriz.length
				+ matriz2.matriz[0].length) {
			aux = new double[0][0];
			return null;
		} else {
			aux = new double[this.matriz.length][this.matriz[0].length];
			for (int i = 0; i < this.matriz.length; i++) {
				for (int j = 0; j < this.matriz[0].length; j++) {
					aux[i][j] = this.matriz[i][j] + matriz2.matriz[i][j];
				}
			}
			return new MatrizReales(aux);
		}
	}

	/**
	 * Restar.
	 *
	 * @param matriz2 the matriz2
	 * @return the matriz reales
	 */
	public MatrizReales restar(MatrizReales matriz2) {
		double[][] aux = null;
		if (this.matriz.length + this.matriz[0].length != matriz2.matriz.length
				+ matriz2.matriz[0].length) {
			aux = new double[0][0];
			return null;
		} else {
			aux = new double[this.matriz.length][this.matriz[0].length];
			for (int i = 0; i < this.matriz.length; i++) {
				for (int j = 0; j < this.matriz[0].length; j++) {
					aux[i][j] = this.matriz[i][j] - matriz2.matriz[i][j];
				}
			}
			return new MatrizReales(aux);
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public MatrizReales clone() {
		MatrizReales aux = new MatrizReales(this.matriz.length,
				this.matriz[0].length);
		for (int i = 0; i < this.matriz.length; i++) {
			for (int j = 0; j < this.matriz[0].length; j++) {
				aux.matriz[i][j] = this.matriz[i][j];
			}
		}
		return aux;
	}

	/**
	 * Equals.
	 *
	 * @param matriz2 the matriz2
	 * @return true, if successful
	 */
	public boolean equals(MatrizReales matriz2) {
		MatrizReales aux = (MatrizReales) matriz2;
		if (aux == null
				|| this.matriz.length + this.matriz[0].length != aux.matriz.length
						+ aux.matriz[0].length)
			return false;
		for (int i = 0; i < this.matriz.length; i++) {
			for (int j = 0; j < this.matriz[0].length; j++) {
				if (this.matriz[i][j] != aux.matriz[i][j])
					return false;
			}
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		if (this.matriz.length == 0 || this.matriz[0].length == 0) {
			return " 00 ";
		} else if(this.matriz.length >= 1000 && this.matriz[0].length >= 1000){
			return " *** demasiados elementos *** ";
		}else{
			String detalleMatriz = "";
			for (int i = 0; i < this.matriz.length; i++) {
				for (int j = 0; j < this.matriz[0].length; j++) {
					detalleMatriz += this.matriz[i][j] + "\t";
				}
				detalleMatriz += "\n";
			}
			return detalleMatriz;
		}
	}

}

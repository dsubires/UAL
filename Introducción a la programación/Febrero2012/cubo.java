package Febrero2012;

public class cubo {
	private int[][][] elementos;
	private int dimX;
	private int dimY;
	private int dimZ;

	public cubo(int dimX, int dimY, int dimZ) {
		this.dimX = dimX;
		this.dimY = dimY;
		this.dimZ = dimZ;
		this.elementos = new int[dimX][dimY][dimZ];

		for (int i = 0; i < elementos.length; i++) {
			for (int j = 0; j < elementos[0].length; j++) {
				for (int k = 0; k < elementos[0][0].length; k++) {
					elementos[i][j][k] = (int) (Math.random() * 101);
				}
			}
		}
	}

	public String ocurrencias(int prototipo) {
		String aux = "";
		int contador = 0;

		for (int i = 0; i < elementos.length; i++) {
			for (int j = 0; j < elementos[0].length; j++) {
				for (int k = 0; k < elementos[0][0].length; k++) {
					if (prototipo == elementos[i][j][k]) {
						contador++;
					}
				}
			}
		}
		aux = "Se repite " + contador + " veces el número " + prototipo;
		return aux;
	}

	public int sumar() {
		int suma = 0;
		for (int i = 0; i < elementos.length; i++) {
			for (int j = 0; j < elementos[0].length; j++) {
				for (int k = 0; k < elementos[0][0].length; k++) {
					suma += elementos[i][j][k];
				}
			}
		}

		return suma;
	}

	public String toString() {
		String aux = "";
		for (int i = 0; i < this.dimX; i++) {
			for (int j = 0; j < this.dimY; j++) {
				for (int k = 0; k < this.dimZ; k++) {
				aux += this.elementos[i][j][k] + "\t";
			}
			aux += "\n";
		}
		aux += "\n\n\n";
	}
		return aux;
	}

	/*
	 * public int ocurrencias (int valor){ … } public Cubo sumar(Cubo otra){ … }
	 * public String toString(){ … } … }
	 */

}
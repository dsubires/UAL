package tema02;

public class MultiplicarMatrices {

	
	public static void main(String[] args) {
		int [][]m1, m2, m3;
		String tamaño = "Tamaño";
		String bruta = "F.Bruta(ns)";
		String DyV = "DyV(ns)";
		String strassen = "Strassen(ns)";		
		System.out.printf("\n  %5s  %10s  %10s  %10s", tamaño, bruta, DyV, strassen);
		for (int n=64; n<=1024; n=n*2) {
			m1 = generar (n);
			m2 = generar (n);
			long tiempoAntes = System.currentTimeMillis();
			m3 = fuerzaBruta (m1, m2);
			long tiempoDespues = System.currentTimeMillis();
			long tiempoFB = tiempoDespues - tiempoAntes;
			tiempoAntes = System.currentTimeMillis();
			m3 = divideYVenceras (m1, m2);
			tiempoDespues = System.currentTimeMillis();
			long tiempoDV = tiempoDespues - tiempoAntes;
			tiempoAntes = System.currentTimeMillis();
			m3 = strassen (m1, m2);
			tiempoDespues = System.currentTimeMillis();
			long tiempoS = tiempoDespues - tiempoAntes;
			System.out.printf("\n  %5d  %10d  %10d  %10d", n, tiempoFB, 
					tiempoDV, tiempoS);
		}
	}

	private static int[][] generar(int n) {
		int [][]m = new int [n][n];
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				m[i][j] = (int) (Math.random() * 10);
			}
		}
		return m;
	}
	
	//algoritmo para multiplicar dos matrices de manera iterativa
	//por fuerza bruta
	//la matriz nueva en la posicion i, j tiene la multiplicacion
	//de toda la fila i de la primera matriz por toda la columna
	//j de la segunda matriz
	public static int[][] fuerzaBruta(int[][] m1, int[][] m2) {
		int [][]m = new int [m1.length][m1.length];
		
		for (int i=0; i<m.length; i++) {
			for (int j=0; j<m.length; j++) {
				int sum = 0;
				for (int k=0; k<m.length; k++)
					sum = sum + m1[i][k] * m2[k][j];
				m [i][j] = sum;
			}
		}
		return m;
	}

	public static int[][] divideYVenceras(int[][] m1, int[][] m2) {
		int [][]m = divideYVenceras (m1, m2, m1.length);
		return m;
	}

	private static int[][] divideYVenceras(int[][] a, int[][] b, 
			int tama) {
		if (tama == 2) {
			int [][]m = new int [tama][tama];
			m[0][0] = a[0][0]*b[0][0] + a[0][1]*b[1][0];
			m[0][1] = a[0][0]*b[0][1] + a[0][1]*b[1][1];
			m[1][0] = a[1][0]*b[0][0] + a[1][1]*b[1][0];
			m[1][1] = a[1][0]*b[0][1] + a[1][1]*b[1][1];
			return m;
		}
		int tamaNuevo = tama / 2;
		int [][] a11 = new int [tamaNuevo][tamaNuevo];
		int [][] b11 = new int [tamaNuevo][tamaNuevo];
		int [][] a12 = new int [tamaNuevo][tamaNuevo];
		int [][] b12 = new int [tamaNuevo][tamaNuevo];
		int [][] a21 = new int [tamaNuevo][tamaNuevo];
		int [][] b21 = new int [tamaNuevo][tamaNuevo];
		int [][] a22 = new int [tamaNuevo][tamaNuevo];
		int [][] b22 = new int [tamaNuevo][tamaNuevo];
		for (int i=0; i<tamaNuevo; i++) {
			for (int j=0; j<tamaNuevo; j++) {
				a11[i][j] = a[i][j];
				b11[i][j] = b[i][j];
				a12[i][j] = a[i][j+tamaNuevo];
				b12[i][j] = b[i][j+tamaNuevo];
				a21[i][j] = a[i+tamaNuevo][j];
				b21[i][j] = b[i+tamaNuevo][j];
				a22[i][j] = a[i+tamaNuevo][j+tamaNuevo];
				b22[i][j] = b[i+tamaNuevo][j+tamaNuevo];
			}
		}
		int [][]izq = divideYVenceras (a11, b11, tamaNuevo);
		int [][]der = divideYVenceras (a12, b21, tamaNuevo);
		int [][]c11 = sumar (izq, der);
		izq = divideYVenceras (a11, b12, tamaNuevo);
		der = divideYVenceras (a12, b22, tamaNuevo);
		int [][]c12 = sumar (izq, der);
		izq = divideYVenceras (a21, b11, tamaNuevo);
		der = divideYVenceras (a22, b21, tamaNuevo);
		int [][]c21 = sumar (izq, der);
		izq = divideYVenceras (a21, b12, tamaNuevo);
		der = divideYVenceras (a22, b22, tamaNuevo);
		int [][]c22 = sumar (izq, der);
		int [][]m = new int [tama][tama];
		for (int i=0; i<tamaNuevo; i++) {
			for (int j=0; j<tamaNuevo; j++) {
				m[i][j] = c11[i][j];
				m[i][j+tamaNuevo] = c12[i][j];
				m[i+tamaNuevo][j] = c21[i][j];
				m[i+tamaNuevo][j+tamaNuevo] = c22[i][j];
			}
		}
		return m;
	}

	private static int[][] sumar(int[][] a, int[][] b) {
		int [][]m = new int [a.length][a.length];
		for (int i=0; i<a.length; i++) {
			for (int j=0; j<a.length; j++) {
				m[i][j] = a[i][j] + b[i][j];
			}
		}
		return m;
	}
	
	public static int[][] strassen(int[][] m1, int[][] m2) {
		int [][]m = strassen (m1, m2, m1.length);
		return m;
	}

	private static int[][] strassen(int[][] a, int[][] b, 
			int tama) {
		if (tama == 2) {
			int [][]m = new int [tama][tama];
			m[0][0] = a[0][0]*b[0][0] + a[0][1]*b[1][0];
			m[0][1] = a[0][0]*b[0][1] + a[0][1]*b[1][1];
			m[1][0] = a[1][0]*b[0][0] + a[1][1]*b[1][0];
			m[1][1] = a[1][0]*b[0][1] + a[1][1]*b[1][1];
			return m;
		}
		int tamaNuevo = tama / 2;
		int [][] a11 = new int [tamaNuevo][tamaNuevo];
		int [][] b11 = new int [tamaNuevo][tamaNuevo];
		int [][] a12 = new int [tamaNuevo][tamaNuevo];
		int [][] b12 = new int [tamaNuevo][tamaNuevo];
		int [][] a21 = new int [tamaNuevo][tamaNuevo];
		int [][] b21 = new int [tamaNuevo][tamaNuevo];
		int [][] a22 = new int [tamaNuevo][tamaNuevo];
		int [][] b22 = new int [tamaNuevo][tamaNuevo];
		for (int i=0; i<tamaNuevo; i++) {
			for (int j=0; j<tamaNuevo; j++) {
				a11[i][j] = a[i][j];
				b11[i][j] = b[i][j];
				a12[i][j] = a[i][j+tamaNuevo];
				b12[i][j] = b[i][j+tamaNuevo];
				a21[i][j] = a[i+tamaNuevo][j];
				b21[i][j] = b[i+tamaNuevo][j];
				a22[i][j] = a[i+tamaNuevo][j+tamaNuevo];
				b22[i][j] = b[i+tamaNuevo][j+tamaNuevo];
			}
		}
		int [][]m1 = strassen (restar(a12, a22), sumar(b21,b22), 
					tamaNuevo);
		int [][]m2 = strassen (sumar(a11,a22), sumar(b11,b22), 
					tamaNuevo);
		int [][]m3 = strassen (restar(a11, a21), sumar (b11, b21),
					tamaNuevo);
		int [][]m4 = strassen (sumar(a11, a12), b22, tamaNuevo);
		int [][]m5 = strassen (a11, restar(b12, b22), tamaNuevo);
		int [][]m6 = strassen (a22, restar(b21, b11), tamaNuevo);
		int [][]m7 = strassen (sumar(a21, a22), b11, tamaNuevo);
		int [][]c11 = sumar(restar(sumar (m1, m2), m4), m6);
		int [][]c12 = sumar (m4, m5);
		int [][]c21 = sumar (m6, m7);
		int [][]c22 = restar (sumar (restar(m2, m3), m5), m7);
		int [][]m = new int [tama][tama];
		for (int i=0; i<tamaNuevo; i++) {
			for (int j=0; j<tamaNuevo; j++) {
				m[i][j] = c11[i][j];
				m[i][j+tamaNuevo] = c12[i][j];
				m[i+tamaNuevo][j] = c21[i][j];
				m[i+tamaNuevo][j+tamaNuevo] = c22[i][j];
			}
		}
		return m;
	}
	
	private static int[][] restar(int[][] a, int[][] b) {
		int [][]m = new int [a.length][a.length];
		for (int i=0; i<a.length; i++) {
			for (int j=0; j<a.length; j++) {
				m[i][j] = a[i][j] - b[i][j];
			}
		}
		return m;
	}
}
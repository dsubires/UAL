package org.ip.sesion05;

public class Ecuacion2Grado {
	public static void main(String[] args) {
		String resultado;
		System.out.println("Programa Ecuacion de 2º Grado");
		resultado = resolverEcuacion(2, -5, 6);
		if (resultado == "") {
			System.out
					.print("La ecuacion x(cuadrado)-5x+6=0 no tiene resultados.");
		} else {
			System.out
					.print("Los posibles resultados de la ecuacion x(cuadrado)-5x+6=0 son: "
							+ resultado);
		}
	}

	private static String resolverEcuacion(double a, double b, double c) {
		double x1, x2;
		String x = "";
		if (b * b < 4 * a * c) {
			return x;
		} else {
			x1 = (-(b) + Math.sqrt(b * b - 4 * a * c)) / 2 * a;
			x2 = (-(b) - Math.sqrt(b * b - 4 * a * c)) / 2 * a;
			x = "(" + x1 + "," + x2 + ")";
			return x;
		}
	}

}

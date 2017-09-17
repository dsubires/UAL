package practica01;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GeneradorPruebas {

	public static void main(String[] args) {
		String directorio = System.getProperty("user.dir") + File.separator
				+ "src" + File.separator + "practica01" + File.separator;

		int numeroIntercambiadores = 30000;
		for (int i = 1; i <= 25; i++) {
			if (i == 25)
				numeroIntercambiadores = 80000;
			String nombreFichero = directorio + "datos" + i + ".txt";
			generarFichero(nombreFichero, numeroIntercambiadores);
			generarPeorCaso(directorio + "PeorCaso" + i + ".txt",
					numeroIntercambiadores);
			generarMejorCaso(directorio + "MejorCaso" + i + ".txt",
					numeroIntercambiadores);
			numeroIntercambiadores += 2080;
		}
		
	}

	public static void generarMejorCaso(String nombreFichero,
			int numeroIntercambiadores) {
		try {
			BufferedWriter bw = new BufferedWriter(
					new FileWriter(nombreFichero));
			bw.write(numeroIntercambiadores + "\n");
			double presion = 400;
			for (int i = 1; i <= numeroIntercambiadores * 2 + 2; i++) {
				bw.write(presion + "\n");
			}
			bw.close();
		} catch (Exception e) {

		}
	}

	public static void generarPeorCaso(String nombreFichero,
			int numeroIntercambiadores) {

		for (int j = 1; j <= 25; j++) {
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(
						nombreFichero));
				bw.write(numeroIntercambiadores + "\n");
				bw.write(400 + "\n");
				double presion = 400;
				for (int i = 1; i <= numeroIntercambiadores * 2 + 1; i++) {
					presion = presion - 0.002;
					bw.write(presion + "\n");
				}
				bw.close();

			} catch (Exception e) {

			}
		}
	}

	public static void generarFichero(String nombreFichero,
			int numeroIntercambiadores) {
		try {
			BufferedWriter bw = new BufferedWriter(
					new FileWriter(nombreFichero));
			bw.write(numeroIntercambiadores + "\n");
			bw.write(400 + "\n");
			double presion = 400;

			for (int i = 1; i <= numeroIntercambiadores * 2 + 1; i++) {

				if (Math.random() < 0.01) {
					double bajada = Math.random() * presion * 0.0175;
					if (presion - bajada > (400 / 27))
						presion = presion - bajada;
					bw.write(presion + "\n");
				} else {
					if (Math.random() < 0.001) {
						double subida = Math.random() * presion * 0.0175;
						if (Math.random() < 0.5)
							presion = subida + presion;

						bw.write(presion + "\n");

					} else {
						bw.write(presion + "\n");
					}
				}
			}
			bw.close();
		} catch (IOException e) {

		}
	}

}

package practica01;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Main {
	public static void main(String[] args) {
		String directorio = System.getProperty("user.dir") + File.separator
				+ "src" + File.separator + "practica01" + File.separator;
	//	String direct = "c:\\CarpetaTest\\";
		long tiempillo1;
		long tiempillo2;

		for (int j = 1; j <= 25; j++) {
			System.out.println(j);
			tiempillo1 = 0;
			tiempillo2 = 0;
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(
						System.getProperty("user.dir") + File.separator + "src"
								+ File.separator + "Resultados"
								+ File.separator + "Resultado" + j + ".txt"));

				for (int i = 1; i <= 10; i++) {
					bw.write("MEDICION " + i + ":\r\n");
					String nombreFichero = directorio + "datos" + j + ".txt";

					Comprobador comprobador = new Comprobador(nombreFichero);
					comprobador.comprobarErrores(); //
					// -------------DYV--------------------
					long tiempoAntes = System.nanoTime();
					comprobador.comprobarFugasDYV();
					long tiempoDespues = System.nanoTime();
					long tiempo = tiempoDespues - tiempoAntes;
					// ----------------------------------

					// ------------DYVM------------------
					comprobador = new Comprobador(nombreFichero);
					long tiempoAntesMejorado = System.nanoTime();
					comprobador.comprobarFugasDYVMejorado();
					long tiempoDespuesMejorado = System.nanoTime();
					long tiempoMejorado = tiempoDespuesMejorado
							- tiempoAntesMejorado;
					// -------------------------------------------------------------
					String t1 = "Tiempo (ns): " + tiempo + "\r\n";
					String t2 = "Tiempo (ns): " + tiempoMejorado + "\r\n";
					tiempillo1 = tiempillo1 + tiempo;
					tiempillo2 = tiempillo2 + tiempoMejorado;

					bw.write(t1 + "");
					bw.write(t2 + "\r\n");
					bw.write(" " + "\r\n");
					if (i == 10) {
						tiempillo1 = tiempillo1 / 10;
						tiempillo2 = tiempillo2 / 10;

						bw.write("Nº DE INTERCAMBIADORES: " + "\r\n");
						bw.write(comprobador.size() + " " + "\r\n" + "\r\n");
						bw.write("MANOMETROS DEFECTUOSOS: " + "\r\n");
						bw.write(comprobador.getListaDefectuosos() + "\r\n"
								+ "\r\n");
						bw.write("INTERCAMBIADORES CON FUGA: " + "\r\n");
						bw.write(comprobador.getListaIntercambiadoresConFuga()
								+ "\r\n" + "\r\n");
						bw.write("TRAMOS CON FUGA: " + "\r\n");
						bw.write(comprobador.getListaTramosConFuga() + "\r\n"
								+ "\r\n");
						bw.write("TIEMPO MEDIO:" + "\r\n");
						bw.write(tiempillo1 + "" + "\r\n" + "\r\n");
						bw.write("TIEMPO MEDIO MEJORADO:" + "\r\n");
						bw.write(tiempillo2 + "" + "\r\n" + "\r\n");

					}
				}
				bw.close();

			} catch (Exception e) {

			}

			System.out.println("Fichero nº: " + j + "\n");
		}

		// ---------------------------MEJOR CASO------------------------------
		for (int j = 1; j <= 25; j++) {
			tiempillo1 = 0;
			tiempillo2 = 0;
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(
						System.getProperty("user.dir") + File.separator + "src"
								+ File.separator + "Resultados"
								+ File.separator + "ResultadoMejorCaso"+j+".txt"));

				for (int i = 1; i <= 10; i++) {
					bw.write("MEDICION " + i + ":\r\n");
					String nombreFichero = directorio + "MejorCaso"+j+".txt";

					Comprobador comprobador = new Comprobador(nombreFichero);
					comprobador.comprobarErrores();
					// -------------DYV--------------------
					long tiempoAntes = System.nanoTime();
					comprobador.comprobarFugasDYV();
					long tiempoDespues = System.nanoTime();
					long tiempo = tiempoDespues - tiempoAntes; // ----------------------------------

					// ------------DYVM------------------
					comprobador = new Comprobador(nombreFichero);
					long tiempoAntesMejorado = System.nanoTime();
					comprobador.comprobarFugasDYVMejorado();
					long tiempoDespuesMejorado = System.nanoTime();
					long tiempoMejorado = tiempoDespuesMejorado
							- tiempoAntesMejorado;
					// -------------------------------------------------------------
					String t1 = "Tiempo (ns): " + tiempo + "\r\n";
					String t2 = "Tiempo (ns): " + tiempoMejorado + "\r\n";
					tiempillo1 = tiempillo1 + tiempo;
					tiempillo2 = tiempillo2 + tiempoMejorado;

					bw.write(t1 + "");
					bw.write(t2 + "\r\n");
					bw.write(" " + "\r\n");
					if (i == 10) {
						tiempillo1 = tiempillo1 / 10;
						tiempillo2 = tiempillo2 / 10;

						bw.write("Nº DE INTERCAMBIADORES: " + "\r\n");
						bw.write(comprobador.size() + " " + "\r\n" + "\r\n");
						bw.write("MANOMETROS DEFECTUOSOS: " + "\r\n");
						bw.write(comprobador.getListaDefectuosos() + "\r\n"
								+ "\r\n");
						bw.write("INTERCAMBIADORES CON FUGA: " + "\r\n");
						bw.write(comprobador.getListaIntercambiadoresConFuga()
								+ "\r\n" + "\r\n");
						bw.write("TRAMOS CON FUGA: " + "\r\n");
						bw.write(comprobador.getListaTramosConFuga() + "\r\n"
								+ "\r\n");
						bw.write("TIEMPO MEDIO:" + "\r\n");
						bw.write(tiempillo1 + "" + "\r\n" + "\r\n");
						bw.write("TIEMPO MEDIO MEJORADO:" + "\r\n");
						bw.write(tiempillo2 + "" + "\r\n" + "\r\n");

					}
				}
				bw.close();

			} catch (Exception e) {

			}
			System.out.println("Fichero mejor caso \n");

			// -----------------------------------PEOR  CASO---------------------------------------------
			tiempillo1 = 0;
			tiempillo2 = 0;
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(
						System.getProperty("user.dir") + File.separator + "src"
								+ File.separator + "Resultados"
								+ File.separator + "ResultadoPeor"+j+".txt"));

				for (int i = 1; i <= 10; i++) {
					bw.write("MEDICION " + i + ":\r\n");
					String nombreFichero = directorio + "PeorCaso"+j+".txt";

					Comprobador comprobador = new Comprobador(nombreFichero);
					comprobador.comprobarErrores();
					// -------------DYV--------------------
					long tiempoAntes = System.nanoTime();
					comprobador.comprobarFugasDYV();
					long tiempoDespues = System.nanoTime();

					long tiempo = tiempoDespues - tiempoAntes;
					// ----------------------------------
					comprobador = new Comprobador(nombreFichero);
					// ------------DYVM------------------
					long tiempoAntesMejorado = System.nanoTime();
					comprobador.comprobarFugasDYVMejorado();

					long tiempoDespuesMejorado = System.nanoTime();

					long tiempoMejorado = tiempoDespuesMejorado
							- tiempoAntesMejorado;
					// -------------------------------------------------------------
					String t1 = "Tiempo (ns): " + tiempo + "\r\n";
					String t2 = "Tiempo (ns): " + tiempoMejorado + "\r\n";
					tiempillo1 = tiempillo1 + tiempo;
					tiempillo2 = tiempillo2 + tiempoMejorado;

					bw.write(t1 + "");
					bw.write(t2 + "\r\n");
					bw.write(" " + "\r\n");
					if (i == 10) {
						tiempillo1 = tiempillo1 / 10;
						tiempillo2 = tiempillo2 / 10;

						bw.write("Nº DE INTERCAMBIADORES: " + "\r\n");
						bw.write(comprobador.size() + " " + "\r\n" + "\r\n");
						bw.write("MANOMETROS DEFECTUOSOS: " + "\r\n");
						bw.write(comprobador.getSizeDefectuosos() + "\r\n"
								+ "\r\n");

						bw.write("INTERCAMBIADORES CON FUGA: " + "\r\n");
						bw.write(comprobador.getSizeIntercambiadoresConFuga()
								+ "\r\n" + "\r\n");
						bw.write("TRAMOS CON FUGA: " + "\r\n");
						bw.write(comprobador.getSizeTramosConFuga() + "\r\n"
								+ "\r\n");
						bw.write("TIEMPO MEDIO:" + "\r\n");
						bw.write(tiempillo1 + "" + "\r\n" + "\r\n");
						bw.write("TIEMPO MEDIO MEJORADO:" + "\r\n");
						bw.write(tiempillo2 + "" + "\r\n" + "\r\n");

					}
				}
				bw.close();

			} catch (Exception e) {

			}
		}
		System.out.println("Fichero peor caso \n");

		System.out.println("FIN");
	}
}
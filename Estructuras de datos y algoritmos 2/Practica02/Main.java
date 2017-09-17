package Practica2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Main {
	public static void main(String[] args) {
		String directorio = System.getProperty("user.dir") + File.separator
				+ "src" + File.separator + "practica01" + File.separator;
		// String direct = "c:\\CarpetaTest\\";
		long tiempillo1;
		long tiempillo2;
		long tiempillo3;

		for (int j = 1; j <= 25; j++) {
		//	System.out.println(j);
			tiempillo1 = 0;
			tiempillo2 = 0;
			tiempillo3 = 0;
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(
						System.getProperty("user.dir") + File.separator + "src"
								+ File.separator + "ResultadosGreedy"
								+ File.separator + "ResultadoGreedy" + j
								+ ".txt"));
			

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

					// ----------------GREEDY----------------
					comprobador = new Comprobador(nombreFichero);
					long tiempoAntesGreedy = System.nanoTime();
					comprobador.comprobarFugasDYVMejorado();
					long tiempoDespuesGreedy = System.nanoTime();
					long tiempoGreedy = tiempoDespuesGreedy - tiempoAntesGreedy;
					// ----------------------------------------------

					String t1 = "Tiempo (ns): " + tiempo + "\r\n";
					String t2 = "Tiempo (ns): " + tiempoMejorado + "\r\n";
					String t3 = "Tiempo (ns): " + tiempoGreedy + "\r\n";
					tiempillo1 = tiempillo1 + tiempo;
					tiempillo2 = tiempillo2 + tiempoMejorado;
					tiempillo3 = tiempillo3 + tiempoGreedy;

					bw.write(t1 + "");
					bw.write(t2 + "");
					bw.write(t2 + "\r\n");
					bw.write(" " + "\r\n");
					if (i == 10) {
						tiempillo1 = tiempillo1 / 10;
						tiempillo2 = tiempillo2 / 10;
						tiempillo3 = tiempillo3 / 10;
						
						
						//System.out.println("escribo------------------------");

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
						bw.write("TIEMPO MEDIO DYV:" + "\r\n");
						bw.write(tiempillo1 + "" + "\r\n" + "\r\n");
						bw.write("TIEMPO MEDIO DYV MEJORADO:" + "\r\n");
						bw.write(tiempillo2 + "" + "\r\n" + "\r\n");
						bw.write("TIEMPO MEDIO GREEDY:" + "\r\n");
						bw.write(tiempillo3 + "" + "\r\n" + "\r\n");
					//	System.out.println("termino-----------------------");

					}
					System.out.println("Iteracion nº: " + i + "\n");
				}
				bw.close();

			} catch (Exception e) {
				System.out.println("FALLO------------------------------------");
				e.printStackTrace();

			}

			System.out.println("-------Fichero nº: " + j +" terminada-------"+ "\n");
		}

		// ---------------------------MEJOR CASO------------------------------
		for (int j = 1; j <= 25; j++) {
			tiempillo1 = 0;
			tiempillo2 = 0;
			tiempillo3 = 0;
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(
						System.getProperty("user.dir") + File.separator + "src"
								+ File.separator + "ResultadosGreedy"
								+ File.separator + "ResultadoGreedyMejorCaso"
								+ j + ".txt"));

				for (int i = 1; i <= 10; i++) {
					bw.write("MEDICION " + i + ":\r\n");
					String nombreFichero = directorio + "MejorCaso" + j
							+ ".txt";

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

					// ----------------GREEDY----------------
					comprobador = new Comprobador(nombreFichero);
					long tiempoAntesGreedy = System.nanoTime();
					comprobador.comprobarFugasDYVMejorado();
					long tiempoDespuesGreedy = System.nanoTime();
					long tiempoGreedy = tiempoDespuesGreedy - tiempoAntesGreedy;
					// ----------------------------------------------

					String t1 = "Tiempo (ns): " + tiempo + "\r\n";
					String t2 = "Tiempo (ns): " + tiempoMejorado + "\r\n";
					String t3 = "Tiempo (ns): " + tiempoGreedy + "\r\n";
					tiempillo1 = tiempillo1 + tiempo;
					tiempillo2 = tiempillo2 + tiempoMejorado;
					tiempillo3 = tiempillo3 + tiempoMejorado;

					bw.write(t1 + "");
					bw.write(t2 + "");
					bw.write(t3 + "\r\n");
					bw.write(" " + "\r\n");
					if (i == 10) {
						tiempillo1 = tiempillo1 / 10;
						tiempillo2 = tiempillo2 / 10;
						tiempillo3 = tiempillo3 / 10;

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
						bw.write("TIEMPO MEDIO GREEDY:" + "\r\n");
						bw.write(tiempillo3 + "" + "\r\n" + "\r\n");

					}
					System.out.println("Iteracion nº: " + i+"\n");
				}
				bw.close();

			} catch (Exception e) {

			}
			System.out.println("-------Fichero mejor caso nº: " + j +" terminada-------"+ "\n");

			// -----------------------------------PEOR
			// CASO---------------------------------------------
			tiempillo1 = 0;
			tiempillo2 = 0;
			tiempillo3 = 0;
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(
						System.getProperty("user.dir") + File.separator + "src"
								+ File.separator + "ResultadosGreedy"
								+ File.separator + "ResultadoGreedyPeorCaso"
								+ j + ".txt"));

				for (int i = 1; i <= 10; i++) {
					bw.write("MEDICION " + i + ":\r\n");
					String nombreFichero = directorio + "PeorCaso" + j + ".txt";

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

					// ----------------GREEDY----------------
					comprobador = new Comprobador(nombreFichero);
					long tiempoAntesGreedy = System.nanoTime();
					comprobador.comprobarFugasDYVMejorado();
					long tiempoDespuesGreedy = System.nanoTime();
					long tiempoGreedy = tiempoDespuesGreedy - tiempoAntesGreedy;
					// ----------------------------------------------

					String t1 = "Tiempo (ns): " + tiempo + "\r\n";
					String t2 = "Tiempo (ns): " + tiempoMejorado + "\r\n";
					String t3 = "Tiempo (ns): " + tiempoGreedy + "\r\n";
					tiempillo1 = tiempillo1 + tiempo;
					tiempillo2 = tiempillo2 + tiempoMejorado;
					tiempillo3 = tiempillo3 + tiempoGreedy;

					bw.write(t1 + "");
					bw.write(t2 + "");
					bw.write(t3 + "\r\n");
					bw.write(" " + "\r\n");
					if (i == 10) {
						tiempillo1 = tiempillo1 / 10;
						tiempillo2 = tiempillo2 / 10;
						tiempillo3 = tiempillo3 / 10;

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
						bw.write("TIEMPO MEDIO GREEDY:" + "\r\n");
						bw.write(tiempillo3 + "" + "\r\n" + "\r\n");

					}
					System.out.println("Iteracion nº: " +i+ "\n");
				}
				bw.close();

			} catch (Exception e) {

			}
			System.out.println("-------Fichero peor caso nº: " + j +" terminada-------"+ "\n");
		}
		

		System.out.println("FIN");
	}
}
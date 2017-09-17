package EjerciciosTema3.Ejercicio03;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {

		ArrayList<Long> tiempos = new ArrayList<Long>();
		ArrayList<Integer> tamanoProblema = new ArrayList<Integer>();
		for (int d = 1; d < 7; d++) {
			String outputFile = System.getProperty("user.dir");
			outputFile = outputFile + File.separator + "src" + File.separator
					+ "EjerciciosTema3" + File.separator + "Ejercicio03"
					+ File.separator + "Datos" + File.separator;

			outputFile += "afinidadParejas" + d + ".txt";
			AsignacionParejas ap = new AsignacionParejas(outputFile);
			long tiempoAntes = System.nanoTime();
//			int[] resultado = ap.generaAsignacionParejas();
			ap.generaAsignacionParejas();
			long tiempoDespues = System.nanoTime();
			tiempos.add(tiempoDespues - tiempoAntes);
			tamanoProblema.add(ap.getNumEmpleados());

			/*
			 * DESCOMENTAR PARA VER EQUIPOS DESIGNADOS 
			 * for (int i = 0; i < resultado.length; i++) { 
			 * System.out.println("Empleado " + i + " trabajará con empleado " + resultado[i]); 
			 * }
			 */

		}

		System.out.println("*********Tiempos:*********\n");
		System.out.println("Tamaño\t\tTiempo");
		Iterator<Long> iter1 = tiempos.iterator();
		Iterator<Integer> iter2 = tamanoProblema.iterator();
		while (iter1.hasNext()) {
			System.out.println(+iter2.next() + "\t\t" + iter1.next());

		}
	}

}

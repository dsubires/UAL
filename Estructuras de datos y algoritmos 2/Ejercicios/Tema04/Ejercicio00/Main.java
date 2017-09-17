package EjerciciosTema4.Ejercicio00;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {

		String file = "";
		ArrayList<Long> tiemposB = new ArrayList<Long>();
		ArrayList<Long> tiemposD = new ArrayList<Long>();
		ArrayList<Long> tiemposF = new ArrayList<Long>();
		ArrayList<Integer> numAristas = new ArrayList<Integer>();

		for (int i = 1; i < 6; i++) {

			file = System.getProperty("user.dir");
			file = file + File.separator + "src" + File.separator
					+ "EjerciciosTema4" + File.separator + "Ejercicio00"
					+ File.separator + "Datos" + File.separator;
			file += "grafo" + i + ".txt";

			Grafo g = new Grafo(file);
			long tiempoAntes;
			long tiempoDespues;

			tiempoAntes = System.currentTimeMillis();
			g.caminosMinimosDijkstra();
			tiempoDespues = System.currentTimeMillis();
			tiemposD.add(tiempoDespues - tiempoAntes);

			tiempoAntes = System.currentTimeMillis();
			g.caminosMinimosFuerzaBruta();
			tiempoDespues = System.currentTimeMillis();
			tiemposB.add(tiempoDespues - tiempoAntes);

			tiempoAntes = System.currentTimeMillis();
			g.caminosMinimosFloyd();
			tiempoDespues = System.currentTimeMillis();
			tiemposF.add(tiempoDespues - tiempoAntes);

			numAristas.add(g.getNumVertices());

		}

		System.out.println("*********Tiempos:*********\n");
		System.out.println("Aristas:\tBruta\tDijkstra\tFloyd");
		Iterator<Long> iter1 = tiemposB.iterator();
		Iterator<Long> iter2 = tiemposD.iterator();
		Iterator<Long> iter3 = tiemposF.iterator();
		Iterator<Integer> iter0 = numAristas.iterator();
		while (iter2.hasNext()) {
			System.out.println(+iter0.next() + "\t\t" + iter1.next() + "\t"
					+ iter2.next() + "\t" + iter3.next());
		}
	}

}

package EjerciciosTema3.Ejercicio00;

import java.util.PriorityQueue;
import java.io.*;

public class Grafo {

	private int numVertices;
	private int[][] aristas;

	public Grafo(String nombreArchivo) {
		// aqui leo el archivo de texto con la informacion del grafo
		try {
			BufferedReader f = new BufferedReader(new FileReader(new File(
					nombreArchivo)));
			// el numero de vertices se lee del archivo
			// supongo que esta en la primera linea del fichero
			numVertices = Integer.parseInt(f.readLine());
			// inicializo la tabla a infinito, excepto la diagonal
			// que se inicializa a 0
			aristas = new int[numVertices][numVertices];
			for (int i = 0; i < numVertices; i++) {
				for (int j = 0; j < numVertices; j++) {
					if (i == j)
						aristas[i][j] = 0;
					else
						aristas[i][j] = Integer.MAX_VALUE;
				}
			}
			// ahora leo cada arista del grafo, junto con su peso
			String linea;
			while ((linea = f.readLine()) != "") {
				String[] datos = linea.split(" ");
				aristas[Integer.parseInt(datos[0])][Integer.parseInt(datos[1])] = Integer
						.parseInt(datos[2]);

			}
			f.close();
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}

	/**
	 * voy a calcular dijkstra para cada vertice sumo el vector de distancias
	 * resultado de dijkstra y el vertice cuya suma sea la menor, es el ganador
	 * 
	 * @return el mejor vertice
	 */
	public Integer mejorLocalizacion() {
		int[] distancias = new int[numVertices];
		//Integer[] previos = new Integer[numVertices];
		Integer mejorVertice = 0;
		int minimo = Integer.MAX_VALUE;

		for (int i = 0; i < numVertices; i++) {
			dijkstra(i, distancias);
			int sum = 0;
			for (int j = 0; j < distancias.length; j++)
				sum = sum + distancias[j];
			if (sum < minimo) {
				minimo = sum;
				mejorVertice = i;
			}
		}
		return mejorVertice;
	}

	private void dijkstra(int origen, int[] distancias) {
		Nodo nodo;
		Integer[] previos = new Integer[numVertices];

		for (int i = 0; i < distancias.length; i++) {
			distancias[i] = aristas[origen][i];
			previos[i] = null;
		}
		distancias[origen] = 0;
		PriorityQueue<Nodo> colap = new PriorityQueue<Nodo>();
		for (int i = 0; i < numVertices; i++) {
			if (i != origen) {
				nodo = new Nodo(i, distancias[i]);
				colap.add(nodo);
			}
		}
		while (!colap.isEmpty()) {
			nodo = colap.poll();
			for (int j = 0; j < numVertices; j++) {
				if (aristas[nodo.vertice][j] != 0
						&& aristas[nodo.vertice][j] != Integer.MAX_VALUE) {
					if (distancias[j] > distancias[nodo.vertice]
							+ aristas[nodo.vertice][j]) {
						distancias[j] = distancias[nodo.vertice]
								+ aristas[nodo.vertice][j];
						previos[j] = nodo.vertice;
					}
				}
			}
		}
	}
	
	public int getNumVertices(){
		return numVertices;
	}

	private class Nodo implements Comparable {
		private Integer vertice;
		private Integer peso;

		public Nodo(Integer vertice, Integer peso) {
			this.vertice = vertice;
			this.peso = peso;
		}

		@Override
		public int compareTo(Object o) {
			Nodo nodo = (Nodo) o;
			if (peso < nodo.peso)
				return -1;
			if (peso > nodo.peso)
				return 1;
			if (vertice < nodo.vertice)
				return -1;
			if (vertice > nodo.vertice)
				return 1;
			return 0;
		}

	}
}

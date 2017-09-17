package EjerciciosTema4.Ejercicio00;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Stack;
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
			while ((linea = f.readLine()) != null) {
				String[] datos = linea.split(" ");
				aristas[Integer.parseInt(datos[0])][Integer.parseInt(datos[1])] = Integer
						.parseInt(datos[2]);

			}
			f.close();
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

	public String caminosMinimosFuerzaBruta() {
		ArrayList<String> aux = new ArrayList<String>();
		int[][] caminos = new int[numVertices][numVertices];
		ArrayList<Integer>[][] recorridos = new ArrayList[numVertices][numVertices];

		// Rellenamos matriz caminos de Integer.Max_Value
		for (int i = 0; i < numVertices; i++)
			for (int j = 0; j < numVertices; j++)
				caminos[i][j] = Integer.MAX_VALUE;

		// Lanzamos algoritmo fuerza bruta
		fuerzaBruta(caminos, recorridos);

		// Procesamos los datos obtenidos por el algoritmo
		for (int i = 0; i < numVertices; i++)
			for (int j = 0; j < numVertices; j++)
				if (i != j) {
					if (caminos[i][j] != Integer.MAX_VALUE) {
						aux.add("Peso camino de " + i + " a " + j + "->  "
								+ caminos[i][j] + "\n");
						aux.add("Camino: " + recorridos[i][j].toString() + "\n");
					}
				}
		return aux.toString();
	}

	private void fuerzaBruta(int[][] caminos, ArrayList<Integer>[][] recorridos) {

		for (int i = 0; i < numVertices; i++) {
			for (int j = 0; j < numVertices; j++) {
				int peso = 0;
				ArrayList<Integer> camino = new ArrayList<Integer>();
				if (i == j) {
					caminos[i][j] = peso;
					recorridos[i][j] = null;
				} else {

					// Hay arista del vertice i al vertice j
					if (aristas[i][j] != Integer.MAX_VALUE) {
						peso += aristas[i][j];
						camino.add(i);
						camino.add(j);
						caminos[i][j] = peso;
						recorridos[i][j] = camino;
					} else {

						// No hay arista del vertice i al vertice j
						// Buscamos camino
						buscarCamino(i, j, peso, camino, caminos, recorridos);
					}
				}

			}
		}
	}

	private void buscarCamino(int from, int to, int peso,
			ArrayList<Integer> camino, int[][] caminos,
			ArrayList<Integer>[][] recorridos) {
		ArrayList<Integer> vecinos = getVecinos(from);
		if (vecinos.contains(to)) {
			// solucion encontrada
			peso += aristas[from][to];
			camino.add(from);
			camino.add(to);
			if (caminos[camino.get(0)][to] > peso) {
				// si es mejor que la que tenemos, la guardamos
				caminos[camino.get(0)][to] = peso;
				recorridos[camino.get(0)][to] = camino;
			}
		} else {
			// solucion no encontrada
			Iterator<Integer> it = vecinos.iterator();
			while (it.hasNext()) {
				int vecinoTemp = it.next();
				if (!camino.contains(vecinoTemp)) {
					ArrayList caminoTemp = (ArrayList) camino.clone();
					caminoTemp.add(from);
					buscarCamino(vecinoTemp, to, peso
							+ aristas[from][vecinoTemp], caminoTemp, caminos,
							recorridos);
				}
			}
		}
	}

	private ArrayList<Integer> getVecinos(int vertice) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 0; i < numVertices; i++) {
			if (i != vertice)
				if (aristas[vertice][i] != Integer.MAX_VALUE)
					al.add(i);
		}
		return al;
	}

	public String caminosMinimosDijkstra() {
		Integer[] matriz = new Integer[numVertices];
		Integer[] recorridos = new Integer[numVertices];
		ArrayList<String> aux = new ArrayList<String>();

		for (Integer i = 0; i < numVertices; i++) {
			dijkstra(i, matriz, recorridos);
			for (int j = 0; j < numVertices; j++) {
				if (i != j) {
					if (matriz[j] != Integer.MAX_VALUE) {
						aux.add("Peso camino de " + i + " a " + j + "->  "
								+ matriz[j] + "\n");
						// calculamos recorrido
						ArrayList<Integer> recorrido = new ArrayList<Integer>();
						if (recorridos[j] != null) {
							Stack<Integer> pila = new Stack<Integer>();
							Integer temp = recorridos[j];
							while (temp != -1) {
								pila.push((int) temp);
								temp = recorridos[(int) temp];
							}
							while (!pila.isEmpty())
								recorrido.add(pila.pop());
						}
						recorrido.add(j);
						aux.add("Camino: " + recorrido.toString() + "\n");

					}
				}
			}

		}

		return aux.toString();
	}

	// Dijkstra Priority Queue
	public void dijkstra(Integer source, Integer[] distancias, Integer[] padre) {
		int INFINITY = Integer.MAX_VALUE;
		PriorityQueue<Nodo> pq = new PriorityQueue<Nodo>();

		if (source == null)
			return;

		for (int i = 0; i < numVertices; i++) {
			distancias[i] = INFINITY;
			padre[i] = -1;

		}
		distancias[source] = 0;
		padre[source] = -1;
		pq.add(new Nodo(source, 0));

		while (!pq.isEmpty()) {
			Nodo nodo = pq.poll();
			for (int i = 0; i < numVertices; i++) {
				if (aristas[nodo.vertice][i] < INFINITY) {
					int sumTemp = distancias[nodo.vertice]
							+ aristas[nodo.vertice][i];
					if (distancias[i] > sumTemp) {
						distancias[i] = sumTemp;
						padre[i] = nodo.vertice;
						pq.add(new Nodo(i, distancias[i]));
					}
				}
			}
		}
	}

	public String caminosMinimosFloyd() {
		ArrayList<String> aux = new ArrayList<String>();
		int[][] matriz = aristas.clone();
		int[][] recorridos = new int[numVertices][numVertices];

		for (int i = 0; i < numVertices; i++)
			for (int j = 0; j < numVertices; j++)
				recorridos[i][j] = -1;

		floyd(matriz, recorridos);

		for (int i = 0; i < numVertices; i++) {
			for (int j = 0; j < numVertices; j++) {
				if (i != j) {
					aux.add("Peso camino de " + i + " a " + j + "->  "
							+ matriz[i][j] + "\n");
					// calculamos recorrido
					aux.add("Camino: [" + showPath(i, j, recorridos) + "]\n");
				}
			}

		}

		return aux.toString();
	}

	public void floyd(int[][] d, int[][] p) {
		int infinity = Integer.MAX_VALUE;

		for (int k = 0; k < numVertices; k++) {
			for (int i = 0; i < numVertices; i++) {
				for (int j = 0; j < numVertices; j++) {

					if ((d[i][k] < infinity) && (d[k][j] < infinity)
							&& d[i][k] != -1 && d[k][j] != -1) {
						int temp = d[i][k] + d[k][j];
						if (temp < d[i][j]) {
							d[i][j] = temp;
							p[i][j] = k;
						}
					}

				}
			}
		}
	}

	// Dos métodos para reconstruir recorridos/caminos generados por el
	// algoritmo Floyd
	private String showPath(int i, int j, int A[][]) {
		String output = i + ", ";
		output += showPathR(i, j, A);
		output += j;
		return output;
	}

	private String showPathR(int i, int j, int A[][]) {
		String output = "";// +i+", ";
		int k = A[i][j];
		if (k >= 0) {
			output += showPathR(i, k, A);
			output += k + ", ";
			output += showPathR(k, j, A);
		}
		return output;
	}

	public int getNumVertices() {
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

package EjerciciosTema4.Ejercicio01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Mochila {

	private ArrayList<Objeto> lista;
	private int capacidad;
	private int[][] B ;

	public Mochila(String archivo) {
		lista = new ArrayList<Objeto>();
		try {
			BufferedReader f = new BufferedReader(new FileReader(new File(
					archivo)));

			// leemos la capacidad en la primera linea del archivo
			capacidad = Integer.parseInt(f.readLine());
			String linea;
			while ((linea = f.readLine()) != null) {
				String[] datos = linea.split(" ");		
				lista.add(new Objeto(datos[0], Integer.parseInt(datos[1]),Integer.parseInt(datos[2])));
			}
			f.close();
			B = new int[lista.size() + 1][capacidad + 1];
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public String getMochilaGreedy() {
		ArrayList<Objeto> contenido = mochilaGreedy();
		return imprimeDatos(contenido);
	}

	private ArrayList<Objeto> mochilaGreedy() {
		if(lista.size() == 0 || capacidad == 0)
			return null;
		// declaracion e inicializacion de datos
		double peso = 0;
		ArrayList<Objeto> contenido = new ArrayList<Objeto>();
		TreeSet<Objeto> tree = new TreeSet<Objeto>();
		for (Objeto o : lista)
			tree.add(o);


		// nucelo algoritmo
		while (peso < capacidad && !tree.isEmpty()) {
			Objeto o = tree.pollFirst();

			if (peso + o.peso <= capacidad) {
				contenido.add(o);
				peso += o.peso;
			}
		}

		return contenido;
	}
	
	public String getMochilaDinamica(){
		ArrayList<Objeto> contenido = mochilaDinamica();
		return imprimeDatos(contenido);
	}
	
	private ArrayList<Objeto> mochilaDinamica() {
		if (lista.size() == 0 || capacidad == 0)
			return null;

	
		int n = lista.size();
		
		

		for (int w = 0; w <= capacidad; w++)
			B[0][w] = 0;

		for (int k = 1; k <= n; k++) {
			for (int w = 0; w <= lista.get(k -1).peso -1; w++)
				B[k][w] = B[k - 1][w];
			for (int w = lista.get(k - 1).peso; w <= capacidad; w++) {
				int temp = B[k - 1][w - lista.get(k - 1).peso] + lista.get(k - 1).valor;
				if (temp > B[k - 1][w])
					B[k][w] = temp;
				else
					B[k][w] = B[k - 1][w];
			}
		}
	/*	
		//Descomentar los dos bucles para visualizar por consola la TABLA del algoritmo
		for(int i=0; i<=lista.size(); i++){
			for(int j=0; j<=capacidad; j++){
				System.out.print(B[i][j]+" ");
			}
			System.out.println();
		}
	*/	
		return obtenerObjetosSeleccionados(n , capacidad );
	}
/*	
 * Metodo recursivo para construir la solución a partir de la tabla
	private ArrayList<Objeto> obtenerObjetos(int n, int p){
		ArrayList<Objeto> output = new ArrayList<Objeto>();
		
		if(n > 0){
			if(p < lista.get(n).peso)
				output.addAll(obtenerObjetos(n - 1, p));
			else{
				if(B[n - 1][p - lista.get(n).peso] + lista.get(n).valor > B[n - 1][p]){
					output.addAll(obtenerObjetos(n-1, p - lista.get(n).peso ));
					output.add(lista.get(n));
//					return output;
				}else
					output.addAll(obtenerObjetos(n - 1, p));
			}
		}
		return output;
	}
	
*/
	//Metodo lineal para construir la solucion a partir de la tabla
	private ArrayList<Objeto> obtenerObjetosSeleccionados(int n, int p){
		ArrayList<Objeto> output = new ArrayList<Objeto>();
		
		while(n > 0){
			if(B[n][p] == B[n-1][p]){
				n--;
			}else{
				output.add(lista.get(n - 1));
				p -= lista.get(n - 1).peso;
				n--;
			}
		}
		return output;
	}
	private String imprimeDatos(ArrayList<Objeto> contenido) {
		ArrayList<String> output = new ArrayList<String>();

		output.add("Contenido mochila\nCapacidad:" + capacidad + "\n");
		double sumaValor = 0;
		double sumaPeso = 0;

		for (Objeto o : contenido) {
			output.add(o.toString() + "\n");
			sumaValor += o.valor;
			sumaPeso += o.peso;
		}

		output.add("Numero objetos:" + contenido.size() + "\n");
		output.add("Valor total:" + sumaValor + " Peso total:" + sumaPeso);

		return output.toString().replace(", ", "");
	}
	
	public int getNumeroTotalObjetos(){
		return lista.size();
	}
	
	public int getCapacidadMochila(){
		return capacidad;
	}

	private class Objeto implements Comparable<Objeto> {

		private int valor;
		private int peso;
		private String nombre;

		public Objeto(String n, int v, int p) {
			nombre = n;
			valor = v;
			peso = p;
		}

		@Override
		public String toString() {
			return "Objeto[Nombre:" + nombre + " Valor:" + valor + " Peso:"
					+ peso + "]";
		}

		@Override
		public boolean equals(Object o) {
			Objeto ob = (Objeto) o;
			return nombre.equals(ob.nombre);
		}

		public int compareTo(Objeto o) {
			if ( ((double)valor / (double)peso) < ((double)o.valor / (double)o.peso))
				return 1;
			if (((double)valor / (double)peso) > ((double)o.valor / (double)o.peso))
				return -1;
			if(nombre.hashCode() < o.nombre.hashCode())
				return 1;
			if(nombre.hashCode() > o.nombre.hashCode())
				return -1;
			return 0;
		}

	}

}

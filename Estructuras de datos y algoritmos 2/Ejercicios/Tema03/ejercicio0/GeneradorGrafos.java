package EjerciciosTema3.Ejercicio00;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class GeneradorGrafos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] distancias;

		//String output = "";
		ArrayList<String> output;
		String outputFile = "";
		int numVertices = 64;

		for (int i = 1; i < 6; i++) {

//			output = "";
			output = new ArrayList<String>();
			distancias = new int[numVertices][numVertices];
//		    output += numVertices + "\n";
			output.add(numVertices+"\n");
			outputFile = System.getProperty("user.dir");
			outputFile = outputFile + File.separator + "src" + File.separator
					+ "EjerciciosTema3" + File.separator + "Ejercicio00"
					+ File.separator + "Datos" + File.separator;

			// inicializamos matriz de aristas a false;
			// esta matriz servirá para que la distancia de x a y sea la misma
			// que de y a x
			for (int j = 0; j < numVertices; j++) {
				for (int k = 0; k < numVertices; k++) {
					distancias[j][k] = 0;
				}
			}

	/*		// añadimos vertices
			for (int j = 0; j < numVertices; j++) {
				output += j + "\n";
			}
*/
			// añadimos aristas
			for (int j = 0; j < numVertices; j++) {
				for (int k = 0; k < numVertices; k++) {
					if (j != k){
						if (distancias[k][j] == 0) {
							int random = (int) Math
									.floor((Math.random() * 101 + 1));
							distancias[j][k] = random;
							distancias[k][j] = random;
						}
//						output += j + " " + k + " " + distancias[j][k] + "\n";
						output.add(j + " " + k + " " + distancias[j][k]+"\n");
					}
				}
			}
			// escribimos el fichero en disco
			outputFile += "grafo" + i + ".txt";
			File file = new File(outputFile);
			try {
				FileWriter fw = new FileWriter(file);
				Iterator<String> iter1 = output.iterator();
				while(iter1.hasNext())
					fw.write(iter1.next());
//				fw.write(output);
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			numVertices *= 2;
		}

	}

}

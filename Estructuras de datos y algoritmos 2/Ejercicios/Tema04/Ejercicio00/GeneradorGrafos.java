package EjerciciosTema4.Ejercicio00;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class GeneradorGrafos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] distancias;

		// String output = "";
		ArrayList<String> output;
		String outputFile = "";
		int numVertices = 30;

		 for (int i = 6; i < 11; i++) {

			// output = "";
			output = new ArrayList<String>();
			distancias = new int[numVertices][numVertices];
			// output += numVertices + "\n";
			output.add(numVertices + "\n");
			outputFile = System.getProperty("user.dir");
			outputFile = outputFile + File.separator + "src" + File.separator
					+ "EjerciciosTema4" + File.separator + "Ejercicio00"
					+ File.separator + "Datos" + File.separator;

			// inicializamos matriz de aristas a false;
			for (int j = 0; j < numVertices; j++) {
				for (int k = 0; k < numVertices; k++) {
					distancias[j][k] = 0;
				}
			}


			// añadimos aristas
			for (int j = 0; j < numVertices; j++) {
				for (int k = 0; k < numVertices; k++) {
					if (j != k) {
						if (distancias[k][j] == 0) {		// así evitamos que exista una arista de i a j y de j a i
							if (Math.random() > 0.49) {
								int random = (int) Math
										.floor((Math.random() * 101 + 1));
								distancias[j][k] = random;
								output.add(j + " " + k + " " + distancias[j][k]
										+ "\n");
							}
						}
					}
				}
			}
			
			//Comprobamos que de todos los vertices sale al menos UNA arista
			for (int j = 0; j < numVertices; j++) {
				int count = 0;
				for (int k = 0; k < numVertices; k++) {
					if(distancias[j][k] != 0)
						count++;
				}
				if(count == 0){
					int kTemp = (int) (Math.random() * distancias[i].length);
					int random = (int) (Math.random() * 101 + 1);
					distancias[j][kTemp] = random;
					output.add(j + " " + kTemp + " " + distancias[j][kTemp]
										+ "\n");
				}
					
			}
			
			// escribimos el fichero en disco
			outputFile += "grafo" + i + ".txt";
			File file = new File(outputFile);
			try {
				FileWriter fw = new FileWriter(file);
				Iterator<String> iter1 = output.iterator();
				while (iter1.hasNext())
					fw.write(iter1.next());
				// fw.write(output);
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			numVertices += 5;
		}

	}

}

package EjerciciosTema4.Ejercicio01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class GeneradorObjetos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		ArrayList<String> output;
		String outputFile = "";
		int numObjetos = 256;
		int capacidadMochila = 11;

		 for (int i = 1; i < 11; i++) {
			 
			outputFile = System.getProperty("user.dir");
			outputFile = outputFile + File.separator + "src" + File.separator
					+ "EjerciciosTema4" + File.separator + "Ejercicio01"
					+ File.separator + "Datos" + File.separator;

			output = new ArrayList<String>();
			int peso,valor;
			String nombre;
			output.add(capacidadMochila+"\n");
			
			for(int j=0; j<numObjetos;j++){
				valor = (int) (Math.random() * 56 + 1);
				peso = (int) (Math.random() * 11 + 1);
				nombre = j+"";
				output.add(nombre+" "+valor+" "+peso+"\n");			
				}

			
			
			// escribimos el fichero en disco
			outputFile += "mochila" + i + ".txt";
			File file = new File(outputFile);
			try {
				FileWriter fw = new FileWriter(file);
				Iterator<String> iter1 = output.iterator();
				while (iter1.hasNext())
					fw.write(iter1.next());
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			numObjetos *= 2;
		}

	}

}

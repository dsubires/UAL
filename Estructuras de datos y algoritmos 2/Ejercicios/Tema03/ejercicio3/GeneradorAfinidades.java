package EjerciciosTema3.Ejercicio03;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class GeneradorAfinidades {

	public static void main(String[] args) {

		int numEmpleados = 32;

		for (int d = 1; d < 7; d++) {

			String outputFile = System.getProperty("user.dir");
			outputFile = outputFile + File.separator + "src" + File.separator
					+ "EjerciciosTema3" + File.separator + "Ejercicio03"
					+ File.separator + "Datos" + File.separator;

			outputFile += "afinidadParejas" + d + ".txt";

			// generamos los datos
			ArrayList<String> output = new ArrayList<String>();
			output.add(numEmpleados + "\n");
			for (int i = 0; i < numEmpleados; i++) {
				for (int j = 0; j < numEmpleados; j++) {
					if (i != j) {
						output.add(i + " " + j + " "
								+ ((int) Math.floor(Math.random() * 101 + 1))
								+ "\n");
					}
				}
			}

			// escribimos los datos en disco
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

			numEmpleados *= 2;
		}
	}

}

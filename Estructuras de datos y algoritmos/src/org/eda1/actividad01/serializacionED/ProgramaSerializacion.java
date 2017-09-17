package org.eda1.actividad01.serializacionED;

import java.io.*;

public class ProgramaSerializacion {

	public ArrayList<CiudadBarrios> cargarArchivo(String inputFile) {
		ArrayList<CiudadBarrios> aux = new ArrayList<CiudadBarrios>();
		CiudadBarrios cbTemp;
		try {
			FileInputStream fis = new FileInputStream(new File(inputFile));
			DataInputStream dis = new DataInputStream(fis);
			BufferedReader buffer = new BufferedReader(new InputStreamReader(
					dis));
			String temp = "";
			String[] temp2;
			while (buffer.ready()) {
				temp = buffer.readLine();
				temp2 = temp.split(" ");
				cbTemp = new CiudadBarrios(temp2[0],
						Double.parseDouble(temp2[1]),
						Double.parseDouble(temp2[2]));
				for (int i = 0; i < Integer.parseInt(temp2[3]); i++) {
					cbTemp.addBarrio(temp2[i + 4]);
				}
				aux.add(cbTemp);
			}
			buffer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return aux;
	}

	public String mostrarEstructura(ArrayList<CiudadBarrios> cB) {
		String aux = "";
		if (cB.size() != 0) {
			Iterator<CiudadBarrios> iterador = cB.iterator();
			CiudadBarrios temp;
			while (iterador.hasNext()) {
				temp = iterador.next();
				aux += "[" + temp.ciudad + ", " + temp.latitud + ", "
						+ temp.longitud + ", {";
				Iterator<String> iterador2 = temp.barrios.iterator();
				while (iterador2.hasNext()) {
					aux += iterador2.next();
					if (iterador2.hasNext()) {
						aux += ", ";
					}
				}
				aux += "}]\n";
			}
		}
		return aux;
	}

}

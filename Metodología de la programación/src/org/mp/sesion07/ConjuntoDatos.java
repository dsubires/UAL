package org.mp.sesion07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/**
 * Clase ConjuntoDatos. Permite procesar un archivo de texto almacenando los
 * datos del archivo, nº lineas, nº columnas y cabecera.
 * 
 * @author David Subires Parra
 * 
 */

public class ConjuntoDatos {

	private File archivoTexto;
	private String separador;
	private Locale locale;
	private List<String> cabecera;
	private int numeroLineas;
	private int numeroColumnas;
	private double[][] datos;

	/**
	 * Instancia un ConjuntoDatos. Recibe como parametro un archivo, el
	 * separador de los datos y un locale. Crea la cabecera en caso necesario,
	 * establece el nº de lineas, columnas y los datos del archivo.
	 * 
	 * @param archivo
	 *            archivo a procesar
	 * @param separador
	 *            separador de los datos del archivo
	 * @param locale
	 *            locale del archivo
	 */
	public ConjuntoDatos(File archivo, String separador, Locale locale) {
		archivoTexto = archivo;
		this.separador = separador;
		this.locale = locale;
		cabecera = cabecera(archivo);
		numeroLineas = numLineas(archivo);
		numeroColumnas = numColumnas(archivo);
		datos = leerDatos(archivo, numeroLineas, numeroColumnas);
	}

	/**
	 * Metodo privado cabecera. Procesa el archivo para obtener su cabecera,
	 * añadirla a la List cabecera y devolverla
	 * 
	 * @param archivoTexto
	 *            archivo el cual se procesara su cabecera, en caso de tenerla
	 * @return una List con la cabecera
	 */
	private List<String> cabecera(File archivoTexto) {

		cabecera = new ArrayList<String>();
		try {
			// Abrimos el archivo
			FileInputStream fstream = new FileInputStream(archivoTexto);
			// Creamos el objeto de entrada
			DataInputStream entrada = new DataInputStream(fstream);
			// Creamos el buffer de lectura
			BufferedReader buffer = new BufferedReader(new InputStreamReader(
					entrada));
			// Leemos la cabecera (1ª línea)
			String temp = buffer.readLine();
			entrada.close();
			String[] temp2 = temp.split(";");
			for (int i = 0; i < temp2.length; i++) {
				cabecera.add(temp2[i]);
			}

		} catch (Exception e) {
			e.getMessage();
		}
		return cabecera;
	}

	/**
	 * Metodo privado que devuelve el numero de lineas de un archivo pasado por
	 * parametro
	 * 
	 * @param archivoTexto
	 *            archivo del que se contaran y devolveran las lineas
	 * @return numero de lineas del archivo
	 */
	private int numLineas(File archivoTexto) {
		try {
			int count;
			// Abrimos el archivo
			FileInputStream fstream = new FileInputStream(archivoTexto);
			// Creamos el objeto de entrada
			DataInputStream entrada = new DataInputStream(fstream);
			// Creamos el buffer de lectura
			BufferedReader buffer = new BufferedReader(new InputStreamReader(
					entrada));

			// Comprobamos si el archivo tiene cabecera o no
			String[] temp = buffer.readLine().split(";");
			char c = temp[0].charAt(0);
			if (Character.isLetter(c)) {
				count = -1; // Si hay cabecera
			} else {
				count = 0; // No hay cabecera
			}
			fstream.close();
			fstream = new FileInputStream(archivoTexto);
			entrada = new DataInputStream(fstream);
			buffer = new BufferedReader(new InputStreamReader(entrada));

			// Leer el archivo linea por linea
			while (buffer.readLine() != null) {
				count++;
			}
			entrada.close();
			return count;

		} catch (Exception e) {
			e.getMessage();
		}
		return numeroLineas;
	}

	/**
	 * Metodo privado numColumnas. Devuelve el numero de columnas de un archivo
	 * de texto.
	 * 
	 * @param archivoTexto
	 *            archivo el cual se contara y devolvera el numero de columnas
	 * @return numero de columnas del archivo
	 */
	private int numColumnas(File archivoTexto) {
		return cabecera.size();
	}

	/**
	 * Metodo privado leerDatos. Procesa los datos de un archivo de texto pasado
	 * por parametro junto con el numero de filas y columnas. Lee los datos del
	 * arhivo y los devuelve en una matriz double
	 * 
	 * @param archivoTexto
	 *            archivo el cual se van a leer los datos
	 * @param filas
	 *            numero de filas del archivo
	 * @param columnas
	 *            numero de columnas del archivo
	 * @return todos los datos del archivo de texto
	 */
	private double[][] leerDatos(File archivoTexto, int filas, int columnas) {
		datos = new double[filas][columnas];
		int count;
		try {
			// Abrimos el archivo
			FileInputStream fstream = new FileInputStream(archivoTexto);
			// Creamos el objeto de entrada
			DataInputStream entrada = new DataInputStream(fstream);
			// Creamos el buffer de lectura
			BufferedReader buffer = new BufferedReader(new InputStreamReader(
					entrada));
			// Comprobamos si el archivo tiene cabecera o no
			String[] temp = buffer.readLine().split(";");
			char c = temp[0].charAt(0);
			if (Character.isLetter(c)) {
				count = -1; // Si hay cabecera
			} else {
				count = 0; // No hay cabecera
			}
			fstream.close();
			fstream = new FileInputStream(archivoTexto);
			entrada = new DataInputStream(fstream);
			buffer = new BufferedReader(new InputStreamReader(entrada));
			// Leer el archivo linea por linea
			String linea;
			double temp2;
			while ((linea = buffer.readLine()) != null) {
				if (count >= 0) {
					String[] elementos = linea.split(";");
					for (int i = 0; i < elementos.length; i++) {
						// Si falla el parseo de String a double, por ejemplo en
						// el caso NaN, se asigna un 0
						try {
							temp2 = Double.parseDouble(elementos[i]);
							datos[count][i] = temp2;
						} catch (Exception e) {
							datos[count][i] = 0;

						}
					}
				}
				count++;
			}
			entrada.close();

		} catch (Exception e) {
			e.getMessage();
		}
		return datos;
	}

	/**
	 * Metodo publico getColumna. Devuelve los datos de una columna pasada por
	 * parametro, almacenados en un vector double.
	 * 
	 * @param columna
	 *            indice o numero int de la columna a obtener los datos
	 * @return todas las filas de la culumna
	 */
	public double[] getColumna(int columna) {
		double[] temp = new double[numeroLineas];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = datos[i][columna];
		}
		return temp;
	}

	/**
	 * Metodo publico getColumna. Devuelve los datos de una columna pasada por
	 * parametro, almacenados en un vector double.
	 * 
	 * @param columna
	 *            indice o numero int de la columna a obtener los datos
	 * @return todas las filas de la culumna
	 */
	public double[] getColumna(String columna) {
		int columnaString = -1;

		String aux;

		Iterator<String> iterador = cabecera.iterator();
		int pos = 0;
		while (true) {
			aux = iterador.next();
			if (aux.equals(columna)) {
				columnaString = pos;
				break;
			}
			pos++;
		}

		double[] temp = new double[numeroLineas];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = datos[i][columnaString];
		}
		return temp;

	}

	/**
	 * Metodo publico getCabecera. Devuelve una List con la cabecer
	 * 
	 * @return cabecera almacenada en una List
	 */
	public List<String> getCabecera() {
		return cabecera;
	}

	/*
	 * public void setCabecera(String[] cabecera) { List<String> temp = new
	 * ArrayList<String>(); for (int i = 0; i < cabecera.length; i++) {
	 * temp.add(cabecera[i]); } this.cabecera = temp; }
	 */
	/**
	 * Metodo publico getSeparador. Devuelve el separador
	 * 
	 * @return separador
	 */
	public String getSeparador() {
		return separador;
	}

	/**
	 * Metodo publico getLocale. Devuelve el locale
	 * 
	 * @return locale
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * Metodo publico getNumeroLineas. Devuelve el numero de lineas(int)
	 * 
	 * @return numero de lineas
	 */
	public int getNumeroLineas() {
		return numeroLineas;
	}

	/**
	 * Metodo publico getNumeroColumnas. Devuelve el numero de columnas en (int)
	 * 
	 * @return numero de columnas
	 */
	public int getNumeroColumnas() {
		return numeroColumnas;
	}

	/**
	 * Metodo publico getDatos. Devuelve una matriz con los datos
	 * 
	 * @return datos
	 */
	public double[][] getDatos() {
		return datos;
	}

	/**
	 * Metodo publico getArchivoTexto. Devuelve el archivo de texto(File)
	 * 
	 * @return archivo de texto
	 */
	public File getArchivoTexto() {
		return archivoTexto;
	}

	/**
	 * Metodo publico exportar. Exporta todos los datos del CojuntoDatos cuya
	 * cabecera coincida con la cabecera pasada por parametro. Estos datos
	 * quedan almacenados en disco en la ruta (String archivoTexto) delimitados
	 * por (String separador).
	 * 
	 * @param cabecera
	 *            Array de string que contiene la cabecera de datos a exportar
	 * @param archivoTexto
	 *            archivo de texto es la dirección en disco donde se almacenaran
	 *            los datos con la cabecera
	 * @param separador
	 *            separador usado para almacenar los datos del fichero
	 */
	public void exportar(String[] cabecera, String archivoTexto,
			String separador) {

		int nColumnas = cabecera.length;
		int count = 0;
		int[] iColumnas = new int[nColumnas];
		String aux = "";

		for (int i = 0; i < this.cabecera.size(); i++) {
			if (this.cabecera.get(i).equals(cabecera[count])) {
				iColumnas[count] = i;
				count++;
				if (count == nColumnas) {
					break;
				}
			}
		}
		try {

			FileWriter fw = new FileWriter(archivoTexto);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);

			aux = "";
			for (int i = 0; i < cabecera.length; i++) {
				if (i == cabecera.length - 1) {
					aux += cabecera[i];
				} else {
					aux += cabecera[i] + separador;
				}
			}
			pw.println(aux);
			count = 0;
			aux = "";
			for (int linea = 0; linea < datos[0].length; linea++) {
				for (int columna = 0; columna < nColumnas; columna++) {
					if (columna == nColumnas - 1) {
						aux += datos[linea][iColumnas[count]];
						count = 0;
					} else {
						aux += datos[linea][iColumnas[count]] + separador;
						count++;
					}
				}
				pw.println(aux);
				aux = "";
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Metodo publico conjuntoDatos. LLama al metodo exportar con la cabecera
	 * pasada por parametro, el separador y el locale, y despues instancia y
	 * devuelve un nuevo ConjuntoDatos apartir del archivoTexto creado por
	 * exportar
	 * 
	 * 
	 * @param cabecera
	 *            cabecera que tendra el conjuntoDatos.
	 * @param archivoTexto
	 *            archivo de texto a procesar para obtener los datos
	 * @param separador
	 *            separador usado en los datos
	 * @param locale
	 *            locale de los datos
	 * @return devuelve conjuntoDatos con los datos pasados por parametro
	 */
	public ConjuntoDatos conjuntoDatos(String[] cabecera, String archivoTexto,
			String separador, Locale locale) {
		exportar(cabecera, archivoTexto, separador);
		return new ConjuntoDatos(new File(archivoTexto), separador, locale);
	}

}

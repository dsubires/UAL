package org.eda1.practica03.ejercicio01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * Clase ProcesarDirecciones. 
 * Procesa un log .txt de conexiones a una red(IP;NOMBRE) para posteriormente mostrar dicha 
 * información de manera ordenada, mostrando el número de conexiones de un par IP,Nombre_Maquina,
 * incluso ver las incidencias(varias maquinas conectadas con la misma IP) 
 * @author david
 *
 */

public class ProcesarDirecciones {

	TreeMap<String, TreeMap<String, Integer>> mapa;
	/**
	 * Instancia un nuevo objeto del tipo ProcesarDirecciones
	 */
	public ProcesarDirecciones() {
		mapa = new TreeMap<String, TreeMap<String, Integer>>();
	}
	/**
	 * Procesa el log del archivo en la ruta (path) pasada como parámetro y almacena de manera ordenada todas las conexiones.
	 * @param archivo ruta del archivo que sera procesado.
	 */
	public void cargarArchivo(String archivo) {
		String dir, nom;

		Scanner scaner;
		try {
			scaner = new Scanner(new File(archivo));			
			while (scaner.hasNext()) {
				dir = scaner.next();
				nom = scaner.next();
				if (mapa.containsKey(dir)) {
					//La direccion está en nuestro mapa
					if (mapa.get(dir).containsKey(nom))
						mapa.get(dir).put(nom, (mapa.get(dir).get(nom)) + 1);
					else
						mapa.get(dir).put(nom, 1);

				} else {
					//La direccion no está en nuestro mapa
					TreeMap<String, Integer> temp = new TreeMap<String, Integer>();
					temp.put(nom, 1);
					mapa.put(dir, temp);
				}
			}

			scaner.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Devuelve el numero de direcciones almacenadas
	 * @return int numero direcciones
	 */
	public int tamano() {
		return mapa.size();
	}
	/**
	 * Genera un archivo en la ruta especifidada por el parametro "archivo" con todas las direcciones que contiene el objeto ProcesarDirecciones
	 * almacenandolas en el siguiente formato: 113.213.12.1 => {epi.ual.es=1, epicuro.ual.es=2}
	 * @param archivo ruta(path) donde se generará el archivo con las direcciones
	 */
	public void generarDirecciones(String archivo) {
		// output-example: "113.213.12.1 => {epi.ual.es=1, epicuro.ual.es=2}"
		String output = "", key;
		Iterator<String> iterador = mapa.keySet().iterator();

		// Direcciones a output
		while (iterador.hasNext()) {
			key = iterador.next();
			output += key + " => ";
			output += mapa.get(key).toString() + "\n";
		}

		// Direcciones a disco
		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(new File(archivo)));
			oos.writeObject(output);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * Muestra por pantalla todas las direcciones en el siguiente formato: 113.213.12.1 => {epi.ual.es=1, epicuro.ual.es=2}
	 */
	public void mostraDirecciones() {
		// output-example: "113.213.12.1 => {epi.ual.es=1, epicuro.ual.es=2}"
		String output = "", key;
		Iterator<String> iterador = mapa.keySet().iterator();

		// Direcciones a output
		while (iterador.hasNext()) {
			key = iterador.next();
			output += key + " => ";
			output += mapa.get(key).toString() + "\n";
		}
		System.out.println(output);
	}

	/**
 	 * Genera un archivo en la ruta especifidada por el parametro "archivo" con todas las incidencias generadas por las direcciones que contiene el objeto ProcesarDirecciones
	 * almacenandolas en el siguiente formato: 113.213.12.1 => {epi.ual.es=1, epicuro.ual.es=2} 
	 * @param archivo ruta(path) donde se generará el archivo con las incidencias
	 */
	public void generarIncidencias(String archivo) {
		// output-example: "113.213.12.1 => {epi.ual.es=1, epicuro.ual.es=2}"
		String output = "", key;
		Iterator<String> iterador = mapa.keySet().iterator();

		// Incidencias a output
		while (iterador.hasNext()) {
			key = iterador.next();
			if (mapa.get(key).size() > 1) {
				output += key + " => ";
				output += mapa.get(key).toString() + "\n";
			}
		}

		// Incidencias a disco
		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(new File(archivo)));
			oos.writeObject(output);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Muestra las incidencias, generadas por las direcciones que contiene ProcesarDirecciones, por pantalla
	 */
	public void mostrarIncidencias() {
		String output = "", key;
		Iterator<String> iterador = mapa.keySet().iterator();

		// Incidencias a output
		while (iterador.hasNext()) {
			key = iterador.next();
			if (mapa.get(key).size() > 1) {
				output += key + " => ";
				output += mapa.get(key).toString() + "\n";
			}
		}

		System.out.println(output);
	}
	
	/**
	 * Devuelve el nombre de todas las máquinas cuyo contador sea mayor que "c"
	 * @param c (int) numero contador pasado por parametro
	 * @return ArrayList<String> con los nombres de las maquinas que cumplan la condición
	 */
	public ArrayList<String> maquinasConContadorMayorQue(int c) {
		ArrayList<String> output = new ArrayList<String>();
		String key1 = "", key2 = "";
		Iterator<String> iterador = mapa.keySet().iterator();
		while (iterador.hasNext()) {
			key1 = iterador.next();
			Iterator<String> iterador2 = mapa.get(key1).keySet().iterator();
			while (iterador2.hasNext()) {
				key2 = iterador2.next();
				if (mapa.get(key1).get(key2) > c)
					output.add(key2);
			}
		}

		return output;
	}
	
	//
	// Metodo maquinasConContadorMayorQue usando Entry<StringInteger>
	//
	/*
	 * Metodo maquinasConContadorMayorQue con Iterator<Entry<String,Integer>>
	 * 
	public ArrayList<String> maquinasConContadorMayorQue(int c) {
		ArrayList<String> output = new ArrayList<String>();
		Iterator<String> iterador = mapa.keySet().iterator();
		while (iterador.hasNext()) {
			Iterator<Entry<String,Integer>> iterador2 = mapa.get(iterador.next()).entrySet().iterator();
			while(iterador2.hasNext()){
			Entry<String,Integer> entrada = iterador2.next();
			if(entrada.getValue() > 1 )
				output.add(entrada.getKey());
			}
		}
		return output;
	}
	*/
	
	/**
	 * Devuelve el nombre de todas las máquinas cuyo contador sea igual que "c"
	 * @param c (int) numero contador pasado por parametro
	 * @return ArrayList<String> con los nombres de las maquinas que cumplan la condición
	 */
	public int maquinasConContadorIgualA(int c) {
		int count = 0;
		String key1 = "", key2 = "";
		Iterator<String> iterador = mapa.keySet().iterator();
		while (iterador.hasNext()) {
			key1 = iterador.next();
			Iterator<String> iterador2 = mapa.get(key1).keySet().iterator();
			while (iterador2.hasNext()) {
				key2 = iterador2.next();
				if (mapa.get(key1).get(key2) == c)
					count++;
			}
		}
		return count;
	}
	/**
	 * Devuelve el contador(numero de veces que un PC usa la red a traves de una IP)
	 * @param direccion Ip de la maquina a buscar
	 * @param maquina Nombre de la maquina a buscar
	 * @return (int) contador de la maquina con direccion y nombre pasados por parametro. Si no existe devuelve -1
	 */
	public int valorContador(String direccion, String maquina) {
		if (mapa.containsKey(direccion)
				&& mapa.get(direccion).containsKey(maquina))
			return mapa.get(direccion).get(maquina);
		return -1;
	}
	
	/**
	 * Devuelve las incidencias generadas por una direccion
	 * @param direccion IP para mirar si presenta conflictos
	 * @return El nombre de las maquinas en conflicto
	 */
	public ArrayList<String> incidenciasGeneradasPor(String direccion) {
		ArrayList<String> output = new ArrayList<String>();
		if(mapa.containsKey(direccion)){
			if(mapa.get(direccion).size() > 1 ){
				Iterator<String> iterador = mapa.get(direccion).keySet().iterator();
				while(iterador.hasNext())
					output.add(iterador.next());
			}
		}
		return output;
	}
	
	/**
	 * Devuelve el número de incidencias generadas por una direccion
	 * @param direccion IP a comprobar si presenta incidencias
	 * @return (int) numero de incidencias
	 */
	public int numeroDeIncidenciasGeneradasPor(String direccion){
		int temp;
		if(mapa.containsKey(direccion)){
				if((temp = (mapa.get(direccion).size())) > 1)
					return temp;
		}
		return 0;
	}


}

package org.eda1.practica03.ejercicio03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Concordancia {

	private Pattern identifierPattern;
	/**
	 * Instancia un nuevo objeto Concordancia
	 * @param expresion
	 */
	public Concordancia(String expresion) {
		identifierPattern = Pattern.compile(expresion);
	}
	/**
	 * Devuelve la concordancia de un string pasado por parametro
	 * @param cadena string del cual se obtendra la concordancia
	 * @return String concordancia
	 */
	public String concordance(String cadena) {
		String aux = "",linea = "";
		TreeSet<Integer> set;
		int lineaCount = 0;
		TreeMap<String, TreeSet<Integer>> mapa = new TreeMap<String, TreeSet<Integer>>();
		
		Scanner scaner = new Scanner(cadena);
		while(scaner.hasNext()){
		linea = scaner.nextLine();
		Matcher mt = identifierPattern.matcher(linea);
		while (mt.find()) {
			aux = linea.substring(mt.start(), mt.end());
			if (!mapa.containsKey(aux)) {
				// aux no esta en el mapa
				set = new TreeSet<Integer>();
				set.add(1);
				mapa.put(aux, set);
			} else {
				// aux esta en el mapa, solo añadimos la linea
				mapa.get(aux).add(1);
			}
		}
		}
		return writeConcordance(mapa);
	}
	
	/**
	 * Devuelve la concordancia de un archivo pasado por parametro
	 * @param filename archivo del cual se obtendra la concordancia
	 * @return String concordancia
	 */
	public String concordance(File filename) {
		String coincidencia = "", linea = "";
		Scanner scaner;
		TreeMap<String, TreeSet<Integer>> mapa = new TreeMap<String, TreeSet<Integer>>();
		try {
			scaner = new Scanner(filename);
			TreeSet<Integer> set;
			int lineaCount = 0;
			Matcher mt;

			while (scaner.hasNext()) {
				lineaCount++;
				linea = scaner.nextLine();
				mt = identifierPattern.matcher(linea);
				while (mt.find()) {
					coincidencia = linea.substring(mt.start(), mt.end());
					if (!mapa.containsKey(coincidencia)) {
						// coincidencia no esta en el mapa
						set = new TreeSet<Integer>();
						set.add(lineaCount);
						mapa.put(coincidencia, set);
					} else {
						// coincidencia esta en el mapa, solo añadimos la linea
						mapa.get(coincidencia).add(lineaCount);
					}
				}

			}
			
			scaner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return writeConcordance(mapa);
	}

	private String writeConcordance(TreeMap<String, TreeSet<Integer>> map) {
		// example otput: "else          1:    6"

		String output = "", linea = "";
		Set<Map.Entry<String, TreeSet<Integer>>> entries = map.entrySet();
		TreeSet<Integer> lineNumberSet;
		Iterator<Map.Entry<String, TreeSet<Integer>>> iter = entries.iterator();
		Iterator<Integer> setIter;
		while (iter.hasNext()) {
			linea = "";
			Map.Entry<String, TreeSet<Integer>> e = iter.next();
			linea += String.format("%-10s", e.getKey());
			lineNumberSet = e.getValue();
			linea += String.format("%5s%s", e.getValue().size(), ":");
			setIter = lineNumberSet.iterator();
			while (setIter.hasNext()) {
				linea += String.format("%5s", setIter.next());
			}
			if (iter.hasNext())
				linea += "\n";
			output += linea;
		}

		return output;
	}
	/**
	 * Devuelve la concordancia de un archivo pasado por parametro, mostrando, ademas de la palabra y el/los numeros de lineas en las que aparece,
	 * el numero de veces que aparece en cada linea
	 * @param filename
	 * @return
	 */
	public String newConcordance(File filename) {
		Scanner scaner;
		TreeMap<String, TreeMap<Integer,Integer>> mapa = new TreeMap<String, TreeMap<Integer,Integer>>();
		String linea = "", coincidencia = "";
		try {
			scaner = new Scanner(filename);
			TreeMap<Integer,Integer> mapaInteger;
			int lineaCount = 0;
			Matcher mt;

			while (scaner.hasNext()) {
				lineaCount++;
				linea = scaner.nextLine();
				mt = identifierPattern.matcher(linea);
				while (mt.find()) {
					coincidencia = linea.substring(mt.start(), mt.end());
					if (!mapa.containsKey(coincidencia)) {
						// coincidencia no esta en el mapa
						mapaInteger = new TreeMap<Integer,Integer>();
						mapaInteger.put(lineaCount, 1);
						mapa.put(coincidencia, mapaInteger);
					} else {
						// coincidencia esta en el mapa
						if(mapa.get(coincidencia).containsKey(lineaCount))
							//linea ya esta registrada
							mapa.get(coincidencia).put(lineaCount, mapa.get(coincidencia).get(lineaCount)+1 );
						else
							//linea no esta registrada
						mapa.get(coincidencia).put(lineaCount, 1);
					}
				}

			}
			
			scaner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return newWriteConcordance(mapa);
	}
	
	private String newWriteConcordance(TreeMap<String,TreeMap<Integer,Integer>> map){
		// example otput: hypotenuse    2:    2(1)    8(1)

		String output = "", linea = "";
		Set<Map.Entry<String, TreeMap<Integer,Integer>>> entries = map.entrySet();
		TreeMap<Integer,Integer> lineNumberMap;
		Iterator<Map.Entry<String, TreeMap<Integer,Integer>>> iter = entries.iterator();
		Iterator<Map.Entry<Integer, Integer>> iter2;
		int count;
		while (iter.hasNext()) {
			linea = "";
			count = 0;
			Map.Entry<String, TreeMap<Integer,Integer>> e = iter.next();
			linea += String.format("%-10s", e.getKey());
			lineNumberMap = e.getValue();
			Iterator<Integer> iterador = lineNumberMap.values().iterator();
			while(iterador.hasNext())
				count += iterador.next();
			linea += String.format("%5s%s", count, ":");
			iter2 = lineNumberMap.entrySet().iterator();
			while (iter2.hasNext()) {
				Map.Entry<Integer, Integer> e2 = iter2.next();
				linea += String.format("%5s%s", e2.getKey(), "("+e2.getValue()+")");
			}
			if (iter.hasNext())
				linea += "\n";
			output += linea;
		}

		return output;
	}

}

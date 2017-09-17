package org.eda1.actividadesSeptiembre.actividad04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SimilarWords {

	public List<String> readWords(String stringArchivoEntrada) {
		ArrayList<String> al = new ArrayList<String>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(
					stringArchivoEntrada)));
			while (br.ready())
				al.add(br.readLine());
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return al;
	}

	public Map<Integer, Integer> computeDistributionOfDictionary(
			List<String> words) {
		TreeMap<Integer, Integer> mapa = new TreeMap<Integer, Integer>();

		for (String str : words) {
			if (mapa.containsKey(str.length()))
				mapa.put(str.length(), mapa.get(str.length()) + 1);
			else
				mapa.put(str.length(), 1);
		}

		return mapa;
	}

	// Devuelve true si word1 y word2 tienen la misma longitud y difieren en un
	// único carácter
	private static boolean oneCharOff(String word1, String word2) {
		if (word1.length() != word2.length())
			return false;
		int countFails = 0;
		for (int i = 0; i < word1.length(); i++) {
			if (word1.charAt(i) != word2.charAt(i))
				countFails++;
			if (countFails > 1)
				return false;
		}
		return true;
	}

	// Actualiza el mapa
	private static <KeyType> void update(Map<KeyType, List<String>> m,
			KeyType key, String value) {

		List<String> temp;
		if (m.get(key) != null)
			temp = m.get(key);
		else
			temp = new ArrayList<String>();

		temp.add(value);
		m.put(key, temp);
	}

	// Calcula un mapa en el que las claves son palabras y los valores listas de
	// palabras que difieren en
	// un único carácter de la clave correspondiente. Utiliza un algoritmo
	// cuadrático de fuerza bruta
	public static Map<String, List<String>> computeSimilarWordsBruteForce(
			List<String> theWords) {
		TreeMap<String, List<String>> mapa = new TreeMap<String, List<String>>();

		for (String str : theWords) {
			for (String str2 : theWords) {
				if (!str.equals(str2)) {
					if (oneCharOff(str, str2))
						update(mapa, str, str2);
				}
			}
		}

		return mapa;
	}

	// Calcula un mapa en el que las claves son palabras y los valores listas de
	// palabras que difieren en
	// un único caracter de la clave correspondiente. Utiliza un algoritmo
	// cuadrático, pero mejora y
	// hace más rápido al anterior con un mapa adicional y agrupando palabras
	// por su longitud
	public static Map<String, List<String>> computeSimilarWordsImproved(
			List<String> theWords) {

		TreeMap<Integer, List<String>> mapaAux = new TreeMap<Integer, List<String>>();
		TreeMap<String, List<String>> mapa = new TreeMap<String, List<String>>();

		for (String str : theWords) {
			if (mapaAux.get(str.length()) == null) {
				List<String> list = new ArrayList<String>();
				list.add(str);
				mapaAux.put(str.length(), list);
			} else {
				List<String> list = mapaAux.get(str.length());
				list.add(str);
				mapaAux.put(str.length(), list);
			}
		}

		for (Map.Entry<Integer, List<String>> entry : mapaAux.entrySet()) {
			mapa.putAll(computeSimilarWordsBruteForce(entry.getValue()));
		}

		return mapa;
	}

	// Calcula un mapa en el que las claves son palabras y los valores listas de
	// palabras que difieren en
	// un único caracter de la clave correspondiente. Utiliza un algoritmo
	// eficiente que es O(N log N),
	// con un TreeMap o O(N) si lo que se utiliza es un HashMap
	public static Map<String, List<String>> computeSimilarWords(
			List<String> words) {
		TreeMap<Integer, List<String>> mapaAux = new TreeMap<Integer, List<String>>();
		TreeMap<String, List<String>> mapa = new TreeMap<String, List<String>>();

		for (String str : words) {
			if (mapaAux.get(str.length()) == null) {
				List<String> list = new ArrayList<String>();
				list.add(str);
				mapaAux.put(str.length(), list);
			} else {
				List<String> list = mapaAux.get(str.length());
				list.add(str);
				mapaAux.put(str.length(), list);
			}
		}

		for (Map.Entry<Integer, List<String>> entry : mapaAux.entrySet()) {
			for (int i = 0; i < entry.getKey(); i++) {
				TreeMap<String, List<String>> mapaTemp = new TreeMap<String, List<String>>();
				for (String str : entry.getValue()) {
					String strRepr = "";
					for (int j = 0; j < entry.getKey(); j++) {
						if (i != j)
							strRepr += str.charAt(j);
					}
					List<String> list;
					if (mapaTemp.get(strRepr) == null) {
						list = new ArrayList<String>();
					} else {
						list = mapaTemp.get(strRepr);
					}
					list.add(str);
					mapaTemp.put(strRepr, list);
				}
				for (Map.Entry<String, List<String>> entradas : mapaTemp
						.entrySet()) {
					for (String stri : entradas.getValue()) {
						for (String stri2 : entradas.getValue()) {
							if (!stri.equals(stri2)) {
								List<String> list;
								if (mapa.get(stri) == null) {
									list = new ArrayList<String>();
								} else {
									list = mapa.get(stri);
								}
								list.add(stri2);
								mapa.put(stri, list);
							}
						}
					}
				}
			}
		}

		return mapa;
	}

	// Dado el mapa que contiene palabras como clave y como valor una lista de
	// palabras que difieren
	// en un único carácter, devolver un mapa con las palabras que tienen
	// minNumberOfSimilarWords
	// o más palabras obtenidas por la sustitución de un carácter en ella

	public Map<String, Integer> findHighChangeables(
			Map<String, List<String>> mapSimilarWords, int i) {

		TreeMap<String, Integer> mapa = new TreeMap<String, Integer>();

		for (Map.Entry<String, List<String>> entry : mapSimilarWords.entrySet()) {
			int sizeOfList = entry.getValue().size();
			if (sizeOfList >= i) 
					mapa.put(entry.getKey(), sizeOfList);
		}

		return mapa;
	}

	// Encontrar la palabra más intercambiable, que es aquella palabra que
	// difiere en sólo un carácter
	// con la mayoría de las palabras. Devolvería una lista de esas palabras en
	// caso de empate
	public List<String> findMostChangeable(
			Map<String, List<String>> mapSimilarWords) {
		List<String> list = new ArrayList<String>();
		int max = 0;
		for(Map.Entry<String, List<String>> entry : mapSimilarWords.entrySet()){
			if(entry.getValue().size() > max){
				max = entry.getValue().size();
				list = new ArrayList<String>();
				list.add(entry.getKey());
			}else if(entry.getValue().size() == max)
				list.add(entry.getKey());
		}
		
		return list;
	}
	/**
	 * Imprime en un String la palabra más intercambiable con sus respectivas palabras
	 * @param mostChangeable Lista con la/las palabra/s más intercambiables
	 * @param mapSimilarWords Mapa con todas las parablas intercambiables y sus respectivas palabras
	 * @return
	 */
	public String showMostChangeables(List<String> mostChangeable,
			Map<String, List<String>> mapSimilarWords) {
		String output = "";
		
		for(String str : mostChangeable){
			output += str+":";
			for(String string : mapSimilarWords.get(str)){
				output += " "+string+"\n";
			}
			output += " ("+ mapSimilarWords.get(str).size() + " words)"+ "\n";
		}
		
		return output;
	}

}

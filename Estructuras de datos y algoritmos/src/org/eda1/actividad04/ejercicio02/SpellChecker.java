package org.eda1.actividad04.ejercicio02;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class SpellChecker {
	protected TreeSet<String> dictionarySet;
	protected TreeSet<String> documentSet;
	/**
	 * Constructor SpellChecker. 
	 * Instancia el nuevo objeto inicializando sus variables dictionarySet y documentSet
	 */
	public SpellChecker() {
		dictionarySet = new TreeSet<String>();
		documentSet = new TreeSet<String>();
	}
	/**
	 * A�ade la palabra word al diccionario de sinonimos
	 * @param word palabra a a�adir
	 */
	public void addToDictionary(String word) {
		if(word != null && word.length() > 1)
			dictionarySet.add(word.toLowerCase());
	}
	/**
	 * A�ade todas las palabras de la LinkedList al diccionario.
	 * @param additionalWords LinkedList con las palabras a a�adir
	 */
	public void addToDictionary(LinkedList<String> additionalWords) {
		Iterator<String> iterador = additionalWords.iterator();
		while(iterador.hasNext())
			addToDictionary(iterador.next().toLowerCase());
	}
	/**
	 * A�ade nueva linea al documento
	 * @param line linea a a�adir
	 */
	public void addToDocument(String line) {
		if(line != null && line.length() > 1)
			documentSet.add(line.toLowerCase());
	}
	/**
	 * Compara todas las palabras del documento con el diccionario, comprobando as� que palabras del documento no est�n en el diccionario.
	 * @return Devuelve LinkedList con la lista de palabras que no eten en el diccionario
	 */
	public LinkedList<String> compare() {
		LinkedList<String> output = new LinkedList<String>();
		Iterator<String> iterador = documentSet.iterator();
		String temp;
		while(iterador.hasNext()){
			temp = iterador.next(); 
			if(!dictionarySet.contains(temp))
				output.add(temp);
		}
		
		return output;
	}
	/**
	 * Devuelve LinkedList con todas las palabras del diccionario
	 * @return LinkedList con las palabas del diccionario
	 */
	public LinkedList<String> dictionaryToList() {
		LinkedList<String> output = new LinkedList<String>();
		Iterator<String> iterador = dictionarySet.iterator();
		
		while(iterador.hasNext())
			output.add(iterador.next());
		
		return output;
	}
	/**
	 * Devuelve todo el texto del documento en una LinkedList.
	 * @return LinkedList con el texto del documento
	 */
	public LinkedList<String> documentToList() {
		LinkedList<String> output = new LinkedList<String>();
		Iterator<String> iterador = documentSet.iterator();
		
		while(iterador.hasNext())
			output.add(iterador.next());
		
		return output;
	}
	/**
	 * Comprueba si word esta en el diccionario
	 * @param word palabra a comprobar
	 * @return True si est�, false en caso contrario
	 */
	public boolean isInDictionary(String word) {	
		return dictionarySet.contains(word);
	}
	/**
	 * Devuelve el tama�o del diccionario
	 * @return int tama�o diccionario
	 */
	public int sizeDictionary() {
		return dictionarySet.size();
	}
}

package org.eda1.actividad04.ejercicio02;


import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SpellCheckerTester {
	
	protected SpellChecker spellChecker;
	/**
	 * Constructor SpellCheckerTester
	 */
	public SpellCheckerTester(){
		spellChecker = new SpellChecker();
	}
	/**
	 * Extiende el diccionario a�adiendo todas las palabras del LinkedList pasado por parametro
	 * @param wordsNoInDictionary LinkedList con palabras a a�adir
	 */
	public void extendDictionary(LinkedList<String> wordsNoInDictionary){
		spellChecker.addToDictionary(wordsNoInDictionary);			
	}
	/**
	 * Carga el archivo diccionario con la ruta pasada por parametro, almacenando todas las palbras en el diccionario del spellChecker 
	 * @param fileName ruta del archivo diccionario
	 */
	public void loadDictionary(String fileName){
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
			while(br.ready())
				spellChecker.addToDictionary(br.readLine());
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}	
	}
	/**
	 * Carga el documento con la ruta pasada por parametro, a�adiendo todo el texto de �ste al documento spellChecker
	 * @param fileName
	 */
	public void loadDocument(String fileName){
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
			String aux = "";
			String[] temp;
			while(br.ready())
				aux += br.readLine();
			br.close();
			
			aux = aux.replace("...", " ");
			aux = aux.replace(".", " ");
			aux = aux.replace(",", " ");
			aux = aux.replace(":", " ");
			temp = aux.split(" ");
			for(int i=0; i<temp.length;i++){
				spellChecker.addToDocument(temp[i]);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	/**
	 * @See spellChecker.compare()
	 * @return LinkedList con la lista de palabras que no eten en el diccionario
	 */
	public LinkedList<String> showDifferences(){
		return spellChecker.compare();
	}
	/**
	 * Comprueba si la palbra word esta en el diccionario
	 * @param word palabra a comprobar
	 * @return True en caso positivo, false en caso contrario
	 */
	public boolean isInDictionary(String word){
		return spellChecker.isInDictionary(word);
	}
	/**
	 * Devuelve el tama�o del diccionario de spellChecker
	 * @return int tama�o diccionario
	 */
	public int sizeDictionary(){
		return spellChecker.sizeDictionary();
	}
}

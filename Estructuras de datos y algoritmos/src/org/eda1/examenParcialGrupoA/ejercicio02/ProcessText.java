package org.eda1.examenParcialGrupoA.ejercicio02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.eda1.estructurasdedatos.AVLTree;


// TODO: Auto-generated Javadoc
/**
 * The Class ProcessText.
 */
public class ProcessText {

	/** The avl words. */
	AVLTree<WordFrequency> avlWords;
	
	/**
	 * Instantiates a new process text.
	 */
	public ProcessText(){
		avlWords=new AVLTree<WordFrequency>();
	}
	
	/**
	 * Instantiates a new process text.
	 *
	 * @param avl the avl
	 */
	public ProcessText(AVLTree<WordFrequency> avl){
		avlWords=avl;
	}
	
	/**
	 * Gets the frecuency of word.
	 *
	 * @param palabra the palabra
	 * @return the frecuency of word
	 */
	public int getFrecuencyOfWord(String palabra) {
		WordFrequency aux=new WordFrequency(palabra);
		if (avlWords.contains(aux))
			return avlWords.find(aux).getFrequency();
		return 0;
	}

	/**
	 * Gets the words with frequency.
	 *
	 * @param i the i
	 * @return the words with frequency
	 */
	public ArrayList<String> getWordsWithFrequency(int i) {
		ArrayList<String> vector=new ArrayList<String>();
		Iterator<WordFrequency> iter=avlWords.iterator();
		while (iter.hasNext()){
			WordFrequency aux=iter.next();
			if (aux.getFrequency()==i)
				vector.add(aux.getWord());
		}
		return vector;
	}
	
	/**
	 * Removes the special characters.
	 *
	 * @param input the input
	 * @return the string
	 */
	public String removeSpecialCharacters(String input) {
		String specialChart = ",.;:_()[]{}<>*+-/=%&$|'\"^¿?!¡0123456789";
		String output = input;
		for (int i = 0; i < specialChart.length(); i++) {
			output = output.replace(String.valueOf(specialChart.charAt(i)), "");
		}
		return output.toLowerCase();
	}

	/**
	 * Load file.
	 *
	 * @param inputFile the input file
	 * @return the aVL tree
	 */
	public AVLTree<WordFrequency> loadFile(String inputFile) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(inputFile));
			WordFrequency aux;
			String cadena = "";
			String[] vector;
			while ((cadena = in.readLine()) != null) {
				cadena=removeSpecialCharacters(cadena);
				vector=cadena.split(" ");
				for (int i = 0; i < vector.length; i++) {
					aux=new WordFrequency(vector[i]);
						if (avlWords.contains(aux))
							avlWords.find(aux).incrementFrequency();
						else	
							avlWords.add(aux);
				}
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return avlWords;
	}

}

package org.eda1.examenSegundoParcialGrupoA.ejercicio01;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Thesaurus {
	protected TreeMap<String, TreeSet<String>> thesaurusMap;
	/**
	 * Constructor Thesaurus
	 */
	public Thesaurus() {
		thesaurusMap = new TreeMap<String, TreeSet<String>>();
	}
	
	public Thesaurus(TreeMap<String,TreeSet<String>> t){
		thesaurusMap = t;
	}
	/**
	 * Procesa una linea en formato: "palabra sinonimo1 sinonimo2 etc..." añadiendo la palabra con sus sinonimos al Thesaurus
	 * Tambien añade cada sinonimo como palabra siguiendo el criterio del ExamenSegundoParcialGrupoA 
	 * @param line String con el contenido a añadir
	 */
	public void add(String line) {
			String[] temp = line.split(" ");
	
			for(int i=1; i<temp.length; i++)
				add(temp[0], temp[i]);
			
			for(int i=1; i<temp.length;i++){
				for(int j=1; j<temp.length;j++){
					if(i != j){
						//añadimos palabra base
						if(!thesaurusMap.containsKey(temp[i]))
							add(temp[i], temp[0]);
						else
							if(j == 1)
								add(temp[i], temp[0]);	

						add(temp[i],temp[j]);
					}
					
				}
			}

	}
	/**
	 * Añade el sinonimo synonym a la palabra word.
	 * Si la palabra no estaba en el Thesaurus se añade primero.
	 * @param word palabra a la cual se añadira un sinonimo	
	 * @param synonym sinonimo a añadir
	 */
	public void add(String word, String synonym) {
		
		if(!thesaurusMap.containsKey(word)){
			thesaurusMap.put(word, new TreeSet<String>());
		}
		
		if(thesaurusMap.get(word).isEmpty()){
		TreeSet<String> ts = new TreeSet<String>();
		ts.add(synonym);
		thesaurusMap.put(word, ts);
		}else
			thesaurusMap.get(word).add(synonym);
		
	}
	/**
	 * Elimina una palabra(key) y sus sinonimos del Thesaurus
	 * Ademas, elimina la palabra de los conjuntos de sinonimos de otras palabras.
	 * @param word key del objeto a eliminar
	 * @return Devuelve los sinonimos de la palabra eliminada. TreeSet<String>
	 */
	public TreeSet<String> remove(String word) {
		TreeSet<String> temp;
		for(Map.Entry<String, TreeSet<String>> entry : thesaurusMap.entrySet()){
			if(entry.getValue().contains(word)){
				temp = entry.getValue();
				temp.remove(word);
				entry.setValue(temp);
			}
		}
		return thesaurusMap.remove(word);
	}
	/**
	 * Elimina el sinonimo pasado por parametro de la palabra pasada por parametro
	 * @param word palabra de la cual se eliminara un sinonimo
	 * @param synonym sinonimo a eliminar
	 * @return
	 */
	public boolean remove(String word, String synonym) {
		return thesaurusMap.get(word).remove(synonym);
	}
	/**
	 * Actualiza los sinonimos de la palabra word. Elimina todos los sinonimos anteriores y añade todos los incluidos en la LinkedList synonyms
	 * @param word palabra a la cual se actualizaran sus sinonimos
	 * @param synonyms LinkedList con los nuvos sinonimos a asignar
	 * @return Devuelve TreeSet con los nuevos sinonimos ya establecidos
	 */
	public TreeSet<String> update(String word, LinkedList<String> synonyms) {
		thesaurusMap.remove(word);
		Iterator<String> iterador = synonyms.iterator();
		while(iterador.hasNext())
			add(word,iterador.next());
		return thesaurusMap.get(word);
	}
	/**
	 * Devuelve el numero de palabras almacenada en el Thesaurus
	 * @return int tamaño
	 */
	public int size() { 
		return thesaurusMap.size();
	}
	/**
	 * Devuelve todos los sinonimos de la palabra word. 
	 * @param word palabra de la cual se devolveran los sinonimos
	 * @return Devuelve TreeSet con los sinonimos de word
	 */
	public TreeSet<String> getSynonymous(String word) {
		return thesaurusMap.get(word);
	}
	/**
	 * Devuelve el numero de sinonimos de la palabra word
	 * @param word palabra de la cual se devolvera el numero de sinonimos
	 * @return int numero sinonimos
	 */
	public int size(String word) {
		if(!thesaurusMap.containsKey(word))
			return -1;
		return thesaurusMap.get(word).size();
	}
	/**
	 * Comprueba si synonym es sinonimo de word
	 * @param word palabra de la cual se comprobara si contiene synonym
	 * @param synonym sinonimo a comprobar si esta presente en word
	 * @return true en caso positivo, false en caso contrario
	 */
	public boolean isSynonymousOf(String word, String synonym) {
		if(!thesaurusMap.containsKey(word))
			return false;
		return thesaurusMap.get(word).contains(synonym);
	}
	/**
	 * Comprueba si el sinonimo pasado por parametro esta presente en Thesaurus
	 * @param synonym sinonimo a comprobar si esta
	 * @return true en caso positivo, false en caso contrario
	 */
	public boolean isSynonymous(String synonym) {
		return thesaurusMap.containsValue(synonym);
	}	
	/** 
	 * Comprueba si la palabra word tiene algún sinonimo
	 * @param word palabra a comprobar
	 * @return True en caso positivo, flase en caso contrario.
	 */
	public boolean hasSynonymous(String word) { 
		if(thesaurusMap.get(word) == null)
			return false;
		return thesaurusMap.get(word).size() != 0;
	}
	/**
	 * Devuelve todo el contenido del Thesaurus en formato String
	 * @return String con el contenido del Thesaurus
	 */
	public String showThesaurus() { 
		return thesaurusMap.toString();
	}
	/**
	 * Devuelve todo el contenido del Thesaurus en formato String
	 * @return String con el contenido del Thesaurus
	 */
	public String toString(){
		return showThesaurus();
	}
	
}
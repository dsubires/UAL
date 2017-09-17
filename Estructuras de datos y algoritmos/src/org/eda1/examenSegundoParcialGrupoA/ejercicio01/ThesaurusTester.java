package org.eda1.examenSegundoParcialGrupoA.ejercicio01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class ThesaurusTester {
	
	protected Thesaurus thesaurus;
	
	public ThesaurusTester(){
		thesaurus = new Thesaurus();
	}
	
	public ThesaurusTester(Thesaurus t){
		thesaurus = t;
	}
	
	public void constructThesaurus(String fileName){
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
			while(br.ready()){
				thesaurus.add(br.readLine());
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	public void printSynonyms(){
		
	}
	
	public String showThesaurus(){
		return thesaurus.showThesaurus();
	}
	
	public void add(String line){
			thesaurus.add(line);
	}
	
	public void add(String line, String synonym){
		thesaurus.add(line, synonym);
	}
	
	public TreeSet<String> remove(String word){
		return thesaurus.remove(word);
	}
	
	public boolean remove(String word, String synonym){
		return thesaurus.remove(word, synonym);
	}
	
	public TreeSet<String> update(String word, LinkedList<String> synonyms){
		return thesaurus.update(word, synonyms);
	}
	
	public int size(){
		return thesaurus.size();
	}
	
	public TreeSet<String> getSynonymous(String word){
		return thesaurus.getSynonymous(word);
	}
	
	public int size(String word){
		return thesaurus.size(word);
	}
	
	public boolean isSynonymousOf(String word, String synonym){
		return thesaurus.isSynonymousOf(word, synonym);
	}
	
	public boolean isSynonymous(String synonymous){
		return thesaurus.isSynonymous(synonymous);
	}
	
	public boolean hasSynonymous(String word){
		return thesaurus.hasSynonymous(word);
	}

	public String toString(){
		return thesaurus.toString();
	}
	//ToDo
	public ThesaurusTester subThesaurus(String min, String max) {
		if(min.compareTo(max) > 0)
			return null;
		SortedMap<String, TreeSet<String>> sMap =  thesaurus.thesaurusMap.subMap(min, max);
		TreeMap<String,TreeSet<String>> map = new TreeMap<String,TreeSet<String>>();
		
		for(Map.Entry<String, TreeSet<String>> entry : sMap.entrySet())
			map.put(entry.getKey(), entry.getValue());
		
		return new ThesaurusTester(new Thesaurus( map ));
	}
}

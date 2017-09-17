package org.eda1.practica02.ejercicio03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

import org.eda1.estructurasdedatos.AVLTree;

// TODO: Auto-generated Javadoc
/**
 * The Class CorrectorOrtografico.
 */
public class CorrectorOrtografico {

	/** The tree palabras. */
	private AVLTree<String> treePalabras;
	
	
	/**
	 * Instantiates a new corrector ortografico.
	 */
	public CorrectorOrtografico(){
		treePalabras = new AVLTree<String>();
	}
	
	/**
	 * Instantiates a new corrector ortografico.
	 *
	 * @param tree the tree
	 */
	public CorrectorOrtografico(AVLTree<String> tree){
		treePalabras = tree;
	}
	
	/**
	 * Carga diccionario en AVLTree desde el archivo pasado por paramtero
	 *
	 * @param archivo ruta al archivo desde donde se cargara el diccionario
	 * @return diccionario de palabras
	 */
	public AVLTree<String> cargarDiccionario(String archivo){
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(archivo))) ;
			while(br.ready())
				treePalabras.add(br.readLine());
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}	
		return treePalabras;
	}
	
	/**
	 * Almacena en disco el diccionario de palabras cargado en memoria 
	 * @param archivo archivo donde se almacenara el diccionario
	 */
	public void guardarDiccionario(String archivo){
		try {
			PrintWriter pw =  new PrintWriter(new File(archivo));
			Iterator<String> iterador = treePalabras.iterator();
			while(iterador.hasNext())
				pw.println(iterador.next());
			pw.close();
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Devuelve el minimo de los tres numeros pasados por parametro
	 *
	 * @param a numero a
	 * @param b numero b
	 * @param c numero c
	 * @return el menor
	 */
	private int minimo(int a, int b, int c){
		if(a<=b && a<= c)
			return a;
		if(b<=a && b<=c)
			return b;
		return c;
	}
	
	/**
	 * Crea un array de caracteres con el contenido de cada palabra y sobre estos ejecuta el Algoritmo Compute Levenshtein distance. 
	 *
	 * @param str1 the str1
	 * @param str2 the str2
	 * @return the int
	 */
	public int computeLevenshteinDistance(String str1, String str2){
		char[] vStr1 = new char[str1.length()], vStr2 = new char[str2.length()];
		for(int i=0; i<vStr1.length;i++)
			vStr1[i] = str1.charAt(i);
		for(int j=0; j<vStr2.length;j++)
			vStr2[j] = str2.charAt(j);
		
		return computeLevenshteinDistance(vStr1, vStr2);
		
	}
	
	/**
	 * Algoritmo Compute Levenshtein distance.
	 * Evalua la distancia de dos palabras -->(El número de operaciones necesarias[insertar,eliminar,..] sobre str2 para que sea igual a str1
	 *
	 * @param str1 the str1
	 * @param str2 the str2
	 * @return the int
	 */
	private int computeLevenshteinDistance(char[] str1, char[] str2){
		int[][] distancia = new int[str1.length+1][str2.length+1];
		
		for(int i=0; i<=str1.length;i++)
			distancia[i][0] = i;
		for(int j=0; j <= str2.length;j++)
			distancia[0][j] = j;
		
		for(int i=1; i <= str1.length;i++ ){
			for(int j=1; j <= str2.length;j++){
				distancia[i][j] = minimo(distancia[i-1][j]+1, distancia[i][j-1]+1,distancia[i-1][j-1] + ((str1[i-1] ==str2[j-1]) ?0:1));
			}
		}

		return distancia[str1.length][str2.length];
	}
	
	/**
	 * Devuelve una lista de palabras parecidas para la palabra pasada por parametro, con la distancia maxima (entre esta y cada palabra de la lista) menor que la pasada por parametro
	 *
	 * @param max distancia maxima entre palabra y sugerencias
	 * @param plabra palabra sobre la cual se buscaran sugerencias
	 * @return lista de palabras sugerencias
	 */
	public ArrayList<String> listaSugerencias(int max, String plabra){
		ArrayList<String> lista = new ArrayList<String>();
		DistanceComparator comparator = new DistanceComparator();
		PriorityQueue<PalabraDistancia> cola = new PriorityQueue<PalabraDistancia>(10,comparator);
		
		String palabraTemp;
		PalabraDistancia pd1 = new PalabraDistancia(plabra, max),pd2;
		Iterator<String> iterador = treePalabras.iterator();
		while(iterador.hasNext()){
			palabraTemp = iterador.next();
			pd2 = new PalabraDistancia(palabraTemp, computeLevenshteinDistance(plabra, palabraTemp));
			if(comparator.compare(pd1, pd2) > 0)
				cola.add(pd2);
		}
		
		while(!cola.isEmpty())
			lista.add(cola.remove().getPalabra());
		
		return lista;
		
	}
	
	/**
	 * Adds the palabra.
	 *
	 * @param palabra the palabra
	 */
	public void addPalabra(String palabra){
		if(!find(palabra))
			add(palabra);
	}
	
	/**
	 * Contains palabra.
	 *
	 * @param palabra the palabra
	 * @return true, if successful
	 */
	public boolean containsPalabra(String palabra){
		return treePalabras.contains(palabra);
	}
	
	/**
	 * Size.
	 *
	 * @return the int
	 */
	public int size(){
		return treePalabras.size();
	}
	
	/**
	 * Adds the.
	 *
	 * @param palabra the palabra
	 * @return true, if successful
	 */
	public boolean add(String palabra){
		return treePalabras.add(palabra);
	}
	
	/**
	 * Find.
	 *
	 * @param palabra the palabra
	 * @return true, if successful
	 */
	public boolean find(String palabra){
		return treePalabras.contains(palabra);
	}
}

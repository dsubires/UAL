package Practica03;

import java.util.ArrayList;
import java.util.TreeSet;

public class Prueba {

	private static ArrayList<String> x;
	private static TreeSet<String> aux;
	
	public static void main (String []args) {
		ArrayList<String> l = new ArrayList<String> ();
		l.add("1");
		l.add("2");
		l.add("3");
		x = new ArrayList<String> ();
		aux = new TreeSet<String> ();
		aux.add(x.toString());
		escribirTodos(0, l);
		System.out.println(aux.toString());
		System.out.println(x.toString());
		System.out.println(l.toString());
	}

	private static void escribirTodos(int pos, ArrayList<String> l) {
		for (int i=pos; i<l.size(); i++) {
			x.add(l.get(pos));
			aux.add(x.toString());
			escribirTodos(pos+1, l);
			x.remove(l.get(pos));
			escribirTodos(pos+1, l);
		}
	}
	
}

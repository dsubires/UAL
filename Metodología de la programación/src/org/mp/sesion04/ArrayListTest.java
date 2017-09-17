package org.mp.sesion04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class ArrayListTest.
 */
public class ArrayListTest {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		List<Integer> arrayList = new ArrayList<Integer>();
		
		for (int i = 0; i< 20; i++)
			arrayList.add((Integer)i);
		
		Iterator<Integer> iterador = arrayList.iterator();
		
		while (iterador.hasNext())
			System.out.println("Elemento del arrayList: " + iterador.next().toString());
	}

}

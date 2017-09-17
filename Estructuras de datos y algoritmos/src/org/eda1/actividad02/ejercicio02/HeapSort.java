package org.eda1.actividad02.ejercicio02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import org.eda1.actividad02.ejercicio01.Heap;

public class HeapSort<T> {

	public static <T> void sortHeap(ArrayList<T> aList, Comparator<T> comp) {
		int n = aList.size();
		Heap<T> vHeap = new Heap<T>(n, comp);
		// pasamos los valores del ArrayList al Heap
		for (int i = 0; i < n; i++)
			vHeap.add(aList.remove(0));

		// valores de vuelta al ArrayList, ordenados
		while (!vHeap.isEmpty())
			aList.add(vHeap.removeMin());

	}

	private static <T> void siftDown(ArrayList<T> aList, int first, int last,
			Comparator<T> comp) {
		int parent = first, child = (parent << 1) + 1;

		while (child < last) {
			if (child < last - 1
					&& comp.compare(aList.get(child), aList.get(child + 1)) > 0)
				child++;
			if (comp.compare(aList.get(parent), aList.get(child)) < 0)
				break;

			T aux = aList.get(parent);
			aList.set(parent, aList.get(child));
			aList.set(child, aux);

			parent = child;
			child = (parent << 1) + 1;
		}
	}

	public static <T> void heapSort(ArrayList<T> aList, Comparator<T> comp) {
		// aplicamos siftDown a los padres
		int n = aList.size();
		for (int i = n >> 2; i >= 0; i--) {
			siftDown(aList, i, n - 1, comp);
		}
		// intercambiamos y reparamos
		for (int i = n; i > 1; i--) {
			T aux = aList.get(0);
			aList.set(0, aList.get(i - 1));
			aList.set(i - 1, aux);

			siftDown(aList, 0, i - 1, comp);
		}
		Collections.reverse(aList);
	}

}

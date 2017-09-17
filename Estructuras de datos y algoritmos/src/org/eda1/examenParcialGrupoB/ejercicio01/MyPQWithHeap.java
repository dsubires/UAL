package org.eda1.examenParcialGrupoB.ejercicio01;

import java.util.Comparator;

// TODO: Auto-generated Javadoc
/**
 * The Class MyPQWithHeap.
 *
 * @param <T> the generic type
 */
public class MyPQWithHeap<T> implements MyPriorityQueue<T> {

	/** The heap. */
	private Heap<T> heap;
	
	
	/**
	 * Instantiates a new my pq with heap.
	 */
	public MyPQWithHeap() {
		this.heap = new Heap<T>();
	}
	
	/**
	 * Instantiates a new my pq with heap.
	 *
	 * @param comp the comp
	 */
	public MyPQWithHeap( Comparator<T> comp) {
		this.heap= new Heap<T>(comp);
	} 
	
	/**
	 * Instantiates a new my pq with heap.
	 *
	 * @param i the i
	 * @param comp the comp
	 */
	public MyPQWithHeap(int i, Comparator<T> comp){
		this.heap=new Heap<T> (i,comp);
	}
	
	/* (non-Javadoc)
	 * @see org.eda1.examenParcialGrupoB.ejercicio01.MyPriorityQueue#size()
	 */
	@Override
	public int size() {
		return heap.size();
	}

	/* (non-Javadoc)
	 * @see org.eda1.examenParcialGrupoB.ejercicio01.MyPriorityQueue#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return heap.isEmpty();
	}

	/* (non-Javadoc)
	 * @see org.eda1.examenParcialGrupoB.ejercicio01.MyPriorityQueue#add(java.lang.Object)
	 */
	@Override
	public void add(T element) {
		heap.add(element);
	}

	/* (non-Javadoc)
	 * @see org.eda1.examenParcialGrupoB.ejercicio01.MyPriorityQueue#peek()
	 */
	@Override
	public T peek() {
		return heap.getMin();
	}

	/* (non-Javadoc)
	 * @see org.eda1.examenParcialGrupoB.ejercicio01.MyPriorityQueue#poll()
	 */
	@Override
	public T poll() {
		return heap.removeMin();
	}
}

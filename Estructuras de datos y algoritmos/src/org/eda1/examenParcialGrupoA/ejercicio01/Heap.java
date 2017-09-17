/*
 * 
 */
package org.eda1.examenParcialGrupoA.ejercicio01;

import java.util.*;

/**
 * Clase Heap. Clase parametrizada. Hace referencia a un monticulo de elementos
 * 
 * @param <T>
 *            tipo parametrizado.
 */
public class Heap<T> {

	/** The Constant DEFAULT_INITIAL_CAPACITY. */
	protected static final int DEFAULT_INITIAL_CAPACITY = 7;

	/** The heap. */
	protected ArrayList<T> theHeap;

	/** The comparator. */
	protected Comparator<T> comparator;

	/**
	 * Inicializa el Heap a una capacidad inicial de initialCapacity, y con
	 * elementos que están ordenados por un objeto Comparator dado.
	 * 
	 * @param initialCapacity
	 *            - Capacidad inicial para el Heap.
	 * @param comp
	 *            - el objeto Comparator.
	 * 
	 */
	public Heap(int initialCapacity, Comparator<T> comp) {
		if (initialCapacity < 1)
			throw new IllegalArgumentException();
		theHeap = new ArrayList<T>(initialCapacity);
		comparator = comp;
	} // constructor con una capacidad inicial y un Comparator

	/**
	 * Inicializa el Heap con una capacidad inicial por defecto
	 * DEFAULT_INITIAL_CAPACITY y con elementos en una clase que implemente la
	 * interfaz Comparable.
	 */
	public Heap() {
		this(DEFAULT_INITIAL_CAPACITY, null);
	} // constructor por defecto

	/**
	 * Inicializa el Heap a una capacidad inicial de initialCapacity, y con
	 * elementos en una clase que implementa la interface Comparable.
	 * 
	 * @param initialCapacity
	 *            - la capacidad inicial del Heap.
	 */
	public Heap(int initialCapacity) {
		this(initialCapacity, null);
	} // constructor con una capacidad inicial

	/**
	 * Inicializa el Heap a una capacidad inicial de initialCapacity, y con
	 * elementos comparados según el objeto Comparator comp.
	 * 
	 * @param comp
	 *            - el objeto Comparator utilizado para comparar elementos en el
	 *            Heap
	 * 
	 */
	public Heap(Comparator<T> comp) {
		this(DEFAULT_INITIAL_CAPACITY, comp);
	} // constructor con parámetro Comparator

	/**
	 * Inicializa este Heap con un objeto Heap pasado por parámetro Los
	 * elementos en este Heap se compararán como se especifiquen en el objeto
	 * Heap que se pasa como parámetro The worstTime(n) is O(n), donde n es el
	 * número de elementos en el Heap pasado como parámetro.
	 * 
	 * @param otherHeap
	 *            - el Heap que se va a copiar en en objeto heap actual
	 * 
	 */
	public Heap(Heap<T> otherHeap) {
		theHeap = new ArrayList<T>(otherHeap.theHeap);
		comparator = otherHeap.comparator;
	} // constructor copia

	/**
	 * Devuelve el número de elementos en el Heap.
	 * 
	 * @return número de elementos que hay en este Heap.
	 */
	public int size() {
		return theHeap.size();
	} // metodo size

	/**
	 * Determina si el Heap no tiene elementos (está vacio).
	 * 
	 * @return true - si el heap no tiene elementos, en otro caso false;
	 * 
	 */
	public boolean isEmpty() {
		return theHeap.isEmpty();
	} // método isEmpty

	/**
	 * Inserta un elemento en el Heap. The worstTime(n) is O(n) and
	 * averageTime(n) is constant.
	 * 
	 * @param element
	 *            - el elemento que va a ser insertado en el Heap
	 * 
	 */
	public void add(T element) {
		theHeap.add(element);
		siftUp();
	} // metodo add

	/**
	 * Restaura las propiedades del Heap, empezando desde el final hasta la raiz
	 * 
	 * The worstTime(n) is O(log n), and averageTime(n) is constant.
	 * 
	 */
	protected void siftUp() {
		int child = theHeap.size() - 1, parent;

		while (child > 0) {
			parent = (child - 1) >> 1; // >> 1 is slightly faster than / 2
										// => parent = (child - 1) / 2
			if (compare(theHeap.get(child), theHeap.get(parent)) >= 0)
				break;
			swap(parent, child);
			child = parent;
		}
	} // metodo siftUp

	/**
	 * Compara dos elementos dados según Comparable o un objeto Comparator.
	 * 
	 * @param element1
	 *            - uno de los elementos a comparar.
	 * @param element2
	 *            - el otro elemento a comparar.
	 * @return un entero negativo, 0, o un entero positivo, dependiendo de si
	 *         element1 es menor que, igual a o mayor que element2.
	 */
	@SuppressWarnings("unchecked")
	protected int compare(T element1, T element2) {
		return (comparator == null ? ((Comparable<T>) element1)
				.compareTo(element2) : comparator.compare(element1, element2));
		// if (comparator == null )
		// return ((Comparable<T>)element1).compareTo(element2);
		// else
		// return comparator.compare(element1, element2);
	} // metodo compare

	/**
	 * Intercambia dos elementos del Heap (parent y child).
	 * 
	 * @param parent
	 *            - el índice del elemento padre (parent).
	 * @param child
	 *            - el índice del elemento hijo (child).
	 * 
	 */
	protected void swap(int parent, int child) {
		T temp = theHeap.get(parent);
		theHeap.set(parent, theHeap.get(child));
		theHeap.set(child, temp);
	} // metodo swap

	/**
	 * Devuelve el elemento con el menor valor del Heap.
	 * 
	 * @return el elemento con el menor valor del Heap.
	 */
	public T getMin() {
		if (theHeap.isEmpty())
			throw new NoSuchElementException("Heap removeMin(): empty heap");

		return theHeap.get(0);
	} // metodo getMin

	/**
	 * Elimina el elemento con el menor valor del Heap. The worstTime(n) is
	 * O(log n).
	 * 
	 * @return el elemento eliminado.
	 */
	public T removeMin() {
		if (theHeap.isEmpty())
			throw new NoSuchElementException("Heap removeMin(): empty heap");

		T minElem = theHeap.get(0);
		theHeap.set(0, theHeap.get(theHeap.size() - 1));
		theHeap.remove(theHeap.size() - 1);
		siftDown(0);
		return minElem;
	} // metodo removeMin

	/**
	 * Restaura las propiedades del Heap (hundir) The worstTime(n) is O(log n).
	 * 
	 * @param start
	 *            - el índice del Heap donde va a empezar la restauración de la
	 *            propiedad.
	 * 
	 */
	protected void siftDown(int start) {
		int parent = start, child = (parent << 1) + 1; // parent << 1 is
														// slightly faster than
														// parent * 2
														// => (2 * parent) + 1

		while (child < theHeap.size()) {
			if (child < theHeap.size() - 1
					&& compare(theHeap.get(child), theHeap.get(child + 1)) > 0)
				child++; // child is the right child (child = (2 * parent) + 2)
			if (compare(theHeap.get(child), theHeap.get(parent)) >= 0)
				break;
			swap(parent, child);
			parent = child;
			child = (parent << 1) + 1; // => child = (2 * parent) + 1
		}
	} // function siftDown

	/**
	 * Metodo assign. Metodo que inserta en la posicion i de nuestra lista, el
	 * elemento parametrizado valor.
	 * 
	 * @param i
	 *            , varible de tipo int, hace referencia a la posición dentro de
	 *            nuestra lista.
	 * @param valor
	 *            , variable parametrizada, hace referencia al elemento a
	 *            insertar en nuestra lista.
	 */
	public void assign(int i, T valor) {
		theHeap.add(i, valor);

	}

	/**
	 * Metodo isHeap. Metodo que comprueba si se trata de un heap.
	 * 
	 * @return un boolean, devuelve true si es un heap, y false si no lo es.
	 */
	public boolean isHeap() {
		// Variables.

		int child, parent = 0;

		// Cuerpo.

		while (parent <= theHeap.size() / 2 - 1) {
			child = parent * 2 + 1;
			// Comprobamos que el padre sea menor siempre que sus 2 hijos
			if ((compare(theHeap.get(parent), theHeap.get(child)) > 0)
					&& (compare(theHeap.get(parent), theHeap.get(child + 1)) > 0))
				return false;
			else
				parent++;
		}

		// Retorno.

		return true;
	}

	/**
	 * Metodo makeHeap. Metodo que transforma una lista (ArrayList) en un heap.
	 */
	public void makeHeap() {
		// Variables.

		int n = theHeap.size();

		// Cuerpo.

		for (int i = (n / 2) - 1; i >= 0; i--)
			siftDown(i);

	}

	/**
	 * Metodo increaseKey. Metodo que incrementa el valor del elemento de la
	 * posicion pasada por parametro, sumada al valor pasado por parametro.
	 * 
	 * @param pos
	 *            , variable de tipo int. Hace referencia al elemento a
	 *            modificar.
	 * 
	 * @param valor
	 *            , variable de tipo Integer. Hace referencia al valor a sumar
	 *            al elemento indicado.
	 * 
	 * @return boolean, si cumple las condiciones de ser una posicion valida
	 *         dentro de la lista y ser un numero posito, devuelve true, en caso
	 *         contrario devuelve false.
	 */
	@SuppressWarnings("unchecked")
	public boolean increaseKey(int pos, Integer valor) {
		if (valor > 0 && pos >= 0 && pos <= theHeap.size() - 1) {// Comprobamos....
			Integer nuevoValor = (Integer) theHeap.get(pos) + valor;// Realiamos
																	// la suma
			theHeap.set(pos, (T) nuevoValor);// Modificamos el valor
			siftDown(pos);// Restablecemos el heap desde la posicion
							// modificada...
			return true;
		}
		return false;
	}

	/**
	 * Metod getValue. Metodo que devuelve el valor del elemento de la posicion
	 * pasada por parametro.
	 * 
	 * @param i
	 *            , variable de tipo int. Hace referencia a la posicion del
	 *            elemento de nuestra lista.
	 * 
	 * @return un valor de tipo Integer, correspondiente al valor numero del
	 *         elemento en cuestion.
	 */
	public Integer getValue(int i) {
		return (Integer) theHeap.get(i);
	}

	/**
	 * Metodo decreaseKey. Metodo que decrementa el valor del elemento de la
	 * posicion pasada por parametro, el valor pasado por parametro.
	 * 
	 * @param pos
	 *            , variable de tipo int. Hace referencia al elemento a
	 *            modificar.
	 * @param valor
	 *            , variable de tipo Integer. Hace referencia al valor a restar
	 *            al elemento indicado.
	 * @return boolean, si cumple las condiciones de ser una posicion valida
	 *         dentro de la lista y ser un numero posito tanto el valor a restar
	 *         como el resultado de la resta, devuelve true, en caso contrario
	 *         devuelve false.
	 */
	@SuppressWarnings("unchecked")
	public boolean decreaseKey(int pos, Integer valor) {
		if (valor > 0 && pos >= 0 && pos <= theHeap.size() - 1) {// Comprobamos...
			Integer nuevoValor = (Integer) theHeap.get(pos) - valor;// Restamos...
			if (nuevoValor >= 0) {// Comprobamos....
				theHeap.set(pos, (T) nuevoValor);// Modificamos el valor
				siftUp(pos);// Restablecemos el heap desde la posicion
							// modificada...
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo siftUp (flotar). Metodo que comprueba que los hijos sean menores
	 * que los padres, intercambiando padres por hijos en el caso de no
	 * cumplirse.
	 * 
	 * @param pos
	 *            , variable de tipo int. Hace referencia a la posicion dentro
	 *            del heap, que empieza a comprobar.
	 */
	protected void siftUp(int pos) {
		// Variables.

		int child = pos, parent;

		// Cuerpo.

		while (child > 0) {
			parent = (child - 1) >> 1; // >> 1 is slightly faster than / 2
										// => parent = (child - 1) / 2
			if (compare(theHeap.get(child), theHeap.get(parent)) >= 0)
				break;// Comprobamos que el hijo sea mayor que el padre...
			swap(parent, child);// Si no es asi, intercambiamos los valores
			child = parent; // Ahora el hijo es el nuevo padre...
		}
	} // metodo siftUp(inicio)

	/**
	 * Metodo replaceKey. Metodo que cambia el valor del elemento de la posicion
	 * pasada por parametro, el valor pasado por parametro.
	 * 
	 * @param pos
	 *            , variable de tipo int. Hace referencia al elemento a
	 *            modificar.
	 * @param valor
	 *            , variable de tipo parametrizado. Hace referencia al nuevo
	 *            elemento que estara en la posicion indicada
	 * @return boolean, si cumple las condiciones de ser una posicion valida
	 *         dentro de la lista y ser un numero posito el valor del nuevo
	 *         elemento, devuelve true, en caso contrario devuelve false.
	 */
	public boolean replaceKey(int pos, T valor) {
		if ((Integer) valor > 0 && pos >= 0 && pos <= theHeap.size() - 1) {// Comprobamos...
			int temp = (Integer) theHeap.get(pos);// Asignamos el valor a una
													// variable temporal
			theHeap.set(pos, valor);// Cambiamos el elemento
			if (temp > (Integer) theHeap.get(pos))// Comprobamos para flotar o
													// hundir...
				siftUp(pos);
			else
				siftDown(pos);
			return true;
		}
		return false;
	}

	/**
	 * Metodo delete. Metodo que elimina el elemento pasado por parametro de
	 * nuestro heap.
	 * 
	 * @param pos
	 *            , variable de tipo int. Hace referencia al elemento a
	 *            eliminar.
	 * 
	 * @return boolean, si cumple las condiciones de ser una posicion valida
	 *         dentro de la lista, devuelve true, en caso contrario devuelve
	 *         false.
	 */
	public boolean delete(int pos) {
		if (pos >= 0 && pos < theHeap.size() - 1) {// Comprobamos que sea una
													// posicion valida...
			decreaseKey(pos, (Integer) theHeap.get(pos));// Decrementamos por el
															// total del valor
			removeMin();// Eliminamos...
			return true;
		}
		return false;

	}

	/**
	 * Metodo branchMinSum. Metodo que devuelve un String, con un determinado
	 * formato con, la suma de la rama menor, con la secuencia desde los hijos
	 * hasta el padre.
	 * 
	 * @return cadena, variable de tipo String. Hace referencia al String con la
	 *         informacion antes indicada.
	 */
	public String branchMinSum() {

		// Variables.

		int parent = 0;
		int ramaMinima = 0;
		int ramaActual = 0;
		String cadenaMinima = "";
		String cadenaActual = "";

		// Cuerpo.

		// Comprobamos cada una de las ramas, tomando como inicio todos los
		// elementos que son hojas
		for (int hijoActual = theHeap.size() - 1; hijoActual >= (theHeap.size() - 1) / 2; hijoActual--) {
			if (hijoActual % 2 == 0)
				parent = (hijoActual / 2) - 1;
			else
				parent = hijoActual / 2;
			ramaActual = (Integer) theHeap.get(hijoActual);
			// Variable para los valores de la rama
			cadenaActual = "" + theHeap.get(hijoActual) + " ";
			// Variable para el String de la rama

			// Vamos subiendo hasta el inicio del heap acumulando valores a las
			// 2 variables anteriores
			while (parent >= 0) {
				ramaActual += (Integer) theHeap.get(parent);
				cadenaActual += theHeap.get(parent) + " ";
				if (parent % 2 == 0)
					parent = (parent / 2) - 1;
				else
					parent = parent / 2;
			}
			if (hijoActual == theHeap.size() - 1)
				ramaMinima = ramaActual;
			if (ramaMinima > ramaActual) {
				ramaMinima = ramaActual;
				cadenaMinima = cadenaActual;
			}// Comprobamos cual de las ramas ha sido menor, para devolver el
				// String correspondiente a la menor.
		}

		// Retorno.

		return "<" + (Integer) ramaMinima + "> --- " + cadenaMinima;
	}

	/**
	 * Metodo toString. Metodo que devuelve un String con un determinado formato
	 * del heap.
	 */
	@Override
	public String toString() {
		// Variables.
		String cadena = "[";

		// Cuerpo.
		for (T actual : theHeap)
			if (actual.equals(theHeap.get(theHeap.size() - 1)))
				cadena += actual + "]";
			else
				cadena += actual + ", ";
		// Retorno.
		return cadena;
	}

	/**
	 * Metodo sumValuesOfBranches. Metodo que devuelve una lista con todos los
	 * valores de las ramas del heap de menor a mayor.
	 * 
	 * @return salida. Variable de tipo ArrayList<Integer>. Hace referencia a la
	 *         lista con los resultados de las ramos del heap.
	 */
	public ArrayList<Integer> sumValuesOfBranches() {
		ArrayList<Integer> salida = new ArrayList<Integer>();
		int parent = 0;

		// Comprobamos cada una de las ramas, tomando como inicio todos los
		// elementos que son hojas
		for (int hijoActual = theHeap.size() - 1; hijoActual > (theHeap.size() - 1) / 2; hijoActual--) {
			int ramaActual = 0;
			if (hijoActual % 2 == 0)
				parent = (hijoActual / 2) - 1;
			else
				parent = hijoActual / 2;
			ramaActual += (Integer) theHeap.get(hijoActual);

			// Vamos subiendo hasta el inicio del heap acumulando valores a las
			// 2 variables anteriores
			while (parent >= 0) {
				ramaActual += (Integer) theHeap.get(parent);
				if (parent % 2 == 0)
					parent = (parent / 2) - 1;
				else
					parent = parent / 2;
			}
			salida.add(0, ramaActual);
		}
		return salida;
	}

} // class Heap


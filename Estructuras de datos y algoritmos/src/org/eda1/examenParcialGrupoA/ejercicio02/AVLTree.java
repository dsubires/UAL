/*
/ Universidad de Almeria
/ Grado Ingenieria de Informatica
/
/ ACTIVIDAD : Numero 3 Documentacion en Javadoc - 
 * Arboles Binarios de Busqueda: BSTree-AVLTree-RBTree-AVLTreeJCF
/ ASIGNATURA : Estructuras de Datos y Algoritmos 1.
/  
 */

package org.eda1.examenParcialGrupoA.ejercicio02;

import java.util.NoSuchElementException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.IllegalStateException;
import java.util.ConcurrentModificationException;

import org.eda1.estructurasdedatos.ALStack;
import org.eda1.estructurasdedatos.BinarySearchTree;
import org.eda1.estructurasdedatos.Collection;
import org.eda1.estructurasdedatos.Iterator;

// TODO: Auto-generated Javadoc
/**
 * The Class AVLTree. This class is a balanced binary tree that implements the
 * Collection interface AVL tree single and double rotation methods.
 * 
 * @param <T>
 *            the generic type
 * @see RBTree
 */

public class AVLTree<T> implements Collection<T>, Iterable<T>, Serializable,
		BinarySearchTree<T> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The leftheavy. */
	private static int LEFTHEAVY = 1;

	/** The balanced. */
	private static int BALANCED = 0;

	/** The rightheavy. */
	private static int RIGHTHEAVY = -1;
	// reference to tree root
	/** The root. */
	private AVLNode<T> root;

	// number of elements in the tree
	/** The tree size. */
	private int treeSize;

	// increases whenever the tree changes. used by an iterator
	// to verify that it is in a consistent state
	/** The mod count. */
	private int modCount;

	// delete the tree with a postorder scan of the nodes
	/**
	 * Delete tree.
	 * 
	 * @param t
	 *            the t
	 */
	private void deleteTree(AVLNode<T> t) {
		// if current root node is not null, delete its left
		// subtree, its right subtree and then set the node to null
		if (t != null) {
			deleteTree(t.left);
			deleteTree(t.right);
			t = null;
		}
	}

	// iteratively traverse a path from the root to the node
	// whose value is item; return a reference to the node
	// containing item or null if the search fails
	/**
	 * Find node.
	 * 
	 * @param item
	 *            the item
	 * @return the aVL node
	 */
	private AVLNode<T> findNode(Object item) {
		// t is current node in traversal
		AVLNode<T> t = root;
		int orderValue;

		// terminate on on empty subtree
		while (t != null) {
			// compare item and the current node value
			orderValue = ((Comparable<T>) item).compareTo(t.nodeValue);

			// if a match occurs, return true; otherwise, go left
			// or go right following search tree order
			if (orderValue == 0)
				return t;
			else if (orderValue < 0)
				t = t.left;
			else
				t = t.right;
		}
		return null;
	}

	/**
	 * Metodo AVLTree. Metodo Construcctor de la clase. Todos los elementos
	 * insertados en el arbol deben implementar la interface <tt>Comparable</tt>
	 * .
	 */
	public AVLTree() {
		root = null;
		modCount = 0;
		treeSize = 0;
	}

	/**
	 * Adds the specified item to this tree if it is not already present.
	 * 
	 * @param item
	 *            element to be added to this tree.
	 * @return <tt>true</tt> if the tree did not already contain the specified
	 *         element.
	 */
	public boolean add(T item) {
		try {
			root = addNode(root, item);
		} catch (IllegalStateException ise) {
			return false;
		}
		// increment the tree size and modCount
		treeSize++;
		modCount++;
		// we added a node to the tree
		return true;
	}

	/**
	 * Metodo addNode. Metodo que inserta un nuevo nodo en nuestro arbol
	 * AVLTree. Realiza una busqueda recursiva buscando el lugar a insertar, y
	 * tras la actualizacion del factor de equilibrio, realiza las oportunas
	 * rotaciones para rebalancear el arbol si fuese necesario.
	 * 
	 * @param t
	 *            , variable de tipo AVLNode<T>. Hace referencia al nodo raiz
	 *            del arbol/sub-arbol sobre el que se quiere realizar la
	 *            insercion del nodo.
	 * 
	 * @param item
	 *            , variable parametrizada, es el elemento a insertar en nuestro
	 *            arbol AVLTree.
	 * 
	 * @return t, variable de tipo AVLNode<T>. Hace referencia al nodo raiz del
	 *         arbol/sub-arbol, sobre el que se ha insertado el elemento
	 *         parametrizado en nuestro arbol AVLTree.
	 */
	private AVLNode<T> addNode(AVLNode<T> t, T item) {
		if (t == null)
			// Si esta vacia la raiz del arbol/sub-arbol.
			t = new AVLNode<T>(item);
		else
		// Si el elemento es menor, busca por la rama izquierda
		if (((Comparable<T>) item).compareTo(t.nodeValue) < 0) {
			t.left = addNode(t.left, item);
			// Comprueba que haya que realizar alguna rotacion
			if (height(t.left) - height(t.right) == 2)
				if (((Comparable<T>) item).compareTo(t.left.nodeValue) < 0)
					t = singleRotateRight(t);
				else
					t = doubleRotateRight(t);
		} else
		// Si el elemento es mayor, busca por la rama derecha
		if (((Comparable<T>) item).compareTo(t.nodeValue) > 0) {
			t.right = addNode(t.right, item);
			// Comprueba que haya que realizar alguna rotacion
			if (height(t.left) - height(t.right) == -2)
				if (((Comparable<T>) item).compareTo(t.right.nodeValue) > 0)
					t = singleRotateLeft(t);
				else
					t = doubleRotateLeft(t);
		} else
			// duplicate; throw IllegalStateException
			throw new IllegalStateException();
		// Modifica la altura hasta la raiz.
		t.height = max(height(t.left), height(t.right)) + 1;

		return t;
	}

	/**
	 * Metodo remove. Metodo que elimina un elemento del arbol AVLTree.
	 * 
	 * @param item
	 *            , variable de tipo Object. Hace referencia al elemento a
	 *            eliminar del arbol AVLTree.
	 * @return boolean. Dependiendo si el elemento ha sido eliminado o no,
	 *         devolvera true o false.
	 */
	public boolean remove(Object item) {

		if (item == null)
			return false;
		try {
			root = remove(root, (T) item);
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}

	/**
	 * Removes the.
	 * 
	 * @param t
	 *            the t
	 * @param item
	 *            the item
	 * @return the aVL node
	 */
	private AVLNode<T> remove(AVLNode<T> t, T item) {
		// Si esta vacio, no se puede eliminar nada.
		if (t == null)
			throw new IllegalArgumentException("Element " + item
					+ " is not present.");
		// Si el elemento es menor, busca por la rama izquierda
		if (((Comparable<T>) item).compareTo(t.nodeValue) < 0) {
			t.left = remove(t.left, item);
			if (height(t.right) - height(t.left) == 2)
				if (height(t.right.right) >= height(t.right.left))
					t = singleRotateLeft(t);
				else
					t = doubleRotateLeft(t);

		} else
		// Si el elemento es mayor, busca por la rama derecha
		if (((Comparable<T>) item).compareTo(t.nodeValue) > 0) {
			t.right = remove(t.right, item);
			if (height(t.left) - height(t.right) == 2) {
				if (height(t.left.left) >= height(t.left.right))
					t = singleRotateRight(t);
				else
					t = doubleRotateRight(t);
			}
		} else
			// Si no es ni por la izq ni por la der, es que estoy en el nodo a
			// eliminar
			return removeNode(t);
		// Modifica la altura hasta la raiz.
		t.height = Math.max(height(t.left), height(t.right)) + 1;
		return t;
	}

	/**
	 * Removes the node.
	 * 
	 * @param removalNode
	 *            the removal node
	 * @return the aVL node
	 */
	private AVLNode<T> removeNode(AVLNode<T> removalNode) {

		AVLNode<T> replacementNode;

		if (removalNode.left != null && removalNode.right != null) {
			replacementNode = findMin(removalNode.right);

			removalNode.right = removeMin(removalNode.right);

			replacementNode.left = removalNode.left;
			replacementNode.right = removalNode.right;

			if (height(replacementNode.left) - height(replacementNode.right) == 2) {
				if (height(replacementNode.left.left) >= height(replacementNode.left.right)) {
					replacementNode = singleRotateRight(replacementNode);
				} else {
					replacementNode = doubleRotateRight(replacementNode);
				}
			}

			replacementNode.height = Math.max(height(replacementNode.left),
					height(replacementNode.right)) + 1;
		} else {
			replacementNode = (removalNode.left != null) ? removalNode.left
					: removalNode.right;

			treeSize--;
		}

		removalNode.left = null;
		removalNode.right = null;

		return replacementNode;
	}

	/**
	 * Removes the min.
	 * 
	 * @param t
	 *            the t
	 * @return the aVL node
	 */
	private AVLNode<T> removeMin(AVLNode<T> t) {
		// Si es nulo
		if (t == null)
			return null;
		if (t.left == null) {
			treeSize--;
			return t.right;
		}
		t.left = removeMin(t.left);
		
		if (height(t.right) - height(t.left) == 2)
			if (height(t.right.right) >= height(t.right.left))
				t = singleRotateLeft(t);
			else
				t = doubleRotateLeft(t);
		t.height = Math.max(height(t.left), height(t.right)) + 1;
		return t;
	}

	/**
	 * Find min.
	 * 
	 * @param t
	 *            the t
	 * @return the aVL node
	 */
	private AVLNode<T> findMin(AVLNode<T> t) {

		if (t.left == null) {
			return t;
		}

		return findMin(t.left);
	}

	/**
	 * Height.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param t
	 *            the t
	 * @return the int
	 */
	private static <T> int height(AVLNode<T> t) {
		if (t == null)
			return -1;
		else
			return t.height;
	}

	/**
	 * Max.
	 * 
	 * @param a
	 *            the a
	 * @param b
	 *            the b
	 * @return the int
	 */
	private static int max(int a, int b) {
		if (a > b)
			return a;
		else
			return b;
	}

	// perform a single right rotation for parent p
	/**
	 * Single rotate right.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param p
	 *            the p
	 * @return the aVL node
	 */
	private static <T> AVLNode<T> singleRotateRight(AVLNode<T> p) {
		AVLNode<T> lc = p.left;

		p.left = lc.right;
		lc.right = p;
		p.height = max(height(p.left), height(p.right)) + 1;
		lc.height = max(height(lc.left), lc.height) + 1;

		return lc;
	}

	// perform a single left rotation for parent p
	/**
	 * Single rotate left.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param p
	 *            the p
	 * @return the aVL node
	 */
	private static <T> AVLNode<T> singleRotateLeft(AVLNode<T> p) {
		AVLNode<T> rc = p.right;

		p.right = rc.left;
		rc.left = p;
		p.height = max(height(p.left), height(p.right)) + 1;
		rc.height = max(height(rc.right), rc.height) + 1;

		return rc;
	}

	// perform a double right rotation for parent p
	/**
	 * Double rotate right.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param p
	 *            the p
	 * @return the aVL node
	 */
	private static <T> AVLNode<T> doubleRotateRight(AVLNode<T> p) {
		p.left = singleRotateLeft(p.left);
		return singleRotateRight(p);
	}

	// perform a single left rotation for parent p
	/**
	 * Double rotate left.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param p
	 *            the p
	 * @return the aVL node
	 */
	private static <T> AVLNode<T> doubleRotateLeft(AVLNode<T> p) {
		p.right = singleRotateRight(p.right);
		return singleRotateLeft(p);
	}

	/**
	 * Removes all of the elements from this tree. The resulting tree is empty
	 * after the method executes.
	 */
	public void clear() {
		deleteTree(root);
		root = null;
		treeSize = 0;
	}

	/**
	 * Returns <tt>true</tt> if this tree contains the specified element.
	 * 
	 * @param item
	 *            the object to be checked for containment in this tree.
	 * @return <tt>true</tt> if this tree contains the specified element.
	 */
	public boolean contains(Object item) {
		AVLNode<T> t = findNode(item);
		return (t == null) ? false : true;
	}

	/**
	 * Returns <tt>true</tt> if this tree contains no elements.
	 * 
	 * @return <tt>true</tt> if this tree contains no elements.
	 */
	public boolean isEmpty() {
		return treeSize == 0;
	}

	/**
	 * Returns an iterator over the elements in this tree. The elements are
	 * returned in ascending order.
	 * 
	 * @return an iterator over the elements in this tree.
	 */
	public Iterator<T> iterator() {
		return new TreeIterator(root);
	}

	/**
	 * Returns the number of elements in this tree.
	 * 
	 * @return the number of elements in this tree.
	 */
	public int size() {
		return treeSize;
	}

	/**
	 * Returns an array containing all of the elements in this tree. The order
	 * of elements in the array is the iterator order of elements in the tree
	 * 
	 * @return an array containing all of the elements in this tree
	 */
	public Object[] toArray() {
		Object[] arr = new Object[treeSize];
		Iterator iter = iterator();
		int i = 0;

		while (iter.hasNext()) {
			arr[i] = iter.next();
			i++;
		}

		return arr;
	}

	/**
	 * Returns a string representation of this tree. The representation is a
	 * comma separated list in iterator order enclosed in square brackets.
	 * 
	 * @return the string
	 */
	public String toString() {
		int i;

		// create the return string object
		String returnStr = "[";
		Iterator iter = this.iterator();

		// output values separated by commas
		for (i = 0; i < treeSize; i++) {
			returnStr += iter.next();
			if (i < treeSize - 1)
				returnStr += ", ";
		}
		returnStr += "]";

		// return the string
		return returnStr;
	}

	/**
	 * Searches for the specified item in the tree and returns the value of the
	 * node that matches item as a key.
	 * 
	 * @param item
	 *            serves as a key to locate an element in the tree..
	 * @return the value of the node that corresponds to item as a key or
	 *         <tt>null</tt> if the element is not found.
	 */
	public T find(T item) {
		AVLNode<T> t = findNode(item);
		T value = null;

		if (t != null)
			value = t.nodeValue;

		return value;
	}

	/**
	 * The Class TreeIterator.
	 */
	private class TreeIterator implements Iterator<T> {

		/** The stack. */
		private ALStack<AVLNode<T>> stack = null;

		/** The curr. */
		private AVLNode<T> curr = null;

		/** The last returned. */
		private AVLNode<T> lastReturned = null;

		// set expectedModCount to the number of list changes
		// at the time of iterator creation
		/** The expected mod count. */
		private int expectedModCount = modCount;

		// go far left from t, pushing all the nodes with left
		// children on stack
		/**
		 * Go far left.
		 * 
		 * @param t
		 *            the t
		 * @return the aVL node
		 */
		private AVLNode<T> goFarLeft(AVLNode<T> t) {
			if (t == null)
				return null;
			while (t.left != null) {
				stack.push(t);
				t = t.left;
			}
			return t;
		}

		/**
		 * Instantiates a new tree iterator.
		 * 
		 * @param root
		 *            the root
		 */
		public TreeIterator(AVLNode<T> root) {
			stack = new ALStack<AVLNode<T>>();
			curr = goFarLeft(root);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eda1.estructurasdedatos.Iterator#hasNext()
		 */
		public boolean hasNext() {
			return curr != null;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eda1.estructurasdedatos.Iterator#current()
		 */
		public T current() {
			return lastReturned.nodeValue;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eda1.estructurasdedatos.Iterator#next()
		 */
		public T next() {
			// check that the iterator is in a consistent state.
			// throws ConcurrentModificationException if not
			checkIteratorState();

			if (curr == null)
				throw new NoSuchElementException("No elements remaining");

			// capture the value in the node
			T returnValue = (T) curr.nodeValue;

			lastReturned = curr;

			if (curr.right != null) // have a right subtree
				// stack nodes on left subtree
				curr = goFarLeft(curr.right);
			else if (!stack.isEmpty())
				// no right subtree there are other nodes
				// to visit. pop the stack
				curr = (AVLNode<T>) stack.pop();
			else
				curr = null; // end of tree; set curr to null

			return returnValue;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eda1.estructurasdedatos.Iterator#remove()
		 */
		public void remove() {
			// no implementation
		}

		// protected so MiniListIteratorImpl class can use it also
		/**
		 * Check iterator state.
		 */
		private void checkIteratorState() {
			if (expectedModCount != modCount)
				throw new ConcurrentModificationException(
						"Inconsistent iterator");
		}
	}

	// declares a binary search tree node object
	/**
	 * The Class AVLNode.
	 * 
	 * @param <T>
	 *            the generic type
	 */
	private static class AVLNode<T> implements Serializable {
		// node data
		/** The node value. */
		public T nodeValue;

		// child links and link to the node's parent
		/** The right. */
		public AVLNode<T> left, right;

		// public int height;
		/** The height. */
		public int height;

		// constructor that initializes the value, balance factor
		// and parent fields and sets the link fields left and
		// right to null
		/**
		 * Instantiates a new aVL node.
		 * 
		 * @param item
		 *            the item
		 */
		public AVLNode(T item) {
			nodeValue = item;
			left = null;
			right = null;
			height = 0;
		}
	}

	/**
	 * Metodo height. Metodo que devuelve la altura maxima de un arbol AVLTree
	 * de forma recursiva.
	 * 
	 * @return Variable de tipo int. Hace referencia a la maxima altura de los
	 *         elementos hojas de nuestro arbol AVLTree.
	 */
	public int height() {
		if (root == null)
			return -1;
		else
			return (Math.max(height(root.left), height(root.right))) + 1;
	}

	/**
	 * Metodo pathHeigt. Metodo que devuelve la altura de un elemento dentro de
	 * nuestro arbol AVLTree.
	 * 
	 * @param x
	 *            . Variable parametrizada. Hace referencia al elemento de
	 *            nuestro arbol sobre el que queremos conocer su altura.
	 * @return Variable de tipo int. Hace referencia a la altura de dicho
	 *         elemento dentro de nuestro arbol AVLTree.
	 */
	public int pathHeight(T x) {
		if (findNode(x) == null)
			return -1;
		AVLNode<T> aux = root;
		int valor, altura = 0;
		while (aux != null) {
			valor = ((Comparable<T>) x).compareTo(aux.nodeValue);
			if (valor == 0)
				return altura;
			else if (valor < 0) {
				aux = aux.left;
				altura++;
			} else {
				aux = aux.right;
				altura++;
			}
		}
		return altura;
	}

	/**
	 * Metodo writeObject. Metodo que serializa en disco un arbol. Realiza la
	 * escritura en el archivo de datos, todos los elementos de un arbol.
	 * 
	 * @param out
	 *            . Variable de tipo ObjectOutputStream. Hace referencia al
	 *            buffer de escritura en disco, con la informacion de la ruta
	 *            destino sobre el archivo que se escribiran los elementos de
	 *            nuestro arbol AVLTree.
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private void writeObject(ObjectOutputStream out) throws java.io.IOException {
		out.defaultWriteObject();
		// write out the necessary elements of the collection
		out.writeInt(treeSize);
		out.writeInt(modCount);

		TreeIterator iter = (TreeIterator) this.iterator();
		while (iter.hasNext()) {
			out.writeObject(iter.next());
		}

		// Object[] aux=toArray();
		// for (int i = 0; i < aux.length; i++) {
		// out.writeObject(aux[i]);
		// }

	}

	/**
	 * Metodo readObject. Metodo que deserializa desde disco a memoria, el
	 * contenido de los elementos de un archivo y los pasa a un arbol AVLTree.
	 * 
	 * @param in
	 *            . Variable de tipo ObjectInputStream. Hace referencia al
	 *            buffer de lectura desde disco, con la informacion de los
	 *            elementos que deseamos insertar en nuestro arbol AVLTree.
	 * @throws IOException
	 *             Controla la excepcion de cualquier posible error de
	 *             escritura.
	 * @throws ClassNotFoundException
	 *             Controla la excepcion de no encontrar la clase deseada.
	 */
	private void readObject(ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		in.defaultReadObject();
		// read the elements of the collection (using in.readObject())
		int largo = in.readInt();
		modCount = in.readInt();
		for (int i = 0; i < largo - 1; i++) {
			add((T) in.readObject());
		}
	}
	
	public T getMin(){
		return getMin(root);
	}

	private T getMin(AVLNode<T> item) {
		if (item.left!=null)
			return getMin(item.left);
		return item.nodeValue;
	}
}
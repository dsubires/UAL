/*
/ Universidad de Almeria
/ Grado Ingenieria de Informatica
/
/ ACTIVIDAD : Numero 3 Documentacion en Javadoc - 
 * Arboles Binarios de Busqueda: BSTree-AVLTree-RBTree-AVLTreeJCF
/ ASIGNATURA : Estructuras de Datos y Algoritmos 1.
/  
 */

package org.eda1.examenParcialGrupoB.ejercicio02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.lang.IllegalStateException;
import java.util.ConcurrentModificationException;
import org.eda1.estructurasdedatos.BinarySearchTree;
import org.eda1.estructurasdedatos.Collection;
import org.eda1.estructurasdedatos.Iterator;
import org.eda1.estructurasdedatos.ALStack;
import org.eda1.utilidades.Less;

// TODO: Auto-generated Javadoc
/**
 * The Class BSTree. This class implements the Collection interface using a
 * binary search tree as the underlying storage structure.
 * 
 * @param <T>
 *            the generic type
 */

public class BSTree<T> implements Collection<T>, Iterable<T>, Cloneable,
		BinarySearchTree<T> {
	// reference to tree root
	// transient
	/** The root. */
	private BSTNode<T> root;

	// number of elements in the tree
	/** The tree size. */
	private int treeSize;

	// increases whenever the tree changes. used by an iterator
	// to verify that it is in a consistent state
	/** The mod count. */
	transient private int modCount;

	// private method used by remove() and the iterator
	// remove() to delete a node
	/**
	 * Removes the node.
	 * 
	 * @param dNode
	 *            the d node
	 */
	private void removeNode(BSTNode<T> dNode) {
		if (dNode == null)
			return;

		// dNode = reference to node D that is deleted
		// pNode = reference to parent P of node D
		// rNode = reference to node R that replaces D
		BSTNode<T> pNode, rNode;

		// assign pNode as a reference to P
		pNode = dNode.parent;

		// if D has a null child, the
		// replacement node is the other child
		if (dNode.left == null || dNode.right == null) {
			if (dNode.right == null)
				rNode = dNode.left;
			else
				rNode = dNode.right;

			if (rNode != null)
				// the parent of R is now the parent of D
				rNode.parent = pNode;

			// complete the link to the parent node.

			// deleting the root node. assign new root
			if (pNode == null)
				root = rNode;
			// attach R to the correct branch of P
			else if (((Comparable<T>) dNode.nodeValue)
					.compareTo(pNode.nodeValue) < 0)
				pNode.left = rNode;
			else
				pNode.right = rNode;
		}
		// both children of dNode are non-null.
		else {
			// find and unlink replacement node for D.
			// starting at the right child of node D,
			// find the node whose value is the smallest of all
			// nodes whose values are greater than the value in D.
			// unlink the node from the tree.

			// pOfRNode is reference to parent of replacement node
			BSTNode<T> pOfRNode = dNode;

			// first possible replacement is right child of D
			rNode = dNode.right;

			// descend down left subtree of the right child of D,
			// keeping a record of current node and its parent.
			// when we stop, we have found the replacement
			while (rNode.left != null) {
				pOfRNode = rNode;
				rNode = rNode.left;
			}

			// copy the value in R to D
			dNode.nodeValue = rNode.nodeValue;

			if (pOfRNode == dNode)
				dNode.right = rNode.right;
			else
				pOfRNode.left = rNode.right;

			// the parent of the right child of R is the
			// parent of R
			if (rNode.right != null)
				rNode.right.parent = pOfRNode;

			// we want to dispose of rNode
			dNode = rNode;
		}

		// make the reference to the deleted node null
		dNode = null;
	}

	// iteratively traverse a path from the root to the node
	// whose value is item; return a reference to the node
	// containing item or null if the search fails
	/**
	 * Find node.
	 * 
	 * @param item
	 *            the item
	 * @return the bST node
	 */
	private BSTNode<T> findNode(Object item) {
		// t is current node in traversal
		BSTNode<T> t = root;
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
	 * Creates an empty binary search tree. All elements inserted into the tree
	 * must implement the <tt>Comparable</tt> interface.
	 */
	public BSTree() {
		root = null;
		modCount = 0;
		treeSize = 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eda.estructurasdatos.Tree#add(T)
	 */
	@Override
	public boolean add(T item) {
		// t is current node in traversal, parent the previous node
		BSTNode<T> t = root, parent = null, newNode;
		int orderValue = 0;

		// terminate on on empty subtree
		while (t != null) {
			// update the parent reference.
			parent = t;

			// compare item and the current node value
			orderValue = ((Comparable<T>) item).compareTo(t.nodeValue);

			// if a match occurs, return false; otherwise, go left
			// or go right following search tree order
			if (orderValue == 0)
				return false;
			else if (orderValue < 0)
				t = t.left;
			else
				t = t.right;
		}

		// create the new node
		newNode = new BSTNode<T>(item, parent);

		if (parent == null)
			// this is the first node added. make it root
			root = newNode;
		else if (orderValue < 0)
			// attach newNode as the left child of parent
			parent.left = newNode;
		else
			// attach newNode as the right child of parent
			parent.right = newNode;

		// increment the tree size and modCount
		treeSize++;
		modCount++;

		// we added a node to the tree
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eda.estructurasdatos.Tree#clear()
	 */
	@Override
	public void clear() {
		modCount++;
		treeSize = 0;
		root = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eda.estructurasdatos.Tree#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(Object item) {
		BSTNode<T> t = findNode(item);
		return (t == null) ? false : true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eda.estructurasdatos.Tree#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return treeSize == 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eda.estructurasdatos.Tree#iterator()
	 */
	@Override
	public Iterator<T> iterator() {
		return new TreeIterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eda.estructurasdatos.Tree#remove(java.lang.Object)
	 */
	@Override
	public boolean remove(Object item) {
		// search tree for item
		BSTNode<T> dNode = findNode(item);

		if (dNode == null)
			return false;

		removeNode(dNode);

		treeSize--;
		modCount++;

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eda.estructurasdatos.Tree#size()
	 */
	@Override
	public int size() {
		return treeSize;
	}

	/**
	 * Returns an array containing all of the elements in this tree. The order
	 * of elements in the array is the iterator order of elements in the tree.
	 * 
	 * @return an array containing all of the elements in this tree.
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
				// returnStr += ", ";
				returnStr += "\n"; // *** MIO ***
		}
		returnStr += "]";

		// return the string
		return returnStr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eda.estructurasdatos.Tree#find(T)
	 */

	public T find(T item) {
		BSTNode<T> t = findNode(item);
		T value = null;

		if (t != null)
			value = t.nodeValue;

		return value;
	}

	/**
	 * The Class TreeIterator.
	 */
	private class TreeIterator implements Iterator<T> {
		// set expectedModCount to the number of list changes
		// at the time of iterator creation
		/** The expected mod count. */
		private int expectedModCount = modCount;
		// node of the last value returned by next() if that
		// value was deleted by the iterator method remove()
		/** The last returned. */
		private BSTNode<T> lastReturned = null;
		// node whose value is returned a subsequent call to next()
		/** The next node. */
		private BSTNode<T> nextNode = null;

		// constructor
		/**
		 * Instantiates a new tree iterator.
		 */
		TreeIterator() {
			nextNode = root;

			// if the tree is not empty, the first node inorder is the farthest
			// node left from root
			if (nextNode != null)
				while (nextNode.left != null)
					nextNode = nextNode.left;
		}

		// returns true if the tree has more
		// unvisited elements
		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eda1.estructurasdedatos.Iterator#hasNext()
		 */
		public boolean hasNext() {
			// elements remain if nextNode is not null
			return nextNode != null;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eda1.estructurasdedatos.Iterator#current()
		 */
		public T current() {
			return lastReturned.nodeValue;
		}

		// returns the next element in the iteration.
		// throws NoSuchElementException if the iteration
		// has no more elements
		// public T next()
		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eda1.estructurasdedatos.Iterator#next()
		 */
		public T next() {
			// check that the iterator is in a consistent state.
			// throws ConcurrentModificationException if it
			// it is not
			checkIteratorState();

			// check if the iteration has an another element
			// if not, throw NoSuchElementException
			if (nextNode == null)
				throw new NoSuchElementException(
						"Iteration has no more elements");

			// save current value of next in lastReturned.
			lastReturned = nextNode;

			// set nextNode to the next node in order
			BSTNode<T> p;

			if (nextNode.right != null) {
				// successor is the furthest left node of
				// right subtree
				nextNode = nextNode.right;

				while (nextNode.left != null)
					nextNode = nextNode.left;
			} else {
				// have already processed the left subtree, and
				// there is no right subtree. move up the tree,
				// looking for a parent for which nextNode is a left child,
				// stopping if the parent becomes null. a non-null parent
				// is the successor. if parent is null, the original node
				// was the last node inorder
				p = nextNode.parent;

				while (p != null && nextNode == p.right) {
					nextNode = p;
					p = p.parent;
				}

				// if we were previously at the right-most node in
				// the tree, nextNode = null
				nextNode = p;
			}

			return lastReturned.nodeValue;
		}

		// removes the last element returned by next() from the
		// underlying collection. this method can be called only
		// once per call to next(). it is an error to modify
		// the underlying collection while the iteration is in
		// progress in any way other than by calling this method.
		// throws IllegalStateException if next() has not yet been
		// called,or remove() has already been called after the last
		// call to next()
		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eda1.estructurasdedatos.Iterator#remove()
		 */
		public void remove() {
			// check for a missing call to next() or previous()
			if (lastReturned == null)
				throw new IllegalStateException("Iterator call to next() "
						+ "required before calling remove()");

			// make sure our state is good
			checkIteratorState();

			// if lastReturned has two children, the replacement node
			// during deletion is nextNode. the value in nextNode
			// is copied to lastReturned. nextNode must be
			// lastReturned
			if (lastReturned.left != null && lastReturned.right != null)
				nextNode = lastReturned;
			removeNode(lastReturned);

			// list has been modified
			modCount++;
			expectedModCount = modCount;

			// we did a deletion. indicate this by setting lastReturned
			// to null and decrementing treeSize
			lastReturned = null;
			treeSize--;
		}

		/**
		 * Check iterator state.
		 */
		private void checkIteratorState() {
			if (expectedModCount != modCount)
				throw new ConcurrentModificationException(
						"Inconsistent iterator");
		}
	}

	/**
	 * Return a copy of this <tt>STree</tt> instance.
	 * 
	 * @return the object
	 */
	public Object clone() {
		BSTree<T> copy = null;

		try {
			copy = (BSTree<T>) super.clone();
		} catch (CloneNotSupportedException cnse) {
			throw new InternalError();
		}

		copy.root = copyTree(root);
		// return the cloned object
		return copy;
	}

	/*
	 * Uses the static method copyTree() in the class BinaryTree as a model to
	 * create a duplicate of the tree with root <tt>t</tt> and returns a
	 * reference to the root of the copied tree. In this case, the elements are
	 * STNode<T> objects
	 */
	/**
	 * Copy tree.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param t
	 *            the t
	 * @return the bST node
	 */
	private static <T> BSTNode<T> copyTree(BSTNode<T> t) {
		// newNode points at a new node that the algorithm
		// creates. newLptr. and newRptr point to the subtrees
		// of newNode
		BSTNode<T> newLeft, newRight, newNode;

		// stop the recursive scan when we arrive at empty tree
		if (t == null)
			return null;

		// build the new tree from the bottom up by building the two
		// subtrees and then building the parent. at node t, make
		// a copy of the left subtree and assign its root node reference
		// to newLeft. make a copy of the right subtree and assign its
		// root node reference to newRight
		newLeft = copyTree(t.left);
		newRight = copyTree(t.right);

		// create a new node whose value is the same as the value in t
		// and whose children are the copied subtrees
		newNode = new BSTNode<T>(t.nodeValue, null);
		newNode.left = newLeft;
		newNode.right = newRight;
		if (newLeft != null)
			newLeft.parent = newNode;
		if (newRight != null)
			newRight.parent = newNode;

		// return a reference to the root of the newly copied tree
		return newNode;
	}

	/**
	 * Returns a string that displays the elements in the binary tree using the
	 * preorder (NLR) scan. The description is a listing of elements separated
	 * by two blanks.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param t
	 *            a <tt>TNode</tt> that designates the root of the tree.
	 * @return string that contains the list of elements in the array.
	 */
	private static <T> String preorderDisplay(BSTNode<T> t) {
		// return value
		String s = "";

		// the recursive scan terminates on a empty subtree
		if (t != null) {
			s += t.nodeValue + "  "; // display the node
			s += preorderDisplay(t.left); // descend left
			s += preorderDisplay(t.right); // descend right
		}
		return s;
	}

	/**
	 * Preorder display.
	 * 
	 * @return the string
	 */
	public String preorderDisplay() {
		// return value
		return preorderDisplay(root);
	}

	/**
	 * Display tree.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param t
	 *            the t
	 * @param level
	 *            the level
	 * @return the string
	 */
	private static <T> String displayTree(BSTNode<T> t, int level) {
		String s = "";
		// the recursive scan terminates on a empty subtree
		if (t != null) {
			if (t.right != null)
				s += displayTree(t.right, level + 1);
			for (int i = 0; i < level; i++)
				s += "     ";
			s += "(" + t.nodeValue.toString() + ")[" + level + "]\n";
			if (t.left != null)
				s += displayTree(t.left, level + 1);
		}
		return s;
	}

	/**
	 * Display tree.
	 * 
	 * @return the string
	 */
	public String displayTree() {
		String s = displayTree(root, 0);
		return s;
	}

	// declares a binary search tree node object
	/**
	 * The Class BSTNode.
	 * 
	 * @param <T>
	 *            the generic type
	 */
	private static class BSTNode<T> {
		// STNode is used to implement the binary search tree class
		// making the data public simplifies building the class functions

		// node data
		/** The node value. */
		T nodeValue;

		// child links and link to the node's parent
		/** The parent. */
		BSTNode<T> left, right, parent;

		// constructor that initializes the value and parent fields and sets
		// the link fields left and right to null
		/**
		 * Instantiates a new bST node.
		 * 
		 * @param item
		 *            the item
		 * @param parentNode
		 *            the parent node
		 */
		public BSTNode(T item, BSTNode<T> parentNode) {
			nodeValue = item;
			left = null;
			right = null;
			parent = parentNode;
		}
	}

	/**
	 * Metodo toStringPreorder. Metodo que devuelve el contenido del arbol con
	 * un orden Preorder de forma recursiva.
	 * 
	 * @return String, con el contenido del arbol de forma Preorder.
	 */
	public String toStringPreorder() {
		return toStringPreorder(root);
	}

	/**
	 * Metodo toStringPreorder. Metodo que devuelve el contenido del sub-arbol
	 * con un orden Preorder de forma recursiva.
	 * 
	 * @param actual
	 *            . Variable de tipo BSTNode Hace referencia al raiz del
	 *            sub-arbol sobre el que se quiere describir el contenido.
	 * @return cadena. Variable de tipo String, con el contenido del arbol de
	 *         forma Preorder.
	 */
	private String toStringPreorder(BSTNode<T> actual) {
		String s = "";
		if (actual != null) {
			s += actual.nodeValue + "  "; // display the node
			s += toStringPreorder(actual.left); // descend left
			s += toStringPreorder(actual.right); // descend right
		}
		return s;
	}

	/**
	 * Metodo toStringPreorder. Metodo que devuelve el contenido del arbol con
	 * un orden Preorder de forma iterativa.
	 * 
	 * @return String, con el contenido del arbol de forma Preorder.
	 */
	public String toStringIterativePreorder() {
		return toStringIterativePreorder(root);
	}

	/**
	 * Metodo toStringIterativePreorder. Metodo que devuelve el contenido del
	 * sub-arbol con un orden Preorder de forma iterativa.
	 * 
	 * @param actual
	 *            . Variable de tipo BSTNode Hace referencia al raiz del
	 *            sub-arbol sobre el que se quiere describir el contenido.
	 * @return cadena, variable de tipo String, con el contenido del arbol de
	 *         forma Preorder.
	 */
	public String toStringIterativePreorder(BSTNode<T> actual) {
		ALStack<BSTNode<T>> pila = new ALStack<BSTNode<T>>();
		String cadena = "";
		if (actual != null) {
			pila.push(actual);
			while (!pila.isEmpty()) {
				actual = pila.peek();
				pila.pop();
				if ((actual.left == null) && (actual.right == null))
					cadena += actual.nodeValue + "  ";
				else {
					if (actual.right != null)
						pila.push(actual.right);
					if (actual.left != null)
						pila.push(actual.left);
					BSTNode<T> aux = new BSTNode<T>(actual.nodeValue, null);
					pila.push(aux);
				}
			}
		}
		return cadena;
	}

	/**
	 * Metodo height. Metodo que devuelve la altura de nuestro arbol.
	 * 
	 * @return Variable de tipo int. Hace referencia a la altura del arbol o
	 *         nodo raiz, de forma recursiva.
	 */
	public int height() {
		return height(root);
	}

	/**
	 * Metodo height. Metodo que devuelve la altura de nuestro sub-arbol, a
	 * partir de una nodo raiz pasado por parametro.
	 * 
	 * @param actual
	 *            . Variable de tipo BSTNode. Hace referencia al nodo raiz de
	 *            nuestro sub-arbol.
	 * @return Variable de tipo int. Hace referencia a la altura de nuestro
	 *         sub-arbol.
	 */
	private int height(BSTNode<T> actual) {
		if (actual == null)
			return -1;
		else
			return Math.max(height(actual.left), height(actual.right)) + 1;
	}

	/**
	 * Metodo numberOfLeaves. Metodo que devuelve el numero de hojas que tiene
	 * nuestro arbol de forma recursiva.
	 * 
	 * @return variable de tipo int. Hace eferencia al numero de hojas de
	 *         nuestro arbol.
	 */
	public int numberOfLeaves() {
		return numberOfLeaves(root);
	}

	/**
	 * Metodo numberOfLeaves. Metodo que devuelve el numero de hojas de un
	 * determinado sub-arbol, a partir del nodo pasado raiz pasado por
	 * parametro.
	 * 
	 * @param nivel
	 *            , Variable de tipo BSTNode. Hace referencia al nodo raiz del
	 *            sub-arbol a comprobar sus hojas.
	 * @return Variable de tipo int, con el numero de hojas que posee nuestro
	 *         sub-arbol.
	 */
	private int numberOfLeaves(BSTNode<T> nivel) {
		if (nivel == null)
			return 0;
		if ((nivel.left == null) && (nivel.right == null))
			return 1;
		else
			return numberOfLeaves(nivel.left) + numberOfLeaves(nivel.right);
	}

	/**
	 * Metodo que devuelve el elemento menor dentro de nuestro arbol BSTree de
	 * forma recursiva.
	 * 
	 * @return <T> variable parametrizada. Hace referencia al menor elemento
	 *         dentro de nuestro arbol.
	 */
	public T findMin() {
		return findMin(root).nodeValue;
	}

	/**
	 * Metodo findMin. Metodo que devuelve el menor nodo con el el elemento
	 * menor dentro de nuestro sub-arbol BSTree.
	 * 
	 * @param actual
	 *            . Variable de tipo BSTNode. Hace referencia al nodo raiz sobre
	 *            el que se realiza la busqueda del aub-arbol.
	 * @return BSTNode. Variable de tipo BSTNode. Hace referencia al nodo del
	 *         elemento menor dentro de nuestro sub-arbol BSTree.
	 */
	private BSTNode<T> findMin(BSTNode<T> actual) {
		if (actual == null)
			return null;
		if (actual.left == null)
			return actual;
		else
			return findMin(actual.left);
	}

	/**
	 * Metodo findMinIterative. Metodo que devuelve el elemento menor dentro de
	 * nuestro arbol BSTree de forma iterativa.
	 * 
	 * @return <T> Variable parametrizada. Hace referencia al menor elemento de
	 *         nuestro arbol BSTree.
	 */
	public T findMinIterative() {
		return findMinIterative(root).nodeValue;
	}

	/**
	 * Metodo findMinIterative. Metodo que devuelve el nodo con el elemento
	 * menor dentro de nuestro arbol, de forma iterativa.
	 *
	 * @param actual the actual
	 * @return BSTNode. Hace referencia al nodo con el elemento menor dentro de
	 * nuestro arbol BSTree.
	 */
	private BSTNode<T> findMinIterative(BSTNode<T> actual) {
		while (actual.left != null) {
			actual = actual.left;
		}
		return actual;
	}

	/**
	 * Metodo findMax. Metodo que devuelve el elemento mayor dntro de nuestro
	 * arbol, de forma recursiva.
	 * 
	 * @return <T> .Variable parametrizada. Hace referencia al elemento mayor
	 *         dentro de nuestro arbol BSTree.
	 */
	public T findMax() {
		return findMax(root).nodeValue;
	}

	/**
	 * Metodo findMax. Metodo que devuelve el nodo con elemento mayor dentro de
	 * nuestro sub-arbol, de forma recursiva.
	 * 
	 * @param actual
	 *            . Vsriable de tipo BSTNode. Hace referencia al nodo inical de
	 *            nuestro sub-arbol.
	 * @return BSTNode. Hace referencia al nodo con elemento mayor dentro de
	 *         nuestro arbol BSTree.
	 */
	private BSTNode<T> findMax(BSTNode<T> actual) {
		if (actual == null)
			return null;
		if (actual.right == null)
			return actual;
		else
			return findMax(actual.right);
	}

	/**
	 * Metodo findMaxIterative. Metodo que devuelve el elemento mayor dentro de
	 * nuestro arbol BSTree.
	 * 
	 * @return <T> .Variable parametrizada. Hace referencia al elemento mayor de
	 *         nuestro arbol BSTree.
	 */
	public T findMaxIterative() {
		return findMaxIterative(root).nodeValue;
	}

	/**
	 * Metodo findMaxIterative. Metodo que devuelve el nodo con el elemento
	 * mayor dentro de nuestro arbol, de forma iterativa.
	 *
	 * @param actual the actual
	 * @return BSTNode .Variable parametrizada. Hace referencia al nodo con el
	 * elemento mayor dentro de nuestro arbol BSTree.
	 */
	public BSTNode<T> findMaxIterative(BSTNode<T> actual) {
		while (actual.right != null) {
			actual = actual.right;
		}
		return actual;
	}

	/**
	 * Metodo toStringLevel. Metodo que devuelve los elementos de una
	 * determinada altura pasada por parametro.
	 * 
	 * @param i
	 *            . Variable de tipo int. Hace referencia a la altura del arbol.
	 * @return String, con el contenido del elemetos elementos de altura igual a
	 *         la altura pasado por parametro
	 */
	public String toStringLevel(int i) {
		return toStringLevel(root, i);
	}

	/**
	 * Metodo toStringLevel. Metodo que devuelve los elementos de una
	 * determinada altura pasada por parametro.
	 * 
	 * @param actual
	 *            . Variable de tipo BSTNode. Hace referencia al sub-arbol sobre
	 *            el que se van a devolver los elementos de una determinada
	 *            altura pasada por parametro.
	 * @param i
	 *            . Variable de tipo int. Hace referencia a la altura dentro del
	 *            sub-arbol pasado por parametro.
	 * @return cadena. Variable de tipo String. Hace referencia a los elementos
	 *         de una determinada altura dentro del sub-arbol.
	 */
	private String toStringLevel(BSTNode<T> actual, int i) {
		String cadena = "";
		if (actual != null)
			if (i == 0)
				cadena += actual.nodeValue + " ";
			else {
				cadena += toStringLevel(actual.left, i - 1);
				cadena += toStringLevel(actual.right, i - 1);
			}
		return cadena;
	}

	/**
	 * Metodo toStringPostorder. Metodo que devuelve el contenido del arbol con
	 * un orden Inorder de forma recursiva.
	 * 
	 * @return String, con el contenido del arbol de forma Inorder.
	 */
	public String toStringInorder() {
		return toStringInorder(root);
	}

	/**
	 * Metodo toStringInorder. Metodo que devuelve el contenido del sub-arbol
	 * con un orden Inorder de forma recursiva.
	 * 
	 * @param actual
	 *            . Variable de tipo BSTNode Hace referencia al raiz del
	 *            sub-arbol sobre el que se quiere describir el contenido.
	 * @return cadena. Variable de tipo String, con el contenido del arbol de
	 *         forma Inorder.
	 */
	private String toStringInorder(BSTNode<T> actual) {
		String cadena = "";
		if (actual != null) {
			cadena += toStringInorder(actual.left);
			cadena += actual.nodeValue + "  ";
			cadena += toStringInorder(actual.right);
		}
		return cadena;
	}

	/**
	 * Metodo toStringInorder. Metodo que devuelve el contenido del arbol con un
	 * orden Inorder de forma iterativa.
	 * 
	 * @return String, con el contenido del arbol de forma Inorder.
	 */
	public String toStringIterativeInorder() {
		return toStringIterativeInorder(root);
	}

	/**
	 * Metodo toStringIterativeInorder. Metodo que devuelve el contenido del
	 * sub-arbol con un orden Inorder de forma iterativa.
	 * 
	 * @param actual
	 *            . Variable de tipo BSTNode Hace referencia al raiz del
	 *            sub-arbol sobre el que se quiere describir el contenido.
	 * @return cadena, variable de tipo String, con el contenido del arbol de
	 *         forma Inorder.
	 */
	private String toStringIterativeInorder(BSTNode<T> actual) {
		String cadena = "";
		ALStack<BSTNode<T>> pila = new ALStack<BSTNode<T>>();
		while (!pila.isEmpty() || actual != null) {
			if (actual != null) {
				pila.push(actual);
				actual = actual.left;
			} else {
				actual = pila.pop();
				cadena += actual.nodeValue + "  ";
				actual = actual.right;
			}
		}
		return cadena;
	}

	/**
	 * Metodo toStringPostorder. Metodo que devuelve el contenido del arbol con
	 * un orden Postorder de forma recursiva.
	 * 
	 * @return String, con el contenido del arbol de forma Postorder.
	 */
	public String toStringPostorder() {
		return toStringPostorder(root);
	}

	/**
	 * Metodo toStringPostorder. Metodo que devuelve el contenido del sub-arbol
	 * con un orden Postorder de forma recursiva.
	 * 
	 * @param actual
	 *            . Variable de tipo BSTNode Hace referencia al raiz del
	 *            sub-arbol sobre el que se quiere describir el contenido.
	 * @return cadena. Variable de tipo String, con el contenido del arbol de
	 *         forma Postorder.
	 */
	private String toStringPostorder(BSTNode<T> actual) {
		String cadena = "";
		if (actual != null) {
			cadena += toStringPostorder(actual.left);
			cadena += toStringPostorder(actual.right);
			cadena += actual.nodeValue + "  ";
		}
		return cadena;
	}

	/**
	 * Metodo toStringIterativePostorder. Metodo que devuelve el contenido del
	 * arbol con un orden Postorder de forma iteractiva.
	 * 
	 * @return String, con el contenido del arbol de forma Postorder.
	 */
	public String toStringIterativePostorder() {
		return toStringIterativePostorder(root);
	}

	/**
	 * Metodo toStringIterativePostorder. Metodo que devuelve el contenido del
	 * sub-arbol con un orden Postorder de forma iterativa.
	 * 
	 * @param actual
	 *            . Variable de tipo BSTNode Hace referencia al raiz del
	 *            sub-arbol sobre el que se quiere describir el contenido.
	 * @return cadena, variable de tipo String, con el contenido del arbol de
	 *         forma Postorder.
	 */
	private String toStringIterativePostorder(BSTNode<T> actual) {
		String cadena = "";
		ALStack<BSTNode<T>> pila = new ALStack<BSTNode<T>>();
		ALStack<BSTNode<T>> pilaOrdenada = new ALStack<BSTNode<T>>();
		pila.push(actual);
		while (!pila.isEmpty()) {
			pilaOrdenada.push(pila.peek());
			BSTNode<T> hojaAux = pila.pop();
			if (hojaAux.left != null)
				pila.push(hojaAux.left);
			if (hojaAux.right != null)
				pila.push(hojaAux.right);
		}
		while (!pilaOrdenada.isEmpty())
			cadena += pilaOrdenada.pop().nodeValue + "  ";
		return cadena;
	}

	/**
	 * Metodo addBalanced. Metodo que convierte un arraylist de elementos en un
	 * arbol BSTree balanceado.
	 * 
	 * @param vector
	 *            , Varaible de tipo ArrayList. Hace referencia al array de
	 *            elementos a insertar en el arbol.
	 */
	public void addBalanced(ArrayList<T> vector) {
		Comparator<T> comp = new Less<T>();
		Collections.sort(vector, comp);
		addBalanced(vector, 0, vector.size() - 1);
	}

	/**
	 * Metodo addBalanced. Metodo que inserta en un arbol BSTree el contenido de
	 * un ArrayList, quedando dicho arbol balanceado.
	 * 
	 * @param vector
	 *            . Variable de tipo ArrayList. Hace referencia al array de
	 *            elementos que queremos insertar en nuestro arbol.
	 * @param inicio
	 *            . Varaible de tipo int. Hace referencia a la primera posicion
	 *            del array.
	 * @param fin
	 *            . Variable de tipo int. Hace rerferencia a la ultima posicion
	 *            del array.
	 */
	private void addBalanced(ArrayList<T> vector, int inicio, int fin) {
		if (fin >= inicio) {
			int medio = (fin + inicio) / 2;
			add(vector.get(medio));
			addBalanced(vector, inicio, medio - 1);
			addBalanced(vector, medio + 1, fin);
		}
	}

	/**
	 * Metodo buildSimetricTree. Metodo que devuelve un arbol simetrico al arbol
	 * actual.
	 * 
	 * @return nuevoArbol. Variable de tipo BSTree. Hace referencia a un arbol
	 *         simetro al actual.
	 */
	public BSTree<T> buildSimetricTree() {
		BSTree<T> nuevoArbol = new BSTree<T>();
		if (root != null)
			nuevoArbol.root = buildSimetricTree(root);
		return nuevoArbol;
	}

	/**
	 * Metodo buildSimetricTree. Metodo que construye un arbol simetrico a
	 * partir de un nodo BSTNode pasado por parametro.
	 * 
	 * @param actual
	 *            , Varaible de tipo BSTNode. Hace referencia al nodo inicio
	 *            sobre el que se quiere construir el simetrico.
	 * @return padre. Variable de tipo BSTNode. Hace referencia al nodo sobre el
	 *         que cuelga un arbol simetrico al pasado por parametro.
	 */

	private BSTNode<T> buildSimetricTree(BSTNode<T> actual) {
		BSTNode<T> padre, hijoIzq, hijoDer;
		padre = null;
		if (actual != null) {
			padre = new BSTNode<T>(actual.nodeValue, actual.parent);
			hijoIzq = buildSimetricTree(actual.right);
			padre.left = hijoIzq;
			if (hijoIzq != null)
				hijoIzq.parent = padre;
			hijoDer = buildSimetricTree(actual.left);
			padre.right = hijoDer;
			if (hijoDer != null)
				hijoDer.parent = padre;
		}
		return padre;
	}

	/**
	 * Metodo pathHeight. Metodo que devuelve la altura de desde un elemento
	 * pasado por parametro.
	 * 
	 * @param i
	 *            , Variable de tipo T, parametrizada. Hace referencia al
	 *            elemento pasado por parametro.
	 * @return variable de tipo int. Hace referencia a la altura que posee el
	 *         elemento pasado por parametro.
	 */
	public int pathHeight(T i) {
		BSTNode<T> aux = findNode(i);
		if (aux != null) {
			int contador = 0;
			while (aux.parent != null) {
				aux = aux.parent;
				contador++;
			}
			return contador;
		} else
			return -1;
	}

	/**
	 * Removes the leaves.
	 */
	public void removeLeaves() {
		removeLeaves(root);	
	}
	
	/**
	 * Removes the leaves.
	 *
	 * @param curr the curr
	 * @return the bST node
	 */
	private BSTNode<T> removeLeaves(BSTNode<T> curr) {
		if (curr!=null){
			if (curr.left==null&&curr.right==null)
				remove(curr.nodeValue);
			if (curr.left!=null)
				removeLeaves(curr.left);
			if (curr.right!=null)
				removeLeaves(curr.right);
		}
		return curr;
	}
}

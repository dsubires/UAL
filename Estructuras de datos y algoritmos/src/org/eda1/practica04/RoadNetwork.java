package org.eda1.practica04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.Map.Entry;

import org.eda1.estructurasdedatos.ALStack;
import org.eda1.estructurasdedatos.Graph;
import org.eda1.estructurasdedatos.LinkedQueue;
import org.eda1.utilidades.Greater;

// TODO: Auto-generated Javadoc
/**
 * The Class RoadNetwork.
 * 
 * @param <Vertex>
 *            the generic type
 */
public class RoadNetwork<Vertex> implements Graph<Vertex>, Iterable<Vertex> {

	/** The directed. */
	protected boolean directed; // directed = false (unDirected), directed =
								// true (DiGraph)

	/** The adjacency map. */
	protected TreeMap<Vertex, TreeMap<Vertex, Double>> adjacencyMap;

	/** The visited. */
	protected TreeMap<Vertex, Boolean> visited;

	/** The result. */
	protected ArrayList<Vertex> result;

	/** The result simple paths. */
	protected ArrayList<ArrayList<Vertex>> resultSimplePaths;

	/** The shortest path weight. */
	Double shortestPathWeight;

	/** The result shortest path. */
	protected ArrayList<Vertex> resultShortestPath;

	/** The largest path weight. */
	Double largestPathWeight;

	/** The result largest path. */
	protected ArrayList<Vertex> resultLargestPath;

	/** The result floyd. */
	protected ArrayList<ArrayList<Object>> resultFloyd;

	/** The path floyd. */
	ArrayList<Vertex> pathFloyd;

	/** The All vtx. */
	Set<Vertex> AllVtx;

	/**
	 * Initialized this Network object to be empty.
	 */
	public RoadNetwork() {
		directed = true;
		adjacencyMap = new TreeMap<Vertex, TreeMap<Vertex, Double>>();
	}

	/**
	 * Instantiates a new road network.
	 * 
	 * @param uDOrD
	 *            the u d or d
	 */
	public RoadNetwork(boolean uDOrD) {
		directed = uDOrD;
		adjacencyMap = new TreeMap<Vertex, TreeMap<Vertex, Double>>();
	}

	/**
	 * Initializes this Network object to a shallow copy of a specified Network
	 * object. The averageTime(V, E) is O(V + E).
	 * 
	 * @param network
	 *            - the Network object that this Network object is initialized
	 *            to a shallow copy of.
	 * 
	 */
	public RoadNetwork(RoadNetwork<Vertex> network) {
		this.directed = network.directed;
		this.adjacencyMap = new TreeMap<Vertex, TreeMap<Vertex, Double>>(
				network.adjacencyMap);
	}

	/**
	 * Sets the directed.
	 * 
	 * @param uDOrD
	 *            the new directed
	 */
	public void setDirected(boolean uDOrD) {
		directed = uDOrD;
	}

	/**
	 * Gets the directed.
	 * 
	 * @return the directed
	 */
	public boolean getDirected() {
		return directed;
	}

	/**
	 * Determines if this Network object contains no vertices.
	 * 
	 * @return true - if this Network object contains no vertices.
	 * 
	 */
	public boolean isEmpty() {
		return adjacencyMap.isEmpty();
	}

	/**
	 * Determines the number of vertices in this Network object.
	 * 
	 * @return the number of vertices in this Network object.
	 * 
	 */
	public int numberOfVertices() {
		return adjacencyMap.size();
	}

	/**
	 * Returns the number of edges in this Network object. The averageTime (V,
	 * E) is O (V).
	 * 
	 * @return the number of edges in this Network object.
	 * 
	 */
	public int numberOfEdges() {
		int count = 0;
		for (Map.Entry<Vertex, TreeMap<Vertex, Double>> entry : adjacencyMap
				.entrySet())
			count += entry.getValue().size();
		return count;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eda1.estructurasdedatos.Graph#clear()
	 */
	public void clear() {
		adjacencyMap.clear();
	}

	/**
	 * Determines the weight of an edge in this Network object. The averageTime
	 * (V, E) is O (E / V).
	 * 
	 * @param v1
	 *            - the beginning Vertex object of the edge whose weight is
	 *            sought.
	 * @param v2
	 *            - the ending Vertex object of the edge whose weight is sought.
	 * 
	 * @return the weight of edge <v1, v2>, if <v1, v2> forms an edge; return
	 *         –1.0 if <v1, v2> does not form an edge in this Network object.
	 * 
	 */
	public double getWeight(Vertex v1, Vertex v2) {
		if (!(adjacencyMap.containsKey(v1) && adjacencyMap.get(v1).containsKey(
				v2)))
			return -1.0;

		return adjacencyMap.get(v1).get(v2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eda1.estructurasdedatos.Graph#setWeight(java.lang.Object,
	 * java.lang.Object, double)
	 */
	public double setWeight(Vertex v1, Vertex v2, double w) {
		if (!(adjacencyMap.containsKey(v1) && adjacencyMap.get(v1).containsKey(
				v2)))
			return -1.0;

		TreeMap<Vertex, Double> neighborMap = adjacencyMap.get(v1);
		double oldWeight = neighborMap.get(v2);
		adjacencyMap.get(v1).put(v2, w);
		return oldWeight;
	}

	/**
	 * Checks if is adjacent.
	 * 
	 * @param v1
	 *            the v1
	 * @param v2
	 *            the v2
	 * @return true, if is adjacent
	 */
	public boolean isAdjacent(Vertex v1, Vertex v2) {
		if ((adjacencyMap.containsKey(v1))
				&& (adjacencyMap.get(v1).containsKey(v2)))
			return true;
		else
			return false;
	}

	/**
	 * Determines if this Network object contains a specified Vertex object.
	 * 
	 * @param vertex
	 *            - the Vertex object whose presence is sought.
	 * 
	 * @return true - if vertex is an element of this Network object.
	 */
	public boolean containsVertex(Vertex vertex) {
		return adjacencyMap.containsKey(vertex);
	}

	/**
	 * Determines if this Network object contains an edge specified by two
	 * vertices. The averageTime (V, E) is O (E / V).
	 * 
	 * @param v1
	 *            - the beginning Vertex object of the edge sought.
	 * @param v2
	 *            - the ending Vertex object of the edge sought.
	 * 
	 * @return true - if this Network object contains the edge <v1, v2>.
	 * 
	 */
	public boolean containsEdge(Vertex v1, Vertex v2) {
		if (adjacencyMap.containsKey(v1)
				&& adjacencyMap.get(v1).containsKey(v2))
			return true;
		else
			return false;
	}

	/**
	 * Ensures that a specified Vertex object is an element of this Network
	 * object.
	 * 
	 * @param vertex
	 *            - the Vertex object whose presence is ensured.
	 * 
	 * @return true - if vertex was added to this Network object by this call;
	 *         returns false if vertex was already an element of this Network
	 *         object when this call was made.
	 */
	public boolean addVertex(Vertex vertex) {
		if (adjacencyMap.containsKey(vertex))
			return false;
		adjacencyMap.put(vertex, new TreeMap<Vertex, Double>());
		return true;
	}

	/**
	 * Ensures that an edge is in this Network object.
	 * 
	 * @param v1
	 *            - the beginning Vertex object of the edge whose presence is
	 *            ensured.
	 * @param v2
	 *            - the ending Vertex object of the edge whose presence is
	 *            ensured.
	 * @param w
	 *            the w
	 * @return true - if the given edge (and weight) were added to this Network
	 *         object by this call; return false, if the given edge (and weight)
	 *         were already in this Network object when this call was made.
	 */
	public boolean addEdge(Vertex v1, Vertex v2, double w) {
		addVertex(v1);
		addVertex(v2);
		adjacencyMap.get(v1).put(v2, w);

		if (!directed)
			adjacencyMap.get(v2).put(v1, w);

		return true;
	}

	/**
	 * Ensures that a specified Vertex object is not an element of this Network
	 * object. The averageTime (V, E) is O (V + E).
	 * 
	 * @param vertex
	 *            - the Vertex object whose absence is ensured.
	 * 
	 * @return true - if vertex was removed from this Network object by this
	 *         call; returns false if vertex was not an element of this Network
	 *         object when this call was made.
	 * 
	 */
	public boolean removeVertex(Vertex vertex) {
		if (!adjacencyMap.containsKey(vertex))
			return false;

		for (Map.Entry<Vertex, TreeMap<Vertex, Double>> entry : adjacencyMap
				.entrySet()) {
			TreeMap<Vertex, Double> neighborMap = entry.getValue();
			neighborMap.remove(vertex);
		}
		adjacencyMap.remove(vertex);
		return true;
	}

	/**
	 * Ensures that an edge specified by two vertices is absent from this
	 * Network object. The averageTime (V, E) is O (E / V).
	 * 
	 * @param v1
	 *            - the beginning Vertex object of the edge whose absence is
	 *            ensured.
	 * @param v2
	 *            - the ending Vertex object of the edge whose absence is
	 *            ensured.
	 * 
	 * @return true - if the edge <v1, v2> was removed from this Network object
	 *         by this call; return false if the edge <v1, v2> was not in this
	 *         Network object when this call was made.
	 * 
	 */
	public boolean removeEdge(Vertex v1, Vertex v2) {
		if (!adjacencyMap.containsKey(v1)
				|| !adjacencyMap.get(v1).containsKey(v2))
			return false;

		TreeMap<Vertex, Double> neighborMap = adjacencyMap.get(v1);
		neighborMap.remove(v2);

		if (!directed) {
			TreeMap<Vertex, Double> neighborMapV2 = adjacencyMap.get(v2);
			neighborMapV2.remove(v1);
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eda1.estructurasdedatos.Graph#vertexSet()
	 */
	public Set<Vertex> vertexSet() {
		return adjacencyMap.keySet();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eda1.estructurasdedatos.Graph#getNeighbors(java.lang.Object)
	 */
	public Set<Vertex> getNeighbors(Vertex v) {
		TreeSet<Vertex> neighbors = new TreeSet<Vertex>();
		if (adjacencyMap.containsKey(v)) {
			TreeMap<Vertex, Double> neighborMap = adjacencyMap.get(v);
			for (Map.Entry<Vertex, Double> entry : neighborMap.entrySet()) {
				neighbors.add(entry.getKey());
			}
		}
		return neighbors;
	}

	/**
	 * Returns a String representation of this Network object. The
	 * averageTime(V, E) is O(V + E).
	 * 
	 * @return a String representation of this Network object.
	 * 
	 */
	public String toString() {
		return adjacencyMap.toString();
	}

	/**
	 * Read road network.
	 * 
	 * @param filename
	 *            the filename
	 * @return the road network
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	public static RoadNetwork<String> readRoadNetwork(String filename)
			throws FileNotFoundException {
		// type of Graph
		int typeOfGraph;
		// nVertices is number of vertices to read
		int i, nVertices, nEdges;
		// use for input of vertices (v1) and edges ( {v1, v2} )
		String v1, v2;
		// edge weight
		double weight;
		Scanner scaner = new Scanner(new File(filename));
		RoadNetwork<String> net = new RoadNetwork<String>();

		// READ THE FILE ACCORDING TO THE SPECIFIED FORMAT
		// Coprobamos si es dirigido o no y seteamos
		net.setDirected((Integer.parseInt(scaner.nextLine()) == 1) ? true
				: false);

		// Añadimos vertices
		nVertices = Integer.parseInt(scaner.nextLine());
		for (i = 0; i < nVertices; i++)
			net.addVertex(scaner.nextLine());

		// Añadimos aristas
		nEdges = Integer.parseInt(scaner.nextLine());
		for (i = 0; i < nEdges; i++) {
			v1 = scaner.next();
			v2 = scaner.next();
			weight = Integer.parseInt(scaner.next());

			net.addEdge(v1, v2, weight);
		}
		scaner.close();
		return net;
	}

	// IMPLEMENT THE EXERCISES SUGGESTED AT THE PRACTICE 04
	// ...

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator<Vertex> iterator() {
		return adjacencyMap.keySet().iterator();
	}

	/**
	 * Breadth first iterator.
	 * 
	 * @param v
	 *            the v
	 * @return the breadth first iterator
	 */
	public BreadthFirstIterator breadthFirstIterator(Vertex v) {
		if (!adjacencyMap.containsKey(v))
			return null;
		return new BreadthFirstIterator(v);
	}

	/**
	 * Depth first iterator.
	 * 
	 * @param v
	 *            the v
	 * @return the depth first iterator
	 */
	public DepthFirstIterator depthFirstIterator(Vertex v) {
		if (!adjacencyMap.containsKey(v))
			return null;
		return new DepthFirstIterator(v);
	}

	// ...

	/**
	 * The Class BreadthFirstIterator.
	 */
	protected class BreadthFirstIterator implements Iterator<Vertex> {

		/** The queue. */
		protected LinkedQueue<Vertex> queue;

		/** The reached. */
		protected TreeMap<Vertex, Boolean> reached;

		/** The current. */
		protected Vertex current;

		/**
		 * Instantiates a new breadth first iterator.
		 * 
		 * @param start
		 *            the start
		 */
		public BreadthFirstIterator(Vertex start) {
			queue = new LinkedQueue<Vertex>();

			reached = new TreeMap<Vertex, Boolean>();

			Iterator<Vertex> itr = adjacencyMap.keySet().iterator();
			while (itr.hasNext())
				reached.put(itr.next(), false);

			queue.push(start);
			reached.put(start, true);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#hasNext()
		 */
		public boolean hasNext() {
			return !(queue.isEmpty());
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#next()
		 */
		public Vertex next() {
			Vertex to;

			current = queue.pop();

			TreeMap<Vertex, Double> neighborMap = adjacencyMap.get(current);
			for (Map.Entry<Vertex, Double> entry : neighborMap.entrySet()) {
				to = entry.getKey();

				if (!reached.get(to)) {
					reached.put(to, true);
					queue.push(to);
				}
			}
			return current;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#remove()
		 */
		public void remove() {
			removeVertex(current);
		}

	}

	/**
	 * The Class DepthFirstIterator.
	 */
	protected class DepthFirstIterator implements Iterator<Vertex> {

		/** The stack. */
		ALStack<Vertex> stack;

		/** The reached. */
		TreeMap<Vertex, Boolean> reached;

		/** The current. */
		Vertex current;

		/**
		 * Instantiates a new depth first iterator.
		 * 
		 * @param start
		 *            the start
		 */
		public DepthFirstIterator(Vertex start) {
			stack = new ALStack<Vertex>();

			reached = new TreeMap<Vertex, Boolean>();

			Iterator<Vertex> itr = adjacencyMap.keySet().iterator();
			while (itr.hasNext())
				reached.put(itr.next(), false);

			stack.push(start);
			reached.put(start, true);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#hasNext()
		 */
		public boolean hasNext() {
			return !(stack.isEmpty());
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#next()
		 */
		public Vertex next() {
			Vertex to;

			current = stack.pop();

			TreeMap<Vertex, Double> neighborMap = adjacencyMap.get(current);
			for (Map.Entry<Vertex, Double> entry : neighborMap.entrySet()) {
				to = entry.getKey();

				if (!reached.get(to)) {
					reached.put(to, true);
					stack.push(to);
				}
			}
			return current;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#remove()
		 */
		public void remove() {
			RoadNetwork.this.removeVertex(current);
		}

	}

	/**
	 * The Class VertexWeightPair.
	 */
	protected class VertexWeightPair implements Comparable<VertexWeightPair> {

		/** The vertex. */
		Vertex vertex;

		/** The weight. */
		double weight;

		/**
		 * Initializes this VertexWeightPair from vertex and weight.
		 * 
		 * @param vertex
		 *            the vertex
		 * @param weight
		 *            the weight
		 */
		public VertexWeightPair(Vertex vertex, double weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		/**
		 * Returns the vertex in this VertexWeightPair.
		 * 
		 * @return the vertex
		 */
		public Vertex getVertex() {
			return vertex;
		}

		/**
		 * Returns the weight in this VertexWeightPair.
		 * 
		 * @return the weight
		 */
		public double getWeight() {
			return weight;
		}

		/**
		 * Set the weight in this VertexWeightPair.
		 * 
		 * @param w
		 *            the new weight
		 */
		public void setWeight(double w) {
			weight = w;
		}

		/**
		 * Returns an int <, = or > 0 , depending on whether this
		 * VertexWeightPair's weight is <, = or > other's weight.
		 * 
		 * @param other
		 *            the other
		 * @return the int
		 */
		public int compareTo(VertexWeightPair other) {
			return (int) (weight - other.getWeight());
		}

		/**
		 * Returns a String representation of this VertexWeightPair.
		 * 
		 * @return the string
		 */
		public String toString() {
			return vertex.toString() + "  " + String.valueOf(weight);
		}

	}

	/**
	 * The Class EdgeWeight.
	 */
	protected class EdgeWeight implements Comparable<EdgeWeight> {

		/** The from. */
		Vertex from;

		/** The to. */
		Vertex to;

		/** The weight. */
		double weight;

		/**
		 * Initializes this EdgeWeight from v1, v2 and weight.
		 * 
		 * @param from
		 *            the from
		 * @param to
		 *            the to
		 * @param weight
		 *            the weight
		 */
		public EdgeWeight(Vertex from, Vertex to, double weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		/**
		 * Returns the "from" vertex in this EdgeWeight.
		 * 
		 * @return the from vertex
		 */
		public Vertex getFromVertex() {
			return from;
		}

		/**
		 * Returns the "to" vertex in this EdgeWeight.
		 * 
		 * @return the to vertex
		 */
		public Vertex getToVertex() {
			return to;
		}

		/**
		 * Returns the weight vertex in this EdgeWeight.
		 * 
		 * @return the weight
		 */
		public double getWeight() {
			return weight;
		}

		/**
		 * Returns an int <, = or > 0, depending on whether this EdgeWeight's
		 * weight is <, = or > edge's weight.
		 * 
		 * @param edge
		 *            the edge
		 * @return the int
		 */
		public int compareTo(EdgeWeight edge) {
			return (int) (weight - edge.weight);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			EdgeWeight e = (EdgeWeight) obj;
			if ((from == e.from) && (to == e.to) && (weight == e.weight))
				return true;
			else
				return false;
		}

		/**
		 * Returns a String representation of this EdgeWeight.
		 * 
		 * @return the string
		 */
		public String toString() {
			return "<" + from.toString() + ", " + to.toString() + "; "
					+ String.valueOf(weight) + ">";
		}

	}

	/**
	 * To array dfs.
	 * 
	 * @param start
	 *            the start
	 * @return the array list
	 */
	public ArrayList<Vertex> toArrayDFS(Vertex start) {
		result = new ArrayList<Vertex>();
		visited = new TreeMap<Vertex, Boolean>();
		Iterator<Vertex> iterador = adjacencyMap.keySet().iterator();
		while (iterador.hasNext())
			visited.put(iterador.next(), false);
		toArrayDFSAux(start);
		return result;
	}

	/**
	 * To array dfs aux.
	 * 
	 * @param current
	 *            the current
	 */
	private void toArrayDFSAux(Vertex current) {
		result.add(current);
		visited.put(current, true);
		TreeMap<Vertex, Double> neighborMap = adjacencyMap.get(current);
		for (Map.Entry<Vertex, Double> entry : neighborMap.entrySet()) {
			Vertex to = entry.getKey();
			if (!visited.get(to))
				toArrayDFSAux(to);
		}
	}

	/**
	 * To array dfs.
	 * 
	 * @return the array list
	 */
	public ArrayList<Vertex> toArrayDFS() {
		result = new ArrayList<Vertex>();
		visited = new TreeMap<Vertex, Boolean>();
		Iterator<Vertex> iterador = adjacencyMap.keySet().iterator();
		while (iterador.hasNext())
			visited.put(iterador.next(), false);
		for (Map.Entry<Vertex, Boolean> entry : visited.entrySet()) {
			Vertex start = entry.getKey();
			if (!visited.get(start))
				toArrayDFSAux(start);
		}

		return result;
	}

	/**
	 * To array bfs.
	 * 
	 * @param start
	 *            the start
	 * @return the array list
	 */
	public ArrayList<Vertex> toArrayBFS(Vertex start) {
		result = new ArrayList<Vertex>();
		LinkedQueue<Vertex> q = new LinkedQueue<Vertex>();
		visited = new TreeMap<Vertex, Boolean>();
		Vertex current;
		Iterator<Vertex> iterador = adjacencyMap.keySet().iterator();
		while (iterador.hasNext())
			visited.put(iterador.next(), false);
		q.push(start);
		visited.put(start, true);
		while (!q.isEmpty()) {
			Vertex to;
			current = q.peek();
			q.pop();
			result.add(current);
			TreeMap<Vertex, Double> neighborMap = adjacencyMap.get(current);
			for (Map.Entry<Vertex, Double> entry : neighborMap.entrySet()) {
				to = entry.getKey();
				if (!visited.get(to)) {
					visited.put(to, true);
					q.push(to);
				}
			}
		}

		return result;
	}

	/**
	 * Shortest path std.
	 * 
	 * @param from
	 *            the from
	 * @param middle
	 *            the middle
	 * @param to
	 *            the to
	 * @return the string
	 */
	public String shortestPathSTD(Vertex from, Vertex middle, Vertex to) {
		String output = "";
		double distancePath = 0.0;
		ArrayList shortestPath = Dijkstra(from, middle);
		shortestPath.remove(middle);
		shortestPath.addAll(Dijkstra(middle, to));

		for (int i = 0; i < shortestPath.size(); i++) {
			EdgeWeight e = (EdgeWeight) shortestPath.get(i);
			if (i < shortestPath.size() - 1)
				output += e.from + " -> ";
			else
				output += e.from + " -> " + e.to;
			distancePath += e.weight;
		}
		output += " => " + distancePath;
		return output;
	}

	/**
	 * Dijkstra.
	 * 
	 * @param inicio
	 *            the inicio
	 * @param destino
	 *            the destino
	 * @return the array list
	 */
	public ArrayList<Object> Dijkstra(Vertex inicio, Vertex destino) {
		TreeMap<Vertex, Double> D = new TreeMap<Vertex, Double>();
		TreeMap<Vertex, Vertex> S = new TreeMap<Vertex, Vertex>();
		TreeSet<Vertex> V_minus_S = new TreeSet<Vertex>();
		Vertex vertex, to = null, from;
		final double INFINITY = Double.MAX_VALUE;

		if (inicio == null || destino == null)
			return new ArrayList<Object>();
		if (inicio.equals(destino))
			return new ArrayList<Object>();
		if (!(adjacencyMap.containsKey(inicio) && adjacencyMap
				.containsKey(destino)))
			return new ArrayList<Object>();

		for (Map.Entry<Vertex, TreeMap<Vertex, Double>> e : adjacencyMap
				.entrySet())
			if (!(inicio.equals(e.getKey())))
				V_minus_S.add(e.getKey());
		Iterator<Vertex> itr = V_minus_S.iterator();
		while (itr.hasNext()) {
			vertex = itr.next();
			if (isAdjacent(inicio, vertex)) {
				S.put(vertex, inicio);
				D.put(vertex, getWeight(inicio, vertex));
			} else {
				S.put(vertex, null);
				D.put(vertex, INFINITY);
			}
		}
		S.put(inicio, inicio);
		D.put(inicio, 0.0);

		while (!V_minus_S.isEmpty()) {
			Double minWeight = INFINITY;
			from = null;
			Iterator<Vertex> itr1 = V_minus_S.iterator();
			while (itr1.hasNext()) {
				vertex = itr1.next();
				if (D.get(vertex) < minWeight) {
					minWeight = D.get(vertex);
					from = vertex;
				}
			}
			if (!from.equals(null)) {
				V_minus_S.remove(from);
				Iterator<Vertex> itr2 = V_minus_S.iterator();
				while (itr2.hasNext()) {
					to = itr2.next();
					if (isAdjacent(from, to)) {
						double weight = getWeight(from, to);
						if (D.get(from) + weight < D.get(to)) {
							D.put(to, D.get(from) + weight);
							S.put(to, from);
						}
					}
				}
			} else
				break;
		}

		ArrayList<Object> path = new ArrayList<Object>();
		ALStack<Vertex> st = new ALStack<Vertex>();
		if (S.get(destino).equals(null)) {
			System.out.println("The vertex " + destino
					+ " is not reachable from " + inicio);
			return path;
		} else {
			st.push(destino);
			while (!(st.peek().equals(inicio)))
				st.push(S.get(st.peek()));
			while (!(st.isEmpty())) {
				path.add(st.peek());
				st.pop();
			}
		}
		// Respuesta para memorias:
		// System.out.println(path+" = "+D.get(destino));
		ArrayList<Object> edgePath = new ArrayList<Object>();
		for (int i = 0; (i < (path.size() - 1)); i++) {
			EdgeWeight edgeWeight = new EdgeWeight((Vertex) path.get(i),
					(Vertex) path.get(i + 1), getWeight((Vertex) path.get(i),
							(Vertex) path.get(i + 1)));
			edgePath.add(edgeWeight);
		}
		// Respuesta para memorias:
		// System.out.println(edgePath);
		return edgePath;
	}

	/**
	 * Simple paths.
	 * 
	 * @param inicio
	 *            the inicio
	 * @param destino
	 *            the destino
	 * @return the array list
	 */
	public ArrayList<ArrayList<Vertex>> simplePaths(Vertex inicio,
			Vertex destino) {
		result = new ArrayList<Vertex>();
		resultSimplePaths = new ArrayList<ArrayList<Vertex>>();
		simplePathsAux(inicio, destino);
		return resultSimplePaths;
	}

	/**
	 * Simple paths aux.
	 * 
	 * @param current
	 *            the current
	 * @param destino
	 *            the destino
	 */
	private void simplePathsAux(Vertex current, Vertex destino) {
		result.add(current);
		if (current.equals(destino)) {
			ArrayList<Vertex> resultAux = new ArrayList<Vertex>();
			for (int i = 0; i < result.size(); i++) {
				resultAux.add(result.get(i));
			}
			resultSimplePaths.add(resultAux);
		} else {
			TreeMap<Vertex, Double> neighborMap = adjacencyMap.get(current);
			for (Map.Entry<Vertex, Double> entry : neighborMap.entrySet()) {
				Vertex to = entry.getKey();
				if (!result.contains(to)) {
					simplePathsAux(to, destino);
				}
			}
		}
		result.remove(result.size() - 1);
	}

	/**
	 * Shortest path with simple paths.
	 * 
	 * @param inicio
	 *            the inicio
	 * @param destino
	 *            the destino
	 * @return the string
	 */
	public String shortestPathWithSimplePaths(Vertex inicio, Vertex destino) {
		String salida1 = "The shortest path using the simple paths algorithm from "
				+ inicio + " to " + destino + " is:\n";
		int menor = Integer.MAX_VALUE;
		int array = 0;
		ArrayList<ArrayList<Vertex>> aux = simplePaths(inicio, destino);
		for (int i = 0; i < aux.size(); i++) {
			int peso = 0;
			for (int j = 0; j < aux.get(i).size() - 1; j++) {
				peso += getWeight(aux.get(i).get(j), aux.get(i).get(j + 1));
			}
			if (peso < menor) {
				menor = peso;
				array = i;
			}
		}
		ArrayList<Vertex> caminoMinimo = aux.get(array);
		for (int k = 0; k < caminoMinimo.size() - 1; k++) {
			salida1 += caminoMinimo.get(k) + " --> ";
		}
		salida1 += caminoMinimo.get(caminoMinimo.size() - 1) + " => ("
				+ (double) menor + ")";
		// System.out.println(salida1);
		return salida1;
	}

	/**
	 * Dijkstra tree.
	 * 
	 * @param inicio
	 *            the inicio
	 * @return the array list
	 */
	public ArrayList<Object> DijkstraTree(Vertex inicio) {
		TreeMap<Vertex, Double> D = new TreeMap<Vertex, Double>();
		TreeMap<Vertex, Vertex> S = new TreeMap<Vertex, Vertex>();
		TreeSet<Vertex> V_minus_S = new TreeSet<Vertex>();
		Vertex vertex, to = null, from;
		final double INFINITY = Double.MAX_VALUE;
		ArrayList<Object> dijkstraArbol = new ArrayList<Object>();
		EdgeWeight camino;

		if (inicio == null)
			return new ArrayList<Object>();
		if (!(adjacencyMap.containsKey(inicio)))
			return new ArrayList<Object>();

		for (Map.Entry<Vertex, TreeMap<Vertex, Double>> e : adjacencyMap
				.entrySet())
			if (!(inicio.equals(e.getKey())))
				V_minus_S.add(e.getKey());
		Iterator<Vertex> itr = V_minus_S.iterator();
		while (itr.hasNext()) {
			vertex = itr.next();
			if (isAdjacent(inicio, vertex)) {
				S.put(vertex, inicio);
				D.put(vertex, getWeight(inicio, vertex));
			} else {
				S.put(vertex, null);
				D.put(vertex, INFINITY);
			}
		}
		S.put(inicio, inicio);
		D.put(inicio, 0.0);

		while (!V_minus_S.isEmpty()) {
			Double minWeight = INFINITY;
			from = null;
			Iterator<Vertex> itr1 = V_minus_S.iterator();
			while (itr1.hasNext()) {
				vertex = itr1.next();
				if (D.get(vertex) < minWeight) {
					minWeight = D.get(vertex);
					from = vertex;
				}
			}
			if (!from.equals(null)) {
				camino = new EdgeWeight(S.get(from), from, getWeight(from,
						S.get(from)));
				dijkstraArbol.add(camino);
				V_minus_S.remove(from);
				Iterator<Vertex> itr2 = V_minus_S.iterator();
				while (itr2.hasNext()) {
					to = itr2.next();
					if (isAdjacent(from, to)) {
						double weight = getWeight(from, to);
						if (D.get(from) + weight < D.get(to)) {
							D.put(to, D.get(from) + weight);
							S.put(to, from);
							// System.out.println(from+" "+to+" "+weight);
						}
					}
				}
			} else
				break;
		}
		// Respuesta para memorias:
		// System.out.println(dijkstraArbol);
		return dijkstraArbol;
	}

	/**
	 * Dijkstra farthest.
	 * 
	 * @param inicio
	 *            the inicio
	 * @return the array list
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Object> DijkstraFarthest(Vertex inicio) {
		TreeMap<Vertex, Double> D = new TreeMap<Vertex, Double>();
		TreeMap<Vertex, Vertex> S = new TreeMap<Vertex, Vertex>();
		TreeSet<Vertex> V_minus_S = new TreeSet<Vertex>();
		Vertex vertex, to = null, from;
		final double INFINITY = Double.MAX_VALUE;
		ArrayList<Object> dijkstraLargo = new ArrayList<Object>();
		ArrayList<Double> distancias = new ArrayList<Double>();

		if (inicio == null)
			return new ArrayList<Object>();
		if (!(adjacencyMap.containsKey(inicio)))
			return new ArrayList<Object>();

		for (Map.Entry<Vertex, TreeMap<Vertex, Double>> e : adjacencyMap
				.entrySet())
			if (!(inicio.equals(e.getKey())))
				V_minus_S.add(e.getKey());
		Iterator<Vertex> itr = V_minus_S.iterator();
		while (itr.hasNext()) {
			vertex = itr.next();
			if (isAdjacent(inicio, vertex)) {
				S.put(vertex, inicio);
				D.put(vertex, getWeight(inicio, vertex));
			} else {
				S.put(vertex, null);
				D.put(vertex, INFINITY);
			}
		}
		S.put(inicio, inicio);
		D.put(inicio, 0.0);

		while (!V_minus_S.isEmpty()) {
			Double minWeight = INFINITY;
			from = null;
			Iterator<Vertex> itr1 = V_minus_S.iterator();
			while (itr1.hasNext()) {
				vertex = itr1.next();
				if (D.get(vertex) < minWeight) {
					minWeight = D.get(vertex);
					from = vertex;
				}
			}
			if (!from.equals(null)) {
				V_minus_S.remove(from);
				Iterator<Vertex> itr2 = V_minus_S.iterator();
				while (itr2.hasNext()) {
					to = itr2.next();
					if (isAdjacent(from, to)) {
						double weight = getWeight(from, to);
						if (D.get(from) + weight < D.get(to)) {
							D.put(to, D.get(from) + weight);
							S.put(to, from);
						}
					}
				}
			} else
				break;
		}

		Iterator<Vertex> iterD = D.keySet().iterator();
		while (iterD.hasNext()) {
			Vertex fin = iterD.next();
			if (fin != inicio)
				distancias.add(D.get(fin));
		}
		Collections.sort(distancias, new Greater<Double>());
		double aux1;
		for (int j = 0; j < distancias.size(); j++) {
			aux1 = distancias.get(j);
			Vertex fin;
			iterD = D.keySet().iterator();
			ALStack<Vertex> st = new ALStack<Vertex>();
			ArrayList<Object> path = new ArrayList<Object>();
			while (iterD.hasNext()) {
				fin = iterD.next();
				if (D.get(fin) == aux1) {
					st.push(fin);
					while (!(st.peek().equals(inicio)))
						st.push(S.get(st.peek()));
					while (!(st.isEmpty())) {
						path.add(st.peek());
						st.pop();
					}
				}
			}
			ArrayList<Object> edgePath = new ArrayList<Object>();
			for (int i = 0; (i < (path.size() - 1)); i++) {
				EdgeWeight edgeWeight = new EdgeWeight((Vertex) path.get(i),
						(Vertex) path.get(i + 1), getWeight(
								(Vertex) path.get(i), (Vertex) path.get(i + 1)));
				edgePath.add(edgeWeight);
			}
			dijkstraLargo.add(edgePath);
		}
		// //Respuesta para memorias:
		// int contador = 0;
		// for (Object actual : dijkstraLargo) {
		// double contador2 = 0;
		// ArrayList<Object> aux=(ArrayList<Object>) actual;
		// EdgeWeight aux2;
		// for (Object actual2 : aux) {
		// aux2=(EdgeWeight) actual2;
		// contador2 += aux2.getWeight();
		// }
		// System.out.println(++contador + " " + actual + " = " + contador2);
		// }
		return dijkstraLargo;
	}

	/**
	 * Largest path with simple paths.
	 * 
	 * @param inicio
	 *            the inicio
	 * @param destino
	 *            the destino
	 * @return the array list
	 */
	public ArrayList<EdgeWeight> largestPathWithSimplePaths(Vertex inicio,
			Vertex destino) {
		int menor = Integer.MIN_VALUE;
		int array = 0;
		ArrayList<ArrayList<Vertex>> aux = simplePaths(inicio, destino);
		for (int i = 0; i < aux.size(); i++) {
			int peso = 0;
			for (int j = 0; j < aux.get(i).size() - 1; j++) {
				peso += getWeight(aux.get(i).get(j), aux.get(i).get(j + 1));
			}
			if (peso > menor) {
				menor = peso;
				array = i;
			}
		}
		ArrayList<EdgeWeight> caminoMaximo = new ArrayList<EdgeWeight>();
		ArrayList<Vertex> camino = aux.get(array);
		// double acumulado=0;
		for (int i = 0; i < camino.size() - 1; i++) {
			// acumulado+=getWeight(camino.get(i), camino.get(i + 1));
			caminoMaximo.add(new EdgeWeight(camino.get(i), camino.get(i + 1),
					getWeight(camino.get(i), camino.get(i + 1))));
		}
		// Respuesta para memorias:
		// System.out.println(caminoMaximo+" = "+acumulado);
		return caminoMaximo;
	}

	/**
	 * Floyd with dijkstra.
	 * 
	 * @return the int
	 */
	public int FloydWithDijkstra() {
		int contador = 0;
		Iterator<Vertex> iter = adjacencyMap.keySet().iterator();
		while (iter.hasNext()) {
			Vertex iter1 = iter.next();
			Iterator<Vertex> iter2 = adjacencyMap.keySet().iterator();
			while (iter2.hasNext()) {
				Vertex iter3 = iter2.next();
				if (iter1 != iter3 && Dijkstra(iter1, iter3) != null)
					contador++;
			}
		}
		// System.out.println(contador);
		return contador;
	}

	/**
	 * Checks if is floyd graph.
	 * 
	 * @return true, if is floyd graph
	 */
	public boolean isFloydGraph() {
		for (Entry<Vertex, TreeMap<Vertex, Double>> e1 : adjacencyMap
				.entrySet()) {
			if (!e1.getValue().containsKey(e1.getKey()))
				return false;
			else if (e1.getValue().get(e1.getKey()) != 0.0)
				return false;
		}
		return true;
	}

	/**
	 * Adapt to floyd graph.
	 */
	public void adaptToFloydGraph() {
		if (!isFloydGraph())
			for (Entry<Vertex, TreeMap<Vertex, Double>> e1 : adjacencyMap
					.entrySet())
				if (!e1.getValue().containsKey(e1.getKey()))
					e1.getValue().put(e1.getKey(), 0.0);
	}

	/**
	 * Floyd.
	 * 
	 * @return the array list
	 */
	public ArrayList<ArrayList<Object>> Floyd() {
		resultFloyd = new ArrayList<ArrayList<Object>>();
		final double INFINITY = Double.MAX_VALUE;
		double[][] D;
		int[][] A;
		TreeMap<Vertex, Integer> vtxIndex = new TreeMap<Vertex, Integer>();
		Vertex from, to;
		double weight;
		int i, j, k;
		int n = numberOfVertices();
		if (n <= 0)
			return null;
		D = new double[n][n];
		A = new int[n][n];
		int index = 0;
		for (Map.Entry<Vertex, TreeMap<Vertex, Double>> e : adjacencyMap
				.entrySet())
			vtxIndex.put(e.getKey(), index++);

		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				D[i][j] = INFINITY;
				A[i][j] = -1;
			}
		}
		for (Map.Entry<Vertex, TreeMap<Vertex, Double>> e1 : adjacencyMap
				.entrySet()) {
			TreeMap<Vertex, Double> neighborMap = e1.getValue();
			for (Map.Entry<Vertex, Double> e2 : neighborMap.entrySet()) {
				from = e1.getKey();
				to = e2.getKey();
				weight = e2.getValue();
				D[vtxIndex.get(from)][vtxIndex.get(to)] = weight;
			}
		}

		for (k = 0; (k < n); k++) {
			for (i = 0; (i < n); i++) {
				for (j = 0; (j < n); j++) {
					if ((D[i][k] < INFINITY) && (D[k][j] < INFINITY)) {
						if ((D[i][k] + D[k][j]) < D[i][j]) {
							D[i][j] = D[i][k] + D[k][j];
							A[i][j] = k;
						}
					}
				}
			}
		}
		addPaths(D, A, vtxIndex);
		// Salida para memorias...
		// System.out.println(resultFloyd.size());
		// int contador=0;
		// for (ArrayList actual : resultFloyd) {
		// EdgeWeight aux;
		// double contador2=0;
		// for (Object actual2 : actual) {
		// aux=(EdgeWeight) actual2;
		// contador2+=aux.getWeight();
		// }
		// System.out.println(++contador+" "+actual+" = "+contador2);
		// }
		// System.out.println(resultFloyd);
		return resultFloyd;
	}

	/**
	 * Adds the paths.
	 * 
	 * @param D
	 *            the d
	 * @param A
	 *            the a
	 * @param vI
	 *            the v i
	 */
	private void addPaths(double D[][], int A[][], TreeMap<Vertex, Integer> vI) {
		final double INFINITY = Double.MAX_VALUE;
		int i, j;
		pathFloyd = new ArrayList<Vertex>();
		for (i = 0; (i < numberOfVertices()); i++) {
			for (j = 0; (j < numberOfVertices()); j++) {
				if ((D[i][j] >= 0) && (D[i][j] < INFINITY)) {
					if (!(getVertexFromIndex(vI, i).equals(getVertexFromIndex(
							vI, j)))) {
						pathFloyd.clear();
						pathFloyd.add(getVertexFromIndex(vI, i));
						addPath(i, j, A, vI);
						pathFloyd.add(getVertexFromIndex(vI, j));
						ArrayList<Object> edgePath = new ArrayList<Object>();
						for (int p = 0; (p < (pathFloyd.size() - 1)); p++) {
							EdgeWeight edgeWeight = new EdgeWeight(
									(Vertex) pathFloyd.get(p),
									(Vertex) pathFloyd.get(p + 1), getWeight(
											(Vertex) pathFloyd.get(p),
											(Vertex) pathFloyd.get(p + 1)));
							edgePath.add(edgeWeight);
						}
						resultFloyd.add(edgePath);
					}
				}
			}
		}
	}

	/**
	 * Adds the path.
	 * 
	 * @param i
	 *            the i
	 * @param j
	 *            the j
	 * @param A
	 *            the a
	 * @param vI
	 *            the v i
	 */
	private void addPath(int i, int j, int A[][], TreeMap<Vertex, Integer> vI) {
		int k = A[i][j];
		if (k >= 0) {
			addPath(i, k, A, vI);
			pathFloyd.add(getVertexFromIndex(vI, k));
			addPath(k, j, A, vI);
		}
	}

	/**
	 * Gets the vertex from index.
	 * 
	 * @param vI
	 *            the v i
	 * @param index
	 *            the index
	 * @return the vertex from index
	 */
	private Vertex getVertexFromIndex(TreeMap<Vertex, Integer> vI, int index) {
		Vertex v = null;
		for (Map.Entry<Vertex, Integer> ei : vI.entrySet())
			if (ei.getValue() == index) {
				v = ei.getKey();
				break;
			}
		return v;
	}

	/**
	 * Floyd filter by distances.
	 * 
	 * @param d
	 *            the d
	 * @param e
	 *            the e
	 * @return the array list
	 */
	public ArrayList<ArrayList<Object>> FloydFilterByDistances(double d,
			double e) {
		Floyd();
		ArrayList<ArrayList<Object>> salida = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> salidaAux = new ArrayList<Object>();

		for (int i = 0; i < resultFloyd.size(); i++) {
			ArrayList<Object> actual = resultFloyd.get(i);
			double suma = 0.0;
			for (int j = 0; j < actual.size(); j++) {
				EdgeWeight tripleta = (EdgeWeight) actual.get(j);
				salidaAux.add(tripleta);
				suma += tripleta.getWeight();

			}
			if (suma > d && suma < e)
				salida.add(salidaAux);
			salidaAux = new ArrayList<Object>();
		}
		// Salida para memorias...
		// int contador=0;
		// for (ArrayList actual : salida) {
		// EdgeWeight aux;
		// double contador2=0;
		// for (Object actual2 : actual) {
		// aux=(EdgeWeight) actual2;
		// contador2+=aux.getWeight();
		// }
		// System.out.println(++contador+" "+actual+" = "+contador2);
		// }
		return salida;
	}

	/**
	 * Floyd closest farthest.
	 * 
	 * @return the array list
	 */
	public ArrayList<ArrayList<Object>> FloydClosestFarthest() {
		Floyd();
		ArrayList<ArrayList<Object>> salida = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> salidaAux = new ArrayList<Object>();
		ArrayList<Object> salidaAuxMax = new ArrayList<Object>();
		ArrayList<Object> salidaAuxMin = new ArrayList<Object>();
		double mayor = Double.MIN_VALUE;
		double menor = Double.MAX_VALUE;

		for (int i = 0; i < resultFloyd.size(); i++) {
			ArrayList<Object> actual = resultFloyd.get(i);
			double suma = 0.0;
			for (int j = 0; j < actual.size(); j++) {
				EdgeWeight tripleta = (EdgeWeight) actual.get(j);
				salidaAux.add(tripleta);
				suma += tripleta.getWeight();
			}
			if (suma < menor) {
				salidaAuxMin = salidaAux;
				menor = suma;
			}
			if (suma > mayor) {
				salidaAuxMax = salidaAux;
				mayor = suma;
			}
			salidaAux = new ArrayList<Object>();
		}
		salida.add(salidaAuxMin);
		salida.add(salidaAuxMax);
		// System.out.println(salidaAuxMin);
		// System.out.println(salidaAuxMax);
		// System.out.println(salida);
		return salida;
	}

	/**
	 * Floyd filter by name of city.
	 * 
	 * @param ciudad
	 *            the ciudad
	 * @return the array list
	 */
	public ArrayList<ArrayList<Object>> FloydFilterByNameOfCity(Vertex ciudad) {
		Floyd();
		ArrayList<ArrayList<Object>> salida = new ArrayList<ArrayList<Object>>();
		for (int i = 0; i < resultFloyd.size(); i++) {
			ArrayList<Object> actual = resultFloyd.get(i);
			if (((EdgeWeight) actual.get(0)).getFromVertex().equals(ciudad)) {
				salida.add(actual);
			}
		}
		// Salida para memorias...
		// int contador=0;
		// for (ArrayList actual : salida) {
		// EdgeWeight aux;
		// double contador2=0;
		// for (Object actual2 : actual) {
		// aux=(EdgeWeight) actual2;
		// contador2+=aux.getWeight();
		// }
		// System.out.println(++contador+" "+actual+" = "+contador2);
		// }
		return salida;
	}

	/**
	 * Prim.
	 * 
	 * @param ciudad
	 *            the ciudad
	 * @return the array list
	 */
	public ArrayList<Object> Prim(Vertex ciudad) {
		final double INFINITY = Double.MAX_VALUE;
		TreeMap<Vertex, Double> D = new TreeMap<Vertex, Double>();
		TreeMap<Vertex, Vertex> S = new TreeMap<Vertex, Vertex>();
		TreeSet<Vertex> V_minus_S = new TreeSet<Vertex>();
		Vertex vertex, to = null, from;
		ArrayList<Object> MST = new ArrayList<Object>();
		if (ciudad == null)
			return new ArrayList<Object>();
		if (!(adjacencyMap.containsKey(ciudad)))
			return new ArrayList<Object>();
		for (Map.Entry<Vertex, TreeMap<Vertex, Double>> e : adjacencyMap
				.entrySet()) {
			if (!(ciudad.equals(e.getKey())))
				V_minus_S.add(e.getKey());
		}
		Iterator<Vertex> itr = V_minus_S.iterator();
		while (itr.hasNext()) {
			vertex = (Vertex) itr.next();
			if (isAdjacent(ciudad, vertex)) {
				S.put(vertex, ciudad);
				D.put(vertex, getWeight(ciudad, vertex));
			} else {
				S.put(vertex, null);
				D.put(vertex, INFINITY);
			}
		}
		S.put(ciudad, ciudad);
		D.put(ciudad, 0.0);
		// double contador = 0;
		while (!V_minus_S.isEmpty()) {
			Double minWeight = INFINITY;
			from = null;
			Iterator<Vertex> itr1 = V_minus_S.iterator();
			while (itr1.hasNext()) {
				vertex = (Vertex) itr1.next();
				if (D.get(vertex) < minWeight) {
					minWeight = D.get(vertex);
					from = vertex;
				}
			}

			if (from != null) {
				V_minus_S.remove(from);
				EdgeWeight edgeWeight = new EdgeWeight(S.get(from), from,
						getWeight(S.get(from), from));
				// contador+=edgeWeight.getWeight();
				MST.add(edgeWeight);
				Iterator<Vertex> itr2 = V_minus_S.iterator();
				while (itr2.hasNext()) {
					to = (Vertex) itr2.next();
					if (isAdjacent(from, to)) {
						double weight = getWeight(from, to);
						if (weight < D.get(to)) {
							D.put(to, weight);
							S.put(to, from);

						}
					}
				}
			} else
				break;
		}
		// System.out.println(MST+" = "+ contador);
		return MST;
	}

	/**
	 * Kruskal.
	 *
	 * @return the array list
	 */
	public ArrayList<Object> Kruskal() {
		TreeMap<Vertex, TreeSet<Vertex>> connectedComponents = new TreeMap<Vertex, TreeSet<Vertex>>();
		;

		ArrayList<Object> MST = new ArrayList<Object>();

		PriorityQueue<EdgeWeight> pQ = new PriorityQueue<EdgeWeight>();

		Vertex vertex, from, to;

		EdgeWeight edgeWeight;

		double weight;

		for (Map.Entry<Vertex, TreeMap<Vertex, Double>> e1 : adjacencyMap
				.entrySet()) {
			TreeMap<Vertex, Double> neighborMap = e1.getValue();
			for (Map.Entry<Vertex, Double> e2 : neighborMap.entrySet()) {
				from = e1.getKey();
				to = e2.getKey();
				weight = e2.getValue();
				edgeWeight = new EdgeWeight(from, to, weight);

				pQ.add(edgeWeight);
				if (!connectedComponents.containsKey(from)) {
					TreeSet<Vertex> valueTreeSet = new TreeSet<Vertex>();
					valueTreeSet.add(from);
					connectedComponents.put(from, valueTreeSet);
				}
				if (!connectedComponents.containsKey(to)) {
					TreeSet<Vertex> valueTreeSet = new TreeSet<Vertex>();
					valueTreeSet.add(to);
					connectedComponents.put(to, valueTreeSet);
				}
			}
		}

		for (Map.Entry<Vertex, TreeSet<Vertex>> e1 : connectedComponents
				.entrySet()) {
			TreeSet<Vertex> neighborMap = e1.getValue();
			System.out.print(e1.getKey() + ": ");
			for (Vertex e2 : neighborMap)
				System.out.print(e2 + ", ");
			System.out.println();
		}

		while (!pQ.isEmpty()) {
			edgeWeight = pQ.poll();
			from = edgeWeight.getFromVertex();
			to = edgeWeight.getToVertex();
			weight = edgeWeight.getWeight();

			// If graph vertices (from, to) are in different connected
			// components,
			// i.e. the set for 'from' is different from that for 'to'
			Vertex kf = null, kt = null;
			TreeSet<Vertex> sf = null, st = null;
			for (Map.Entry<Vertex, TreeSet<Vertex>> e1 : connectedComponents
					.entrySet()) {
				Vertex v = e1.getKey();
				TreeSet<Vertex> s = e1.getValue();
				if (s.contains(from)) {
					kf = v;
					sf = s;
				}
				if (s.contains(to)) {
					kt = v;
					st = s;
				}
			}
			if (!sf.equals(st)) {
				System.out.println("Vertices are in different sets ... " + from
						+ ", " + to + "; " + weight);
				System.out.println("Keys ... " + kf + ", " + kt);
				if (connectedComponents.get(kf).size() > connectedComponents
						.get(kt).size()) {
					// Transfer all vertices including 'to'
					while (!connectedComponents.get(kt).isEmpty()) {
						vertex = connectedComponents.get(kt).pollFirst();
						connectedComponents.get(kf).add(vertex);
					}
				} else {
					// Transfer all nodes including 'from'
					while (!connectedComponents.get(kf).isEmpty()) {
						vertex = connectedComponents.get(kf).pollFirst();
						connectedComponents.get(kt).add(vertex);
					}
				}

				for (Map.Entry<Vertex, TreeSet<Vertex>> e1 : connectedComponents
						.entrySet()) {
					TreeSet<Vertex> s = e1.getValue();
					System.out.print(e1.getKey() + ": ");
					for (Vertex e2 : s)
						System.out.print(e2 + ", ");
					System.out.println();
				}

				MST.add(edgeWeight);
			} else
				System.out
						.println("Vertices are in the same set ... nothing to do here "
								+ from + ", " + to + "; " + weight);
		}

		return MST;
	}

}

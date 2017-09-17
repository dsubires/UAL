package org.eda1.actividad05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Map.Entry;

import org.eda1.estructurasdedatos.ALStack;
import org.eda1.estructurasdedatos.Graph;
import org.eda1.estructurasdedatos.LinkedQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class Network.
 *
 * @param <Vertex> the generic type
 */
public class Network<Vertex> implements Graph<Vertex>, Iterable<Vertex> {

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

	/** The largest length path. */
	int largestLengthPath;
	
	/** The result largest length path. */
	protected ArrayList<Vertex> resultLargestLengthPath;

	/** The sum of length of simple paths. */
	int numberOfSimplePaths, sumOfLengthOfSimplePaths;

	/**
	 * Initialized this Network object to be empty.
	 */
	public Network() {
		directed = true;
		adjacencyMap = new TreeMap<Vertex, TreeMap<Vertex, Double>>();
	} // default constructor

	/**
	 * Instantiates a new network.
	 *
	 * @param uDOrD the u d or d
	 */
	public Network(boolean uDOrD) {
		directed = uDOrD;
		adjacencyMap = new TreeMap<Vertex, TreeMap<Vertex, Double>>();
	} // default constructor

	/**
	 * Initializes this Network object to a shallow copy of a specified Network
	 * object. The averageTime(V, E) is O(V + E).
	 * 
	 * @param network
	 *            - the Network object that this Network object is initialized
	 *            to a shallow copy of.
	 * 
	 */
	public Network(Network<Vertex> network) {
		this.directed = network.directed;
		this.adjacencyMap = new TreeMap<Vertex, TreeMap<Vertex, Double>>(
				network.adjacencyMap);
	} // copy constructor

	/**
	 * Sets the directed.
	 *
	 * @param uDOrD the new directed
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
	} // method isEmpty

	/**
	 * Determines the number of vertices in this Network object.
	 * 
	 * @return the number of vertices in this Network object.
	 * 
	 */
	public int numberOfVertices() {
		return adjacencyMap.size();
	} // method size

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
	} // method getEdgeCount

	/* (non-Javadoc)
	 * @see org.eda1.estructurasdedatos.Graph#clear()
	 */
	public void clear() {
		adjacencyMap.clear();
	}

	/* (non-Javadoc)
	 * @see org.eda1.estructurasdedatos.Graph#getWeight(java.lang.Object, java.lang.Object)
	 */
	public double getWeight(Vertex v1, Vertex v2) {
		if (!(adjacencyMap.containsKey(v1) && adjacencyMap.get(v1).containsKey(
				v2)))
			return -1.0;

		return adjacencyMap.get(v1).get(v2);
	} // method getWeight

	/* (non-Javadoc)
	 * @see org.eda1.estructurasdedatos.Graph#setWeight(java.lang.Object, java.lang.Object, double)
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
	 * Determines if this Network object contains a specified Vertex object.
	 * 
	 * @param vertex
	 *            - the Vertex object whose presence is sought.
	 * 
	 * @return true - if vertex is an element of this Network object.
	 */
	public boolean containsVertex(Vertex vertex) {
		return adjacencyMap.containsKey(vertex);
	} // method containsVertex

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
	} // method containsEdge

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
	} // method addVertex

	/**
	 * Ensures that an edge is in this Network object.
	 *
	 * @param v1 - the beginning Vertex object of the edge whose presence is
	 * ensured.
	 * @param v2 - the ending Vertex object of the edge whose presence is
	 * ensured.
	 * @param w the w
	 * @return true - if the given edge (and weight) were added to this Network
	 * object by this call; return false, if the given edge (and weight)
	 * were already in this Network object when this call was made.
	 */
	public boolean addEdge(Vertex v1, Vertex v2, double w) {
		addVertex(v1);
		addVertex(v2);
		adjacencyMap.get(v1).put(v2, w);
		if (!directed)
			adjacencyMap.get(v2).put(v1, w);
		return true;
	} // method addEdge

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
		} // for each vertex in the network
		adjacencyMap.remove(vertex);
		return true;
	} // removeVertex

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
	} // method removeEdge

	/* (non-Javadoc)
	 * @see org.eda1.estructurasdedatos.Graph#vertexSet()
	 */
	public Set<Vertex> vertexSet() {
		return adjacencyMap.keySet();
	}

	/* (non-Javadoc)
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
	} // method toString

	/**
	 * Builds a graph whose vertices are strings by reading the vertices and
	 * edges from the textfile <tt>filename</tt>. The format of the file is
	 * <code>
	 * nVertices
	 * vertex_1 vertex_2 ...vertex_n
	 * nEdges
	 * vertex_i vertex_j weight
	 * . . .  </code> ...
	 *
	 * @param filename name of the text file with vertex and edge specifications.
	 * @return <tt>DiGraph</tt> object with generic type String.
	 * @throws FileNotFoundException the file not found exception
	 */
	public static Network<String> readNetwork(String filename)
			throws FileNotFoundException {
		// type of Graph
		int typeOfGraph;
		// nVertices is number of vertices to read
		int i, nVertices, nEdges;
		// use for input of vertices (v1) and edges ( {v1, v2} )
		String v1, v2;
		// edge weight
		double weight;
		Network<String> net = new Network<String>();
		Scanner scaner = new Scanner(new File(filename));

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

	/**
	 * Show network.
	 */
	public void showNetwork() {
		for (Map.Entry<Vertex, TreeMap<Vertex, Double>> e1 : adjacencyMap
				.entrySet()) {
			TreeMap<Vertex, Double> neighborMap = e1.getValue();
			for (Map.Entry<Vertex, Double> e2 : neighborMap.entrySet()) {
				System.out.println(e1.getKey() + " " + e2.getKey() + " "
						+ e2.getValue());
			}
		}
	}

	// IMPLEMENT THE EXERCISES SUGGESTED AT THE ACTTIVITY 05
	// ...

	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator<Vertex> iterator() {
		return adjacencyMap.keySet().iterator();
	}

	/**
	 * Breadth first iterator.
	 *
	 * @param v the v
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
	 * @param v the v
	 * @return the depth first iterator
	 */
	public DepthFirstIterator depthFirstIterator(Vertex v) {
		if (!adjacencyMap.containsKey(v))
			return null;
		return new DepthFirstIterator(v);
	}

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
		 * @param start the start
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

		/* (non-Javadoc)
		 * @see java.util.Iterator#hasNext()
		 */
		public boolean hasNext() {
			return !(queue.isEmpty());
		}

		/* (non-Javadoc)
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

		/* (non-Javadoc)
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
		 * @param start the start
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

		/* (non-Javadoc)
		 * @see java.util.Iterator#hasNext()
		 */
		public boolean hasNext() {
			return !(stack.isEmpty());
		}

		/* (non-Javadoc)
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

		/* (non-Javadoc)
		 * @see java.util.Iterator#remove()
		 */
		public void remove() {
			Network.this.removeVertex(current);
		}

	}
    /////////////////////////////////////////////////////////////////////////////
	
	/**
     * In degree.
     *
     * @param v the v
     * @return the int
     */
    public int inDegree(Vertex v) {
		int count = 0;
		Vertex temp, temp2;

		Iterator<Vertex> iterador = adjacencyMap.keySet().iterator();
		while (iterador.hasNext()) {
			temp = iterador.next();
			if (!temp.equals(v)) {
				Iterator<Vertex> iterador2 = adjacencyMap.get(temp).keySet()
						.iterator();
				while (iterador2.hasNext()) {
					temp2 = iterador2.next();
					if (temp2.equals(v))
						count++;
				}
			}
		}

		return count;
	}

	/**
	 * Out degree.
	 *
	 * @param v the v
	 * @return the int
	 */
	public int outDegree(Vertex v) {
		return adjacencyMap.get(v).size();
	}

	/**
	 * To array dfs.
	 *
	 * @param start the start
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
	 * @param current the current
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
	 * To array dfs iterative.
	 *
	 * @param start the start
	 * @return the array list
	 */
	public ArrayList<Vertex> toArrayDFSIterative(Vertex start) {
		result = new ArrayList<Vertex>();
		ALStack<Vertex> st = new ALStack<Vertex>();
		visited = new TreeMap<Vertex, Boolean>();
		Vertex current;
		Iterator<Vertex> iterador = adjacencyMap.keySet().iterator();
		while (iterador.hasNext())
			visited.put(iterador.next(), false);
		st.push(start);
		visited.put(start, true);
		while (!st.isEmpty()) {
			Vertex to;
			current = st.peek();
			st.pop();
			result.add(current);
			TreeMap<Vertex, Double> neighborMap = adjacencyMap.get(current);
			for (Map.Entry<Vertex, Double> entry : neighborMap.entrySet()) {
				to = entry.getKey();
				if (!visited.get(to)) {
					visited.put(to, true);
					st.push(to);
				}
			}
		}
		return result;
	}

	/**
	 * Checks if is reachable.
	 *
	 * @param source the source
	 * @param destination the destination
	 * @return true, if is reachable
	 */
	public boolean isReachable(Vertex source, Vertex destination) {
		return (toArrayDFS(source).contains(destination)) ? true : false;
	}

	/**
	 * To array bfs.
	 *
	 * @param start the start
	 * @return the array list
	 */
	public ArrayList<Vertex> toArrayBFS(Vertex start){
		result = new ArrayList<Vertex>();
		LinkedQueue<Vertex> q = new LinkedQueue<Vertex>();
		visited = new TreeMap<Vertex,Boolean>();
		Vertex current;
		Iterator<Vertex> iterador = adjacencyMap.keySet().iterator();
		while(iterador.hasNext())
			visited.put(iterador.next(), false);
		q.push(start);
		visited.put(start, true);
		while(!q.isEmpty()){
			Vertex to;
			current = q.peek();
			q.pop();
			result.add(current);
			TreeMap<Vertex,Double> neighborMap = adjacencyMap.get(current);
			for(Map.Entry<Vertex, Double> entry: neighborMap.entrySet()){
				to = entry.getKey();
				if(!visited.get(to)){
					visited.put(to, true);
					q.push(to);
				}
			}
		}
		
		return result;
	}

	/**
	 * Checks if is source.
	 *
	 * @param v the v
	 * @return true, if is source
	 */
	public boolean isSource(Vertex v) {
		return (outDegree(v) > 0 && inDegree(v) == 0)?true:false;
	}

	/**
	 * Checks if is sink.
	 *
	 * @param v the v
	 * @return true, if is sink
	 */
	public boolean isSink(Vertex v) {
		return (inDegree(v) > 0 && outDegree(v) == 0)?true:false;
	}

	/**
	 * Simple paths.
	 *
	 * @param source the source
	 * @param destination the destination
	 * @return the array list
	 */
	public ArrayList<ArrayList<Vertex>> simplePaths(Vertex source,Vertex destination) {
		result = new ArrayList<Vertex>();
		resultSimplePaths = new ArrayList<ArrayList<Vertex>>();
		
		simplePathsAux(source,destination);
		
		return resultSimplePaths;
	}
	
	/**
	 * Simple paths aux.
	 *
	 * @param current the current
	 * @param destination the destination
	 */
	private void simplePathsAux(Vertex current, Vertex destination){
		result.add(current);
		
		if(current.equals(destination)){
			ArrayList<Vertex> resultAux = new ArrayList<Vertex>();
			for(int i=0; i<result.size(); i++)
				resultAux.add(result.get(i));
			resultSimplePaths.add(resultAux);
		}else{
			TreeMap<Vertex,Double> neighborMap = adjacencyMap.get(current);
			for(Map.Entry<Vertex, Double> entry: neighborMap.entrySet()){
				Vertex to = entry.getKey();
				if(!result.contains(to))
					simplePathsAux(to,destination);
			}
		}
		result.remove(result.size()-1);
	}

	
	/**
	 * Simple paths visited.
	 *
	 * @param source the source
	 * @param destination the destination
	 * @return the array list
	 */
	public ArrayList<ArrayList<Vertex>> simplePathsVisited(Vertex source, Vertex destination){
		result = new ArrayList<Vertex>();
		resultSimplePaths = new ArrayList<ArrayList<Vertex>>();
		visited = new TreeMap<Vertex,Boolean>();
		Iterator<Vertex> iterador = adjacencyMap.keySet().iterator();
		while(iterador.hasNext())
			visited.put(iterador.next(), false);
		simplePathsVisitedAux(source,destination);
		
		return resultSimplePaths;
	}
	
	/**
	 * Simple paths visited aux.
	 *
	 * @param current the current
	 * @param destination the destination
	 */
	private void simplePathsVisitedAux(Vertex current, Vertex destination){
		result.add(current);
		visited.put(current, true);
		
		if(current.equals(destination)){
			ArrayList<Vertex> resultAux = new ArrayList<Vertex>();
			for(int i = 0; i<result.size(); i++)
				resultAux.add(result.get(i));
			resultSimplePaths.add(resultAux);
		}else{
			TreeMap<Vertex,Double> neighborMap = adjacencyMap.get(current);
			for(Map.Entry<Vertex, Double> entry:neighborMap.entrySet()){
				Vertex to = entry.getKey();
				if(!visited.get(to))
					simplePathsVisitedAux(to,destination);
			}
		}
		result.remove(result.size()-1);
		visited.put(current, false);
	}
	

	/**
	 * Shortest path with simple paths.
	 *
	 * @param source the source
	 * @param destination the destination
	 * @return the string
	 */
	public String shortestPathWithSimplePaths(Vertex source, Vertex destination) {
		
		ArrayList<ArrayList<Vertex>> paths = simplePaths(source, destination);
		double sumaCosteMin = 0;
		String output = ""; 
		
		//No hay ningun camino
		if(paths.size() == 0)
			return "";
		//Hay un solo camino
		else if(paths.size() == 1)
			output = printPath(paths.get(0)) +" => ("+calculateSumPath(paths.get(0))+")";
		else{
		//Hay varios caminos
			sumaCosteMin = calculateSumPath(paths.get(0));
			output = printPath(paths.get(0))+" => ("+sumaCosteMin+")";
			
			for(ArrayList<Vertex> al : paths){
				double tempSum = calculateSumPath(al); 
				if(tempSum < sumaCosteMin){
					output = printPath(al)+" => ("+tempSum+")";
					sumaCosteMin = tempSum ;
				}
			}
		}
		output = "The shortest path using the simple paths algorithm from "+source+" to "+destination+" is:\n"+output;
		return output;
	}
	
	/**
	 * Calculate sum path.
	 *
	 * @param path the path
	 * @return the double
	 */
	private double calculateSumPath(ArrayList<Vertex> path){
		double count = 0;
		Vertex temp;
		ListIterator<Vertex> li = path.listIterator();
		while(li.hasNext()){
			temp = li.next();
			if(li.hasNext()){
				count += getWeight(temp, li.next());
				li.previous();
			}
		}
		return count;
	}
	
	
	/**
	 * Prints the path.
	 *
	 * @param path the path
	 * @return the string
	 */
	private String printPath(ArrayList<Vertex> path){
		String output = "";
		Iterator<Vertex> itr = path.iterator();
		while(itr.hasNext()){
			output += itr.next();
			if(itr.hasNext())
				output += " --> ";
		}
		return output;
	}

	/**
	 * Largest lenght path with simple paths.
	 *
	 * @param source the source
	 * @param destination the destination
	 * @return the string
	 */
	public String largestLenghtPathWithSimplePaths(Vertex source, Vertex destination) {
		ArrayList<ArrayList<Vertex>> paths = simplePaths(source, destination);
		int size = 0;
		double averageSize = 0.0;
		String output = ""; 
		
		//No hay ningun camino
		if(paths.size() == 0)
			return "";
		//Hay un solo camino
		else if(paths.size() == 1){
			output = printPath(paths.get(0))+" => ("+ (paths.get(0).size()-1) +")";
			averageSize = (paths.get(0).size()-1);
		}else{
		//Hay varios caminos
			
			size = (paths.get(0).size()-1) ;
			output = printPath(paths.get(0))+" => ("+size+")";
			
			for(ArrayList<Vertex> al : paths){
				int sizeTemp = (al.size()-1);
				averageSize += Double.parseDouble(sizeTemp+"");
				if(sizeTemp > size){
					size = sizeTemp ;
					output = printPath(paths.get(0))+" => ("+size+")";
				}
			}
			averageSize = averageSize/paths.size();
		}
		output = "The largest length path using the simple paths algorithm from "+source+" to "+destination+" is:\n"+output;
		output += "\nThe average length of the simple paths from "+source+" to "+destination+" is: "+String.format("%.2f", averageSize).replace(",", ".");
		return output;
	}

	/**
	 * Checks if is path length.
	 *
	 * @param source the source
	 * @param destination the destination
	 * @param i the i
	 * @return true, if is path length
	 */
	public boolean isPathLength(Vertex source, Vertex destination, Integer i) {
		resultSimplePaths = simplePaths(source, destination);
		
		for(ArrayList<Vertex> al : resultSimplePaths)
			if((al.size()-1) == i )
				return true;
		return false;
	}

	/**
	 * Checks if is connected.
	 *
	 * @return true, if is connected
	 */
	public boolean isConnected(){
		if(directed)
			return false;
		for(Vertex v : adjacencyMap.keySet()){
			//Count the vertices reachable from v
			Iterator<Vertex> itr = new BreadthFirstIterator(v);
			int count = 0;
			while(itr.hasNext()){
				itr.next();
				count++;
			}
			if(count < adjacencyMap.size())
				return false;
		}
		return true;
	}
	/*
	public boolean isStronglyConnected() {
		for(Vertex source : adjacencyMap.keySet()){
			for(Vertex destination : adjacencyMap.keySet()){
				if(!source.equals(destination)){
					resultSimplePaths = simplePaths(source, destination);
					if(resultSimplePaths.size() == 0)
						return false;
				}
			}
		}
		return true;
	}
	*/
	/**
	 * Checks if is strongly connected.
	 *
	 * @return true, if is strongly connected
	 */
	public boolean isStronglyConnected(){
		if(!directed)
			return false;
		Network<Vertex> transposeGraph = new Network(directed);
		for(Map.Entry<Vertex, TreeMap<Vertex,Double>> e1 : adjacencyMap.entrySet()){
			TreeMap<Vertex,Double> neighborMap = e1.getValue();
			for(Map.Entry<Vertex, Double> e2 : neighborMap.entrySet()){
				transposeGraph.addEdge(e2.getKey(), e1.getKey(), e2.getValue());
			}
		}	
		
		for(Vertex v : adjacencyMap.keySet()){
			int countS = 0;
			Iterator<Vertex> itrS = new BreadthFirstIterator(v);
			while(itrS.hasNext()){
				itrS.next();
				countS++;
			}
			if(countS < adjacencyMap.size())
				return false;
			int countP = 0;
			Iterator<Vertex> itrP = transposeGraph.breadthFirstIterator(v);
			while(itrP.hasNext()){
				itrP.next();
				countP++;
			}
			if(countP < adjacencyMap.size())
				return false;
		}
	return true;
	}
	
	
	/**
	 * Checks if is tree.
	 *
	 * @return true, if is tree
	 */
	public boolean isTree(){
    	if (directed)
        	return false;
    	
    	if(!isConnected())
    		return false;
    	if(numberOfVertices()-1!=numberOfEdges()>>1)
    		return false;
		return true;
	}
	
	/**
	 * Checks if is adjacent.
	 *
	 * @param source the source
	 * @param destination the destination
	 * @return true, if is adjacent
	 */
	private boolean isAdjacent(Vertex source, Vertex destination){
		return (adjacencyMap.get(source).containsKey(destination))?true:false;
	}
	
	/**
	 * Dijkstra.
	 *
	 * @param source the source
	 * @param destination the destination
	 * @return the array list
	 */
	public ArrayList<Object> Dijkstra(Vertex source, Vertex destination) {
		Double INFINITY = Double.MAX_VALUE;
		TreeMap<Vertex, Double> D = new TreeMap<Vertex, Double>();
	    	TreeMap<Vertex, Vertex> S = new TreeMap<Vertex, Vertex>();
		TreeSet<Vertex> V_minus_S = new TreeSet<Vertex>();
		Vertex vertex, to = null, from;
	    	if (source == null || destination == null)	return new ArrayList<Object>();
		if (source.equals(destination))	return new ArrayList<Object>();
	    	if (!(adjacencyMap.containsKey(source) && adjacencyMap.containsKey(destination)))
			return new ArrayList<Object>();
	    	
	    	
		for (Map.Entry<Vertex, TreeMap<Vertex, Double>> e : adjacencyMap.entrySet())
	    		if (!(source.equals(e.getKey())))	V_minus_S.add(e.getKey());
		Iterator itr = V_minus_S.iterator();
	    	while(itr.hasNext()) {
	    		vertex = (Vertex)itr.next();
	    		if (isAdjacent(source, vertex)) {
	    			S.put(vertex, source);	D.put(vertex, getWeight(source, vertex));
	    		}
	    		else {
	    			S.put(vertex, null);	D.put(vertex, INFINITY);
	    		}
	    	}
		S.put(source, source);
		D.put(source, 0.0);
		while (!V_minus_S.isEmpty()) {
			Double minWeight = INFINITY;	from = null;	Iterator itr1 = V_minus_S.iterator();
		    	while(itr1.hasNext()) {
				vertex = (Vertex)itr1.next();
		    		if (D.get(vertex) < minWeight) {
		    			minWeight = D.get(vertex);	from = vertex;
		    		}
		    	}
			if (!from.equals(null)) {
				V_minus_S.remove(from);
			    	Iterator itr2 = V_minus_S.iterator();
			    	while(itr2.hasNext()) {
			    		to = (Vertex)itr2.next();
			    		if (isAdjacent(from, to)) {
			    			double weight = getWeight(from, to);
			    			if (D.get(from) + weight < D.get(to)) {
		      					D.put(to, D.get(from) + weight);	S.put(to, from);
			    			}
			    		}
			    	}
			}
			else
				break;
		}
		ArrayList<Object> path = new ArrayList<Object>();
		ALStack<Vertex> st = new ALStack<Vertex>();
		if (S.get(destination).equals(null)) {
			System.out.println ("The vertex " + destination + " is not reachable from " + source);
			return path;
		}
		else {
			st.push(destination);
			while (!(st.peek().equals(source)))
				st.push(S.get(st.peek()));
			while (!(st.isEmpty())) {
				path.add(st.peek());
				st.pop();
			}
		}
		
		ArrayList<Object> edgePath = new ArrayList<Object>();
		for (int i = 0; (i < (path.size() - 1)); i++) {
	        		EdgeWeight edgeWeight = new EdgeWeight((Vertex)path.get(i), (Vertex)path.get(i + 1), getWeight((Vertex)path.get(i),
				(Vertex)path.get(i + 1)));
	        		edgePath.add(edgeWeight);
		}
	    	return edgePath;
	}
	
	/**
	 * The Class EdgeWeight.
	 */
	protected class EdgeWeight implements Comparable<EdgeWeight>{
		
		/** The to. */
		Vertex from,to;
		
		/** The weight. */
		double weight;
		
		/**
		 * Instantiates a new edge weight.
		 *
		 * @param s the s
		 * @param d the d
		 * @param w the w
		 */
		public EdgeWeight(Vertex s, Vertex d, Double w){
			from = s; to = d; weight = w;
		}
		
		/**
		 * Gets the source.
		 *
		 * @return the source
		 */
		public Vertex getSource(){
			return from;
		}
		
		/**
		 * Gets the destination.
		 *
		 * @return the destination
		 */
		public Vertex getDestination(){
			return to;
		}
		
		/**
		 * Gets the weight.
		 *
		 * @return the weight
		 */
		public double getWeight(){
			return weight;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(EdgeWeight o) {
			if(this.weight < o.weight)
				return -1;
			else if(this.weight > o.weight)
				return 1;
			else
				return 0;
		}
		
	}
	
	/**
	 * The Class VertexWeightPair.
	 */
	protected class VertexWeightPair implements Comparable<VertexWeightPair>{
		
		/** The vertex. */
		Vertex vertex;
		
		/** The weight. */
		double weight;
		
		/**
		 * Instantiates a new vertex weight pair.
		 *
		 * @param v the v
		 * @param w the w
		 */
		public VertexWeightPair(Vertex v, double w){
			vertex = v; weight = w;
		}

		/* (non-Javadoc)
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(VertexWeightPair o) {
			if(this.weight < o.weight)
				return -1;
			else if(this.weight > o.weight)
				return 1;
			else
				return 0;
		}
		
	}
	
	
	/**
	 * Dijkstra pq.
	 *
	 * @param source the source
	 * @param destination the destination
	 * @return the array list
	 */
	public ArrayList<Object> DijkstraPQ(Vertex source, Vertex destination) {
		Double INFINITY = Double.MAX_VALUE;
		PriorityQueue<VertexWeightPair> pq = new PriorityQueue<VertexWeightPair>();	
		TreeMap<Vertex,Vertex> padre = new TreeMap<Vertex,Vertex>();
		TreeMap<Vertex, Double> distancia = new TreeMap<Vertex, Double>();
		VertexWeightPair vwp;
		ArrayList<Object> path = new ArrayList<Object>();
		
    	if (source == null || destination == null)	return new ArrayList<Object>();
    	if (source.equals(destination))	return new ArrayList<Object>();
    	if (!(adjacencyMap.containsKey(source) && adjacencyMap.containsKey(destination)))
    		return new ArrayList<Object>();
    	
    	for (Map.Entry<Vertex, TreeMap<Vertex, Double>> e : adjacencyMap.entrySet())
    		if (!(source.equals(e.getKey()))){
    			distancia.put(e.getKey(), INFINITY);
    			padre.put(e.getKey(), null);
    		}
    	distancia.put(source, 0.0);
    	pq.add(new VertexWeightPair(source,0.0));
    	
    	while(!pq.isEmpty()){
    		vwp = pq.poll();
    		for(Vertex v : adjacencyMap.keySet()){
    			if(isAdjacent(vwp.vertex, v)){
    				Double sumTemp = distancia.get(vwp.vertex) + getWeight(vwp.vertex,v);
    				if(distancia.get(v) > sumTemp){
    					distancia.put(v, sumTemp);
    					padre.put(v, vwp.vertex);
    					pq.add(new VertexWeightPair(v, distancia.get(v)));
    				}
    			}
    		}
    	}
    	
    	ALStack<Vertex> st = new ALStack<Vertex>();
		if (padre.get(destination).equals(null)) {
			System.out.println ("The vertex " + destination + " is not reachable from " + source);
			return path;
		}
		else {
			st.push(destination);
			while (!(st.peek().equals(source)))
				st.push(padre.get(st.peek()));
			while (!(st.isEmpty())) {
				path.add(st.peek());
				st.pop();
			}
		}
		ArrayList<Object> edgePath = new ArrayList<Object>();
		for (int i = 0; (i < (path.size() - 1)); i++) {
	        		EdgeWeight edgeWeight = new EdgeWeight((Vertex)path.get(i), (Vertex)path.get(i + 1), getWeight((Vertex)path.get(i),
				(Vertex)path.get(i + 1)));
	        		edgePath.add(edgeWeight);
		}
	    	return edgePath;
	}
	
	
	
	/**
	 * Floyd ec.
	 *
	 * @return the string
	 */
	public String FloydEC() {
		final double INFINITY = Double.MAX_VALUE;
		double [][] D;
	 	int [][] A;
		TreeMap<Vertex, Integer> vtxIndex = new TreeMap<Vertex, Integer>();
		Vertex vertex, from, to;
		EdgeWeight edgeWeight;
		String output = "";
		double weight;
		int i, j, k;
		int n = numberOfVertices();
		if (n <= 0)     return "";
	       D = new double [n] [n];
	       A = new int [n] [n];
		int index = 0;
		for (Map.Entry<Vertex, TreeMap<Vertex, Double>> e : adjacencyMap.entrySet())
			vtxIndex.put(e.getKey(), index++);
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				D[i][j] = INFINITY;
				A[i][j] = -1;
			}
		}
		for (Map.Entry<Vertex, TreeMap<Vertex, Double>> e1 : adjacencyMap.entrySet()) {
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
					if ((D[i][k] < INFINITY) && (D[k][j] < INFINITY) && D[i][k] != -1.0 && D[k][j] != -1.0) {
						if ((D[i][k] + D[k][j]) < D[i][j]) {
							D[i][j] = D[i][k] + D[k][j];
							A[i][j] = k;
						}
					}
				}
			}
		}
		
		//Imprimimos los caminos desde el vertice 0 a todos los demas vertices de G accesibles
		output += showPaths(D, A, vtxIndex,0,true);
		//Calculamos el vertice centro segun su excentricidad y lo imprimimos
		int centro = getCentro(D, A, vtxIndex);
		output += " centro = "+ centro+ "\n";
		//si no hay centro return 
		if(centro < 0)
			return "";
		//imprimimos los caminos desde el centro a todos los demas vertices de G accesibles
		output += showPaths(D, A, vtxIndex, centro, false);
		return output;
	}
	
	
	/**
	 * Show paths.
	 *
	 * @param D the d
	 * @param A the a
	 * @param vI the v i
	 * @param from the from
	 * @param b the b
	 * @return the string
	 */
	private String showPaths(double D[][], int A[][], TreeMap<Vertex, Integer> vI, int from, boolean b) {
	 	final double INFINITY = Double.MAX_VALUE;  		
	   	int i, j,numPaths=0;
	   	String output = "";

	   	//true= Imprime costes desde el primer vertice, false= Imprime costes desde el vertice "centro"
	   	if(b){
	   		output += "{";
	   		for (i = 0; (i < numberOfVertices()); i++) {
	   			if ((D[from][i] >= -1.0) && (D[from][i] < INFINITY))
	   				numPaths++;
	   		}
   			for (i = 0; (i < numberOfVertices()); i++) {
   				if ((D[from][i] >= -1.0) && (D[from][i] < INFINITY)){ 
   					output += getVertexFromIndex(vI, i) +"="+D[from][i];
   					numPaths--;
   					if(i == numberOfVertices()-1)
   						output += "};";
   					else
   						if(numPaths >0)
   							output += ", ";
   				}else
   					if(i == numberOfVertices()-1)
   						output += "};";
   			}
   		}else{
   			output += "[";
	   		for (i = 0; (i < numberOfVertices()); i++) {
	   			if ((D[from][i] >= 0) && (D[from][i] < INFINITY))
	   				numPaths++;
	   		}
   			for (i = 0; (i < numberOfVertices()); i++) {
   	   			if ((D[from][i] >= 0) && (D[from][i] < INFINITY)){
   	   				output += "(" + getVertexFromIndex(vI, from) +", "+ getVertexFromIndex(vI, i) + ")=" + D[from][i];
   	   				numPaths--;
   	   				if(i == numberOfVertices()-1)
   	   					output += "]\n";
   	   				else
   	   					if(numPaths >0)
   	   						output += ", ";
   	   			}else
   	   				if(i == numberOfVertices()-1)
   	   					output += "]\n";
   			}
   		}
	   	return output;
	}
	
	/**
	 * Show path.
	 *
	 * @param i the i
	 * @param j the j
	 * @param A the a
	 * @param vI the v i
	 * @return the string
	 */
	private String showPath(int i, int j, int A[][], TreeMap<Vertex, Integer> vI){
		String output = ""+i+", ";
		output += showPathR(i,j,A,vI);
		output += j+"";
		return output;
	}
	
	/**
	 * Show path r.
	 *
	 * @param i the i
	 * @param j the j
	 * @param A the a
	 * @param vI the v i
	 * @return the string
	 */
	private String showPathR(int i, int j, int A[][], TreeMap<Vertex, Integer> vI) {
	  	String output = "";//+i+", ";
		int k = A[i][j];
	   	if (k >= 0) {
	   		output += showPathR(i, k, A, vI);
	 		output += getVertexFromIndex(vI, k) + ", ";
	 		output += showPathR(k, j, A, vI); 
	 	}
	   	return output;
	}
	
	/**
	 * Gets the vertex from index.
	 *
	 * @param vI the v i
	 * @param index the index
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
	 * Checks if is floyd graph.
	 *
	 * @return true, if is floyd graph
	 */
	public boolean isFloydGraph() {
		boolean isFloyd = true;
		TreeMap<Vertex,Double> neighborMap;
		
		for(Vertex v: adjacencyMap.keySet()){
			neighborMap = adjacencyMap.get(v);
			if(!neighborMap.containsKey(v) || neighborMap.get(v) != -1.0)
				isFloyd = false;
			}
		
		if(!directed)
			isFloyd = false;
		
		return isFloyd;
	}

	/**
	 * Adapt to floyd graph.
	 */
	public void adaptToFloydGraph() {
		directed = true;
		TreeMap<Vertex,Double> neighborMap;
		
		for(Vertex v : adjacencyMap.keySet()){
			neighborMap = adjacencyMap.get(v);
			if(!neighborMap.containsKey(v) || neighborMap.get(v) != -1.0)
				neighborMap.put(v, -1.0);
		}

	}

	/**
	 * Gets the centro.
	 *
	 * @param D the d
	 * @param A the a
	 * @param vI the v i
	 * @return the centro
	 */
	public int getCentro(double D[][], int A[][], TreeMap<Vertex, Integer> vI){
		final double INFINITY = Double.MAX_VALUE;  		
		Double min = INFINITY,max = 0.0;
	   	int i, j,centro = -1;
	   	TreeMap<Integer,Double> mapaExcentricidad = new TreeMap<Integer,Double>();
	   	ArrayList<Double> temp = new ArrayList<Double>();
	   	String[] numVertexInPath;
	   	
		for (i = 0; (i < numberOfVertices()); i++) {
			temp = new ArrayList<Double>();
	   		for (j = 0; (j < numberOfVertices()); j++) {
	   			numVertexInPath = showPath(i, j, A, vI).split(",");
	   			if (D[i][j] >= 0 && D[i][j] < INFINITY  && numVertexInPath.length > 3 ){
	   					temp.add(D[i][j]);
	   			}
	   		}
	   		if(temp.size() == 0)
	   			temp.add(0.0);
	   		max = Collections.max(temp);
	   		mapaExcentricidad.put(i, max);
	   	}
		max = 0.0;
		for(Double d: mapaExcentricidad.values()){
			if(d > max)
				max = d;
		}
		for(Map.Entry<Integer, Double> e : mapaExcentricidad.entrySet()){
	   		if(min == INFINITY){
	   			centro = e.getKey();
				min = e.getValue();
	   		}
	   		if(e.getValue() < min && e.getValue() > 0 ){
				centro = e.getKey();
				min = e.getValue();
			}
		}

		return centro;
	}
	
	// class Network
}

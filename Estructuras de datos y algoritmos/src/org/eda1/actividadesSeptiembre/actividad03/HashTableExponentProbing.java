package org.eda1.actividadesSeptiembre.actividad03;


public class HashTableExponentProbing<T> {
	private static final int DEFAULT_TABLE_SIZE = 71;
	private final double MAX_LOAD_FACTOR = .5;
	private HashEntry<T>[] table; // The table of elements
	private int occupiedEntries; // The number of occupied entries
	private int hashTableSize; // The current size
	private int tableThreshold;
	private int numberOfCollisions;
	private int exponent;

	public HashTableExponentProbing() {
		this(DEFAULT_TABLE_SIZE);
	}

	public HashTableExponentProbing(int exp) {
		allocateTable(DEFAULT_TABLE_SIZE);
		occupiedEntries = 0;
		hashTableSize = 0;
		tableThreshold = (int) (table.length * MAX_LOAD_FACTOR);
		numberOfCollisions = 0;
		exponent = exp;
		for (int i = 0; i < table.length; i++)
			table[i] = null;
	}

    /**
     * Expand the hash table.
     */
    private void rehash(int newTableSize) {
        HashEntry<T> [] oldTable = new HashEntry[table.length];
        for (int i = 0; i < table.length; i++)
            oldTable[i] = table[i];        

        // Create a new empty table
        allocateTable(newTableSize);
        occupiedEntries = 0;
        hashTableSize = 0;
        tableThreshold = (int)(table.length * MAX_LOAD_FACTOR);
        for (int i = 0; i < table.length; i++)
            table[i] = null;        

        // Copy table add
        for (HashEntry<T> entry : oldTable)
            if (entry != null && entry.isActive)
                add(entry.element);

        oldTable = null;
    }

    /**
     * Method that performs quadratic probing resolution.
     * @param x the item to search for.
     * @return the position where the search terminates.
     */
    private int findPos(T x) {
        int currentPos = myHash(x);

        //int offset = 1;
        //while (table[currentPos] != null && !table[currentPos].element.equals(x)) {
        //    currentPos += offset;  // Compute ith probe
        //    offset += 2;
        //    if (currentPos >= table.length)
        //        currentPos -= table.length;
        //}

        int k = 0;
        while (table[currentPos] != null && !table[currentPos].element.equals(x)) {
        	k++;
        	numberOfCollisions++;
            currentPos += Math.pow(k, exponent);
            currentPos %= table.length;
            if (currentPos >= table.length)
                currentPos -= table.length;
            
        }

        return currentPos;
    }

	   /**
     * Insert into the hash table. If the item is
     * already present, do nothing.
     * @param x the item to insert.
     */
    public boolean add(T x) {
        // Insert x as active
        int currentPos = findPos(x);
        if (isActive(currentPos))
            return false;

        table[currentPos] = new HashEntry<T>(x, true);
        hashTableSize++;
        occupiedEntries++;

		if (hashTableSize >= tableThreshold)
			rehash(2 * table.length);

        return true;
    }


    /**
     * Remove from the hash table.
     * @param x the item to remove.
     * @return true if item removed
     */
    public boolean remove(T x) {
        int currentPos = findPos((T) x);
        if (isActive(currentPos)) {
            table[currentPos].isActive = false;
            hashTableSize--;
            return true;
        }
        else
            return false;
    }


	public int size() {
		return hashTableSize;
	}

	public int capacity() {
		return table.length;
	}

	public int numberOfOccupiedEntries() {
		return occupiedEntries;
	}

	public int getNumberOfCollisions() {
		return numberOfCollisions;
	}

    /**
     * Find an item in the hash table.
     * @param x the item to search for.
     * @return the matching item.
     */
    public boolean contains(T x) {
        int currentPos = findPos(x);
        return isActive(currentPos);
    }


    /**
     * Return true if currentPos exists and is active.
     * @param currentPos the result of a call to findPos.
     * @return true if currentPos is active.
     */
    private boolean isActive(int currentPos) {
        return table[currentPos] != null && table[currentPos].isActive;
    }

    public void clear() {
    	occupiedEntries = 0;
        hashTableSize = 0;
        for (int i = 0; i < table.length; i++)
            table[i] = null;
    }

	public boolean isEmpty() {
		return hashTableSize == 0;
	}

    /**
    * Returns an array containing all of the elements in this hash table.
    * @return an array containing all of the elements in this hash table.
    */
    public Object[] toArray() {
 		// allocate the array an an iterator
 		Object[] arr = new Object[hashTableSize];

 		for (int i = 0; i < table.length; i++) {
 			if (isActive(i))
 	 			arr[i] = (Object)table[i].element;
 		}

 		return arr;
 	}

    /**
     * Returns a string representation of this tree. The
     * representation is a comma separated list in iterator order
     * enclosed in square brackets.
     */
    public String toString() {
 		int max = hashTableSize - 1;
 		StringBuffer buf = new StringBuffer();

 		buf.append("[");
 		int j = 0;
 		for (int i = 0; i < table.length; i++) {
 			if (isActive(i)) {
 				buf.append(table[i].element.toString());
 	 	    	if (j < max) {
 	 				buf.append(", ");
 	 				j++;
 	 	    	}
 			}
 		}
 		buf.append("]");
 		return buf.toString();
 	}

	private int myHash(T x) {
		int hashVal = (x.hashCode() & Integer.MAX_VALUE) % table.length;
		if (hashVal < 0)
			hashVal += table.length;
		return hashVal;
	}

	private void allocateTable(int tableSize) {
		table = new HashEntry[nextPrime(tableSize)];
	}

	private static int nextPrime(int n) {
		if (n % 2 == 0)
			n++;
		for (; !isPrime(n); n += 2)
			;
		return n;
	}

	private static boolean isPrime(int n) {
		if (n == 2 || n == 3)
			return true;
		if (n == 1 || n % 2 == 0)
			return false;
		for (int i = 3; i * i <= n; i += 2)
			if (n % i == 0)
				return false;
		return true;
	}

	private static class HashEntry<T> {
		public T element; // The element
		public boolean isActive; // true is marked added, false if marked
									// deleted

		public HashEntry(T e) {
			this(e, true);
		}

		public HashEntry(T e, boolean i) {
			element = e;
			isActive = i;
		}
	}
}

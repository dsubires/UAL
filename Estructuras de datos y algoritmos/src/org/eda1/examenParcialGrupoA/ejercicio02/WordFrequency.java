package org.eda1.examenParcialGrupoA.ejercicio02;

// TODO: Auto-generated Javadoc
/**
 * The Class WordFrequency.
 */
public class WordFrequency implements Comparable{

	/** The word. */
	private String word;
	
	/** The frequency. */
	private int frequency;
	
	/**
	 * Instantiates a new word frequency.
	 */
	public WordFrequency(){
		word="";
		frequency=0;
	}
	
	/**
	 * Instantiates a new word frequency.
	 *
	 * @param word the word
	 * @param frequency the frequency
	 */
	public WordFrequency(String word, int frequency){
		this.word=word;
		this.frequency=frequency;
	}
	
	/**
	 * Instantiates a new word frequency.
	 *
	 * @param word the word
	 */
	public WordFrequency(String word){
		this.word=word;
		frequency=1;
	}
	
	/**
	 * Gets the word.
	 *
	 * @return the word
	 */
	public String getWord() {
		return word;
	}
	
	/**
	 * Sets the word.
	 *
	 * @param word the new word
	 */
	public void setWord(String word) {
		this.word = word;
	}
	
	/**
	 * Gets the frequency.
	 *
	 * @return the frequency
	 */
	public int getFrequency() {
		return frequency;
	}
	
	/**
	 * Sets the frequency.
	 *
	 * @param frequency the new frequency
	 */
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return word;
	}

	/**
	 * Increment frequency.
	 */
	public void incrementFrequency(){
		frequency++;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordFrequency other = (WordFrequency) obj;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Object obj) {
		WordFrequency aux=(WordFrequency)obj;
		return word.compareTo(aux.getWord());
	}
}

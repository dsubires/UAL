package org.ip.sesion08;

public class EjemploCadena {
	String cadena;

	public EjemploCadena(String cadena) {
		this.cadena = cadena;
	}

	public String realizarConteo() {
		int numLetras = 0;
		int numEspacios = 0;
		int numDigitos = 0;
		char c;
		for (int i = 0; i < cadena.length(); i++) {
			c = this.cadena.charAt(i);
			if (Character.isLetter(c)) {
				numLetras++;
			} else if (Character.isDigit(c)) {
				numDigitos++;
			} else if (Character.isWhitespace(c)) {
				numEspacios++;
			}
		}
		return ("\nNúmero de letras = " + numLetras + "\nNúmero de Dígitos = "
				+ numDigitos + "\nNúmero de Espacios = " + numEspacios);
	}
	public String eliminarVocales(){
		String aux = this.cadena;
		aux = aux.replace('a','*');
		aux = aux.replace('e','*');
		aux = aux.replace('i','*');
		aux = aux.replace('o','*');
		aux = aux.replace('u','*');
		return aux;
		}

}
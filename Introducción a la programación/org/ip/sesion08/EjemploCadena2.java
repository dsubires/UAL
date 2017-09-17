package org.ip.sesion08;

public class EjemploCadena2 {
	String cadena;

	public EjemploCadena2(String cadena) {
		this.cadena = cadena;
	}

	static public String realizarConteo(String cadenaUsuario) {
		int numLetras = 0;
		int numEspacios = 0;
		int numDigitos = 0;
		char c;
		for (int i = 0; i < cadenaUsuario.length(); i++) {
			c = cadenaUsuario.charAt(i);
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
	static public String eliminarVocales(String cadenaUsuario){
		String aux = cadenaUsuario;
		aux = aux.replace('a','*');
		aux = aux.replace('e','*');
		aux = aux.replace('i','*');
		aux = aux.replace('o','*');
		aux = aux.replace('u','*');
		return aux;
		}

}
package org.ip.sesion08;

public class Palindromo {

	public static boolean esPalindromo(String cadena) {
		String invertida;
		cadena = procesarCadena(cadena);
		invertida = invertirCadena(cadena);
		if (cadena.equals(invertida)) {
			return true;
		} else {
			return false;
		}
	}

	private static String procesarCadena(String cadena) {
		String cadenaProcesada = "";
		// Quitamos los espacios/caracteres raros y pasamos la cadena a
		// minusculas
		char c;
		for (int i = 0; i < cadena.length(); i++) {
			c = cadena.charAt(i);
			if (!Character.isWhitespace(c)) {
				if (Character.isLetterOrDigit(c)) {
					cadenaProcesada += Character.toLowerCase(c);
				}
			}
		}
		cadenaProcesada = cadenaProcesada.replace("á", "a");
		cadenaProcesada = cadenaProcesada.replace("é", "e");
		cadenaProcesada = cadenaProcesada.replace("í", "i");
		cadenaProcesada = cadenaProcesada.replace("ó", "o");
		cadenaProcesada = cadenaProcesada.replace("ú", "u");
		return cadenaProcesada;
	}

	private static String invertirCadena(String cadena) {
		char c;
		String cadenaAlReves = "";
		for (int i = cadena.length() - 1; 0 <= i; --i) {
			c = cadena.charAt(i);
			cadenaAlReves += c;
		}
		return cadenaAlReves;
	}
}

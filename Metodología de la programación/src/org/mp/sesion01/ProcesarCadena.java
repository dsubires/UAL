package org.mp.sesion01;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesarCadena.
 */
public class ProcesarCadena {

	/**
	 * Procesa.
	 *
	 * @param cadena the cadena
	 * @return the string
	 */
	public static String Procesa(String cadena){
		int letras=0;
		int digitos=0;
		int espacios=0;
		char c;
		
		for(int i=0; i < cadena.length();i++){
			c = cadena.charAt(i);
			if(Character.isLetter(c)){
				letras++;
			}
			if(Character.isDigit(c)){
				digitos++;
			}
			if(Character.isWhitespace(c)){
				espacios++;
			}

		}
		
		return "La frase: \n"+cadena+"\nTiene "+letras+" letras, "+digitos+" dígitos y "+espacios+" espacios.";
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		String prueba = "Hola, vivo en Marquina 123, 5-7";
		System.out.println(ProcesarCadena.Procesa(prueba));

	}
	
	
}

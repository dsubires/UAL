package org.ip.sesion08;

import org.ip.entradaInteractiva.EntradaInteractiva;

public class UsoEjemploCadena2 {

	public static void main(String[] args) {
		String cadena;
		do {
			System.out.print("Introduzca una cadena de caracteres");
			System.out
					.println("...teclee \"Quiero salir de aqui\" para terminar:");
			cadena = EntradaInteractiva.leerCadena();

			// comprobamos si cadena indica fin de programa
			if (cadena.toLowerCase().equals("quiero salir de aqui"))
				break;

			System.out.println(EjemploCadena2.realizarConteo(cadena));
			System.out.println(EjemploCadena2.eliminarVocales(cadena));
		} while (true);

		System.out.println("Fin del programa");

	}

}

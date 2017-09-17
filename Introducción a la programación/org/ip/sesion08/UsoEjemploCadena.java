package org.ip.sesion08;

import org.ip.entradaInteractiva.EntradaInteractiva;

public class UsoEjemploCadena {
	public static void main(String[] args) {
		String cadenaUsuario;
		System.out
				.print("Introduce cadena de texto para ser tratada (Quiero salir de aqui=exit): ");
		cadenaUsuario = EntradaInteractiva.leerCadena();
		EjemploCadena ejemplo1 = new EjemploCadena(cadenaUsuario);
		while (!cadenaUsuario.equals("Quiero salir de aqui")) {
			System.out.println(ejemplo1.realizarConteo());
			System.out.println(ejemplo1.eliminarVocales());
			System.out
					.print("Introduce cadena de texto para ser tratada (Quiero salir de aqui=exit): ");
			cadenaUsuario = EntradaInteractiva.leerCadena();
			ejemplo1 = new EjemploCadena(cadenaUsuario);

		}
		System.out.println("Fin del programa");
	}
}
package org.ip.sesion08;

import org.ip.entradaInteractiva.EntradaInteractiva;

public class UsoPalindromo {
	public static void main(String[] args) {
		String entrada;
		do {
			System.out.print("Escriba alg�n pal�ndromo...intro para salir: ");
			entrada = EntradaInteractiva.leerCadena();
			if (entrada.isEmpty())
				break;
			System.out
					.println(Palindromo.esPalindromo(entrada) ? "....que si\n"
							: "...que no\n");
		} while (true);

	}

}

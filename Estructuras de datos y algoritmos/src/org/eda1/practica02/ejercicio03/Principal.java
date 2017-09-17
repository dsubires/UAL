package org.eda1.practica02.ejercicio03;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		CorrectorOrtografico corrector = new CorrectorOrtografico();
		ArrayList<String> sugerencias;
		String aux, frase = "";
		int opcion, opcion2, tempOpcion;

		System.out.println("*************");
		System.out.println("Programa corrector otrografico");
		System.out.println("*************\n\n\n");

		// 1 Al ejecutarse el programa, el árbol diccionario leerá desde archivo
		// la lista de palabras actuales que lo componen.
		String directorioEntrada = System.getProperty("user.dir");

		String archivoEntrada = directorioEntrada + File.separator + "src"
				+ File.separator + "org" + File.separator + "eda1"
				+ File.separator + "practica02" + File.separator
				+ "ejercicio03" + File.separator + "diccionario.txt";

		corrector.cargarDiccionario(archivoEntrada);

		// 2 El usuario podrá introducir desde teclado una frase, el programa
		// deberá analizar la frase, palabra por palabra,
		System.out.println("Introduce una frase");
		try {
			BufferedReader br0 = new BufferedReader(new InputStreamReader(
					System.in));
			String[] palabras = br0.readLine().split(" ");

			for (int i = 0; i < palabras.length; i++) {
				aux = palabras[i];
				System.out.println();
				if (corrector.containsPalabra(aux)) {
					// Palabra esta en diccionario
					System.out.println(aux + " -> OK");
					frase += aux + " ";
					System.out.println();
				} else {
					// Palabra no esta en diccionario
					System.out.println(aux + " no esta en el diccionario.");
					opcion = 0;
					while (opcion == 0) {
						sugerencias = corrector.listaSugerencias(2, aux);
						System.out.println("Elige una opcion:");
						System.out
								.println("1) Cambiar "
										+ aux
										+ " por una palabra de la lista de sugerencias: "
										+ sugerencias);
						System.out.println("2) Añadir " + aux
								+ " al diccionario");
						System.out.println("3) No hacer nada");
						BufferedReader br = new BufferedReader(
								new InputStreamReader(System.in));
						tempOpcion = Integer.parseInt(br.readLine());
						if (tempOpcion == 1) {
							// Cambiar palabar por la sugerencia
							System.out.println("Elige palabra sugerencia");
							Iterator<String> iterador = sugerencias.iterator();
							int count = 0;
							while (iterador.hasNext()) {
								System.out.println(count + ") "
										+ iterador.next());
								count++;
							}
							opcion2 = 0;
							while (opcion2 == 0) {
								BufferedReader br2 = new BufferedReader(
										new InputStreamReader(System.in));
								count = Integer.parseInt(br2.readLine());
								if (count >= sugerencias.size())
									System.out.println("Fuera de rango");
								else {
									frase += sugerencias.get(count) + " ";
									opcion2 = 1;
									opcion = 1;
									System.out.println();
								}

							}

						} else if (tempOpcion == 2) {
							// Añadir palabra a diccionario
							corrector.addPalabra(aux);
							opcion = 1;
							frase += aux + " ";
							System.out.println();

						}else if(tempOpcion == 3){
							opcion = 1;
							frase += aux+" ";
						}else
							System.out.println("Opcion erronea");

					}
					System.out.println();
				}
			}

		} catch (IOException e) {
			System.err.println(e);
			System.out
					.println("Asegurese de haber proporcionado una opcion valida");
		}
		corrector.guardarDiccionario(archivoEntrada);
		System.out.println("Finalmente la frase ha quedado así:\n" + frase);
	}

	public ArrayList<String> leerFrase() {
		ArrayList<String> list = new ArrayList<String>();

		return list;
	}

}

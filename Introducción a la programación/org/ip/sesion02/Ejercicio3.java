package org.ip.sesion02;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Ejercicio3 {
	public static void main(String args[]) throws IOException {
		System.out
				.println("Programa para calcular el área, el perímetro y la diagonal de un rectángulo:");
		String entrada1;
		String entrada2;
		int ancho = 0, alto = 0;
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Escribe el ancho del rectangulo");
		entrada1 = br.readLine();
		System.out.println("Escribe el alto del rectangulo");
		entrada2 = br.readLine();
		ancho = Integer.parseInt(entrada1); // aqui convertimos de String a int
											// para poder operar matematicamente
		alto = Integer.parseInt(entrada2);
		System.out.println("El ancho del rectangulo es:\t" + ancho);
		System.out.println("El alto del rectangulo es:\t" + alto);
		System.out.println("El área del rectangulo es:\t" + (ancho * alto));
		System.out.println("El perímetro del rectangulo es:\t"
				+ ((ancho * 2) + (alto * 2)));
		System.out.println("La diagonal del rectangulo es:\t"
				+ Math.sqrt((Math.pow(ancho, 2) + Math.pow(alto, 2))));

	}
}

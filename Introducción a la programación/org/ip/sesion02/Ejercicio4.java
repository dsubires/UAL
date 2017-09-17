package org.ip.sesion02;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class Ejercicio4 {

	/**
	 * @param args
	 */
	public static void main(String[] args)  throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Programa para calcular el área y volumen de un cilindro:");
        String entrada1;
        String entrada2 ;
        int radio=0,altura=0;
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Escribe el radio del cilindro");
        entrada1 = br.readLine();
        System.out.println("Escribe la altura del cilindro" );
        entrada2 = br.readLine();
        radio = Integer.parseInt(entrada1); //aqui convertimos de String a int para poder operar matematicamente
        altura = Integer.parseInt(entrada2);
        System.out.println("El radio del rectangulo es:\t"+ radio);
        System.out.println("La altura del rectangulo es:\t"+ altura);
        System.out.println("El área del rectangulo es:\t"+ (2 * Math.PI * radio * altura));
        System.out.println("El volumen del rectangulo es:\t"+ (Math.PI * Math.pow(radio, 2) * altura) );
	}

}

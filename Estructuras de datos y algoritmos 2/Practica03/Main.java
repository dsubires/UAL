package Practica03;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		String directorio = System.getProperty("user.dir")+
				File.separator+"src"+File.separator+"Practica03"+
				File.separator+"Datos"+File.separator;

		/**
		 * datos de entrada del programa
		 * voy a darle un valor fijo, constante, en todas las ejecuciones
		 * en nuestro caso las he definido como constantes en la
		 * clase ubicacion
		**/
		
		
		
		/* 
		 * creo las ubicaciones de los intercambiadores,
		 * esto solo lo ejecutare una vez.
		 */
		/*for (int i=1; i<=25; i++) {
			String nombreInter = directorio + "intervz"+i+".txt";
			String nombreUbica = directorio + "ubica"+i+".txt";
			Reparacion repara = new Reparacion ();
			repara.leerAveriasSinUbicacion(nombreInter);
			repara.generarUbicacion ();
			repara.guardarAveriasConUbicacion (nombreUbica);
		}
		
		for (int i=1; i<=25; i++) {
			String nombreUbica = directorio + "ubica"+i+".txt";
			Reparacion repara = new Reparacion ();
			repara.leerAveriasConUbicacion(nombreUbica);
		}*/
		
		
	
	//	String nombreUbica = directorio + "ubicaTest.txt";
		String nombreUbica = directorio + "testUbica.txt";
		Reparacion r = new Reparacion();
		r.leerAveriasConUbicacion(nombreUbica);
		long tiempoAntes = System.currentTimeMillis();
		System.out.println(r.calculaRuta());
		long tiempoDespues = System.currentTimeMillis();
		System.out.println(tiempoDespues - tiempoAntes);
		
		
	/*
	 // generar resultadosUbicaI.txt	
		for(int i=0; i <= 25; i++){
			String nombreUbica = directorio + "ubica"+i+".txt";
			String ficheroSalida = directorio + "resultadoUbica"+i+".txt";		
			Reparacion r = new Reparacion();
			r.leerAveriasConUbicacion(nombreUbica);
			String output = "";
			output = r.calculaRuta();
			try {
				FileWriter fw = new FileWriter(new File(ficheroSalida));
				fw.write(output);
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	*/
		//
		// Obtener tiempo de los casos de prueba para obtener las graficas
		//
	/*
		System.out.println("n\tt(n)");
		long max = Long.MIN_VALUE;
		long sum;
		for(int i=1; i<=16; i++){
			sum = 0;
			String nombreUbica = directorio + "ubica"+i+".txt";
			Reparacion r = new Reparacion();
			r.leerAveriasConUbicacion(nombreUbica);
			System.out.print(r.getNumeroAverias() + "\t");
			for(int j=0; j<10; j++){
				long tiempoAntes = System.currentTimeMillis();
				r.calculaRuta();
				long tiempoDespues = System.currentTimeMillis();
				long temp = tiempoDespues - tiempoAntes;
				if(temp > max)
					max = temp;
				sum += temp;
			}
			sum -= max;
			System.out.println(sum/9);
		}
*/

	}
	

}

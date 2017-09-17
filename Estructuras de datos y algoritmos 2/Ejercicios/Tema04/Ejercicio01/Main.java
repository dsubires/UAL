package EjerciciosTema4.Ejercicio01;

import java.io.File;

public class Main {

	public static void main(String[] args) {

		
		System.out.println("*****Tiempos problema mochila Greedy vs Programacion Dinamica*****");
		System.out.println("tamaño(n)\tT(Greedy)\tT(PDinamica)");
		
		for(int i=1; i<11; i++){
			String file = System.getProperty("user.dir");
			file = file + File.separator + "src" + File.separator
					+ "EjerciciosTema4" + File.separator + "Ejercicio01"
					+ File.separator + "Datos" + File.separator;
		
		file += "mochila"+i+".txt";
		
		Mochila m = new Mochila(file);
		System.out.print(m.getNumeroTotalObjetos()+"\t\t");
		long tiempoAntes = System.nanoTime();
//		System.out.println(m.getMochilaGreedy());
		m.getMochilaGreedy();
		long tiempoDespues = System.nanoTime();
		System.out.print(tiempoDespues - tiempoAntes + "\t");
		tiempoAntes = System.nanoTime();
	//	System.out.println(m.getMochilaDinamica());
		m.getMochilaDinamica();
		tiempoDespues = System.nanoTime();
		System.out.print(tiempoDespues - tiempoAntes);
//				
		System.out.println();
		}
	}

}

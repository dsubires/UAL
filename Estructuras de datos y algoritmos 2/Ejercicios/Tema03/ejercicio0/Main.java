package EjerciciosTema3.Ejercicio00;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		
		String file = "";
		ArrayList<Long> tiempos = new ArrayList<Long>();
		ArrayList<Integer> numAristas = new ArrayList<Integer>();
		for(int i=1; i<6;i++){
			 file = System.getProperty("user.dir");
			 file = file + File.separator + "src" + File.separator
						+ "EjerciciosTema3" + File.separator + "Ejercicio00"
						+ File.separator + "Datos" + File.separator;
			file += "grafo" + i+".txt";
			Grafo g = new Grafo(file);
			long tiempoAntes = System.nanoTime();
			g.mejorLocalizacion();
			long tiempoDespues = System.nanoTime();
			tiempos.add(tiempoDespues - tiempoAntes);
			numAristas.add(g.getNumVertices());
		}
		
		System.out.println("*********Tiempos:*********\n");
		System.out.println("Aristas:\tTiempo");
		Iterator<Long> iter1 = tiempos.iterator();
		Iterator<Integer> iter2 = numAristas.iterator();
		while(iter1.hasNext()){
			System.out.println(+iter2.next()+"\t\t"+iter1.next());
		}
	}
	
	

}

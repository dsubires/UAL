package Practica03;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;


public class Reparacion {

	public static final double SEP1 = 7.0;
	public static final double SEP2 = 3.0;
	public static final String TALLER = "C1A1";

	private ArrayList<Averia> lista;
	private Averia taller;
	private double[][] L;
	// atributos para el algoritmo
	private HashMap<EstructuraAveriaLista, Double> mapa;
	private HashMap<EstructuraAveriaLista, Averia> mapaJ;

	public Reparacion() {
		lista = new ArrayList<Averia>();
		taller = new Averia(0, 0, TALLER);
	}

	public void leerAveriasSinUbicacion(String nombreArchivo) {
		try {
			Scanner entrada = new Scanner(new File(nombreArchivo));
			entrada.useLocale(Locale.ENGLISH);
			int numeroAverias = entrada.nextInt();
			for (int i = 0; i < numeroAverias; i++) {
				int numInter = entrada.nextInt();
				double porcentaje = entrada.nextDouble();
				Averia averia = new Averia(numInter, porcentaje);
				lista.add(averia);
			}
			entrada.close();
		} catch (IOException e) {
		}
	}

	public void generarUbicacion() {
		for (Averia averia : lista) {
			averia.setUbica(new Ubicacion());
		}
	}

	public void guardarAveriasConUbicacion(String nombreArchivo) {
		try {
			FileWriter f = new FileWriter(new File(nombreArchivo));
			f.write(lista.size() + "\n");
			for (Averia averia : lista) {
				f.write(averia + "\n");
			}
			f.close();
		} catch (IOException e) {
		}
	}

	public void leerAveriasConUbicacion(String nombreArchivo) {
		try {
			Scanner entrada = new Scanner(new File(nombreArchivo));
			entrada.useLocale(Locale.ENGLISH);
			int numeroAverias = entrada.nextInt();
			for (int i = 0; i < numeroAverias; i++) {
				int numInter = entrada.nextInt();
				double porcentaje = entrada.nextDouble();
				String nombreUbicacion = entrada.next();
				Averia averia = new Averia(numInter, porcentaje, nombreUbicacion);
				lista.add(averia);
			}
			entrada.close();
		} catch (IOException e) {
		}
	}

	/**
	 * Metodo que divide la lista de averias en tres subconjuntos y realiza un recorrido minimizando la distancia teniendo en cuenta el punto de partida
	 * y de finalizacion de la ruta, además de el punto de partida y de finalización de la ruta de cada subconjunto  
	 * @return Devuelve el coste total del cicloy el recorrido
	 */
	public String calculaRuta(){
		
	//	if(lista.isEmpty())
	//		return "La lista de averias está vacía";
		
		ArrayList<Averia> lista1, lista2, lista3;
		int n = 0;
		String output = "";
		double distancia = 0;
		ArrayList<Averia> caminoSolucion = new ArrayList<Averia>();

		lista1 = new ArrayList<Averia>();
		while (n < lista.size() && lista.get(n).getPorcentaje() >= SEP1) {
			lista1.add(lista.get(n));
			n++;
		}
		lista2 = new ArrayList<Averia>();
		while (n < lista.size() && lista.get(n).getPorcentaje() >= SEP2) {
			lista2.add(lista.get(n));
			n++;
		}
		lista3 = new ArrayList<Averia>();
		while (n < lista.size()) {
			lista3.add(lista.get(n));
			n++;
		}

		
		
		mapa = new HashMap<EstructuraAveriaLista, Double>();
		mapaJ = new HashMap<EstructuraAveriaLista, Averia>();
		Averia ultimo;
		
		distancia += calculaRutaR(taller, lista1, taller);
		caminoSolucion.addAll(recorridoSolucion(taller, lista1));
		ultimo = caminoSolucion.get(caminoSolucion.size() - 1);
		
		distancia += calculaRutaR(ultimo, lista2, ultimo);
		caminoSolucion.addAll(recorridoSolucion(ultimo, lista2));
		ultimo = caminoSolucion.get(caminoSolucion.size() - 1);
		
		distancia += calculaRutaR(ultimo, lista3, taller);
		caminoSolucion.addAll(recorridoSolucion(ultimo, lista3));
	
	
		/*
		distancia += calculaRutaR(taller, lista, taller);
		caminoSolucion.addAll(recorridoSolucion(taller, lista));
	
		*/

		output += "Número de averías: "+ lista.size() +"\nDistancia solucion: "+distancia + "\nRecorrido: \n";
		for(Averia av : caminoSolucion){
			output += av.toString()+"\n";
		}
	
		
		return output;
		
	}
	
	/**
	 * 
	 * @param desde punto de partida de la ruta
	 * @param conjunto conjunto de averias para formar la ruta
	 * @return distancia total de la ruta
	 */
	private double calculaRutaR(Averia desde, ArrayList<Averia> conjunto, Averia finalRuta){
		double masCorto,distancia;
		Averia masCortoA;
		EstructuraAveriaLista eal;
		if(conjunto.isEmpty()){
			double temp =  desde.calcularDistancia(finalRuta);
			eal = new EstructuraAveriaLista(desde, new ArrayList<Averia>());
			mapa.put(eal, temp);
			mapaJ.put(eal, finalRuta);
			return  temp;
		}else{
			if(mapa.get(new EstructuraAveriaLista(desde, conjunto)) != null)
				return mapa.get(new EstructuraAveriaLista(desde, conjunto));	
			else{
				masCorto = Double.MAX_VALUE;
				masCortoA = null;
				
				for(Averia av : conjunto){
					ArrayList<Averia> conjuntoMenosDesde = (ArrayList<Averia>) conjunto.clone();
					conjuntoMenosDesde.remove(av);
					distancia = desde.calcularDistancia(av) + calculaRutaR(av, conjuntoMenosDesde,finalRuta);
									
					if(distancia < masCorto){
						masCorto = distancia;
						masCortoA = av;
					}
				}
				
				
				eal = new EstructuraAveriaLista(desde, conjunto);
				mapa.put(eal, masCorto);
				mapaJ.put(eal, masCortoA);
				return masCorto;
			}
		}
	}
	
	private ArrayList<Averia> recorridoSolucion(Averia inicio, ArrayList<Averia> conjunto){
		ArrayList<Averia> output = new ArrayList<Averia>();
		Averia current = mapaJ.get(new EstructuraAveriaLista(inicio, conjunto));
		ArrayList<Averia> conjuntoMenosDesde = (ArrayList<Averia>) conjunto.clone();
		int n = 0;
		while( n < conjunto.size() ){
			output.add(current);
			conjuntoMenosDesde.remove(current);
			current = mapaJ.get(new EstructuraAveriaLista(current, conjuntoMenosDesde));
			n++;
		}	
		
		return output;
	}
	

/* Método lineal
 	private double calculaRuta(Averia inicio, ArrayList<Averia> conjunto) {
		// int n = listaActual.size()+1;
		int n = conjunto.size();
		int coln = (int) Math.pow(2, n);
		generarTablaL();
		mapa = new HashMap<Averia, HashMap<ArrayList<Averia>, Double>>();
		inicioRuta = inicio;
		HashMap<ArrayList<Averia>, Double> temp;

		for (int i = 0; i <= n; i++) { // tamaño subconjunto
			for (int j = 0; j < n; j++) { // vertice salida
				Averia desde = conjunto.get(j);
				if(i == 0){
					temp = new HashMap<ArrayList<Averia>, Double>();
					temp.put(new ArrayList<Averia>(), desde.calcularDistancia(inicioRuta));
					mapa.put(desde, temp);
				}else{
					ArrayList<Averia> conjuntoTemp = (ArrayList<Averia>) conjunto.clone();
					conjuntoTemp.remove(conjuntoTemp.indexOf(desde));
					ArrayList<ArrayList<Averia>> conjuntos = calculaConjuntos(i,conjuntoTemp);
					
					for (int k = 0; k < Math.pow(n, i); k++) {  // numero subconjuntos posibles de tamaño n
						
						if( i == 1){ // subconjuntos de 1 elemento
							if(j != k){
								Averia hasta = conjunto.get(j);
								temp = new HashMap<ArrayList<Averia>, Double>();
								ArrayList<Averia> al = new ArrayList<Averia>();
								al.add(hasta);
								temp.put(al, desde.calcularDistancia(hasta) + mapa.get(hasta).get(new ArrayList<Averia>()) );
								mapa.put(desde, temp);
								//////
							}
						}else{		// subconjuntos de más de 1 elemento
							
						}
						
					}
				}
			}

		}

		return 0;
	}*/
	
/*
	private void generarTablaL() {
		// TODO Auto-generated method stub
		L = new double[lista.size()][lista.size()];
		for (int i = 0; i < L.length; i++) {
			// System.out.println(v.size());
			// System.out.println(v.get(0));
			for (int j = 0; j < L[i].length; j++) {
				if (i == j )
					L[i][j] = 0.0;
				else
					L[i][j] = lista.get(i).calcularDistancia(
							lista.get(j));
			}
		}
	}
*/

	public int getNumeroAverias(){
		return lista.size();
	}
	
	public int getNumeroEntradasTabla(){
		return mapa.size();
	}
	
}

package Practica03;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Conjunto {

	private int numIntercambiadores;
	private double salidaCentral;
	private ArrayList<Intercambiador> lista;
	private double entradaCentral;
	private ArrayList<String> listaErroneos;
	private ArrayList<String> listaIntercambiadores;
	private ArrayList<String> listaTramos;
	private ArrayList<String> listaIntercambiadoresVoraz;
	private ArrayList<String> listaTramosVoraz;
	
	public Conjunto (String nombreFichero) {
		try {
			Scanner f = new Scanner (new File(nombreFichero));
			f.useLocale(Locale.ENGLISH);
			numIntercambiadores = f.nextInt();
			lista = new ArrayList<Intercambiador> ();
			listaErroneos = new ArrayList<String> ();
			listaIntercambiadores = new ArrayList<String>();
			listaTramos = new ArrayList<String>();
			listaIntercambiadoresVoraz = new ArrayList<String>();
			listaTramosVoraz = new ArrayList<String>();
			salidaCentral = f.nextDouble();
			for (int i=1; i<=numIntercambiadores; i++) {
				String nombre = i+"";
				double entrada = f.nextDouble();
				double salida = f.nextDouble();
				Intercambiador inter = new Intercambiador (nombre, 
						entrada, salida);
				lista.add(inter);
			}
			entradaCentral = f.nextDouble();
			f.close();
		}
		catch (IOException e) {
		}
	}
	
	public int size () {
		return lista.size();
	}
	
	public void analisisPrevio () {
		double anterior, sig1, sig2, actual;
		
		for (int i=0; i<lista.size(); i++) {
			actual = lista.get(i).getEntrada();
			if (i == 0) 
				anterior = salidaCentral;
			else
				anterior = lista.get(i-1).getSalida();
			sig1 = lista.get(i).getSalida();
			if (i < lista.size()-1) 
				sig2 = lista.get(i+1).getEntrada();
			else 
				sig2 = entradaCentral;
			if ((actual > anterior) ||
					(actual<anterior && sig1>actual && sig2==sig1)) {
				listaErroneos.add(lista.get(i).getNombre()+"e");
				lista.get(i).setEntrada(salidaCentral);
			}
			actual = lista.get(i).getSalida();
			anterior = lista.get(i).getEntrada();
			//en medio
			if (i < lista.size()-2) {
				sig1 = lista.get(i+1).getEntrada();
				sig2 = lista.get(i+1).getSalida();
			}
			else {
				//penultima
				if (i == lista.size()-2) {
					sig1 = lista.get(i+1).getEntrada();
					sig2 = lista.get(i+1).getSalida();
				}
				else {
					sig1 = entradaCentral;
					sig2 = entradaCentral;
				}
			}
			if ((actual > anterior) ||
					(actual<anterior && sig1>actual && sig2==sig1)) {
				listaErroneos.add(lista.get(i).getNombre()+"s");
				lista.get(i).setSalida(lista.get(i).getEntrada());
			}
		}
		//System.out.println(listaErroneos);
	}
	
	public void comprobarFugas () {
		comprobarFugas (salidaCentral, 0, lista.size()-1);
		if (lista.get(lista.size()-1).getSalida() > entradaCentral) {
			String nombre = (numIntercambiadores+1) + "";
			listaTramos.add(nombre);
		}
		System.out.println("Intercambiadores divide y venceras");
		System.out.println(listaIntercambiadores);
		System.out.println("Tramos divide y venceras");
		System.out.println(listaTramos);
	}

	/**
	 * METODO RECURSIVO DIVIDE Y VENCERAS
	 * este es menos eficiente
	 * tiene coste n 
	 * porque aunque el metodo va dividiendo la lista en dos partes 
	 * iguales, al final siempre llega a un vector de un elemento
	 * por eso es el coste n
	 */
	/*private void comprobarFugas(double valorAnterior, int ini, int fin) {
		if (ini > fin)
			return;
		if (ini == fin) {
			Intercambiador inter = lista.get(ini);
			if (valorAnterior > inter.getEntrada())
				listaTramos.add(inter.getNombre());
			if (inter.getEntrada() > inter.getSalida())
				listaIntercambiadores.add(inter.getNombre());
			return;
		}
		int med = (ini+fin) / 2;
		comprobarFugas (valorAnterior, ini, med);
		comprobarFugas (lista.get(med).getSalida(), med+1, fin);
	}*/
	
	/**
	 * METODO RECURSIVO DIVIDE Y VENCERAS
	 * es casi igual que el otro, con la diferencia de que cuando 
	 * tengo un trozo de la lista donde la entrada del primero coincide
	 * con la salida del ultimo, no hace falta llamar recursivamente y 
	 * me salto ese trozo
	 * es mas rápido porque habra trozos donde no tenga que llegar a
	 * un elemento, pero en otros trozo si
	 * la complejidad sigue siendo n
	 */
	private void comprobarFugas(double valorAnterior, int ini, int fin) {
		if (ini > fin)
			return;
		Intercambiador inter = lista.get(ini);
		if (lista.get(ini).getEntrada() == lista.get(fin).getSalida()) {
			if (valorAnterior > inter.getEntrada())
				listaTramos.add(inter.getNombre());
			return;
		}
		else {
			if (ini==fin && inter.getEntrada() > inter.getSalida()) {
				listaIntercambiadores.add(inter.getNombre());
				return;
			}
		}
		int med = (ini+fin) / 2;
		comprobarFugas (valorAnterior, ini, med);
		comprobarFugas (lista.get(med).getSalida(), med+1, fin);
	}
	
	public void comprobarFugasVoraz () {
		PriorityQueue<PorcentajeBajada> colaPrioridad =
					new PriorityQueue<PorcentajeBajada>();
		PorcentajeBajada p, p2;
		double porc, antes, despues;
		
		porc = (salidaCentral - entradaCentral) * 100 / salidaCentral;
		p = new PorcentajeBajada(0, lista.size()-1, porc);
		colaPrioridad.add (p);
		while ( ! colaPrioridad.isEmpty()) {
			p = colaPrioridad.remove();
			//System.out.printf("%d - %d - %.2f %%\n", p.getIzq(),
				//	p.getDer(), p.getPorc());
			if (p.getIzq() == p.getDer()) {
				if (lista.get(p.getIzq()).getEntrada() != 
						lista.get(p.getIzq()).getSalida()) {
					//fuga por intercambiador
					listaIntercambiadoresVoraz.add
						(lista.get(p.getIzq()).getNombre()+
							" "+p.getPorc());
				}
				else {
					//fuga por tramo
					listaTramosVoraz.add
						(lista.get(p.getIzq()).getNombre()+
								" "+p.getPorc());
				}
			}
			else {
				int med = (p.getIzq() + p.getDer()) / 2;
				//trozo de la izquierda
				if (p.getIzq() == 0)
					antes = salidaCentral;
				else
					antes = lista.get(p.getIzq()-1).getSalida();
				despues = lista.get(med).getSalida();
				if (antes != despues) {
					porc = (antes - despues) * 100 / antes;
					p2 = new PorcentajeBajada(p.getIzq(), med, porc);
					colaPrioridad.add(p2);
				}
				//trozo de la derecha
				antes = lista.get(med).getSalida();
				despues = lista.get(p.getDer()).getSalida();
				if (antes != despues) {
					porc = (antes - despues) * 100 / antes;
					p2 = new PorcentajeBajada(med+1, p.getDer(), porc);
					colaPrioridad.add(p2);
				}
			}
		}
		System.out.println("Intercambiadores Voraz");
		System.out.println(listaIntercambiadoresVoraz);
		System.out.println("Tramos Voraz");
		System.out.println(listaTramosVoraz);

	}

	public void guardarIntercambiadoresVZ(String nombreInter) {
		try {
			FileWriter f = new FileWriter (new File (nombreInter));
			
			f.write(listaIntercambiadoresVoraz.size()+"\n");
			for (String s : listaIntercambiadoresVoraz) {
				f.write(s+"\n");
			}
			f.close ();
		}
		catch (IOException e) {
			System.out.println("Error de escritura en el fichero de intercambiadores");
		}
	}
	
}

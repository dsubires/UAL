package Practica2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.Scanner;

import practica01.Intercambiador;

public class Comprobador {

	private int numeroIntercambiadores;
	private double salidaCentral;
	private double entradaCentral;
	private ArrayList<Intercambiador> listaIntercambiadores;
	private ArrayList<String> listaDefectuosos;
	private ArrayList<String> listaIntercambiadoresConFuga;
	private ArrayList<String> listaTramosConFuga;
	static int i = 0;

	public Comprobador(String nombreFichero) {
		try {
			Scanner f = new Scanner(new File(nombreFichero));
			f.useLocale(Locale.ENGLISH);
			numeroIntercambiadores = f.nextInt();
			listaIntercambiadores = new ArrayList<Intercambiador>();
			listaDefectuosos = new ArrayList<String>();
			listaIntercambiadoresConFuga = new ArrayList<String>();
			listaTramosConFuga = new ArrayList<String>();
			salidaCentral = f.nextDouble();
			for (int i = 1; i <= numeroIntercambiadores; i++) {
				String nombre = i + "";
				double entrada = f.nextDouble();
				double salida = f.nextDouble();
				Intercambiador inter = new Intercambiador(nombre, entrada,
						salida);
				listaIntercambiadores.add(inter);
			}
			entradaCentral = f.nextDouble();
			f.close();
		} catch (IOException x) {
		}
	}

	public void comprobarErrores() {
		double valorAnterior, siguiente1, siguiente2, actual;
		Intercambiador interInicio, interNext;

		for (int i = 0; i < listaIntercambiadores.size(); i++) {

			// -----Almacenamos los intercambiadores con los que
			// trabajamos-------
			interInicio = listaIntercambiadores.get(i);
			if(i<=listaIntercambiadores.size()-2)
			interNext = listaIntercambiadores.get(i + 1);
			else
				interNext=null;
			// --------------------------------------------------------------------

			actual = interInicio.getEntrada();

			// -----------Si estamos en el primer elemento, el valor anterior
			// sera la salida-------------
			if (i == 0)
				valorAnterior = salidaCentral;
			else
				valorAnterior = listaIntercambiadores.get(i - 1).getSalida();
			siguiente1 = interInicio.getSalida();

			// -----------Si estamos en el penultimo elemento, siguiente2 sera
			// la entrada-----------
			if (i <= listaIntercambiadores.size() - 2)
				siguiente2 = interNext.getEntrada();
			else
				siguiente2 = entradaCentral;

			// -------------Comprobacion de manometro de entrada
			// erroneo-------------------------
			if ((actual > valorAnterior)
					|| (actual < valorAnterior && siguiente1 > actual && siguiente2 <= siguiente1)) {
				listaDefectuosos.add(interInicio.getNombre() + "e");
				listaIntercambiadores.get(i).setEntrada(valorAnterior);
			}
			actual = interInicio.getSalida();
			valorAnterior = interInicio.getEntrada();

			if (i <= listaIntercambiadores.size() - 2) {
				siguiente1 = interNext.getEntrada();
				siguiente2 = interNext.getSalida();
			} else {

				siguiente1 = entradaCentral;
				siguiente2 = entradaCentral;

			}

			// --------------Comprobacion de manometro de salida
			// erroneo----------------------
			if ((actual > valorAnterior)
					|| (actual < valorAnterior && siguiente1 > actual && siguiente2 == siguiente1)) {
				listaDefectuosos.add(interInicio.getNombre() + "s");
				listaIntercambiadores.get(i)
						.setSalida(interInicio.getEntrada());
			}
		}

	}

	public void greedy() {

		PriorityQueue<Fuga> cola = new PriorityQueue<Fuga>();
		if (entradaCentral < salidaCentral)
			cola.add(new Fuga(salidaCentral, 0, entradaCentral,
					listaIntercambiadores.size() - 1));
		else
			return;

		// ------Variables-------------
		Intercambiador intercambiadorInicio, intercambiadorMitad;
		double iniEnter;
		double iniExit;
		double medEnter;
		double medExit;
		double fin = entradaCentral;
		double valorAnterior;
		int posicionA, posicionB, posicionM;

		// ------------------------------

		while (!cola.isEmpty()) {

			// ----Saca fuga de la cola------
			Fuga fuga = cola.poll();
			// ------------------------------

			// --------Datos de la fuga------
			posicionA = fuga.getPosI();
			posicionB = fuga.getPosF();
			posicionM = (posicionA + posicionB) / 2;
			intercambiadorInicio = listaIntercambiadores.get(posicionA);
			intercambiadorMitad = listaIntercambiadores.get(posicionM);
			iniEnter = intercambiadorInicio.getEntrada();
			iniExit = intercambiadorInicio.getSalida();
			medEnter = intercambiadorMitad.getEntrada();
			medExit = intercambiadorMitad.getSalida();
			// ---------------------------------------------------

			// --------------CASO BASE----------------------------
			if (posicionA == posicionB) {

				// ----si es el ultimo elemento, comprueba si hay fuga en el
				// tramo a la entrada
				if (posicionA == listaIntercambiadores.size() - 1) {
					if (entradaCentral < iniExit)
						listaTramosConFuga.add(listaIntercambiadores.size() + 1
								+ "");
				}

				// ----si es el primer elemento, el valor anterior es la salida
				if (posicionA == 0)
					valorAnterior = salidaCentral;
				else
					valorAnterior = listaIntercambiadores.get(posicionA - 1)
							.getSalida();

				// ----Si la salida anterior es menor que la entrada del actual
				// -> fuga en el tramo
				if (valorAnterior > iniEnter) {
					listaTramosConFuga.add(intercambiadorInicio.getNombre());

				}

				// -----Si la salida del actual es menor que la entrada del
				// actual -> fuga en el intercambiador
				if (iniEnter > iniExit)
					listaIntercambiadoresConFuga.add(intercambiadorInicio
							.getNombre());

				continue;
			}
			// ---------------------------------------------------

			// ---------DIVISION DEL PROBLEMA--------------------

			// --------Mitad izquierda-----------
			if (iniEnter > medExit)
				cola.add(new Fuga(iniEnter, posicionA, medExit, posicionM));
			// --------Mitad derecha-------------

			if (medEnter > fin)
				cola.add(new Fuga(medExit, posicionM + 1, fin, posicionB));

		}
	}

	public void comprobarFugasDYVMejorado() {
		comprobarFugasDYVMejorado(salidaCentral, 0,
				listaIntercambiadores.size() - 1);
		if (listaIntercambiadores.get(listaIntercambiadores.size() - 1)
				.getSalida() > entradaCentral) {
			String nombre = (numeroIntercambiadores + 1) + "";
			listaTramosConFuga.add(nombre);
		}
		// System.out.println(listaIntercambiadoresConFuga.toString());
		// System.out.println(listaTramosConFuga.toString());
	}

	private void comprobarFugasDYVMejorado(double valorAnterior, int inicio,
			int fin) {

		if (inicio == fin) {
			Intercambiador inter = listaIntercambiadores.get(inicio);
			if (valorAnterior > inter.getEntrada())
				listaTramosConFuga.add(inter.getNombre());
			if (inter.getEntrada() > inter.getSalida())
				listaIntercambiadoresConFuga.add(inter.getNombre());
			return;
		}

		int medio = (inicio + fin) / 2;
		double salidaMedio = listaIntercambiadores.get(medio).getSalida();
		if (valorAnterior > salidaMedio)
			comprobarFugasDYVMejorado(valorAnterior, inicio, medio);
		if (salidaMedio > listaIntercambiadores.get(fin).getSalida())
			comprobarFugasDYVMejorado(salidaMedio, medio + 1, fin);
	}

	// ---------------------------------------------------------------------------
	public void comprobarFugasDYV() {
		comprobarFugasDYV(salidaCentral, 0, listaIntercambiadores.size() - 1);
		if (listaIntercambiadores.get(listaIntercambiadores.size() - 1)
				.getSalida() > entradaCentral) {
			String nombre = (numeroIntercambiadores + 1) + "";
			listaTramosConFuga.add(nombre);
		}

	}

	private void comprobarFugasDYV(double valorAnterior, int inicio, int fin) {

		if (inicio == fin) {
			Intercambiador intercambiador = listaIntercambiadores.get(inicio);
			if (valorAnterior > intercambiador.getEntrada())
				listaTramosConFuga.add(intercambiador.getNombre());
			if (intercambiador.getEntrada() > intercambiador.getSalida())
				listaIntercambiadoresConFuga.add(intercambiador.getNombre());
			return;
		}

		int medio = inicio + fin;
		medio = medio / 2;
		double salidaMedio = listaIntercambiadores.get(medio).getSalida();
		comprobarFugasDYV(valorAnterior, inicio, medio);
		comprobarFugasDYV(salidaMedio, medio + 1, fin);
	}

	public int size() {
		return listaIntercambiadores.size();
	}

	
	
	
	public int getSizeDefectuosos() {
		return listaDefectuosos.size();
	}

	public int getSizeIntercambiadoresConFuga() {
		return listaIntercambiadoresConFuga.size();
	}

	public int getSizeTramosConFuga() {
		return listaTramosConFuga.size();
	}

	public String getListaDefectuosos() {
		String resultado = "";
		int x = 5;
		for (int i = 0; i < listaDefectuosos.size() - 1; i++) {
			resultado += "[" + listaDefectuosos.get(i) + "] ";
			x--;
			if (x == 0) {
				resultado += "\r\n";
				x = 5;
			}
		}
		return resultado;
	}

	public String getListaIntercambiadoresConFuga() {
		String resultado = "";
		int x = 5;
		for (int i = 0; i < listaIntercambiadoresConFuga.size() - 1; i++) {
			resultado += "[" + listaIntercambiadoresConFuga.get(i) + "] ";
			x--;
			if (x == 0) {
				resultado += "\r\n";
				x = 5;
			}
		}
		return resultado;
	}

	public String getListaTramosConFuga() {
		String resultado = "";
		int x = 5;
		for (int i = 0; i < listaTramosConFuga.size() - 1; i++) {
			resultado += "[" + listaTramosConFuga.get(i) + "] ";
			x--;
			if (x == 0) {
				resultado += "\r\n";
				x = 5;
			}
		}
		return resultado;
	}
	
	
	
	
	
}

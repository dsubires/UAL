package Practica03;

import java.util.LinkedList;

public class Solucion {

	private double distancia;
	private LinkedList<Averia> orden;
	
	public Solucion () {
		distancia = 0;
		orden = new LinkedList<Averia> ();
	}

	public Solucion(double distancia, LinkedList<Averia> orden) {
		this.distancia = distancia;
		this.orden = orden;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public LinkedList<Averia> getOrden() {
		return orden;
	}

	public void setOrden(LinkedList<Averia> orden) {
		this.orden = orden;
	}
	
	public void insertarPrincipio (Averia averia, double valor) {
		orden.addFirst(averia);
		distancia = distancia + valor;
	}
	
	public void insertarFinal (Averia averia, double valor) {
		orden.addLast(averia);
		distancia = distancia + valor;
	}
	
	public Averia getUltimo () {
		return orden.getLast();
	}
	
	public Averia getPrimero() {
		return orden.getFirst();
	}

	public void vueltaTaller(Averia taller) {
		distancia = distancia + getUltimo().calcularDistancia(taller);
		orden.add(taller);
	}

	public void añadirSolucion(Solucion solucion) {
		solucion.orden.removeFirst();
		this.orden.addAll(solucion.orden);
		distancia = distancia + solucion.distancia;
	}
}

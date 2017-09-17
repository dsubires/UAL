package Practica03;

import java.util.Scanner;

public class Ubicacion {

	public static final int n = 20; //numero avenidas
	public static final int m = 20; //numero calles
	//public static final int tm = 75; //tamaño manzana
	//public static final int an = 100; //ancho avenidas y calles
	
	public static final int tm = 1; //tamaño manzana
	public static final int an = 1; //ancho avenidas y calles
	
	private int calle;
	private int avenida;
	private String nombre;

	public Ubicacion () {
		calle = (int) (Math.random()*m) + 1;
		avenida = (int) (Math.random()*n) + 1;
		if (Math.random() <= 0.5)
			nombre = "A"+avenida+"C"+calle;
		else
			nombre = "C"+calle+"A"+avenida;
	}
	
	public Ubicacion (String nombre) {
		this.nombre = nombre;
		if (nombre.charAt(0) == 'A') {
			int pos = nombre.indexOf('C');
			avenida = Integer.parseInt(nombre.substring(1, pos));
			calle = Integer.parseInt(nombre.substring(pos+1));
		}
		else {
			int pos = nombre.indexOf('A');
			calle = Integer.parseInt(nombre.substring(1, pos));
			avenida = Integer.parseInt(nombre.substring(pos+1));
		}
	}
	
	public double calcularDistancia (Ubicacion otra) {
		// la primera letra de cada direccion es diferente
		if (this.nombre.charAt(0) != otra.nombre.charAt(0)) {
			double distancia =  (Math.abs(this.avenida - otra.avenida) +
					Math.abs(this.calle - otra.calle)) * (tm+an);
			if ((this.avenida - otra.avenida) *(this.calle - otra.calle) <= 0)
				distancia = distancia + 1 * (tm+an);
			return distancia;
		}
		else {
			//las dos comienzan por la misma letra
			if (this.nombre.charAt(0) == 'A') {
				if (this.calle == otra.calle)
					return (Math.abs(this.avenida - otra.avenida) +
						Math.abs(this.calle - otra.calle) + 1) * (tm+an);
				else
					return (Math.abs(this.avenida - otra.avenida) +
						Math.abs(this.calle - otra.calle)) * (tm+an);
			}
			else {
				if (this.avenida == otra.avenida)
					return (Math.abs(this.avenida - otra.avenida) +
						Math.abs(this.calle - otra.calle)  +1 ) * (tm+an);
				else
					return (Math.abs(this.avenida - otra.avenida) +
						Math.abs(this.calle - otra.calle)) * (tm+an);
			}
		}
	}

	public int getCalle() {
		return calle;
	}

	public void setCalle(int calle) {
		this.calle = calle;
	}

	public int getAvenida() {
		return avenida;
	}

	public void setAvenida(int avenida) {
		this.avenida = avenida;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}

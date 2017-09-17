package org.eda1.examenSegundoParcial.ejercicio01;

import java.util.Iterator;
import java.util.TreeSet;

public class DatosCiudad implements Comparable {
	String pais;
	String continente;
	TreeSet<String> direcciones = new TreeSet<String>();

	public DatosCiudad(String pais, String conti, TreeSet<String> direc) {
		this.pais = pais;
		this.continente = conti;
		this.direcciones = direc;
	}

	public String getPais() { 
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getContinente() { 
		return continente;
	}

	public void setContinente(String continente) { 
		this.continente = continente;
	}

	public void setDirecciones(TreeSet<String> direcciones) { 
		this.direcciones = direcciones;
	}

	public TreeSet<String> getDirecciones(){ 
		return direcciones;
	}

	public int compareTo(Object otroDatosCuidad){ 
		DatosCiudad d = (DatosCiudad) otroDatosCuidad;
		if(this.direcciones.size() > d.direcciones.size())
			return -1;
		else if(this.direcciones.size() < d.direcciones.size())
			return 1;
		else return 0;
	}
	// Otras funciones que considere necesarias
	
	public String toString(){
		//Spain.Europe(Castellana, Chamartin, Gran_Via, Juan_Bravo, Serrano, Velazquez)>
		String output = pais+"."+continente+"(";
		Iterator<String> iterador = direcciones.iterator();
		while(iterador.hasNext()){
			output += iterador.next();
			if(iterador.hasNext())
				output+= ", ";
		}
		output += ")";
		return output;
	}
}
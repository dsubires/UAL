package org.eda1.practica01.ejercicio02;

import java.util.ArrayList;

public class ProyectoCiudades {
	
	
	private String proyecto;
	private ArrayList<String> ciudades;
	
	public ProyectoCiudades(){
		proyecto = "";
		ciudades = new ArrayList<String>();
	}
	
	public ProyectoCiudades(String proy){
		proyecto = proy;
		ciudades = new ArrayList<String>();
	}
	
	public void setProyecto(String proy){
		proyecto = proy;
	}
	
	public String getProyecto(){
		return proyecto;
	}
	
	public void addCiudad(String ciudad){
		ciudades.add(ciudad);
	}
	
	public ArrayList<String> getCiudades(){
		return ciudades;
	}
	
	public String getCiudad(int index){
		return ciudades.get(index);
	}
	
	public int size(){
		return ciudades.size();
	}
	
	
	
	
	

}

package org.eda1.practica01.ejercicio02;

import java.util.ArrayList;
import java.util.ListIterator;

public class EmpresaProyectos {
	
	private String empresa;
	private ArrayList<ProyectoCiudades> proyectosCiudades;
	
	public EmpresaProyectos(){
		empresa = "";
		proyectosCiudades = new ArrayList<ProyectoCiudades>();
	}
	
	public EmpresaProyectos(String empresa){
		this.empresa = empresa;
		proyectosCiudades = new ArrayList<ProyectoCiudades>();
	}
	
	public void addProyectoCiudad(String proyecto, String ciudad){
		
		Boolean insert = true;
		ProyectoCiudades temp = null;
		ListIterator<ProyectoCiudades> iterador = proyectosCiudades.listIterator();
		while(iterador.hasNext()){
			temp = iterador.next();
			if(temp.getProyecto().equals(proyecto)){
				insert = false;
				break;
			}
		}
		if(insert){
		temp = new ProyectoCiudades(proyecto);
		temp.addCiudad(ciudad);
		proyectosCiudades.add(temp);
		}else{
			temp.addCiudad(ciudad);
		}
	}
	
	public void setEmpresa(String empr){
		empresa = empr;
	}
	
	public String getEmpresa(){
		return empresa;
	}
	
	public ArrayList<ProyectoCiudades> getProyectosCiudades(){
		return proyectosCiudades;
	}
	
	public ProyectoCiudades getProyectoCiudades(int i){
		return proyectosCiudades.get(i);
	}
	
	public int size(){
		return proyectosCiudades.size();
	}
	
	

}

package org.eda1.examenSegundoParcial.ejercicio01;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class ProcesarDatos {

	private TreeMap<String, TreeMap<String, TreeMap<String,DatosCiudad>>> mapa;
	
	
	public ProcesarDatos() {
		mapa = new TreeMap<String, TreeMap<String, TreeMap<String,DatosCiudad>>>();
	}


	public void cargarArchivo(String pathArchivo) {
		String[] dirsToSplit;
		DatosCiudad dc;
		String empr, pry, ciu, pais, conti;
		TreeSet<String> direcciones;
		TreeMap<String,DatosCiudad> treeT; //tree map temp
		TreeMap<String,TreeMap<String,DatosCiudad>> treeT2; // tree map temp 2
		try {
			Scanner scaner = new Scanner(new File(pathArchivo));
			
			while(scaner.hasNextLine()){
				//Procesamos datos estaticos
				empr = scaner.next();
				pry = scaner.next();
				ciu = scaner.next();
				pais = scaner.next();
				conti = scaner.next();
			
				//Procesamos datos dinamicos
				dirsToSplit = scaner.nextLine().split(" ");
				direcciones = new TreeSet<String>();
				for(int i =0; i<dirsToSplit.length; i++){
					if(!dirsToSplit[i].equals(""))
					direcciones.add(dirsToSplit[i]);
				}
				//Creamos estrutura para añadir al mapa
				dc = new DatosCiudad(pais, conti, direcciones);
			if(mapa.get(empr) == null){	
				//empresa no esta en el mapa
				treeT = new TreeMap<String,DatosCiudad>();
				treeT.put(ciu, dc);
				
				treeT2 = new TreeMap<String,TreeMap<String,DatosCiudad>>();
				treeT2.put(pry, treeT);
				
				mapa.put(empr, treeT2);
			}else{	
				//empresa si esta en el mapa
				if(mapa.get(empr).get(pry) == null){
					//proyecto no esta en el mapa
					treeT = new TreeMap<String,DatosCiudad>();
					treeT.put(ciu, dc);
					mapa.get(empr).put(pry, treeT);
				}else{
					//proyecto si esta en el mapa
					if(mapa.get(empr).get(pry).get(ciu) == null){
						//ciudad no esta en el mapa
						mapa.get(empr).get(pry).put(ciu, dc);
					}else{
						//ciudad si esta en el mapa
						mapa.get(empr).get(pry).get(ciu).direcciones.addAll(dc.direcciones);
					}
					
				}
			}
							
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	public int size(){
		return mapa.size();
	}

	//consulta que devuelva las empresas que tienen proyectos en ciudades europeas, indicando también cuáles son y en qué dirección se ubican
	public TreeMap<String, ArrayList<String>> consulta1() {
		TreeMap<String,ArrayList<String>> output = new TreeMap<String,ArrayList<String>>();
		ArrayList<String> al;
		String ciudad;
		DatosCiudad dc;
		
		for(String empresa : mapa.keySet()){
			for(String proyecto : mapa.get(empresa).keySet()){
				for(Map.Entry<String, DatosCiudad> entry : mapa.get(empresa).get(proyecto).entrySet()){
					al = new ArrayList<String>();
					ciudad = entry.getKey();
					dc = entry.getValue();
					if(dc.continente.equals("Europe")){
						if(output.get(empresa) == null){
							al.add(proyecto+"<"+ciudad+"."+dc+">");
							output.put(empresa, al);	
						}else{
							output.get(empresa).add(proyecto+"<"+ciudad+"."+dc+">");
						}
					}
					
				}
			}
				
		}
		
		return output;
	}

	// implementar otra consulta que devuelva las empresas y los proyectos asociados a dichas empresas que estén ubicadas en la misma dirección de una 
	// determinada ciudad.
	public TreeMap<String, ArrayList<String>> consulta2() {
		TreeMap<String,ArrayList<String>> output = new TreeMap<String,ArrayList<String>>();
		ArrayList<String> al = new ArrayList<String>();
		String ciudad;
		DatosCiudad dc;
		
	
		for(String empresa : mapa.keySet()){
			for(String proyecto : mapa.get(empresa).keySet()){
				for(Map.Entry<String, DatosCiudad> entry : mapa.get(empresa).get(proyecto).entrySet()){					
					ciudad = entry.getKey();
					dc = entry.getValue();					
					
					for(String dir : dc.direcciones){
						if(output.get(dir) == null){
							al = new ArrayList<String>();
							al.add(ciudad);
							al.add("("+empresa+", "+proyecto+")");
							output.put(dir,al);
						}else
							output.get(dir).add("("+empresa+", "+proyecto+")");
					}
					
					
				}
			}
				
		}
		
		TreeMap<String,ArrayList<String>> finalOutput = new TreeMap<String,ArrayList<String>>();
		
		for(Map.Entry<String, ArrayList<String>> entry : output.entrySet()){
			if(entry.getValue().size()>2){
				finalOutput.put(entry.getKey(), entry.getValue());
			}
		}
		
		return finalOutput;
	}	
	
	
}


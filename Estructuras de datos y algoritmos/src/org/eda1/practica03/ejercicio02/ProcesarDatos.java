package org.eda1.practica03.ejercicio02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class ProcesarDatos {

	private TreeMap<String, TreeMap<String, TreeSet<String>>> mapa;

	/**
	 * Instancia un nuevo objeto del tipo ProcesarDatos
	 */
	public ProcesarDatos() {
		mapa = new TreeMap<String, TreeMap<String, TreeSet<String>>>();
	}

	/**
	 * Procesa el archivo de la ruta pasada por parametro añadiendo todas las
	 * tripletas (Empresa-Proyecto-Ciudades) al mapa.
	 * 
	 * @param archivo
	 *            ruta(path) del archivo a procesar
	 */
	public void cargarArchivo(String archivo) {
		String vEmpresa, vProyecto, vCiudad;
		Scanner scaner;
		try {
			scaner = new Scanner(new File(archivo));
			while (scaner.hasNext()) {
				vEmpresa = scaner.next();
				vProyecto = scaner.next();
				vCiudad = scaner.next();

				if (mapa.containsKey(vEmpresa)) {
					if (mapa.get(vEmpresa).containsKey(vProyecto)) {
						if (!mapa.get(vEmpresa).get(vProyecto)
								.contains(vCiudad))
							// Añadimos ciudad
							mapa.get(vEmpresa).get(vProyecto).add(vCiudad);
					} else {
						// Añadimos el par Proyecto-Ciudad
						TreeSet<String> tempSet = new TreeSet<String>();
						tempSet.add(vCiudad);
						mapa.get(vEmpresa).put(vProyecto, tempSet);
					}
				} else {
					// Añadimos la tripleta Emprea-Proyecto-Ciudad
					TreeMap<String, TreeSet<String>> tempMap = new TreeMap<String, TreeSet<String>>();
					TreeSet<String> tempSet = new TreeSet<String>();
					tempSet.add(vCiudad);
					tempMap.put(vProyecto, tempSet);
					mapa.put(vEmpresa, tempMap);
				}
			}

			scaner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Devuelve el numero de empresas del mapa
	 * 
	 * @return int numero empresas
	 */
	public int size() {
		return mapa.size();
	}

	/**
	 * Devuelve el numero de proyectos de la empresa pasada por parametro
	 * 
	 * @param empresa
	 *            empresa de la que se devolvera el nº de proyectos
	 * @return int nº proyectos de empresa, -1 si la empresa no esta en el mapa
	 */
	public int numeroProyectosEmpresa(String empresa) {
		if (mapa.containsKey(empresa))
			return mapa.get(empresa).size();
		return -1;
	}

	/**
	 * Devuelve el numero de ciudades en las que se esta desarrollando un
	 * proyecto
	 * 
	 * @param proyecto
	 *            proyecto del cual se devolvera el nº de ciudades
	 * @return int nº proyectos
	 */
	public int numeroCiudadesProyecto(String proyecto) {
		String vEmpresa;
		Iterator<String> iterador = mapa.keySet().iterator();
		while (iterador.hasNext()) {
			vEmpresa = iterador.next();
			if (mapa.get(vEmpresa).containsKey(proyecto))
				return mapa.get(vEmpresa).get(proyecto).size();
		}
		return -1;
	}

	/**
	 * Devuelve el numero de ciudades en las que se estan desarrollando
	 * proyectos de la empresa pasada por parametro
	 * 
	 * @param empresa
	 *            empresa de la cual se devolvera el numero de ciudades
	 * @return int nº ciudades
	 */
	public int numeroCiudadesEmpresa(String empresa) {
		if (!mapa.containsKey(empresa))
			return -1;
		ArrayList<String> ciudades = new ArrayList<String>();
		String aux = "";
		Iterator<TreeSet<String>> iterador = mapa.get(empresa).values()
				.iterator();
		while (iterador.hasNext()) {
			Iterator<String> iterador2 = iterador.next().iterator();
			while (iterador2.hasNext()) {
				aux = iterador2.next();
				if (!ciudades.contains(aux))
					ciudades.add(aux);
			}
		}
		return ciudades.size();
	}

	/**
	 * Devuelve todas las empresas que contiene el mapa, con sus proyectos y
	 * ciudades correspondientes. example output:
	 * "Adobe: Flash<Boston, Charleston, Washington>; Illustrator<Miami, New_Orleans, Sacramento>; Photoshop<Houston, San_Antonio, Seattle>"
	 * + "\n";
	 * 
	 * @return String con el contenido del mapa. Tripletas
	 *         Empresa-Proyectos-Ciudades
	 */
	public String devolverEmpresasProyectosCiudades() {
		String output = "", vTemp;
		Entry<String, TreeSet<String>> temp;

		Iterator<String> iterador = mapa.keySet().iterator();
		while (iterador.hasNext()) {
			vTemp = iterador.next();
			// Añadimos empresa
			output += vTemp + ": ";
			Iterator<Entry<String, TreeSet<String>>> iterador2 = mapa
					.get(vTemp).entrySet().iterator();
			while (iterador2.hasNext()) {
				temp = iterador2.next();
				// Añadimos los proyectos de la empresa con sus ciudades
				output += temp.getKey() + "<";
				Iterator<String> iterador3 = temp.getValue().iterator();
				while (iterador3.hasNext()) {
					output += iterador3.next();
					if (iterador3.hasNext())
						output += ", ";
					else
						output += ">";
				}
				if (iterador2.hasNext())
					output += "; ";
				else
					output += "\n";

			}
		}

		return output;
	}

	/**
	 * Devuelve todas las empresas
	 * 
	 * @return ArrayList<String> con el nombre de todas las empresas
	 */
	public ArrayList<String> devolverEmpresas() {
		ArrayList<String> lista = new ArrayList<String>();
		Iterator<String> iterador = mapa.keySet().iterator();
		while (iterador.hasNext())
			lista.add(iterador.next());
		return lista;
	}

	/**
	 * Devuelve los proyectos de todas las empresas
	 * 
	 * @return ArrayList<String> con todos los proyectos
	 */
	public ArrayList<String> devolverProyectos() {
		ArrayList<String> lista = new ArrayList<String>();
		Iterator<String> iterador = mapa.keySet().iterator();
		while (iterador.hasNext()) {
			Iterator<String> iterador2 = mapa.get(iterador.next()).keySet()
					.iterator();
			while (iterador2.hasNext())
				lista.add(iterador2.next());
		}
		return lista;
	}

	/**
	 * Devuelve todas las ciudades en las que se esta desarrollando cada
	 * proyecto de cada empresa
	 * 
	 * @return ArrayList<String> con todas las ciudades
	 */
	public ArrayList<String> devolverCiudades() {
		ArrayList<String> lista = new ArrayList<String>();
		String aux = "";
		Iterator<String> iterador = mapa.keySet().iterator();
		while (iterador.hasNext()) {
			Iterator<TreeSet<String>> iterador2 = mapa.get(iterador.next())
					.values().iterator();
			while (iterador2.hasNext()) {
				Iterator<String> iterador3 = iterador2.next().iterator();
				while (iterador3.hasNext()) {
					aux = iterador3.next();
					if (!lista.contains(aux))
						lista.add(aux);
				}
			}
		}
		return lista;
	}

	/**
	 * Devuelve las empresas que estan desarrollando algun proyecto en la ciudad
	 * pasada por parametro
	 * 
	 * @param ciudad
	 *            ciudad en la cual se buscaran empresas
	 * @return ArrayList<String> con las empresas encontradas
	 */
	public ArrayList<String> devolverEmpresasCiudad(String ciudad) {
		ArrayList<String> lista = new ArrayList<String>();
		String vEmpresa;

		Iterator<String> iterador = mapa.keySet().iterator();
		while (iterador.hasNext()) {
			vEmpresa = iterador.next();
			Iterator<TreeSet<String>> iterador2 = mapa.get(vEmpresa).values()
					.iterator();
			while (iterador2.hasNext()) {
				if (iterador2.next().contains(ciudad))
					if (!lista.contains(vEmpresa))
						lista.add(vEmpresa);
			}
		}
		return lista;
	}

	/**
	 * Devuelve todos los proyectos que se estan desarrollando en la ciudad
	 * pasada por parametro
	 * 
	 * @param ciudad
	 *            ciudad para buscar proyectos desarrollandose en ella
	 * @return ArrayList<String> con todos los proyectos encontrados
	 */
	public ArrayList<String> devolverProyectosCiudad(String ciudad) {
		ArrayList<String> lista = new ArrayList<String>();
		String vProyecto = "", vEmpresa = "";

		Iterator<String> iterador = mapa.keySet().iterator();
		while (iterador.hasNext()) {
			vEmpresa = iterador.next();
			Iterator<String> iterador2 = mapa.get(vEmpresa).keySet().iterator();
			while (iterador2.hasNext()) {
				vProyecto = iterador2.next();
				if (mapa.get(vEmpresa).get(vProyecto).contains(ciudad)) {
					if (!lista.contains(vProyecto))
						lista.add(vProyecto);
				}
			}
		}
		return lista;
	}

	/**
	 * Devuelve todas las ciudades en las que se estan desarrollando proyectos
	 * de una empresa
	 * 
	 * @param empresa
	 *            empresa de la cual se buscaran las ciudades de los proyectos
	 * @return ArrayList<String> con todas las ciudades encontradas
	 */
	public ArrayList<String> devolverCiudadesEmpresa(String empresa) {
		ArrayList<String> lista = new ArrayList<String>();
		String vTemp = "";
		Iterator<String> iterador = mapa.get(empresa).keySet().iterator();
		while (iterador.hasNext()) {
			Iterator<String> iterador2 = mapa.get(empresa).get(iterador.next())
					.iterator();
			while (iterador2.hasNext()) {
				vTemp = iterador2.next();
				if (!lista.contains(vTemp))
					lista.add(vTemp);
			}
		}

		return lista;
	}

	/**
	 * Devuelve las ciudades en donde, desarrollandose el proyecto pasado por
	 * parametro, se desarrollan a su vez proyectos de otras empresa distintas a
	 * la empresa pasada por parametro(empresa del proyecto).
	 * 
	 * @param proyecto
	 *            proyecto del cual se buscaran las ciudades que coincidan con
	 *            otros proyectos
	 * @param empresa
	 *            empresa de la cual se buscara el proyecto y sus respectivas
	 *            ciudades que coincidan.
	 * @return ArrayList<String> con todas las ciudades que cumplan el criterio
	 */
	public ArrayList<String> devolverCiudadesProyectoEmpresa(String proyecto,
			String empresa) {
		if (!mapa.containsKey(empresa)
				|| !mapa.get(empresa).containsKey(proyecto))
			return null;
		ArrayList<String> lista = new ArrayList<String>(), listaTemp = new ArrayList<String>();
		String empresaAux = "", aux = "";
		TreeSet<String> set;
		Iterator<String> iterador = mapa.get(empresa).get(proyecto).iterator();
		while (iterador.hasNext())
			listaTemp.add(iterador.next());

		iterador = mapa.keySet().iterator();
		while (iterador.hasNext()) {
			empresaAux = iterador.next();
			if (!empresaAux.equals(empresa)) {
				Iterator<TreeSet<String>> iterador2 = mapa.get(empresaAux)
						.values().iterator();
				while (iterador2.hasNext()) {
					set = iterador2.next();
					Iterator<String> iterador3 = listaTemp.iterator();
					while (iterador3.hasNext()) {
						aux = iterador3.next();
						if (set.contains(aux) && !lista.contains(aux))
							lista.add(aux);
					}
				}
			}
		}

		return lista;
	}

	/**
	 * Devuelve los proyectos de la empresa pasada por parametro, que tienen
	 * alguna ciudad común entre sí. Indicando tambien el nombre de la ciudad.
	 * Example output: "Chrome - Earth => New_Jersey" + "\n"
	 * 
	 * @param empresa
	 *            empresa de la cual se miraran las ciudades en comun de los
	 *            proyectos
	 * @return ArrayList con las tripletas Proyecto-Proyecto => Ciudad-en-Común
	 */
	public ArrayList<String> devolverEmpresaParesProyectoCiudadesComunes(
			String empresa) {
		ArrayList<String> lista = new ArrayList<String>();
		ArrayList<String> temp = new ArrayList<String>();
		String pr1 = "", pr2 = "", vCiudad = "", tripleta, tripletaAlReves;
		Iterator<String> iterador = mapa.get(empresa).keySet().iterator();
		while (iterador.hasNext()) {
			pr1 = iterador.next();
			Iterator<String> iterador2 = mapa.get(empresa).get(pr1).iterator();
			temp.clear();
			while (iterador2.hasNext())
				temp.add(iterador2.next());

			Iterator<String> iterador3 = mapa.get(empresa).keySet().iterator();
			while (iterador3.hasNext()) {
				pr2 = iterador3.next();
				if (!pr1.equals(pr2)) {
					Iterator<String> iterador4 = temp.iterator();
					while (iterador4.hasNext()) {
						vCiudad = iterador4.next();
						tripleta = pr1 + " - " + pr2 + " => " + vCiudad;
						tripletaAlReves = pr2 + " - " + pr1 + " => " + vCiudad;
						if (mapa.get(empresa).get(pr2).contains(vCiudad)
								&& !lista.contains(tripleta)
								&& !lista.contains(tripletaAlReves))
							lista.add(tripleta);
					}
				}
			}
		}
		return lista;
	}

	/**
	 * Devuelve el proyecto con mayor numero de ciudades
	 * 
	 * @return String proyecto
	 */
	public String devolverProyectoConMayorNumeroDeCiudades() {
		String vProyecto = "", vEmpresa = "", proyecto = "";
		int max = 0;

		Iterator<String> iterador = mapa.keySet().iterator();
		while (iterador.hasNext()) {
			vEmpresa = iterador.next();
			Iterator<String> iterador2 = mapa.get(vEmpresa).keySet().iterator();
			while (iterador2.hasNext()) {
				vProyecto = iterador2.next();
				if (mapa.get(vEmpresa).get(vProyecto).size() > max) {
					proyecto = vProyecto;
					max = mapa.get(vEmpresa).get(vProyecto).size();
				}
			}
		}
		return proyecto;
	}

	/**
	 * Devuelve el nombre de la empresa con mayor numero de proyectos.
	 * @return String empresa
	 */
	public String devolverEmpresaConMayorNumeroDeProyectos() {
		String vEmpresa = "", empresa = "";
		int max = 0;

		Iterator<String> iterador = mapa.keySet().iterator();
		while (iterador.hasNext()) {
			vEmpresa = iterador.next();
			if (mapa.get(vEmpresa).keySet().size() > max) {
				empresa = vEmpresa;
				max = mapa.get(vEmpresa).keySet().size();
			}
		}
		return empresa;
	}
	
	/**
	 * Devuelve el nombre de la ciudad en la que se estan desarrollando mayor numero de proyectos.
	 * @return String ciudad
	 */
	public String devolverCiudadConMayorNumeroDeProyectos() {
		String vCiudad = "", vEmpresa = "", ciudad = "";
		int max = 0, count = 0;
		ArrayList<String> ciudades = new ArrayList<String>();
		//Primero añadimos todas las ciudades a ArrayList 
		Iterator<String> iterador = mapa.keySet().iterator();
		while (iterador.hasNext()) {
			vEmpresa = iterador.next();
			Iterator<String> iterador2 = mapa.get(vEmpresa).keySet().iterator();
			while (iterador2.hasNext()) {
				Iterator<String> iterador3 = mapa.get(vEmpresa)
						.get(iterador2.next()).iterator();
				while (iterador3.hasNext()) {
					vCiudad = iterador3.next();
					if (!ciudades.contains(vCiudad))
						ciudades.add(vCiudad);
				}
			}
		}
		//Despues por cada ciudad comprobamos el numero de veces que aparece en las ciudades de cada proyecto de cada empresa
		iterador = ciudades.iterator();
		while (iterador.hasNext()) {
			vCiudad = iterador.next();

			Iterator<String> iterador2 = mapa.keySet().iterator();
			while (iterador2.hasNext()) {
				vEmpresa = iterador2.next();
				Iterator<String> iterador3 = mapa.get(vEmpresa).keySet().iterator();
				count = 0;
				while (iterador3.hasNext()) {
					if (mapa.get(vEmpresa).get(iterador3.next()).contains(vCiudad) )
						count++;
				}
				if (count > max) {
					max = count;
					ciudad = vCiudad;

				}
			}
		}

		return ciudad;
	}

}

package org.eda1.practica01.ejercicio02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ProcesarDatos {

	public static ArrayList<EmpresaProyectos> cargarArchivo(
			String stringArchivoEntrada) {

		ArrayList<EmpresaProyectos> empresas = new ArrayList<EmpresaProyectos>();
		EmpresaProyectos empresaTemp = null;
		boolean insert;
		Scanner fileScanner = null;
		String line = "";
		String[] split;

		try {
			fileScanner = new Scanner(new File(stringArchivoEntrada));

			while (true) {
				insert = true;
				line = fileScanner.nextLine();
				split = line.split(" ");
				Iterator<EmpresaProyectos> iterador = empresas.iterator();
				// Buscamos si la empresa existe para no repetir datos
				while (iterador.hasNext()) {
					empresaTemp = iterador.next();
					if (empresaTemp.getEmpresa().equals(split[0])) {
						insert = false;
						break;
					}
				}

				if (insert) {
					// empresa no existe
					empresaTemp = new EmpresaProyectos(split[0]);
					empresaTemp.addProyectoCiudad(split[1], split[2]);
					empresas.add(empresaTemp);
				} else {
					// empresa si existe
					empresaTemp.addProyectoCiudad(split[1], split[2]);
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			fileScanner.close();
		}
		return empresas;
	}

	public static String devolverEmpresasProyectosCiudades(
			ArrayList<EmpresaProyectos> listaEmpresas) {
		// example ouput:
		// "Adobe: Photoshop<San_Antonio, Houston, Seattle>; Flash<Charleston, Boston, Washington>; Illustrator<Miami, Sacramento, New_Orleans>"
		// + "\n"
		String aux = "";
		EmpresaProyectos empresaTemp = null;
		ProyectoCiudades proyectoTemp = null;
		Iterator<EmpresaProyectos> iterador = listaEmpresas.iterator();
		while (iterador.hasNext()) {
			empresaTemp = iterador.next();
			aux += empresaTemp.getEmpresa() + ": ";
			Iterator<ProyectoCiudades> iterador2 = empresaTemp
					.getProyectosCiudades().iterator();
			while (iterador2.hasNext()) {
				proyectoTemp = iterador2.next();
				aux += proyectoTemp.getProyecto() + "<";
				Iterator<String> iterador3 = proyectoTemp.getCiudades()
						.iterator();
				while (iterador3.hasNext()) {
					aux += iterador3.next();
					if (iterador3.hasNext()) {
						aux += ", ";
					}
				}
				aux += ">";
				if (iterador2.hasNext()) {
					aux += "; ";
				}
			}
			aux += "\n";
		}

		return aux;

	}

	public static ArrayList<String> enumerarEmpresasCiudad(
			ArrayList<EmpresaProyectos> listaEmpresas, String target) {

		ArrayList<String> temp = new ArrayList<String>();
		EmpresaProyectos empresaTemp = null;
		boolean insert;
		Iterator<EmpresaProyectos> iterador = listaEmpresas.iterator();

		while (iterador.hasNext()) {
			insert = false;
			empresaTemp = iterador.next();
			Iterator<ProyectoCiudades> iterador2 = empresaTemp
					.getProyectosCiudades().iterator();
			while (iterador2.hasNext()) {
				Iterator<String> iterador3 = iterador2.next().getCiudades()
						.iterator();
				while (iterador3.hasNext()) {
					if (iterador3.next().equals(target)) {
						insert = true;
						break;
					}
				}
			}
			if (insert) {
				temp.add(empresaTemp.getEmpresa());
			}
		}

		return temp;
	}

	public static ArrayList<String> enumerarProyectosCiudad(
			ArrayList<EmpresaProyectos> listaEmpresas, String target) {

		ArrayList<String> temp = new ArrayList<String>();
		ProyectoCiudades proyectoTemp = null;
		boolean insert;
		Iterator<EmpresaProyectos> iterador = listaEmpresas.iterator();

		while (iterador.hasNext()) {
			Iterator<ProyectoCiudades> iterador2 = iterador.next()
					.getProyectosCiudades().iterator();
			while (iterador2.hasNext()) {
				insert = false;
				proyectoTemp = iterador2.next();
				Iterator<String> iterador3 = proyectoTemp.getCiudades()
						.iterator();
				while (iterador3.hasNext()) {
					if (iterador3.next().equals(target)) {
						insert = true;
						break;
					}
				}
				if (insert)
					temp.add(proyectoTemp.getProyecto());
			}
		}

		return temp;
	}

	public static int contarCiudadesEmpresa(
			ArrayList<EmpresaProyectos> listaEmpresas, String target) {

		String aux = "";
		ArrayList<String> temp = new ArrayList<String>();
		EmpresaProyectos empresaTemp = null;
		boolean isCount = false, isAdded;
		Iterator<EmpresaProyectos> iterador = listaEmpresas.iterator();

		while (iterador.hasNext()) {
			if (isCount)
				break;
			empresaTemp = iterador.next();
			if (empresaTemp.getEmpresa().equals(target)) {
				Iterator<ProyectoCiudades> iterador2 = empresaTemp
						.getProyectosCiudades().iterator();
				while (iterador2.hasNext()) {
					Iterator<String> iterador3 = iterador2.next().getCiudades()
							.iterator();
					while (iterador3.hasNext()) {
						isAdded = false;
						aux = iterador3.next();
						Iterator<String> iterador4 = temp.iterator();
						while (iterador4.hasNext()) {
							if (iterador4.next().equals(aux)) {
								isAdded = true;
								break;
							}
						}

						if (!isAdded) {
							temp.add(aux);
						}

					}
				}
				isCount = true;
			}
		}
		return temp.size();
	}

	public static ArrayList<String> enumerarCiudadesProyectoEmpresa(
			ArrayList<EmpresaProyectos> listaEmpresas, String targetP,
			String targetE) {

		ArrayList<String> ciudades = new ArrayList<String>();
		ArrayList<String> ciudadesTarget = new ArrayList<String>();
		EmpresaProyectos empresaTemp = null;
		ProyectoCiudades proyectoTemp = null;
		boolean targetOK = false;

		// Primero obtenemos todas las ciudades del par Proyecto-Empresa en cuestión
		Iterator<EmpresaProyectos> iterador = listaEmpresas.iterator();
		while (iterador.hasNext()) {
			empresaTemp = iterador.next();
			if (targetOK)
				break;
			if (empresaTemp.getEmpresa().equals(targetE)) {
				Iterator<ProyectoCiudades> iterador2 = empresaTemp
						.getProyectosCiudades().iterator();
				while (iterador2.hasNext()) {
					proyectoTemp = iterador2.next();
					if (proyectoTemp.getProyecto().equals(targetP)) {
						Iterator<String> iterador3 = proyectoTemp.getCiudades()
								.iterator();
						while (iterador3.hasNext()) {
							ciudades.add(iterador3.next());
						}
					}
					targetOK = true;
				}
			}
		}
		
		// Despues comprobamos en qué ciudades se desarrollan proyectos de otras empresas
		
		iterador = listaEmpresas.iterator();
		while(iterador.hasNext()){
			empresaTemp = iterador.next();
			if(!empresaTemp.getEmpresa().equals(targetE)){
				Iterator<ProyectoCiudades> iterador2 = empresaTemp.getProyectosCiudades().iterator();
				while(iterador2.hasNext()){
					Iterator<String> iterador3 = iterador2.next().getCiudades().iterator();
					while(iterador3.hasNext()){
						String aux = iterador3.next();
						if(ciudades.contains(aux)){
							if(!ciudadesTarget.contains(aux)){
								ciudadesTarget.add(aux);
							}
						}
					}
					
				}
			}
		}

		return ciudadesTarget;
	}
		
}

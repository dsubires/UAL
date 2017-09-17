package org.eda1.practica02.ejercicio02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import org.eda1.estructurasdedatos.AVLTree;


/**
 * The Class ProcesarDatos.
 */
public class ProcesarDatos {
	
	/**
	 * Cargar archivo. Procesa el archivo pasado por parametro añadiendo todas las tripletas (empresa, proyecto, ciudad), sin repetirlas, a una estructura AVLTree.
	 *
	 * @param archivo archivo a procesar
	 * @return theAVLtree  AVLTree con lo datos procesados del archivo
	 */
	public static AVLTree<EmpresaProyectos> cargarArchivo(String archivo){
		AVLTree<EmpresaProyectos> datos = new AVLTree<EmpresaProyectos>();
		String aux,empresa,proyecto,ciudad;
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(archivo)));
			while(br.ready()){
				aux = br.readLine();
				String[] temp = aux.split(" ");
				empresa = temp[0];
				proyecto = temp[1];
				ciudad = temp[2];
				ProcesarDatos.addEmpresaProyectoCiudad(datos, empresa, proyecto, ciudad);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		return datos;
	}

	/**
	 * Añade la tripleta empresa,proyecto,ciudad al AVLTree sin repetir ocurrencias.
	 *
	 * @param empresas AVLTree donde se añadirá la tripleta
	 * @param empresa empresa a añadir
	 * @param proyecto proyecto a añadir
	 * @param ciudad ciudad a añadir
	 * @return true, si añade la tripleta(no existia), false en caso contrario
	 */
	public static boolean addEmpresaProyectoCiudad(AVLTree<EmpresaProyectos> empresas,String empresa, String proyecto, String ciudad){
		EmpresaProyectos ep = new EmpresaProyectos(empresa);
		ep.addProyectoCiudad(proyecto, ciudad);
		
		if(!empresas.add(ep))
			return empresas.find(ep).addProyectoCiudad(proyecto, ciudad);
		return true;
	}
	
	/**
	 * Almacena en disco toda la estructura del AVLTree<EmpresaProyectos> y de sus AVLTree<ProyectoCiudades> respectivos
	 *
	 * @param listaEmpresas AVLTree a almacenar en disco
	 * @param archivo archivo donde se almacenara el AVLTree
	 */
	public static void guardarEmpresasProyectosCiudades(AVLTree<EmpresaProyectos> listaEmpresas, String archivo){
		try {
			PrintWriter pw = new PrintWriter(new File(archivo));
			Iterator<EmpresaProyectos> iterador = listaEmpresas.iterator();
			while(iterador.hasNext()){
				pw.println(iterador.next());
			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Devuelve el número de proyectos de una empresa.
	 *
	 * @param listaEmpresas AVLTree con los datos a buscar
	 * @param empresa empresa a buscar
	 * @return numero de proyectos
	 */
	public static int numeroProyectosEmpresa(AVLTree<EmpresaProyectos> listaEmpresas,String empresa){
		EmpresaProyectos ep = new EmpresaProyectos(empresa);
		if(listaEmpresas.contains(ep))
			return listaEmpresas.find(ep).size();
		return -1;
	}
	
	/**
	 * Devuelve el número de ciudades en las que se está desarrollando un proyecto
	 *
	 * @param listaEmpresas AVLTree con los datos a buscar
	 * @param proyecto proyecto a buscar
	 * @return número de ciudades del proyecto
	 */
	public static int numeroCiudadesProyecto(AVLTree<EmpresaProyectos> listaEmpresas,String proyecto){
		EmpresaProyectos empresaTemp;
		ProyectoCiudades pc = new ProyectoCiudades(proyecto);
		Iterator<EmpresaProyectos> iterador = listaEmpresas.iterator();
		while(iterador.hasNext()){
			empresaTemp = iterador.next();
			if(empresaTemp.getProyectosciudades().contains(pc))
				return empresaTemp.getProyectosciudades().find(pc).size();
		}
		return -1;
	}
	
	/**
	 * Devuelve el número de ciudades en las que se están desarrollando proyectos de una empresa
	 *
	 * @param listaEmpresas AVLTree con los datos a buscar
	 * @param empresa empresa a buscar
	 * @return número de ciudades donde se encuentra una empresa
	 */
	public static int numeroCiudadesEmpresa(AVLTree<EmpresaProyectos> listaEmpresas,String empresa){
		ArrayList<String> ciudades = new ArrayList<String>();
		EmpresaProyectos ep = new EmpresaProyectos(empresa);
		String aux;
		if(listaEmpresas.contains(ep)){
			Iterator<ProyectoCiudades> iterador = listaEmpresas.find(ep).getProyectosciudades().iterator();
			while(iterador.hasNext()){
				Iterator<String> iterador2 = iterador.next().getCiudades().iterator();
				while(iterador2.hasNext()){
					aux = iterador2.next();
					if(!ciudades.contains(aux))
						ciudades.add(aux);
				}
			}
		}
			
		return ciudades.size();
	}
	
	/**
	 * Devuelve un String con todos las tripletas del AVLTree pasado por paramtero
	 *
	 * @param listaEmpresas AVLTree con los datos a mostrar
	 * @return string con todas las tripletas
	 */
	public static String devolverEmpresasProyectosCiudades(AVLTree<EmpresaProyectos> listaEmpresas){
		String aux = "";
		Iterator<EmpresaProyectos> iterador = listaEmpresas.iterator();
		while(iterador.hasNext())
			aux += iterador.next();
		return aux;
	}

	/**
	 * Devuelve el nombre de todas las empresas que tienen sede una ciudad
	 *
	 * @param listaEmpresas AVLTree con los datos a buscar
	 * @param ciudad ciudad a buscar
	 * @return arrayList con todos los nombres de las empresas
	 */
	public static ArrayList<String> devolverEmpresasCiudad(AVLTree<EmpresaProyectos> listaEmpresas, String ciudad) {
		ArrayList<String> list = new ArrayList<String>();
		EmpresaProyectos tempEP;
		Iterator<EmpresaProyectos> iterador = listaEmpresas.iterator();
		while(iterador.hasNext()){
			tempEP = iterador.next();
			Iterator<ProyectoCiudades> iterador2 = tempEP.getProyectosciudades().iterator();
			while(iterador2.hasNext()){
				if(iterador2.next().getCiudades().contains(ciudad)){
					if(!list.contains(tempEP.getEmpresa()))
						list.add(tempEP.getEmpresa());	
				}
			}
		}
		return list;
	}
	
	/**
	 * Devuelve todos los proyectos que se están desarrollando en una ciudad
	 *
	 * @param listaEmpresas the lista empresas
	 * @param ciudad the ciudad
	 * @return the array list
	 */
	public static ArrayList<String> devolverProyectosCiudad(AVLTree<EmpresaProyectos> listaEmpresas, String ciudad){
		ArrayList<String> list = new ArrayList<String>();
		ProyectoCiudades tempPC;
		Iterator<EmpresaProyectos> iterador = listaEmpresas.iterator();
		while(iterador.hasNext()){
			Iterator<ProyectoCiudades> iterador2 = iterador.next().getProyectosciudades().iterator();
			while(iterador2.hasNext()){
				tempPC = iterador2.next();
				if(tempPC.getCiudades().contains(ciudad))
					list.add(tempPC.getProyecto());
			}
		}
		return list;
	}
	
	/**
	 * Devuelve todas las ciudades en las que se estan desarrollando proyectos de una empresa
	 *
	 * @param listaEmpresas the lista empresas
	 * @param empresa the empresa
	 * @return the array list
	 */
	public static ArrayList<String> devolverCiudadesEmpresa(AVLTree<EmpresaProyectos> listaEmpresas, String empresa){
		ArrayList<String> list = new ArrayList<String>();
		String aux;
		Iterator<ProyectoCiudades> iterador = listaEmpresas.find(new EmpresaProyectos(empresa)).getProyectosciudades().iterator();
		while(iterador.hasNext()){
			Iterator<String> iterador2 = iterador.next().getCiudades().iterator();
			while(iterador2.hasNext()){
				aux = iterador2.next();
				if(!list.contains(aux))
					list.add(aux);	
			}
		}
		return list;
	}
	
	
	/**
	 * Devuelve todas las ciudades donde, desarrollandose el proyecto pasado por paramtero, se desarrollen a su vez proyectos de otras empresas distintas a la empresa pasada por parametro (empresa del proyecto pasado por parametro)
	 *
	 * @param listaEmpresas the lista empresas
	 * @param proyecto the proyecto
	 * @param empresa the empresa
	 * @return the array list
	 */
	public static ArrayList<String> devolverCiudadesProyectoEmpresa(AVLTree<EmpresaProyectos> listaEmpresas, String proyecto, String empresa){
		ProyectoCiudades tempPC,pc = new ProyectoCiudades(proyecto);
		EmpresaProyectos tempEP,ep = new EmpresaProyectos(empresa);
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> temp = new ArrayList<String>();
		String aux = "";
		Iterator<String> iterador = listaEmpresas.find(ep).getProyectosciudades().find(pc).getCiudades().iterator();
		while(iterador.hasNext())
			temp.add(iterador.next());
		Iterator<EmpresaProyectos> iterador2 = listaEmpresas.iterator();
		while(iterador2.hasNext()){
			tempEP = iterador2.next();
			if(!tempEP.getEmpresa().equals(empresa)){
				Iterator<ProyectoCiudades> iterador3 = tempEP.getProyectosciudades().iterator();
				while(iterador3.hasNext()){
					tempPC = iterador3.next();
					iterador = temp.iterator();
					while(iterador.hasNext()){
						aux = iterador.next();
						if(tempPC.getCiudades().contains(aux)){
							list.add(aux);
							iterador.remove();
						}
					}	
				}
			}
		}
		
		return list;
	}
	
	
	/**
	 * Devuelve los proyectos de una empresa pasada por paramtero, que se están desarrollando en una misma ciudad.
	 * Formato_Salida: Proyecto1 - Proyecto2 => Ciudad
	 *
	 * @param listaEmpresas the lista empresas
	 * @param empresa the empresa
	 * @return the array list
	 */
	public static ArrayList<String> devolverEmpresaParesProyectoCiudadesComunes(AVLTree<EmpresaProyectos> listaEmpresas, String empresa){
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> temp = new ArrayList<String>();
		EmpresaProyectos ep = new EmpresaProyectos(empresa);
		ProyectoCiudades pc,pc2;
		String aux,linea,linea2 ;
		if(listaEmpresas.find(ep) == null)
			return null;
		Iterator<ProyectoCiudades> iterador = listaEmpresas.find(ep).getProyectosciudades().iterator();
		while(iterador.hasNext()){
			if(iterador.hasNext()){
			pc = iterador.next();
			Iterator<String> iterador2 = pc.getCiudades().iterator();
			temp.clear();
			while(iterador2.hasNext())
				temp.add(iterador2.next());
			Iterator<ProyectoCiudades> iterador3 = listaEmpresas.find(ep).getProyectosciudades().iterator();
			while(iterador3.hasNext()){
				pc2 = iterador3.next();
				if(!pc2.equals(pc)){
					Iterator<String> iterador4 = temp.iterator();
					while(iterador4.hasNext()){
						aux = iterador4.next();
						if(pc2.getCiudades().contains(aux)){
							linea = pc.getProyecto()+" - "+pc2.getProyecto()+" => "+aux;
							linea2 = pc2.getProyecto()+" - "+pc.getProyecto()+" => "+aux;
							if(!list.contains(linea) && !list.contains(linea2))
								list.add(linea);
						}
					}
				}
					
			}
			}
		}
		return list;
	}
	
	
	
}

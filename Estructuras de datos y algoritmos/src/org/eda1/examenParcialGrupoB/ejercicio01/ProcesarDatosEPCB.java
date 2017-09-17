package org.eda1.examenParcialGrupoB.ejercicio01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

import org.eda1.practica02.ejercicio03.PalabraDistancia;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesarDatosEPCB.
 */
public class ProcesarDatosEPCB {

	/**
	 * Cargar archivo.
	 *
	 * @param archivoEntrada the archivo entrada
	 * @return the array list
	 */
	public static ArrayList<EmpresaProyectoCiudadBeneficio> cargarArchivo(
			String archivoEntrada) {
		ArrayList<EmpresaProyectoCiudadBeneficio> lista = new ArrayList<EmpresaProyectoCiudadBeneficio>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(
					archivoEntrada));
			String aux;
			String[] vector;
			while ((aux = in.readLine()) != null) {
				vector = aux.split(" ");
				EmpresaProyectoCiudadBeneficio temp = new EmpresaProyectoCiudadBeneficio(
						vector[0], vector[1], vector[2],
						Double.parseDouble(vector[3]));
				lista.add(temp);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lista;
	}

	/**
	 * Gets the top k.
	 *
	 * @param listaEmpresas the lista empresas
	 * @param i the i
	 * @return the top k
	 */
	public static ArrayList<EmpresaProyectoCiudadBeneficio> getTopK(
			ArrayList<EmpresaProyectoCiudadBeneficio> listaEmpresas, int i) {
		
		MyPQWithHeap<EmpresaProyectoCiudadBeneficio> cola = new MyPQWithHeap<EmpresaProyectoCiudadBeneficio>(
				i, new Less<EmpresaProyectoCiudadBeneficio>());

		ArrayList<EmpresaProyectoCiudadBeneficio> aux=new ArrayList<EmpresaProyectoCiudadBeneficio>();
		
		for (EmpresaProyectoCiudadBeneficio iter : listaEmpresas) {
			if (cola.size() == i) {
				EmpresaProyectoCiudadBeneficio top = cola.peek();
				if (iter.compareTo(top)>0) {	//if (nrand > top) {
					cola.poll();
					cola.add(iter);
				}	
			}
			else
				cola.add(iter);
    	System.out.println(cola.toString());
    }
    while (!cola.isEmpty()) {
    	EmpresaProyectoCiudadBeneficio x = cola.poll();
	    aux.add(x);
    }
    return aux;
	}
}

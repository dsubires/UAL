package org.eda1.practica02.ejercicio01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import org.eda1.estructurasdedatos.BSTree;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesarDirecciones.
 */
public class ProcesarDirecciones {

	/** The tree direcciones. */
	protected BSTree<DireccionMaquinas> treeDirecciones;

	/**
	 * Instantiates a new procesar direcciones.
	 */
	public ProcesarDirecciones() {
		treeDirecciones = new BSTree<DireccionMaquinas>();
	}

	/**
	 * Instantiates a new procesar direcciones.
	 *
	 * @param tree the tree
	 */
	public ProcesarDirecciones(BSTree<DireccionMaquinas> tree) {
		treeDirecciones = tree;
	}

	/**
	 * Cargar archivo. Lee el archivo de la ruta que se pasa por parametro y procesa los datos en un BSTree
	 *
	 * @param archivo the archivo
	 * @return the bS tree
	 */
	@SuppressWarnings("unchecked")
	public BSTree<DireccionMaquinas> cargarArchivo(String archivo) {

		ProcesarDirecciones pd = new ProcesarDirecciones();
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(
					archivo)));
			String linea, dir, maq;
			DireccionMaquinas dm;
			MaquinaContador mc;
			while (br.ready()) {
				linea = br.readLine();
				int index = linea.indexOf(" ");
				dir = linea.substring(0, index);
				maq = linea.substring(index + 1, linea.length());
				dm = new DireccionMaquinas(dir, maq);
				mc = new MaquinaContador(maq);

				if (!pd.addDireccionMaquina(dir, maq)) {
					if (!pd.treeDirecciones.find(dm).addMaquina(mc))
						pd.treeDirecciones.find(dm).getMaquinas().find(mc)
								.incrementarContador();
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		treeDirecciones = pd.treeDirecciones;
		return (BSTree<DireccionMaquinas>) treeDirecciones.clone();
	}

	/**
	 * Adds the direccion maquina.
	 *
	 * @param dir the dir
	 * @param maq the maq
	 * @return true, if successful
	 */
	public boolean addDireccionMaquina(String dir, String maq) {
		return treeDirecciones.add(new DireccionMaquinas(dir, maq));
	}

	/**
	 * Adds the direccion maquina with find.
	 *
	 * @param dir the dir
	 * @param maq the maq
	 * @return true, if successful
	 */
	public boolean addDireccionMaquinaWithFind(String dir, String maq) {
		DireccionMaquinas dm = new DireccionMaquinas(dir, maq);
		if (treeDirecciones.contains(dm))
			return false;
		return treeDirecciones.add(new DireccionMaquinas(dir, maq));
	}

	/**
	 * Maquinas con contador. Devuelve el nº de maquinas con el mismo contador que el pasado por parametro
	 *
	 * @param c the c
	 * @return the int
	 */
	public int maquinasConContador(int c) {
		int count = 0;
		Iterator<DireccionMaquinas> iterador = treeDirecciones.iterator();
		while (iterador.hasNext()) {
			Iterator<MaquinaContador> iterador2 = iterador.next().getMaquinas()
					.iterator();
			while (iterador2.hasNext()) {
				if (iterador2.next().getContador() == c)
					count++;
			}
		}
		return count;
	}

	/**
	 * Devuelve el par Direccion,Maquina de todas las que coincidan con el contador pasado por parametro
	 *
	 * @param c contador pasado por parametro
	 * @return String que contiene todos los pares Direccion,Maquina
	 */
	public String direccionMaquinasConContador(int c) {
		String salida = "";
		Iterator<DireccionMaquinas> iterador = treeDirecciones.iterator();
		while (iterador.hasNext()) {
			DireccionMaquinas dm = iterador.next();
			Iterator<MaquinaContador> iterador2 = dm.getMaquinas().iterator();
			while (iterador2.hasNext()) {
				MaquinaContador mc = iterador2.next();
				if (mc.getContador() == c)
					salida += "(" + dm.getDireccion() + ", " + mc.getMaquina()
							+ ")\n";
			}
		}

		return salida;
	}

	/**
	 * Devuelve el contador del par Direccion,Maquina pasados por parametro
	 *
	 * @param dir the dir
	 * @param maq the maq
	 * @return the int
	 */
	public int contadorDeDireccionMaquina(String dir, String maq) {
		if (treeDirecciones.contains(new DireccionMaquinas(dir))
				&& treeDirecciones.find(new DireccionMaquinas(dir))
						.getMaquinas().contains(new MaquinaContador(maq)))
			return treeDirecciones.find(new DireccionMaquinas(dir))
					.getMaquinas().find(new MaquinaContador(maq)).getContador();
		return -1;
	}

	/**
	 * Guardar direcciones incidencias.
	 *
	 * @param archivoSalida the archivo salida
	 */
	public void guardarDireccionesIncidencias(String archivoSalida) {
		
		try {
			String aux = "";
			PrintWriter pw = new PrintWriter(new File(archivoSalida)) ;
			Iterator<DireccionMaquinas> iterador = treeDirecciones.iterator();
			pw.print("[");
			while(iterador.hasNext()){
			aux = iterador.next().toString();
				if(iterador.hasNext())
					pw.println(aux);	
				else
					pw.print(aux);
			}
			pw.print("]");
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

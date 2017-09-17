package junioMP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;

/* CON StackLinedListIterable<T>
public class Municipios {

	private StackLinkedListIterable<Municipio> municipios;
	private StackLinkedListIterable<String> cabecera;

	public Municipios(File f) {
		cabecera = new StackLinkedListIterable<String>();
		municipios = new StackLinkedListIterable<Municipio>();
		leerCabecera(f);
		leerMunicipios(f);
	}

	public StackLinkedListIterable<Municipio> getMunicipios() {
		return municipios;
	}

	public StackLinkedListIterable<String> getCabecera() {
		return cabecera;
	}

	private void leerCabecera(File f) {
		String[] aux;
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			aux = br.readLine().split(";");
			for (int i = 0; i < aux.length; i++) {
				cabecera.push(aux[i]);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void leerMunicipios(File f) {
		try {
			String linea;
			String[] aux;
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			// pasamlos linea cabecera
			br.readLine();
			while ((linea = br.readLine()) != null) {
				aux = linea.split(";");
				municipios.push(new Municipio(aux[0], aux[1], aux[2], Long
						.parseLong(aux[3])));
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	public String toString() {
		String aux = "Comunidad\t Provincia\t Municipio\t Poblacion\n";

		Iterator<Municipio> iterador = municipios.iterator();

		while (iterador.hasNext()) {
			Municipio temp = iterador.next();
			aux += temp.getComunidad() + "\t " + temp.getProvincia() + "\t "
					+ temp.getMunicipio() + "\t " + temp.getPoblacion() + "\n";
		}

		return aux;
	}
	
	public static void main(String[] args) {
				
		
		String directorioEntrada = System.getProperty("user.dir");

		directorioEntrada = directorioEntrada + File.separator + "src"
				+ File.separator + "juniomp" + File.separator;
		String nombreArchivo = directorioEntrada + "municipios.csv";
		
		Municipios municipios = new Municipios(new File(nombreArchivo));
		
		
		
		System.out.println(municipios);
		
		
		
		

	}

}
*/

public class Municipios {

	private ArrayList<Municipio> municipios;
	private ArrayList<String> cabecera;

	public Municipios(File f) {
		cabecera = new ArrayList<String>();
		municipios = new ArrayList<Municipio>();
		leerCabecera(f);
		leerMunicipios(f);
	}
	
	public Municipios(ArrayList<Municipio> a){
		cabecera = new ArrayList<String>();
		cabecera.add("Comunidad");
		cabecera.add("Provincia");
		cabecera.add("Municipio");
		cabecera.add("Poblacion");
		municipios = a;
	}

	public ArrayList<Municipio> getMunicipios() {
		return municipios;
	}

	public ArrayList<String> getCabecera() {
		return cabecera;
	}

	private void leerCabecera(File f) {
		String[] aux;
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			aux = br.readLine().split(";");
			for (int i = 0; i < aux.length; i++) {
				cabecera.add(aux[i]);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void leerMunicipios(File f) {
		try {
			String linea;
			String[] aux;
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			// pasamlos linea cabecera
			br.readLine();
			while ((linea = br.readLine()) != null) {
				aux = linea.split(";");
				municipios.add(new Municipio(aux[0], aux[1], aux[2], Long
						.parseLong(aux[3])));
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	public String toString() {
		String aux = "Comunidad\t Provincia\t Municipio\t Poblacion\n";

		Iterator<Municipio> iterador = municipios.iterator();

		while (iterador.hasNext()) {
			Municipio temp = iterador.next();
			
			if( temp.getMunicipio().length() > 13){
				aux += temp.getComunidad() + "\t " + temp.getProvincia() + "\t "
						+ temp.getMunicipio() +	"\t "+ temp.getPoblacion() + "\n";
			}else if(temp.getMunicipio().length() > 6){
			aux += temp.getComunidad() + "\t " + temp.getProvincia() + "\t "
					+ temp.getMunicipio() +	"\t\t "+ temp.getPoblacion() + "\n";
			}else{
				aux += temp.getComunidad() + "\t " + temp.getProvincia() + "\t "
						+ temp.getMunicipio() +	"\t\t\t "+ temp.getPoblacion() + "\n";
			}
		}

		return aux;
	}
	
	public Municipio buscarMunicipio(String municipio){
		Municipio buscado = null;
		Municipio aux = null;
		Iterator<Municipio> i = municipios.iterator();
		while(i.hasNext()){
			aux = i.next();
			if(aux.getMunicipio().equals(municipio)){
				buscado = aux;
				break;
			}
		}
		return buscado;
	}
	
	public long poblacionTotal(){
		
		long count = 0;
		Iterator<Municipio> i = municipios.iterator();
		
		while(i.hasNext()){
			count += i.next().getPoblacion();
		}
		
		return count;
	}
	
	public ArrayList<Municipio> municipiosComunidad(String comunidad){
		Municipio aux = null;
		ArrayList<Municipio> temp = new ArrayList<>();
		Iterator<Municipio> i = municipios.iterator();
		while(i.hasNext()){
			aux = i.next();
			if(aux.getComunidad().equals(comunidad)){
				temp.add(aux);
			}
		}
		
		return temp;
	}
	
	public ArrayList<Municipio> municipiosProvincia(String provincia){
		Municipio aux = null;
		ArrayList<Municipio> temp = new ArrayList<>();
		Iterator<Municipio> i = municipios.iterator();
		while(i.hasNext()){
			aux = i.next();
			if(aux.getProvincia().equals(provincia)){
				temp.add(aux);
			}
		}
		
		return temp;
	}
	
	public static void main(String[] args) {
				
		
		String directorioEntrada = System.getProperty("user.dir");

		directorioEntrada = directorioEntrada + File.separator + "src"
				+ File.separator + "juniomp" + File.separator;
		String nombreArchivo = directorioEntrada + "municipios.csv";
		
		Municipios municipios = new Municipios(new File(nombreArchivo));	
		
		System.out.println(municipios.buscarMunicipio("Antas"));
		System.out.println(municipios.poblacionTotal());
		System.out.println(new Municipios(municipios.municipiosProvincia("Almería")));
		System.out.println("Nº de municipios de almería: "+new Municipios(municipios.municipiosProvincia("Almería")).municipios.size());
		
		//System.out.println(municipios);	
		

	}

}




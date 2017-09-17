package junioMP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class FileTextTaxiDAO implements FileTextDAO {

	private String nombreArchivo;
	private String marca;

	public FileTextTaxiDAO(String n, String m) {
		nombreArchivo = n;
		marca = m;
	}

	public void anadir(Object o) {

		if (buscar(o) == null) {

			Taxi t = (Taxi) o;
			try {
				FileWriter fw = new FileWriter(new File(nombreArchivo), true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(t.getLicencia() + marca + t.getPropietario() + marca
						+ t.isMinusvalido() + "\n");
				bw.close();
			} catch (FileNotFoundException e) {

			} catch (IOException e) {

			}
		}
	}

	public Object buscar(Object o) {

		// Variable Exception
		// Si el object introducido no es un taxi, lanza excepcion al realizar el cast
		@SuppressWarnings("unused")
		Taxi t = (Taxi) o;
		
		ArrayList<Taxi> taxis = new ArrayList<Taxi>();
		String aux;
		String[] aux2;

		try {
			FileReader fr = new FileReader(nombreArchivo);
			BufferedReader br = new BufferedReader(fr);

			while ((aux = br.readLine()) != null) {
				aux2 = aux.split(marca);
				taxis.add(new Taxi(Integer.parseInt(aux2[0]), aux2[1], Boolean
						.parseBoolean(aux2[2])));
			}

			br.close();
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}

		if (taxis.size() > 0) {

			Iterator<Taxi> iterador = taxis.iterator();
			while (iterador.hasNext()) {
				if (o.equals(iterador.next())) {
					return o;
				}
			}

		}

		return null;
	}

	public boolean eliminar(Object o) {
		
		boolean eliminado = false;
		
		if(buscar(o) !=null){
			
			ArrayList<Taxi> taxis = new ArrayList<Taxi>();
			String aux;
			String[] aux2;
			Taxi t;
			Taxi temp;

			try {
				FileReader fr = new FileReader(nombreArchivo);
				BufferedReader br = new BufferedReader(fr);
				
				// añadimos todos los taxis menos el eliminado al arrayList
				while ((aux = br.readLine()) != null) {
					aux2 = aux.split(marca);
					temp = new Taxi(Integer.parseInt(aux2[0]), aux2[1], Boolean
							.parseBoolean(aux2[2]));
					if(temp.equals(o)){
						eliminado = true;
					}else{
						taxis.add(temp);
					}						
				}
				
				br.close();
				
				// escribimos en el fichero el subconjunto de taxis resultantes
				
				FileWriter fw = new FileWriter(nombreArchivo);
				BufferedWriter bw = new BufferedWriter(fw);
				
				Iterator<Taxi> iterador = taxis.iterator();
				
				while(iterador.hasNext()){
					t = (Taxi) iterador.next();
					bw.write(t.getLicencia() + marca + t.getPropietario() + marca
						+ t.isMinusvalido() + "\n");
				}
				

				bw.close();
			} catch (FileNotFoundException e) {

			} catch (IOException e) {

			}

			
			
		}
		return eliminado;
	}

	public boolean modificar(Object o) {

		return false;
	}

}

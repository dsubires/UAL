package junioMP;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BuscadorArchivos {

		private ArrayList<File> files;

	public BuscadorArchivos() {
		files = new ArrayList<File>();
	}
	
	public List listado(File file) {
		
		return null;
	}
	
	public List listado(String dir) {
		//ToDo
		return null;
	}


	public List buscar(String dir, String buscado) {
		
		File file = new File(dir);		
		if (!(file.isFile()||file.isDirectory())) {
			throw new RuntimeException("no existe");
		}
		
		//ToDo
		return null;
	}
}

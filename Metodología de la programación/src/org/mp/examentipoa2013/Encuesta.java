package org.mp.examentipoa2013;

import java.io.File;
import java.util.ArrayList;

public class Encuesta {

	ArrayList encuesta;
	
	File fileEncuesta;

	public Encuesta() {
		super();
		encuesta = new ArrayList();
	}
	
	public Encuesta(File encuestaFile){
		super();
		encuesta = new ArrayList();
		fileEncuesta = encuestaFile;
	}

	public void addPregunta(PreguntaContestacion preguntaContestacion) {
		
		encuesta.add(preguntaContestacion);
	}

	public ArrayList getEncuesta() {
		return encuesta;
	}
	
	public File getFileEncuesta(){
		return fileEncuesta;
	}
	
	public void setFileEncuesta(File fileEncuesta){
		this.fileEncuesta = fileEncuesta;
	}

	@Override
	public String toString() {
		return String.format("Encuesta [encuesta=%s]", encuesta);
	}
	
	

}

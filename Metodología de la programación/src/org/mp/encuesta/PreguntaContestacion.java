package org.mp.encuesta;

public class PreguntaContestacion {

	private int numero;
	private String tipo;
	private String pregunta;
	private String contestacion;

	public PreguntaContestacion(int numero, String tipo, String pregunta,
			String contestacion) {
		super();
		this.numero = numero;
		this.tipo = tipo;
		this.pregunta = pregunta;
		this.contestacion = contestacion;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getContestacion() {
		return contestacion;
	}

	public void setContestacion(String contestacion) {
		this.contestacion = contestacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return String
				.format("PreguntaContestacion [numero=%s, tipo=%s, pregunta=%s, contestacion=%s]",
						numero, tipo, pregunta, contestacion);
	}

	
	
}

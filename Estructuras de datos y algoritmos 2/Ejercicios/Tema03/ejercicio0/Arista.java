package EjerciciosTema3.Ejercicio00;

public class Arista implements Comparable {

	private Integer origen;
	private Integer destino;
	private Integer peso;
	
	public Arista(Integer origen, Integer destino, Integer peso) {
		this.origen = origen;
		this.destino = destino;
		this.peso = peso;
	}

	public Integer getOrigen() {
		return origen;
	}

	public void setOrigen(Integer origen) {
		this.origen = origen;
	}

	public Integer getDestino() {
		return destino;
	}

	public void setDestino(Integer destino) {
		this.destino = destino;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	@Override
	public int compareTo(Object o) {
		Arista a = (Arista) o;
		
		if (peso < a.peso)
			return -1;
		if (peso > a.peso)
			return 1;
		return 0;
	}
	
	
}

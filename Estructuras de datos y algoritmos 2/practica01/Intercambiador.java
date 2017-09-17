package practica01;

public class Intercambiador {

	private String nombre;
	private double entrada;
	private double salida;
	
	public Intercambiador(String nombre, double entrada, double salida) {
		this.nombre = nombre;
		this.entrada = entrada;
		this.salida = salida;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getEntrada() {
		return entrada;
	}

	public void setEntrada(double entrada) {
		this.entrada = entrada;
	}

	public double getSalida() {
		return salida;
	}

	public void setSalida(double salida) {
		this.salida = salida;
	}
	
	public String toString () {
		return nombre +" "+entrada+" "+salida;
	}
}

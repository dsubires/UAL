package org.ip.sesion06;

public class Cuenta {

	private int credito;

	// constructor
	public Cuenta(int ingresoInicial) {
		if (ingresoInicial <= 0) {
			System.out.println("No puede abrir una cuenta con saldo <= 0.");
			System.exit(0);
		} else {
			credito += ingresoInicial;
		}
	}

	// metodos de acceso
	public String ingresar(int cantidad) {
		this.credito += cantidad;
		return "Ingreso de " + cantidad + " realizado correctamente";
	}

	public String retirar(int cantidad) {
		if (this.credito - cantidad <= 0) {
			return "No hay saldo suficiente para la retirada";
		} else {
			this.credito -= cantidad;
			return "Retirada de " + cantidad + " realizada correctamente";
		}
	}

	public String transferir(int cantidad, Cuenta cuenta2) {
		if (this.credito - cantidad <= 0) {
			return "No hay saldo suficiente para realizar la transferencia";
		} else {
			this.retirar(cantidad);
			cuenta2.ingresar(cantidad);
			return "Transferencia de " + cantidad + " realizada correctamente";
		}
	}

	public int verCredito() {
		return this.credito;
	}

}

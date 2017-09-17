package org.ip.sesion06;

public class UsoCuenta {

	public static void main(String[] args) {

		Cuenta cuentaDavid, cuentaUal;

		cuentaDavid = new Cuenta(0);
		cuentaUal = new Cuenta(999999999);

		System.out
				.println("El credito de las cuentas antes de realizar las operaciones es de: cuentaDavid=2500 y cuentaUal=999999999.\n");
		// incremento el saldo de cuentaDavid en 300
		System.out.println(cuentaDavid.ingresar(300));
		// decremento el saldo de cuentaDavid en 2000
		System.out.println(cuentaDavid.retirar(2000));
		// transfiero 800 de cuentaDavid a cuentaUal
		System.out.println(cuentaDavid.transferir(800, cuentaUal));

		System.out
				.println("\nCredito en cuentaDavid al terminar las operaciones: "
						+ cuentaDavid.verCredito());
		System.out.println("Credito en cuentaUal al terminar las operaciones: "
				+ cuentaUal.verCredito());

	}

}

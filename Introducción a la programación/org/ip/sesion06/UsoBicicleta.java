package org.ip.sesion06;

public class UsoBicicleta {
	public static void main(String[] args) {

		Bicicleta biciDavid;
		Bicicleta biciUal;

		biciDavid = new Bicicleta(1, 1, 10);
		biciUal = new Bicicleta(2, 2, 20);

		biciUal.setCadencia(6);
		biciUal.setMarcha(6);
		biciUal.frenar(14);

		biciDavid.setCadencia(6);
		biciDavid.setMarcha(6);
		biciDavid.frenar(4);

		System.out.println("Cadencia de biciUal: " + biciUal.getCadencia());
		System.out.println("Marcha de biciUal: " + biciUal.getMarcha());
		System.out.println("Velocidad de biciUal: " + biciUal.getVelocidad());

		System.out.println("Cadencia de biciDavid: " + biciDavid.getCadencia());
		System.out.println("Marcha de biciDavid: " + biciDavid.getMarcha());
		System.out.println("Velocidad de biciDavid: "
				+ biciDavid.getVelocidad());

		System.out.println("El número total de bicicletas es: "
				+ Bicicleta.getNumeroBicicletas());

	}

}

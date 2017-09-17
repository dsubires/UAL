package org.mp.sesion08;

import java.io.File;

public class ResidenciaTestSER extends AbstractResidenciaTestDAO{

	@Override
	public DataAccessObject makeDataAccessObject() {

		String directorioEntrada = System.getProperty("user.dir");
		String archivoDatos = directorioEntrada + File.separator + "test"
				+ File.separator + "org" + File.separator + "mp"
				+ File.separator + "sesion08" + File.separator
				+ "residencia.dat";
		
		return ResidenciaDAOFactory.createResidenciaDAOFactory(archivoDatos, "ser");
	}

}

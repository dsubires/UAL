package org.eda1.examenParcialGrupoB.ejercicio01;

// TODO: Auto-generated Javadoc
/**
 * The Class EmpresaProyectoCiudadBeneficio.
 */
public class EmpresaProyectoCiudadBeneficio implements Comparable {

	/** The empresa. */
	private String empresa;
	
	/** The proyecto. */
	private String proyecto;
	
	/** The ciudad. */
	private String ciudad;
	
	/** The beneficio. */
	private double beneficio;

	/**
	 * Instantiates a new empresa proyecto ciudad beneficio.
	 */
	public EmpresaProyectoCiudadBeneficio() {
		empresa = "";
		proyecto = "";
		ciudad = "";
		beneficio = 0;
	}

	/**
	 * Instantiates a new empresa proyecto ciudad beneficio.
	 *
	 * @param empresa the empresa
	 * @param proyecto the proyecto
	 * @param ciudad the ciudad
	 * @param beneficio the beneficio
	 */
	public EmpresaProyectoCiudadBeneficio(String empresa, String proyecto,
			String ciudad, double beneficio) {
		this.empresa = empresa;
		this.proyecto = proyecto;
		this.ciudad = ciudad;
		this.beneficio = beneficio;
	}

	/**
	 * Gets the beneficio.
	 *
	 * @return the beneficio
	 */
	public double getBeneficio() {
		return beneficio;
	}

	/**
	 * Gets the empresa.
	 *
	 * @return the empresa
	 */
	public String getEmpresa() {
		return empresa;
	}

	/**
	 * Gets the proyecto.
	 *
	 * @return the proyecto
	 */
	public String getProyecto() {
		return proyecto;
	}

	/**
	 * Gets the ciudad.
	 *
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * Sets the empresa.
	 *
	 * @param empresa the new empresa
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	/**
	 * Sets the proyecto.
	 *
	 * @param proyecto the new proyecto
	 */
	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}

	/**
	 * Sets the ciudad.
	 *
	 * @param ciudad the new ciudad
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * Sets the beneficio.
	 *
	 * @param beneficio the new beneficio
	 */
	public void setBeneficio(double beneficio) {
		this.beneficio = beneficio;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EmpresaProyectoCiudadBeneficio [empresa=" + empresa
				+ ", proyecto=" + proyecto + ", ciudad=" + ciudad
				+ ", beneficio=" + beneficio + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object otra) {
		EmpresaProyectoCiudadBeneficio aux = (EmpresaProyectoCiudadBeneficio) otra;
		if (this.getBeneficio() == aux.getBeneficio())
			return 0;
		if (this.getBeneficio() < aux.getBeneficio())
			return -1;
		return 1;
	}

}

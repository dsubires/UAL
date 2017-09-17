package junioMP;

public class Municipio {

	private String comunidad;
	private String provincia;
	private String municipio;
	private long poblacion;
	
	public Municipio(String comunidad, String provincia, String municipio, long poblacion){
		this.comunidad = comunidad;
		this.provincia = provincia;
		this.municipio = municipio;
		this.poblacion = poblacion;
	}
	
	public String getComunidad(){
		return comunidad;
	}
	
	public void setComunidad(String comunidad){
		this.comunidad = comunidad;
	}
	
	public String getProvincia(){
		return provincia;
	}
	
	public void setProvincia(String provincia){
		this.provincia = provincia;
	}
	
	public String getMunicipio(){
		return municipio;
	}
	
	public void setMunicipio(String municipio){
		this.municipio = municipio;
	}
	
	public double getPoblacion(){
		return poblacion;
	}

	public void setPoblacion(long poblacion){
		this.poblacion = poblacion;
	}
	
	@Override
	public boolean equals(Object o){
		Municipio temp = (Municipio) o;
		return municipio.equals(temp);
	}
	
	@Override
	public String toString(){
		return "Municipio[Comunidad = "+comunidad+" provincia = "+provincia+" municipio = "+municipio+" poblacion = "+poblacion+" ]";
	}
	
}

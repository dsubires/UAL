package org.ip.prueba1;

public class Coordenadas {
	
	private int x;
	private int y;

	// Constructor
	public	Coordenadas(int iniX,int iniY){
		this.x = iniX;
		this.y = iniY;
	}
	public Coordenadas(){
		this.x = 0;
		this.y = 0;
	}
	
	//métodos de acceso
	
	public String getCoordenadas(){
		return "(x="+this.x+",y="+this.y+")";
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public void setCoordenadas(int setX,int setY){
			this.x = setX;
			this.y = setY;
		}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	

}

package org.ip.sesion07;

public class SerieEnteros {

	private int ValorMax;
	
	//constructor
	public SerieEnteros(int maximo){
		ValorMax = maximo; 
	}
	
	//Métodos de acceso 
	
	
	public String toString(){
		String a = "", b="";
		int i=1;
		while(i <= this.ValorMax - 1){
			b += i + ", ";
			++i;
		}
		b= b + this.ValorMax;
		a = "{"+ b + "}";
		return a;
		}
		
	public int calcularSum(){
		int sumatoria=0;
		int i=1;
		while(i <= this.ValorMax){
			sumatoria += i;
			++i;
		}
		return sumatoria;
	}
	
	public int calcularProd(){
		int productorio = 1;
		int i = 1;
		while(i <= this.ValorMax){
			productorio = productorio * i;
			++i;
		}
		return productorio;
	}
	
	public int calcularSumPares(){
		int sumatoria=0;
		int i=2;
		while(i <= this.ValorMax){
			sumatoria += i;
			i += 2;
		}
		return sumatoria;
	}
	
	public int calcularSumImpares(){
		int sumatoria=0;
		int i=1;
		while(i <= this.ValorMax){
			sumatoria += i;
			i += 2;
		}
		return sumatoria;
	}
	
	

}

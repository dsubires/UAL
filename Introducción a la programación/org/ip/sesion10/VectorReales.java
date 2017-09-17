package org.ip.sesion10;

public class VectorReales {
	private double[] vector;
	// Contador de VectoresReales
	private static int numVectores = 0;
	
	// Constructores
	public VectorReales(int dim) {
		this.vector = new double[dim];
		for (int i = 0; i < this.vector.length; i++) {
			this.vector[i] = (int) (Math.random() * 100);
		}
		numVectores++;
	}
	
	public VectorReales(double[] ArrayAux) {
		this.vector = new double[ArrayAux.length];
		for (int i = 0; i < ArrayAux.length; i++){
			this.vector[i] = ArrayAux[i];
		}
		numVectores++;
	}

	
	// Métodos de acceso
	public static int getNumVectores() {
		return numVectores;
	}

	public String toString() {
		if (this.vector.length == 0 || this.vector == null) {
			 return "( 0 )";
		}else{
		String detalleVector = "( ";
		for (int i = 0; i < this.vector.length-1 ; i++) {
			detalleVector +=  this.vector[i]+", ";
		}
		detalleVector += this.vector[this.vector.length-1]+" )";
		return detalleVector;
		}
	}
	
	

	public VectorReales sumar(VectorReales vector2){
		double[] SumaVectores = null;
		if(this.vector == null || vector2.vector == null || this.vector.length != vector2.vector.length ){
			return null;
		}else{
			SumaVectores = new double[vector2.vector.length];
			for(int i=0; i < vector2.vector.length; i++){
				SumaVectores[i] = this.vector[i] + vector2.vector[i];
			}
			return new VectorReales(SumaVectores);
		}
	}
	
	public VectorReales restar(VectorReales vector2){
		double[] RestaVectores = null;
		if(this.vector == null || vector2.vector == null || this.vector.length != vector2.vector.length ){
			return null;
		}else{
			RestaVectores = new double[vector2.vector.length];
			for(int i=0; i < vector2.vector.length; i++){
				RestaVectores[i] = this.vector[i] - vector2.vector[i];
			}
			return new VectorReales(RestaVectores);
		}
	}

	public double norma(){
		double NormaVectores = 0;
		if(this.vector == null ||  this.vector.length == 0 ){
			return 0;
		}else{
			for(int i=0; i < this.vector.length; i++){
				NormaVectores += Math.sqrt(Math.pow(this.vector[i],2)) ;
			}
			return NormaVectores;
		}
	}

	public VectorReales productoEscalar(int escalar){
		double[] productoEscalar = null;
		if(this.vector == null ||  this.vector.length == 0 ){
			return null;
		}else{
			productoEscalar = new double[this.vector.length];
			for(int i=0; i < this.vector.length; i++){
				productoEscalar[i] = this.vector[i] * escalar ;
			}
			return new VectorReales(productoEscalar);
		}
	}

	public double productoEscalar(VectorReales vector2){
		double productoEscalar = 0;
		if(this.vector == null ||  this.vector.length == 0 || vector2.vector == null || this.vector.length != vector2.vector.length ){
			return 0;
		}else{
			for(int i=0; i < this.vector.length; i++){
				productoEscalar += this.vector[i] * vector2.vector.length ;
			}
			return productoEscalar;
		}
	}

	public double distancia(VectorReales vector2){
		if(this.vector == null ||  this.vector.length == 0 ){
			return 0;
		}else{
			return this.restar(vector2).norma();
		}
	}
	
	public double angulo(VectorReales vector2){
		if(this.vector == null ||  this.vector.length == 0 || vector2.vector == null || this.vector.length != vector2.vector.length ){
			return 0;
		}else{
			return Math.acos(this.productoEscalar(vector2) / (this.norma() * vector2.norma() ));
		}
	}
	
	public VectorReales clone() {
		VectorReales aux = new VectorReales(this.vector.length);
		for (int i=0;i<this.vector.length;i++){
			aux.vector[i]= this.vector[i];
		}
		return aux;
	}


	public boolean equals(VectorReales vector2) {
		VectorReales aux=(VectorReales) vector2;
		if (aux==null ||this.vector.length != aux.vector.length ) return false;		
		for (int i=0;i<this.vector.length;i++) {
			if (this.vector[i]!=aux.vector[i])
				return false;
		}
		return true;
	}

	
}

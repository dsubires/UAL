
package org.mp.examentipoa2013;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Polinomio {
	
	private List<Termino> lista= new LinkedList<Termino>();
	
	public Polinomio() { 
		super();	
	}

	public Polinomio(double coef, int exp) {
			lista.add(new Termino(coef, exp));
	}

	public Polinomio(Polinomio p) { 
		for (Termino termino : p.lista) {
			this.lista.add(new Termino(termino));
		}
	}
	
	public Polinomio(double[] a){
		for(int i=0; i<a.length; i++){
			lista.add(new Termino(a[i],i+1));
		}
	}
	
	public int grado(){
		if(lista.size() > 0){
		return lista.size()-1;
		}else{
			return 0;
		}
	}
	
	public boolean isCero(){
		return lista.size() == 0;
	}
	
	public Polinomio suma(Polinomio p){
		Polinomio aux = new Polinomio();
		
		Iterator<Termino> iterador = lista.iterator();
		Iterator<Termino> iterador2 = p.lista.iterator();
		while(iterador.hasNext()){
			Termino t1 = iterador.next();
			while(iterador2.hasNext()){
				Termino t2 = iterador2.next();
				if(t1.getExp() == t2.getExp()){
					aux.lista.add(new Termino(t1.getCoef()+t2.getCoef(),t1.getExp()));
				}
			}
			
		}
		return aux;
	}
	
	
	public Polinomio resta(Polinomio p){
		Polinomio aux = new Polinomio();
		
		Iterator<Termino> iterador = lista.iterator();
		Iterator<Termino> iterador2 = p.lista.iterator();
		while(iterador.hasNext()){
			Termino t1 = iterador.next();
			while(iterador2.hasNext()){
				Termino t2 = iterador2.next();
				if(t1.getExp() == t2.getExp()){
					aux.lista.add(new Termino(t1.getCoef()-t2.getCoef(),t1.getExp()));
				}
			}
			
		}
		return aux;
	}

	public Polinomio multiplicacion(Double d){
		Polinomio p = new Polinomio();
		Iterator<Termino> iterador = lista.iterator();
		
		while(iterador.hasNext()){
			Termino t1 = iterador.next();
					p.lista.add(new Termino((t1.getCoef()*d),t1.getExp()));
			}
		
		return p;		
	}
	
	public Polinomio multiplicacion(Polinomio p){
		Polinomio aux = new Polinomio();
		
		Iterator<Termino> iterador = lista.iterator();
		Iterator<Termino> iterador2 = p.lista.iterator();
		while(iterador.hasNext()){
			Termino t1 = iterador.next();
			while(iterador2.hasNext()){
				Termino t2 = iterador2.next();
				if(t1.getExp() == t2.getExp()){
					aux.lista.add(new Termino(t1.getCoef()*t2.getCoef(), t1.getExp()+t2.getExp()));
				}
			}
			
		}
		return aux;		
	}
	
	public double evaluar(double x){
		double resultado = 0;
		int count = 0;
		
		Iterator<Termino> iterador = lista.iterator();
		
		while(iterador.hasNext()){
			Termino t = iterador.next();
			resultado += Math.pow(x, t.getExp())*t.getCoef() ;
		}
		
		
		return resultado;
	}
	
	public double[] getCoeficientes(){
		double[] aux = new double[lista.size()];
		
		for(int i=0; i<aux.length; i++){
			aux[i] = lista.get(i).getCoef();
		}
		
		return aux;
	}
	
	public String toString(){
		String aux = "";
		Iterator<Termino> iterador = lista.iterator();
		while(iterador.hasNext()){
			Termino t = iterador.next();
			aux += t.getCoef()+"^"+t.getExp()+"\n";
			}
		
		return aux;
	}
	
	public boolean equals(Object o){
		Polinomio p = (Polinomio) o;
		return this.equals(p);
	}
	
	
	
	
}

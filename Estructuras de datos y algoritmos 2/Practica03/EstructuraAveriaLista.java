package Practica03;

import java.util.ArrayList;

public class EstructuraAveriaLista  {
	private Averia desde;
	private ArrayList<Averia> conjunto;
	
	public EstructuraAveriaLista(Averia a, ArrayList<Averia> al){
		desde = a;
		conjunto = al;
	}
	
	public Averia getAveria(){
		return desde;
	}
	
	public ArrayList<Averia> getConjunto(){
		return conjunto;
	}

	
	
	public String toString(){
		return desde.toString()+ " "+ conjunto.toString();
	}
	
	@Override
	public boolean equals(Object o){
		EstructuraAveriaLista a = (EstructuraAveriaLista) o;
		if(!desde.equals(a.desde))
			return false;
		if(!conjunto.equals(a.conjunto))
			return false;
		
		return true;
	}
	
	 @Override
	    public int hashCode() {
	        return desde.hashCode() + conjunto.hashCode();
	    }
	 
	/*	@Override
		public int compareTo(Object obj) {
			EstructuraAveriaLista eal = (EstructuraAveriaLista) obj;
			
			if(desde.getNumInter() < eal.desde.getNumInter())
				return -1;
			if(desde.getNumInter() > eal.desde.getNumInter())
				return 1;
			if(conjunto.size() < eal.conjunto.size())
				return -1;
			if(conjunto.size() > eal.conjunto.size())
				return 1;
			if(conjunto.toString().hashCode() < eal.conjunto.hashCode())
				return -1;
			if(conjunto.toString().hashCode() > eal.conjunto.hashCode())
				return 1;
			
			return 0;
		}
*/


}

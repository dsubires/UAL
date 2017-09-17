package org.ip.prueba1;

public class UsoGirasol {
	
	public static void main(String[] args) {

		//Crear 4 girasoles
		Girasol girasol1,girasol2,girasol3,girasol4,sol;
		
		girasol1 = new Girasol(new Coordenadas(1,2));
		girasol2 = new Girasol(new Coordenadas(1,3));
		girasol3 = new Girasol(new Coordenadas(1,4));
		girasol4 = new Girasol(new Coordenadas(1,5));
		sol		 = new Girasol(new Coordenadas(1,8));
		
		//Posiciones de partida girasol1: (x=1,y=2); girasol2: (x=1,y=3);
		// girasol3: (x=1,y=4); girasol4: (x=1,y=5);
		//Posición sol (x=1, y=8)
		
				
		//Poner todos los girasoles en modo de seguimiento.
		
		
	   Girasol.setModo(true);
	   
	   do{
		
		   girasol1.giro(sol.getPosicionX());
		   girasol2.giro(sol.getPosicionX());
		   girasol3.giro(sol.getPosicionX());
		   girasol4.giro(sol.getPosicionX());
		   if(Math.random()*2 > 1){
			 Girasol.setModo(false);  
		   }else{
			   Girasol.setModo(true);
			   
		   }
		   if(Girasol.getModo()){
			   girasol1.setContLuz();
			   girasol2.setContLuz();
			   girasol3.setContLuz();
			   girasol4.setContLuz();
		   }
		 
		   System.out.println("Posición destino: "+sol.getPosicion());
			System.out.println("Nº horas de luz consumidas por girasol1= "+girasol1.getContLuz());
			System.out.println("Nº horas de luz consumidas por girasol2= "+girasol2.getContLuz());
			System.out.println("Nº horas de luz consumidas por girasol3= "+girasol3.getContLuz());
			System.out.println("Nº horas de luz consumidas por girasol4= "+girasol4.getContLuz());
			System.out.println("************************************************************************");
			sol.setPosicionX( (sol.getPosicionX()+ 1) );
		   
		   
	   } while(girasol1.getContLuz() < 20 || girasol2.getContLuz() < 20 || girasol3.getContLuz() < 20 || girasol4.getContLuz() < 20);
	   System.out.println("Todos los girasoles estan listos para recolectar");
	}

}

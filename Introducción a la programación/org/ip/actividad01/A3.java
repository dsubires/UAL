package org.ip.actividad01;

public class A3 {
	public static void main(String[] args) {
int a=5,b=3;
boolean uno,dos,tres;
uno = (1==a || (10>++a));
dos = 10<=2*5 && 3<4 || !(8<7) && 3*2<=4*2-1;
tres = a++/2<b && (a++/2>b || (a*2<b*4));
System.out.println("Para a y b de tipo entero, con a=5 y b=3:");
System.out.println("a. (1==a) || (10>++a) = "+uno);
System.out.println("b. 10<=2*5&&3<4||!(8<7)&&3*2<=4*2-1 = "+dos);
System.out.println("c. a++/2<b&&(a++/2>b||(a*2<b*4)) = "+tres);
	}

}

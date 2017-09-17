package org.ip.actividad01;

public class A2 {
	public static void main(String[] args) {
int a=2,b=4;
System.out.println("Para a y b de tipo entero, con a=2 y b=4:");
System.out.println("a. 10*10+15*10 = "+ (10*10+15*10));
System.out.println("b. 15/10*2+3/4*8 = "+ ((15/10)*2+3.0/4.0*8));
System.out.println("c. -a+5%b-a*a = "+ (-a+5%b-a*a));
System.out.println("d. 5+3%7*b*a-b%a = "+ (5+3%7*b*a-b%a));
System.out.println("e. a + (b++) = "+ (a+(b++)));
System.out.println("f. a + (++a) = "+ (a+(++a)));
final double PI = 3.1415927; //atención a la constante Math.PI
System.out.println("Valor de PI = " + PI);
System.out.println("Valor de PI = " + Math.PI);
	}

}

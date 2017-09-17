package org.ip.sesion06;


public class Bicicleta {
private int cadencia;
private int marcha;
private int velocidad;

//añadimos una variable de instancia para almacenar el ID
private int id;
//añadimos una variable de clase
private static int numeroBicicletas;

//Constructor 
public Bicicleta(int cadenciaInicio, int marchaInicio,int velocidadInicio) {
cadencia = cadenciaInicio;
marcha = marchaInicio;
velocidad = velocidadInicio;

//incrementamos el número de bicicletas y asignamos el id
id = ++numeroBicicletas;
}

//métodos de acceso
public void setCadencia(int nuevoValor) {
cadencia = nuevoValor;
}
public int getCadencia(){
return cadencia;
}
public void setMarcha(int nuevoValor) {
marcha = nuevoValor;
}
public int getMarcha(){
return marcha;
}
public int getVelocidad(){
return velocidad;
}
public void frenar(int decremento) {
velocidad -= decremento;
}
public void acelerar(int incremento) {
velocidad += incremento;
}
public int getId(){
return id;	
}
public static int getNumeroBicicletas(){
return numeroBicicletas;
}
}